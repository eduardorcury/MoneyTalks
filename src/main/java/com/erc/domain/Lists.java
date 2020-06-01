package com.erc.domain;

import com.erc.components.ApplicationCharts;
import com.erc.enums.Type;
import com.erc.util.DBService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public abstract class Lists {

    private static ObservableList<Category> categoriesList = FXCollections.observableArrayList();
    private static ObservableList<Data> dataList = FXCollections.observableArrayList();
    private static ObservableList<String> comboBoxList = FXCollections.observableArrayList();

    private static ObservableList<XYChart.Series<Number, String>> incomeData = FXCollections.observableArrayList();
    private static ObservableList<XYChart.Series<Number, String>> spendingsData = FXCollections.observableArrayList();

    public static ObservableList<Category> getCategoriesList() {
        return categoriesList;
    }

    public static void setCategoriesList() {

        for (Category category : DBService.getAllCategories()) {
            System.out.println(category);
        }
        categoriesList.addAll(DBService.getAllCategories());
        System.out.println(categoriesList);
        for (Category category : DBService.getAllCategories()) {
            XYChart.Series<Number, String> series = new XYChart.Series<>();
            category.setCategorySeries(series);
            for (Data data : category.getData()) {
                XYChart.Data<Number, String> chartData = new XYChart.Data<>(data.getAmount(), category.getCategoryName());
                chartData.nodeProperty().addListener((ov, oldNode, newNode) -> ApplicationCharts.changeColor(newNode, data));
                category.getCategorySeries().getData().add(chartData);
            }
            if (category.getCategoryType().equals(Type.INCOME)) {
                incomeData.add(series);
            }
            else {
                spendingsData.add(series);
            }
        }
    }

    public static ObservableList<Data> getDataList() {
        return dataList;
    }

    public static void setDataList() {
        dataList.addAll(DBService.getAllData());
        System.out.println(dataList);

    }

    public static ObservableList<String> getComboBoxList() {
        return comboBoxList;
    }

    public static void setComboBoxList() {
        comboBoxList.addAll(DBService.getAllNames());
    }

    public static ObservableList<XYChart.Series<Number, String>> getIncomeData() {
        return incomeData;
    }

    public static ObservableList<XYChart.Series<Number, String>> getSpendingsData() {
        return spendingsData;
    }

}

