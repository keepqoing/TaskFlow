package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;
import TF.model.ProjectDAO;
import TF.util.MakeCode;

public class TaskFlowProjectCreateCmd implements TaskFlowCmd{

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String pName = request.getParameter("pName");
		String pDescript = request.getParameter("pDescript");
		String pManager = (String) session.getAttribute("sessionID");

		ProjectDAO dao = new ProjectDAO();
		
		//여기서 참여코드 생성
		MakeCode tmp = new MakeCode();
		int pCode = tmp.CreateCode();
		while(pCode == 0) {
			pCode = tmp.CreateCode();
		}
		
		dao.createProject(pCode, pName, pDescript, pManager);
		
		MemberDAO mdao = new MemberDAO();
		MemberDO data = mdao.getInfo(pManager);
		
		String pList = data.getProject();
		if(pList != null) {
			pList += "," + Integer.toString(pCode);
		}
		else {
			pList = Integer.toString(pCode);
		}
		
		mdao.updateproject(pManager, pList);
		
	}

}