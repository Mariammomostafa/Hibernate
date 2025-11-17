# Java Hibernate project
- It's maven project using ORM's tool Hibernate to apply Data base operations
- Write all Data Base connection info inside hibernate.cfg.xml file
- create Configuration obj based on xml file
- create SessionFactory from configuration obj
- open Session from SessionFactory obj
- This project show how to make cache global for all sessions NOT specific to one session like first-level-cache
- second-level-cache NOT provided by default by Hibernate , it needs configuration
    - add two dependencies :
      -  hibernate-ehcache for the integration between Hibernate
      -  hibernate-ehcache & hibernate-core versions SHOULD be the same
      -   ehcache - ehcache-core to provide features
    -  In hibernate.cfg.xml file :
        - enable second-level-cache
        - mention who is the provider
- when get the same data in 2 different session , ONLY one select query will be executed due to second sesson will get the same data from second-level-cache which is global for all sessions & NOT hit the data base


### Prerequisites
- Java 17
- hibernate-core 5.4.29.Final
- hibernate-ehcache 5.4.29.Final
- ehcache-core 2.4.3
- mysql-connector-j 8.3.0
- IDE (Eclips)
