<%@page import="java.util.Optional"%>
<%@page import="com.snipe.project.hrmsapp.model.EmployeeSalary"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="./errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
label {
	color: #21868c;
	font-family: Arial, Helvetica, sans-serif;
}

table {
	border: 1;
	align: center;
	bgcolor: #e6f2f2;
	width: 100%;
}
</style>
<title>Insert title here</title>
</head>
<body bgcolor="#9cc9cc">
	<form method="post" action="../SalaryServlet">
		<label for="id">Enter employee id:</label><input type="number"
			name="empid" />
        <input type="submit" value="confirm" name="submit">
	</form>

	<%
	   String x= request.getParameter("submit");

	      try{
			 EmployeeSalary e =  (EmployeeSalary)request.getAttribute("empSal");
			 Optional checkNull=Optional.ofNullable(e);
			 if(checkNull.isPresent() && x.equals("confirm")){
		%>
	<table>
		<caption font-size="18 px">
			<b>EMPLOYEE INFO</b>
		</caption>
		<tr bgcolor="white">
			<th><b>Employee Id</b></th>
			<th><b>First Name</b></th>
			<th><b>Last Name</b></th>
			<th><b>Basic Salary</b></th>
			<th><b>HRA</b></th>
			<th><b>DA</b></th>
			<th><b>TA</b></th>
			<th><b>TOTAL</b></th>
		</tr>
		<%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "SaveDetails.java"
        --%>

		<%-- Arranging data in tabular form
        --%>
		<tr>
			<td><%=e.getEmpId()%></td>
			<td><%=e.getFirstName()%></td>
			<td><%=e.getLastName()%></td>
			<td><%=e.getBasicpay() %></td>
			<td><%=e.getHra()%></td>
			<td><%=e.getDa()%></td>
			<td><%=e.getTa()%></td>
             <td><%=e.getTa()+e.getDa()+e.getHra()+e.getBasicpay()%></td>
		</tr>

	</table>




	<%}else
		out.println("ENTER A VALID ID");
	      }
	      
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
			 %>


</body>
</html>