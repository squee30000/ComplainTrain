package Interface;
import java.io.IOException;
import java.sql.SQLException;

import DB.DBaseConnect;
import DB.NetworkConnect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Login extends Application {
	//private Event
	public Login()
	{
	}
	
	private boolean checkUname(String str)
	{
		if (str.equals("Complain")) {
			return true;
		}
		return false;
	}
	
	private boolean checkPwd(String str)
	{
		if (str.equals("Train")) {
			return true;
		}
		return false;
	}
	
	public void start(Stage primaryStage) {
		try {
			String[] args = null;
			//BorderPane root = new BorderPane();
			GridPane gPane = new GridPane();
			gPane.setPadding(new Insets(10, 10, 10, 10));  
			gPane.setVgap(5); 
			gPane.setHgap(5);       
			//gPane.setAlignment(Pos.LEFT);
       
			Scene scene = new Scene(gPane,350,200);
			Button ok = new Button("OK");
			Button cancel = new Button("Cancel");
			Label username = new Label("Username: ");
			Label passwd = new Label("Password: ");
			TextField userText = new TextField();
			TextField pwdText = new TextField();
			
			gPane.add(username, 0, 0);
			gPane.add(userText, 2, 0);
			gPane.add(passwd, 0, 5);
			gPane.add(pwdText, 2, 5);
			gPane.add(ok, 0, 20);
			gPane.add(cancel, 3, 20);
			
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			
			primaryStage.show();
			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					/*if (checkUname(userText.getText()))
						if (checkPwd(pwdText.getText()))
						{
							Complaint c = new Complaint();
							c.start(primaryStage);
						}
					*/
					
					try {
						DB.DBaseConnect connection = new DBaseConnect();
						
						
						if(connection.LoginAttempt(userText.getText())) {
							Complaint c = new Complaint();
							c.start(primaryStage);
							
						}
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			};
			
			ok.setOnAction(event);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	boolean NetworkLogin() {
		
		return false;
	}

	public static void main(String[] args) {
		launch(args);
		try {
			DB.NetworkConnect N =  new NetworkConnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
