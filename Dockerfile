FROM openjdk:8
EXPOSE 8080
ADD target/deliver_ease.jar deliver_ease.jar
ENTRYPOINT ["java","-jar","/deliver_ease.jar"]
