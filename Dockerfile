FROM openjdk:8

ADD target/studyspringboot.jar studyspringboot.jar
ENTRYPOINT ["java", "-jar", "studyspringboot.jar"]