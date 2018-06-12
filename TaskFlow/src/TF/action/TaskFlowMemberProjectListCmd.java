package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;
import TF.model.ProjectDAO;
import TF.model.ProjectDO;

public class TaskFlowMemberProjectListCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();

		String tmp = (String) session.getAttribute("sessionID");
		MemberDAO mdao = new MemberDAO();
		MemberDO pCodeList = mdao.getInfo(tmp);
		ProjectDAO dao = new ProjectDAO();
		ArrayList<ProjectDO> pList = dao.pjlist(pCodeList.getProject());
		ArrayList<Integer> pmList = new ArrayList<Integer>();

		for(ProjectDO i : pList) {
			if(pCodeList.getId().equals(i.getpManager())) {
				pmList.add(i.getpCode());
			}
		}



		request.setAttribute("pList",pList);
		request.setAttribute("pmList",pmList);

	}

}
