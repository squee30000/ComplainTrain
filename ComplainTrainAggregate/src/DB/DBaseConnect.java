package DB;
import java.sql.*;

public class DBaseConnect {
	
	private Connection connection;
	public DBaseConnect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/complainTrainCore");	
	}
	public boolean LoginAttempt(String ID) throws SQLException {
		Statement statement = connection.createStatement();
		
		ResultSet RS = statement.executeQuery
				("SELECT * FROM employee WHERE FName = '"+ ID + "'; ");
		
		RS.next(); 
		
		//System.out.println(RS.getString(1));
		
		//return true;
		if(RS.getString("rank")!= "0") {
			return true;
		}else {
			
			System.out.println("Not quite working Eli");
			System.out.println(RS.getString("rank"));
			return false;
		}
		
		
		
	}
}
