<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 생성</title>

</head>
<body>
<h1>프로젝트 생성 화면</h1>
 <form action="createproject.do" method="post">
	프로젝트 이름<input type="text" name="pName"><br />
	프로젝트 설명<input type="text" name="pDescript"><br />
	<input type="hidden" name="pManager" value="이민섭">
	<input type="submit" value="프로젝트 생성">
	<input type=button value="취소" onClick="history.back();">
  </form>
  
 <a href="pjlist.do">프로젝트 목록보기</a>
</body>
</html>
