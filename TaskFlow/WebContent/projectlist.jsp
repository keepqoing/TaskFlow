<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 목록 보기</title>
</head>
<body>
	<h1>프로젝트 목록 보기</h1>

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
			<td>프로젝트 이름</td>
			<td>프로젝트 설명</td>
			<td>프로젝트 관리자</td>
			<td>프로젝트 참여자</td>
			<td>프로젝트 참여코드</td>
		</tr>

 		<c:forEach var="aaa" items="${pList}" >
			<tr>
				<td><a href="projectmodify.do?pCode=${aaa.pCode}">${aaa.pName}</a></td>
				<td>${aaa.pDescript}</td>
				<td>${aaa.pManager}</td>
				<td>${aaa.pMember}</td>
				<td>${aaa.pCode}</td>
			</tr>
		</c:forEach>

	</table>
	<a href="createprojectui.do">프로젝트 생성</a>
</body>
</html>