
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
    background:#9cc9cc;
}

/* Style the header */
header {
   background-color: #21868c;
  background-image: linear-gradient(45deg,#21868c,#e6f2f2);
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 300px; /* only for demonstration, should be removed */
  background:#9cc9cc;
 
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #e6f2f2;
  height: auto; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section::after {
  content: "";
  display: table;
  clear: both;
}

label,a{
color:#21868c;
 font-family: Arial, Helvetica, sans-serif;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
   article {
    width: 100%;
    height: auto;
  }
  nav{
   width: 100%;
   height:100%;
  }
}
#emp_details {
font-size:18 px;
color:#21868c;

}

</style>
</head>
<body>


<header>
  <h2>WELCOME TO HRMS SERVICES </h2>
</header>

<section>
  <nav>
    <ul>
      <li><a href="#saveform">Save Employee Details</a></li>
      <li><a href="./DisplayServlet" target="_self">View Employees</a></li>
      <li><a href="./JSP/displaySalary.jsp">View Salary</a></li>
      <li><a href="#">View By Department</a></li>
      <li><a href="#">View email</a></li>
      <li><a href="#">Update Employee Department</a></li>
      <li><a href="#">Update Employee Salary</a></li>
      <li><a href="#">Delete Employee</a></li>
    </ul>
  </nav>
  
  <article id="saveform">
    <form name="detailsForm" method="post" action="./SaveDetails">


		<table>
			<caption id="emp_details">
				<b>EMPLOYEE DETAILS</b>
			</caption>
			<tr>
				<td><label for="fname">First name:</label></td>
				<td><input type="text" id="fname" name="firstname"></td>
			</tr>

			<tr>
				<td><label for="lname">Last name:</label></td>
				<td><input type="text" id="lname" name="lastname"></td>
			</tr>
			<tr>
				<td><label for="designation">Designation:</label></td>
				<td><input type="text" id="desig" name="desig"></td>
			</tr>
			<tr>
				<td><label for="homeaddress">Home Address:</label></td>
				<td><textarea name="hadd" rows="10" cols="30"></textarea></td>
			</tr>
			<tr>
				<td><label for="contactnum">Contact Number:</label></td>
				<td><input type="number" id="cnum" name="contactnum"></td>
			</tr>
			<tr>
				<td><label for="doj">Date Of Joining:</label></td>
				<td><input type="date" id="doj" name="hireddt"></td>
			</tr>
			<tr>
				<td><label for="location">Location:</label></td>
				<td><select id="locate" name="loc">
						<option value="Bangalore">Bangalore</option>
						<option value="Kolkata">Kolkata</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Kochi">Kochi</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="deptid">Department Id:</label></td>
				<td><input type="number" id="depId" name="deptId"></td>
			</tr>
			<tr>
				<td><label for="salary">Salary:</label></td>
				<td><input type="number" id="sal" name="salary"></td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="text" id="mailid" name="email"></td>
			</tr>
			<tr>
			<td colspan="4" align="center"><input type="submit" value="submit">   <input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
</article>
</section>


</body>
</html>
