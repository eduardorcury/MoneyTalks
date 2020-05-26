package com.erc.domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Lists {

    private static final ObservableList<Category> categoriesList = FXCollections.observableArrayList();
    private static final ObservableList<Data> dataList = FXCollections.observableArrayList();

    private static final ObservableList<String> comboBoxList = FXCollections.observableArrayList();

    public static ObservableList<Category> getCategoriesList() {
        return categoriesList;
    }

    public static ObservableList<Data> getDataList() {
        return dataList;
    }

    public static ObservableList<String> getComboBoxList() {
        return comboBoxList;
    }
}
