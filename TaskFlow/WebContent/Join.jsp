<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>

</head>
<body>
<h1>회원 가입 화면</h1>
 <form action="join.do" method="post">
	아이디<input type="text" name="id"><br />
	비밀번호<input type="password" name="pw"><br />
	이름<input type="text" name="name"><br />
	이메일<input type="text" name="email"><br />
	연락처<input type="text" name="phone"><br />
	<input type="submit" value="회원가입" onclick="">
	<input type=button value="취소" onClick="history.back();">
  </form>
  
 <a href="list.do">목록보기</a>
</body>
</html>
