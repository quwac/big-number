package dev.quwac.bignumber

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
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
