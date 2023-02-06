FROM maven:alpine as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19
WORKDIR /app
COPY --from=build ./build/target/*.jar ./application.jar
EXPOSE 8080

ENTRYPOINT java -jar application.jar