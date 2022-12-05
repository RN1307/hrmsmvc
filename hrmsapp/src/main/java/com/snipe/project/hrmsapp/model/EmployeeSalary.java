package com.snipe.project.hrmsapp.model;

public class EmployeeSalary {

	private int empId;
	private String firstName;
	private String lastName;
	private float basicpay;
	private float hra;
	private float da;
	private float ta;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getBasicpay() {
		return basicpay;
	}
	public void setBasicpay(float basicpay) {
		this.basicpay = basicpay;
	}
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	public float getDa() {
		return da;
	}
	public void setDa(float da) {
		this.da = da;
	}
	public float getTa() {
		return ta;
	}
	public void setTa(float ta) {
		this.ta = ta;
	}
	@Override
	public String toString() {
		return "EmployeeSalary [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", basicpay="
				+ basicpay + ", hra=" + hra + ", da=" + da + ", ta=" + ta + "]";
	}
	
	
}
