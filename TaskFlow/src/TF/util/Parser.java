package TF.util;

import java.util.ArrayList;

public class Parser {
	
	public ArrayList<String> parseProjectMember(String pMember){
		System.out.println("By Parser pMember = " + pMember);
		String[] pMembers = pMember.split(",");

		ArrayList<String> list = new ArrayList<String>();
		
		for(String i : pMembers) {
			list.add(i);
		}
		
		return list;
	}
}
