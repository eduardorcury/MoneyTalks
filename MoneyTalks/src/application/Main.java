package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene;
	applicationTrees months = new applicationTrees();
	TreeView<String> monthTree = months.getMonths();
	applicationMenu menu = new applicationMenu();
	DataLayout dataLayout = new DataLayout();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
		ColorPicker colorPicker = new ColorPicker();
		colorPicker.getStyleClass().add("split-button");
		
		DatePicker datePicker1 = new DatePicker();
		DatePicker datePicker2 = new DatePicker();
		datePicker1.getStylesheets().add("DatePicker.css");
		
		datePicker1.setPromptText("Enter item date");
		
		VBox dateBox = new VBox();
		dateBox.getChildren().addAll(datePicker1, datePicker2);

		window = primaryStage;
		window.setTitle("MoneyTalks");
		window.setMaximized(true);
		
		BorderPane layout = new BorderPane();
		layout.setTop(menu.menuItems());
		layout.setCenter(colorPicker);
		layout.setLeft(dateBox);
		layout.setRight(dataLayout.newData());
		scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();

	}

}
