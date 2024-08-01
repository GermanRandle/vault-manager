package vault.manager.apigateway

object ApplicationConfig {
    private const val ROOT_PACKAGE = "vault.manager.apigateway"
    const val GRAPHQL_MODELS_PACKAGE = "$ROOT_PACKAGE.graphql"
}

object WebServerConfig {
    const val HOST = "127.0.0.1"
    const val PORT = 49152

    const val GRAPHQL_ENDPOINT = "graphql"
    const val ROOT_ENDPOINT = "/"
}
