rootProject.name = "api-gateway"

include("app")

plugins {
    // Manages which repositories to download toolchains from.
    // Recommended to use in Kotlin official documentation.
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.8.0")
}
