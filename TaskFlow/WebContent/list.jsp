<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록 보기</title>
</head>
<body>
	<h1>회원 목록 보기</h1>

	<table border="1" cellpadding="10px">
		<tr>
			<td colspan="5">
				<form action="">
					<select name="searchName" size="1">
						<option value="name">이름</option>
						<option value="id">아이디</option>
					</select> 
					<input type="text" name="searchValue"> 
					<input type="submit" value="찾기">
				</form>
			</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>PW</td>
			<td>NAME</td>
			<td>EMAIL</td>
			<td>PHONE</td>
			<td>PROJECT</td>
		</tr>

 		<c:forEach var="aaa" items="${list}" >
			<tr>
				<td><a href="modify.do?id=${aaa.id}">${aaa.id}</a></td>
				<td>${aaa.pw}</td>
				<td>${aaa.name}</td>
				<td>${aaa.email}</td>
				<td>${aaa.phone}</td>
				<td>${aaa.project}</td>
			</tr>
		</c:forEach>

	</table>
	<a href="joinui.do">회원가입</a>
	<a href="modify.do">회원정보 수정</a>
</body>
</html>