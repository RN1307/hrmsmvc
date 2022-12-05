package com.snipe.project.hrmsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.snipe.project.hrmsapp.constants.Constants;
import com.snipe.project.hrmsapp.exception.EmployeeException;
import com.snipe.project.hrmsapp.exception.ErrorCode;
import com.snipe.project.hrmsapp.model.Employee;
import com.snipe.project.hrmsapp.model.EmployeeSalary;
import com.snipe.project.hrmsapp.model.Employee;

import java.sql.Date;

public class DaoImpl implements Dao{

	@Override
	public void addEmployee( String fname, String lname, String desig, String homeAdd, String contactnum,
			Date hired, String location,int deptid,float salary ,String email) throws EmployeeException {
		// TODO Auto-generated method stub
		Connection conn=null; int key=1;
		try {

			conn=Connect.getConnection();
			Statement stmt=conn.createStatement();

			PreparedStatement ps=conn.prepareStatement(Constants.SQL_INSERT_TBL,java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,desig);
			ps.setString(4,homeAdd);
			ps.setString(5,contactnum);
			ps.setDate(6,hired);
			ps.setString(7,location);
			ps.setInt(8,deptid);
			ps.setString(9,email);
			int count=ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				key=rs.getInt(1);
			}
			System.out.println("Added to employee:"+count);

			System.out.println("key generated"+key);
			PreparedStatement ps1=conn.prepareStatement(Constants.SQL_INSERT_TBL_PAYROLL);
			ps1.setInt(1,key);
			ps1.setFloat(2,salary);
			float hra=(float) (salary*0.2);
			float ta=(float)(salary*0.15);
			float da=(float)(salary*0.18);
			ps1.setFloat(3,hra);
			ps1.setFloat(4, da);
			ps1.setFloat(5, ta);
			int count1=ps1.executeUpdate();
			System.out.println("Added to payroll:"+count);



		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new EmployeeException(e,ErrorCode.LOAD_DRIVER_ERROR);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e,ErrorCode.SQL_INSERT_ERROR);

		}catch(Exception e) {
			throw new EmployeeException(e,ErrorCode.SQL_UNKNOWN_ERROR);
		}


	}

	@Override
	public void modifyEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter id of employee to be updated:");
		int empid=scan.nextInt();
		System.out.println("Enter the new designation of employee:");
		scan.nextLine();
		String desig=scan.nextLine();

		PreparedStatement ps1=createPreparedStatement(Constants.SQL_UPDATE_TBL_EMPLOYEE);

		try {
			ps1.setString(1,desig);
			ps1.setInt(2, empid);
			int count=ps1.executeUpdate();
			System.out.println("UPDATED ROWS :"+count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void displayEmployeeDetails() throws EmployeeException {
		// TODO Auto-generated method stub
		try {

			PreparedStatement ps=createPreparedStatement(Constants.SQL_SELECT_TBL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				int empid=rs.getInt(1);
				e.setEmpid(empid);
				String fname=rs.getString(2);
				e.setFname(fname);
				String lname=rs.getString(3);
				e.setLname(lname);
				String desig=rs.getString(4);
				e.setDesig(desig);
				String homeAdd=rs.getNString(5);
				e.setHomeAdd(homeAdd);
				String contactnum=rs.getString(6);
				e.setContactnum(contactnum);
				Date hiredDate=rs.getDate(7);
				e.setHiredDate(hiredDate);
				String location=rs.getString(8);
				e.setLocation(location);
				int deptId=rs.getInt(9);
				e.setDeptid(deptId);
				String email=rs.getString(10);
				e.setEmail(email);
				System.out.println("Employee Id:"+e.getEmpid()+"First Name:"+e.getFname()+" Last Name: "+e.getLname()+"Email:"+e.getEmail()+" Designation: "+e.getDesig()+" Home Address:"+e.getHomeAdd()+" Contact No: "+e.getContactnum()+" HiredDate:"+e.getHiredDate()+" Location: "+e.getLocation()+" Dept Id: "+e.getDeptid());

			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e,ErrorCode.SQL_INSERT_ERROR);

		}catch(Exception e) {
			throw new EmployeeException(e,ErrorCode.SQL_UNKNOWN_ERROR);
		}
		//return records;
	}



	@Override
	public void displayEmployeesinDept() throws EmployeeException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		List<Employee> records=dataRows();
		Stream<Employee> s=records.stream();
		System.out.println("Enter department id");
		int did=scan.nextInt();
		List<Employee> filtered=s.filter(e->(e.getDeptid()==did)).collect(Collectors.toList());
	    filtered.forEach(System.out::println);

	}

	@Override
	public void displayDepartmentDetails() throws EmployeeException {

		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> dataRows() throws EmployeeException {
		// TODO Auto-generated method stub

		List<Employee> records=new ArrayList<Employee>();
		try {
			PreparedStatement ps=createPreparedStatement(Constants.SQL_SELECT_TBL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				int emp_id=rs.getInt(1);
				e.setEmpid(emp_id);
				String fname=rs.getString(2);
				e.setFname(fname);
				String lname=rs.getString(3);
				e.setLname(lname);
				String desig=rs.getString(4);
				e.setDesig(desig);
				String homeAdd=rs.getNString(5);
				e.setHomeAdd(homeAdd);
				String contactnum=rs.getString(6);
				e.setContactnum(contactnum);
				Date hiredDate=rs.getDate(7);
				e.setHiredDate(hiredDate);
				String location=rs.getString(8);
				e.setLocation(location);
				int deptId=rs.getInt(9);
				e.setDeptid(deptId);
				String email=rs.getString(10);
				e.setEmail(email);
				records.add(e);


			}



		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e,ErrorCode.SQL_INSERT_ERROR);

		}catch(Exception e) {
			throw new EmployeeException(e,ErrorCode.SQL_UNKNOWN_ERROR);
		}
		return records;
	}

	@Override
	public void displayEmployeeEmail() throws EmployeeException {
		// TODO Auto-generated method stub
		try{
			List<Employee> records=dataRows();
			Stream<Integer> semployeeid=records.stream().map(e->e.getEmpid());
			Stream semployeemail=records.stream().map(e->e.getEmail());
			HashMap<Integer,String> idEmail=(HashMap<Integer,String>)records.stream().collect(Collectors.toMap(e->e.getEmpid(),e->e.getEmail()));
			System.out.println("EMPLOYEE ID\tEMPLOYEE EMAIL");
			for(Entry<Integer, String> m :idEmail.entrySet()){

				System.out.println(m.getKey()+"\t\t"+m.getValue());
			}
		}
		catch(Exception e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	public PreparedStatement createPreparedStatement(String sql) throws EmployeeException {
		PreparedStatement ps=null;
		try{
			Connection conn=Connect.getConnection();
			ps=conn.prepareStatement(sql);
		}catch(Exception e) {
			throw new EmployeeException(e.getMessage()) ;


		}
		return ps;
	}

	@Override
	public void displayDepartments() throws EmployeeException {
		// TODO Auto-generated method stub
		PreparedStatement ps1=createPreparedStatement(Constants.SQL_SELECT_TBL_DEPT);
		try {
			ResultSet rs=ps1.executeQuery();
			System.out.println("DEPARTMENT NAME");
			while(rs.next()) {

				String depName=rs.getString(1);
				System.out.println(depName);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter id of employee to be deleted:");
		int empid=scan.nextInt();
		PreparedStatement ps1=createPreparedStatement(Constants.SQL_DELETE_TBL_PAYROLL);
		PreparedStatement ps2=createPreparedStatement(Constants.SQL_DELETE_TBL_EMPLOYEE);
		try {
			ps1.setInt(1, empid);
			int count=ps1.executeUpdate();
			System.out.println("DELETED EMPLOYEE FROM PAYROLL"+count);
			ps2.setInt(1, empid);
			int count1=ps2.executeUpdate();
			System.out.println("DELETED EMPLOYEE FROM EMPLOYEE"+count1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException(ErrorCode.SQL_DELETION_ERROR) ;

		}

	}

	@Override
	public void modifyDepartment() throws EmployeeException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter id of department to be updated:");
		int did=scan.nextInt();
		System.out.println("Enter new name of department :");
		scan.nextLine();
		String dname=scan.nextLine();

		PreparedStatement ps1=createPreparedStatement(Constants.SQL_UPDATE_TBL_DEPT);

		try {
			ps1.setString(1,dname);
			ps1.setInt(2,did);
			int count=ps1.executeUpdate();
			System.out.println("UPDATED ROWS :"+count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException(ErrorCode.SQL_UPDATION_ERROR) ;

		}
		finally {
			scan.close();
		}
	}

	@Override
	public void modifyPayroll() throws EmployeeException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter id of employee to be updated:");
		int eid=scan.nextInt();
		System.out.println("Enter modified  :");

		float salary=scan.nextFloat();

		PreparedStatement ps1=createPreparedStatement(Constants.SQL_UPDATE_TBL_PAYROLL);

		try {
			ps1.setFloat(1,salary);
			ps1.setInt(2,eid);
			int count=ps1.executeUpdate();
			System.out.println("UPDATED ROWS :"+count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException(ErrorCode.SQL_UPDATION_ERROR) ;

		}
		finally {
			scan.close();
		}

	}
	public EmployeeSalary displaySalary(int id) throws EmployeeException{
		PreparedStatement ps=createPreparedStatement(Constants.SQL_DISPLAY_TBL_EMPPAY);
		EmployeeSalary es=new EmployeeSalary();
		try {
		
			Scanner s=new Scanner(System.in);
			int empid=0;int eid=0;
			String fname=null;
			String lname=null;
			float basic=0,hra=0,da=0,ta=0;
			boolean isPresent=false;

			//System.out.println("Enter employee id :");
			eid=id;
			ps.setInt(1, eid);
			//System.out.println(ps);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				isPresent=true;
				empid=rs.getInt(1);
				es.setEmpId(empid);
				fname=rs.getString(2);
				es.setFirstName(fname);
				lname=rs.getString(3);
				es.setLastName(lname);
				basic=rs.getFloat(4);
				es.setBasicpay(basic);
				hra=rs.getFloat(5);
				es.setHra(hra);
				da= rs.getFloat(6);
				es.setDa(da);
				ta=rs.getFloat(7);
				es.setTa(ta);

			}

			if(isPresent) {
				System.out.println("\tEMPLOYEE ID::"+empid+"\tFIRST NAME::"+fname+"\tLAST NAME::"+lname+"\tBASIC ::"+basic+"\tHRA::"+hra+"\tDA::"+da+"\tTA::"+ta);
	
			}else {
				System.out.println("Enter valid employee id");
			    	
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(ErrorCode.SQL_UNKNOWN_ERROR);
		}
	return es;
	}


	@Override
	public String login(String user, String pwd) throws EmployeeException {
		// TODO Auto-generated method stub
		String s="none";

		try {
			PreparedStatement ps=createPreparedStatement(Constants.SQL_SELECT_TBL_USER);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(user)&&rs.getString(2).equals(pwd))
				{
					 s=rs.getString(3);
					 break;
				}
		        }
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(ErrorCode.SQL_UNKNOWN_ERROR);
		}
		
		return s;
	}}


