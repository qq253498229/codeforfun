FROM maven:3.5.0-jdk-8
VOLUME /Users/wangbin/.m2/repository /root/.m2/repository
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn verify
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-DPROD_MODE=true", "-Xmx32m","-jar","target/cloud-user.jar"]