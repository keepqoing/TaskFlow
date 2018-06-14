<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link href="Joinstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="blurback">
	<h1>회원 가입</h1>
	<form action="join.do" method="post" enctype="multipart/form-data">
		<div class="formwrap">
			<p>아이디</p>
			<input class="form" type="text" name="id">
		</div>
		<div class="formwrap">
			<p>비밀번호</p>
			<input class="form" type="password" name="pw">
		</div>
		<div class="formwrap">
			<p>이름</p>
			<input class="form" type="text" name="name">
		</div>
		<div class="formwrap">
			<p>이메일</p>
			<input class="form" type="text" name="email">
		</div>
		<div class="formwrap">
			<p>연락처</p>
			<input class="form" type="text" name="phone">
		</div>
		<div class="formwrap">
			<p>프로필 사진</p>
			<input class="form" type="file" name="filename">
		</div>
		<div class="buttonwrap">
			<input class="button1" type="submit" value="회원가입" onclick="">
			<input class="button2" type=button value="취소" onClick="history.back();">
		</div>
	</form>
</div>
</body>
</html>
