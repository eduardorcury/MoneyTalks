package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class ApplicationChart extends Data {
	
	
	public ObservableList<XYChart.Series<Number, String>> list = FXCollections.observableArrayList();
	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private XYChart.Series<Number, String> spendingsSeries;
	private StackedBarChart<Number, String> spendingsChart;
	
	public void createChart() {
		
		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();
		
		spendingsChart = new StackedBarChart<>(xAxis, yAxis);
		list.add(spendingsSeries);
		spendingsChart.setData(list);
	}

	public void addChartData(Float amount, Category category) {
		spendingsSeries.getData().add(new XYChart.Data<Number, String>(amount, category.toString()));
	}

}
