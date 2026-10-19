# BigNumber

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
