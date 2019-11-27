package DB;
import java.sql.*;

public class DBaseConnect {
	
	private Connection connection;
	public DBaseConnect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("complainTrainCore");	
	}
	public boolean LoginAttempt(String ID) throws SQLException {
		Statement statement = connection.createStatement();
		
		ResultSet RS = statement.executeQuery
				("SELECT rank FROM employee WHERE FName = '"+ ID + "'; ");
		
		RS.next(); 
		if(RS.getString(0)=="2") {
			return true;
		}else {
			return false;
		}
		
		
	}
}
