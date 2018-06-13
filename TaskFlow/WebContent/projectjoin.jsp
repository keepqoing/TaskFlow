<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 참여</title>
<script>
function checkValue()
{
    inputForm = eval("document.loginInfo");
    if(!inputForm.pCode.value)
    {
        alert("아이디를 입력하세요");    
        inputForm.pCode.focus();
        return false;
    }
}

</script>

</head>
<body>
<h1>로그인 화면</h1>
 <form action="projectjoin.do" method="post" onsubmit="return checkValue()">
	참여코드 입력<input type="text" name="pCode"><br />
	<input type="submit" value="참여하기!">
  </form>
  
  <% 
            // 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
            // LoginPro.jsp에서 로그인 처리 결과에 따른 메시지를 보낸다.
            String msg=request.getParameter("msg");
            
            if(msg!=null && msg.equals("0")) 
            {
                out.println("<br>");
                out.println("<font color='red' size='5'>이미 참여중인 프로젝트입니다</font>");
            }
            else if(msg!=null && msg.equals("-1"))
            {    
                out.println("<br>");
                out.println("<font color='red' size='5'>프로젝트가 존재하지 않습니다.</font>");
            }
        %>    

  <a href="pjlist.do">프로젝트 목록 보기</a>
</body>
</html>