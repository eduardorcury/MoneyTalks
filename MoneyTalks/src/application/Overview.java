package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Overview {

	private VBox incomeOverview;
	private VBox spendingsOverview;
	private Label incomeLabel;
	private Label spendingsLabel;
	private HBox overviewHBox;
	private BorderPane overviewLayout;
	
	private static ObservableList<HBox> incomeCategories = FXCollections.observableArrayList();
	private static ObservableList<HBox> spendingsCategories = FXCollections.observableArrayList();
	
	public VBox createIncomeOverview() {
		incomeOverview = new VBox(5);
		incomeLabel = new Label("Income");
		
		incomeOverview.getChildren().add(incomeLabel);
		
		incomeCategories.addListener((ListChangeListener<HBox>) change -> {
			incomeOverview.getChildren().add(incomeCategories.get(incomeCategories.size()-1));
		});
		incomeOverview.setAlignment(Pos.TOP_CENTER);
		incomeOverview.getStyleClass().add("vbox");
		return incomeOverview;
	}
	
	public VBox createSpendingsOverview() {
		spendingsOverview = new VBox(5);
		spendingsLabel = new Label("Spendings");
		
		spendingsOverview.getChildren().add(spendingsLabel);
		
		spendingsCategories.addListener((ListChangeListener<HBox>) change -> {
			spendingsOverview.getChildren().add(spendingsCategories.get(spendingsCategories.size()-1));
		});
		spendingsOverview.setAlignment(Pos.TOP_CENTER);
		spendingsOverview.getStyleClass().add("vbox");
		return spendingsOverview;
	}
	
	public static void updateVBox(Data data) {
		HBox HBox = new HBox(30);
		Button color = new Button();
		HBox.getStylesheets().add("Overview.css");
		color.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + ");");
		
		Label categoryLabel = new Label(data.getCategory().getCategoryName());
		//TODO: PUT PERCENT HERE 
		Label percentLabel = new Label(data.getAmount().toString());
		HBox.setAlignment(Pos.CENTER);
		HBox.getChildren().addAll(color, categoryLabel, percentLabel);
		
		if (data.getCategory().getCategoryType() == "Income") {
			incomeCategories.add(HBox);
		}
		
		if (data.getCategory().getCategoryType() == "Spendings") {
			spendingsCategories.add(HBox);
		}
	}
	
	public BorderPane createOverviewLayout() {
		overviewLayout = new BorderPane();
		overviewHBox = new HBox(20);
		overviewHBox.getChildren().addAll(createIncomeOverview(), createSpendingsOverview());
		overviewHBox.setAlignment(Pos.TOP_CENTER);
		overviewLayout.setCenter(overviewHBox);
		overviewLayout.getStylesheets().add("Overview.css");
		return overviewLayout;
	}
}















