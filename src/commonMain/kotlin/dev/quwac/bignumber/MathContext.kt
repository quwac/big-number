package dev.quwac.bignumber

/**
 * Controls decimal precision and rounding.
 *
 * A [precision] of zero means unlimited precision. A positive precision limits a result to that
 * many significant decimal digits.
 *
 * @throws IllegalArgumentException when [precision] is negative.
 */
data class MathContext(val precision: Int, val roundingMode: RoundingMode = RoundingMode.HALF_UP) {
    init {
        require(precision >= 0) { "Precision must be non-negative" }
    }

    companion object {
        /** Unlimited precision; operations that require rounding fail. */
        val UNLIMITED: MathContext = MathContext(0, RoundingMode.HALF_UP)

        /** IEEE 754 decimal32 precision with half-even rounding. */
        val DECIMAL32: MathContext = MathContext(7, RoundingMode.HALF_EVEN)

        /** IEEE 754 decimal64 precision with half-even rounding. */
        val DECIMAL64: MathContext = MathContext(16, RoundingMode.HALF_EVEN)

        /** IEEE 754 decimal128 precision with half-even rounding. */
        val DECIMAL128: MathContext = MathContext(34, RoundingMode.HALF_EVEN)
    }
}
