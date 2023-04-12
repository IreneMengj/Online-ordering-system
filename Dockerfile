FROM openjdk:8
EXPOSE 8080
ADD target/reggie_take_out-1.0-SNAPSHOT.jar reggie_take_out-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "reggie_take_out-1.0-SNAPSHOT.jar"]

