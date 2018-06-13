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
<title>프로젝트 공지사항 목록 보기</title>
</head>
<body>
	<h1>프로젝트 공지사항 목록 보기</h1>

	<table border="1" cellpadding="10px">
		<tr>
			<td colspan = "3">공지사항</td>
			<td><a href="projectNotice.do?pCode=${pCode}">더 보기</a></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일자</td>
		</tr>

		<c:forEach var="aaa" items="${NoticeList}">
			<tr>
				<td>${aaa.nName}</td>
				<td>${aaa.nDescript}</td>
				<td>${aaa.nWriter}</td>
				<td>${aaa.nDate}</td>
			</tr>
		</c:forEach>
	</table>


	<table border="1" cellpadding="10px">
		<tr>
			<td>과제 제목</td>
			<td>과제 설명</td>
			<td>과제 시작일자</td>
			<td>과제 마감일자</td>
			<td>과제 상태</td>
		</tr>

		<c:forEach var="aaa" items="${SubpList}">
			<tr>
				<td>${aaa.SubpName}</td>
				<td>${aaa.SubpDescript}</td>
				<td>${aaa.SubpStartDate}</td>
				<td>${aaa.SubpEndDate}</td>
				<td>${aaa.SubpState}</td>
			</tr>
		</c:forEach>
	</table>

	<table border="1" cellpadding="10px">
		<tr>
			<td>${pManager }</td>
			<c:forEach var="bbb" items="${pMember }">
				<td>${bbb}</td>
			</c:forEach>

		</tr>
	</table>


	<a href="createnoticeui.do">공지사항 생성</a>
	<a href="createSubprojectui.do">과제 생성</a>
	<a href="pjlist.do">프로젝트 목록 보기</a>
	<form method="post" action="logout.do">
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>