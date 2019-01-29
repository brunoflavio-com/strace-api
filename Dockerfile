FROM java:openjdk-8u111-alpine
RUN apk --no-cache add curl
RUN apk --no-cache add strace
COPY build/libs/*-all.jar strace-api.jar
CMD java ${JAVA_OPTS} -jar strace-api.jar
