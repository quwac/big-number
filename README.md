<p align="center">
  <img src="docs/assets/bignumber-logo.svg" alt="BigNumber logo" width="420">
</p>

<h1 align="center">BigNumber</h1>

<p align="center">
  <a href="https://github.com/quwac/big-number/actions/workflows/ci.yml"><img src="https://img.shields.io/badge/CI-Verify-2088FF?logo=githubactions&amp;logoColor=white" alt="CI: Verify"></a>
  <a href="https://kotlinlang.org/"><img src="https://img.shields.io/badge/Kotlin-2.4.21-7F52FF?logo=kotlin&amp;logoColor=white" alt="Kotlin 2.4.21"></a>
  <a href="#supported-targets"><img src="https://img.shields.io/badge/Kotlin-Multiplatform-7F52FF?logo=kotlin&amp;logoColor=white" alt="Kotlin Multiplatform"></a>
  <a href="https://gradle.org/"><img src="https://img.shields.io/badge/Gradle-9.8.1-02303A?logo=gradle&amp;logoColor=white" alt="Gradle 9.8.1"></a>
  <a href="https://openjdk.org/"><img src="https://img.shields.io/badge/JDK-17-007396?logo=openjdk&amp;logoColor=white" alt="JDK 17"></a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="MIT License"></a>
</p>

Pure Kotlin arbitrary-precision integers and decimals with identical semantics across Kotlin Multiplatform targets.

BigNumber provides immutable `BigInteger` and `BigDecimal` values. All arithmetic is implemented once in `commonMain`;
the library does not delegate to Java numeric classes, JavaScript `BigInt`, decimal.js, or platform-specific
arbitrary-precision APIs.

## Installation

Add Maven Central and BigNumber to the `commonMain` source set:

```kotlin
repositories {
    mavenCentral()
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("dev.quwac:bignumber:<version>")
        }
    }
}
```

Replace `<version>` with the release you want to use.

## Usage

```kotlin
import dev.quwac.bignumber.*

val integer = "12345678901234567890".toBigInteger()
val radixValue = BigInteger("ff", radix = 16)

val amount = BigDecimal("10.50")
val divisor = 4.toBigDecimal()

val exact = amount / divisor // 2.625
val total = 4 + amount // 14.50
val rounded = amount.divide(
    BigDecimal("3"),
    MathContext(4, RoundingMode.HALF_EVEN),
)
```

## Supported targets

- JVM and Android
- JavaScript on Node.js and browsers
- WebAssembly JavaScript on Node.js and browsers, and WebAssembly WASI
- Android Native x86, x64, arm32, and arm64
- iOS device arm64 and x64/arm64 simulators
- macOS arm64
- Linux x64 and arm64
- Windows x64 through MinGW
- tvOS device arm64 and arm64 simulator
- watchOS arm64, device arm64, and arm64 simulator

Deprecated Kotlin/Native target presets are not published.

## Decimal semantics

`BigDecimal` follows the familiar Java decimal model without calling `java.math` in production code:

- `unscaledValue` and `scale` define the representation.
- `precision` is the number of digits in the unscaled value; zero has precision one.
- `equals` and `hashCode` include scale, so `BigDecimal("1.0")` and `BigDecimal("1.00")` are distinct representations.
- `compareTo` compares numerical values, so those same values compare as equal.
- `/` and `divide(other)` require an exact terminating decimal result.
- Scale-based division, `setScale`, and `MathContext` operations require an explicit `RoundingMode` when information may
  be discarded.
- `RoundingMode.UNNECESSARY` throws `ArithmeticException` if rounding is required.
- `Byte`, `Short`, `Int`, `Long`, `Float`, `Double`, and the unsigned integer types provide concrete overloads for
  `+`, `-`, `*`, `/`, `%`, and ordered comparison with `BigDecimal` in either operand order. Floating-point operands
  use their canonical decimal string representation; `NaN` and infinities are rejected.
- `toString` uses canonical plain or scientific notation; `toPlainString` never uses an exponent and
  `toEngineeringString` uses exponents divisible by three.

## Integer semantics

Primitive conversions such as `toInt()` and `toLong()` return the low-order bits, matching the truncating behavior
familiar from `java.math.BigInteger`. Exact variants such as `toIntExact()` and `toULongExact()` throw
`ArithmeticException` on overflow.

`Byte`, `Short`, `Int`, `Long`, and the unsigned integer types provide concrete overloads for `+`, `-`, `*`, `/`, `%`,
and ordered comparison with `BigInteger` in either operand order. `Float` and `Double` provide the same operators with
`BigInteger`, returning `BigDecimal` so fractional results are preserved.

Bitwise operations use an infinite-width two's-complement representation, so `-1` has `1` in every bit position rather
than a finite representation such as `11`. `and`, `or`, `xor`, `andNot`, `inv`, `shl`, and `shr` therefore work
consistently for positive and negative values. The binary operations accept `BigInteger` or any concrete integral type
in either operand order. Individual bits can be read or changed with `testBit`, `setBit`, `clearBit`, and `flipBit`.
There is no unsigned right shift because an arbitrary-precision integer has no fixed most-significant bit.

```kotlin
val masked = BigInteger.of(-1) and BigInteger.of(5) // 5
val inverted = BigInteger.of(5).inv() // -6
val shifted = BigInteger.of(-5) shr 1 // -3
```

String parsing accepts an optional sign. `BigInteger` supports radices from 2 through 36. Invalid text throws
`IllegalArgumentException`; nullable parsing functions return `null`. Division by zero and non-terminating exact decimal
division throw `ArithmeticException`.

The internal decimal-digit storage is not public API. It may be replaced without changing the numerical contract.

## Build and local publication

The repository uses `mise` to install JDK 17 and the project tools.

```sh
mise run test
mise run check
```

The local publication uses the coordinates `dev.quwac:bignumber:0.1.0-SNAPSHOT`.

## License

BigNumber is available under the [MIT License](LICENSE).
