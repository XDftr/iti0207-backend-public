FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/parkla-0.0.1.jar
COPY ${JAR_FILE} parkla-0.0.1.jar
ENTRYPOINT ["java","-jar","/parkla-0.0.1.jar"]
