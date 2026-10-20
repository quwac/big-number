@file:Suppress("TooManyFunctions")

package dev.quwac.bignumber

// Byte
operator fun Byte.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: Byte): BigInteger = this + other.toBigInteger()
operator fun Byte.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: Byte): BigInteger = this - other.toBigInteger()
operator fun Byte.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: Byte): BigInteger = this * other.toBigInteger()
operator fun Byte.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: Byte): BigInteger = this / other.toBigInteger()
operator fun Byte.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: Byte): BigInteger = this % other.toBigInteger()
operator fun Byte.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: Byte): Int = compareTo(other.toBigInteger())

// Short
operator fun Short.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: Short): BigInteger = this + other.toBigInteger()
operator fun Short.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: Short): BigInteger = this - other.toBigInteger()
operator fun Short.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: Short): BigInteger = this * other.toBigInteger()
operator fun Short.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: Short): BigInteger = this / other.toBigInteger()
operator fun Short.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: Short): BigInteger = this % other.toBigInteger()
operator fun Short.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: Short): Int = compareTo(other.toBigInteger())

// Int
operator fun Int.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: Int): BigInteger = this + other.toBigInteger()
operator fun Int.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: Int): BigInteger = this - other.toBigInteger()
operator fun Int.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: Int): BigInteger = this * other.toBigInteger()
operator fun Int.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: Int): BigInteger = this / other.toBigInteger()
operator fun Int.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: Int): BigInteger = this % other.toBigInteger()
operator fun Int.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: Int): Int = compareTo(other.toBigInteger())

// Long
operator fun Long.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: Long): BigInteger = this + other.toBigInteger()
operator fun Long.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: Long): BigInteger = this - other.toBigInteger()
operator fun Long.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: Long): BigInteger = this * other.toBigInteger()
operator fun Long.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: Long): BigInteger = this / other.toBigInteger()
operator fun Long.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: Long): BigInteger = this % other.toBigInteger()
operator fun Long.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: Long): Int = compareTo(other.toBigInteger())

// UByte
operator fun UByte.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: UByte): BigInteger = this + other.toBigInteger()
operator fun UByte.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: UByte): BigInteger = this - other.toBigInteger()
operator fun UByte.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: UByte): BigInteger = this * other.toBigInteger()
operator fun UByte.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: UByte): BigInteger = this / other.toBigInteger()
operator fun UByte.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: UByte): BigInteger = this % other.toBigInteger()
operator fun UByte.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: UByte): Int = compareTo(other.toBigInteger())

// UShort
operator fun UShort.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: UShort): BigInteger = this + other.toBigInteger()
operator fun UShort.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: UShort): BigInteger = this - other.toBigInteger()
operator fun UShort.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: UShort): BigInteger = this * other.toBigInteger()
operator fun UShort.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: UShort): BigInteger = this / other.toBigInteger()
operator fun UShort.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: UShort): BigInteger = this % other.toBigInteger()
operator fun UShort.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: UShort): Int = compareTo(other.toBigInteger())

// UInt
operator fun UInt.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: UInt): BigInteger = this + other.toBigInteger()
operator fun UInt.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: UInt): BigInteger = this - other.toBigInteger()
operator fun UInt.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: UInt): BigInteger = this * other.toBigInteger()
operator fun UInt.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: UInt): BigInteger = this / other.toBigInteger()
operator fun UInt.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: UInt): BigInteger = this % other.toBigInteger()
operator fun UInt.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: UInt): Int = compareTo(other.toBigInteger())

// ULong
operator fun ULong.plus(other: BigInteger): BigInteger = toBigInteger() + other
operator fun BigInteger.plus(other: ULong): BigInteger = this + other.toBigInteger()
operator fun ULong.minus(other: BigInteger): BigInteger = toBigInteger() - other
operator fun BigInteger.minus(other: ULong): BigInteger = this - other.toBigInteger()
operator fun ULong.times(other: BigInteger): BigInteger = toBigInteger() * other
operator fun BigInteger.times(other: ULong): BigInteger = this * other.toBigInteger()
operator fun ULong.div(other: BigInteger): BigInteger = toBigInteger() / other
operator fun BigInteger.div(other: ULong): BigInteger = this / other.toBigInteger()
operator fun ULong.rem(other: BigInteger): BigInteger = toBigInteger() % other
operator fun BigInteger.rem(other: ULong): BigInteger = this % other.toBigInteger()
operator fun ULong.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun BigInteger.compareTo(other: ULong): Int = compareTo(other.toBigInteger())

// Float
operator fun Float.plus(other: BigInteger): BigDecimal = toBigDecimal() + BigDecimal(other)
operator fun BigInteger.plus(other: Float): BigDecimal = BigDecimal(this) + other.toBigDecimal()
operator fun Float.minus(other: BigInteger): BigDecimal = toBigDecimal() - BigDecimal(other)
operator fun BigInteger.minus(other: Float): BigDecimal = BigDecimal(this) - other.toBigDecimal()
operator fun Float.times(other: BigInteger): BigDecimal = toBigDecimal() * BigDecimal(other)
operator fun BigInteger.times(other: Float): BigDecimal = BigDecimal(this) * other.toBigDecimal()
operator fun Float.div(other: BigInteger): BigDecimal = toBigDecimal() / BigDecimal(other)
operator fun BigInteger.div(other: Float): BigDecimal = BigDecimal(this) / other.toBigDecimal()
operator fun Float.rem(other: BigInteger): BigDecimal = toBigDecimal() % BigDecimal(other)
operator fun BigInteger.rem(other: Float): BigDecimal = BigDecimal(this) % other.toBigDecimal()
operator fun Float.compareTo(other: BigInteger): Int = toBigDecimal().compareTo(BigDecimal(other))
operator fun BigInteger.compareTo(other: Float): Int = BigDecimal(this).compareTo(other.toBigDecimal())

// Double
operator fun Double.plus(other: BigInteger): BigDecimal = toBigDecimal() + BigDecimal(other)
operator fun BigInteger.plus(other: Double): BigDecimal = BigDecimal(this) + other.toBigDecimal()
operator fun Double.minus(other: BigInteger): BigDecimal = toBigDecimal() - BigDecimal(other)
operator fun BigInteger.minus(other: Double): BigDecimal = BigDecimal(this) - other.toBigDecimal()
operator fun Double.times(other: BigInteger): BigDecimal = toBigDecimal() * BigDecimal(other)
operator fun BigInteger.times(other: Double): BigDecimal = BigDecimal(this) * other.toBigDecimal()
operator fun Double.div(other: BigInteger): BigDecimal = toBigDecimal() / BigDecimal(other)
operator fun BigInteger.div(other: Double): BigDecimal = BigDecimal(this) / other.toBigDecimal()
operator fun Double.rem(other: BigInteger): BigDecimal = toBigDecimal() % BigDecimal(other)
operator fun BigInteger.rem(other: Double): BigDecimal = BigDecimal(this) % other.toBigDecimal()
operator fun Double.compareTo(other: BigInteger): Int = toBigDecimal().compareTo(BigDecimal(other))
operator fun BigInteger.compareTo(other: Double): Int = BigDecimal(this).compareTo(other.toBigDecimal())
