# Stage 1: Build
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copiamos solo los archivos de build primero (mejor caché de Docker)
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Descargamos dependencias (esta capa se cachea si no cambió build.gradle)
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# Ahora copiamos el código fuente y compilamos
COPY src/ src/
RUN ./gradlew bootJar --no-daemon -x test

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos solo el .jar desde el stage anterior
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]