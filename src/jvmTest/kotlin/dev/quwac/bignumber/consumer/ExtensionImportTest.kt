package dev.quwac.bignumber.consumer

import dev.quwac.bignumber.BigDecimal
import dev.quwac.bignumber.BigInteger
import dev.quwac.bignumber.toBigDecimal
import dev.quwac.bignumber.toBigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionImportTest {
    @Test
    fun stringExtensionsCanBeImportedFromAnotherPackageOnJvm() {
        val integer: BigInteger = "12345678901234567890".toBigInteger()
        val decimal: BigDecimal = "123.450".toBigDecimal()

        assertEquals("12345678901234567890", integer.toString())
        assertEquals("123.450", decimal.toString())
    }
}
