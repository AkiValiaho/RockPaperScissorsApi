FROM openjdk:9
COPY ./target/rockpaperscissors-0.0.1-SNAPSHOT.jar /usr/src/myapp/runnable.jar
CMD ["java", "-jar","/usr/src/myapp/runnable.jar"]
