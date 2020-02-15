package application;

import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataLayout {

	public HBox valueHBox;
	public HBox categoryHBox;
	public HBox calendarHBox;
	public VBox completeLayout;
	public Label valueLabel;
	public Label categoryLabel;
	public Label calendarLabel;
	public DatePicker calendar;
	public Button cancelButton;
	public Button confirmButton;
	public Button addNewCategoryButton;
	public TextField valueInput;
	public TextField categoryField;
	public Stage addNewCategoryStage;
	public TableView<Data> contentLogs;
	public Separator separator1;
	public Separator separator2;
	public ComboBox<String> typeComboBox = new ComboBox<>();

	public static ComboBox<String> categoryComboBox = new ComboBox<>();

	public VBox newData() {

		separator1 = new Separator(Orientation.HORIZONTAL);
		separator2 = new Separator(Orientation.HORIZONTAL);
		separator1.setCenterShape(true);
		separator2.setCenterShape(true);
		separator1.setPadding(new Insets(0, 0, 0, 0));
		
		addNewCategoryButton = new Button();
		categoryLabel = new Label("Category:");
		valueLabel = new Label("Amount:");
		calendarLabel = new Label("Day:");
		valueInput = new TextField();
		valueHBox = new HBox(10);
		categoryHBox = new HBox(10);
		calendarHBox = new HBox(10);
		completeLayout = new VBox(5);
		//completeLayout.setPrefColumns(1);
		calendar = new DatePicker();

		valueInput.setPromptText("Enter value");
		valueHBox.setPadding(new Insets(0, 0, 0, 10));
		calendarHBox.setPadding(new Insets(0, 0, 0, 32));
		calendar.getStylesheets().add("DatePicker.css");
		calendar.setPromptText("Enter item date");
		calendar.setEditable(false);
		valueHBox.setAlignment(Pos.CENTER);
		categoryHBox.setAlignment(Pos.CENTER);
		calendarHBox.setAlignment(Pos.CENTER);
		addNewCategoryButton.setId("add-button");
		
		typeComboBox.setId("combo-box1");
		categoryComboBox.setId("combo-box2");

		typeComboBox.setPrefWidth(80);
		typeComboBox.getItems().addAll("Expense", "Income");

		typeComboBox.setPromptText("Type");
		addNewCategoryButton.setOnAction(event -> AddNewCategory.addNewCategoryWindow());

		valueHBox.getChildren().addAll(valueLabel, valueInput, typeComboBox);
		categoryHBox.getChildren().addAll(categoryLabel, getCategoryComboBox(), addNewCategoryButton);
		calendarHBox.getChildren().addAll(calendarLabel, calendar);
		completeLayout.getChildren().addAll(valueHBox, separator1, categoryHBox, separator2, calendarHBox);
		completeLayout.setPadding(new Insets(10, 10, 10, 10));
		//completeLayout.setVgap(2);

		completeLayout.getStylesheets().add("DataLayout.css");
		completeLayout.getStyleClass().add("vbox");
		categoryHBox.getStyleClass().add("hbox");
		valueHBox.getStyleClass().add("hbox");
		calendarHBox.getStyleClass().add("hbox");

		return completeLayout;

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
