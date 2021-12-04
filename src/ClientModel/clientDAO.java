package ClientModel;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
		out.println("checkId"); 
		out.flush();
		out.println(id); 
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
		out.println("sign_sub"); 
		out.flush();
		try {
			ob_out.writeObject(login);
			out.flush();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		id_che+=1;
		return id_che;
	}
	public int checkIdPw(loginVO login) {
		String check = "0";
		int id_che= 0;
		out.println("checkIdPw"); 
		out.flush();
		try {
			ob_out.writeObject(login);
			out.flush();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		try {
			check = in.readLine();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		if(check.equals("0")==true) {
			id_che = 0;
			return id_che;
		}else if(check.equals("1")==true){
			id_che = 1;
			return id_che;
		} 
		return id_che;
	}
}
