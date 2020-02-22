package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	Button teste;
	Stage window;
	Scene scene;
	applicationTrees months = new applicationTrees();
	TreeView<String> monthTree = months.getMonths();
	applicationMenu menu = new applicationMenu();
	DataLayout dataLayout = new DataLayout();
	Data data = new Data();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("MoneyTalks");
		window.setMaximized(true);

		BorderPane layout = new BorderPane();
		layout.setTop(menu.menuItems());
		layout.setRight(dataLayout.newData());
		layout.setCenter(data.createChart());
		
		scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();

	}

}
