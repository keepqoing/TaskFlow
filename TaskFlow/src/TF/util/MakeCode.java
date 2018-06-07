package TF.util;

import java.util.ArrayList;
import java.util.Random;

import TF.model.ProjectDAO;

public class MakeCode {
	public int CreateCode() {
		//참여코드 생성기로 참여코드 생성
		
		ProjectDAO dao = new ProjectDAO();	
		ArrayList<Integer> datas = dao.codeList();
		
		Random random = new Random();
        
		int result = random.nextInt(10000)+1000;
		 
		if(result>10000){
		    result = result - 1000;
		}		
		
		for(int i : datas) {

			if(i == result) 
				return 0;			
		}
				
		return result;
	}
}
