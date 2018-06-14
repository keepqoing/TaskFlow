package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.SubProjectDAO;
import TF.model.SubProjectDO;

public class TaskFlowSubmissionUploadCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		//HttpSession session = request.getSession();
		
		int subpId = Integer.parseInt(request.getParameter("subpId"));
		//session.setAttribute("currentSubmission", subpId);
		
		
		SubProjectDAO subProjectdao = new SubProjectDAO();
		SubProjectDO  subProject = subProjectdao.readSubProject(subpId);
		subProjectdao.changeState(1, subpId);

		request.setAttribute("subProject",subProject);
		request.setAttribute("subpId",subpId);
	}
}