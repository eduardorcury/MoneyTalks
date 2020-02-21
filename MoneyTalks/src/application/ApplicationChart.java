package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class ApplicationChart extends Data {

	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private StackedBarChart<Number, String> spendingsChart;
	private XYChart.Series<Number, String> spendingsSeries = new XYChart.Series<>();
	private static ObservableList<XYChart.Series<Number, String>> chartSeries = FXCollections.observableArrayList();

	public void createChart() {

		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();

		spendingsSeries.getData().addAll(chartData);
		spendingsChart = new StackedBarChart<>(xAxis, yAxis);
		chartSeries.add(spendingsSeries);
		spendingsChart.setData(chartSeries);
	}
}
