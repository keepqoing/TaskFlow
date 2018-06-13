package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.NoticeDAO;

public class TaskFlowProjectNoticeDeleteCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		String nId = request.getParameter("nId");

		NoticeDAO dao = new NoticeDAO();
		dao.deleteNotice(Integer.parseInt(nId));
	}
}