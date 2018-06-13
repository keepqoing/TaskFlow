package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.SubProjectDAO;

public class TaskFlowSubProjectDeleteCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String subpId = request.getParameter("subpId");

		SubProjectDAO dao = new SubProjectDAO();
		dao.deleteSubProject(Integer.parseInt(subpId));
	}
}