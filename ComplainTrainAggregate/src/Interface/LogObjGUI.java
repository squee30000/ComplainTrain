package Interface;
import java.io.IOException;
import java.sql.SQLException;

import DB.*;
import javafx.application.Application;

import javafx.event.*;

import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
//import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class LogObjGUI extends Application {
	public String user;
	public int rank;
	/*
	 * Final constructor
	 */
	
	public LogObjGUI(LoginObject LO)
	{
		user = LO.getName();
		rank = LO.getRank();
	}
	
	
	/*
	 * Test constructor
	 */
	
	public LogObjGUI()
	{
		user = "test";
		rank = 2;
	}
	
	private void upload(String name, String complaint, String dept) throws IOException {
		DB.ComplaintObject c = new ComplaintObject(user, complaint, dept);
		DB.DBaseConnect db;
		try {
			db = new DB.DBaseConnect();
			db.sendComplaint(c);
		} catch (ClassNotFoundException e1) {
			// Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void upload(String complaint, String dept) throws IOException {
		DB.ComplaintObject c = new ComplaintObject(complaint, dept);
		DB.DBaseConnect db;
		try {
			db = new DB.DBaseConnect();
			db.sendAnonComplaint(c);
		} catch (ClassNotFoundException e1) {
			//Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			//Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void start(Stage primaryStage) {
		try {
	
			//BorderPane root = new BorderPane();
			GridPane gPane = new GridPane();
			gPane.setPadding(new Insets(10, 10, 10, 10));  
			gPane.setVgap(5); 
			gPane.setHgap(5);       
			//gPane.setAlignment(Pos.LEFT);
       
			Scene scene = new Scene(gPane,800,400);


			Button view = new Button("View complaints");
			Button complain = new Button("Submit complaint");
			
			//gPane.add(name, 0, 0);
			//gPane.add(nameTxt, 2, 0);
			
			gPane.add(view,3,3);
			gPane.add(complain,5,3);
			

			
			primaryStage.setTitle("Choose Path");
			primaryStage.setScene(scene);
			
			primaryStage.show();
	

			EventHandler<ActionEvent> eventView = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					
					
					
					ComplaintView cv = new ComplaintView();
					cv.start(primaryStage);
				}
					
			};
			
			EventHandler<ActionEvent> eventComplain = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Complaint c = new Complaint(new LoginObject(user, rank));
					c.start(primaryStage);
				}
				
			};
			
			view.setOnAction(eventView);
			complain.setOnAction(eventComplain);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}