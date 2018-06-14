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

public class TaskFlowSubProjectCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		//String nFrom = request.getParameter("pCode");
		
		HttpSession session = request.getSession();
		String currentUser = (String)session.getAttribute("sessionID");
		String nFrom = (String)session.getAttribute("currentProject");
		
		
		SubProjectDAO subPdao = new SubProjectDAO();
		ArrayList<SubProjectDO> subPList = subPdao.SubProjectList(Integer.parseInt(nFrom));
		
		for(SubProjectDO i : subPList) {
			i.setSubpStartDate(i.getSubpStartDate().substring(0, 10));
			i.setSubpEndDate(i.getSubpEndDate().substring(0, 10));			
		}
		
		ProjectDAO Pdao = new ProjectDAO();
		ProjectDO pData = Pdao.getInfo(Integer.parseInt(nFrom));
		String pManager = pData.getpManager();
		
		
		request.setAttribute("SubpList", subPList);
		request.setAttribute("pCode", nFrom);
		
		//관리자에게만 과제 생성버튼을 보이게 하기 위함
		request.setAttribute("User", currentUser);
		request.setAttribute("pManager", pManager);
		
		//request.setAttribute("curProject", nFrom);
	}
}