import java.io.*;

import java.net.InetSocketAddress;

import java.net.Socket;

import javax.swing.JOptionPane;

public class NetworkConnect{
	private Socket s;
	private OutputStream outputStream;
	private ObjectOutputStream objOutputStream;
	
	public NetworkConnect() throws IOException {
		s = new Socket("localhost", 7070); //Needs to be changed to connect to database
		outputStream = s.getOutputStream();
		objOutputStream = new ObjectOutputStream(outputStream);	
		
	}
	
	public void sendObject(ComplaintObject complaint) throws IOException {
		objOutputStream.writeObject(complaint);
	}
}
	

