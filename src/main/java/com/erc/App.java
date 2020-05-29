package com.erc;

import com.erc.layout.DataLayout;
import com.erc.layout.OverviewLayout;
import com.erc.util.HibernateUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 * JavaFX App
 */

public class App extends Application {

    public static Session session = HibernateUtil.getSessionFactory().openSession();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        DataLayout dataLayout = new DataLayout();
        OverviewLayout overviewLayout = new OverviewLayout();
        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setTitle("MoneyTalks");
        primaryStage.setMaximized(true);

        TabPane tabPane = new TabPane();
        Tab spendingsTab = new Tab("Spendings");
        Tab incomeTab = new Tab("Income");
        Tab overviewTab = new Tab("Overview");
        tabPane.getTabs().addAll(spendingsTab, incomeTab, overviewTab);
        spendingsTab.setContent(dataLayout.getSpendingsLayout());
        incomeTab.setContent(dataLayout.getIncomeLayout());
        overviewTab.setContent(overviewLayout.getOverviewLayout());

        vbox.getChildren().addAll(tabPane);

        scene.getStylesheets().add(getClass().getResource("/css/App.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Session getSession() {
        return session;
    }
}