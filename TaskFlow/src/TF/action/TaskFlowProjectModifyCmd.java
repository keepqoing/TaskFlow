package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.ProjectDAO;
import TF.model.ProjectDO;

public class TaskFlowProjectModifyCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String pCode = request.getParameter("pCode");
		System.out.println(pCode);
		ProjectDAO dao = new ProjectDAO();
		ProjectDO data = dao.getInfo(Integer.parseInt(pCode));
		
		request.setAttribute("data",data);
	}
}
