package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
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

		window = primaryStage;
		window.setTitle("MoneyTalks");
		window.setMaximized(true);

		BorderPane layout = new BorderPane();
		layout.setTop(menu.menuItems());
		layout.setRight(dataLayout.newData());

		Button teste = new Button();
		teste.setStyle("-fx-background-image: url(\"../icons/add-icon2.png\");" + "-fx-background-radius: 50;"
				+ "-fx-min-width: 300;" + "-fx-min-height: 300;" + "-fx-max-width: 300;" + "-fx-max-height: 300;"
		+ "-fx-background-color: rgb(86, 6, 172);");
		layout.setCenter(teste);
		
		
		scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();

	}

}
