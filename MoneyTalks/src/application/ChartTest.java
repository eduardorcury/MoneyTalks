package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChartTest extends Application {

	private XYChart.Series<Number, String> gastos;
	private CategoryAxis yAxis;
	private NumberAxis xAxis;
	private StackedBarChart<Number, String> barChart;

	public static void main(String[] args) {
		launch(args);
	}

	public void createChart() {

		XYChart.Data<Number, String> comida = new XYChart.Data<>(200, "Comida");
		XYChart.Data<Number, String> roupa1 = new XYChart.Data<>(500, "Roupa");
		XYChart.Data<Number, String> roupa2 = new XYChart.Data<>(300, "Roupa");

		yAxis = new CategoryAxis();
		xAxis = new NumberAxis();
		yAxis.setTickLabelFont(new Font("Ubuntu bold", 15));

		xAxis.setLabel("Gastos");
		yAxis.setLabel("R$");

		gastos.getNode().getStyleClass().add("series-" + gastos);

		gastos = new XYChart.Series<Number, String>();
		gastos.getData().add(comida);
		gastos.getData().addAll(roupa1, roupa2);
		
		barChart = new StackedBarChart<>(xAxis, yAxis);
		barChart.getData().add(gastos);
		barChart.setStyle("fx-bar-fill: navy;");
		barChart.setPrefWidth(100);
		barChart.setOnDragDetected(e -> xAxis.setLabel("teste"));

		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		this.createChart();
		BorderPane layout = new BorderPane();
		layout.setCenter(barChart);
		Scene scene = new Scene(layout, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
}