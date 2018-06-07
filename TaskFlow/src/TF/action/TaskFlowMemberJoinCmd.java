package TF.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TF.model.MemberDAO;
import TF.model.MemberDO;

public class TaskFlowMemberJoinCmd implements TaskFlowCmd{

	public void execute(HttpServletRequest request, HttpServletResponse response)  {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberDO> list = dao.list();
		
		//중복검사 필요
		
		dao.join( id, pw , name, email, phone );
	}

}
