package Interface;
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
	
	private boolean adminCheckUname(String str)
	{
		if (str.equals("Admin")) {
			return true;
		}
		return false;
	}
	
	private boolean adminCheckPwd(String str)
	{
		if (str.equals("Pwd")) {
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
			Label wrong = new Label("Wrong Username or Password")
			TextField userText = new TextField();
			TextField pwdText = new TextField();
			
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
					if (adminCheckUname(userText.getText()))
					{
						if (adminCheckPwd(pwdText.getText()))
						{
							Admin c = new Admin();
							c.start(primaryStage);
						}
						else
							wrong.setVisible(true);
					}
					
					else if (checkUname(userText.getText()))
					{
						if (checkPwd(pwdText.getText()))
						{
							Complaint c = new Complaint();
							c.start(primaryStage);
						}
						else
							wrong.setVisible(true);
					}
					else
						wrong.setVisible(true);
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

	public static void main(String[] args) {
		launch(args);
	}
} 
