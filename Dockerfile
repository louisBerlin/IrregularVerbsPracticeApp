FROM --platform=linux/amd64 openjdk:21

EXPOSE 8080

ADD backend/target/app.jar app.jar
#java -jar new_name_app.jar
ENTRYPOINT ["java","-jar","app.jar"]

#CMD ["sh","-c","java -jar /new_name_app.jar"]