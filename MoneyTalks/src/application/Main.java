package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene;
	applicationTrees months = new applicationTrees();
	TreeView<String> monthTree = months.getMonths();
	applicationMenu menu = new applicationMenu();
	ApplicationData left = new ApplicationData();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("MoneyTalks");
		window.setMaximized(true);
		
		BorderPane layout = new BorderPane();
		layout.setTop(menu.menuItems());
		// layout.setLeft(monthTree);
		layout.setRight(left.dataVBox());
		scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();

	}

}
