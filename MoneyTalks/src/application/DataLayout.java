package application;

import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataLayout {

	public HBox valueHBox;
	public HBox categoryHBox;
	public VBox completeVBox;
	public Label valueLabel;
	public Label categoryLabel;
	public Button cancelButton;
	public Button confirmButton;
	public Button addNewCategoryButton;
	public TextField valueInput;
	public TextField categoryField;
	public Stage addNewCategoryStage;
	public TableView<Data> contentLogs;
	
	public static ComboBox<String> categoryComboBox = new ComboBox<>();

	
	public VBox newData() {
		
		addNewCategoryButton = new Button("Add");
		categoryLabel = new Label("Category");
		valueLabel = new Label("Amount");
		valueInput = new TextField();
		categoryHBox = new HBox(10);
		completeVBox = new VBox(20);
		valueHBox = new HBox(10);
		
		valueInput.setPromptText("$");
		valueInput.setPrefWidth(100);
		valueHBox.setPadding(new Insets(0, 90, 0, 0));
		valueHBox.setPrefWidth(300);
		valueHBox.setAlignment(Pos.CENTER_RIGHT);
		categoryHBox.setMinHeight(20);
		categoryHBox.setMaxHeight(20);
		categoryHBox.setPrefWidth(300);
		categoryHBox.setAlignment(Pos.CENTER_RIGHT);

		addNewCategoryButton.setOnAction(event -> AddNewCategory.addNewCategoryWindow());

		valueHBox.getChildren().addAll(valueLabel, valueInput);
		categoryHBox.getChildren().addAll(categoryLabel, getCategoryComboBox(), addNewCategoryButton);
		completeVBox.getChildren().addAll(valueHBox, categoryHBox, getContentLogs());
		completeVBox.setPadding(new Insets(30, 30, 30, 30));
	
		return completeVBox;
		
	}
	
	public ComboBox<String> getCategoryComboBox() {
		
		Button addCategory = new Button("Add category");
		addCategory.setPrefWidth(150);
		
		categoryComboBox.setPrefWidth(150);
		categoryComboBox.setOnShowing(event -> categoryComboBox.setPromptText(""));
		categoryComboBox.setOnHiding(event -> categoryComboBox.setPromptText("Select category"));
		categoryComboBox.setPlaceholder(addCategory);
		categoryComboBox.getPlaceholder().setOnMousePressed(event -> AddNewCategory.addNewCategoryWindow());
		categoryComboBox.setPromptText("Select category");
		
		return categoryComboBox;
		
	}
	
	public TableView<Data> getContentLogs() {
		
		contentLogs = new TableView<Data>();
		TableColumn<Data, Double> amountColumn = new TableColumn<>("Amount");
		TableColumn<Data, String> categoryColumn = new TableColumn<>("Category");
		TableColumn<Data, Date> dateColumn = new TableColumn<>("Date");
		
		amountColumn.setMinWidth(100);
		categoryColumn.setMinWidth(100);
		dateColumn.setMinWidth(100);
		contentLogs.getColumns().addAll(amountColumn, categoryColumn, dateColumn);
		
		return contentLogs;

	}
	
	public static void setCategoryComboBox(String categoryName) {
		
		categoryComboBox.getItems().add(categoryName);

	}
	
	

}
