package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewCategory extends DataLayout {
	
	private static HBox hbox1;
	private static HBox hbox2;
	private static VBox layout;
	private static Scene scene;
	private static Label categoryLabel;
	private static Button cancelButton;
	private static Button confirmButton;
	private static TilePane buttonsLayout; 
	private static TextField categoryField;
	private static CategoryColor colorButtons; 
	private static Stage addNewCategoryStage;
	
	public static void addNewCategoryWindow() {
		
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
		
		hbox1.setAlignment(Pos.TOP_CENTER);
		hbox2.setAlignment(Pos.BOTTOM_CENTER);
		buttonsLayout.setAlignment(Pos.CENTER);
		categoryLabel.setAlignment(Pos.CENTER_RIGHT);
		categoryField.setAlignment(Pos.CENTER);
		addNewCategoryStage.initModality(Modality.APPLICATION_MODAL);
		categoryField.setPromptText("Category name");
		confirmButton.setDefaultButton(true);
		
		hbox1.getChildren().addAll(categoryLabel, categoryField);
		hbox2.getChildren().addAll(confirmButton, cancelButton);
		layout.setPadding(new Insets(30, 30, 30, 30));
		layout.getChildren().addAll(hbox1, buttonsLayout, hbox2);

		buttonsLayout.setStyle("-fx-border-color: black;" + "-fx-border-width: 5");
		
		scene.getStylesheets().add("AddNewCategoryWindow.css");
		addNewCategoryStage.setTitle("Add new category");
		addNewCategoryStage.setResizable(false);
		addNewCategoryStage.setScene(scene);
		addNewCategoryStage.show();
		
		confirmButton.setOnAction(event -> confirm());
		cancelButton.setOnAction(event -> addNewCategoryStage.close());

	}
	
	public static Category confirm() {
		
		Category newCategory = new Category(categoryField.getText(), colorButtons.buttonColor);
		setCategoryComboBox(categoryField.getText());
		newCategory.categoriesArrayList();
		addNewCategoryStage.close();

		return newCategory;
		
	}
}
