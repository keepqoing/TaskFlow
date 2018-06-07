package TF.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.action.TaskFlowCmd;
import TF.action.TaskFlowMemberDeleteCmd;
import TF.action.TaskFlowMemberJoinCmd;
import TF.action.TaskFlowMemberListCmd;
import TF.action.TaskFlowMemberLoginCmd;
import TF.action.TaskFlowMemberLogoutCmd;
import TF.action.TaskFlowMemberModifyCmd;
import TF.action.TaskFlowMemberProjectListCmd;
import TF.action.TaskFlowMemberUpdateCmd;
import TF.action.TaskFlowProjectCreateCmd;
import TF.action.TaskFlowProjectDeleteCmd;
import TF.action.TaskFlowProjectJoinCmd;
import TF.action.TaskFlowProjectListCmd;
import TF.action.TaskFlowProjectModifyCmd;
import TF.action.TaskFlowProjectUpdateCmd;

/**
 * Servlet implementation class MemberFrontController1
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		HttpSession session = request.getSession();
		TaskFlowCmd command  = null;
		String nextPage = null;


		if(com.equals("/plist.do")){
			command = new TaskFlowProjectListCmd();
			command.execute(request, response);
			nextPage = "projectlist.jsp";
		}

		if(com.equals("/pjlist.do")){
			command = new TaskFlowMemberProjectListCmd();
			command.execute(request, response);
			nextPage = "projectlistview.jsp";
		}

		if(com.equals("/list.do")){
			command = new TaskFlowMemberListCmd();
			command.execute(request, response);
			nextPage = "list.jsp";
		}

		//프로젝트 생성 폼
		if(com.equals("/createprojectui.do")){
			nextPage = "createproject.jsp";
		}
		//프로젝트 생성
		if(com.equals("/createproject.do")){
			command = new TaskFlowProjectCreateCmd();
			command.execute(request, response);
			nextPage = "pjlist.do";
		}

		// 프로젝트 정보 수정
		if(com.equals("/projectmodify.do")){
			command = new TaskFlowProjectModifyCmd();
			command.execute(request, response);
			nextPage = "projectmodify.jsp";
		}	

		//프로젝트 정보 업데이트
		if(com.equals("/projectupdate.do")){
			command = new TaskFlowProjectUpdateCmd();
			command.execute(request, response);
			nextPage = "pjlist.do";
		}	

		//프로젝트 삭제
		if(com.equals("/projectdelete.do")){
			command = new TaskFlowProjectDeleteCmd();
			command.execute(request, response);
			nextPage = "pjlist.do";
		}	

		//프로젝트 참여 폼
		if(com.equals("/projectjoinui.do")){
			nextPage = "projectjoin.jsp";
		}
		//프로젝트 참여
		if(com.equals("/projectjoin.do")){
			command = new TaskFlowProjectJoinCmd();
			command.execute(request, response);
			nextPage = "pjlist.do";
		}

		if(com.equals("/login.do")) {
			command = new TaskFlowMemberLoginCmd();
			command.execute(request, response);
			System.out.println("By FrontController session = "+session.getAttribute("sessionID"));

			nextPage = (String) request.getAttribute("msg");
		}

		if(com.equals("/logout.do")) {
			command = new TaskFlowMemberLogoutCmd();
			command.execute(request, response);

			nextPage = (String) request.getAttribute("msg");
		}


		//회원가입 폼
		if(com.equals("/joinui.do")){
			nextPage = "Join.jsp";
		}
		//회원가입
		if(com.equals("/join.do")){
			command = new TaskFlowMemberJoinCmd();
			command.execute(request, response);
			nextPage = "login.jsp";
		}
		// 회원정보 수정
		if(com.equals("/modify.do")){
			command = new TaskFlowMemberModifyCmd();
			command.execute(request, response);
			nextPage = "Modify.jsp";
		}	

		//회원정보 업데이트
		if(com.equals("/update.do")){
			command = new TaskFlowMemberUpdateCmd();
			command.execute(request, response);
			nextPage = "pjlist.do";
		}	
		//		
		//회원 탈퇴
		if(com.equals("/delete.do")){
			command = new TaskFlowMemberDeleteCmd();
			command.execute(request, response);
			nextPage = "logout.do";
		}	
		//		
		//		//�� �˻� �ϱ�
		//		if(com.equals("/search.do")){
		//			command = new BoardSearchCommand();
		//			command.execute(request, response);
		//			nextPage = "list.jsp";
		//		}	
		//		//�亯�� �Է� �� ����
		//		if(com.equals("/replyui.do")){
		//			command = new BoardReplyUICommand();
		//			command.execute(request, response);
		//			nextPage = "reply.jsp";
		//		}	
		//		//�亯�� ����
		//		if(com.equals("/reply.do")){
		//			command = new BoardReplyCommand();
		//			command.execute(request, response);
		//			nextPage = "list.do";
		//		}	
		//		// ����¡ ó��
		//		if(com.equals("/list.do")){
		//			command = new BoardPageCommand();
		//			command.execute(request, response);
		//			nextPage = "listPage.jsp";
		//		}	

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

}