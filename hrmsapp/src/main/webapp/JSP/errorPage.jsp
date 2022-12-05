<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body bgcolor="#9cc9cc">


<%
try{
String role=(String)request.getAttribute("role");

   if(role.equals("none"))
	   out.println("Enter a valid username and password:");
   else if(role.equals("empty"))
	   out.println("Enter a valid employee id:");
   else if (role==null)
	 out.println("Unknown error");
}
catch(Exception e){
	e.printStackTrace();
	
}
%>




</body>
</html>