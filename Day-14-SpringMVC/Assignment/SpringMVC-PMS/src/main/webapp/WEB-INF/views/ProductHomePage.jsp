<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "header">
		<h1>Product Management System</h1>
	
	</div>
	<br />
	<form action="product" method="post">
	<div class = "content">
		<table>
        <tr>
            <td>Product Id</td>
            <td>
                <input type="text" name="pid"/>
            </td>
        </tr>

        <tr>
            <td>Product Name</td>
            <td>
                <input type="text" name="pname" class="form-control"/>
            </td>
        </tr>
        <tr>
            <td>Product Price</td>
            <td>
                <input type="number" step="0.01" name="price" class="form-control"/>
            </td>
        </tr>
        <tr>
            <td>Product Quantity</td>
            <td>
                <input type="number" name="quantity" class="form-control"/>
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