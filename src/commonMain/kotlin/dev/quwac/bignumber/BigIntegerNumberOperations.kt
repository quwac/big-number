@file:Suppress("TooManyFunctions")

package dev.quwac.bignumber

// Byte
/** Returns the sum of this value and [other]. */
operator fun Byte.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: Byte): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun Byte.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: Byte): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun Byte.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: Byte): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Byte.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: Byte): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Byte.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: Byte): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun Byte.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: Byte): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun Byte.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: Byte): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun Byte.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: Byte): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun Byte.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: Byte): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun Byte.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: Byte): BigInteger = this andNot other.toBigInteger()

// Short

/** Returns the sum of this value and [other]. */
operator fun Short.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: Short): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun Short.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: Short): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun Short.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: Short): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Short.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: Short): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Short.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: Short): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun Short.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: Short): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun Short.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: Short): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun Short.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: Short): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun Short.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: Short): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun Short.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: Short): BigInteger = this andNot other.toBigInteger()

// Int

/** Returns the sum of this value and [other]. */
operator fun Int.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: Int): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun Int.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: Int): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun Int.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: Int): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Int.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: Int): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Int.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: Int): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun Int.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: Int): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun Int.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: Int): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun Int.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: Int): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun Int.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: Int): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun Int.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: Int): BigInteger = this andNot other.toBigInteger()

// Long

/** Returns the sum of this value and [other]. */
operator fun Long.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: Long): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun Long.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: Long): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun Long.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: Long): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Long.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: Long): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Long.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: Long): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun Long.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: Long): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun Long.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: Long): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun Long.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: Long): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun Long.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: Long): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun Long.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: Long): BigInteger = this andNot other.toBigInteger()

// UByte

/** Returns the sum of this value and [other]. */
operator fun UByte.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: UByte): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun UByte.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: UByte): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun UByte.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: UByte): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UByte.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: UByte): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UByte.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: UByte): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun UByte.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: UByte): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun UByte.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: UByte): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun UByte.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: UByte): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun UByte.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: UByte): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun UByte.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: UByte): BigInteger = this andNot other.toBigInteger()

// UShort

/** Returns the sum of this value and [other]. */
operator fun UShort.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: UShort): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun UShort.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: UShort): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun UShort.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: UShort): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UShort.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: UShort): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UShort.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: UShort): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun UShort.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: UShort): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun UShort.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: UShort): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun UShort.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: UShort): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun UShort.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: UShort): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun UShort.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: UShort): BigInteger = this andNot other.toBigInteger()

// UInt

/** Returns the sum of this value and [other]. */
operator fun UInt.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: UInt): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun UInt.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: UInt): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun UInt.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: UInt): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UInt.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: UInt): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UInt.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: UInt): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun UInt.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: UInt): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun UInt.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: UInt): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun UInt.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: UInt): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun UInt.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: UInt): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun UInt.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: UInt): BigInteger = this andNot other.toBigInteger()

// ULong

/** Returns the sum of this value and [other]. */
operator fun ULong.plus(other: BigInteger): BigInteger = toBigInteger() + other

/** Returns the sum of this value and [other]. */
operator fun BigInteger.plus(other: ULong): BigInteger = this + other.toBigInteger()

/** Returns this value minus [other]. */
operator fun ULong.minus(other: BigInteger): BigInteger = toBigInteger() - other

/** Returns this value minus [other]. */
operator fun BigInteger.minus(other: ULong): BigInteger = this - other.toBigInteger()

/** Returns the product of this value and [other]. */
operator fun ULong.times(other: BigInteger): BigInteger = toBigInteger() * other

/** Returns the product of this value and [other]. */
operator fun BigInteger.times(other: ULong): BigInteger = this * other.toBigInteger()

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun ULong.div(other: BigInteger): BigInteger = toBigInteger() / other

/**
 * Divides this value by [other], rounding toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.div(other: ULong): BigInteger = this / other.toBigInteger()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun ULong.rem(other: BigInteger): BigInteger = toBigInteger() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigInteger.rem(other: ULong): BigInteger = this % other.toBigInteger()

/** Compares this value with [other] numerically. */
operator fun ULong.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigInteger.compareTo(other: ULong): Int = compareTo(other.toBigInteger())

/** Returns the bitwise AND of this value and [other]. */
infix fun ULong.and(other: BigInteger): BigInteger = toBigInteger() and other

/** Returns the bitwise AND of this value and [other]. */
infix fun BigInteger.and(other: ULong): BigInteger = this and other.toBigInteger()

/** Returns the bitwise OR of this value and [other]. */
infix fun ULong.or(other: BigInteger): BigInteger = toBigInteger() or other

/** Returns the bitwise OR of this value and [other]. */
infix fun BigInteger.or(other: ULong): BigInteger = this or other.toBigInteger()

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun ULong.xor(other: BigInteger): BigInteger = toBigInteger() xor other

/** Returns the bitwise exclusive OR of this value and [other]. */
infix fun BigInteger.xor(other: ULong): BigInteger = this xor other.toBigInteger()

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun ULong.andNot(other: BigInteger): BigInteger = toBigInteger() andNot other

/** Returns the bitwise AND of this value and the inverse of [other]. */
infix fun BigInteger.andNot(other: ULong): BigInteger = this andNot other.toBigInteger()

// Float

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.plus(other: BigInteger): BigDecimal = toBigDecimal() + BigDecimal(other)

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.plus(other: Float): BigDecimal = BigDecimal(this) + other.toBigDecimal()

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.minus(other: BigInteger): BigDecimal = toBigDecimal() - BigDecimal(other)

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.minus(other: Float): BigDecimal = BigDecimal(this) - other.toBigDecimal()

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.times(other: BigInteger): BigDecimal = toBigDecimal() * BigDecimal(other)

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.times(other: Float): BigDecimal = BigDecimal(this) * other.toBigDecimal()

/**
 * Returns the exact decimal quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.div(other: BigInteger): BigDecimal = toBigDecimal() / BigDecimal(other)

/**
 * Returns the exact decimal quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.div(other: Float): BigDecimal = BigDecimal(this) / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.rem(other: BigInteger): BigDecimal = toBigDecimal() % BigDecimal(other)

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.rem(other: Float): BigDecimal = BigDecimal(this) % other.toBigDecimal()

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.compareTo(other: BigInteger): Int = toBigDecimal().compareTo(BigDecimal(other))

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.compareTo(other: Float): Int = BigDecimal(this).compareTo(other.toBigDecimal())

// Double

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.plus(other: BigInteger): BigDecimal = toBigDecimal() + BigDecimal(other)

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.plus(other: Double): BigDecimal = BigDecimal(this) + other.toBigDecimal()

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.minus(other: BigInteger): BigDecimal = toBigDecimal() - BigDecimal(other)

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.minus(other: Double): BigDecimal = BigDecimal(this) - other.toBigDecimal()

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.times(other: BigInteger): BigDecimal = toBigDecimal() * BigDecimal(other)

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.times(other: Double): BigDecimal = BigDecimal(this) * other.toBigDecimal()

/**
 * Returns the exact decimal quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.div(other: BigInteger): BigDecimal = toBigDecimal() / BigDecimal(other)

/**
 * Returns the exact decimal quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.div(other: Double): BigDecimal = BigDecimal(this) / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.rem(other: BigInteger): BigDecimal = toBigDecimal() % BigDecimal(other)

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.rem(other: Double): BigDecimal = BigDecimal(this) % other.toBigDecimal()

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.compareTo(other: BigInteger): Int = toBigDecimal().compareTo(BigDecimal(other))

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigInteger.compareTo(other: Double): Int = BigDecimal(this).compareTo(other.toBigDecimal())
