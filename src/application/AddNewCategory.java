package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewCategory {

	private HBox hbox1;
	private HBox hbox2;
	private VBox layout;
	private Scene scene;
	private Label categoryLabel;
	private Button cancelButton;
	private Button confirmButton;
	private TilePane buttonsLayout; 
	private TextField categoryField;
	private CategoryColor colorButtons; 
	private Stage addNewCategoryStage;
	
	AddNewCategory(ComboBox<String> categoryComboBox, String type) {
		
		hbox1 = new HBox(10);
		hbox2 = new HBox(10);
		layout = new VBox(20);
		scene = new Scene(layout);
		categoryField = new TextField();
		addNewCategoryStage = new Stage();
		colorButtons = new CategoryColor();
		confirmButton = new Button("Confirm");
		cancelButton = new Button("Cancel");
		categoryLabel = new Label("Enter category name: ");
		buttonsLayout = colorButtons.colorButtonsLayout();
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		buttonsLayout.setAlignment(Pos.CENTER);
		categoryLabel.setAlignment(Pos.CENTER_RIGHT);
		categoryField.setAlignment(Pos.CENTER);
		addNewCategoryStage.initModality(Modality.APPLICATION_MODAL);
		categoryField.setPromptText("Category name");
		confirmButton.setCursor(Cursor.HAND);
		cancelButton.setCursor(Cursor.HAND);
		
		hbox1.getChildren().addAll(categoryLabel, categoryField);
		hbox2.getChildren().addAll(confirmButton, cancelButton);
		layout.setPadding(new Insets(30, 30, 30, 30));
		layout.getChildren().addAll(hbox1, buttonsLayout, hbox2);
		
		buttonsLayout.setStyle("-fx-border-color: black;" + "-fx-border-width: 5");
		
		scene.getStylesheets().add("css/AddNewCategoryWindow.css");
		addNewCategoryStage.setTitle("Add new category");
		addNewCategoryStage.setResizable(false);
		addNewCategoryStage.setScene(scene);
		addNewCategoryStage.show();
		
		confirmButton.setOnAction(event -> confirm(categoryComboBox, type));
		cancelButton.setOnAction(event -> addNewCategoryStage.close());

	}
	
	public Category confirm(ComboBox<String> categoryComboBox, String type) {
		
		Category newCategory = new Category(categoryField.getText(), colorButtons.buttonColor, type);
		categoryComboBox.getItems().add(categoryField.getText());
		newCategory.categoriesArrayList();
		addNewCategoryStage.close();
		categoryComboBox.setValue(newCategory.getCategoryName());
		
		return newCategory;
		
	}
}
