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
<title>공지사항 목록 보기</title>
</head>
<body>
	<h1>공지사항 목록 보기</h1>

	<c:forEach var="aaa" items="${NoticeList}">

		<c:choose>
			<c:when test="${aaa.nWriter eq User }">
				<table border="1" cellpadding="10px">
					<tr>
						<td colspan="4">${aaa.nName}</td>
						<td>${aaa.nWriter}</td>
						<td>${aaa.nDate}</td>
						<td><a href="noticemodify.do?nId=${aaa.nId}">수정</a></td>
						<td><a href="noticedelete.do?nId=${aaa.nId }">삭제</a></td>
					</tr>
					<tr>
						<td colspan="8">${aaa.nDescript}</td>
					</tr>
				</table>
			</c:when>

			<c:otherwise>
				<table border="1" cellpadding="10px">
					<tr>
						<td colspan="6">${aaa.nName}</td>
						<td>${aaa.nWriter}</td>
						<td>${aaa.nDate}</td>
					</tr>
					<tr>
						<td colspan="8">${aaa.nDescript}</td>
					</tr>
				</table>
			</c:otherwise>


		</c:choose>


	</c:forEach>
	
	<c:if test="${pManager eq User }">
		<a href="createnoticeui.do">공지사항 추가</a>
	</c:if>
	<a href="projectEntry.do">프로젝트 로비</a>
	<a href="pjlist.do">프로젝트 목록 보기</a>
	<form method="post" action="logout.do">
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>