package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.MemberDAO;
import TF.model.MemberDO;

public class TaskFlowMemberListCmd implements TaskFlowCmd {

	public void execute(HttpServletRequest request, HttpServletResponse response)  {

		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDO> list = dao.list();
		
		request.setAttribute("list",list);
	}

}
