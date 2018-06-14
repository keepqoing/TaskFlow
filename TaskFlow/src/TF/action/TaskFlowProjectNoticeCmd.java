package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.NoticeDAO;
import TF.model.NoticeDO;
import TF.model.ProjectDAO;
import TF.model.ProjectDO;

public class TaskFlowProjectNoticeCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		//String nFrom = request.getParameter("pCode");
		
		HttpSession session = request.getSession();
		String currentUser = (String)session.getAttribute("sessionID");
		String nFrom = (String)session.getAttribute("currentProject");
		
		NoticeDAO Noticedao = new NoticeDAO();
		ArrayList<NoticeDO> noticeList = Noticedao.NoticeList(Integer.parseInt(nFrom));
		
		ProjectDAO Pdao = new ProjectDAO();
		ProjectDO pData = Pdao.getInfo(Integer.parseInt(nFrom));
		String pManager = pData.getpManager();
		
		request.setAttribute("NoticeList", noticeList);
		request.setAttribute("pCode", nFrom);
		
		//관리자에게만 공지사항 생성버튼을 보이게 하기 위함
		request.setAttribute("User", currentUser);
		request.setAttribute("pManager", pManager);
		
		
		//request.setAttribute("curProject", nFrom);
	}
}