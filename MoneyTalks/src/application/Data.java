package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Data extends Category {
	
	private Float amount;
	private Category category;
	private LocalDate date;
	public ObservableList<Data> dataList = FXCollections.observableArrayList();
	public ObservableList<XYChart.Data<Number, String>> chartData = FXCollections.observableArrayList();
	
	public Data(Float amount, Category category, LocalDate date) {
		
		this.amount = amount;
		this.category = category;
		this.date = date;
		dataList.add(this);
		addChartData();
		System.out.println(dataList);
		System.out.println(chartData);
		
	}
	
	public Data(Float amount, String comboBoxValue, LocalDate date) {
		
		this.amount = amount;
		this.date = date;
		//Look for the category name and select its category
		for (int i = 0; i < categories.size(); i++) {
			if (comboBoxValue.equals(categories.get(i).getCategoryName())) {
				this.category = categories.get(i);
				System.out.println(categories.get(i).getCategoryName());
			}
		}
		dataList.add(this);
		addChartData();
		System.out.println(dataList);
		System.out.println(chartData);
	}
	
	public LocalDate getDate() {
		//format localdate style
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

	public Data() {}

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
	
	public void addChartData() {

		for (int i = 0; i < dataList.size(); i++) {
			chartData.add(
					new XYChart.Data<>(dataList.get(i).getAmount(), dataList.get(i).getCategory().getCategoryName()));
		}
	}
	
}
