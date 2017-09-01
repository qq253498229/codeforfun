FROM maven:3.5.0-jdk-8
WORKDIR /app
COPY pom.xml .
COPY src ./src
ENTRYPOINT ["mvn","spring-boot:run"]