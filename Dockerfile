# Build stage
FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM kritilabs/21-jdk:latest

# Application metadata
LABEL maintainer="yannbiko@gmail.com"
LABEL version="1.0"
LABEL description="Subscription Service"

# Create non-root user
RUN groupadd -r spring && useradd -r -g spring spring

WORKDIR /app

# Copy jar from build stage
COPY --from=builder /build/target/*.jar app.jar
RUN chown spring:spring app.jar

# Use non-root user
USER spring

# Environment variables
ENV TZ=UTC

# Expose port
EXPOSE 5000

# Run application
ENTRYPOINT ["java", \
            "-XX:+UseContainerSupport", \
            "-XX:MaxRAMPercentage=75.0", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-jar", \
            "app.jar"]

# Healthcheck
HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 \
    CMD curl -f http://localhost:5000/actuator/health || exit 1