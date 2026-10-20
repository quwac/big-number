package dev.quwac.bignumber

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BigDecimalTest {
    @Test
    fun parsingPreservesScalePrecisionAndUnscaledValue() {
        val decimal = BigDecimal("+0012345678901234567890.12000")

        assertEquals("12345678901234567890.12000", decimal.toString())
        assertEquals(BigInteger.parse("1234567890123456789012000"), decimal.unscaledValue)
        assertEquals(5, decimal.scale)
        assertEquals(25, decimal.precision)
        assertEquals("0.00", BigDecimal("-0.00").toString())
        assertEquals(2, BigDecimal("-0.00").scale)
        assertEquals(0, BigDecimal("-0.00").signum)
        assertEquals("1.2E+3", BigDecimal("1.2e3").toString())
        assertEquals("0.001", BigDecimal("1E-3").toString())
    }

    @Test
    fun equalityIncludesScaleWhileComparisonDoesNot() {
        val oneWithOneZero = BigDecimal("1.0")
        val oneWithTwoZeros = BigDecimal("1.00")

        assertFalse(oneWithOneZero == oneWithTwoZeros)
        assertEquals(0, oneWithOneZero.compareTo(oneWithTwoZeros))
        assertEquals(oneWithOneZero, oneWithOneZero)
        assertFalse(oneWithOneZero.hashCode() == oneWithTwoZeros.hashCode())
        assertTrue(BigDecimal("100000000000000000000.01") > BigDecimal("99999999999999999999.99"))
        assertTrue(BigDecimal("-0.0002") < BigDecimal("-0.0001"))
    }

    @Test
    fun rejectsInvalidDecimalsAndOutOfRangeExponents() {
        for (value in listOf("", "+", "-", ".", "1.2.3", " 1", "1 ", "1e", "1e+", "١.0")) {
            assertNull(BigDecimal.parseOrNull(value))
            assertFailsWith<IllegalArgumentException> { BigDecimal.parse(value) }
        }
        assertNull(BigDecimal.parseOrNull("1e2147483648"))
        assertNull(BigDecimal.parseOrNull("1.0e2147483648"))
        assertEquals(Int.MIN_VALUE, BigDecimal(BigInteger.ONE, Int.MIN_VALUE).scale)
    }

    @Test
    fun arithmeticPreservesPreferredScales() {
        assertDecimal("3.00", 2, BigDecimal("1.0") + BigDecimal("2.00"))
        assertDecimal("-1.00", 2, BigDecimal("1.0") - BigDecimal("2.00"))
        assertDecimal("2.000", 3, BigDecimal("1.00") * BigDecimal("2.0"))
        assertDecimal("0.00", 2, BigDecimal("0.00") * BigDecimal.of(2))

        val left = BigDecimal("12345678901234567890.125")
        val right = BigDecimal("0.875")
        assertDecimal("12345678901234567891.000", 3, left + right)
        assertDecimal("12345678901234567889.250", 3, left - right)
        assertDecimal("10802469038580246903.859375", 6, left * right)
    }

    @Suppress("LongMethod") // The complete primitive/operator matrix belongs in one test.
    @Test
    fun interoperatesWithConcreteNumericTypesInBothOperandOrders() {
        val decimal = BigDecimal("2.50")
        val byteValue: Byte = 1.toByte()
        val shortValue: Short = 1.toShort()
        val intValue: Int = 1
        val longValue: Long = 1L
        val floatValue: Float = 1.0F
        val doubleValue: Double = 1.0
        val uByteValue: UByte = 1.toUByte()
        val uShortValue: UShort = 1.toUShort()
        val uIntValue: UInt = 1u
        val uLongValue: ULong = 1uL

        listOf(
            decimal + byteValue,
            byteValue + decimal,
            decimal + shortValue,
            shortValue + decimal,
            decimal + intValue,
            intValue + decimal,
            decimal + longValue,
            longValue + decimal,
            decimal + floatValue,
            floatValue + decimal,
            decimal + doubleValue,
            doubleValue + decimal,
            decimal + uByteValue,
            uByteValue + decimal,
            decimal + uShortValue,
            uShortValue + decimal,
            decimal + uIntValue,
            uIntValue + decimal,
            decimal + uLongValue,
            uLongValue + decimal,
        ).forEach { assertNumericallyEquals("3.5", it) }
        listOf(
            decimal - byteValue,
            decimal - shortValue,
            decimal - intValue,
            decimal - longValue,
            decimal - floatValue,
            decimal - doubleValue,
            decimal - uByteValue,
            decimal - uShortValue,
            decimal - uIntValue,
            decimal - uLongValue,
        ).forEach { assertNumericallyEquals("1.5", it) }
        listOf(
            byteValue - decimal,
            shortValue - decimal,
            intValue - decimal,
            longValue - decimal,
            floatValue - decimal,
            doubleValue - decimal,
            uByteValue - decimal,
            uShortValue - decimal,
            uIntValue - decimal,
            uLongValue - decimal,
        ).forEach { assertNumericallyEquals("-1.5", it) }
        listOf(
            decimal * byteValue,
            byteValue * decimal,
            decimal * shortValue,
            shortValue * decimal,
            decimal * intValue,
            intValue * decimal,
            decimal * longValue,
            longValue * decimal,
            decimal * floatValue,
            floatValue * decimal,
            decimal * doubleValue,
            doubleValue * decimal,
            decimal * uByteValue,
            uByteValue * decimal,
            decimal * uShortValue,
            uShortValue * decimal,
            decimal * uIntValue,
            uIntValue * decimal,
            decimal * uLongValue,
            uLongValue * decimal,
        ).forEach { assertNumericallyEquals("2.5", it) }
        listOf(
            decimal / byteValue,
            decimal / shortValue,
            decimal / intValue,
            decimal / longValue,
            decimal / floatValue,
            decimal / doubleValue,
            decimal / uByteValue,
            decimal / uShortValue,
            decimal / uIntValue,
            decimal / uLongValue,
        ).forEach { assertNumericallyEquals("2.5", it) }
        listOf(
            byteValue / decimal,
            shortValue / decimal,
            intValue / decimal,
            longValue / decimal,
            floatValue / decimal,
            doubleValue / decimal,
            uByteValue / decimal,
            uShortValue / decimal,
            uIntValue / decimal,
            uLongValue / decimal,
        ).forEach { assertNumericallyEquals("0.4", it) }
        listOf(
            decimal % byteValue,
            decimal % shortValue,
            decimal % intValue,
            decimal % longValue,
            decimal % floatValue,
            decimal % doubleValue,
            decimal % uByteValue,
            decimal % uShortValue,
            decimal % uIntValue,
            decimal % uLongValue,
        ).forEach { assertNumericallyEquals("0.5", it) }
        listOf(
            byteValue % decimal,
            shortValue % decimal,
            intValue % decimal,
            longValue % decimal,
            floatValue % decimal,
            doubleValue % decimal,
            uByteValue % decimal,
            uShortValue % decimal,
            uIntValue % decimal,
            uLongValue % decimal,
        ).forEach { assertNumericallyEquals("1", it) }
        assertTrue(
            listOf(
                (decimal > byteValue),
                (byteValue < decimal),
                (decimal > shortValue),
                (shortValue < decimal),
                (decimal > intValue),
                (intValue < decimal),
                (decimal > longValue),
                (longValue < decimal),
                (decimal > floatValue),
                (floatValue < decimal),
                (decimal > doubleValue),
                (doubleValue < decimal),
                (decimal > uByteValue),
                (uByteValue < decimal),
                (decimal > uShortValue),
                (uShortValue < decimal),
                (decimal > uIntValue),
                (uIntValue < decimal),
                (decimal > uLongValue),
                (uLongValue < decimal),
            ).all { it },
        )

        assertDecimal("5.50", 2, 3 + decimal)
        assertDecimal("0.25", 2, BigDecimal("0.5") * 0.5)
        assertEquals(BigDecimal("0.5"), 0.5.toBigDecimal())
        assertFailsWith<IllegalArgumentException> { Double.NaN.toBigDecimal() }
        assertFailsWith<IllegalArgumentException> { BigDecimal.ONE + Float.POSITIVE_INFINITY }
    }

    @Test
    fun exactDivisionUsesPreferredScaleAndRejectsNonTerminatingResults() {
        assertDecimal("0.125", 3, BigDecimal.ONE / BigDecimal.of(8))
        assertDecimal("0.50", 2, BigDecimal("1.00") / BigDecimal.of(2))
        assertDecimal("0.5", 1, BigDecimal.ONE / BigDecimal("2.00"))
        assertDecimal("5.0E+2", -1, BigDecimal.of(100) / BigDecimal("0.2"))
        assertDecimal("0.00", 2, BigDecimal("0.00") / BigDecimal.of(2))
        assertFailsWith<ArithmeticException> { BigDecimal.ONE / BigDecimal.of(3) }
        assertFailsWith<ArithmeticException> { BigDecimal.ONE / BigDecimal.ZERO }
    }

    @Test
    fun setScaleHonorsEveryRoundingMode() {
        assertDecimal("0.33", 2, BigDecimal.ONE.divide(BigDecimal.of(3), 2, RoundingMode.DOWN))
        assertDecimal("0.34", 2, BigDecimal.ONE.divide(BigDecimal.of(3), 2, RoundingMode.UP))
        assertDecimal("-0.33", 2, (-BigDecimal.ONE).divide(BigDecimal.of(3), 2, RoundingMode.CEILING))
        assertDecimal("-0.34", 2, (-BigDecimal.ONE).divide(BigDecimal.of(3), 2, RoundingMode.FLOOR))
        assertDecimal("2.34", 2, BigDecimal("2.345").setScale(2, RoundingMode.HALF_EVEN))
        assertDecimal("2.36", 2, BigDecimal("2.355").setScale(2, RoundingMode.HALF_EVEN))
        assertDecimal("2.35", 2, BigDecimal("2.345").setScale(2, RoundingMode.HALF_UP))
        assertDecimal("2.34", 2, BigDecimal("2.345").setScale(2, RoundingMode.HALF_DOWN))
        assertDecimal("1.000", 3, BigDecimal.ONE.setScale(3))
        assertDecimal("0.000", 3, BigDecimal.ZERO.setScale(3))
        assertFailsWith<ArithmeticException> { BigDecimal("1.01").setScale(1) }
        assertDecimal("1.0", 1, BigDecimal("1.00").setScale(1))
    }

    @Test
    fun mathContextRoundsSignificantDigitsAndDivision() {
        val halfEvenTwo = MathContext(2, RoundingMode.HALF_EVEN)

        assertDecimal("10", 0, BigDecimal("9.99").round(halfEvenTwo))
        assertDecimal("1.0E+3", -2, BigDecimal("999").round(halfEvenTwo))
        assertDecimal("2.4", 1, BigDecimal("2.355").round(halfEvenTwo))
        assertDecimal("0.0012", 4, BigDecimal("0.0012345").round(halfEvenTwo))
        assertDecimal("0.33", 2, BigDecimal.ONE.divide(BigDecimal.of(3), halfEvenTwo))
        assertDecimal("0.5", 1, BigDecimal.of(2).divide(BigDecimal.of(4), halfEvenTwo))
        assertDecimal("0.50", 2, BigDecimal("1.00").divide(BigDecimal.of(2), halfEvenTwo))
        assertFailsWith<ArithmeticException> {
            BigDecimal.ONE.divide(BigDecimal.of(3), MathContext(2, RoundingMode.UNNECESSARY))
        }
        assertEquals(0, MathContext.UNLIMITED.precision)
        assertEquals(RoundingMode.HALF_EVEN, MathContext.DECIMAL128.roundingMode)
        assertFailsWith<IllegalArgumentException> { MathContext(-1) }
    }

    @Test
    fun calculatesRemaindersAndIntegralQuotients() {
        val (quotient, remainder) = BigDecimal("5.00").divideAndRemainder(BigDecimal.of(2))
        assertDecimal("2.00", 2, quotient)
        assertDecimal("1.00", 2, remainder)
        assertDecimal("1.00", 2, BigDecimal.of(5) % BigDecimal("2.00"))
        assertDecimal("0.0", 1, BigDecimal("5.0").remainder(BigDecimal("0.2")))
        assertFailsWith<ArithmeticException> { BigDecimal.ONE.remainder(BigDecimal.ZERO) }
    }

    @Test
    fun movesDecimalPointAndStripsTrailingZeros() {
        assertDecimal("1.2345", 4, BigDecimal("123.45").movePointLeft(2))
        assertDecimal("12345", 0, BigDecimal("123.45").movePointRight(2))
        assertDecimal("0.100", 3, BigDecimal("0.00100").movePointRight(2))
        assertDecimal("10", 0, BigDecimal("1E+3").movePointLeft(2))
        assertDecimal("1E+1", -1, BigDecimal("1E+3").scaleByPowerOfTen(-2))
        assertDecimal("1E+3", -3, BigDecimal("1000.00").stripTrailingZeros())
        assertEquals(BigDecimal.ZERO, BigDecimal("0.000").stripTrailingZeros())
    }

    @Test
    fun formatsPlainCanonicalAndEngineeringStrings() {
        assertEquals("1000", BigDecimal("1E+3").toPlainString())
        assertEquals("1E+3", BigDecimal("1E+3").toString())
        assertEquals("12E+3", BigDecimal("12E+3").toEngineeringString())
        assertEquals("100E-9", BigDecimal("1E-7").toEngineeringString())
        assertEquals("0.0E-6", BigDecimal("0.0000000").toEngineeringString())
        assertEquals("0.00E+6", BigDecimal(BigInteger.ZERO, -4).toEngineeringString())
        assertEquals("0", BigDecimal(BigInteger.ZERO, -4).toPlainString())
    }

    @Test
    fun convertsToBigIntegerWithExplicitExactness() {
        assertEquals(BigInteger.of(123), BigDecimal("123.99").toBigInteger())
        assertEquals(BigInteger.of(-123), BigDecimal("-123.99").toBigInteger())
        assertEquals(BigInteger.of(123), BigDecimal("123.000").toBigIntegerExact())
        assertEquals(BigInteger.parse("12300"), BigDecimal("1.23E+4").toBigIntegerExact())
        assertFailsWith<ArithmeticException> { BigDecimal("123.001").toBigIntegerExact() }
    }

    @Test
    fun providesKotlinExtensionsAndConvenienceOperations() {
        assertEquals(BigDecimal.of(123), 123.toBigDecimal())
        assertEquals(BigDecimal("123.45"), "123.45".toBigDecimal())
        assertNull("not-a-number".toBigDecimalOrNull())
        assertEquals(BigDecimal("2.0"), BigDecimal("-2.0").abs())
        assertEquals(BigDecimal("-2.0"), BigDecimal("2.0").negate())
        assertEquals(BigDecimal("2.0"), BigDecimal("2.0").plus())
        assertEquals(BigDecimal("-2.0"), BigDecimal("-2.0").min(BigDecimal("3")))
        assertEquals(BigDecimal("3"), BigDecimal("-2.0").max(BigDecimal("3")))
    }
}

private fun assertDecimal(expectedText: String, expectedScale: Int, actual: BigDecimal) {
    assertEquals(expectedText, actual.toString())
    assertEquals(expectedScale, actual.scale)
}

private fun assertNumericallyEquals(expectedText: String, actual: BigDecimal) {
    assertEquals(0, BigDecimal(expectedText).compareTo(actual))
}
