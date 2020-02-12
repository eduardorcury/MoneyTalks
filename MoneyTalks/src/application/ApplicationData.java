package application;

import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ApplicationData {

	public Label valueLabel;
	public Label categoryLabel;
	public TextField valueInput;
	public ChoiceBox<String> categoryChoiceBox;
	public Button addNewCategoryButton;
	public Button cancelButton;
	public HBox valueHBox;
	public HBox categoryHBox;
	public VBox completeVBox;
	public ApplicationMessages message;
	public TextField categoryField;
	public Stage addNewCategoryStage;
	public Button confirmButton;

	private TableView<Double> contentLogs;

	public VBox dataVBox() {

		message = new ApplicationMessages();
		valueLabel = new Label("Amount");
		categoryLabel = new Label("Category");
		valueInput = new TextField();
		addNewCategoryButton = new Button("Add");
		addNewCategoryButton.setStyle("-fx-background-radius: 10em; " + "-fx-min-height: 50px;" + "-fx-min-width: 50px;"
				+ "-fx-max-height: 50px;" + "-fx-max-width: 50px;");

		categoryChoiceBox = new ChoiceBox<>();
		contentLogs = new TableView<>();

		TableColumn<Double, Double> amountColumn = new TableColumn<>("Amount");
		TableColumn<Double, String> categoryColumn = new TableColumn<>("Category");
		TableColumn<Double, Date> dateColumn = new TableColumn<>("Date");

		amountColumn.setMinWidth(100);
		categoryColumn.setMinWidth(100);
		dateColumn.setMinWidth(100);

		contentLogs.getColumns().addAll(amountColumn, categoryColumn, dateColumn);

		getCategoryChoiceBox().setPrefWidth(150);
		valueInput.setPromptText("$");
		valueInput.setPrefWidth(100);

		valueHBox = new HBox(10);
		categoryHBox = new HBox(10);
		categoryHBox.setStyle("-fx-background-fill: blue; ");
		valueHBox.setPadding(new Insets(0, 90, 0, 0));
		categoryHBox.setMinHeight(20);
		categoryHBox.setMaxHeight(20);

		valueHBox.setPrefWidth(300);
		categoryHBox.setPrefWidth(300);

		categoryHBox.setAlignment(Pos.CENTER_RIGHT);
		valueHBox.setAlignment(Pos.CENTER_RIGHT);

		completeVBox = new VBox(20);
		addNewCategoryButton.setOnAction(event -> addNewCategoryWindow());

		BorderStroke teste = new BorderStroke(Color.CRIMSON, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
				BorderWidths.DEFAULT);
		BorderStroke teste2 = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
				BorderWidths.DEFAULT);

		valueHBox.setBorder(new Border(teste2));
		categoryHBox.setBorder(new Border(teste2));

		categoryChoiceBox.getItems().add("meu deus");

		valueHBox.getChildren().addAll(valueLabel, valueInput);
		categoryHBox.getChildren().addAll(categoryLabel, getCategoryChoiceBox(), addNewCategoryButton);
		completeVBox.getChildren().addAll(valueHBox, categoryHBox, contentLogs);
		completeVBox.setPadding(new Insets(30, 30, 30, 30));
		completeVBox.setBorder(new Border(teste));
		return completeVBox;

	}

	public void setCategoryChoiceBox(String categoryName) {
		categoryChoiceBox.getItems().add(categoryName);

	}

	public ChoiceBox<String> getCategoryChoiceBox() {
		return categoryChoiceBox;
	}

	public void addNewCategoryWindow() {

		Category newCategory = new Category();
		CategoryColor colorButtons = new CategoryColor();
		TilePane buttonsLayout = colorButtons.colorButtonsLayout();
		categoryField = new TextField();
		confirmButton = new Button("Confirm");
		cancelButton = new Button("Cancel");
		categoryLabel = new Label("Enter category name: ");
		HBox hbox1 = new HBox(10);
		HBox hbox2 = new HBox(10);
		VBox layout = new VBox(20);
		addNewCategoryStage = new Stage();
		addNewCategoryStage.initModality(Modality.APPLICATION_MODAL);
		Scene scene = new Scene(layout);
		
		hbox1.setAlignment(Pos.TOP_CENTER);
		buttonsLayout.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.BOTTOM_CENTER);
		categoryLabel.setAlignment(Pos.CENTER_RIGHT);
		categoryField.setAlignment(Pos.CENTER);
		buttonsLayout.setStyle("-fx-border-color: black;" + "-fx-border-width: 5");
		
		categoryField.setPromptText("Category name");
		confirmButton.setDefaultButton(true);
		hbox1.getChildren().addAll(categoryLabel, categoryField);
		hbox2.getChildren().addAll(confirmButton, cancelButton);

		layout.setPadding(new Insets(30, 30, 30, 30));
		layout.getChildren().addAll(hbox1, buttonsLayout, hbox2);

		addNewCategoryStage.setTitle("Add new category");
		addNewCategoryStage.setResizable(false);
		addNewCategoryStage.setScene(scene);
		addNewCategoryStage.show();

		confirmButton.setOnAction(event -> {
			//actions: set category name and color
			setCategoryChoiceBox(categoryField.getText());
			newCategory.setCategoryName(categoryField.getText());
			newCategory.setCategoryColor(colorButtons.buttonColor);
			addNewCategoryStage.close();
			System.out.println(categoryField.getText() + newCategory.getCategoryColor());
			
		});
		
		cancelButton.setOnAction(event -> addNewCategoryStage.close());

	}
}
