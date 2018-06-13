<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과제 수정</title>
</head>
<body>
<h1>과제 수정화면</h1>
 <form action="SubProjectupdate.do" method="post">
	과제 이름<input type="text" name="subpName" value="${subProject.subpName }"><br />
	과제 설명<input type="text" name="subpDescript" value="${subProject.subpDescript }"><br />
	과제 종료일<input type="date" name="subpEndDate" id="datePicker" ><br />	
	
	<script>
			var tmp = ${subProject.subpDescript };
			document.getElementById('datePicker').value = tmp;
		</script>
	
	<input type="hidden" name="subpId" value="${subProject.subpId }">
	<input type="submit" value="공지사항 수정">
	<input type=button value="취소" onClick="history.back();">
  </form>
  
 <a href="SubProjectView.do">과제 목록보기</a>
</body>
</html>