package dev.quwac.bignumber.consumer

import dev.quwac.bignumber.BigDecimal
import dev.quwac.bignumber.BigInteger
import dev.quwac.bignumber.compareTo
import dev.quwac.bignumber.div
import dev.quwac.bignumber.minus
import dev.quwac.bignumber.plus
import dev.quwac.bignumber.rem
import dev.quwac.bignumber.times
import dev.quwac.bignumber.toBigDecimal
import dev.quwac.bignumber.toBigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ExtensionImportTest {
    @Test
    fun stringExtensionsCanBeImportedFromAnotherPackageOnJvm() {
        val integer: BigInteger = "12345678901234567890".toBigInteger()
        val decimal: BigDecimal = "123.450".toBigDecimal()

        assertEquals("12345678901234567890", integer.toString())
        assertEquals("123.450", decimal.toString())
    }

    @Test
    fun concreteNumericOperatorsCanBeImportedFromAnotherPackageOnJvm() {
        val decimal = BigDecimal("2.5")

        assertEquals(BigDecimal("6.5"), 4 + decimal)
        assertEquals(BigDecimal("1.5"), 4 - decimal)
        assertEquals(BigDecimal("10.0"), 4 * decimal)
        assertEquals(BigDecimal("1.6"), 4 / decimal)
        assertEquals(BigDecimal("1.5"), 4 % decimal)
        assertTrue(4 > decimal)
    }
}
