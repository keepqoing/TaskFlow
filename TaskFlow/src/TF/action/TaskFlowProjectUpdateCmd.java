package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.ProjectDAO;

public class TaskFlowProjectUpdateCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String pName = request.getParameter("pName");
		String pDescript = request.getParameter("pDescript");
		String pCode = request.getParameter("pCode");
		
		ProjectDAO dao = new ProjectDAO();
		dao.update(pName, pDescript, Integer.parseInt(pCode));
	}
}