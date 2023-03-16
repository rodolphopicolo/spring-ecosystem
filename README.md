#Spring Ecosystem

https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#features.spring-application.application-availability.managing


# Package

    mvn package

## Package with arguments for tests

    mvn -Dname="My Application Name" package

    mvn -Dspring.profiles.active=dev -Dname="MyApplicationName" clean package

# Test

    mvn -Dname="My Application Name" test

    mvn -Dspring.profiles.active=dev -Dname="MyApplicationName" test

# Run

    java -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar

    mvn spring-boot:run

## Run with arguments

    java -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar --name="My Application Name"

    java -Dname="My Application Name" -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar

    mvn spring-boot:run -Dspring-boot.run.arguments=--name="My Application Name"

    mvn spring-boot:run -Dspring.profiles.active=prod -Dspring-boot.run.arguments=--name="My Application Name"

    SPRING_APPLICATION_JSON='{"name":"My Application Name"}' java -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar

    java -Dspring.application.json='{"name":"My Application Name"}'  -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar

    java -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar --spring.application.json='{"name":"My Application Name"}'

## Run with profiles

### VM parameter

Observe application.properties has the variable name defined as name=NoApplicationNameSpecified and it is not overriden by the application-profile.properties, but it can be overriden by the in line parameter. Try to not pass the argument in the command line and compare the results.

    java -Dspring.profiles.active=dev -Dname="My App Name" -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar

    SPRING_APPLICATION_JSON='{"name":"My Application Name thru Environment Variables"}' java -Dspring.profiles.active=dev -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar

Override db.username with the environment variable value:

    DB_USERNAME=mydbname SPRING_APPLICATION_JSON='{"name":"My Application Name thru Environment Variables 1235"}' java -jar -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

    mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --name='my app name'"

### Application parameter

    java -jar -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --name="My Application Name"

Override db.username with the environment variable value:

    DB_USERNAME=mydbname SPRING_APPLICATION_JSON='{"name":"My Application Name thru Environment Variables"}' java -jar -jar ./target/spring-ecosystem-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

    mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev -Dname='my app name'"


# TODO

Logging environment: ElasticSearch, Logstash and Kibana (ELK Stack)
How to configure LogBack to send logs to ElasticSearch using Logstash and visualizing thru Kibana?
