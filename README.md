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


# Security

First of all, I started a Authentication Provider, KeyCloak, to use with the aplication.

https://www.keycloak.org/getting-started/getting-started-docker

Create a server with admin, admin credentials in development mode:

    docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev

Access

http://localhost:8081/admin

## Production mode with Postgresql

    create database keycloak;
    create user keycloak with encrypted password 'keycloak';
    grant all privileges on database keycloak to keycloak;

    JDBC URL: jdbc:postgresql://localhost:5432/keycloak

    sudo docker build . -t mykeycloak

To connect with postgresql, we need to reach the host and they are not at the same network, so, we use the parameter --network host,
this parameter makes the -p parameter, to port forword, useless.

    sudo docker run --network host --name mykeycloak mykeycloak start --optimized

To run with the proper certificate:

    docker run --network host --name mykeycloak mykeycloak start --optimized --https-certificate-file /tls-certificate/certificate.pem --https-certificate-key-file /tls-certificate/key.pem

Keycloak, in production mode, starts over HTTPS, and MUST be accessed with explicit protocol https:

https://localhost:8443

After that, when start the application, an error will raise related to invalid certificate. To fix this problem it is necessary to change the default TLS certificate of keycloak, to do that, follow

https://www.keycloak.org/server/enabletls

To create a self signed certificate:

https://www.ibm.com/docs/en/api-connect/2018.x?topic=overview-generating-self-signed-certificate-using-openssl

    openssl req -newkey rsa:2048 -nodes -keyout key.pem -x509 -days 365 -out certificate.pem

The common name should be localhost, so, the fields can be filled so:

    Generating a RSA private key
    .......+++++
    ..........................................+++++
    writing new private key to 'key.pem'
    -----
    You are about to be asked to enter information that will be incorporated
    into your certificate request.
    What you are about to enter is what is called a Distinguished Name or a DN.
    There are quite a few fields but you can leave some blank
    For some fields there will be a default value,
    If you enter '.', the field will be left blank.
    -----
    Country Name (2 letter code) [AU]:BR
    State or Province Name (full name) [Some-State]:
    Locality Name (eg, city) []:
    Organization Name (eg, company) [Internet Widgits Pty Ltd]:
    Organizational Unit Name (eg, section) []:
    Common Name (e.g. server FQDN or YOUR name) []:localhost

The content of the certificate can be viewed with:

    openssl x509 -text -noout -in certificate.pem

After that, as the certificate will be copied to the docker image, we should change the rights of the key file:

    chmod ugo+r+w ./key.pem


To make the application trust the self signed certificate, it's necessary to put the certificate into the trust-store of the jvm, so, 
it's necessary export the PEM format to DER format and then put it into the key store:

https://stackoverflow.com/questions/2138940/import-pem-into-java-key-store

    openssl x509 -outform der -in certificate.pem -out certificate.der

The default password of the jvm trust store is changeit.

### Import

    sudo keytool -import -alias keycloak-local -keystore /usr/lib/jvm/java-11-openjdk-amd64/lib/security/cacerts -file certificate.der

### View the certificate

    keytool -keystore /usr/lib/jvm/java-11-openjdk-amd64/lib/security/cacerts -alias keycloak-local -list

### Delete the certificate

    sudo keytool -keystore /usr/lib/jvm/java-11-openjdk-amd64/lib/security/cacerts -alias keycloak-local -delete

### Start/ Stop

To stop keycloak:

    docker container stop mykeycloak

To start keycloak:

    docker container start mykeycloak




# TODO

Logging environment: ElasticSearch, Logstash and Kibana (ELK Stack)
How to configure LogBack to send logs to ElasticSearch using Logstash and visualizing thru Kibana?

When working with security, see how to handle the access denied: https://www.baeldung.com/exception-handling-for-rest-with-spring#denied

    docker exec -it mykeycloak /bin/bash