package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Overview {

	private GridPane incomeOverview;
	private GridPane spendingsOverview;
	private BorderPane overviewLayout;
	
	private static ObservableList<GridPaneItem> incomeItems = FXCollections.observableArrayList();
	private static ObservableList<GridPaneItem> spendingsItems = FXCollections.observableArrayList();

	public GridPane createGridPane(ObservableList<GridPaneItem> list) {
		
		GridPane pane = new GridPane();
		pane.getColumnConstraints().add(new ColumnConstraints(110));
		pane.getColumnConstraints().add(new ColumnConstraints(110));
		
		list.addListener((ListChangeListener<GridPaneItem>) c -> {
			while (c.next()) {
				if (c.wasAdded()) {
					for (GridPaneItem addedItem : c.getAddedSubList()) {
						
						StackPane categoryPane = new StackPane();
						StackPane amountPane = new StackPane();
						Label categoryLabel = addedItem.getCategoryLabel();
						Label amountLabel = addedItem.getAmountLabel();
						
						categoryPane.getStyleClass().add("category-pane");
						amountPane.getStyleClass().add("amount-pane");
						NodeColor.gridPaneCellStyle(addedItem.getData(), categoryPane, amountPane);
						
						EventHandler<MouseEvent> mouseEntered = new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								NodeColor.setNodeStyle(addedItem.getData(), categoryPane);
								NodeColor.setNodeStyle(addedItem.getData(), amountPane);
								categoryLabel.setStyle("-fx-text-fill: white;");
								amountLabel.setStyle("-fx-text-fill: white;");
							}
						};
						
						EventHandler<MouseEvent> mouseExited = new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								categoryPane.setStyle("-fx-background-color: white;");
								amountPane.setStyle("-fx-background-color: white;");
								categoryLabel.setStyle("-fx-text-fill: black;");
								amountLabel.setStyle("-fx-text-fill: black;");
								NodeColor.gridPaneCellStyle(addedItem.getData(), categoryPane, amountPane);
							}
						};
						
						categoryPane.setOnMouseEntered(mouseEntered);
						categoryPane.setOnMouseExited(mouseExited);
						amountPane.setOnMouseEntered(mouseEntered);
						amountPane.setOnMouseExited(mouseExited);
						
						pane.add(categoryPane, 0, c.getFrom() + 1);
						pane.add(amountPane, 1, c.getFrom() + 1);
						categoryPane.setAlignment(Pos.CENTER);
						amountPane.setAlignment(Pos.CENTER);
						categoryPane.getChildren().add(categoryLabel);
						amountPane.getChildren().add(amountLabel);
						
					}
				}
			}
		});
		
		pane.getStyleClass().add("grid-pane");
		return pane;
	}
	
	public static void updateGridPane(Data data) {
		
		GridPaneItem item = new GridPaneItem(data);
		
		if (item.getType().equals("Income")) {
			incomeItems.add(item);
		}
		
		if (item.getType().equals("Spendings")) {
			spendingsItems.add(item);
		}
	}
	
	public BorderPane createOverviewLayout() {
		
		Label incomeLabel;
		Label spendingsLabel;
		incomeOverview = createGridPane(incomeItems);
		spendingsOverview = createGridPane(spendingsItems);
		
		VBox incomeVBox = new VBox();
		VBox spendingsVBox = new VBox();
		incomeVBox.setAlignment(Pos.CENTER);
		spendingsVBox.setAlignment(Pos.CENTER);
		incomeLabel = new Label("Income");
		spendingsLabel = new Label("Spendings");
		incomeVBox.getChildren().addAll(incomeLabel, incomeOverview);
		spendingsVBox.getChildren().addAll(spendingsLabel, spendingsOverview);
		
		overviewLayout = new BorderPane();
		HBox overviewHBox= new HBox();
		overviewHBox.getChildren().addAll(incomeVBox, spendingsVBox);
		
		overviewLayout.setCenter(overviewHBox);
		overviewLayout.getStylesheets().add("css/Overview.css");
		return overviewLayout;
	}
}















