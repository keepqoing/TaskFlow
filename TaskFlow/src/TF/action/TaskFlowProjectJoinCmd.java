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

public class TaskFlowProjectJoinCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionID");
		int pCode = Integer.parseInt(request.getParameter("pCode"));	

		ProjectDAO dao = new ProjectDAO();
		ProjectDO data = dao.getInfo(pCode);
		System.out.println("By TFPJC pCode = " + data.getpMember());


		ArrayList<Integer> pCodeList = dao.codeList();


		// 참여하려는 프로젝트가 존재하는지 검사
		int check = -1;

		for(int i : pCodeList) {
			if(i == pCode) {
				check = 1;
				break;
			}
		}

		//data의 pMember에 이미 참여하려는 사람이 존재하는지 검사


		Parser parser = new Parser();
		ArrayList<String> pmlist;
		String msg = "";
		if(data.getpMember() != null && check == 1) {
			pmlist = parser.parseProjectMember(data.getpMember());

			for(String i : pmlist) 
				if(i.equals(id)) {
					check = 0;
					break;
				}
		}
		
		if(data.getpManager().equals(id))
			check = 0;


		if(check == 1) {
			String pMember = data.getpMember(); 
			
			if(pMember != null){
				pMember += ","+ id;
			}
			else {
				pMember = id;
			}
			
			dao.projectMemberUpdate(pCode, pMember);

			MemberDAO mdao = new MemberDAO();
			MemberDO member = mdao.getInfo(id);

			String tmp = member.getProject();
			
			if(tmp != null) {
				tmp += "," + Integer.toString(pCode);
			}
			
			else {
				tmp = Integer.toString(pCode);
			}
			
			mdao.updateproject(id, tmp);

			msg = "pjlist.do";
		}
		else if(check == 0) {
			msg = "projectjoin.jsp?msg=0";
		}
		else {
			msg = "projectjoin.jsp?msg=-1";
		}

		request.setAttribute("msg", msg);
	}

}
