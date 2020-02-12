package application;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class ApplicationChart {
	
	private XYChart.Series<Float, String> spendingsSeries;
	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private StackedBarChart<Float, String> spendingsChart;
	
	public void createChart() {
		
		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();
		xAxis.setLabel("$");
		yAxis.setLabel("Group");
		
	}

}
