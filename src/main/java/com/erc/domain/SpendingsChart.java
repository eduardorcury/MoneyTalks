package com.erc.domain;

import com.erc.enums.Type;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;

import java.time.Month;

public class SpendingsChart extends ApplicationCharts {

    Type type = Type.SPENDINGS;

    public SpendingsChart(Month month, Type type, NumberAxis xAxis, CategoryAxis yAxis) {
        super(month, type, xAxis, yAxis);
    }

    private static StackedBarChart<Number, String> spendingsChart;

}
