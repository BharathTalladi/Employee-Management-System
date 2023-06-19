FROM eclipse-temurin:17
WORKDIR /bharath
ENV PORT 8080
EXPOSE 8080
COPY ./target/employeemanagement-0.0.1-SNAPSHOT.jar /bharath/employeemanagement.jar
ENTRYPOINT exec java -jar employeemanagement.jar

