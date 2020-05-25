package com.erc.domain;

import com.erc.enums.Type;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.time.Month;

public abstract class ApplicationCharts {

    private final Month month;
    private final Type type;

    private final NumberAxis xAxis;
    private final CategoryAxis yAxis;

    public ApplicationCharts(Month month, Type type, NumberAxis xAxis, CategoryAxis yAxis) {
        this.month = month;
        this.type = type;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
}
