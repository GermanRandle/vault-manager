package vault.manager.vaultService.server.webserver

class WebServerException(
    override val message: String,
    override val cause: Exception,
) : Exception(message, cause)
