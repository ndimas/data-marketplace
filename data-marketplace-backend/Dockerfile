FROM eclipse-temurin:17-jre-alpine AS builder
WORKDIR /app
COPY gradle/ ./gradle/
COPY build.gradle.kts settings.gradle.kts gradle.properties ./
COPY src ./src
RUN ./gradlew build -Dquarkus.package.type=uber-jar

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/quarkus-app/data-marketplace-backend-runner.jar ./application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
