package dev.quwac.bignumber

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class BigIntegerTest {
    @Test
    fun parsesCanonicalValuesAndEliminatesNegativeZero() {
        val positive = BigInteger("+000123456789012345678901234567890")
        val negative = BigInteger("-999999999999999999999999999999999")

        assertEquals("123456789012345678901234567890", positive.toString())
        assertEquals("-999999999999999999999999999999999", negative.toString())
        assertSame(BigInteger.ZERO, BigInteger.parse("-000"))
        assertEquals(1, positive.signum)
        assertEquals(-1, negative.signum)
        assertEquals(0, BigInteger.ZERO.signum)
        assertSame(BigInteger.ZERO, -BigInteger.ZERO)
    }

    @Test
    fun parsesAndFormatsSupportedRadices() {
        assertEquals(BigInteger.of(255), BigInteger("ff", 16))
        assertEquals(BigInteger.of(-255), BigInteger.parse("-FF", 16))
        assertEquals(BigInteger.of(42), BigInteger.parse("101010", 2))
        assertEquals("zzzzzz", BigInteger.parse("2176782335").toString(36))
        assertEquals("-ff", BigInteger.of(-255).toString(16))
        assertEquals(BigInteger.of(255), "ff".toBigInteger(16))
        assertNull("fg".toBigIntegerOrNull(16))
        assertFailsWith<IllegalArgumentException> { BigInteger.parse("1", 1) }
        assertFailsWith<IllegalArgumentException> { BigInteger.ONE.toString(37) }
    }

    @Test
    fun rejectsInvalidIntegers() {
        for (value in listOf("", "+", "-", "1.0", " 1", "1 ", "1e2", "١")) {
            assertNull(BigInteger.parseOrNull(value))
            assertFailsWith<IllegalArgumentException> { BigInteger.parse(value) }
        }
    }

    @Test
    fun calculatesWithArbitraryPrecisionAndSignedDivision() {
        val left = BigInteger.parse("123456789012345678901234567890")
        val right = BigInteger.parse("98765432109876543210")

        assertEquals("123456789111111111011111111100", (left + right).toString())
        assertEquals("123456788913580246791358024680", (left - right).toString())
        assertEquals("12193263113702179522496570642237463801111263526900", (left * right).toString())
        assertEquals("1249999988", (left / right).toString())
        assertEquals("60185185207253086410", (left % right).toString())
        assertEquals("-2", (BigInteger.of(-7) / BigInteger.of(3)).toString())
        assertEquals("-1", (BigInteger.of(-7) % BigInteger.of(3)).toString())
        assertEquals("-2", (BigInteger.of(7) / BigInteger.of(-3)).toString())
        assertEquals("1", (BigInteger.of(7) % BigInteger.of(-3)).toString())
        assertFailsWith<ArithmeticException> { left / BigInteger.ZERO }
    }

    @Suppress("LongMethod") // The complete primitive/operator matrix belongs in one test.
    @Test
    fun interoperatesWithConcreteIntegralTypesInBothOperandOrders() {
        val integer = BigInteger.of(5)
        val byteValue: Byte = 2.toByte()
        val shortValue: Short = 2.toShort()
        val intValue: Int = 2
        val longValue: Long = 2L
        val uByteValue: UByte = 2.toUByte()
        val uShortValue: UShort = 2.toUShort()
        val uIntValue: UInt = 2u
        val uLongValue: ULong = 2uL

        assertIntegerResults(
            "7",
            listOf(
                integer + byteValue,
                byteValue + integer,
                integer + shortValue,
                shortValue + integer,
                integer + intValue,
                intValue + integer,
                integer + longValue,
                longValue + integer,
                integer + uByteValue,
                uByteValue + integer,
                integer + uShortValue,
                uShortValue + integer,
                integer + uIntValue,
                uIntValue + integer,
                integer + uLongValue,
                uLongValue + integer,
            ),
        )
        assertIntegerResults(
            "3",
            listOf(
                integer - byteValue,
                integer - shortValue,
                integer - intValue,
                integer - longValue,
                integer - uByteValue,
                integer - uShortValue,
                integer - uIntValue,
                integer - uLongValue,
            ),
        )
        assertIntegerResults(
            "-3",
            listOf(
                byteValue - integer,
                shortValue - integer,
                intValue - integer,
                longValue - integer,
                uByteValue - integer,
                uShortValue - integer,
                uIntValue - integer,
                uLongValue - integer,
            ),
        )
        assertIntegerResults(
            "10",
            listOf(
                integer * byteValue,
                byteValue * integer,
                integer * shortValue,
                shortValue * integer,
                integer * intValue,
                intValue * integer,
                integer * longValue,
                longValue * integer,
                integer * uByteValue,
                uByteValue * integer,
                integer * uShortValue,
                uShortValue * integer,
                integer * uIntValue,
                uIntValue * integer,
                integer * uLongValue,
                uLongValue * integer,
            ),
        )
        assertIntegerResults(
            "2",
            listOf(
                integer / byteValue,
                integer / shortValue,
                integer / intValue,
                integer / longValue,
                integer / uByteValue,
                integer / uShortValue,
                integer / uIntValue,
                integer / uLongValue,
            ),
        )
        assertIntegerResults(
            "0",
            listOf(
                byteValue / integer,
                shortValue / integer,
                intValue / integer,
                longValue / integer,
                uByteValue / integer,
                uShortValue / integer,
                uIntValue / integer,
                uLongValue / integer,
            ),
        )
        assertIntegerResults(
            "1",
            listOf(
                integer % byteValue,
                integer % shortValue,
                integer % intValue,
                integer % longValue,
                integer % uByteValue,
                integer % uShortValue,
                integer % uIntValue,
                integer % uLongValue,
            ),
        )
        assertIntegerResults(
            "2",
            listOf(
                byteValue % integer,
                shortValue % integer,
                intValue % integer,
                longValue % integer,
                uByteValue % integer,
                uShortValue % integer,
                uIntValue % integer,
                uLongValue % integer,
            ),
        )
        assertTrue(
            listOf(
                (integer > byteValue),
                (byteValue < integer),
                (integer > shortValue),
                (shortValue < integer),
                (integer > intValue),
                (intValue < integer),
                (integer > longValue),
                (longValue < integer),
                (integer > uByteValue),
                (uByteValue < integer),
                (integer > uShortValue),
                (uShortValue < integer),
                (integer > uIntValue),
                (uIntValue < integer),
                (integer > uLongValue),
                (uLongValue < integer),
            ).all { it },
        )
    }

    @Suppress("LongMethod") // Both floating-point types exercise every supported operator.
    @Test
    fun promotesFloatingPointOperandsToBigDecimal() {
        val integer = BigInteger.of(5)
        val floatValue = 2.0F
        val doubleValue = 2.0

        assertDecimalResults(
            "7",
            listOf(
                integer + floatValue,
                floatValue + integer,
                integer + doubleValue,
                doubleValue + integer,
            ),
        )
        assertDecimalResults(
            "3",
            listOf(
                integer - floatValue,
                integer - doubleValue,
            ),
        )
        assertDecimalResults(
            "-3",
            listOf(
                floatValue - integer,
                doubleValue - integer,
            ),
        )
        assertDecimalResults(
            "10",
            listOf(
                integer * floatValue,
                floatValue * integer,
                integer * doubleValue,
                doubleValue * integer,
            ),
        )
        assertDecimalResults(
            "2.5",
            listOf(
                integer / floatValue,
                integer / doubleValue,
            ),
        )
        assertDecimalResults(
            "0.4",
            listOf(
                floatValue / integer,
                doubleValue / integer,
            ),
        )
        assertDecimalResults(
            "1",
            listOf(
                integer % floatValue,
                integer % doubleValue,
            ),
        )
        assertDecimalResults(
            "2",
            listOf(
                floatValue % integer,
                doubleValue % integer,
            ),
        )
        assertTrue(
            listOf(
                (integer > floatValue),
                (floatValue < integer),
                (integer > doubleValue),
                (doubleValue < integer),
            ).all { it },
        )

        val promoted: BigDecimal = integer + 0.5
        assertDecimalResults("5.5", listOf(promoted))
        assertFailsWith<IllegalArgumentException> { integer + Double.POSITIVE_INFINITY }
    }

    @Test
    fun handlesCarryBorrowPowersAndGreatestCommonDivisors() {
        assertEquals(
            BigInteger.parse("100000000000000000000"),
            BigInteger.parse("99999999999999999999") + BigInteger.ONE,
        )
        assertEquals(
            BigInteger.parse("99999999999999999999"),
            BigInteger.parse("100000000000000000000") - BigInteger.ONE,
        )
        assertEquals(BigInteger.parse("1048576"), BigInteger.of(2).pow(20))
        assertEquals(BigInteger.ONE, BigInteger.ZERO.pow(0))
        assertEquals(BigInteger.ZERO, BigInteger.ZERO.pow(12))
        assertFailsWith<ArithmeticException> { BigInteger.TEN.pow(-1) }
        assertEquals(BigInteger.of(6), BigInteger.of(-54).gcd(BigInteger.of(24)))
        assertEquals(BigInteger.ZERO, BigInteger.ZERO.gcd(BigInteger.ZERO))
        assertEquals(BigInteger.of(-3), BigInteger.of(-3).min(BigInteger.of(5)))
        assertEquals(BigInteger.of(5), BigInteger.of(-3).max(BigInteger.of(5)))
    }

    @Test
    fun appliesBitwiseOperationsWithInfiniteSignExtension() {
        val five = BigInteger.of(5)
        val negativeOne = BigInteger.of(-1)

        assertEquals(five, negativeOne and five)
        assertEquals(BigInteger.of(-5), BigInteger.of(-5) or BigInteger.of(2))
        assertEquals(BigInteger.of(-8), BigInteger.of(-5) xor BigInteger.of(3))
        assertEquals(BigInteger.of(-6), five.inv())
        assertEquals(BigInteger.of(-6), five.not())
        assertEquals(BigInteger.of(4), five andNot BigInteger.ONE)

        assertEquals(BigInteger.of(-40), BigInteger.of(-5) shl 3)
        assertEquals(BigInteger.of(-3), BigInteger.of(-5) shr 1)
        assertEquals(BigInteger.of(2), BigInteger.of(8) shl -2)
        assertEquals(BigInteger.of(16), BigInteger.of(8) shr -1)
        assertEquals(negativeOne, negativeOne shr 10_000)
    }

    @Suppress("LongMethod") // The complete primitive/bitwise matrix belongs in one test.
    @Test
    fun interoperatesWithConcreteIntegralTypesForBitwiseOperations() {
        val integer = BigInteger.of(5)
        val byteValue: Byte = 3
        val shortValue: Short = 3
        val intValue: Int = 3
        val longValue: Long = 3
        val uByteValue: UByte = 3u
        val uShortValue: UShort = 3u
        val uIntValue: UInt = 3u
        val uLongValue: ULong = 3u

        assertIntegerResults(
            "1",
            listOf(
                integer and byteValue,
                byteValue and integer,
                integer and shortValue,
                shortValue and integer,
                integer and intValue,
                intValue and integer,
                integer and longValue,
                longValue and integer,
                integer and uByteValue,
                uByteValue and integer,
                integer and uShortValue,
                uShortValue and integer,
                integer and uIntValue,
                uIntValue and integer,
                integer and uLongValue,
                uLongValue and integer,
            ),
        )
        assertIntegerResults(
            "7",
            listOf(
                integer or byteValue,
                byteValue or integer,
                integer or shortValue,
                shortValue or integer,
                integer or intValue,
                intValue or integer,
                integer or longValue,
                longValue or integer,
                integer or uByteValue,
                uByteValue or integer,
                integer or uShortValue,
                uShortValue or integer,
                integer or uIntValue,
                uIntValue or integer,
                integer or uLongValue,
                uLongValue or integer,
            ),
        )
        assertIntegerResults(
            "6",
            listOf(
                integer xor byteValue,
                byteValue xor integer,
                integer xor shortValue,
                shortValue xor integer,
                integer xor intValue,
                intValue xor integer,
                integer xor longValue,
                longValue xor integer,
                integer xor uByteValue,
                uByteValue xor integer,
                integer xor uShortValue,
                uShortValue xor integer,
                integer xor uIntValue,
                uIntValue xor integer,
                integer xor uLongValue,
                uLongValue xor integer,
            ),
        )
        assertIntegerResults(
            "4",
            listOf(
                integer andNot byteValue,
                integer andNot shortValue,
                integer andNot intValue,
                integer andNot longValue,
                integer andNot uByteValue,
                integer andNot uShortValue,
                integer andNot uIntValue,
                integer andNot uLongValue,
            ),
        )
        assertIntegerResults(
            "2",
            listOf(
                byteValue andNot integer,
                shortValue andNot integer,
                intValue andNot integer,
                longValue andNot integer,
                uByteValue andNot integer,
                uShortValue andNot integer,
                uIntValue andNot integer,
                uLongValue andNot integer,
            ),
        )
    }

    @Test
    fun inspectsAndChangesIndividualBits() {
        val five = BigInteger.of(5)

        assertTrue(five.testBit(0))
        assertFalse(five.testBit(1))
        assertTrue(BigInteger.of(-1).testBit(10_000))
        assertEquals(BigInteger.of(7), five.setBit(1))
        assertEquals(BigInteger.ONE, five.clearBit(2))
        assertEquals(BigInteger.of(4), five.flipBit(0))
        assertEquals(BigInteger.of(-3), BigInteger.of(-1).clearBit(1))
        assertEquals(BigInteger.of(-2), BigInteger.of(-1).flipBit(0))

        assertEquals(0, BigInteger.ZERO.bitLength())
        assertEquals(3, five.bitLength())
        assertEquals(0, BigInteger.of(-1).bitLength())
        assertEquals(3, BigInteger.of(-5).bitLength())
        assertEquals(2, five.bitCount())
        assertEquals(1, BigInteger.of(-5).bitCount())
        assertEquals(-1, BigInteger.ZERO.lowestSetBit())
        assertEquals(2, BigInteger.of(-12).lowestSetBit())

        assertFailsWith<ArithmeticException> { five.testBit(-1) }
        assertFailsWith<ArithmeticException> { five.setBit(-1) }
        assertFailsWith<ArithmeticException> { five.clearBit(-1) }
        assertFailsWith<ArithmeticException> { five.flipBit(-1) }
    }

    @Test
    fun convertsToPrimitiveIntegersWithExplicitOverflowSemantics() {
        assertEquals(-1, BigInteger.parse("4294967295").toInt())
        assertEquals(UInt.MAX_VALUE, BigInteger.parse("4294967295").toUInt())
        assertEquals(1L, BigInteger.parse("18446744073709551617").toLong())
        assertEquals(ULong.MAX_VALUE, BigInteger.of(-1).toULong())
        assertEquals(Int.MIN_VALUE, BigInteger.of(Int.MIN_VALUE).toIntExact())
        assertEquals(Long.MAX_VALUE, BigInteger.of(Long.MAX_VALUE).toLongExact())
        assertEquals(ULong.MAX_VALUE, BigInteger.of(ULong.MAX_VALUE).toULongExact())
        assertFailsWith<ArithmeticException> { BigInteger.parse("2147483648").toIntExact() }
        assertFailsWith<ArithmeticException> { BigInteger.of(-1).toUIntExact() }
        assertFailsWith<ArithmeticException> { BigInteger.parse("18446744073709551616").toULongExact() }
    }

    @Test
    fun providesKotlinPrimitiveExtensions() {
        assertEquals(BigInteger.of(123), 123.toBigInteger())
        assertEquals(BigInteger.of(Long.MIN_VALUE), Long.MIN_VALUE.toBigInteger())
        assertEquals(BigInteger.of(ULong.MAX_VALUE), ULong.MAX_VALUE.toBigInteger())
        assertEquals(BigInteger.parse("12345678901234567890"), "12345678901234567890".toBigInteger())
    }

    @Test
    fun arithmeticMatchesBuiltInValuesWithinTheirRange() {
        for (left in -100..100) {
            for (right in -20..20) {
                val bigLeft = BigInteger.of(left)
                val bigRight = BigInteger.of(right)
                assertEquals((left + right).toString(), (bigLeft + bigRight).toString())
                assertEquals((left - right).toString(), (bigLeft - bigRight).toString())
                assertEquals((left * right).toString(), (bigLeft * bigRight).toString())
                if (right != 0) {
                    assertEquals((left / right).toString(), (bigLeft / bigRight).toString())
                    assertEquals((left % right).toString(), (bigLeft % bigRight).toString())
                }
            }
        }
        assertTrue(BigInteger.parse("123456789012345678901234567890") > BigInteger.of(Long.MAX_VALUE))
    }
}

private fun assertIntegerResults(expectedText: String, actuals: List<BigInteger>) {
    val expected = BigInteger(expectedText)
    actuals.forEach { assertEquals(expected, it) }
}

private fun assertDecimalResults(expectedText: String, actuals: List<BigDecimal>) {
    val expected = BigDecimal(expectedText)
    actuals.forEach { assertEquals(0, expected.compareTo(it)) }
}
