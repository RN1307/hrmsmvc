<%@page import="com.snipe.project.hrmsapp.model.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th, td, caption {
	color: #21868c;
}

table.itemlist {
	width: 80%;
}
</style>
</head>

	<%--	<%response.sendRedirect("../DisplayServlet"); %> --%>



	<title>Employee List</title>
</head>
<body bgcolor="#9cc9cc">

	<table border="1" align="center" bgcolor="#e6f2f2" width="100%">
		<caption font-size="18 px">
			<b>EMPLOYEE INFO</b>
		</caption>
		<tr bgcolor="white">
			<th><b>Employee Id</b></th>
			<th><b>First Name</b></th>
			<th><b>Employee Last Name</b></th>
			<th><b>Designation</b></th>
			<%--	<th><b>Salary</b></th>--%>
			<th><b>Email</b></th>
			<th><b>Phone Number</b></th>
			<th><b>Location</b></th>
			<th><b>Home Address</b></th>
			<th><b>Hired Date</b></th>
			<th><b>Department Id</b></th>

		</tr>
		<%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "SaveDetails.java"
        --%>
		<%
		List<Employee> emp = (List<Employee>) request.getAttribute("employees");
		for (Employee e : emp) {
		%>
		<%-- Arranging data in tabular form
        --%>
		<tr>
			<td><%=e.getEmpid()%></td>
			<td><%=e.getFname()%></td>
			<td><%=e.getLname()%></td>
			<td><%=e.getDesig()%></td>
			<%--	<td><%=e.getSalary()%></td> --%>
			<td><%=e.getEmail()%></td>
			<td><%=e.getContactnum()%></td>
			<td><%=e.getLocation()%></td>
			<td><%=e.getHomeAdd()%></td>
			<td><%=e.getHiredDate()%></td>
			<td><%=e.getDeptid()%></td>
		</tr>
		<%
		}
		%>
	</table>
	



</body>
</html>