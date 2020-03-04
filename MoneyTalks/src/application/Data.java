package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Data extends Category {

	private Float amount;
	private Category category;
	private LocalDate date;
	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private static StackedBarChart<Number, String> spendingsChart;
	private static ObservableList<Data> dataList = FXCollections.observableArrayList();
	private static ObservableList<XYChart.Series<Number, String>> chartSeries = FXCollections.observableArrayList();
	private static ObservableList<XYChart.Data<Number, String>> chartData = FXCollections.observableArrayList();

	public Data(Float amount, Category category, LocalDate date) {

		this.amount = amount;
		this.category = category;
		this.date = date;
		dataList.add(this);

	}

	public Data(Float amount, String comboBoxValue, LocalDate date) {

		this.amount = amount;
		this.date = date;
		// Look for the category name and select its category
		for (int i = 0; i < categories.size(); i++) {
			if (comboBoxValue.equals(categories.get(i).getCategoryName())) {
				this.category = categories.get(i);
			}
		}
		dataList.add(this);
		spendingsChart.getData().add(addChartData());
	}

	public LocalDate getDate() {
		// format localdate style
		return date;
	}

	public ObservableValue<String> dateProperty() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
		String text = date.format(formatter);
		LocalDate newDate = LocalDate.parse(text, formatter);
		ObservableValue<String> observableLocalDate = new SimpleStringProperty(newDate.toString());
		return observableLocalDate;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Data() {
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public ObservableValue<String> categoryProperty() {
		ObservableValue<String> observableCategoryName = new SimpleStringProperty(category.getCategoryName());
		return observableCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public XYChart.Series<Number, String> addChartData() {
		// add this Data object to Observable List
		XYChart.Data<Number, String> newData = new XYChart.Data<Number, String>(this.getAmount(), this.getCategory().getCategoryName());
		XYChart.Series<Number, String> dataSeries = new XYChart.Series<Number, String>();
		
		dataSeries.getData().add(newData);
		chartSeries.add(dataSeries);
		chartData.add(newData);
		newData.nodeProperty().addListener(new ChangeListener<Node>() {
			  @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
				  changeColor(newNode);
			  }
		});
		newData.setNode(new OnDataHover(this.getAmount()));
		
		return dataSeries;
	}
	
	public void changeColor(Node newNode) {
		newNode.setStyle("-fx-bar-fill: rgb(" + this.getCategory().getCategoryColor().getRed()*255 + ","
				+ this.getCategory().getCategoryColor().getGreen()*255 + ","
				+ this.getCategory().getCategoryColor().getBlue()*255 + ");");
	}

	public StackedBarChart<Number, String> createChart() {

		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();
		
		spendingsChart = new StackedBarChart<>(xAxis, yAxis);
		spendingsChart.getStylesheets().add("/BarChart.css");
		return spendingsChart;
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
