FROM gradle:8.10 AS build

WORKDIR /app

COPY . .

RUN gradle jar


FROM openjdk:21

WORKDIR /app

COPY --from=build /app/server/build/libs/server.jar /app/app.jar

EXPOSE 49152

CMD ["java", "-jar", "/app/app.jar"]
