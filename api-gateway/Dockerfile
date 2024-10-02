FROM gradle:8.10 AS build

WORKDIR /app

# Copying source & build files
COPY settings.gradle.kts ./
COPY gradle/libs.versions.toml ./gradle/
COPY server/build.gradle.kts ./server/
COPY server/src/main/ ./server/src/
COPY vault-service-client/build.gradle.kts ./vault-service-client/
COPY vault-service-client/src/main/ ./vault-service-client/src/

RUN gradle jar

# TODO: I need some Dockerfile `Thread.sleep` alternative to see what's going on in the filesystem

# FROM openjdk:21

# WORKDIR /app

# COPY --from=build /app/server/build/libs/server.jar /app/app.jar

# EXPOSE 49152

# CMD ["java", "-jar", "/app/app.jar"]
