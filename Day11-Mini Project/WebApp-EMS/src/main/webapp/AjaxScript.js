
function getEmployeeDetails() {
	var eid = document.getElementById("eid").value;

	var req = new XMLHttpRequest();
	
		
	req.open("GET","EmployeeController?eid="+eid,true);	

	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var result = req.responseText;
			var arr = result.split(" ");
			document.getElementById("ename").value = arr[0];
			document.getElementById("esalary").value = arr[1];
			document.getElementById("dno").value = arr[2];
		}
	}
	req.send();
}