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
	public void sendComplaint(ComplaintObject c)throws SQLException {
		PreparedStatement p = connection.prepareStatement("INSERT into complaint (complaintBody) values(?);");
		p.setString(1, c.getText());
		
		p.execute();
		
		Statement statement = connection.createStatement();
		
		ResultSet complaintRecord = statement.executeQuery("SELECT complaintID" + 
				"FROM complaint c, complaintCategory cg, category g, employee e, complaintemployee ce " + 
				"WHERE c.complaintID = cg.complaintID " + 
				"	AND cg.categoryID = g.categID " + 
				"	AND c.complaintID=ce.complaintID " + 
				"	AND ce.employeeID = e.employeeID " + 
				"	AND complaintBody =  "+c.getText()+";");
		
		complaintRecord.next();
		
		p = connection.prepareStatement("INSERT into complaintemployee (complaintID, employeeID) values(?);");
		
		p.setString(1, c.getName());
		p.setString(2, complaintRecord.getString(1));

		
	}
}
