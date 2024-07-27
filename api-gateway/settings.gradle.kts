rootProject.name = "api-gateway"

include("app")

// Changing subproject names (for better displaying in IDE).
for (subproject in rootProject.children) {
    subproject.name = "${rootProject.name}-${subproject.name}"
}

plugins {
    // Manages which repositories to download toolchains from.
    // Recommended to use in Kotlin official documentation.
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.8.0")
}
