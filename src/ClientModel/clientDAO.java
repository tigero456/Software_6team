package ClientModel;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import VO.duesVO;
import VO.loginVO;

public class clientDAO {
	BufferedReader in;
	PrintWriter out;
	ObjectOutputStream ob_out;
	ObjectInputStream ob_in;
	public clientDAO(Socket socket) {  
		try { 
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			ob_out = new ObjectOutputStream(socket.getOutputStream()); 
			ob_in= new ObjectInputStream(socket.getInputStream());
            
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	public int checkId(String id) {
		int intCheck = 0;
		String check = "0";
		out.println("checkId--"+id); 
		out.flush(); 
		while(true){
			try {
				check = in.readLine();
				if(check.equals("0")==true) {
					intCheck = 0;
					return intCheck;
				}else if(check.equals("1")==true){
					intCheck = 1;
					return intCheck;
				}
			} catch (IOException e) { 
				e.printStackTrace();
			}
		} 
		 
	}
	public int createUser(loginVO login) {
		int id_che = this.checkId(login.getId());
		if(id_che==0) { 
			return id_che;
		} 
		out.println("createUser--"+login.getId()+"--"+login.getPw()); 
		out.flush();  
		id_che+=1;
		return id_che;
	}
	public int[] checkIdPw(loginVO login) {
		String check = "0";
		String[] checkList = null;
		int[] id_che= new int[2];
		out.println("checkIdPw--"+login.getId()+"--"+login.getPw()); 
		out.flush(); 
		try {
			check = in.readLine();
			checkList = check.split("-");
		} catch (IOException e) { 
			e.printStackTrace();
		}
		if(checkList[0].equals("0")==true) {
			id_che[0] = 0;
			return id_che;
		}else if(checkList[0].equals("1")==true){
			id_che[0] = 1;
			id_che[1] = Integer.parseInt(checkList[1]);
			return id_che;
		} 
		return id_che;
	}
	public void duesAdd(duesVO dues,String id) { 
		out.println("duesAdd--"+id+"--"+dues.getDues_name()+"--"+dues.getDues()+"--"+dues.getDues_date()); 
		out.flush(); 
	}
	public void duesDel(duesVO dues) {
		out.println("duesDel--"+dues.getDues_id()); 
		out.flush(); 
	}
	public List<duesVO> duesSearch(loginVO login,String date) {
		List<duesVO> duesList = new ArrayList<duesVO>();
		out.println("duesAdd--"+login.getLogin_id()+"--"+date); 
		out.flush();
		try {
			ob_out.writeObject(login);
			out.flush();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		try {
			duesList = (List<duesVO>)ob_in.readObject();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return duesList;
	}
	public void duesUpdate(duesVO dues) {
		out.println("duesUpdate--"+dues.getDues_id()+"--"+dues.getDues_name()+"--"+dues.getDues()+"--"+dues.getDues_date());
		out.flush();
	}
}
