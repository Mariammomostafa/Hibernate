# Java Hibernate project
- this project show the different between both of fetch types : Lazy & Eager
- we have two Entities Student & Laptop & want to fetch each student with related laptop
- Lazy Fetch :
   - it'll fetch student obj first & later when we want laptop , it'll fire select query to fetch them
- Eager Fetch :
   - it'll fetch student with related laptop in the same select query

 ### Prerequisites
- Java 17
- hibernate-core 4.0.0.Final
- mysql-connector-j 8.3.0
- IDE (Eclips)
