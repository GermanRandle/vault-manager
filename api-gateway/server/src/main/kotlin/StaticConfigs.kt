package vault.manager.apiGateway.server

internal object ApplicationConfig {
    private const val ROOT_PACKAGE = "vault.manager.apiGateway.server"
    val graphQLSchemaDefinitionPackages = listOf("$ROOT_PACKAGE.graphql.model")
}

internal object WebServerConfig {
    const val HOST = "127.0.0.1"
    const val PORT = 49152

    const val GRAPHQL_ENDPOINT = "graphql"
    const val ROOT_ENDPOINT = "/"
}
