FROM openjdk:11
EXPOSE 8080
ADD target/jumia-service.jar jumia-service.jar 
COPY jumia.db jumia.db
ENTRYPOINT ["java","-jar","/jumia-service.jar"]



