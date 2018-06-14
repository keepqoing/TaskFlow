package TF.action;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import TF.model.MemberDAO;
import TF.model.MemberDO;

public class TaskFlowMemberJoinCmd implements TaskFlowCmd{

	public void execute(HttpServletRequest request, HttpServletResponse response)  {

//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
		
		String uploadPath = "C:\\Users\\USER\\git\\TaskFlow\\TaskFlow\\WebContent\\file\\";
		int size = 10*1024*1024;
		
		try {
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());	
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		String email = multi.getParameter("email");
		String phone = multi.getParameter("phone");
		
		Enumeration files = multi.getFileNames();	
		
		String file = (String)files.nextElement();
		String filename = multi.getFilesystemName(file);		
		
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberDO> list = dao.list();
		
		//중복검사 필요
		
		dao.join( id, pw , name, email, phone , filename );
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
