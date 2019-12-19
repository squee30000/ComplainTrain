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
	
	//Test
	public LoginObject l = new LoginObject("Test", 3);
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

	}
	

	
	public void start(Stage primaryStage) {
		try {
	
			//BorderPane root = new BorderPane();
			GridPane gPane = new GridPane();
			gPane.setPadding(new Insets(10, 10, 10, 10));  
			gPane.setVgap(5); 
			gPane.setHgap(5);       
			//gPane.setAlignment(Pos.LEFT);
       
			Scene scene = new Scene(gPane,300,200);



			Button view = new Button("View complaints");
			Button complain = new Button("Submit complaint");


			

			
			gPane.add(view, 0, 20);
			gPane.add(complain, 2, 20);


			
			primaryStage.setTitle("Select Task");
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