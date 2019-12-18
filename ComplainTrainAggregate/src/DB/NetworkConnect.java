package DB;
import java.io.*;

import java.net.InetSocketAddress;

import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class NetworkConnect{
	private Socket s;
	private OutputStream outputStream;
	private ObjectOutputStream objOutputStream;
	
	
	//"Localhost" needs to be replaced with a static IP of the machine running the server
	public NetworkConnect() throws IOException {
		s = new Socket("192.168.0.75", 7070); 
		outputStream = s.getOutputStream();
		objOutputStream = new ObjectOutputStream(outputStream);	
		
	}
	
	public void sendObject(ComplaintObject complaint) throws IOException {
		//objOutputStream.writeObject(complaint);
		try {
			objOutputStream.writeObject(complaint);
		} catch(IOException i) {
			System.out.println(i);
		}
	}
	public void sendLogin(String login, String pwd) throws IOException{
		try {
			objOutputStream.writeUTF(login);
			objOutputStream.writeUTF(pwd);
		} catch(IOException i) {
			System.out.println(i);
		}
		
		
	}
}
	

