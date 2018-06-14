package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.ProjectDAO;
import TF.model.ProjectDO;
import TF.model.SubProjectDAO;
import TF.model.SubProjectDO;
import TF.model.SubmissionDAO;
import TF.model.SubmissionDO;

public class TaskFlowSubmissionListCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		
		HttpSession session = request.getSession();
		String curUser = (String) session.getAttribute("sessionID");
		
		String pCode = (String) session.getAttribute("currentProject"); // 프로젝트 번호
		String spCode = request.getParameter("subpId"); //과제번호

		
		if(spCode == null)
			spCode = (String) session.getAttribute("currentSubmission");
		else
			session.setAttribute("currentSubmission", spCode);
		
		
		SubmissionDAO dao = new SubmissionDAO();
		ArrayList<SubmissionDO> SubmList = dao.getSubmissionList(pCode, spCode); 
		
		for(SubmissionDO i : SubmList) {  
			i.setsDate(i.getsDate().substring(0, 10));
		}
		
		ProjectDAO pdao = new ProjectDAO();
		ProjectDO pManager = pdao.getInfo(Integer.parseInt(pCode));
		
		SubProjectDAO spdao = new SubProjectDAO();
		int state = spdao.readSubProject(Integer.parseInt(spCode)).getSubpState();

		request.setAttribute("SubmList", SubmList);
		request.setAttribute("subpId", spCode);
		request.setAttribute("curUser", curUser);
		request.setAttribute("state", state);
		request.setAttribute("pManager", pManager.getpManager());
	}
}  