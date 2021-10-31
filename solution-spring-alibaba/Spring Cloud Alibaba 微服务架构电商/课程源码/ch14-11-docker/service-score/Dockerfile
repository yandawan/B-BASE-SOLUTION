FROM java:8

ARG JAR_FILE

ADD target/${JAR_FILE} myservice.jar

ENTRYPOINT ["java", "-jar", "myservice.jar"]