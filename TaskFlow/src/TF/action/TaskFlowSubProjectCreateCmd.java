package TF.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.SubProjectDAO;

public class TaskFlowSubProjectCreateCmd implements TaskFlowCmd{

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
	
		
		String SubpName = request.getParameter("SubpName");
		String SubpDescript = request.getParameter("SubpDescript");
		String SubpStartDate = request.getParameter("SubpStartDate");
		String SubpEndDate = request.getParameter("SubpEndDate");
		String SubpFrom = (String) session.getAttribute("currentProject");
		
		SubProjectDAO subPdao = new SubProjectDAO();
		subPdao.createSubProject(SubpName, SubpDescript, SubpStartDate, SubpEndDate, Integer.parseInt(SubpFrom));
	}

}