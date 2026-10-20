@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform") version "2.4.21"
    id("com.android.kotlin.multiplatform.library") version "9.4.1"
    id("dev.detekt") version "2.0.0-alpha.6"
    `maven-publish`
}

group = "dev.quwac"
version = providers.gradleProperty("version").getOrElse("0.1.0-SNAPSHOT")

dependencies {
    detektPlugins("dev.detekt:detekt-rules-ktlint-wrapper:2.0.0-alpha.6")
}

val isMacOs = System.getProperty("os.name").startsWith("Mac", ignoreCase = true)
val xcodeAvailable = if (isMacOs) {
    providers.exec {
        commandLine("/usr/bin/xcrun", "xcodebuild", "-version")
        isIgnoreExitValue = true
    }.result.map { it.exitValue == 0 }
} else {
    providers.provider { false }
}

val nodeJsRoot = org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin.apply(rootProject)
rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.npm.NpmExtension> {
    override("diff", "8.0.3")
    override("serialize-javascript", "7.0.5")
}
nodeJsRoot.versions.webpack.version = "5.112.0"

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }
    wasmJs {
        browser()
        nodejs()
    }
    wasmWasi {
        nodejs()
    }
    android {
        namespace = "dev.quwac.bignumber"
        compileSdk = 32
        minSdk = 21
        withHostTestBuilder {}
    }
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    iosArm64()
    iosSimulatorArm64()
    iosX64()
    linuxArm64()
    linuxX64()
    macosArm64()
    mingwX64()
    tvosArm64()
    tvosSimulatorArm64()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()
    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

val xcodeTestTargets = listOf(
    "iosSimulatorArm64",
    "iosX64",
    "macosArm64",
    "tvosSimulatorArm64",
    "watchosSimulatorArm64",
)
val xcodeExecutableTestTasks = xcodeTestTargets.flatMap { target ->
    val capitalizedTarget = target.replaceFirstChar { it.uppercase() }
    listOf("${target}Test", "linkDebugTest$capitalizedTarget")
}.toSet()

tasks.matching { it.name in xcodeExecutableTestTasks }.configureEach {
    onlyIf("Xcode is required to link or run Apple platform tests") { xcodeAvailable.get() }
}

detekt {
    toolVersion = "2.0.0-alpha.6"
    source.setFrom(files("src", "build.gradle.kts", "settings.gradle.kts"))
    config.setFrom(layout.projectDirectory.file("config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
    basePath.set(rootDir)
}

tasks.named<dev.detekt.gradle.Detekt>("detekt") {
    include("**/*.kt", "**/*.kts")
}

publishing {
    publications.withType<MavenPublication>().configureEach {
        pom {
            name = "BigNumber"
            description =
                "Pure Kotlin arbitrary-precision integers and decimals with identical semantics across Kotlin Multiplatform targets."
            url = "https://github.com/quwac/big-number"
            licenses {
                license {
                    name = "MIT License"
                    url = "https://opensource.org/license/mit"
                }
            }
            scm {
                connection = "scm:git:https://github.com/quwac/big-number.git"
                developerConnection = "scm:git:ssh://git@github.com/quwac/big-number.git"
                url = "https://github.com/quwac/big-number"
            }
        }
    }
}
