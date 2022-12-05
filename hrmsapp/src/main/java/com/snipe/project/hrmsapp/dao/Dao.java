package com.snipe.project.hrmsapp.dao;

import java.sql.Date;
import java.util.List;

import com.snipe.project.hrmsapp.exception.EmployeeException;
import com.snipe.project.hrmsapp.model.Employee;
import com.snipe.project.hrmsapp.model.EmployeeSalary;



public interface Dao {
	    public String login(String user,String pwd) throws EmployeeException;
	 	public void addEmployee(String fname,String lname,String desig,String homeAdd,String contactnum,Date hired,String location,int deptid,float salary,String email) throws EmployeeException;
	 	public void modifyEmployee() throws EmployeeException;
	 	public void modifyDepartment() throws EmployeeException;
	 	public void modifyPayroll() throws EmployeeException;
	 	public void displayEmployeeDetails() throws EmployeeException;
	 	public void displayEmployeesinDept() throws EmployeeException;
		public void displayDepartmentDetails() throws EmployeeException;
		public void displayEmployeeEmail() throws EmployeeException;
		public void displayDepartments() throws EmployeeException;
		public void deleteEmployee()throws EmployeeException;
		List<Employee> dataRows() throws EmployeeException;
		public EmployeeSalary displaySalary(int id) throws EmployeeException;
}
