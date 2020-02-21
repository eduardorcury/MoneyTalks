package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class ApplicationChart extends Data {

	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private static StackedBarChart<Number, String> spendingsChart;
	private static ObservableList<XYChart.Series<Number, String>> chartSeries = FXCollections.observableArrayList();

	public StackedBarChart<Number, String> createChart() {

		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();

		spendingsSeries.getData().addAll(chartData);
		spendingsChart = new StackedBarChart<>(xAxis, yAxis);
		chartSeries.add(spendingsSeries);
		spendingsChart.getData().add(spendingsSeries);
		
		
		return spendingsChart;
	}
}
