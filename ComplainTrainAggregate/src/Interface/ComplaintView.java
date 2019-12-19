package Interface;

//import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.*;
public class ComplaintView {
	DBaseConnect DB;
	

	public ComplaintView()
	{
		try {
			DB = new DBaseConnect();
		} catch (ClassNotFoundException e) {
			//Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getComplaint(String txt) {
		
		return "";
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
			Button ok = new Button("View");
			TextArea complaintView = new TextArea();
			ListView<String> listView = new ListView<String>();

			TextField searchTxt = new TextField();
			gPane.add(complaintView, 2, 20);
			gPane.add(listView,2,15);
			gPane.add(ok,5,1);
			
			primaryStage.setTitle("Complaint View");
			primaryStage.setScene(scene);
			
			primaryStage.show();
	

			EventHandler<ActionEvent> eventView = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					try {
						ResultSet RS = DB.getComplaintsUnresolved();
						while(RS.next()) {
							String result=RS.getString(1)+" Submitted by "+ RS.getString(3)+", "+RS.getString(2);
							listView.getItems().add(result);
							
						}
						RS= DB.getAnonComplaintsUnresolved();
						while(RS.next()) {
							String result=RS.getString(1)+" Submitted Anonymously";
							listView.getItems().add(result);
							
						}
						
					} catch (SQLException e1) {
						//Auto-generated catch block
						e1.printStackTrace();
					}
					//String s = getComplaint(searchTxt.getText());
					//complaintView.setText(s);
				}
					
			};
			
			ok.setOnAction(eventView);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
