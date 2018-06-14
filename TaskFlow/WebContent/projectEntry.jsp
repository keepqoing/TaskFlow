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
<title>프로젝트  메인페이지</title>
</head>
<body>
	<h1>프로젝트  메인페이지</h1>

	<table border="1" cellpadding="10px">
		<tr>
			<td colspan = "2">공지사항</td>
			<td><a href="projectNotice.do?pCode=${pCode}">더 보기</a></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
		</tr>

		<c:forEach var="aaa" items="${NoticeList}">
			<tr>
				<td>${aaa.nName}</td>
				<td>${aaa.nWriter}</td>
				<td>${aaa.nDate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 과제 부분 -->

	<table border="1" cellpadding="10px">
		<tr>
			<td colspan = "3">과제</td>
			<td><a href="SubProjectView.do?pCode=${pCode}">더 보기</a></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>시작일</td>
			<td>종료일</td>
			<td>상태</td>
		</tr>
		<c:forEach var="bbb" items="${subProjectList}">
			<tr>
				<td>${bbb.subpName}</td>
				<td>${bbb.subpStartDate}</td>
				<td>${bbb.subpEndDate}</td>


				<c:choose>
					<c:when test="${bbb.subpState eq 0}">
						<td>개시</td>
					</c:when>
					<c:when test="${bbb.subpState eq 1}">
						<td>진행</td>
					</c:when>
					<c:when test="${bbb.subpState eq 2}">
						<td>검토</td>
					</c:when>
					<c:when test="${bbb.subpState eq 3}">
						<td>완료</td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
		 
	</table>
	
	
	<table border="1" cellpadding="10px">
			<tr>
				<td><a href="#">${pManager.name}</td>
			</tr>
		<tr>
			<c:choose>
				<c:when test="${!empty pManager.filename}">
					<td><img src="file/${pManager.filename }" width="50" height="50"></td>
				</c:when>
				<c:otherwise>
					<td>물음표 이미지</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
		
	<c:forEach var="bbb" items="${pMember}">
		<table border="1" cellpadding="10px">
			<tr>
				<td><a href="#">${bbb.name}</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${!empty bbb.filename}">
						<td><img src="file/${bbb.filename }" width="50" height="50"></td>
					</c:when>
					<c:otherwise>
						<td>물음표 이미지</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</c:forEach>



<!--  
	<a href="createnoticeui.do">공지사항 생성</a>
	<a href="createSubprojectui.do">과제 생성</a>
	-->
	<a href="pjlist.do">프로젝트 목록 보기</a>
	<form method="post" action="logout.do">
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>