# OrderMicroservice


# Mysql Database configuration
OrderMicroservice\src\main\resources\application.properties

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/orderapi
spring.datasource.username=${MYSQL_USER:root}
spring.datasource.password=${MYSQL_PASSWORD:root}
spring.jpa.show-sql=true


spring.graphql.graphiql.enabled=true


# Maven Build
mvn install
mvn spring-boot:run

