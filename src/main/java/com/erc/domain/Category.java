package com.erc.domain;

import com.erc.enums.Type;
import javafx.scene.paint.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String categoryName;

    private Type categoryType;

    private Color categoryColor;
    private Float categoryTotal;

    @OneToMany
    private List<Data> data = new ArrayList<>();

    public Category() {

    }

    public Category(Integer id, String categoryName, Type categoryType, Color categoryColor) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.categoryColor = categoryColor;
        this.categoryTotal = (float) 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Type getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Type categoryType) {
        this.categoryType = categoryType;
    }

    public Color getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(Color categoryColor) {
        this.categoryColor = categoryColor;
    }

    public Float getCategoryTotal() {
        return categoryTotal;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
