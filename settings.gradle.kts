pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

val secureTransitiveDependencies = listOf(
    "io.opentelemetry:opentelemetry-api:1.62.0",
    "io.opentelemetry:opentelemetry-context:1.62.0",
    "org.apache.commons:commons-lang3:3.18.0",
    "org.apache.httpcomponents:httpclient:4.5.14",
    "org.apache.httpcomponents:httpmime:4.5.14",
    "org.bitbucket.b_c:jose4j:0.9.6",
    "org.bouncycastle:bcpkix-jdk18on:1.85",
    "org.bouncycastle:bcprov-jdk18on:1.85",
    "org.bouncycastle:bcutil-jdk18on:1.85",
    "org.jdom:jdom2:2.0.6.1",
)

gradle.beforeProject {
    buildscript.configurations.configureEach {
        resolutionStrategy.force(*secureTransitiveDependencies.toTypedArray())
    }
    configurations.configureEach {
        resolutionStrategy.force(*secureTransitiveDependencies.toTypedArray())
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "bignumber"
