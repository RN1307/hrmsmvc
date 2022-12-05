package com.snipe.project.hrmsapp.constants;

public class Constants {

	public static final String DB_URL="jdbc:mysql://localhost/hrdb";
	public static final String DB_USERNAME="root";
	public static final String DB_PWD="Krishn@123";
	public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String SQL_INSERT_TBL="insert into employee(firstname,lastname,desig,homeAadd,contactnum,hiredDate,location,deptId,email)values(?,?,?,?,?,?,?,?,?)";
	public static final String SQL_SELECT_TBL="select emp_id,firstname,lastname,desig,homeAadd,contactnum,hiredDate,location,deptId,email from employee";
	public static final String SQL_INSERT_TBL_PAYROLL="insert into payroll(emp_id,basic_salary,hra,da,ta)values(?,?,?,?,?)";
	public static final String SQL_SELECT_TBL_DEPT="select dname from department";
	public static final String SQL_DELETE_TBL_PAYROLL="delete from payroll where emp_id=?";
	public static final String SQL_DELETE_TBL_EMPLOYEE="delete from employee where emp_id=?";
	public static final String SQL_UPDATE_TBL_EMPLOYEE="update employee set desig =? where emp_id=?";
	public static final String SQL_UPDATE_TBL_DEPT="update department set dname =? where deptId=?";
	public static final String SQL_UPDATE_TBL_PAYROLL=" update payroll set basic_salary=?,hra=0.2*basic_salary,da=0.18*basic_salary,ta=0.15*basic_salary where emp_id=?";
	public static final String SQL_SELECT_TBL_USER="select username,password,role from user";
	public static final String SQL_DISPLAY_TBL_EMPPAY="SELECT employee.emp_id,employee.firstname,employee.lastname,payroll.basic_salary,payroll.hra,payroll.da,payroll.ta \r\n"
			+ "FROM  employee INNER JOIN payroll ON employee.emp_id=payroll.emp_id  and employee.emp_id=?";
		



}