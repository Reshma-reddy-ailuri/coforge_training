<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--JSP DECLARATION TAG --%>
	<%!
	String name = "Reshma";
	int a = 10,b = 20;
	%>
<%--JSP SCRIPTLET TAG --%>
	<%
	out.println("<br> Welcome" +name);
	if(a>b) {
		out.println("<br> a is Big Element");
	} else {
		out.println("<br> b is Big Element");
	}
	int sum=a+b;
	%>
<br>
<%--out is the implicit object in JSP --%>

<%--JSP EXPRESSION TAG --%>
sum = <%=sum %>	 <!-- to display result we can use out.println or jsp expression tag -->
	
</body>
</html>