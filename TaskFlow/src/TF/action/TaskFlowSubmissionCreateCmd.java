package TF.action;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import TF.model.SubProjectDAO;
import TF.model.SubmissionDAO;
import TF.model.SubmissionDO;

public class TaskFlowSubmissionCreateCmd implements TaskFlowCmd{

	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		
		String pCode = (String) session.getAttribute("currentProject");
		String Writer = (String) session.getAttribute("sessionID");

		
				
		String uploadPath = "C:\\Users\\USER\\git\\TaskFlow\\TaskFlow\\WebContent\\file\\";
		int size = 10*1024*1024;
		
		try {
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());	
		
		String comment = multi.getParameter("comment");
		String spCode = multi.getParameter("subpId");
		
		Enumeration files = multi.getFileNames();	
		
		String file = (String)files.nextElement();
		String filename = multi.getFilesystemName(file);		
		
		SubmissionDAO dao = new SubmissionDAO();
		dao.upload(pCode, spCode, Writer, comment, filename);
		
		request.setAttribute("subpId",spCode);
		System.out.println("제발..." + spCode);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}