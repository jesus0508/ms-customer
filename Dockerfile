FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S bootcampgroup && adduser -S bootcampuser -G bootcampgroup
USER bootcampuser:bootcampgroup
ARG JAR_FILE=target/ms*.jar
COPY ${JAR_FILE} ms-customer.jar
ENTRYPOINT ["java","-jar","/ms-customer.jar"]