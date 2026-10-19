package dev.quwac.bignumber

/**
 * An immutable arbitrary-precision integer implemented entirely in common Kotlin.
 *
 * The concrete magnitude representation is deliberately not part of the public API.
 */
@Suppress("TooManyFunctions") // Conventional numeric operations belong on the value type.
class BigInteger private constructor(
    /** Returns -1, 0, or 1 according to the sign of this value. */
    val signum: Int,
    internal val magnitude: String,
) : Comparable<BigInteger> {
    private constructor(value: BigInteger) : this(value.signum, value.magnitude)

    /** Creates a base-10 integer from [value]. */
    constructor(value: String) : this(parse(value))

    /** Creates an integer from [value] expressed in [radix]. */
    constructor(value: String, radix: Int) : this(parse(value, radix))

    /** Compatibility alias for [signum]. */
    val sign: Int get() = signum

    /** Returns true when this value is zero. */
    val isZero: Boolean get() = signum == 0

    override fun compareTo(other: BigInteger): Int {
        if (signum != other.signum) return signum.compareTo(other.signum)
        if (signum == 0) return 0
        val magnitudeComparison = compareMagnitude(magnitude, other.magnitude)
        return if (signum > 0) magnitudeComparison else -magnitudeComparison
    }

    operator fun unaryPlus(): BigInteger = this

    operator fun unaryMinus(): BigInteger = when (signum) {
        0 -> this
        else -> BigInteger(-signum, magnitude)
    }

    operator fun plus(other: BigInteger): BigInteger {
        if (isZero) return other
        if (other.isZero) return this
        if (signum == other.signum) return fromMagnitude(signum, addMagnitude(magnitude, other.magnitude))

        val comparison = compareMagnitude(magnitude, other.magnitude)
        return when {
            comparison == 0 -> ZERO
            comparison > 0 -> fromMagnitude(signum, subtractMagnitude(magnitude, other.magnitude))
            else -> fromMagnitude(other.signum, subtractMagnitude(other.magnitude, magnitude))
        }
    }

    operator fun minus(other: BigInteger): BigInteger = this + -other

    operator fun times(other: BigInteger): BigInteger {
        if (isZero || other.isZero) return ZERO
        return fromMagnitude(signum * other.signum, multiplyMagnitude(magnitude, other.magnitude))
    }

    /** Divides toward zero. */
    operator fun div(other: BigInteger): BigInteger = divideAndRemainder(other).first

    /** Returns a remainder with this value's sign. */
    operator fun rem(other: BigInteger): BigInteger = divideAndRemainder(other).second

    /**
     * Divides toward zero and returns the quotient and remainder.
     *
     * @throws ArithmeticException when [other] is zero.
     */
    fun divideAndRemainder(other: BigInteger): Pair<BigInteger, BigInteger> {
        if (other.isZero) throw ArithmeticException("Division by zero")
        if (isZero) return ZERO to ZERO
        val (quotient, remainder) = divideMagnitude(magnitude, other.magnitude)
        return fromMagnitude(signum * other.signum, quotient) to fromMagnitude(signum, remainder)
    }

    /** Returns the absolute value. */
    fun abs(): BigInteger = if (signum < 0) -this else this

    /** Returns the additive inverse. */
    fun negate(): BigInteger = -this

    /**
     * Returns this value raised to [exponent].
     *
     * Zero to the power zero is one, matching `java.math.BigInteger`.
     *
     * @throws ArithmeticException when [exponent] is negative.
     */
    fun pow(exponent: Int): BigInteger {
        if (exponent < 0) throw ArithmeticException("Negative exponent")
        var result = ONE
        var factor = this
        var remaining = exponent
        while (remaining > 0) {
            if (remaining % 2 != 0) result *= factor
            remaining /= 2
            if (remaining != 0) factor *= factor
        }
        return result
    }

    /** Returns the non-negative greatest common divisor of this value and [other]. */
    fun gcd(other: BigInteger): BigInteger {
        var first = abs()
        var second = other.abs()
        while (!second.isZero) {
            val remainder = first % second
            first = second
            second = remainder
        }
        return first
    }

    /** Returns the smaller of this value and [other]. */
    fun min(other: BigInteger): BigInteger = if (this <= other) this else other

    /** Returns the larger of this value and [other]. */
    fun max(other: BigInteger): BigInteger = if (this >= other) this else other

    /** Returns the low eight bits as a signed [Byte]. */
    fun toByte(): Byte = toInt().toByte()

    /** Returns the low sixteen bits as a signed [Short]. */
    fun toShort(): Short = toInt().toShort()

    /** Returns the low 32 bits as a signed [Int]. */
    fun toInt(): Int = lowUInt().toInt()

    /** Returns the low 64 bits as a signed [Long]. */
    fun toLong(): Long = lowULong().toLong()

    /** Returns the low eight bits as an unsigned [UByte]. */
    fun toUByte(): UByte = toUInt().toUByte()

    /** Returns the low sixteen bits as an unsigned [UShort]. */
    fun toUShort(): UShort = toUInt().toUShort()

    /** Returns the low 32 bits as an unsigned [UInt]. */
    fun toUInt(): UInt = lowUInt()

    /** Returns the low 64 bits as an unsigned [ULong]. */
    fun toULong(): ULong = lowULong()

    /** @throws ArithmeticException when this value does not fit in a [Byte]. */
    fun toByteExact(): Byte = requireSignedRange(BYTE_MIN, BYTE_MAX, "Byte").toString().toByte()

    /** @throws ArithmeticException when this value does not fit in a [Short]. */
    fun toShortExact(): Short = requireSignedRange(SHORT_MIN, SHORT_MAX, "Short").toString().toShort()

    /** @throws ArithmeticException when this value does not fit in an [Int]. */
    fun toIntExact(): Int = requireSignedRange(INT_MIN, INT_MAX, "Int").toString().toInt()

    /** @throws ArithmeticException when this value does not fit in a [Long]. */
    fun toLongExact(): Long = requireSignedRange(LONG_MIN, LONG_MAX, "Long").toString().toLong()

    /** @throws ArithmeticException when this value does not fit in a [UByte]. */
    fun toUByteExact(): UByte = requireUnsignedRange(UBYTE_MAX, "UByte").toString().toUByte()

    /** @throws ArithmeticException when this value does not fit in a [UShort]. */
    fun toUShortExact(): UShort = requireUnsignedRange(USHORT_MAX, "UShort").toString().toUShort()

    /** @throws ArithmeticException when this value does not fit in a [UInt]. */
    fun toUIntExact(): UInt = requireUnsignedRange(UINT_MAX, "UInt").toString().toUInt()

    /** @throws ArithmeticException when this value does not fit in a [ULong]. */
    fun toULongExact(): ULong = requireUnsignedRange(ULONG_MAX, "ULong").toString().toULong()

    /** Returns a lowercase string representation in [radix]. */
    @Suppress("ReturnCount")
    fun toString(radix: Int): String {
        requireRadix(radix)
        if (isZero) return "0"
        if (radix == DECIMAL_RADIX) return toString()

        val divisor = radix.toString()
        val result = StringBuilder(magnitude.length)
        var remaining = magnitude
        while (remaining != "0") {
            val (quotient, remainder) = divideMagnitude(remaining, divisor)
            result.append(DIGITS[remainder.toInt()])
            remaining = quotient
        }
        if (signum < 0) result.append('-')
        return result.reverse().toString()
    }

    internal fun timesPowerOfTen(power: Int): BigInteger {
        require(power >= 0)
        return if (isZero || power == 0) this else fromMagnitude(signum, magnitude + "0".repeat(power))
    }

    internal val isOdd: Boolean get() = magnitude.last().digitToInt() % 2 != 0

    override fun equals(other: Any?): Boolean =
        other is BigInteger && signum == other.signum && magnitude == other.magnitude

    override fun hashCode(): Int = 31 * signum + magnitude.hashCode()

    override fun toString(): String = if (signum < 0) "-$magnitude" else magnitude

    private fun lowUInt(): UInt {
        var result = 0u
        for (digit in magnitude) result = result * DECIMAL_RADIX.toUInt() + digit.digitToInt().toUInt()
        return if (signum < 0) 0u - result else result
    }

    private fun lowULong(): ULong {
        var result = 0uL
        for (digit in magnitude) result = result * DECIMAL_RADIX.toULong() + digit.digitToInt().toULong()
        return if (signum < 0) 0uL - result else result
    }

    private fun requireSignedRange(minimum: BigInteger, maximum: BigInteger, target: String): BigInteger {
        if (this < minimum || this > maximum) throw ArithmeticException("BigInteger out of $target range")
        return this
    }

    private fun requireUnsignedRange(maximum: BigInteger, target: String): BigInteger {
        if (signum < 0 || this > maximum) throw ArithmeticException("BigInteger out of $target range")
        return this
    }

    companion object {
        val ZERO: BigInteger = BigInteger(0, "0")
        val ONE: BigInteger = BigInteger(1, "1")
        val TEN: BigInteger = BigInteger(1, "10")

        private val BYTE_MIN = decimal(Byte.MIN_VALUE.toString())
        private val BYTE_MAX = decimal(Byte.MAX_VALUE.toString())
        private val SHORT_MIN = decimal(Short.MIN_VALUE.toString())
        private val SHORT_MAX = decimal(Short.MAX_VALUE.toString())
        private val INT_MIN = decimal(Int.MIN_VALUE.toString())
        private val INT_MAX = decimal(Int.MAX_VALUE.toString())
        private val LONG_MIN = decimal(Long.MIN_VALUE.toString())
        private val LONG_MAX = decimal(Long.MAX_VALUE.toString())
        private val UBYTE_MAX = decimal(UByte.MAX_VALUE.toString())
        private val USHORT_MAX = decimal(UShort.MAX_VALUE.toString())
        private val UINT_MAX = decimal(UInt.MAX_VALUE.toString())
        private val ULONG_MAX = decimal(ULong.MAX_VALUE.toString())

        fun of(value: Byte): BigInteger = decimal(value.toString())

        fun of(value: Short): BigInteger = decimal(value.toString())

        fun of(value: Int): BigInteger = decimal(value.toString())

        fun of(value: Long): BigInteger = decimal(value.toString())

        fun of(value: UByte): BigInteger = decimal(value.toString())

        fun of(value: UShort): BigInteger = decimal(value.toString())

        fun of(value: UInt): BigInteger = decimal(value.toString())

        fun of(value: ULong): BigInteger = decimal(value.toString())

        /** Parses a base-10 integer. */
        fun parse(value: String): BigInteger = parse(value, DECIMAL_RADIX)

        /**
         * Parses an integer expressed in [radix].
         *
         * @throws IllegalArgumentException when [radix] is outside 2..36 or [value] is invalid.
         */
        fun parse(value: String, radix: Int): BigInteger =
            parseOrNull(value, radix) ?: throw IllegalArgumentException("Invalid BigInteger: $value")

        /** Returns a base-10 integer, or null when [value] is invalid. */
        fun parseOrNull(value: String): BigInteger? = parseOrNull(value, DECIMAL_RADIX)

        /**
         * Returns an integer expressed in [radix], or null when [value] is invalid.
         *
         * @throws IllegalArgumentException when [radix] is outside 2..36.
         */
        @Suppress("ReturnCount")
        fun parseOrNull(value: String, radix: Int): BigInteger? {
            requireRadix(radix)
            if (value.isEmpty()) return null
            val digitStart: Int
            val signum = when (value.first()) {
                '-' -> {
                    digitStart = 1
                    -1
                }

                '+' -> {
                    digitStart = 1
                    1
                }

                else -> {
                    digitStart = 0
                    1
                }
            }
            val digits = value.substring(digitStart)
            if (digits.isEmpty()) return null
            if (radix == DECIMAL_RADIX) return decimalOrNull(signum, digits)

            var converted = "0"
            for (character in digits) {
                val digit = character.digitValue()
                if (digit !in 0 until radix) return null
                converted = addMagnitude(multiplyMagnitude(converted, radix.toString()), digit.toString())
            }
            return fromMagnitude(signum, converted)
        }

        internal fun fromMagnitude(signum: Int, magnitude: String): BigInteger {
            val normalized = magnitude.trimStart('0')
            if (normalized.isEmpty()) return ZERO
            require(signum == -1 || signum == 1)
            require(normalized.all { it in '0'..'9' })
            return BigInteger(signum, normalized)
        }

        private fun decimal(value: String): BigInteger =
            decimalOrNull(if (value.startsWith('-')) -1 else 1, value.removePrefix("-").removePrefix("+"))
                ?: error("Invalid internal decimal value")

        private fun decimalOrNull(signum: Int, digits: String): BigInteger? {
            if (digits.any { it !in '0'..'9' }) return null
            return fromMagnitude(signum, digits)
        }
    }
}

private fun compareMagnitude(left: String, right: String): Int {
    val lengthComparison = left.length.compareTo(right.length)
    if (lengthComparison != 0) return lengthComparison
    return left.compareTo(right)
}

private fun addMagnitude(left: String, right: String): String {
    val result = StringBuilder(maxOf(left.length, right.length) + 1)
    var leftIndex = left.lastIndex
    var rightIndex = right.lastIndex
    var carry = 0
    while (leftIndex >= 0 || rightIndex >= 0 || carry != 0) {
        val sum = left.digitAt(leftIndex--) + right.digitAt(rightIndex--) + carry
        result.append(sum % DECIMAL_RADIX)
        carry = sum / DECIMAL_RADIX
    }
    return result.reverse().toString()
}

/** Subtracts [right] from [left], where left is at least right. */
private fun subtractMagnitude(left: String, right: String): String {
    val result = StringBuilder(left.length)
    var rightIndex = right.lastIndex
    var borrow = 0
    for (leftIndex in left.lastIndex downTo 0) {
        var difference = left[leftIndex].digitToInt() - right.digitAt(rightIndex--) - borrow
        if (difference < 0) {
            difference += DECIMAL_RADIX
            borrow = 1
        } else {
            borrow = 0
        }
        result.append(difference)
    }
    return result.reverse().toString().trimStart('0').ifEmpty { "0" }
}

private fun multiplyMagnitude(left: String, right: String): String {
    val digits = IntArray(left.length + right.length)
    for (leftIndex in left.lastIndex downTo 0) {
        var carry = 0
        for (rightIndex in right.lastIndex downTo 0) {
            val resultIndex = leftIndex + rightIndex + 1
            val product = left[leftIndex].digitToInt() * right[rightIndex].digitToInt() +
                digits[resultIndex] + carry
            digits[resultIndex] = product % DECIMAL_RADIX
            carry = product / DECIMAL_RADIX
        }
        digits[leftIndex] += carry
    }
    return digits.dropWhile { it == 0 }.joinToString(separator = "").ifEmpty { "0" }
}

private fun divideMagnitude(dividend: String, divisor: String): Pair<String, String> {
    if (compareMagnitude(dividend, divisor) < 0) return "0" to dividend
    val quotient = StringBuilder(dividend.length)
    var remainder = "0"
    for (digit in dividend) {
        remainder = (if (remainder == "0") digit.toString() else remainder + digit).trimStart('0').ifEmpty { "0" }
        val quotientDigit = quotientDigit(remainder, divisor)
        quotient.append(quotientDigit)
        if (quotientDigit != 0) {
            remainder = subtractMagnitude(remainder, multiplyMagnitudeByDigit(divisor, quotientDigit))
        }
    }
    return quotient.toString().trimStart('0').ifEmpty { "0" } to remainder
}

private fun quotientDigit(dividend: String, divisor: String): Int {
    for (candidate in MAX_DECIMAL_DIGIT downTo 1) {
        if (compareMagnitude(multiplyMagnitudeByDigit(divisor, candidate), dividend) <= 0) return candidate
    }
    return 0
}

private fun multiplyMagnitudeByDigit(value: String, multiplier: Int): String {
    if (multiplier == 0) return "0"
    val result = StringBuilder(value.length + 1)
    var carry = 0
    for (index in value.lastIndex downTo 0) {
        val product = value[index].digitToInt() * multiplier + carry
        result.append(product % DECIMAL_RADIX)
        carry = product / DECIMAL_RADIX
    }
    if (carry != 0) result.append(carry)
    return result.reverse().toString()
}

private fun Char.digitValue(): Int = when (this) {
    in '0'..'9' -> code - '0'.code
    in 'a'..'z' -> code - 'a'.code + DECIMAL_RADIX
    in 'A'..'Z' -> code - 'A'.code + DECIMAL_RADIX
    else -> -1
}

private fun String.digitAt(index: Int): Int = if (index >= 0) this[index].digitToInt() else 0

private fun requireRadix(radix: Int) {
    require(radix in MIN_RADIX..MAX_RADIX) { "Radix out of range: $radix" }
}

private const val MIN_RADIX = 2
private const val MAX_RADIX = 36
private const val DECIMAL_RADIX = 10
private const val MAX_DECIMAL_DIGIT = DECIMAL_RADIX - 1
private const val DIGITS = "0123456789abcdefghijklmnopqrstuvwxyz"
