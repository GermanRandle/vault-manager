package vault.manager.apiGateway.server

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

    val webServer: WebServer = KtorGraphQLEmbeddedWebServer(
        validateGraphQLQuery,
    )
}
