package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Overview {

	private GridPane incomeOverview;
	private GridPane spendingsOverview;
	private Label incomeLabel;
	private Label spendingsLabel;
	private BorderPane overviewLayout;
	
	private static ObservableList<GridPaneItem> incomeItems = FXCollections.observableArrayList();
	private static ObservableList<GridPaneItem> spendingsItems = FXCollections.observableArrayList();
	
	public GridPane createIncomeOverview() {
		incomeOverview = new GridPane();
		incomeOverview.setGridLinesVisible(true);
		incomeOverview.getColumnConstraints().add(new ColumnConstraints(50));
		incomeOverview.getColumnConstraints().add(new ColumnConstraints(100));
		incomeOverview.getColumnConstraints().add(new ColumnConstraints(100));
		
		incomeOverview.getChildren().addListener((ListChangeListener<Node>) change -> {
			while (change.next()) {
				if (change.wasAdded()) {
					for (Node addedNode : change.getAddedSubList()) {
						GridPane.setHalignment(addedNode, HPos.CENTER);
					}
				}
			}
		});
		
		incomeItems.addListener(new ListChangeListener<GridPaneItem>() {
			@Override
			public void onChanged(Change<? extends GridPaneItem> c) {
				while (c.next()) {
					if (c.wasAdded()) {
						for (GridPaneItem addedItem : c.getAddedSubList()) {
							incomeOverview.add(addedItem.getColor(), 0, c.getFrom() + 1);
							incomeOverview.add(addedItem.getCategoryLabel(), 1, c.getFrom() + 1);
							incomeOverview.add(addedItem.getPercentLabel(), 2, c.getFrom() + 1);
						}
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
					}
				}
			}
		});
		
		spendingsItems.addListener(new ListChangeListener<GridPaneItem>() {
			@Override
			public void onChanged(Change<? extends GridPaneItem> c) {
				while (c.next()) {
					if (c.wasAdded()) {
						for (GridPaneItem addedItem : c.getAddedSubList()) {
							spendingsOverview.add(addedItem.getColor(), 0, c.getFrom() + 1);
							spendingsOverview.add(addedItem.getCategoryLabel(), 1, c.getFrom() + 1);
							spendingsOverview.add(addedItem.getPercentLabel(), 2, c.getFrom() + 1);
						}
					}
				}
			}
		});
		
		spendingsOverview.getStyleClass().add("grid-pane");
		return spendingsOverview;
	}
	
	public static void updateGridPane(Data data) {
		
		GridPaneItem item = new GridPaneItem(data);
		
		if (item.getType() == "Income") {
			incomeItems.add(item);
		}
		
		if (item.getType() == "Spendings") {
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
		overviewLayout.getStylesheets().add("Overview.css");
		return overviewLayout;
	}
}















