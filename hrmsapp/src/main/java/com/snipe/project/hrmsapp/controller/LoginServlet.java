package com.snipe.project.hrmsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.snipe.project.hrmsapp.exception.EmployeeException;
import com.snipe.project.hrmsapp.service.HrService;
import com.snipe.project.hrmsapp.service.HrServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		System.out.println("username::"+username+"password::"+password);
		HrService srv=new HrServiceImpl();
		try {
			String role=srv.login(username, password);
			if(role.equals("none"))
				{
				request.setAttribute("role", role);
				request.getRequestDispatcher("./JSP/errorPage.jsp").forward(request, response);
				}
			else if(role.equals("admin"))
				request.getRequestDispatcher("./JSP/adminpage.jsp").forward(request, response);
			else if(role.equals("user"))	
				request.getRequestDispatcher("./JSP/login_successuser.jsp").forward(request, response);
		} catch (EmployeeException e) {
			e.printStackTrace();
			//request.getRequestDispatcher("./JSP/errorPage.jsp").forward(request, response);
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
