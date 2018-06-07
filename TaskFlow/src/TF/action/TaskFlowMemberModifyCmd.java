package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;

public class TaskFlowMemberModifyCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");

		MemberDAO dao = new MemberDAO();
		MemberDO data = dao.getInfo(id);
		
		request.setAttribute("data",data);
	}
}
