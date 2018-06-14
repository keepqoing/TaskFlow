package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.SubProjectDAO;
import TF.model.SubProjectDO;

public class TaskFlowSubmissionUploadCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		int subpId = Integer.parseInt(request.getParameter("subpId"));
		
		SubProjectDAO subProjectdao = new SubProjectDAO();
		SubProjectDO  subProject = subProjectdao.readSubProject(subpId);
		
		//SimpleDateFormat  dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		request.setAttribute("subProject",subProject);
		request.setAttribute("subpId",subpId);
	}
}