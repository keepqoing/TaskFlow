package TF.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;

public class TaskFlowMemberLoginCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		
		MemberDAO dao = new MemberDAO();
		int check = dao.loginCheck(id, pw);
		
		String msg = "";
		if(check == 1) {
			session.setAttribute("sessionID",id);
			if(session.isNew()) {
				System.out.println("세션이 해제되어 다시 설정합니다.");
				session.setAttribute("sessionID", id);
			}
			
			System.out.println("By TFMLC sessionID = "+id);
			msg = "pjlist.do";
		}
		
		else if(check == 0) {
			msg ="login.jsp?msg=0";
		}
		else {
			msg ="login.jsp?msg=-1";
		}
		
		request.setAttribute("msg", msg);
	}

}
