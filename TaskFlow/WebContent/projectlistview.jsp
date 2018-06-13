<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<title>projectlistview</title>
<!—	csslink—>
<link href="projectliststyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/-Team-Rotating-Cards-BS4-.css">
<link rel="stylesheet" href="assets/css/Card-Deck.css">
<link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<!--modal-->
<div id="projectinvitecodeinput" class="modal fade" role="dialog" tabindex="-1">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">프로젝트 초대 코드를 입력하세요</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			</div>
			<div class="modal-body"> 
				<script>
					function checkValue()
					{
						inputForm = eval("document.loginInfo");
						if(!inputForm.pCode.value)
						{
							alert("프로젝트 초대 코드를 입력하세요");    
							inputForm.pCode.focus();
							return false;
						}
					}

				</script>
				<form action="projectjoin.do" method="post" onsubmit="return checkValue()">
					<p style="display: inline;">참여코드 </p> <input type="text" name="pCode">
			</div>
			<div class="modal-footer">
				<button class="btn btn-light" type="button" data-dismiss="modal">취소</button>
				<input type="submit" class="btn btn-primary" type="button" value="참여하기"></input>
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
			</div>
		</div>
	</div>
</div>


<!--background wrap-->
<div class="bg"> 
	<!--titlebar-->
	<div class="titlebar"> <a class="titlestring">진행중인 프로젝트</a> </div>
	<!--titlebarbutton-->
	<div class="barbuttoncontainer"> 
		<!--<a href="projectjoinui.do">-->
		<input class="barbutton" type="button" data-toggle="modal" data-target="#projectinvitecodeinput" value="코드로 참여">
		<!--</a>--> 
	</div>
	<!--navbar-->
	<div class="navbarbase"> <a href="#"><img class="homelogo" src="assets/navbar/teamlogo_white.png" width="160" height="65" alt=""/></a> <a class="currentprj" href="#">
		<p><img class="menuicon" src="assets/icons/projecticon.png">Projects</p>
		</a> 
		
		<!--menu starts here--> 
		<a class="mainmenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuexpand.png"> 팀관리</p>
		</a> <a class="submenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuselect.png"> 공지사항</p>
		</a> <a class="submenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuselect.png"> 팀원</p>
		</a> <a href="#" class="mainmenu">
		<p><img class="menuicon" src="assets/icons/menuselect.png"> 일정관리</p>
		</a> <a class="mainmenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuexpand.png"> 자료조사</p>
		</a> <a class="submenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuselect.png"> 브레인스토밍</p>
		</a> <a class="submenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuselect.png"> 참고 자료</p>
		</a> <a class="submenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuselect.png"> 아이디어 노트</p>
		</a> <a class="mainmenu" href="#">
		<p><img class="menuicon" src="assets/icons/menuselect.png">과제</p>
		</a>
		<div class="welcome">
			<p id="welcome_norm">반갑습니다, Admin</p>
			<p id="welcome_focus">n개의 프로젝트</p>
			<p id="welcome_norm">참여중</p>
		</div>
		
		<a class="mainmenu" href="logout.do">
		<p><img class="menuicon" src="assets/icons/logout.png"> 로그아웃</p>
		</a> <a class="mainmenu" href="modify.do">
		<p><img class="menuicon" src="assets/icons/setting.png"> 계정설정</p>
		</a> <a class="mainmenu" href="#">
		<p><img class="menuicon" src="assets/icons/help.png"> 도움말</p>
		</a>
		<p class="versiontag">ver.ALPHA</p>
	</div>
	
	<div class="pagecontentswrap"> 
		
		<div class="card-deck-wrapper">
			<div class="card-deck"> 
				
				<c:if test="${!empty pList }">
					<c:forEach var="aaa" items="${pList}">
						<div class="card">
							<div class="cardheadtitle"> ${aaa.pName}
								<c:choose>
					<c:when test="${aaa.pManager eq loginmember}">
					
					<a href="projectmodify.do?pCode=${aaa.pCode}"> <img class="projectediticon" src="assets/icons/projectediticon.png"> </a>
					</c:when>

					<c:otherwise>
						<a href="projectout.do?pCode=${aaa.pCode}"><img src="assets/icons/deleteicon.png"></a>
					</c:otherwise>
				</c:choose>
							
							
								
							</div>
							<a href="projectEntry.do?pCode=${aaa.pCode}" style="text-decoration: none; color: black;">
							<div class="card-block">
								<h4 class="card-title">${aaa.pDescript}</h4>
								<p class="card-text"> 개설자 ${aaa.pManager}</br>
									참여자 ${aaa.pMember}</br>
									참여코드 ${aaa.pCode}</br>
								</p>
								<p class="card-text"> <small class="text-muted">Last updated 3 mins ago</small> </p>
							</div>
							</a> </div>
					</c:forEach>
				</c:if>
				<div class="card">
					<div class="cardheadadd"> 새 프로젝트 추가 </div>
					<div class="card-block">
						<h4 class="card-title"> </h4>
						<p class="card-text"> <a href="createprojectui.do"><img class="addbutton" src="assets/icons/projectadd.png"></a> </p>
						<p class="card-text"> <small class="text-muted"> </small> </p>
					</div>
				</div>
			</div>
		</div>
		<script src="assets/js/jquery.min.js"></script> 
		<script src="assets/bootstrap/js/bootstrap.min.js"></script> 
	</div>
</div>
</body>
</html>