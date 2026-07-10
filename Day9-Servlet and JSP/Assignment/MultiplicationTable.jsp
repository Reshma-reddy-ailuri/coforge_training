<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% int n = Integer.parseInt(request.getParameter("num"));%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Table of <%=n %></h2>
	<table border="1">
	<% for(int i=1;i<=n;i++) { %>
	<tr>
	<td>
	<%=n %> x <%=i %> = <%=n*i %>
	</td>
	</tr>
	<%}
		%>
	</table>

</body>
</html>