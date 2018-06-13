package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.SubProjectDAO;

public class TaskFlowSubProjectUpdateCmd  implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String subpName = request.getParameter("subpName");
		String subpDescript = request.getParameter("subpDescript");
		String subpStartDate = request.getParameter("subpStartDate");
		String subpEndDate = request.getParameter("subpEndDate");
		String subpId = request.getParameter("subpId");
		
		SubProjectDAO dao = new SubProjectDAO();
		dao.updateSubProject(subpName, subpDescript, subpEndDate, Integer.parseInt(subpId));
	}
}