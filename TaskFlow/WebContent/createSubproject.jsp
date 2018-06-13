<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과제 생성</title>

</head>
<body>
	<h1>과제 생성 화면</h1>
	<form action="createSubproject.do" method="post">
		과제 이름<input type="text" name="SubpName"><br /> 
		과제 설명<input type="text" name="SubpDescript"><br />
		과제 시작일<input type="date" id="datePicker" name="SubpStartDate"><br />

		<script>
			document.getElementById('datePicker').valueAsDate = new Date();
		</script>

		과제 종료일<input type="date" name="SubpEndDate"><br /> 
		<input type="hidden" name="SubpFrom" value="${curProject }">
		
		<input type="submit" value="프로젝트 생성"> 
		<input type=button value="취소" onClick="history.back();">
	</form>

	 <a href="SubProjectView.do">과제 목록보기</a>
</body>
</html>
