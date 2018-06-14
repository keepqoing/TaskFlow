package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.SubmissionDAO;

public class TaskFlowSubmissionDeleteCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String smId = request.getParameter("smId");

		SubmissionDAO dao = new SubmissionDAO();
		dao.delete(smId);
		
//		SubProjectDAO dao = new SubProjectDAO();
//		dao.deleteSubProject(Integer.parseInt(smId));
	}
}