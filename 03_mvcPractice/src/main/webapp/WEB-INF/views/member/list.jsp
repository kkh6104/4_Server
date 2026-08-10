<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원 목록 </h1>
	
	<a href="/mvc/member/insert.html">회원 등록</a>
	
	<table border="1">
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>나이</th>
			</tr>		
		</thead>
		<tbody>
		<%-- 조회 결과는 request 영역에 memberList 이름으로 저장되어 있음! --%>
		<c:forEach var="m" items="${ memberList }">
			<tr>
				<td> ${ m.id }</td>
				<td>${ m.name }</td>
				<td>${ m.email }</td>
				<td>${ m.age }</td>
			</tr>	
		</c:forEach>
		</tbody>
	</table>
	<br>
	<form action="delete" method="get">
	 	<label>삭제할 id : <input type="number" name="id"> </label>
	 	<button>제출</button>
	 </form>
	 
</body>
</html>