package com.kh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class postTest
 */
@WebServlet("/postTest")
public class postTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: 요청 한글 인코딩 설정 후 전달된 아이디와 비밀번호를 추출하여 응답 처리하세요.
		// * 요청 파라미터의 인코딩 설정
		response.setCharacterEncoding("UTF-8");
		
		// * 요청 파라미터 추출
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// [응답 출력 형식] <h2>로그인 입력 값: [아이디]</h2>
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h2>로그인 입력 값: [" + userId + "]</h2>");
		
	}

}
