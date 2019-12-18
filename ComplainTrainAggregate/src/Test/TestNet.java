package Test;

import java.io.IOException;

import DB.NetworkConnect;

public class TestNet {
	NetworkConnect n = new NetworkConnect();
	
	public TestNet() {
		
	}
	
	public void Send() throws IOException {
		n.sendLogin("complaintrain");
	}
	
	public static void main(String[] args) {
		TestNet t = new TestNet();
		try {
			t.Send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
