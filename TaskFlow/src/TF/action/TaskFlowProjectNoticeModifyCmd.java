package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.NoticeDAO;
import TF.model.NoticeDO;

public class TaskFlowProjectNoticeModifyCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		//String nFrom = request.getParameter("pCode");
		
		HttpSession session = request.getSession();
		String currentUser = (String)session.getAttribute("sessionID");
		String nFrom = (String)session.getAttribute("currentProject");
		int nId = Integer.parseInt(request.getParameter("nId"));
		
		
		NoticeDAO Noticedao = new NoticeDAO();
		NoticeDO notice = Noticedao.readNotice(nId);
		
		request.setAttribute("notice",notice);
				
		//request.setAttribute("curProject", nFrom);
	}
}