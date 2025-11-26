# Spring MVC Hibernate project 

- This is spring MVC project which uses Hibernate framework to connect to dataBase 
- use spring ORM dependency to integrate Hibernate with Spring
- create config class which contains :
    - bean of DataSource (connection pool)
    - beans of SessionFactory and TransactionManager
- create Dao layer which use session to apply CRUD operations to save & retrieve data to/from Data Base
- use @Transactional which provided by Spring to manage database transactions declaratively.


### Prerequisites
- Java 17
- spring-webmvc  6.2.11
- spring-orm 6.2.11
- hibernate-core 6.2.11.Final
- mysql-connector-j 8.3.0
- c3p0 0.9.5.5
- jakarta.servlet.jsp.jstl 3.0.1
- jakarta.servlet.jsp.jstl-api 3.0.0
- IDE (Eclips)
