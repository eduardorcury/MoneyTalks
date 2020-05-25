package com.erc;

import com.erc.layout.DataLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    Stage window;
    Scene scene;

    DataLayout dataLayout = new DataLayout();

    Tab spendingsTab;
    Tab incomeTab;
    Tab overviewTab;
    TabPane tabPane;
    VBox vbox;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("MoneyTalks");
        window.setMaximized(true);

        tabPane = new TabPane();
        spendingsTab = new Tab("Spendings");
        incomeTab = new Tab("Income");
        overviewTab = new Tab("Overview");
        tabPane.getTabs().addAll(spendingsTab, incomeTab, overviewTab);
        spendingsTab.setContent(dataLayout.createSpendingsLayout());
        incomeTab.setContent(dataLayout.createIncomeLayout());

        vbox = new VBox();
        vbox.getChildren().addAll(tabPane);

        scene = new Scene(vbox, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/css/App.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
}