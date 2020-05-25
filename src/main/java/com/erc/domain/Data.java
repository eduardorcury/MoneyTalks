package com.erc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Data implements Serializable {

    @GeneratedValue
    private Integer id;

    private Float amount;

    @ManyToOne
    private Category category;

    private LocalDate date;

    public Data() {}

    public Data(Integer id, Float amount, Category category, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        Logs.getContentLogs().getItems().add(this);
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
