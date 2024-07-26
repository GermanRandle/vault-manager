plugins {
    // Facilitates creating an executable JVM application.
    // Implicitly applies the Java plugin (basis for the project).
    // Also, implicitly applies the Distribution plugin
    // (which facilitates building archives that serve as distributions).
    application

    // Targeting the JVM.
    alias(libs.plugins.jvm)
}

application {
    // Define the main class for the application.
    mainClass = "org.example.AppKt"
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
    // Use the JUnit 5.
    testImplementation(libs.bundles.junit)

    // Use the Kotlin JUnit 5 integration.
    testImplementation(libs.kotlin.test.junit5)
}
