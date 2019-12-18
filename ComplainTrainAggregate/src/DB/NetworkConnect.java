package DB;
import java.io.*;

import java.net.InetSocketAddress;

import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class NetworkConnect{
	private Socket s;
	private OutputStream outputStream;
	private ObjectOutputStream objOutputStream;
	private PrintWriter out;
	
	//"Localhost" needs to be replaced with a static IP of the machine running the server
	public NetworkConnect() {
		try {
			s = new Socket("192.168.0.75", 7071);
			out = new PrintWriter(s.getOutputStream());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			outputStream = s.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objOutputStream = new ObjectOutputStream(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void sendObject(ComplaintObject complaint) throws IOException {
		//objOutputStream.writeObject(complaint);
		try {
			objOutputStream.writeObject(complaint);
		} catch(IOException i) {
			System.out.println(i);
		}
	}
	public void sendLogin(String pwd) throws IOException{
		out.println("");
		out.flush();
		out.println(pwd);
		out.flush();

		
		
	}
}
	

