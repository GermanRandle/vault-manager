package vault.manager.apiGateway.server.integration.vaultService

import io.grpc.StatusException
import vault.manager.apiGateway.vaultServiceClient.inspectionServiceGrpcClient
import vault.manager.apiGateway.vaultServiceClient.proto.grpcValidateRequest

internal class GrpcVaultServiceClient : VaultServiceClient {
    override suspend fun validate(): Result<VaultServiceValidationResponse> {
        val grpcResponse = try {
            inspectionServiceGrpcClient.validate(grpcValidateRequest {})
        } catch (e: StatusException) {
            return Result.failure(e) // TODO: do I need to provide a detailed message here?
        }

        return Result.success(grpcResponse.toVaultServiceResponse())
    }
}
