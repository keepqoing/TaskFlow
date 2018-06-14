package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.ProjectDAO;
import TF.model.ProjectDO;

public class TaskFlowProjectListCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {

		ProjectDAO dao = new ProjectDAO();
		ArrayList<ProjectDO> pList = dao.list();
		
		for(ProjectDO i : pList) {
			System.out.println("개설자 = "+i.getpManager());
			System.out.println("참여자 = "+i.getpMember());
		}
		
		
		request.setAttribute("pList",pList);
	}

}
