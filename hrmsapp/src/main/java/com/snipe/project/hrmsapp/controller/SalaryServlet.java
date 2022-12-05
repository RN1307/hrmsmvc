package com.snipe.project.hrmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snipe.project.hrmsapp.exception.EmployeeException;
import com.snipe.project.hrmsapp.model.EmployeeSalary;
import com.snipe.project.hrmsapp.service.HrService;
import com.snipe.project.hrmsapp.service.HrServiceImpl;
import java.util.Optional;
/**
 * Servlet implementation class SalaryServlet
 */
public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryServlet() {
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
		String empid=request.getParameter("empid");	
		int id=Integer.parseInt(empid);
		try {
			EmployeeSalary es=h.displaySalary(id);
			
			 if(es.getEmpId()==0){
					String empty="empty";
					System.out.println(empty);
					request.setAttribute("role", empty);
					request.getRequestDispatcher("./JSP/errorPage.jsp").forward(request, response);

				}
			 else
			 {
				request.setAttribute("empSal",es);
				request.getRequestDispatcher("./JSP/displaySalary.jsp").forward(request, response);
			}
		

		}catch (EmployeeException e) {
			// TODO Auto-generated catch block
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
