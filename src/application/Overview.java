package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class Overview {

	private GridPane incomeOverview;
	private GridPane spendingsOverview;
	private Label incomeLabel;
	private Label spendingsLabel;
	private BorderPane overviewLayout;
	
	private static ObservableList<GridPaneItem> incomeItems = FXCollections.observableArrayList();
	private static ObservableList<GridPaneItem> spendingsItems = FXCollections.observableArrayList();

	private Insets margin = new Insets(3, 0, 3, 0);

	public GridPane createIncomeOverview() {
		incomeOverview = new GridPane();
		incomeOverview.setGridLinesVisible(true);
		incomeOverview.getColumnConstraints().add(new ColumnConstraints(50));
		incomeOverview.getColumnConstraints().add(new ColumnConstraints(100));
		incomeOverview.getColumnConstraints().add(new ColumnConstraints(90));

		incomeOverview.getRowConstraints().addListener((ListChangeListener<RowConstraints>) change -> {
			while (change.next()) {
				if (change.wasAdded()) {
					for (RowConstraints addedRow : change.getAddedSubList()) {
						addedRow.setMinHeight(40);
						addedRow.setMaxHeight(40);
					}
				}
			}
		});
		
		incomeItems.addListener((ListChangeListener<GridPaneItem>) c -> {
			while (c.next()) {
				if (c.wasAdded()) {
					for (GridPaneItem addedItem : c.getAddedSubList()) {
						StackPane colorPane = new StackPane();
						StackPane categoryPane = new StackPane();
						StackPane percentPane = new StackPane();

						colorPane.setStyle("-fx-background-color: yellow, white;" +
								"-fx-background-insets: 0, 2 0 2 2");
						categoryPane.setStyle("-fx-background-color: yellow, white;" +
								"-fx-background-insets: 0, 2 0 2 0");
						percentPane.setStyle("-fx-background-color: yellow, white;" +
								"-fx-background-insets: 0, 2 2 2 0");

						incomeOverview.add(colorPane, 0, c.getFrom() + 1);
						incomeOverview.add(categoryPane, 1, c.getFrom() + 1);
						incomeOverview.add(percentPane, 2, c.getFrom() + 1);
						colorPane.setAlignment(Pos.CENTER);
						categoryPane.setAlignment(Pos.CENTER);
						percentPane.setAlignment(Pos.CENTER);
						colorPane.getChildren().add(addedItem.getColor());
						categoryPane.getChildren().add(addedItem.getCategoryLabel());
						percentPane.getChildren().add(addedItem.getPercentLabel());
					}
				}
			}
		});
		incomeOverview.getStyleClass().add("grid-pane");
		return incomeOverview;
	}
	
	public GridPane createSpendingsOverview() {
		spendingsOverview = new GridPane();
		spendingsOverview.setGridLinesVisible(true);
		spendingsOverview.getColumnConstraints().add(new ColumnConstraints(50));
		spendingsOverview.getColumnConstraints().add(new ColumnConstraints(100));
		spendingsOverview.getColumnConstraints().add(new ColumnConstraints(100));
		
		spendingsOverview.getChildren().addListener((ListChangeListener<Node>) change -> {
			while (change.next()) {
				if (change.wasAdded()) {
					for (Node addedNode : change.getAddedSubList()) {
						GridPane.setHalignment(addedNode, HPos.CENTER);
						GridPane.setMargin(addedNode, margin);
					}
				}
			}
		});
		
		spendingsItems.addListener((ListChangeListener<GridPaneItem>) c -> {
			while (c.next()) {
				if (c.wasAdded()) {
					for (GridPaneItem addedItem : c.getAddedSubList()) {
						spendingsOverview.add(addedItem.getColor(), 0, c.getFrom() + 1);
						spendingsOverview.add(addedItem.getCategoryLabel(), 1, c.getFrom() + 1);
						spendingsOverview.add(addedItem.getPercentLabel(), 2, c.getFrom() + 1);
					}
				}
			}
		});
		
		spendingsOverview.getStyleClass().add("grid-pane");
		return spendingsOverview;
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
		
		VBox incomeVBox = new VBox();
		VBox spendingsVBox = new VBox();
		incomeVBox.setAlignment(Pos.CENTER);
		spendingsVBox.setAlignment(Pos.CENTER);
		incomeLabel = new Label("Income");
		spendingsLabel = new Label("Spendings");
		incomeVBox.getChildren().addAll(incomeLabel, createIncomeOverview());
		spendingsVBox.getChildren().addAll(spendingsLabel, createSpendingsOverview());
		
		overviewLayout = new BorderPane();
		HBox overviewHBox= new HBox();
		overviewHBox.getChildren().addAll(incomeVBox, spendingsVBox);
		
		overviewLayout.setCenter(overviewHBox);
		overviewLayout.getStylesheets().add("css/Overview.css");
		return overviewLayout;
	}
}















