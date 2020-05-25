package com.erc.domain;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Logs {

    private static TableView<Data> contentLogs;

    public Logs() {

        contentLogs = new TableView<Data>();
        contentLogs.setId("table-view");

        TableColumn<Data, Float> amountColumn = new TableColumn<>("Amount");
        TableColumn<Data, Category> categoryColumn = new TableColumn<>("Category");
        TableColumn<Data, String> dateColumn = new TableColumn<>("Date");

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        contentLogs.setPrefSize(330, 400);
        amountColumn.setMinWidth(107);
        categoryColumn.setMinWidth(107);
        dateColumn.setMinWidth(107);

        contentLogs.getColumns().addAll(amountColumn, categoryColumn, dateColumn);

    }

    public static TableView<Data> getContentLogs() {
        return contentLogs;
    }
}
