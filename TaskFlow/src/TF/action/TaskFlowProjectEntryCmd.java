package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.MemberDAO;
import TF.model.MemberDO;
import TF.model.NoticeDAO;
import TF.model.NoticeDO;
import TF.model.ProjectDAO;
import TF.model.ProjectDO;
import TF.model.SubProjectDAO;
import TF.model.SubProjectDO;
import TF.util.Parser;

public class TaskFlowProjectEntryCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String nFrom = request.getParameter("pCode");
		
		HttpSession session = request.getSession();
		session.removeAttribute("currentSubmission");
		if(nFrom == null)
			nFrom = (String) session.getAttribute("currentProject");
		else
			session.setAttribute("currentProject", nFrom);
		
		NoticeDAO Noticedao = new NoticeDAO();
		ArrayList<NoticeDO> noticeList = Noticedao.NoticeList(Integer.parseInt(nFrom));
		 
		for(NoticeDO i : noticeList) {
			System.out.println("nDate = " + i.getnDate());
		}
		

		SubProjectDAO Subpdao = new SubProjectDAO();
		ArrayList<SubProjectDO> SubpList = Subpdao.SubProjectList(Integer.parseInt(nFrom));
		
		for(SubProjectDO i : SubpList) {
			i.setSubpStartDate(i.getSubpStartDate().substring(0, 10));
			i.setSubpEndDate(i.getSubpEndDate().substring(0, 10));			
		}
		
		ProjectDAO Pdao = new ProjectDAO();
		ProjectDO project = Pdao.getInfo(Integer.parseInt(nFrom));
		
		Parser parser = new Parser();
		String tmp = project.getpMember();
		
		ArrayList<String> pMember = null;
		
		MemberDAO mdao = new MemberDAO();
		ArrayList<MemberDO> member = new ArrayList<MemberDO>();
		
		MemberDO pManager = mdao.getInfo(project.getpManager());
		System.out.println(pManager.getFilename());
		
		if(tmp != null) {
			pMember= parser.parseProjectMember(tmp);
			
			for(String i : pMember) {
				MemberDO temp = mdao.getInfo(i);
				member.add(temp);
			}		
		}
		//////
		
		
		
		
		
		

		request.setAttribute("subProjectList", SubpList);
		request.setAttribute("NoticeList", noticeList);		
		request.setAttribute("pMember", member);		
		//request.setAttribute("pMember", pMember);		
		request.setAttribute("pManager", pManager);
		request.setAttribute("pCode", nFrom);
		
		//request.setAttribute("curProject", nFrom);
	}
}
