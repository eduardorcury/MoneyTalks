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

	public GridPane createGridPane(ObservableList<GridPaneItem> list) {
		
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.getColumnConstraints().add(new ColumnConstraints(100));
		pane.getColumnConstraints().add(new ColumnConstraints(100));

		pane.getRowConstraints().addListener((ListChangeListener<RowConstraints>) change -> {
			while (change.next()) {
				if (change.wasAdded()) {
					for (RowConstraints addedRow : change.getAddedSubList()) {
						addedRow.setMinHeight(40);
						addedRow.setMaxHeight(40);
					}
				}
			}
		});
		
		list.addListener((ListChangeListener<GridPaneItem>) c -> {
			while (c.next()) {
				if (c.wasAdded()) {
					for (GridPaneItem addedItem : c.getAddedSubList()) {
						StackPane categoryPane = new StackPane();
						StackPane percentPane = new StackPane();
						
						if (list.size() == 1) {
							
						}
						
						NodeColor.gridPaneCellStyle(addedItem.getData(), categoryPane, percentPane);

						pane.add(categoryPane, 0, c.getFrom() + 1);
						pane.add(percentPane, 1, c.getFrom() + 1);
						categoryPane.setAlignment(Pos.CENTER);
						percentPane.setAlignment(Pos.CENTER);
						categoryPane.getChildren().add(addedItem.getCategoryLabel());
						percentPane.getChildren().add(addedItem.getPercentLabel());
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















