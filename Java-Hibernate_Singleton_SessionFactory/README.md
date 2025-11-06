# Java Hibernate project
- It's maven project using ORM's tool Hibernate to apply Data base operations
- Write all connection info inside hibernate.cfg.xml file
- create Configuration file based on xml file
- create SessionFactory from configuration obj
- open Session from SessionFactory obj
- Despite of create new connection each time call Data Base
    - create Utility class to enable us create ONLY one SessionFactory which contains Only one connection to DB
    - use Singleton Design Pattern to check each call if we already have sessionFactory to return it or create new one
- Using Log4j with Hibernat efor debugging database issues, monitoring SQL queries & track the application behavior

   ### Prerequisites
- Java 8
- hibernate-core 7.0.6.Final
- mysql-connector-j 8.3.0
- for Logging :
    - slf4j-api 1.7.30
    - slf4j-log4j12  1.7.30
    - log4j 1.2.17
   
- IDE (Eclips)
