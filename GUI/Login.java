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
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class Login extends Application {
	//private Event
	public Login()
	{
	}
	/*

	*/
	public void start(Stage primaryStage) {
		try {
			//String[] args = null;
			//BorderPane root = new BorderPane();
			GridPane gPane = new GridPane();
			gPane.setPadding(new Insets(10, 10, 10, 10));  
			gPane.setVgap(5); 
			gPane.setHgap(5);       
			//gPane.setAlignment(Pos.LEFT);
       
			Scene scene = new Scene(gPane,400,210);
			Button ok = new Button("OK");
			Button cancel = new Button("Cancel");
			Label username = new Label("Username: ");
			Label passwd = new Label("Password: ");
			Label wrong = new Label("Wrong Username or Password");
			TextField userText = new TextField();
			PasswordField pwdText = new PasswordField();
			
			gPane.add(username, 0, 0);
			gPane.add(userText, 2, 0);
			gPane.add(passwd, 0, 5);
			gPane.add(pwdText, 2, 5);
			gPane.add(ok, 0, 20);
			gPane.add(cancel, 3, 20);
			gPane.add(wrong, 0, 15);
			
			wrong.setVisible(false);
			
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			
			primaryStage.show();
			EventHandler<ActionEvent> eventOk = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					
					/*
					 * Networking Stuff
					 */
					DB.NetworkConnect connection = new NetworkConnect();
					
					//String answer = connection.sendLogin(userText.getText());

						try {
							connection.sendLogin(userText.getText());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					String answer = "1";
					if(answer != "") {
						
						Complaint c = new Complaint(answer);
						c.start(primaryStage);
						
					}
					
					/*
					 * Directly access the database
					 *
					try {
						DB.DBaseConnect connection = new DBaseConnect();
						
						String answer = connection.LoginAttempt(userText.getText());
						if(answer != "") {
							
							Complaint c = new Complaint(answer);
							c.start(primaryStage);
						}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			};*/
			
			EventHandler<ActionEvent> eventCancel = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					primaryStage.close();

				}
			};
				ok.setOnAction(eventOk);
				cancel.setOnAction(eventCancel);
			
			
				
			
			
	}
	boolean NetworkLogin() {
		
		return false;
	}
		
	public static void main(String[] args) {
		launch(args);
		
	}
} 
