package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;

public class TaskFlowMemberLogoutCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String msg = "login.jsp";
		session.invalidate();
		
		request.setAttribute("msg", msg);
	}

}

