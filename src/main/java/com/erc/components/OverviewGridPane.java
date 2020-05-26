package com.erc.components;

import com.erc.domain.Colors;
import com.erc.domain.Data;
import com.erc.enums.Type;
import com.erc.items.GridPaneItem;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class OverviewGridPane {

    private GridPane incomePane;
    private GridPane spendingsPane;

    private static ObservableList<GridPaneItem> incomeItems = FXCollections.observableArrayList();
    private static ObservableList<GridPaneItem> spendingsItems = FXCollections.observableArrayList();

    public OverviewGridPane() {

        incomePane = createGridPane(incomeItems);
        spendingsPane = createGridPane(spendingsItems);

    }

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
                        String color = Colors.getRGB(addedItem.getData().getCategory().getCategoryColor());

                        categoryPane.getStyleClass().add("category-pane");
                        amountPane.getStyleClass().add("amount-pane");
                        categoryPane.setStyle("-fx-background-color: rgb(" + color + "), white;");
                        amountPane.setStyle("-fx-background-color: rgb(" + color + "), white;");

                        EventHandler<MouseEvent> mouseEntered = new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                                categoryPane.setStyle("-fx-background-color: rgb(" + color + ");");
                                amountPane.setStyle("-fx-background-color: rgb(" + color + ");");
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
                                categoryPane.setStyle("-fx-background-color: rgb(" + color + "), white;");
                                amountPane.setStyle("-fx-background-color: rgb(" + color + "), white;");
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

        if (item.getType().equals(Type.INCOME)) {
            incomeItems.add(item);
        }

        if (item.getType().equals(Type.SPENDINGS)) {
            spendingsItems.add(item);
        }
    }

    public GridPane getIncomePane() {
        return incomePane;
    }

    public GridPane getSpendingsPane() {
        return spendingsPane;
    }
}
