package Controller;

import java.net.Socket;

import ClientModel.clientDAO;
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
}

