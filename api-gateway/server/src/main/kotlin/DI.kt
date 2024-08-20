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
