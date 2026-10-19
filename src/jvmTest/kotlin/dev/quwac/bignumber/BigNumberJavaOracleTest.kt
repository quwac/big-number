package dev.quwac.bignumber

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import java.math.BigDecimal as JavaBigDecimal
import java.math.BigInteger as JavaBigInteger
import java.math.MathContext as JavaMathContext
import java.math.RoundingMode as JavaRoundingMode

class BigNumberJavaOracleTest {
    @Test
    fun integerOperationsMatchJavaBigInteger() {
        val values = listOf(
            "0",
            "1",
            "-1",
            "999999999999999999999999999999999999",
            "-1234567890123456789012345678901234567890",
        )

        for (leftText in values) {
            for (rightText in values) {
                val left = BigInteger(leftText)
                val right = BigInteger(rightText)
                val javaLeft = JavaBigInteger(leftText)
                val javaRight = JavaBigInteger(rightText)
                assertEquals(javaLeft.add(javaRight).toString(), (left + right).toString())
                assertEquals(javaLeft.subtract(javaRight).toString(), (left - right).toString())
                assertEquals(javaLeft.multiply(javaRight).toString(), (left * right).toString())
                if (right != BigInteger.ZERO) {
                    assertEquals(javaLeft.divide(javaRight).toString(), (left / right).toString())
                    assertEquals(javaLeft.remainder(javaRight).toString(), (left % right).toString())
                }
            }
        }

        for (radix in 2..36) {
            val javaValue = JavaBigInteger("-123456789012345678901234567890")
            val text = javaValue.toString(radix)
            assertEquals(javaValue.toString(), BigInteger(text, radix).toString())
            assertEquals(text, BigInteger(javaValue.toString()).toString(radix))
        }
    }

    @Test
    fun deterministicIntegerSampleMatchesJavaBigInteger() {
        val random = Random(20261020)
        repeat(200) {
            val leftValue = random.nextLong()
            val rightValue = random.nextLong()
            val left = BigInteger.of(leftValue)
            val right = BigInteger.of(rightValue)
            val javaLeft = JavaBigInteger.valueOf(leftValue)
            val javaRight = JavaBigInteger.valueOf(rightValue)

            assertEquals(javaLeft.add(javaRight).toString(), (left + right).toString())
            assertEquals(javaLeft.subtract(javaRight).toString(), (left - right).toString())
            assertEquals(javaLeft.multiply(javaRight).toString(), (left * right).toString())
            assertEquals(javaLeft.gcd(javaRight).toString(), left.gcd(right).toString())
            assertEquals(javaLeft.longValueExact(), left.toLongExact())
            if (leftValue in Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong()) {
                assertEquals(javaLeft.intValueExact(), left.toIntExact())
            }
            if (rightValue != 0L) {
                assertEquals(javaLeft.divide(javaRight).toString(), (left / right).toString())
                assertEquals(javaLeft.remainder(javaRight).toString(), (left % right).toString())
            }
        }
    }

    @Test
    fun decimalRepresentationAndArithmeticMatchJavaBigDecimal() {
        val values = listOf("0", "0.00", "1", "1.0", "1.00", "-12.30", "1E+3", "1E-7", "1234567890.012300")
        for (text in values) assertDecimalMatches(JavaBigDecimal(text), BigDecimal(text))

        val pairs = listOf(
            "1.0" to "2.00",
            "-1234567890.125" to "0.875",
            "1000" to "0.01",
            "0.000" to "42.0",
        )
        for ((leftText, rightText) in pairs) {
            val left = BigDecimal(leftText)
            val right = BigDecimal(rightText)
            val javaLeft = JavaBigDecimal(leftText)
            val javaRight = JavaBigDecimal(rightText)
            assertDecimalMatches(javaLeft.add(javaRight), left + right)
            assertDecimalMatches(javaLeft.subtract(javaRight), left - right)
            assertDecimalMatches(javaLeft.multiply(javaRight), left * right)
            assertDecimalMatches(javaLeft.remainder(javaRight), left % right)
        }
    }

    @Test
    fun decimalScaleAndRoundingMatchJavaBigDecimal() {
        val values = listOf("2.345", "2.355", "-2.345", "-2.355", "9.99", "999", "0.0012345")
        for (value in values) {
            for (roundingMode in RoundingMode.entries) {
                val javaMode = JavaRoundingMode.valueOf(roundingMode.name)
                assertSameOutcome(
                    javaOperation = { JavaBigDecimal(value).setScale(2, javaMode) },
                    kotlinOperation = { BigDecimal(value).setScale(2, roundingMode) },
                )
                assertSameOutcome(
                    javaOperation = { JavaBigDecimal(value).round(JavaMathContext(2, javaMode)) },
                    kotlinOperation = { BigDecimal(value).round(MathContext(2, roundingMode)) },
                )
            }
        }
    }

    @Test
    fun decimalDivisionMatchesJavaBigDecimal() {
        val pairs = listOf("1" to "3", "2" to "4", "1.00" to "2", "999" to "1", "995" to "100")
        for ((leftText, rightText) in pairs) {
            for (roundingMode in RoundingMode.entries) {
                val javaMode = JavaRoundingMode.valueOf(roundingMode.name)
                assertSameOutcome(
                    javaOperation = { JavaBigDecimal(leftText).divide(JavaBigDecimal(rightText), 3, javaMode) },
                    kotlinOperation = { BigDecimal(leftText).divide(BigDecimal(rightText), 3, roundingMode) },
                )
                assertSameOutcome(
                    javaOperation = {
                        JavaBigDecimal(
                            leftText,
                        ).divide(JavaBigDecimal(rightText), JavaMathContext(3, javaMode))
                    },
                    kotlinOperation = {
                        BigDecimal(
                            leftText,
                        ).divide(BigDecimal(rightText), MathContext(3, roundingMode))
                    },
                )
            }
        }
    }

    @Test
    fun deterministicDecimalSampleMatchesJavaBigDecimal() {
        val random = Random(20261021)
        repeat(100) {
            val leftUnscaled = random.nextLong(-1_000_000_000L, 1_000_000_001L)
            var rightUnscaled = random.nextLong(-1_000_000_000L, 1_000_000_001L)
            if (rightUnscaled == 0L) rightUnscaled = 1L
            val leftScale = random.nextInt(-6, 7)
            val rightScale = random.nextInt(-6, 7)
            val left = BigDecimal(BigInteger.of(leftUnscaled), leftScale)
            val right = BigDecimal(BigInteger.of(rightUnscaled), rightScale)
            val javaLeft = JavaBigDecimal(JavaBigInteger.valueOf(leftUnscaled), leftScale)
            val javaRight = JavaBigDecimal(JavaBigInteger.valueOf(rightUnscaled), rightScale)

            assertDecimalMatches(javaLeft, left)
            assertDecimalMatches(javaRight, right)
            assertDecimalMatches(javaLeft.add(javaRight), left + right)
            assertDecimalMatches(javaLeft.subtract(javaRight), left - right)
            assertDecimalMatches(javaLeft.multiply(javaRight), left * right)
            assertDecimalMatches(javaLeft.remainder(javaRight), left % right)
            val javaDivision = javaLeft.divideAndRemainder(javaRight)
            val kotlinDivision = left.divideAndRemainder(right)
            assertDecimalMatches(javaDivision[0], kotlinDivision.first)
            assertDecimalMatches(javaDivision[1], kotlinDivision.second)
            assertDecimalMatches(javaLeft.movePointLeft(3), left.movePointLeft(3))
            assertDecimalMatches(javaLeft.movePointRight(3), left.movePointRight(3))
            assertDecimalMatches(javaLeft.scaleByPowerOfTen(3), left.scaleByPowerOfTen(3))
            assertDecimalMatches(javaLeft.stripTrailingZeros(), left.stripTrailingZeros())
            assertEquals(javaLeft.toBigInteger().toString(), left.toBigInteger().toString())
            assertEquals(javaLeft.compareTo(javaRight).normalizedSign(), left.compareTo(right).normalizedSign())

            for (roundingMode in RoundingMode.entries) {
                val javaMode = JavaRoundingMode.valueOf(roundingMode.name)
                val javaContext = JavaMathContext(6, javaMode)
                val kotlinContext = MathContext(6, roundingMode)
                assertSameOutcome(
                    javaOperation = { javaLeft.setScale(2, javaMode) },
                    kotlinOperation = { left.setScale(2, roundingMode) },
                )
                assertSameOutcome(
                    javaOperation = { javaLeft.add(javaRight, javaContext) },
                    kotlinOperation = { left.plus(right, kotlinContext) },
                )
                assertSameOutcome(
                    javaOperation = { javaLeft.subtract(javaRight, javaContext) },
                    kotlinOperation = { left.minus(right, kotlinContext) },
                )
                assertSameOutcome(
                    javaOperation = { javaLeft.multiply(javaRight, javaContext) },
                    kotlinOperation = { left.times(right, kotlinContext) },
                )
                assertSameOutcome(
                    javaOperation = { javaLeft.divide(javaRight, javaContext) },
                    kotlinOperation = { left.divide(right, kotlinContext) },
                )
            }
        }
    }
}

private fun assertSameOutcome(javaOperation: () -> JavaBigDecimal, kotlinOperation: () -> BigDecimal) {
    val javaResult = runCatching(javaOperation)
    val kotlinResult = runCatching(kotlinOperation)
    assertEquals(javaResult.isSuccess, kotlinResult.isSuccess)
    if (javaResult.isSuccess) {
        assertDecimalMatches(javaResult.getOrThrow(), kotlinResult.getOrThrow())
    } else {
        assertEquals(ArithmeticException::class, kotlinResult.exceptionOrNull()!!::class)
    }
}

private fun assertDecimalMatches(expected: JavaBigDecimal, actual: BigDecimal) {
    assertEquals(expected.toString(), actual.toString())
    assertEquals(expected.toPlainString(), actual.toPlainString())
    assertEquals(expected.toEngineeringString(), actual.toEngineeringString())
    assertEquals(expected.scale(), actual.scale)
    assertEquals(expected.precision(), actual.precision)
    assertEquals(expected.unscaledValue().toString(), actual.unscaledValue.toString())
}

private fun Int.normalizedSign(): Int = when {
    this < 0 -> -1
    this > 0 -> 1
    else -> 0
}
