package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.NoticeDAO;

public class TaskFlowProjectNoticeUpdateCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String nName = request.getParameter("nName");
		String nDescript = request.getParameter("nDescript");
		String nId = request.getParameter("nId");
		
		NoticeDAO dao = new NoticeDAO();
		dao.updateNotice(nName, nDescript, Integer.parseInt(nId));
	}
}