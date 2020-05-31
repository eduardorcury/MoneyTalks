package com.erc.components;

import com.erc.domain.ChartData;
import com.erc.domain.Data;
import com.erc.domain.Lists;
import com.erc.enums.Type;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class ApplicationCharts {

    private static StackedBarChart<Number, String> incomeChart;
    private static StackedBarChart<Number, String> spendingsChart;

    public static XYChart.Series<Number, String> incomeSeries = new XYChart.Series<>();
    public static XYChart.Series<Number, String> spendingsSeries = new XYChart.Series<>();

    public ApplicationCharts() {

        NumberAxis incomeXAxis = new NumberAxis();
        CategoryAxis incomeYAxis = new CategoryAxis();
        NumberAxis spendingsXAxis = new NumberAxis();
        CategoryAxis spendingsYAxis = new CategoryAxis();

        incomeChart = new StackedBarChart<>(incomeXAxis, incomeYAxis);
        incomeChart.getStylesheets().add(getClass().getResource("/css/BarChart.css").toExternalForm());
        incomeChart.getData().add(incomeSeries);
        incomeChart.legendVisibleProperty().setValue(false);

        spendingsChart = new StackedBarChart<>(spendingsXAxis, spendingsYAxis);
        spendingsChart.getStylesheets().add(getClass().getResource("/css/BarChart.css").toExternalForm());
        spendingsChart.getData().add(spendingsSeries);
        spendingsChart.legendVisibleProperty().setValue(false);

        for (ChartData chartData : Lists.getChartDataList()) {
            if (chartData.getCategory().getCategoryType().equals(Type.INCOME)) {
                incomeChart.getData().add(chartData.getChartSeries());
            }
            if (chartData.getCategory().getCategoryType().equals(Type.SPENDINGS)) {
                spendingsChart.getData().add(chartData.getChartSeries());
            }
        }
    }

    public static void addChartData(Data data) {


    }

    public static void changeColor(Node newNode, Data data) {
        newNode.setStyle("-fx-bar-fill: rgb(" + data.getCategory().getCategoryRGB() + ");");
    }

    public static StackedBarChart<Number, String> getIncomeChart() {
        return incomeChart;
    }

    public static StackedBarChart<Number, String> getSpendingsChart() {
        return spendingsChart;
    }
}
