package vault.manager.apiGateway.server.integration.vaultService

import vault.manager.apiGateway.vaultServiceClient.inspectionServiceGrpcClient
import vault.manager.apiGateway.vaultServiceClient.proto.grpcValidateRequest

internal class GrpcVaultServiceClient : VaultServiceClient {
    override suspend fun validate(): VaultServiceValidationResult =
        VaultServiceValidationResult.fromGrpc(
            inspectionServiceGrpcClient.validate(grpcValidateRequest {}),
        )
}
