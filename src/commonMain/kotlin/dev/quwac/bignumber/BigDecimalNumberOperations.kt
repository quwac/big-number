@file:Suppress("TooManyFunctions")

package dev.quwac.bignumber

// Byte
/** Returns the sum of this value and [other]. */
operator fun Byte.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: Byte): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun Byte.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: Byte): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun Byte.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: Byte): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun Byte.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: Byte): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Byte.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: Byte): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun Byte.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: Byte): Int = compareTo(other.toBigDecimal())

// Short

/** Returns the sum of this value and [other]. */
operator fun Short.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: Short): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun Short.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: Short): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun Short.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: Short): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun Short.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: Short): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Short.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: Short): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun Short.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: Short): Int = compareTo(other.toBigDecimal())

// Int

/** Returns the sum of this value and [other]. */
operator fun Int.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: Int): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun Int.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: Int): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun Int.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: Int): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun Int.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: Int): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Int.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: Int): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun Int.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: Int): Int = compareTo(other.toBigDecimal())

// Long

/** Returns the sum of this value and [other]. */
operator fun Long.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: Long): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun Long.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: Long): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun Long.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: Long): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun Long.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: Long): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun Long.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: Long): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun Long.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: Long): Int = compareTo(other.toBigDecimal())

// Float

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.plus(other: Float): BigDecimal = this + other.toBigDecimal()

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.minus(other: Float): BigDecimal = this - other.toBigDecimal()

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.times(other: Float): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.div(other: Float): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.rem(other: Float): BigDecimal = this % other.toBigDecimal()

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Float.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.compareTo(other: Float): Int = compareTo(other.toBigDecimal())

// Double

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/**
 * Returns the sum of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.plus(other: Double): BigDecimal = this + other.toBigDecimal()

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/**
 * Returns this value minus [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.minus(other: Double): BigDecimal = this - other.toBigDecimal()

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/**
 * Returns the product of this value and [other].
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.times(other: Double): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.div(other: Double): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.rem(other: Double): BigDecimal = this % other.toBigDecimal()

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun Double.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/**
 * Compares this value with [other] numerically.
 *
 * @throws IllegalArgumentException when the floating-point operand is not finite.
 */
operator fun BigDecimal.compareTo(other: Double): Int = compareTo(other.toBigDecimal())

// UByte

/** Returns the sum of this value and [other]. */
operator fun UByte.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: UByte): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun UByte.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: UByte): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun UByte.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: UByte): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun UByte.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: UByte): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UByte.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: UByte): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun UByte.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: UByte): Int = compareTo(other.toBigDecimal())

// UShort

/** Returns the sum of this value and [other]. */
operator fun UShort.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: UShort): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun UShort.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: UShort): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun UShort.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: UShort): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun UShort.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: UShort): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UShort.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: UShort): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun UShort.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: UShort): Int = compareTo(other.toBigDecimal())

// UInt

/** Returns the sum of this value and [other]. */
operator fun UInt.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: UInt): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun UInt.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: UInt): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun UInt.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: UInt): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun UInt.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: UInt): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun UInt.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: UInt): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun UInt.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: UInt): Int = compareTo(other.toBigDecimal())

// ULong

/** Returns the sum of this value and [other]. */
operator fun ULong.plus(other: BigDecimal): BigDecimal = toBigDecimal() + other

/** Returns the sum of this value and [other]. */
operator fun BigDecimal.plus(other: ULong): BigDecimal = this + other.toBigDecimal()

/** Returns this value minus [other]. */
operator fun ULong.minus(other: BigDecimal): BigDecimal = toBigDecimal() - other

/** Returns this value minus [other]. */
operator fun BigDecimal.minus(other: ULong): BigDecimal = this - other.toBigDecimal()

/** Returns the product of this value and [other]. */
operator fun ULong.times(other: BigDecimal): BigDecimal = toBigDecimal() * other

/** Returns the product of this value and [other]. */
operator fun BigDecimal.times(other: ULong): BigDecimal = this * other.toBigDecimal()

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun ULong.div(other: BigDecimal): BigDecimal = toBigDecimal() / other

/**
 * Returns the exact quotient of this value divided by [other].
 *
 * @throws ArithmeticException when [other] is zero or the quotient has a non-terminating decimal expansion.
 */
operator fun BigDecimal.div(other: ULong): BigDecimal = this / other.toBigDecimal()

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun ULong.rem(other: BigDecimal): BigDecimal = toBigDecimal() % other

/**
 * Returns the remainder after dividing this value by [other] toward zero.
 *
 * @throws ArithmeticException when [other] is zero.
 */
operator fun BigDecimal.rem(other: ULong): BigDecimal = this % other.toBigDecimal()

/** Compares this value with [other] numerically. */
operator fun ULong.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

/** Compares this value with [other] numerically. */
operator fun BigDecimal.compareTo(other: ULong): Int = compareTo(other.toBigDecimal())
