<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>이름1 : <%=request.getAttribute("name") %></h1> <!-- jsp표현식 -->
<h1>이름2 : ${name}</h1> <!-- EL표현식 -->
</body>
</html>