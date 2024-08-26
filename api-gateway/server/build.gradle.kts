import org.jetbrains.gradle.ext.packagePrefix
import org.jetbrains.gradle.ext.settings

val javaVersion = 21
val packageName = "vault.manager.apiGateway.server"
val mainClassFullName = "$packageName.MainKt"

plugins {
    // Facilitates creating an executable JVM application. Implicitly applies the Java plugin (basis for the project).
    // Also, implicitly applies the Distribution plugin
    // (which facilitates building archives that serve as distributions).
    application

    // Official IDE plugin. In particular, useful for automatic download of source files
    // and Javadoc for project dependencies.
    idea

    // Targeting the JVM.
    alias(libs.plugins.jvm)

    // Extension for IJ IDEA, for avoiding nested packages (in particular).
    alias(libs.plugins.idea.ext)

    // Can be used to configure bom, run tasks and for deployment.
    alias(libs.plugins.ktor)
}

application {
    // Define the main class for the application.
    mainClass = mainClassFullName
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = mainClassFullName
    }
    from(
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    )
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
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
    // Internal
    implementation(project(":vault-service-client"))

    // Server framework
    implementation(libs.bundles.ktor)

    // GraphQL
    implementation(libs.graphql.kotlin.ktor.server)

    // Logging
    implementation(libs.logback)

    // JUnit
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
        isDownloadSources = true
        isDownloadJavadoc = true
        settings {
            packagePrefix["src/main/kotlin"] = packageName
            packagePrefix["src/test/kotlin"] = packageName
        }
    }
}
