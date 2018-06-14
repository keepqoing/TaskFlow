<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과제 제출</title>

</head>
<body>
	<h1>과제 제출 화면</h1>

	<form action="Submissionupload.do" method="post"
		enctype="multipart/form-data">
		<table border="1" cellpadding="10px">
			<tr>
				<td>과제 제목</td>
				<td>${subProject.subpName}</td>
			</tr>
			<tr>
				<td>과제 설명</td>
				<td>${subProject.subpDescript}</td>
			</tr>
			<tr>
				<td>제출물</td>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<td>Comment</td>
				<td><input type="text" name="comment"></td>
			</tr>
		</table>
		<input type="hidden" name="subpId" value="${subProject.subpId}">
		<input type="submit" value="과제 제출"> <input type=button
			value="취소" onClick="history.back();">
	</form>

	<a href="SubmissionList.do?subpId=${subProject.subpId}">제출물 목록 보기</a>
	<form method="post" action="logout.do">
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>
