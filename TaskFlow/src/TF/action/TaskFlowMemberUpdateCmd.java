package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;

public class TaskFlowMemberUpdateCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		System.out.println("By TFMUC id = " + id);
		String pw = request.getParameter("pw");
		System.out.println("By TFMUC pw = " + pw);
		String name = request.getParameter("name");
		System.out.println("By TFMUC name = " + name);
		String email = request.getParameter("email");
		System.out.println("By TFMUC email = " + email);
		String phone = request.getParameter("phone");
		System.out.println("By TFMUC phone = " + phone);
		
		MemberDAO dao = new MemberDAO();
		dao.update(id,pw,name,email,phone);
	}
}