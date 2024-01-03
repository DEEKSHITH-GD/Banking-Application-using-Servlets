package com.destination.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.destination.model.Model;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");		
		String pwd = request.getParameter("pwd");
		
		String sbal = request.getParameter("bal");//Collects the data in form of string
		int bal = Integer.parseInt(sbal);//Converts String data to int data
		
		String email = request.getParameter("email");
		
		try {
			Model m = new Model();
			m.setName(name);
			m.setPwd(pwd);
			m.setBal(bal);
			m.setEmail(email);
			
			boolean b = m.register();
			
			if(b==true) {
				response.sendRedirect("/BankingApplication_Servlets/RegistrationSuccess.html");
			}
			else {
				response.sendRedirect("/BankingApplication_Servlets/RegistrationFail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
