# Étape de build
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Étape d'exécution
FROM eclipse-temurin:17-jre-jammy AS runtime
WORKDIR /app

# Create a non-root user for OpenShift
RUN useradd -u 1001 -r -g 0 -d /app -s /sbin/nologin -c "App user" appuser && \
    chmod -R g+rwX /app

USER 1001

# Copier le JAR depuis l'étape de build
COPY --from=builder --chown=1001:0 /build/target/contact-form-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
