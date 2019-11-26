import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.InetSocketAddress;

import java.net.Socket;

import javax.swing.JOptionPane;

import //ComplaintObject

public class NetworkConnect{
	private Socket s;
	private OutputStream outputStream;
	private ObjectOutputStream objOutputStream;
	
	public NetworkConnect(){
		s = new Socket("localhost", 7070); //Needs to be changed to connect to database
		outputStream = s.getOutputStream();
		objOutputStream = new ObjectOutputStream(outputStream);	
		
	}
	
	public void sendObject(ComplaintObject complaint){
		objOutputStream.writeObject(complaint);
	}
}
	

