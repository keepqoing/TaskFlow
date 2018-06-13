package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;
import TF.model.ProjectDAO;
import TF.model.ProjectDO;

public class TaskFlowProjectOutCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String pCode = request.getParameter("pCode");
		String id = (String) session.getAttribute("sessionID");
		MemberDAO mdao = new MemberDAO();
		ProjectDAO dao = new ProjectDAO();

		System.out.println("id is " + id);
		System.out.println("pCode is " + pCode);
		// 로그인되어있는 회원의 멤버 정보에서 해당 프로젝트 정보 삭제
		MemberDO curMember = mdao.getInfo(id);
		String pList = curMember.getProject();
		System.out.println("PList is " + pList);
		String wantToDel = "";
		if(pList.equals(pCode)) {
			System.out.println("Dddddd");
			pList = null;
		}
		else {
			if(pList.contains(","+pCode))
				wantToDel = "," + pCode;
			else
				wantToDel = pCode + ",";
			
			pList = pList.replace(wantToDel, "");
		}
		
		mdao.updateproject(id, pList);				
		
		// 프로젝트의 pMember에서 로그인되어있는 회원 정보 삭제.
		ProjectDO selProject = dao.getInfo(Integer.parseInt(pCode));
		String pMemList = selProject.getpMember();
		System.out.println("pMemList id " + pMemList);
		wantToDel = "";
		
		if(pMemList.equals(id))
			pMemList = null;
		else {
			if(pMemList.contains(","+id))
				wantToDel = "," + id;
			else
				wantToDel = id + ",";
			
			pMemList.replace(wantToDel , "");
		}
		dao.projectMemberUpdate(Integer.parseInt(pCode), pMemList);
		
		
		//
	}
}