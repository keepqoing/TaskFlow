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
<title>제출물 목록 보기</title>
</head>
<body>
	<h1>제출물 목록 보기</h1>

	<c:forEach var="aaa" items="${SubmList}">
		<table border="1" cellpadding="10px">
			<tr>
				<td colspan="4"><a href="<c:url value="file/${aaa.filename}"/>">${aaa.filename}</a></td>
				<td>${aaa.writer}</td>
				<td>${aaa.sDate}</td>

				<c:if test="${aaa.writer eq curUser || curUser eq pManager}">
					<td><a href="Submissiondelete.do?smId=${aaa.smId}">삭제</a></td>
				</c:if>
			</tr>
			<tr>
				<td colspan="7">${aaa.comment}</td>
			</tr>
		</table>
	</c:forEach>

	<c:if test="${state ne 3}">
		<a href="Submissionuploadui.do?subpId=${subpId}">과제 제출하기</a>
	</c:if>
	
	<a href="SubProjectView.do">과제 목록보기</a>
	<a href="pjlist.do">프로젝트 목록 보기</a>

	<c:if test="${curUser eq pManager}">
		<form method="post" action="accept.do?subpId=${subpId}">
			<input type="submit" value="OK!">
		</form>
		<form method="post" action="reject.do?subpId=${subpId}">
			<input type="submit" value="NO!">
		</form>
	</c:if>

	<form method="post" action="logout.do">
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>