<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
<link href="EMSStyle.css" rel="stylesheet"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "header">
		<h1>Employee Management System</h1>
	
	</div>
	<br />
	<form action="employee" method="post">
	<div class = "content">
		<table>
        <tr>
            <td>Employee Id</td>
            <td>
                <input type="text" name="eid"></input>
            </td>
        </tr>

        <tr>
            <td>Employee Name</td>
            <td>
                <input type="text" name="ename">
                </input>
            </td>
        </tr>
        <tr>
            <td>Employee Salary</td>
            <td>
                <input type="number" name="esalary">
                </input>
            </td>
        </tr>
        <tr>
            <td>Department Number</td>
            <td>
                <input type="number" name="dno" >
                </input>
            </td>
        </tr>
        
    </table>
    
<br>
<input type="submit" name = "Insert" value="Insert" class = "btn-primary"></input>
&nbsp;
&nbsp;
<input type="submit"  name ="Delete" value="Delete" class ="btn-danger"></input>
&nbsp;
&nbsp;
<input type="submit" name="Update" value="Update" class = "btn-warning"></input>
&nbsp;
&nbsp;
<input type="submit" name="Find" value="Find" class = "btn-success"></input>
&nbsp;
&nbsp;
<input type="submit" name="FindAll" value="FindAll" class = "btn-info"></input>
<br>

	</div>
	</form>
	<br />
	<div>
		<b>${result}</b> <!-- Expression Language -->
	</div>
	
	
</body>
</html>