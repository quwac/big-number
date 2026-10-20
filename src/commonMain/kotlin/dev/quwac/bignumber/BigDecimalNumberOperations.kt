@file:Suppress("TooManyFunctions")

package dev.quwac.bignumber

// Byte
operator fun Byte.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: Byte): BigDecimal = this + other.toBigDecimal()
operator fun Byte.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: Byte): BigDecimal = this - other.toBigDecimal()
operator fun Byte.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: Byte): BigDecimal = this * other.toBigDecimal()
operator fun Byte.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: Byte): BigDecimal = this / other.toBigDecimal()
operator fun Byte.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: Byte): BigDecimal = this % other.toBigDecimal()
operator fun Byte.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: Byte): Int = compareTo(other.toBigDecimal())

// Short
operator fun Short.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: Short): BigDecimal = this + other.toBigDecimal()
operator fun Short.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: Short): BigDecimal = this - other.toBigDecimal()
operator fun Short.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: Short): BigDecimal = this * other.toBigDecimal()
operator fun Short.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: Short): BigDecimal = this / other.toBigDecimal()
operator fun Short.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: Short): BigDecimal = this % other.toBigDecimal()
operator fun Short.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: Short): Int = compareTo(other.toBigDecimal())

// Int
operator fun Int.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: Int): BigDecimal = this + other.toBigDecimal()
operator fun Int.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: Int): BigDecimal = this - other.toBigDecimal()
operator fun Int.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: Int): BigDecimal = this * other.toBigDecimal()
operator fun Int.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: Int): BigDecimal = this / other.toBigDecimal()
operator fun Int.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: Int): BigDecimal = this % other.toBigDecimal()
operator fun Int.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: Int): Int = compareTo(other.toBigDecimal())

// Long
operator fun Long.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: Long): BigDecimal = this + other.toBigDecimal()
operator fun Long.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: Long): BigDecimal = this - other.toBigDecimal()
operator fun Long.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: Long): BigDecimal = this * other.toBigDecimal()
operator fun Long.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: Long): BigDecimal = this / other.toBigDecimal()
operator fun Long.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: Long): BigDecimal = this % other.toBigDecimal()
operator fun Long.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: Long): Int = compareTo(other.toBigDecimal())

// Float
operator fun Float.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: Float): BigDecimal = this + other.toBigDecimal()
operator fun Float.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: Float): BigDecimal = this - other.toBigDecimal()
operator fun Float.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: Float): BigDecimal = this * other.toBigDecimal()
operator fun Float.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: Float): BigDecimal = this / other.toBigDecimal()
operator fun Float.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: Float): BigDecimal = this % other.toBigDecimal()
operator fun Float.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: Float): Int = compareTo(other.toBigDecimal())

// Double
operator fun Double.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: Double): BigDecimal = this + other.toBigDecimal()
operator fun Double.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: Double): BigDecimal = this - other.toBigDecimal()
operator fun Double.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: Double): BigDecimal = this * other.toBigDecimal()
operator fun Double.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: Double): BigDecimal = this / other.toBigDecimal()
operator fun Double.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: Double): BigDecimal = this % other.toBigDecimal()
operator fun Double.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: Double): Int = compareTo(other.toBigDecimal())

// UByte
operator fun UByte.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: UByte): BigDecimal = this + other.toBigDecimal()
operator fun UByte.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: UByte): BigDecimal = this - other.toBigDecimal()
operator fun UByte.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: UByte): BigDecimal = this * other.toBigDecimal()
operator fun UByte.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: UByte): BigDecimal = this / other.toBigDecimal()
operator fun UByte.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: UByte): BigDecimal = this % other.toBigDecimal()
operator fun UByte.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: UByte): Int = compareTo(other.toBigDecimal())

// UShort
operator fun UShort.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: UShort): BigDecimal = this + other.toBigDecimal()
operator fun UShort.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: UShort): BigDecimal = this - other.toBigDecimal()
operator fun UShort.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: UShort): BigDecimal = this * other.toBigDecimal()
operator fun UShort.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: UShort): BigDecimal = this / other.toBigDecimal()
operator fun UShort.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: UShort): BigDecimal = this % other.toBigDecimal()
operator fun UShort.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: UShort): Int = compareTo(other.toBigDecimal())

// UInt
operator fun UInt.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: UInt): BigDecimal = this + other.toBigDecimal()
operator fun UInt.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: UInt): BigDecimal = this - other.toBigDecimal()
operator fun UInt.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: UInt): BigDecimal = this * other.toBigDecimal()
operator fun UInt.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: UInt): BigDecimal = this / other.toBigDecimal()
operator fun UInt.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: UInt): BigDecimal = this % other.toBigDecimal()
operator fun UInt.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: UInt): Int = compareTo(other.toBigDecimal())

// ULong
operator fun ULong.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other
operator fun BigDecimal.plus(other: ULong): BigDecimal = this + other.toBigDecimal()
operator fun ULong.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other
operator fun BigDecimal.minus(other: ULong): BigDecimal = this - other.toBigDecimal()
operator fun ULong.times(other: BigDecimal): BigDecimal = toBigDecimal() * other
operator fun BigDecimal.times(other: ULong): BigDecimal = this * other.toBigDecimal()
operator fun ULong.div(other: BigDecimal): BigDecimal = toBigDecimal() / other
operator fun BigDecimal.div(other: ULong): BigDecimal = this / other.toBigDecimal()
operator fun ULong.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other
operator fun BigDecimal.rem(other: ULong): BigDecimal = this % other.toBigDecimal()
operator fun ULong.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: ULong): Int = compareTo(other.toBigDecimal())
