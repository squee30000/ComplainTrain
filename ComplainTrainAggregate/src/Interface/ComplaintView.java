package Interface;

import java.io.IOException;

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

public class ComplaintView {

	public ComplaintView()
	{
	}
	
	private String getComplaint(String txt) {
		
		
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
			ListView<String> listView = new ListView();

			TextField searchTxt = new TextField();
			gPane.add(complaintView, 2, 20);
			
			primaryStage.setTitle("Complaint View");
			primaryStage.setScene(scene);
			
			primaryStage.show();
	

			EventHandler<ActionEvent> eventView = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					String s = getComplaint(searchTxt.getText());
					complaintView.setText(s);
				}
					
			};
			
			ok.setOnAction(eventView);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
