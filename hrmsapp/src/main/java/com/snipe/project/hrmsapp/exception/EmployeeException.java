package com.snipe.project.hrmsapp.exception;

public class EmployeeException extends Exception{
	private String errorCode;
	public EmployeeException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeException(String errorCode) {
		super(errorCode);

	}
	public EmployeeException(String message,Throwable cause,String errorCode) {
		super(message);
		this.errorCode=errorCode;
	}
	public EmployeeException(Throwable cause,String errorCode) {
		super(cause);
		this.errorCode=errorCode;
	}
	public EmployeeException(String message,String errorCode) {
		super(message);
		this.errorCode=errorCode;
	}
}
