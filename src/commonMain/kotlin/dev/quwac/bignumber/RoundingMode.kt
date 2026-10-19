package dev.quwac.bignumber

/** Specifies how a discarded fractional part affects a rounded result. */
enum class RoundingMode {
    /** Rounds away from zero. */
    UP,

    /** Rounds toward zero. */
    DOWN,

    /** Rounds toward positive infinity. */
    CEILING,

    /** Rounds toward negative infinity. */
    FLOOR,

    /** Rounds toward the nearest neighbor, choosing away from zero on a tie. */
    HALF_UP,

    /** Rounds toward the nearest neighbor, choosing toward zero on a tie. */
    HALF_DOWN,

    /** Rounds toward the nearest neighbor, choosing an even final digit on a tie. */
    HALF_EVEN,

    /** Requires an exact result and throws when digits would be discarded. */
    UNNECESSARY,
}
