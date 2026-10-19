@file:Suppress("TooManyFunctions")

package dev.quwac.bignumber

/** Returns this value as an arbitrary-precision integer. */
fun Byte.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun Short.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun Int.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun Long.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun UByte.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun UShort.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun UInt.toBigInteger(): BigInteger = BigInteger.of(this)

/** Returns this value as an arbitrary-precision integer. */
fun ULong.toBigInteger(): BigInteger = BigInteger.of(this)

/** Parses this string as an arbitrary-precision integer expressed in [radix]. */
fun String.toBigInteger(radix: Int = 10): BigInteger = BigInteger.parse(this, radix)

/** Returns an arbitrary-precision integer expressed in [radix], or null when this string is invalid. */
fun String.toBigIntegerOrNull(radix: Int = 10): BigInteger? = BigInteger.parseOrNull(this, radix)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun Byte.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun Short.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun Int.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun Long.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun UByte.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun UShort.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun UInt.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Returns this value as a scale-zero arbitrary-precision decimal. */
fun ULong.toBigDecimal(): BigDecimal = BigDecimal.of(this)

/** Parses this string as an arbitrary-precision decimal. */
fun String.toBigDecimal(): BigDecimal = BigDecimal.parse(this)

/** Returns an arbitrary-precision decimal, or null when this string is invalid. */
fun String.toBigDecimalOrNull(): BigDecimal? = BigDecimal.parseOrNull(this)
