package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.NoticeDAO;

public class TaskFlowNoticeCreateCmd implements TaskFlowCmd{

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		
		String nName = request.getParameter("nName");
		String nDescript = request.getParameter("nDescript");
		String nFrom = (String) session.getAttribute("currentProject");
		String nWriter = (String) session.getAttribute("sessionID");
		
		NoticeDAO noticedao = new NoticeDAO();
		noticedao.createNotice(nName, nDescript, nWriter, Integer.parseInt(nFrom));		
	}

}