rootProject.name = "api-gateway"

include("app")

// Changing subproject names (for better displaying in IDE).
for (subproject in rootProject.children) {
    subproject.name = "${rootProject.name}-${subproject.name}"
}
