package vault.manager.apiGateway.server

import com.expediagroup.graphql.server.operations.Mutation
import vault.manager.apiGateway.server.graphql.query.ValidateGraphQLQuery
import vault.manager.apiGateway.server.integration.vaultService.GrpcVaultServiceClient
import vault.manager.apiGateway.server.integration.vaultService.VaultServiceClient
import vault.manager.apiGateway.server.webserver.KtorGraphQLEmbeddedWebServer
import vault.manager.apiGateway.server.webserver.WebServer

internal object DI {
    private val vaultServiceClient: VaultServiceClient = GrpcVaultServiceClient()

    private val validateGraphQLQuery = ValidateGraphQLQuery(
        vaultServiceClient,
    )

    private val supportedGraphQLQueries = listOf(
        validateGraphQLQuery,
    )

    private val supportedGraphQLMutations = emptyList<Mutation>()

    val webServer: WebServer = KtorGraphQLEmbeddedWebServer(
        supportedGraphQLQueries,
        supportedGraphQLMutations,
    )
}

internal object ApplicationConfig {
    private const val ROOT_PACKAGE = "vault.manager.apiGateway.server"
    val graphQLSchemaDefinitionPackages = listOf("$ROOT_PACKAGE.graphql.model")
}

internal object WebServerConfig {
    const val PORT = 49152
    const val GRAPHQL_ENDPOINT = "graphql"
    const val ROOT_ENDPOINT = "/"
}
