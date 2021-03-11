FROM maven:3.6-jdk-13-alpine AS maven_builder
WORKDIR /build/
COPY src ./src/
COPY pom.xml . 
RUN mvn package

FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
COPY --from=maven_builder /build/target/guia3sd-0.0.1-SNAPSHOT.jar . 
CMD ["java", "-jar", "guia3sd-0.0.1-SNAPSHOT.jar"]