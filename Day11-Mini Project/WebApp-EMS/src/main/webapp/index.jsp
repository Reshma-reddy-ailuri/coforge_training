<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link rel="stylesheet" href="EMSStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
	<script src="./AjaxScript.js"></script>
</head>
<body>
	<div class="header">
		<h1>Employee Management System</h1>
	</div>
	<br />
	<form action="EmployeeController" method="POST">
		<div class="content">
			<table>
				<tr>
					<td>Employee id</td>
					<td><input type="text" id="eid" name="eid" onblur="getEmployeeDetails()"/></td>
				</tr>

				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="ename" id="ename"/></td>
				</tr>
				<tr>
					<td>Employee Salary</td>
					<td><input type="text" name="esalary" id="esalary"/></td>
				</tr>

				<tr>
					<td>Employee DeptNo</td>
					<td><input type="text" name="dno" id="dno"/></td>
				</tr>
			</table>
			<br /> 
			<input type="submit" value="Insert" class="btn btn-primary" name="emsButton"/>
			<input type="submit" value="Update" class="btn btn-warning" name="emsButton" />
			<input type="submit" value="Delete" class="btn btn-danger" name="emsButton"/> 
			<input type="submit" value="Find" class="btn btn-info" name="emsButton"/> 
			<input type="submit" value="FindAll" class="btn btn-info" name="emsButton"/> <br />
			<br />
		</div>
	</form>
	
	 <div class="alert alert-primary">
	  <font align="center"><b><%=request.getParameter("result")%></b></font>
	 </div>
</html>