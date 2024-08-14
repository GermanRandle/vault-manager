package vault.manager.apiGateway.vaultServiceClient

import io.grpc.ManagedChannelBuilder
import vault.manager.apiGateway.vaultServiceClient.proto.GrpcInspectionServiceGrpcKt.GrpcInspectionServiceCoroutineStub

private val grpcChannel = ManagedChannelBuilder.forAddress(
    IntegrationConfig.HOST,
    IntegrationConfig.PORT,
).usePlaintext().build()

val inspectionServiceGrpcClient = GrpcInspectionServiceCoroutineStub(grpcChannel)
