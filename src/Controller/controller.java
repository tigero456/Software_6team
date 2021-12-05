package Controller;

import java.net.Socket;
import java.util.List;

import ClientModel.clientDAO;
import VO.duesVO;
import VO.loginVO;

public class controller {
	clientDAO c;
	public controller(Socket socket){
		c = new clientDAO(socket);
	}
	
	public int[] login(String id, String pw){
		loginVO lov = new loginVO("0", id, pw);
		int[] i=c.checkIdPw(lov);
		
		return i;
	}
	public int join(String id, String pw){
		loginVO lov = new loginVO("0", id, pw);
		int i=c.createUser(lov);
		
		return i;
	}
	public List<duesVO> searchdate(String year, String month, int id){
		String i=year+"-"+month;
		List<duesVO> j;
		j=c.duesSearch(id, i);
		
		return j;
	}
	public void add(String name, String dues, String date, int id){ 
		String id1 = Integer.toString(id);
		duesVO dues1 = new duesVO("0",name,dues,date,id1);
		c.duesAdd(dues1, id1);
	}
	public void del(String id){
		duesVO dues1 = new duesVO(id,"0","","",""); 
		c.duesDel(dues1);
		 
	}
	public void update(String id, String dues, String date,String name){ 
		duesVO dues1 = new duesVO(id,name,dues,date,""); 
		c.duesUpdate(dues1);
		 
	}
}

