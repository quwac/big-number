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
infix fun Byte.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: Byte): BigInteger = this and other.toBigInteger()
infix fun Byte.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: Byte): BigInteger = this or other.toBigInteger()
infix fun Byte.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: Byte): BigInteger = this xor other.toBigInteger()
infix fun Byte.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: Byte): BigInteger = this andNot other.toBigInteger()

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
infix fun Short.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: Short): BigInteger = this and other.toBigInteger()
infix fun Short.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: Short): BigInteger = this or other.toBigInteger()
infix fun Short.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: Short): BigInteger = this xor other.toBigInteger()
infix fun Short.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: Short): BigInteger = this andNot other.toBigInteger()

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
infix fun Int.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: Int): BigInteger = this and other.toBigInteger()
infix fun Int.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: Int): BigInteger = this or other.toBigInteger()
infix fun Int.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: Int): BigInteger = this xor other.toBigInteger()
infix fun Int.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: Int): BigInteger = this andNot other.toBigInteger()

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
infix fun Long.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: Long): BigInteger = this and other.toBigInteger()
infix fun Long.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: Long): BigInteger = this or other.toBigInteger()
infix fun Long.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: Long): BigInteger = this xor other.toBigInteger()
infix fun Long.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: Long): BigInteger = this andNot other.toBigInteger()

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
infix fun UByte.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: UByte): BigInteger = this and other.toBigInteger()
infix fun UByte.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: UByte): BigInteger = this or other.toBigInteger()
infix fun UByte.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: UByte): BigInteger = this xor other.toBigInteger()
infix fun UByte.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: UByte): BigInteger = this andNot other.toBigInteger()

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
infix fun UShort.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: UShort): BigInteger = this and other.toBigInteger()
infix fun UShort.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: UShort): BigInteger = this or other.toBigInteger()
infix fun UShort.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: UShort): BigInteger = this xor other.toBigInteger()
infix fun UShort.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: UShort): BigInteger = this andNot other.toBigInteger()

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
infix fun UInt.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: UInt): BigInteger = this and other.toBigInteger()
infix fun UInt.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: UInt): BigInteger = this or other.toBigInteger()
infix fun UInt.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: UInt): BigInteger = this xor other.toBigInteger()
infix fun UInt.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: UInt): BigInteger = this andNot other.toBigInteger()

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
infix fun ULong.and(other: BigInteger): BigInteger = toBigInteger() and other
infix fun BigInteger.and(other: ULong): BigInteger = this and other.toBigInteger()
infix fun ULong.or(other: BigInteger): BigInteger = toBigInteger() or other
infix fun BigInteger.or(other: ULong): BigInteger = this or other.toBigInteger()
infix fun ULong.xor(other: BigInteger): BigInteger = toBigInteger() xor other
infix fun BigInteger.xor(other: ULong): BigInteger = this xor other.toBigInteger()
infix fun ULong.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other
infix fun BigInteger.andNot(other: ULong): BigInteger = this andNot other.toBigInteger()

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
