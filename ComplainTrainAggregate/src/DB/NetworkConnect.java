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
		s = new Socket("localhost", 7070); 
		outputStream = s.getOutputStream();
		objOutputStream = new ObjectOutputStream(outputStream);	
		
	}
	
	public void sendObject(ComplaintObject complaint) throws IOException {
		//objOutputStream.writeObject(complaint);
		try {
			DBaseConnect db = new DBaseConnect();
			db.sendComplaint(complaint);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendLogin() throws IOException{
		
		
	}
}
	

