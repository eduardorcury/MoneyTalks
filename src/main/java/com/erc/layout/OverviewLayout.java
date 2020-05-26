package com.erc.layout;

import com.erc.components.OverviewGridPane;
import com.erc.enums.Type;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OverviewLayout {

    private BorderPane overviewLayout;
    private HBox gridPaneHbox = new HBox();
    private OverviewGridPane gridPane = new OverviewGridPane();

    public OverviewLayout() {

        overviewLayout = new BorderPane();
        createOverviewLayout();
        overviewLayout.setCenter(gridPaneHbox);
        overviewLayout.getStylesheets().add(getClass().getResource("/css/Overview.css").toExternalForm());

    }

    public void createOverviewLayout() {

        VBox incomeVBox = new VBox();
        VBox spendingsVBox = new VBox();
        Label incomeLabel = new Label(Type.INCOME.name());
        Label spendingsLabel = new Label(Type.SPENDINGS.name());

        incomeVBox.setAlignment(Pos.CENTER);
        spendingsVBox.setAlignment(Pos.CENTER);
        incomeVBox.getChildren().addAll(incomeLabel, gridPane.getIncomePane());
        spendingsVBox.getChildren().addAll(spendingsLabel, gridPane.getSpendingsPane());

        gridPaneHbox.getChildren().addAll(incomeVBox, spendingsVBox);
    }

    public BorderPane getOverviewLayout() {
        return overviewLayout;
    }
}

