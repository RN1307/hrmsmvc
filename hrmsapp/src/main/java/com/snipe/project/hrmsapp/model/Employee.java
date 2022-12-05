package com.snipe.project.hrmsapp.model;

import java.sql.Date;

public class Employee {
	private int empid;
	private String fname;
	private String lname;
	private String desig;
	private String homeAdd;
	private String contactnum;
	private Date hiredDate;
	private String location;
	private int deptid;
	private float salary;
	private String email;

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getHomeAdd() {
		return homeAdd;
	}
	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}
	public String getContactnum() {
		return contactnum;
	}
	public void setContactnum(String contactnum) {
		this.contactnum = contactnum;
	}
	public Date getHiredDate() {
		return hiredDate;
	}
	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDeptid() {
		return deptid;
	}
	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", desig=" + desig + ", homeAdd=" + homeAdd
				+ ", contactnum=" + contactnum + ", hiredDate=" + hiredDate + ", location=" + location + ", deptid="
				+ deptid + "]";
	}
	public void setDeptid(int deptId2) {
		this.deptid = deptId2;
	}
}
