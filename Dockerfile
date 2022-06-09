FROM amazoncorretto

EXPOSE 8080:8080
ADD build/libs/officelocator-0.0.1-SNAPSHOT.jar officelocator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/officelocator-0.0.1-SNAPSHOT.jar"]