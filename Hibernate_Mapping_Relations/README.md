#  Java Hibernate project

- It's maven project using ORM's tool Hibernate to apply Data base operations
- Write all Data Base connection info inside hibernate.cfg.xml file
- create Configuration obj based on xml file
- create SessionFactory from configuration obj
- open Session from SessionFactory obj
- two Entities ( Student & laptop)
- this project show differen relationship between relations in dataBase :
    - One-To-One
      - where one student has ONLY one laptop & one laptop belongs to ONLY one student 
    - One-To-Many & Many-To-One
        - where one student has many laptop & also many laptops belongs to ONLY one student
    - Many-To-Many
        - where many students have many laptops & many laptops belongs to many students

    ### Prerequisites
- Java 17
- hibernate-core 4.0.0.Final
- mysql-connector-j 8.3.0
- IDE (Eclips)
