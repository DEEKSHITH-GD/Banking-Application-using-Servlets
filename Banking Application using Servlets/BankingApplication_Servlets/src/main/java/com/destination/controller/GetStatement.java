package com.destination.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.destination.model.Model;

/**
 * Servlet implementation class GetStatement
 */
@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			ArrayList al = m.getStatement();
			if(al.isEmpty() == true) {
				response.sendRedirect("/BankingApplication_Servlets/StatementFail.html");
			}
			else {
				session.setAttribute("sal", m.sal);
				session.setAttribute("ral", m.ral);
				session.setAttribute("al", m.al);
				response.sendRedirect("/BankingApplication_Servlets/StatementSuccess.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}