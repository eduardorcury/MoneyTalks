package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ApplicationCharts {
	
	private NumberAxis incomeXAxis;
	private NumberAxis spendingsXAxis;
	private CategoryAxis incomeYAxis;
	private CategoryAxis spendingsYAxis;
	private static StackedBarChart<Number, String> incomeChart;
	private static StackedBarChart<Number, String> spendingsChart;
	public static XYChart.Series<Number, String> incomeSeries = new XYChart.Series<>();
	public static XYChart.Series<Number, String> spendingsSeries = new XYChart.Series<>();
	
	static XYChart.Data<Number, String> newData;
	
	public StackedBarChart<Number, String> createIncomeChart() {
		
		incomeXAxis = new NumberAxis();
		incomeYAxis = new CategoryAxis();
		
		incomeChart = new StackedBarChart<>(incomeXAxis, incomeYAxis);
		incomeChart.getStylesheets().add("/BarChart.css");
		incomeChart.getData().add(incomeSeries);
		incomeChart.legendVisibleProperty().setValue(false);
		return incomeChart;
	}
	
	public StackedBarChart<Number, String> createSpendingsChart() {
		
		spendingsXAxis = new NumberAxis();
		spendingsYAxis = new CategoryAxis();
		
		spendingsChart = new StackedBarChart<>(spendingsXAxis, spendingsYAxis);
		spendingsChart.getStylesheets().add("/BarChart.css");
		spendingsChart.getData().add(spendingsSeries);
		spendingsChart.legendVisibleProperty().setValue(false);
		return spendingsChart;
	}
	
	public static void addChartData(Data data) {
		
		String type = data.getCategory().getCategoryType();
		
		XYChart.Data<Number, String> newData = new XYChart.Data<Number, String>(data.getAmount(), data.getCategory().getCategoryName());
		XYChart.Series<Number, String> dataSeries = new XYChart.Series<Number, String>();
		dataSeries.getData().add(newData);
		
		newData.nodeProperty().addListener(new ChangeListener<Node>() {
			  @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
				  changeColor(newNode, data);
			  }
		});
		
		//newData.setNode(new OnDataHover(data.getAmount()));
		
		if (type == "Income") {
			incomeChart.getData().add(dataSeries);
		}
		
		if (type == "Spendings") {
			spendingsChart.getData().add(dataSeries);
		}
	}

	public static void changeColor(Node newNode, Data data) {
		newNode.setStyle("-fx-bar-fill: rgb(" + data.getCategory().getCategoryColor().getRed()*255 + ","
				+ data.getCategory().getCategoryColor().getGreen()*255 + ","
				+ data.getCategory().getCategoryColor().getBlue()*255 + ");");
	}
	
	class OnDataHover extends StackPane {
		OnDataHover(Number amount) {
			VBox vbox = new VBox(10);
			Label label = new Label("$" + amount.toString());
			vbox.getChildren().addAll(label);
			vbox.setAlignment(Pos.CENTER);
			vbox.getStylesheets().add("BarChart.css");
			vbox.setId("#chart-box");
			
			setOnMouseEntered(event -> {
				getChildren().setAll(vbox);
				setCursor(Cursor.HAND);
			});
			
			setOnMouseExited(event -> {
				getChildren().clear();
			});
		}
	}
	
}













