# Java Hibernate project
- It's maven project using ORM's tool Hibernate to apply Data base operations
- Write all Data Base connection info inside hibernate.cfg.xml file
- create Configuration obj based on xml file
- create SessionFactory from configuration obj
- open Session from SessionFactory obj
- this project show how first-level-cache provided by Hibernat can save data to prevent hit the database again for the get the same data
- first-level-cache is specific for each session
- single session can query the same data many times will hit data base ONLY once & get data with execute single select query
- two sessions will execute two select query to fetch the same data many times , one query for each session

### Prerequisites
- Java 17
- hibernate-core 4.2.8.Final
- mysql-connector-j 8.3.0
- IDE (Eclips)
