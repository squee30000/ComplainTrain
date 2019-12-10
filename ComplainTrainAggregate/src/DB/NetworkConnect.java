package DB;
import java.io.*;

import java.net.InetSocketAddress;

import java.net.Socket;

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
		objOutputStream.writeObject(complaint);
	}
	public void sendLogin() throws IOException{
		
		
	}
}
	

