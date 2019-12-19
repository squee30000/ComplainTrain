package DB;
import java.sql.*;

public class DBaseConnect {
	
	private Connection connection;
	public DBaseConnect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/complainTrainCore");	
	}
	public String LoginAttempt(String ID) throws SQLException {
		Statement statement = connection.createStatement();
		
		ResultSet RS = statement.executeQuery
				("SELECT * FROM employee WHERE FName = '"+ ID + "'; ");
		
		RS.next(); 
		
		//System.out.println(RS.getString(1));
		
		//return true;
		if(RS.getString("rank")!= "0") {
			return RS.getString("EmployeeID");
		}else {
			return "";
		}
	}
	
	
	
	public void sendAnonComplaint(ComplaintObject c)throws SQLException {
		PreparedStatement p;
		p = connection.prepareStatement("INSERT into complaint (complaintBody) values(?);");
		p.setString(1, c.getText());
		p.execute();
	}
	
	public void sendComplaint(ComplaintObject c)throws SQLException{
		PreparedStatement p;
		p = connection.prepareStatement("INSERT into complaint (complaintBody,complaintEmployee) values(?,?);");
		
		p.setString(2, c.getName());
		p.setString(1, c.getText());
		p.execute();
		
	}
}
