package com.kh.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.mvc.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		String sql ="DELETE FROM MEMBER WHERE ID = ?";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			
			if(result != 0) {
				System.out.println(result + "행 삭제되었습니다.");
			} else {
				System.out.println("삭제되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/mvc/member/list");
		
	}
}