package Interface;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Admin extends Application {
	public Admin()
	{
	}
	
	private void search(String text)
	{
		
	}
	
	private void archive()
	{
		
	}
	
	private void resolve()
	{
		
	}
	
	private voide delete()
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
       
			Scene scene = new Scene(gPane,800,700);


			Button submit = new Button("Submit");
			Button ok = new Button("OK");
			
			Label search = new Label("Search: ");
			Label list = new Label("List: ");
			Label resolve = new Label("Resolve");
			Label archive = new Label("Archive");
			Label delete = new Label("Delete");
			Label complaint = new Label("Complaint: ");
			
			CheckBox resolveC = new CheckBox();
			CheckBox archiveC = new CheckBox();
			CheckBox deleteC = new CheckBox();
			
			TextField searchTxt = new TextField();
			TextArea complaintView = new TextArea();
			ListView<String> listView = new ListView();
			
			ObservableList<String> complaints = FXCollections.observableArrayList(
				"Complaint 1",
				"Complaint 2"
			);
			listView.setItems(complaints);

			
			
			gPane.add(search, 0, 0);
			gPane.add(searchTxt, 2, 0);
			gPane.add(submit, 3, 0);
			
			gPane.add(list, 0, 1); 
			gPane.add(listView, 2, 1);
			
			gPane.add(archiveC, 1, 2);
			gPane.add(archive, 2, 2);
			gPane.add(resolveC, 1, 4);
			gPane.add(resolve, 2, 4);
			gPane.add(deleteC, 1, 6);
			gPane.add(delete, 2, 6);
			
			gPane.add(complaint, 2, 15);
			gPane.add(complaintView, 2, 20);
			gPane.add(ok, 3, 20);
			

			
			primaryStage.setTitle("Administration");
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			EventHandler<ActionEvent> eventSubmit = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					search(searchTxt.getText());

				}
			};
			
			EventHandler<ActionEvent> eventOk = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e)
				{
					if (archiveC.isSelected())
						archive();
					if (resolveC.isSelected())
						resolve();
					if (deleteC.isSelected())
						delete();
				}
			};
			
			submit.setOnAction(eventSubmit);
			ok.setOnAction(eventOk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
