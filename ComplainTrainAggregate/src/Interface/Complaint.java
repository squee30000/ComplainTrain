package Interface;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Complaint extends Application {
	public Complaint()
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
       
			Scene scene = new Scene(gPane,800,400);


			Button submit = new Button("Submit");
			Label name = new Label("Name: ");
			Label dept = new Label("Department: ");
			Label complaint = new Label("Complaint:");
			TextField nameTxt = new TextField();
			TextArea complaintEntry = new TextArea();
			CheckBox anon = new CheckBox();
			Label anonLabel = new Label("Anonymous");
			
			ComboBox deptList = new ComboBox();
			deptList.getItems().addAll(
				"HR",
				"IT",
				"Accounting",
				"Sales"
			);
			
			gPane.add(name, 0, 0);
			gPane.add(nameTxt, 2, 0);
			gPane.add(anon, 3, 0);
			gPane.add(anonLabel, 4, 0);
			gPane.add(dept, 0, 1); 
			gPane.add(deptList, 2, 1);
			gPane.add(complaint, 2, 10);
			gPane.add(complaintEntry, 2, 12);
			gPane.add(submit, 2, 20);
			

			
			primaryStage.setTitle("Submit Complaint");
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
