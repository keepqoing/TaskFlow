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

public class TaskFlowProjectDeleteCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String pCode = request.getParameter("pCode");
		String pManager = (String) session.getAttribute("sessionID");
		
		ProjectDAO dao = new ProjectDAO();
		ProjectDO pCodeDO = dao.getInfo(Integer.parseInt(pCode)); 
	
		//프로젝트 DB에서 참여자 멤버 가져옴
		String pMember = pCodeDO.getpMember();	
		System.out.println("pMEmber is " + pMember);
		//pMember 파싱해서 참여자 목록 만들고
		
		Parser parser = new Parser();
		ArrayList<String> pMemberList = parser.parseProjectMember(pMember);
		MemberDAO mdao = new MemberDAO();
		
		for(String i: pMemberList) {
			MemberDO tmp = mdao.getInfo(i);
			String pList = tmp.getProject();
			String wantToDel = "";
			if(pList.equals(pCode))
				pList = null;
			else {
				if(pList.contains(","+ pCode))
					wantToDel = "," + pCode;
				else
					wantToDel = pCode;
				pList = pList.replace(wantToDel, "");
			}
			mdao.updateproject(tmp.getId(), pList);
		}
		
		//각 참여자의  참여중인 프로젝트 목록에서 pCode 코드 삭제
		
		//프로젝트 DB에서 해당 프로젝트 정보 삭제
		dao.delete(Integer.parseInt(pCode));
		
		//삭제된 프로젝트의 프로젝트 관리자 DB의 참여중인 프로젝트 정보에서 해당 프로젝트 코드 삭제
		MemberDO data = mdao.getInfo(pManager);
		
		
		String pList = data.getProject();// + "," + pCode;
		System.out.println("pList is "+pList);
		String wantToDel = "";
		
		if(pList.equals(pCode))
			pList = null;
		else{	
			if(pList.contains(","+ pCode))
				wantToDel = "," + pCode;
			else
				wantToDel = pCode + ",";
			pList = pList.replace(wantToDel, "");
		}
		
		mdao.updateproject(pManager, pList);
		
		
		//
	}
}