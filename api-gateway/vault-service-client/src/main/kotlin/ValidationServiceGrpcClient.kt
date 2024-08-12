package vault.manager.apiGateway.vaultServiceClient

import io.grpc.ManagedChannelBuilder
import vault.manager.apiGateway.vaultServiceClient.proto.ValidationServiceGrpcKt.ValidationServiceCoroutineStub

private val grpcChannel = ManagedChannelBuilder.forAddress(
    IntegrationConfig.HOST,
    IntegrationConfig.PORT,
).usePlaintext().build()

val validationServiceGrpcClient = ValidationServiceCoroutineStub(grpcChannel)
