FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
COPY --from=build /target/student-0.0.1-SNAPSHOT.jar student.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","student.jar"]