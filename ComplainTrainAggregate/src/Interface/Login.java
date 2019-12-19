package Interface;
//import java.io.IOException;
import java.sql.SQLException;

import DB.DBaseConnect;
//import DB.NetworkConnect;
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
import javafx.geometry.Pos;

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
			gPane.setAlignment(Pos.CENTER_LEFT);
       
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
					
					try {
						DB.DBaseConnect connection = new DBaseConnect();
						
						LoginObject answer = connection.LoginAttempt(userText.getText());
						if(answer != null && answer.rank >= 3) {
							
							Complaint c = new Complaint(answer);
							c.start(primaryStage);
							
						}
						if(answer != null && answer.rank < 3) {
							
							LogObjGUI c = new LogObjGUI(answer);
							c.start(primaryStage);
							
						}else {
							
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
			
			EventHandler<ActionEvent> eventCancel = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					primaryStage.close();

				}
			};
			
			ok.setOnAction(eventOk);
			cancel.setOnAction(eventCancel);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	boolean NetworkLogin() {
		
		return false;
	}

	public static void main(String[] args) {
		launch(args);
		//DB.NetworkConnect N =  new NetworkConnect();
	}
} 
