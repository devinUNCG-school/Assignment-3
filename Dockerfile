# Stage 1: Build the application
FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /app

# Copy Maven wrapper and pom.xml from demo/
COPY demo/.mvn/ .mvn/
COPY demo/mvnw demo/pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy source code and build
COPY demo/src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
