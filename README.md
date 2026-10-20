<p align="center">
  <img src="docs/assets/bignumber-logo.png" alt="BigNumber logo" width="420">
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

```kotlin
import dev.quwac.bignumber.*

val integer = "12345678901234567890".toBigInteger()
val radixValue = BigInteger("ff", radix = 16)

val amount = BigDecimal("10.50")
val divisor = 4.toBigDecimal()

val exact = amount / divisor // 2.625
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
- `toString` uses canonical plain or scientific notation; `toPlainString` never uses an exponent and
  `toEngineeringString` uses exponents divisible by three.

## Integer semantics

Primitive conversions such as `toInt()` and `toLong()` return the low-order bits, matching the truncating behavior
familiar from `java.math.BigInteger`. Exact variants such as `toIntExact()` and `toULongExact()` throw
`ArithmeticException` on overflow.

String parsing accepts an optional sign. `BigInteger` supports radices from 2 through 36. Invalid text throws
`IllegalArgumentException`; nullable parsing functions return `null`. Division by zero and non-terminating exact decimal
division throw `ArithmeticException`.

The internal decimal-digit storage is not public API. It may be replaced without changing the numerical contract.

## Build and local publication

The repository requires JDK 17. The checked-in Gradle wrapper installs the remaining build tools.

```sh
./gradlew detekt allTests
./gradlew publishToMavenLocal
```

The local publication uses the coordinates `dev.quwac:bignumber:0.1.0-SNAPSHOT`.

## License

BigNumber is available under the [MIT License](LICENSE).
