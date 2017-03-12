FROM frolvlad/alpine-oraclejdk8:latest
VOLUME /tmp
ADD docker-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]