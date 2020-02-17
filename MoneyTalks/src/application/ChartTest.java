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

	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private XYChart.Series<Number, String> ifood;
	private XYChart.Series<Number, String> bandeco;
	private XYChart.Series<Number, String> aluguel;
	private XYChart.Series<Number, String> condominio;
	private StackedBarChart<Number, String> barChart;

	public static void main(String[] args) {
		launch(args);
	}

	public void createChart() {

		ifood = new XYChart.Series<>();
		bandeco = new XYChart.Series<>();
		aluguel = new XYChart.Series<>();
		condominio = new XYChart.Series<>();
		
		ifood.setName("iFood");
		bandeco.setName("Bandejão");
		aluguel.setName("Aluguel");
		condominio.setName("Condomínio");
		
		ifood.getData().add(new XYChart.Data<>(400, "Comida"));
		bandeco.getData().add(new XYChart.Data<>(150, "Comida"));
		aluguel.getData().add(new XYChart.Data<>(450, "Moradia"));
		condominio.getData().add(new XYChart.Data<>(500, "Moradia"));
		
		XYChart.Data<Number, String> teste = new XYChart.Data<>();
		
		
		yAxis = new CategoryAxis();
		xAxis = new NumberAxis();
		//yAxis.setTickLabelFont(new Font("Ubuntu bold", 15));

		yAxis.setLabel("Gastos");
		yAxis.getCategories().addAll("iFood", "Bandejão", "Aluguel", "Condomínio");
		xAxis.setLabel("R$");

		barChart = new StackedBarChart<>(xAxis, yAxis);
		barChart.getData().add(ifood);
		barChart.getData().add(aluguel);
		barChart.getData().add(condominio);
		barChart.getData().add(bandeco);
		
		barChart.setPrefWidth(50);
		barChart.getStylesheets().add("BarChart.css");
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
	}
	
}