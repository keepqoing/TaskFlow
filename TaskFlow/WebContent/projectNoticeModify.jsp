<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정</title>
</head>
<body>
<h1>공지사항 수정화면</h1>
 <form action="noticeupdate.do" method="post">
	공지사항 이름<input type="text" name="nName" value="${notice.nName }"><br />
	공지사항 설명<input type="text" name="nDescript" value="${notice.nDescript }"><br />
	<input type="hidden" name="nId" value="${notice.nId }">
	<input type="submit" value="공지사항 수정">
	<input type=button value="취소" onClick="history.back();">
  </form>
  
 <a href="projectNotice.do">공지사항 목록보기</a>
</body>
</html>