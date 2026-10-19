# Contributing

## Requirements

- JDK 17
- Chrome for browser tests
- Android SDK platform 32 for the Android target, exposed through `ANDROID_HOME` or `local.properties`
- Xcode for Apple simulator and macOS runtime tests

Use the checked-in Gradle wrapper for all build operations.

## Verification

```sh
./gradlew detekt
./gradlew allTests
./gradlew publishToMavenLocal
```

`allTests` runs the tests available on the current host. Linux, macOS, and Windows CI jobs cover their corresponding
native runtimes. Cross-compiled target artifacts are checked by the build even when the host cannot execute them.

Production arithmetic must remain in `commonMain`. Platform source sets may contain tests or integration glue, but must
not replace the Pure Kotlin numerical engine with a platform numeric implementation.

Public comments, KDoc, commit messages, pull requests, and documentation are written in English.
