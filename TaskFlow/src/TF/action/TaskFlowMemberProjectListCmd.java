package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;
import TF.model.ProjectDAO;
import TF.model.ProjectDO;
import TF.util.Parser;

public class TaskFlowMemberProjectListCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		session.removeAttribute("currentProject");
		
		String tmp = (String) session.getAttribute("sessionID");
		
		MemberDAO mdao = new MemberDAO();		
		MemberDO curMember = mdao.getInfo(tmp); // 현재 로그인되어있는 회원의 정보를 불러온다.
		ProjectDAO dao = new ProjectDAO();
		ArrayList<ProjectDO> pList = dao.pjlist(curMember.getProject()); // 현재 로그인되어있는 회원의 참여중인 프로젝트 목록
		
		
		// 참여자 화면에 뿌리는 방식		
		for(ProjectDO i : pList) {
				
			
			System.out.println("개설자 = "+i.getpManager());
			System.out.println("참여자 = "+i.getpMember());
		}

		request.setAttribute("pList",pList);
		request.setAttribute("loginmember",tmp);

	}

}
