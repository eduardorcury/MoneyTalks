package com.erc.layout;

import com.erc.components.ApplicationCharts;
import com.erc.components.DataVBox;
import com.erc.enums.Type;
import javafx.geometry.Insets;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class DataLayout {

    private DataVBox incomeVBox = new DataVBox(Type.INCOME);
    private DataVBox spendingsVBox = new DataVBox(Type.SPENDINGS);

    private ApplicationCharts charts = new ApplicationCharts();

    private BorderPane incomeLayout;
    private BorderPane spendingsLayout;

    public DataLayout() {
        createIncomeLayout();
        createSpendingsLayout();
    }

    public void createIncomeLayout() {

        StackedBarChart<Number, String> incomeChart = charts.getIncomeChart();
        VBox vbox = new VBox(8);
        vbox.getChildren().addAll(incomeVBox.getNewDataVBox(), incomeVBox.getDataLogs(), incomeVBox.getLogsHBox());

        incomeLayout = new BorderPane();
        incomeLayout.setRight(vbox);
        incomeLayout.setCenter(incomeChart);
        BorderPane.setMargin(incomeLayout.getCenter(), new Insets(0, 10, 0, 0));
        incomeLayout.setStyle("-fx-background-color: white;");

    }

    public void createSpendingsLayout() {

        StackedBarChart<Number, String>  spendingsChart = charts.getSpendingsChart();
        VBox vbox = new VBox(8);
        vbox.getChildren().addAll(spendingsVBox.getNewDataVBox(), spendingsVBox.getDataLogs(), spendingsVBox.getLogsHBox());

        spendingsLayout = new BorderPane();
        spendingsLayout.setRight(vbox);
        spendingsLayout.setCenter(spendingsChart);
        BorderPane.setMargin(spendingsLayout.getCenter(), new Insets(0, 10, 0, 0));
        spendingsLayout.setStyle("-fx-background-color: white;");

    }

    public BorderPane getIncomeLayout() {
        return incomeLayout;
    }

    public BorderPane getSpendingsLayout() {
        return spendingsLayout;
    }
}
