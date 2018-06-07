package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.MemberDAO;

public class TaskFlowMemberDeleteCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String id = request.getParameter("id");

		MemberDAO dao = new MemberDAO();
		dao.delete(id);
	}
}