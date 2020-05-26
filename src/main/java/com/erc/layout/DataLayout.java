package com.erc.layout;

import com.erc.components.DataVBox;
import com.erc.enums.Type;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class DataLayout {

    private DataVBox incomeVBox = new DataVBox(Type.INCOME);
    private DataVBox spendingsVBox = new DataVBox(Type.SPENDINGS);

    private BorderPane incomeLayout;
    private BorderPane spendingsLayout;

    public DataLayout() {
        createIncomeLayout();
        createSpendingsLayout();
    }

    public void createIncomeLayout() {

        VBox vbox = new VBox(8);
        vbox.getChildren().addAll(incomeVBox.getNewDataVBox(), incomeVBox.getDataLogs(), incomeVBox.getLogsHBox());

        incomeLayout = new BorderPane();
        incomeLayout.setRight(vbox);
        incomeLayout.setStyle("-fx-background-color: white;");

    }

    public void createSpendingsLayout() {

        VBox vbox = new VBox(8);
        vbox.getChildren().addAll(spendingsVBox.getNewDataVBox(), spendingsVBox.getDataLogs(), spendingsVBox.getLogsHBox());

        spendingsLayout = new BorderPane();
        spendingsLayout.setRight(vbox);
        spendingsLayout.setStyle("-fx-background-color: white;");

    }

    public BorderPane getIncomeLayout() {
        return incomeLayout;
    }

    public BorderPane getSpendingsLayout() {
        return spendingsLayout;
    }
}
