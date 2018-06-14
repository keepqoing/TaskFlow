package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.SubProjectDO;
import TF.model.SubmissionDAO;
import TF.model.SubmissionDO;

public class TaskFlowSubmissionListCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		
		HttpSession session = request.getSession();
		String pCode = (String) session.getAttribute("currentProject"); // 프로젝트 번호
		String spCode = request.getParameter("subpId"); //과제번호
		System.out.println("spCode = " + spCode);
		if(spCode == null)
			spCode = (String) session.getAttribute("currentSubmission");
		else
			session.setAttribute("currentSubmission", spCode);
		System.out.println("spCode = " + spCode);
		
		SubmissionDAO dao = new SubmissionDAO();
		ArrayList<SubmissionDO> SubmList = dao.getSubmissionList(pCode, spCode); 
		
		for(SubmissionDO i : SubmList) {  
			i.setsDate(i.getsDate().substring(0, 10));
		}


		request.setAttribute("SubmList", SubmList);
		request.setAttribute("subpId", spCode);
		
	}
}  