package com.erc.domain;

import com.erc.util.DBService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Lists {

    private static ObservableList<Category> categoriesList = FXCollections.observableArrayList();
    private static ObservableList<Data> dataList = FXCollections.observableArrayList();

    private static ObservableList<String> comboBoxList = FXCollections.observableArrayList();

    public static ObservableList<Category> getCategoriesList() {
        return categoriesList;
    }

    public static void setCategoriesList() {
        categoriesList.addAll(DBService.getAllCategories());
    }

    public static ObservableList<Data> getDataList() {
        return dataList;
    }

    public static void setDataList() {
        dataList.addAll(DBService.getAllData());
    }

    public static ObservableList<String> getComboBoxList() {
        return comboBoxList;
    }

    public static void setComboBoxList() {
        comboBoxList.addAll(DBService.getAllNames());
    }
}
