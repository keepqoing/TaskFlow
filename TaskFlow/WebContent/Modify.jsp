<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<h1>회원정보 수정화면</h1>
 <form action="update.do" method="post">
	아이디<input type="text" name="id" value="${data.id}"><br />
	비밀번호<input type="password" name="pw" value="${data.pw}"><br />
	이름<input type="text" name="name" value="${data.name}"><br />
	이메일<input type="text" name="email" value="${data.email}"><br />
	연락처<input type="text" name="phone" value="${data.phone}"><br />
	<input type="submit" value="회원정보 수정">
	<input type=button value="취소" onClick="history.back();">
  </form>
  
 <a href="list.do">목록보기</a>
 <a href="delete.do?id=${data.id}">회원 탈퇴</a>
</body>
</html>