package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTest {
	/*
	 * * Read (데이터 조회) => 회원 정보 조회, 검색 등과 같이 저장된 데이터를 조회하는 기능
	 * * --> SQL (DQL) SELECT 사용!
	 */
	
	
	public static void main(String[] args) {
		// * MEMBER 테이블 전체 조회
		String sql = "SELECT * FROM MEMBER ORDER BY ID";
		
		try( Connection conn = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)){
			
//			System.out.println("접속 성공 !! ");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// DQL(SELECT) 실행 시 executeQuery() 호출
			// 조회 결과는 ResultSet 객체로 반환됨!
			ResultSet rset = pstmt.executeQuery();
			// * 커서 기반의 객체로 조회 결과를 가리키고 있음.
			// 		처음에는 첫 번째 행이 아니라, 첫 행 바로 위를 가리키고 있음.
			
			// * 조회 결과가 있는 지 확인 : next() 호출
			
			// 현재 쿼리문의 결과 행은 1개 이상 => 반복문 사용
			while (rset.next()) {
				/*
				 * * rset.next() : 커서를 다음 행으로 한 칸 이동시키면서,
				 * 					이동한 위치에 데이터(행)가 존재하면 true를 반환
				 * 					데이터가 없으면 false를 반환
				 */
				
				/*
				 * * rset.getXXX(컬럼명 또는 컬럼순번)
				 * 		: 현재 커서가 위치한 행에서 지정한 컬럼에 해당하는 값을
				 * 			메소드 타입에 따라 데이터 타입으로 가져옴
				 * 			단, 컬럼명을 잘못 작성했을 경우 SQLException 예외가 발생됨!
				 */
				
				
				int id = rset.getInt("id");
				String name = rset.getString("name");
				String email = rset.getString("email");
				int age = rset.getInt("age");
				
				System.out.printf("%d | %s | %s | %d\n", id, name, email, age);
//				System.out.printf("ID: %d, NAME: %s, EMAIL: %s, AGE: %d\n", rset.getInt("id"), rset.getString("name"), rset.getString("email"), rset.getInt("age"));
			}
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
