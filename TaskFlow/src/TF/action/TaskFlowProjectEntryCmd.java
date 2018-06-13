package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if(nFrom == null)
			nFrom = (String) session.getAttribute("currentProject");
		else
			session.setAttribute("currentProject", nFrom);
		
		NoticeDAO Noticedao = new NoticeDAO();
		ArrayList<NoticeDO> noticeList = Noticedao.NoticeList(Integer.parseInt(nFrom));

		SubProjectDAO Subpdao = new SubProjectDAO();
		ArrayList<SubProjectDO> SubpList = Subpdao.SubProjectList(Integer.parseInt(nFrom));
		
		ProjectDAO Pdao = new ProjectDAO();
		ProjectDO project = Pdao.getInfo(Integer.parseInt(nFrom));
		
		Parser parser = new Parser();
		String tmp = project.getpMember();
		
		ArrayList<String> pMember = null;
		
		if(tmp != null)
			pMember= parser.parseProjectMember(tmp);

		request.setAttribute("NoticeList", noticeList);
		request.setAttribute("SubpList", SubpList);
		request.setAttribute("pMember", pMember);		
		request.setAttribute("pManager", project.getpManager());
		request.setAttribute("pCode", nFrom);
		
		//request.setAttribute("curProject", nFrom);
	}
}
