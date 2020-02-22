package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class Data extends Category {

	private Float amount;
	private Category category;
	private LocalDate date;
	private NumberAxis xAxis;
	private CategoryAxis yAxis;
	private static StackedBarChart<Number, String> spendingsChart;
	private static XYChart.Series<Number, String> spendingsSeries = new XYChart.Series<>();
	private static ObservableList<Data> dataList = FXCollections.observableArrayList();
	private static ObservableList<XYChart.Data<Number, String>> chartData = FXCollections.observableArrayList();
	private static ObservableList<XYChart.Series<Number, String>> chartSeries = FXCollections.observableArrayList();

	

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
				System.out.println(categories.get(i).getCategoryName());
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
		XYChart.Series<Number, String> dataSeries = new XYChart.Series<>();
		dataSeries.getData()
				.addAll(new XYChart.Data<Number, String>(this.getAmount(), this.getCategory().getCategoryName()));
		dataSeries.setName(this.getCategory().getCategoryName());
		chartSeries.add(dataSeries);
		return dataSeries;
	}
	
	public StackedBarChart<Number, String> createChart() {

		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();
		
		spendingsChart = new StackedBarChart<>(xAxis, yAxis);
		return spendingsChart;
	}
}
