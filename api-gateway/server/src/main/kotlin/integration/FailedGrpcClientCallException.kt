package vault.manager.apiGateway.server.integration

class FailedGrpcClientCallException(
    methodName: String,
    serviceName: String,
    override val cause: Exception,
) : Exception("gRPC method '$methodName' of '$serviceName' call failed", cause)
