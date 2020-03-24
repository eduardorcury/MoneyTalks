package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DataLayoutVBox {

	public HBox valueHBox;
	public HBox categoryHBox;
	public HBox calendarHBox;
	public HBox logsHBox;
	public VBox completeLayout;
	public Label valueLabel;
	public Label categoryLabel;
	public Label calendarLabel;
	public Label messageLabel;
	public DatePicker calendar;
	public Button cancelButton;
	public Button confirmButton;
	public Button addDataButton;
	public Button addNewCategoryButton;
	public Button editDataButton;
	public Button deleteDataButton;
	public TextField valueInput;
	public TextField categoryField;
	public Stage addNewCategoryStage;
	public TableView<Data> contentLogs;
	public Separator separator1;
	public Separator separator2;
	public Separator separator3;
	
	public String dataLayoutType;
	
	public Font font = new Font("Ubuntu Bold", 16);
	public ObservableList<Boolean> checkData = FXCollections.observableArrayList(false, false, false);

	public ComboBox<String> categoryComboBox = new ComboBox<>();
	
	public DataLayoutVBox(String type) {
		this.dataLayoutType = type;
	}

	public VBox createVBox() {

		VBox finishedLayout = new VBox(5);
		separator1 = new Separator(Orientation.HORIZONTAL);
		separator2 = new Separator(Orientation.HORIZONTAL);
		separator3 = new Separator(Orientation.HORIZONTAL);
		separator1.setCenterShape(true);
		separator2.setCenterShape(true);
		separator3.setCenterShape(true);

		addNewCategoryButton = new Button();
		addDataButton = new Button("Add new data");
		addDataButton.setDisable(true);
		editDataButton = new Button("Edit");
		editDataButton.setDisable(true);
		deleteDataButton = new Button("Delete");
		deleteDataButton.setDisable(true);
		categoryLabel = new Label("Category:");
		valueLabel = new Label("Amount:");
		calendarLabel = new Label("Day:");
		messageLabel = new Label("Enter necessary data");
		valueInput = new TextField();
		valueHBox = new HBox(10);
		categoryHBox = new HBox(10);
		calendarHBox = new HBox(10);
		completeLayout = new VBox(5);
		calendar = new DatePicker();
		logsHBox = new HBox(5);
		logsHBox.getChildren().addAll(editDataButton, deleteDataButton);
		logsHBox.setAlignment(Pos.CENTER);
		logsHBox.setPadding(new Insets(0, 5, 5, 5));
		
		valueInput.setPromptText("Enter value");
		valueHBox.setPadding(new Insets(0, 0, 0, 10));
		calendarHBox.setPadding(new Insets(0, 0, 0, 32));
		calendar.getStylesheets().add("css/DatePicker.css");
		calendar.setPromptText("Enter item date");
		calendar.setEditable(false);
		valueHBox.setAlignment(Pos.CENTER);
		categoryHBox.setAlignment(Pos.CENTER);
		calendarHBox.setAlignment(Pos.CENTER);
		completeLayout.setAlignment(Pos.CENTER);
		valueLabel.setPadding(new Insets(0, 0, 0, 6));
		calendarLabel.setPadding(new Insets(0, 0, 0, 6));
		
		
		categoryComboBox.setId("combo-box2");
		messageLabel.setId("message-label");
		addNewCategoryButton.setId("add-category-button");
		addDataButton.setId("add-data-button");
		editDataButton.setId("edit-data-button");
		deleteDataButton.setId("delete-data-button");

		addNewCategoryButton.setOnAction(event -> new AddNewCategory(categoryComboBox, this.dataLayoutType));

		valueHBox.getChildren().addAll(valueLabel, valueInput);
		valueHBox.setAlignment(Pos.CENTER_LEFT);
		categoryHBox.getChildren().addAll(categoryLabel, getCategoryComboBox(), addNewCategoryButton);
		calendarHBox.getChildren().addAll(calendarLabel, calendar);
		completeLayout.getChildren().addAll(valueHBox, separator1, categoryHBox, separator2, calendarHBox,
				separator3, addDataButton);

		// Add new application.Data with amount, category and date
		addDataButton.setOnAction(event -> {
			Data newData = new Data(Float.parseFloat(valueInput.getText()), categoryComboBox.getValue(),
					calendar.getValue());
			contentLogs.getItems().add(newData);
			valueInput.clear();
		});

		//check if necessary data is informed
		//TODO: put this in a new method?
		checkData.addListener((ListChangeListener<Boolean>) c -> {
			if (checkData.get(0) == true && checkData.get(1) == true && checkData.get(2) == true) {
				addDataButton.setDisable(false);
			}
			else {
				addDataButton.setDisable(true);
			}
		});

		categoryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> checkData.set(0, true));
		calendar.setOnAction(event -> {
			if (!calendar.getValue().toString().isBlank()) {
				checkData.set(1, true);
			}
			else {
				checkData.set(1, false);
			}
		});
		valueInput.textProperty().addListener(( observable, oldValue, newValue ) -> {
			if (!valueInput.getText().isBlank()) {
				try {
					Float.parseFloat(valueInput.getText());
					checkData.set(2, true);
				}
				catch (NumberFormatException e) {
					checkData.set(2, false);
				}
			}
			else {
				checkData.set(2, false);
			}
		});
		
		completeLayout.setPadding(new Insets(10, 10, 10, 10));

		valueLabel.setFont(font);
		categoryLabel.setFont(font);
		calendarLabel.setFont(font);
		valueInput.setStyle("-fx-font: 16px \"Ubuntu Bold\";" + "-fx-text-fill: white");
		calendar.setStyle("-fx-font: 14px \"Ubuntu Bold\";");
		categoryComboBox.setStyle("-fx-font: 14px \"Ubuntu Bold\";");

		finishedLayout.getStylesheets().add("css/DataLayout.css");
		completeLayout.getStyleClass().add("vbox");
		categoryHBox.getStyleClass().add("hbox");
		valueHBox.getStyleClass().add("hbox");
		calendarHBox.getStyleClass().add("hbox");

		finishedLayout.getChildren().addAll(completeLayout, getContentLogs(), logsHBox);
		return finishedLayout;

	}

	public ComboBox<String> getCategoryComboBox() {

		Button addCategory = new Button("Add category");
		addCategory.setPrefWidth(170);

		categoryComboBox.setOnHiding(event -> categoryComboBox.setPromptText("Select category"));
		categoryComboBox.setPlaceholder(addCategory);
		categoryComboBox.getPlaceholder().setOnMousePressed(event -> new AddNewCategory(categoryComboBox, this.dataLayoutType));
		categoryComboBox.setPromptText("Select category");

		return categoryComboBox;

	}

	public TableView<Data> getContentLogs() {

		contentLogs = new TableView<Data>();
		contentLogs.setId("table-view");
		TableColumn<Data, Float> amountColumn = new TableColumn<>("Amount");
		TableColumn<Data, String> categoryColumn = new TableColumn<>("Category");
		TableColumn<Data, String> dateColumn = new TableColumn<>("Date");

		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

		contentLogs.setPrefSize(330, 400);
		amountColumn.setMinWidth(107);
		categoryColumn.setMinWidth(107);
		dateColumn.setMinWidth(107);
		contentLogs.getColumns().addAll(amountColumn, categoryColumn, dateColumn);
		contentLogs.getStylesheets().add("css/DataLayout.css");
		
		contentLogs.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			editDataButton.setDisable(false);
			deleteDataButton.setDisable(false);
		});
		return contentLogs;

	}

}













