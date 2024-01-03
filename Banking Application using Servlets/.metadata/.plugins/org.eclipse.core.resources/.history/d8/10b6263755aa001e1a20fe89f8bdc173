package com.destination.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.destination.model.Model;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");//sender
		String samt = request.getParameter("amt");
		int amt = Integer.parseInt(samt);
		String sraccno = request.getParameter("raccno");
		int raccno = Integer.parseInt(sraccno);//receiver
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setRaccno(raccno);
			m.setAmt(amt);
			boolean b = m.transfer();
			if(b==true) {
				response.sendRedirect("/BankingApplication_Servlets/TransferSuccess.html");
			}
			else {
				response.sendRedirect("/BankingApplication_Servlets/TransferFail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
