package com.kh.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveSession
 */
@WebServlet("/sessionSave")
public class SaveSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		session.setAttribute("nickname", request.getParameter("nickname"));
		session.setAttribute("tel", request.getParameter("tel"));
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h2>세션 정보 저장 완료</h2>");
	}

}
