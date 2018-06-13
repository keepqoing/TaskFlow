package TF.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TF.model.SubProjectDAO;
import TF.model.SubProjectDO;

public class TaskFlowSubProjectModifyCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		//String nFrom = request.getParameter("pCode");
		
		HttpSession session = request.getSession();
		String currentUser = (String)session.getAttribute("sessionID");
		String nFrom = (String)session.getAttribute("currentProject");
		int subpId = Integer.parseInt(request.getParameter("subpId"));
		
		
		SubProjectDAO subProjectdao = new SubProjectDAO();
		SubProjectDO  subProject = subProjectdao.readSubProject(subpId);
		
		SimpleDateFormat  dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		request.setAttribute("subProject",subProject);
				
		//request.setAttribute("curProject", nFrom);
	}
}