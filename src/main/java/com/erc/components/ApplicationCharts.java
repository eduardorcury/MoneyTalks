package com.erc.components;

import com.erc.domain.Data;
import com.erc.domain.Lists;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;

public class ApplicationCharts {

    private static StackedBarChart<Number, String> incomeChart;
    private static StackedBarChart<Number, String> spendingsChart;

    public ApplicationCharts() {

        NumberAxis incomeXAxis = new NumberAxis();
        CategoryAxis incomeYAxis = new CategoryAxis();
        NumberAxis spendingsXAxis = new NumberAxis();
        CategoryAxis spendingsYAxis = new CategoryAxis();

        incomeChart = new StackedBarChart<>(incomeXAxis, incomeYAxis, Lists.getIncomeData());
        incomeChart.getStylesheets().add(getClass().getResource("/css/BarChart.css").toExternalForm());
        incomeChart.legendVisibleProperty().setValue(false);

        spendingsChart = new StackedBarChart<>(spendingsXAxis, spendingsYAxis, Lists.getSpendingsData());
        spendingsChart.getStylesheets().add(getClass().getResource("/css/BarChart.css").toExternalForm());
        spendingsChart.legendVisibleProperty().setValue(false);

    }

    public static void changeColor(Node newNode, Data data) {
        newNode.setStyle("-fx-bar-fill: rgb(" + data.getCategory().getCategoryRGB() + ");" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2;");
    }

    public static StackedBarChart<Number, String> getIncomeChart() {
        return incomeChart;
    }

    public static StackedBarChart<Number, String> getSpendingsChart() {
        return spendingsChart;
    }

}
