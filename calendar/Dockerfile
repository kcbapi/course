FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/*-exec.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-Xmx256M","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=8088", "-jar","/app.jar"]