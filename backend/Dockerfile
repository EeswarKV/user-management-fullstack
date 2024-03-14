#
# Build stage
#
FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean compile package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/UserManagement-0.0.1-SNAPSHOT.jar UserManagement.jar
COPY --from=build src/main/resources/application.properties application.properties
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","UserManagement.jar"]