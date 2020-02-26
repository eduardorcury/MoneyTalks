package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
	Tab spendingsTab;
	Tab incomeTab;
	TabPane tabPane;
	VBox vbox;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("MoneyTalks");
		window.setMaximized(true);

		BorderPane layout = new BorderPane();
		layout.setRight(dataLayout.newData());
		layout.setCenter(data.createChart());
		
		tabPane = new TabPane();
		spendingsTab = new Tab("Spendings");
		incomeTab = new Tab("Income");
		tabPane.getTabs().addAll(spendingsTab, incomeTab);
		spendingsTab.setContent(layout);
		
		vbox = new VBox();
		vbox.getChildren().addAll(menu.menuItems(), tabPane);
		
		scene = new Scene(vbox, 400, 300);
		window.setScene(scene);
		window.show();

	}

}
