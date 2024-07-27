import org.jetbrains.gradle.ext.packagePrefix
import org.jetbrains.gradle.ext.settings

val javaVersion = 21
val packageName = "german.randle"

plugins {
    // Facilitates creating an executable JVM application.
    // Implicitly applies the Java plugin (basis for the project).
    // Also, implicitly applies the Distribution plugin
    // (which facilitates building archives that serve as distributions).
    application

    // Targeting the JVM.
    alias(libs.plugins.jvm)

    // Extension for IJ IDEA, for avoiding nested packages (in particular).
    alias(libs.plugins.idea.ext)
}

application {
    // Define the main class for the application.
    mainClass = "$packageName.AppKt"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    testImplementation(libs.bundles.junit)
}

kotlin {
    // With toolchains support, Gradle can autodetect local JDKs
    // and install missing JDKs that Gradle requires for the build.
    jvmToolchain(javaVersion)
}

java {
    toolchain {
        // With toolchains support, Gradle can autodetect local JDKs
        // and install missing JDKs that Gradle requires for the build.
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

idea {
    module {
        settings {
            packagePrefix["src/main/kotlin"] = packageName
            packagePrefix["src/test/kotlin"] = packageName
        }
    }
}
