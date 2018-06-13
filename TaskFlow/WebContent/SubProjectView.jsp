<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과제 목록 보기</title>
</head>
<body>
	<h1>과제 목록 보기</h1>

	<c:forEach var="aaa" items="${SubpList}">

		<c:choose>
			<c:when test="${pManager eq User }">
				<table border="1" cellpadding="10px">
					<tr>
						<td colspan="4">${aaa.subpName}</td>
						<td>${aaa.subpStartDate}</td>
						<td>${aaa.subpEndDate}</td>
						<td><a href="SubProjectmodify.do?subpId=${aaa.subpId}">수정</a></td>
						<td><a href="SubProjectdelete.do?subpId=${aaa.subpId}">삭제</a></td>
					</tr>
					<tr>
						<td colspan="8">${aaa.subpDescript}</td>
					</tr>
				</table>
			</c:when>

			<c:otherwise>
				<table border="1" cellpadding="10px">
					<tr>
						<td colspan="6">${aaa.subpName}</td>
						<td>${aaa.subpStartDate}</td>
						<td>${aaa.subpEndDate}</td>
					</tr>
					<tr>
						<td colspan="8">${aaa.subpDescript}</td>
					</tr>
				</table>
			</c:otherwise>


		</c:choose>


	</c:forEach>
	
	<c:if test="${pManager eq User }">
		<a href="createSubprojectui.do">과제 추가</a>
	</c:if>
	<a href="projectEntry.do">프로젝트 로비</a>
	<a href="pjlist.do">프로젝트 목록 보기</a>
	<form method="post" action="logout.do">
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>