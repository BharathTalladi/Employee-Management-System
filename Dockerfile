FROM eclipse-temurin:17
ENV PORT 8081
EXPOSE 8081
COPY target/employeemanagement-0.0.1-SNAPSHOT.jar employeemanagement.jar
ENTRYPOINT exec java -jar employeemanagement.jar

