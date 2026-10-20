@file:Suppress("TooManyFunctions")

package dev.quwac.bignumber

import kotlin.math.max

/**
 * An immutable arbitrary-precision decimal implemented entirely in common Kotlin.
 *
 * A value is represented by an [unscaledValue] and a decimal [scale]. Numerically equal values may
 * have different scales. [equals] requires both the value and scale to match, while [compareTo]
 * compares numerical values.
 */
@Suppress("TooManyFunctions") // Conventional decimal operations belong on the value type.
class BigDecimal(val unscaledValue: BigInteger, val scale: Int) : Comparable<BigDecimal> {
    private constructor(value: BigDecimal) : this(value.unscaledValue, value.scale)

    /** Creates a decimal from [value], preserving its parsed scale. */
    constructor(value: String) : this(parse(value))

    /** Creates a scale-zero decimal from [value]. */
    constructor(value: BigInteger) : this(value, 0)

    /** Returns -1, 0, or 1 according to the sign of this value. */
    val signum: Int get() = unscaledValue.signum

    /** Compatibility alias for [signum]. */
    val sign: Int get() = signum

    /** Returns true when this value is zero, independently of its scale. */
    val isZero: Boolean get() = unscaledValue.isZero

    /** Returns the number of decimal digits in the unscaled value; zero has precision one. */
    val precision: Int get() = unscaledValue.magnitude.length

    override fun compareTo(other: BigDecimal): Int {
        if (signum != other.signum) return signum.compareTo(other.signum)
        if (signum == 0) return 0
        val magnitudeComparison = compareDecimalMagnitude(this, other)
        return if (signum > 0) magnitudeComparison else -magnitudeComparison
    }

    operator fun unaryPlus(): BigDecimal = this

    operator fun unaryMinus(): BigDecimal = if (isZero) this else of(-unscaledValue, scale)

    operator fun plus(other: BigDecimal): BigDecimal {
        val resultScale = maxOf(scale, other.scale)
        val left = unscaledValue.timesPowerOfTen(scaleDifference(resultScale, scale))
        val right = other.unscaledValue.timesPowerOfTen(scaleDifference(resultScale, other.scale))
        return of(left + right, resultScale)
    }

    /** Adds [other] and rounds the exact result according to [mathContext]. */
    fun plus(other: BigDecimal, mathContext: MathContext): BigDecimal = (this + other).round(mathContext)

    operator fun minus(other: BigDecimal): BigDecimal = this + -other

    /** Subtracts [other] and rounds the exact result according to [mathContext]. */
    fun minus(other: BigDecimal, mathContext: MathContext): BigDecimal = (this - other).round(mathContext)

    operator fun times(other: BigDecimal): BigDecimal =
        of(unscaledValue * other.unscaledValue, checkedScale(scale.toLong() + other.scale.toLong()))

    /** Multiplies by [other] and rounds the exact result according to [mathContext]. */
    fun times(other: BigDecimal, mathContext: MathContext): BigDecimal = (this * other).round(mathContext)

    /**
     * Performs exact division.
     *
     * @throws ArithmeticException when [other] is zero, the exact result has a non-terminating
     * decimal expansion, or the result scale is outside the supported [Int] range.
     */
    operator fun div(other: BigDecimal): BigDecimal = divide(other)

    /** Performs exact division with the same behavior as the `/` operator. */
    fun divide(other: BigDecimal): BigDecimal {
        if (other.isZero) throw ArithmeticException("Division by zero")
        val preferredScale = checkedScale(scale.toLong() - other.scale.toLong())
        if (isZero) return of(BigInteger.ZERO, preferredScale)

        val commonDivisor = unscaledValue.abs().gcd(other.unscaledValue.abs())
        var numerator = unscaledValue.abs() / commonDivisor
        var denominator = other.unscaledValue.abs() / commonDivisor
        var powersOfTwo = 0
        var powersOfFive = 0
        while (denominator % TWO == BigInteger.ZERO) {
            denominator /= TWO
            powersOfTwo++
        }
        while (denominator % FIVE == BigInteger.ZERO) {
            denominator /= FIVE
            powersOfFive++
        }
        if (denominator != BigInteger.ONE) throw ArithmeticException(NON_TERMINATING_DIVISION)

        val resultPower = maxOf(powersOfTwo, powersOfFive)
        numerator *= TWO.pow(resultPower - powersOfTwo)
        numerator *= FIVE.pow(resultPower - powersOfFive)
        if (signum * other.signum < 0) numerator = -numerator
        val resultScale = checkedScale(resultPower.toLong() + preferredScale.toLong())
        return of(numerator, resultScale)
    }

    /**
     * Divides to [resultScale], applying [roundingMode] when discarded digits are non-zero.
     *
     * The returned value always has [resultScale].
     */
    fun divide(other: BigDecimal, resultScale: Int, roundingMode: RoundingMode): BigDecimal {
        if (other.isZero) throw ArithmeticException("Division by zero")
        if (isZero) return of(BigInteger.ZERO, resultScale)

        val power = resultScale.toLong() + other.scale.toLong() - scale.toLong()
        val unsignedNumerator: BigInteger
        val unsignedDenominator: BigInteger
        if (power >= 0) {
            unsignedNumerator = unscaledValue.abs().timesPowerOfTen(checkedPower(power))
            unsignedDenominator = other.unscaledValue.abs()
        } else {
            unsignedNumerator = unscaledValue.abs()
            unsignedDenominator = other.unscaledValue.abs().timesPowerOfTen(checkedPower(-power))
        }
        val (quotient, remainder) = unsignedNumerator.divideAndRemainder(unsignedDenominator)
        val resultSign = signum * other.signum
        val rounded = quotient.rounded(remainder, unsignedDenominator, resultSign, roundingMode)
        return of(if (resultSign < 0) -rounded else rounded, resultScale)
    }

    /** Divides using this value's scale and [roundingMode]. */
    fun divide(other: BigDecimal, roundingMode: RoundingMode): BigDecimal = divide(other, scale, roundingMode)

    /**
     * Divides and rounds to the significant-digit precision in [mathContext].
     *
     * An unlimited context requires an exact terminating result.
     */
    @Suppress("ReturnCount")
    fun divide(other: BigDecimal, mathContext: MathContext): BigDecimal {
        if (other.isZero) throw ArithmeticException("Division by zero")
        if (mathContext.precision == 0) return divide(other)

        try {
            return divide(other).round(mathContext)
        } catch (failure: ArithmeticException) {
            if (failure.message != NON_TERMINATING_DIVISION) throw failure
        }

        val exponent = quotientAdjustedExponent(this, other)
        val targetScale = checkedScale(mathContext.precision.toLong() - 1L - exponent)
        return divide(other, targetScale, mathContext.roundingMode).round(mathContext)
    }

    /** Returns the remainder after division toward zero. */
    operator fun rem(other: BigDecimal): BigDecimal = remainder(other)

    /**
     * Returns `this - trunc(this / other) * other`.
     *
     * @throws ArithmeticException when [other] is zero.
     */
    fun remainder(other: BigDecimal): BigDecimal {
        val quotient = integralQuotient(other)
        return this - quotient * other
    }

    /** Returns the integral quotient and remainder after division toward zero. */
    fun divideAndRemainder(other: BigDecimal): Pair<BigDecimal, BigDecimal> {
        val quotient = integralQuotient(other)
        return quotient to (this - quotient * other)
    }

    /**
     * Returns this value with [newScale], rounding only when the scale is reduced.
     *
     * @throws ArithmeticException when rounding would be necessary.
     */
    fun setScale(newScale: Int): BigDecimal = setScale(newScale, RoundingMode.UNNECESSARY)

    /** Returns this value with [newScale], applying [roundingMode] when digits are discarded. */
    fun setScale(newScale: Int, roundingMode: RoundingMode): BigDecimal {
        if (newScale == scale) return this
        if (isZero) return of(BigInteger.ZERO, newScale)
        if (newScale > scale) {
            val scaled = unscaledValue.timesPowerOfTen(scaleDifference(newScale, scale))
            return of(scaled, newScale)
        }

        val discardedDigits = scaleDifference(scale, newScale)
        val divisor = BigInteger.ONE.timesPowerOfTen(discardedDigits)
        val (quotient, remainder) = unscaledValue.abs().divideAndRemainder(divisor)
        val rounded = quotient.rounded(remainder, divisor, signum, roundingMode)
        return of(if (signum < 0) -rounded else rounded, newScale)
    }

    /** Compatibility scale-rounding operation; equivalent to [setScale]. */
    fun round(resultScale: Int, roundingMode: RoundingMode): BigDecimal = setScale(resultScale, roundingMode)

    /** Rounds to the significant-digit precision in [mathContext]. */
    fun round(mathContext: MathContext): BigDecimal {
        val targetPrecision = mathContext.precision
        if (targetPrecision == 0 || precision <= targetPrecision) return this

        val discardedDigits = precision - targetPrecision
        val divisor = BigInteger.ONE.timesPowerOfTen(discardedDigits)
        val (quotient, remainder) = unscaledValue.abs().divideAndRemainder(divisor)
        var rounded = quotient.rounded(remainder, divisor, signum, mathContext.roundingMode)
        var resultScale = checkedScale(scale.toLong() - discardedDigits.toLong())
        while (rounded.magnitude.length > targetPrecision) {
            rounded /= BigInteger.TEN
            resultScale = checkedScale(resultScale.toLong() - 1L)
        }
        return of(if (signum < 0) -rounded else rounded, resultScale)
    }

    /** Returns the absolute value, preserving scale. */
    fun abs(): BigDecimal = if (signum < 0) -this else this

    /** Returns the absolute value rounded according to [mathContext]. */
    fun abs(mathContext: MathContext): BigDecimal = abs().round(mathContext)

    /** Returns the additive inverse, preserving scale. */
    fun negate(): BigDecimal = -this

    /** Returns the additive inverse rounded according to [mathContext]. */
    fun negate(mathContext: MathContext): BigDecimal = negate().round(mathContext)

    /** Returns this value unchanged. */
    fun plus(): BigDecimal = this

    /** Returns this value rounded according to [mathContext]. */
    fun plus(mathContext: MathContext): BigDecimal = round(mathContext)

    /** Returns the numerically smaller value. */
    fun min(other: BigDecimal): BigDecimal = if (this <= other) this else other

    /** Returns the numerically larger value. */
    fun max(other: BigDecimal): BigDecimal = if (this >= other) this else other

    /** Moves the decimal point [places] positions to the left without rounding. */
    fun movePointLeft(places: Int): BigDecimal = movePoint(places.toLong())

    /** Moves the decimal point [places] positions to the right without rounding. */
    fun movePointRight(places: Int): BigDecimal = movePoint(-places.toLong())

    /** Returns a value numerically equal to this value multiplied by ten to [power]. */
    fun scaleByPowerOfTen(power: Int): BigDecimal = of(unscaledValue, checkedScale(scale.toLong() - power.toLong()))

    /** Removes trailing zeros from the unscaled value; zero becomes [ZERO]. */
    fun stripTrailingZeros(): BigDecimal {
        if (isZero) return ZERO
        var magnitude = unscaledValue.magnitude
        var strippedScale = scale
        while (magnitude.last() == '0') {
            if (strippedScale == Int.MIN_VALUE) throw ArithmeticException("BigDecimal scale is out of range")
            magnitude = magnitude.dropLast(1)
            strippedScale--
        }
        return of(BigInteger.fromMagnitude(signum, magnitude), strippedScale)
    }

    /** Returns the integer part by discarding any fractional digits. */
    fun toBigInteger(): BigInteger = integerPart(exact = false)

    /**
     * Returns the integer value.
     *
     * @throws ArithmeticException when this value has a non-zero fractional part.
     */
    fun toBigIntegerExact(): BigInteger = integerPart(exact = true)

    /** Returns a non-exponent decimal string, preserving scale where it produces fractional zeros. */
    fun toPlainString(): String {
        if (isZero && scale <= 0) return "0"
        val signPrefix = if (signum < 0) "-" else ""
        val magnitude = unscaledValue.magnitude
        return when {
            scale == 0 -> "$signPrefix$magnitude"

            scale < 0 -> "$signPrefix$magnitude${"0".repeat(checkedPower(-scale.toLong()))}"

            scale >= magnitude.length ->
                "${signPrefix}0.${"0".repeat(scale - magnitude.length)}$magnitude"

            else -> {
                val point = magnitude.length - scale
                "$signPrefix${magnitude.substring(0, point)}.${magnitude.substring(point)}"
            }
        }
    }

    /** Returns an engineering string whose exponent, when present, is a multiple of three. */
    fun toEngineeringString(): String {
        val adjustedExponent = adjustedExponent()
        if (scale >= 0 && adjustedExponent >= PLAIN_STRING_EXPONENT_THRESHOLD) return toPlainString()
        if (isZero) return zeroEngineeringString(adjustedExponent)

        val engineeringExponent = adjustedExponent - floorMod(adjustedExponent, ENGINEERING_GROUP_SIZE)
        val integerDigits = (adjustedExponent - engineeringExponent + 1L).toInt()
        val coefficient = engineeringCoefficient(unscaledValue.magnitude, integerDigits)
        val signPrefix = if (signum < 0) "-" else ""
        if (engineeringExponent == 0L) return "$signPrefix$coefficient"
        return "$signPrefix$coefficient${formatExponent(engineeringExponent)}"
    }

    /**
     * Returns the canonical decimal representation. Plain notation is used when the adjusted
     * exponent is at least -6 and the scale is non-negative; otherwise scientific notation is used.
     */
    override fun toString(): String {
        val adjustedExponent = adjustedExponent()
        if (scale >= 0 && adjustedExponent >= PLAIN_STRING_EXPONENT_THRESHOLD) return toPlainString()
        val magnitude = unscaledValue.magnitude
        val coefficient = if (magnitude.length == 1) magnitude else "${magnitude.first()}.${magnitude.drop(1)}"
        val signPrefix = if (signum < 0) "-" else ""
        return "$signPrefix$coefficient${formatExponent(adjustedExponent)}"
    }

    override fun equals(other: Any?): Boolean =
        other is BigDecimal && unscaledValue == other.unscaledValue && scale == other.scale

    override fun hashCode(): Int = 31 * unscaledValue.hashCode() + scale

    @Suppress("ReturnCount")
    private fun integralQuotient(other: BigDecimal): BigDecimal {
        if (other.isZero) throw ArithmeticException("Division by zero")
        val power = other.scale.toLong() - scale.toLong()
        val numerator: BigInteger
        val denominator: BigInteger
        if (power >= 0) {
            numerator = unscaledValue.timesPowerOfTen(checkedPower(power))
            denominator = other.unscaledValue
        } else {
            numerator = unscaledValue
            denominator = other.unscaledValue.timesPowerOfTen(checkedPower(-power))
        }
        val quotient = numerator / denominator
        val preferredScale = checkedScale(scale.toLong() - other.scale.toLong())
        if (preferredScale >= 0) return of(quotient.timesPowerOfTen(preferredScale), preferredScale)
        if (quotient.isZero) return of(BigInteger.ZERO, preferredScale)

        var magnitude = quotient.magnitude
        var quotientScale = 0
        while (quotientScale > preferredScale && magnitude.last() == '0') {
            magnitude = magnitude.dropLast(1)
            quotientScale--
        }
        return of(BigInteger.fromMagnitude(quotient.signum, magnitude), quotientScale)
    }

    private fun movePoint(scaleIncrease: Long): BigDecimal {
        val candidateScale = scale.toLong() + scaleIncrease
        if (candidateScale >= 0) return of(unscaledValue, checkedScale(candidateScale))
        val shifted = unscaledValue.timesPowerOfTen(checkedPower(-candidateScale))
        return of(shifted, 0)
    }

    private fun integerPart(exact: Boolean): BigInteger {
        if (isZero) return BigInteger.ZERO
        if (scale <= 0) return unscaledValue.timesPowerOfTen(checkedPower(-scale.toLong()))
        if (scale >= unscaledValue.magnitude.length) {
            if (exact && !isZero) throw ArithmeticException("Rounding is necessary")
            return BigInteger.ZERO
        }

        val split = unscaledValue.magnitude.length - scale
        val integerMagnitude = unscaledValue.magnitude.substring(0, split)
        val fractionalMagnitude = unscaledValue.magnitude.substring(split)
        if (exact && fractionalMagnitude.any { it != '0' }) throw ArithmeticException("Rounding is necessary")
        return BigInteger.fromMagnitude(signum, integerMagnitude)
    }

    private fun adjustedExponent(): Long = precision.toLong() - scale.toLong() - 1L

    companion object {
        val ZERO: BigDecimal = BigDecimal(BigInteger.ZERO, 0)
        val ONE: BigDecimal = BigDecimal(BigInteger.ONE, 0)
        val TEN: BigDecimal = BigDecimal(BigInteger.TEN, 0)

        private val TWO = BigInteger.of(2)
        private val FIVE = BigInteger.of(5)

        fun of(value: Byte): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: Short): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: Int): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: Long): BigDecimal = of(BigInteger.of(value), 0)

        /** Creates a decimal from the canonical string representation of [value]. */
        fun of(value: Float): BigDecimal {
            require(value.isFinite()) { "BigDecimal requires a finite Float" }
            return parse(value.toString())
        }

        /** Creates a decimal from the canonical string representation of [value]. */
        fun of(value: Double): BigDecimal {
            require(value.isFinite()) { "BigDecimal requires a finite Double" }
            return parse(value.toString())
        }

        fun of(value: UByte): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: UShort): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: UInt): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: ULong): BigDecimal = of(BigInteger.of(value), 0)

        fun of(value: BigInteger): BigDecimal = of(value, 0)

        /** Creates a decimal with the exact [unscaledValue] and [scale]. */
        fun of(unscaledValue: BigInteger, scale: Int): BigDecimal = when {
            unscaledValue.isZero && scale == 0 -> ZERO
            unscaledValue == BigInteger.ONE && scale == 0 -> ONE
            unscaledValue == BigInteger.TEN && scale == 0 -> TEN
            else -> BigDecimal(unscaledValue, scale)
        }

        /** Parses a decimal, preserving trailing zeros and exponent-derived scale. */
        fun parse(value: String): BigDecimal =
            parseOrNull(value) ?: throw IllegalArgumentException("Invalid BigDecimal: $value")

        /** Returns a parsed decimal, or null when [value] is not valid decimal notation. */
        fun parseOrNull(value: String): BigDecimal? {
            val parsed = parseParts(value) ?: return null
            val unscaled = BigInteger.parseOrNull(parsed.signedDigits) ?: return null
            return of(unscaled, parsed.scale)
        }
    }
}

private data class DecimalParts(val signedDigits: String, val scale: Int)

private val decimalPattern = Regex("[+-]?(?:[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+)(?:[eE][+-]?[0-9]+)?")

private fun parseParts(value: String): DecimalParts? {
    if (!decimalPattern.matches(value)) return null
    val signPrefix = value.first().takeIf { it == '+' || it == '-' }?.toString().orEmpty()
    val unsignedValue = value.removePrefix("+").removePrefix("-")
    val exponentIndex = unsignedValue.indexOfFirst { it == 'e' || it == 'E' }
    val significand = if (exponentIndex < 0) unsignedValue else unsignedValue.substring(0, exponentIndex)
    val exponentText = exponentIndex.takeIf { it >= 0 }?.let { unsignedValue.substring(it + 1) }
    val exponent = if (exponentText == null) 0 else exponentText.toIntOrNull() ?: return null
    val decimalPoint = significand.indexOf('.')
    val fractionalDigits = decimalPoint.takeIf { it >= 0 }?.let { significand.length - it - 1 } ?: 0
    val scale = fractionalDigits.toLong() - exponent.toLong()
    return scale.takeIf { it in Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong() }
        ?.let { DecimalParts(signPrefix + significand.replace(".", ""), it.toInt()) }
}

private fun compareDecimalMagnitude(left: BigDecimal, right: BigDecimal): Int {
    val leftWholeDigits = left.precision.toLong() - left.scale.toLong()
    val rightWholeDigits = right.precision.toLong() - right.scale.toLong()
    val wholeDigitsComparison = leftWholeDigits.compareTo(rightWholeDigits)
    if (wholeDigitsComparison != 0) return wholeDigitsComparison
    return compareSignificands(left.unscaledValue.magnitude, right.unscaledValue.magnitude)
}

private fun compareSignificands(left: String, right: String): Int {
    for (index in 0 until max(left.length, right.length)) {
        val leftDigit = left.getOrNull(index) ?: '0'
        val rightDigit = right.getOrNull(index) ?: '0'
        val comparison = leftDigit.compareTo(rightDigit)
        if (comparison != 0) return comparison
    }
    return 0
}

private fun quotientAdjustedExponent(dividend: BigDecimal, divisor: BigDecimal): Long {
    var exponent = dividend.precision.toLong() - dividend.scale.toLong() -
        divisor.precision.toLong() + divisor.scale.toLong()
    if (compareSignificands(dividend.unscaledValue.magnitude, divisor.unscaledValue.magnitude) < 0) exponent--
    return exponent
}

private fun BigInteger.rounded(
    remainder: BigInteger,
    denominator: BigInteger,
    resultSign: Int,
    roundingMode: RoundingMode,
): BigInteger = if (shouldIncrement(this, remainder, denominator, resultSign, roundingMode)) {
    this + BigInteger.ONE
} else {
    this
}

private fun shouldIncrement(
    quotient: BigInteger,
    remainder: BigInteger,
    denominator: BigInteger,
    resultSign: Int,
    roundingMode: RoundingMode,
): Boolean {
    if (remainder.isZero) return false
    return when (roundingMode) {
        RoundingMode.UP -> true

        RoundingMode.DOWN -> false

        RoundingMode.CEILING -> resultSign > 0

        RoundingMode.FLOOR -> resultSign < 0

        RoundingMode.UNNECESSARY -> throw ArithmeticException("Rounding is necessary")

        RoundingMode.HALF_UP,
        RoundingMode.HALF_DOWN,
        RoundingMode.HALF_EVEN,
        -> {
            val halfComparison = (remainder * BigInteger.of(2)).compareTo(denominator)
            when {
                halfComparison > 0 -> true
                halfComparison < 0 -> false
                roundingMode == RoundingMode.HALF_UP -> true
                roundingMode == RoundingMode.HALF_DOWN -> false
                else -> quotient.isOdd
            }
        }
    }
}

private fun BigDecimal.zeroEngineeringString(adjustedExponent: Long): String {
    val engineeringExponent = adjustedExponent + floorMod(-adjustedExponent, ENGINEERING_GROUP_SIZE)
    val fractionalZeros = (engineeringExponent - adjustedExponent).toInt()
    val coefficient = if (fractionalZeros == 0) "0" else "0.${"0".repeat(fractionalZeros)}"
    return "$coefficient${formatExponent(engineeringExponent)}"
}

private fun engineeringCoefficient(magnitude: String, integerDigits: Int): String {
    val padded = magnitude.padEnd(integerDigits, '0')
    return if (padded.length == integerDigits) {
        padded
    } else {
        "${padded.substring(0, integerDigits)}.${padded.substring(integerDigits)}"
    }
}

private fun formatExponent(exponent: Long): String = when {
    exponent > 0 -> "E+$exponent"
    else -> "E$exponent"
}

private fun floorMod(value: Long, divisor: Long): Long {
    val remainder = value % divisor
    return if (remainder >= 0) remainder else remainder + divisor
}

private fun scaleDifference(larger: Int, smaller: Int): Int = checkedPower(larger.toLong() - smaller.toLong())

private fun checkedPower(power: Long): Int {
    if (power !in 0..Int.MAX_VALUE.toLong()) throw ArithmeticException("Decimal scale difference is too large")
    return power.toInt()
}

private fun checkedScale(scale: Long): Int {
    if (scale !in Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong()) {
        throw ArithmeticException("BigDecimal scale is out of range")
    }
    return scale.toInt()
}

private const val NON_TERMINATING_DIVISION = "Non-terminating decimal expansion"
private const val PLAIN_STRING_EXPONENT_THRESHOLD = -6L
private const val ENGINEERING_GROUP_SIZE = 3L
