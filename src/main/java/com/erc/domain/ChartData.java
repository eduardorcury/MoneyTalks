package com.erc.domain;

import javafx.scene.chart.XYChart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chartData_table")
public class ChartData {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Category category;

    @OneToMany(mappedBy = "chartData")
    private List<Data> dataList = new ArrayList<>();

    @Transient
    private XYChart.Series<Number, String> chartSeries = new XYChart.Series<>();

    public ChartData() { }

    public ChartData(Integer id, Category category) {
        this.id = id;
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public XYChart.Series<Number, String> getChartSeries() {
        return chartSeries;
    }

    public void setChartSeries(XYChart.Series<Number, String> chartSeries) {
        this.chartSeries = chartSeries;
    }

    public void setChartData() {

        Data data = dataList.get(dataList.size()-1);
        XYChart.Data<Number, String> chartData = new XYChart.Data<>();
        chartData.setYValue(data.getCategory().getCategoryName());
        chartData.setXValue(data.getAmount());
        chartSeries.getData().add(chartData);

    }
}

