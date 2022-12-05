package com.snipe.project.hrmsapp.service;

import java.sql.Date;
import java.util.List;

import com.snipe.project.hrmsapp.dao.Dao;
import com.snipe.project.hrmsapp.dao.DaoImpl;
import com.snipe.project.hrmsapp.exception.EmployeeException;
import com.snipe.project.hrmsapp.model.Employee;
import com.snipe.project.hrmsapp.model.EmployeeSalary;



public class HrServiceImpl  implements HrService{

	Dao d=new DaoImpl();

	@Override
	public void addEmployee(String fname, String lname, String desig, String homeAdd, String contactnum, Date hired,
			String location, int deptid,float salary,String email) throws EmployeeException {
		// TODO Auto-generated method stub
		d.addEmployee(fname, lname, desig, homeAdd, contactnum, hired, location, deptid,salary,email);
	}

	@Override
	public void modifyEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
         d.modifyEmployee();
	}

	@Override
	public void displayEmployeeDetails() throws EmployeeException {
		// TODO Auto-generated method stub
		d.displayEmployeeDetails();
		//d.dataRows().forEach(System.out::println);
	}

	@Override
	public void displayEmployeesinDept() throws EmployeeException {
		// TODO Auto-generated method stub
           d.displayEmployeesinDept();
	}

	@Override
	public void displayDepartmentDetails() throws EmployeeException {
		// TODO Auto-generated method stub
          //d.displayDepartmentDetails();
	}

	@Override
	public List<Employee> dataRows() throws EmployeeException {
		return d.dataRows();
	}

	@Override
	public void displayEmployeeEmail() throws EmployeeException {
		// TODO Auto-generated method stub
		d.displayEmployeeEmail();
	}

	@Override
	public void displayDepartments() throws EmployeeException {
		// TODO Auto-generated method stub
		d.displayDepartments();
	}

	@Override
	public void deleteEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		d.deleteEmployee();
	}

	@Override
	public void modifyDepartment() throws EmployeeException {
		// TODO Auto-generated method stub
		d.modifyDepartment();
	}

	@Override
	public void modifyPayroll() throws EmployeeException {
		// TODO Auto-generated method stub
		d.modifyPayroll();
	}

	@Override
	public String login(String user, String pwd) throws EmployeeException {
		// TODO Auto-generated method stub
		String s=d.login(user, pwd);
		return s;
	}

	@Override
	public EmployeeSalary displaySalary(int id) throws EmployeeException {
		// TODO Auto-generated method stub
	EmployeeSalary es=d.displaySalary(id);
		return es;
	}

}