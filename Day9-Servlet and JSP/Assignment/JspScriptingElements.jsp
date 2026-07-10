<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language = "java" %>
    <%!
    String college = "coforge Training";
    public int square(int n) {
    	return n*n;
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Declaration</h2>
	College: <%= college %>
	<br> <br>
	<h2>Scriptlet</h2>
	<%
	int a =20;
	int b =30;
	int sum = a+b;
	out.println("Sum:" +sum);
	%>
	<br> <br>
	
	<h2>Expression</h2>
	
	Square of 8: <%=square(8) %>
</body>
</html>