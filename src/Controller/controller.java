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
}

