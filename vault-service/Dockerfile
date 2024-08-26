FROM gradle:8.10 AS build

WORKDIR /app

COPY . .

RUN gradle jar


FROM openjdk:21

WORKDIR /app

COPY --from=build /app/server/build/libs/server.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]


# docker run -p 49153:49153 <image_id>
