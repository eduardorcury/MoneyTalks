package application;

import java.util.Observable;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChartTest extends Application {

	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private XYChart.Series<Number, String> ifood;
	private XYChart.Series<Number, String> bandeco;
	private XYChart.Series<Number, String> aluguel;
	private XYChart.Series<Number, String> condominio;
	private XYChart.Series<Number, String> saques;
	private XYChart.Series<Number, String> passagem;
	private XYChart.Series<Number, String> tarifa;
	private StackedBarChart<Number, String> barChart;
	private Label label;

	public static void main(String[] args) {
		launch(args);
	}

	public void createChart() {

		ifood = new XYChart.Series<>();
		bandeco = new XYChart.Series<>();
		aluguel = new XYChart.Series<>();
		condominio = new XYChart.Series<>();
		saques = new XYChart.Series<>();
		passagem = new XYChart.Series<>();
		tarifa = new XYChart.Series<>();
		
		ifood.setName("iFood");
		bandeco.setName("Bandejão");
		aluguel.setName("Aluguel");
		condominio.setName("Condomínio");
		saques.setName("Saques");
		passagem.setName("Passagem");
		tarifa.setName("Tarifa");
		
		
		ifood.getData().add(new XYChart.Data<>(400, "Comida"));
		bandeco.getData().add(new XYChart.Data<>(150, "Comida"));
		aluguel.getData().add(new XYChart.Data<>(450, "Moradia"));
		condominio.getData().add(new XYChart.Data<>(500, "Moradia"));
		saques.getData().add(new XYChart.Data<>(400, "Outros"));
		passagem.getData().add(new XYChart.Data<>(500, "Outros"));
		tarifa.getData().add(new XYChart.Data<>(50, "Tarifa"));
		
		
		yAxis = new CategoryAxis();
		xAxis = new NumberAxis();
		//yAxis.setTickLabelFont(new Font("Ubuntu bold", 15));

		yAxis.setLabel("Gastos");
		yAxis.getCategories().addAll("iFood", "Bandejão", "Aluguel", "Condomínio", "Saques",
									 "Passagem", "Tarifa");
		xAxis.setLabel("R$");

		barChart = new StackedBarChart<>(xAxis, yAxis);
		barChart.setAnimated(true);
		barChart.setCategoryGap(20);
		barChart.getData().add(ifood);
		barChart.getData().add(aluguel);
		barChart.getData().add(condominio);
		barChart.getData().add(bandeco);
		barChart.getData().add(saques);
		barChart.getData().add(passagem);
		
		barChart.getStylesheets().add("BarChart.css");
		barChart.setOnMouseEntered(event -> System.out.println("teste"));

		label = new Label("teste");
		ifood.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
		event -> System.out.println("teste"));
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		this.createChart();
		BorderPane layout = new BorderPane();
		Button add = new Button("Adicionar");
		Button kill = new Button("Retirar");
		add.setOnAction(event -> barChart.getData().add(tarifa));
		
		layout.setPadding(new Insets(100, 100, 100, 100));
		layout.setCenter(barChart);
		layout.setBottom(add);
		layout.setLeft(label);
		
		
		Scene scene = new Scene(layout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}