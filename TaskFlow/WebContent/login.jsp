<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>login</title>
<script src="loginjava.js">
	</script>
<script>
function checkValue()
{
    inputForm = eval("document.loginInfo");
    if(!inputForm.id.value)
    {
        alert("아이디를 입력하세요");    
        inputForm.id.focus();
        return false;
    }
    if(!inputForm.password.value)
    {
        alert("비밀번호를 입력하세요");    
        inputForm.password.focus();
        return false;
    }
}

</script>
<link href="loginstyle.css" rel="stylesheet" type="text/css">
</head>

<body>
<img class="logo" src="assets/loginpage/logo.png" width="580" height="240" alt=""/>
<form action="login.do" method="post" onsubmit="return checkValue()"class="loginform">
	<input name="id" type="text" class="idinput" placeholder="아이디">
	<input name="pw" type="password" class="pwinput" placeholder="비밀번호">
	<input src="assets/loginpage/Login Button.png" type="image" class="loginsubmit">
	<div class="option"><a href="joinui.do">회원가입</a> | <a href="search.do">ID/PW 찾기</a></div>
	<div class="snslogin"> <img src="assets/loginpage/google_icon.png" alt="" width="48" height="48" class="googleplus"/> <img src="assets/loginpage/facebook_icon.png" alt="" width="48" height="48" class="facebook"/> <img src="assets/loginpage/kakako_icon.png" alt="" width="48" height="48" class="kakaotalk"/> </div>
</form>
<% 

            // 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
            // LoginPro.jsp에서 로그인 처리 결과에 따른 메시지를 보낸다.
            String msg=request.getParameter("msg");
            
            if(msg!=null && msg.equals("0")) 
            {
                out.println("<br>");
                out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
            }
            else if(msg!=null && msg.equals("-1"))
            {    
                out.println("<br>");
                out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
            }
        %>
</body>
</html>
