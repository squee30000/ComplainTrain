package DB;
import java.sql.*;

import Interface.LoginObject;

public class DBaseConnect {
	
	private Connection connection;
	public DBaseConnect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/complainTrainCore");	
	}
	public LoginObject LoginAttempt(String ID) throws SQLException {
		Statement statement = connection.createStatement();
		
		ResultSet RS = statement.executeQuery
				("SELECT * FROM employee WHERE FName = '"+ ID + "'; ");
		
		RS.next(); 
		
		//System.out.println(RS.getString(1));
		
		//return true;
		if(RS.getString("rank")!= "0") {
			
			LoginObject LO = new LoginObject(RS.getString("EmployeeID"),Integer.parseInt(RS.getString("rank")));
			return LO;
		}else {
			return null;
		}
	}
	
	
	
	
	public void sendAnonComplaint(ComplaintObject c)throws SQLException {
		PreparedStatement p;
		p = connection.prepareStatement("INSERT into complaint (complaintBody) values(?);");
		p.setString(1, c.getText());
		p.execute();
	}
	
	public ResultSet getComplaintsUnresolved()throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet RS = statement.executeQuery("SELECT complaintBody, FName, LName " + 
				"FROM complaint c, employee e " + 
				"WHERE c.complaintResolution <> 1 " + 
				"	AND c.complaintEmployee = e.employeeID;");
		
		return RS;
	}
	public ResultSet getAnonComplaintsUnresolved()throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet RS = statement.executeQuery("SELECT complaintBody\r\n" + 
				"FROM complaint c\r\n" + 
				"WHERE c.complaintResolution <> 1\r\n" + 
				"	AND c.complaintID NOT IN(\r\n" + 
				"		SELECT complaintID\r\n" + 
				"		FROM complaint c, employee e\r\n" + 
				"		WHERE c.complaintResolution = 0\r\n" + 
				"			AND c.complaintEmployee = e.employeeID \r\n" + 
				"	);");
		
		return RS;
	}
	
	public void sendComplaint(ComplaintObject c)throws SQLException{
		PreparedStatement p;
		p = connection.prepareStatement("INSERT into complaint (complaintBody,complaintEmployee) values(?,?);");
		
		p.setString(2, c.getName());
		p.setString(1, c.getText());
		p.execute();
		
	}
}
