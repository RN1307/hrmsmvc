package com.snipe.project.hrmsapp.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snipe.project.hrmsapp.exception.EmployeeException;
import com.snipe.project.hrmsapp.service.HrService;
import com.snipe.project.hrmsapp.service.HrServiceImpl;

/**
 * Servlet implementation class SaveDetails
 */
public class SaveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HrService h=new HrServiceImpl();
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String des=request.getParameter("desig");
		String addr=request.getParameter("hadd");
		String num=request.getParameter("contactnum");
		String dt=request.getParameter("hireddt");
		Date d=Date.valueOf(dt);
		String l=request.getParameter("loc");
		String dId=request.getParameter("deptId");
		int did=Integer.parseInt(dId);
		String sal=request.getParameter("salary");
		float sl=Float.parseFloat(sal);
		String mail=request.getParameter("email");
		
		System.out.println(fname+" "+lname+" "+des+" "+addr+" "+num+" "+d+" "+l+" "+did+" "+" "+sl+" "+mail);
		try {
			h.addEmployee(fname, lname, des, addr, num, d, l, did, sl, mail);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
