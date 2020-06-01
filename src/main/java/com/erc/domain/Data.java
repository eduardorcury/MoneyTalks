package com.erc.domain;

import com.erc.components.ApplicationCharts;
import javafx.scene.chart.XYChart;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "data_table")
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AMOUNT", nullable = false)
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Transient
    private XYChart.Data<Number, String> chartData = new XYChart.Data<>();

    @Column(name = "DATE", nullable = false)
    private LocalDate date;

    public Data() {}

    public Data(Integer id, Float amount, Category category, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        chartData.setXValue(amount);
        chartData.setYValue(category.getCategoryName());
        chartData.nodeProperty().addListener((ov, oldNode, newNode) -> ApplicationCharts.changeColor(newNode, this));
        category.getCategorySeries().getData().add(chartData);
        Lists.getDataList().add(this);
        System.out.println(chartData);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id.equals(data.id) &&
                amount.equals(data.amount) &&
                category.equals(data.category) &&
                date.equals(data.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, category, date);
    }


}
