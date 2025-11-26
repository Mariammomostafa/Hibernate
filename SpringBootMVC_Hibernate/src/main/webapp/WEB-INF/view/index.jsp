<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome to Spring Boot Demo</h1>

<h2>Register Syudent </h2>
<form action = "addStudent" method="post">
  
  
  Enter your name :  <input type="text"  name="name"><br><br>
  Enter your marks :  <input type="text"  name="marks"><br><br>
  
  <input type="submit"  value="add">
</form>

<hr>

<h2>Fetch Student </h2>

<form action="getStudent">
 Enter your ID : <input type="text"  name="id"><br><br>
 <input type="submit"  value="get">
</form>

<hr>
<h2>Fetch All Students</h2>
<form action="getAllStudents">
 Click Here : 
 <input type="submit"  value="get">
</form>

</body>
</html>