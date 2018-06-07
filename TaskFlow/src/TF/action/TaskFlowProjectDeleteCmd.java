package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;
import TF.model.ProjectDAO;

public class TaskFlowProjectDeleteCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String pCode = request.getParameter("pCode");
		String pManager = (String) session.getAttribute("sessionID");

		ProjectDAO dao = new ProjectDAO();
		dao.delete(Integer.parseInt(pCode));
		
		MemberDAO mdao = new MemberDAO();
		MemberDO data = mdao.getInfo(pManager);
		
		String pList = data.getProject();// + "," + pCode;
		String wantToDel = ","+pCode;
		pList.replaceAll(wantToDel, null);
		System.out.println("By TFPCC pList = " + pList);
		mdao.updateproject(pManager, pList);
	}
}