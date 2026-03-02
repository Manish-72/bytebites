# -------- STAGE 1: Build --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom and download dependencies (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests


# -------- STAGE 2: Run --------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy built jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port (Render injects PORT automatically)
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]