package com.erc.domain;

import com.erc.util.DBService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public abstract class Lists {

    private static ObservableList<Category> categoriesList = FXCollections.observableArrayList();
    private static ObservableList<Data> dataList = FXCollections.observableArrayList();
    private static ObservableList<String> comboBoxList = FXCollections.observableArrayList();
    private static List<ChartData> chartDataList = FXCollections.observableArrayList();

    public static ObservableList<Category> getCategoriesList() {
        return categoriesList;
    }

    public static void setCategoriesList() {
        categoriesList.addAll(DBService.getAllCategories());
        System.out.println(categoriesList);
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

    public static List<ChartData> getChartDataList() {
        return chartDataList;
    }

    public static void setChartDataList() {
        chartDataList.addAll(DBService.getAllChartData());
    }
}

