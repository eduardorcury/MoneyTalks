package com.erc.domain;

import com.erc.enums.Type;
import javafx.scene.paint.Color;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "category_table")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String categoryName;

    @Column(name = "TYPE", nullable = false)
    private Type categoryType;

    @Column(name = "COLOR", nullable = false)
    private String categoryRGB;

    @Column(name = "TOTAL")
    private Float categoryTotal;

    @OneToMany(mappedBy = "category")
    private List<Data> data = new ArrayList<>();

    @Transient
    private Color categoryColor;

    public Category() {
        Lists.getCategoriesList().add(this);
    }

    public Category(Integer id, String categoryName, Type categoryType, Color categoryColor) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.categoryColor = categoryColor;
        this.categoryTotal = (float) 0.0;
        this.categoryRGB = Colors.getRGB(categoryColor);
        Lists.getCategoriesList().add(this);
        Lists.getComboBoxList().add(this.categoryName);
        System.out.println(this.toString());
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

    public String getCategoryRGB() {
        return categoryRGB;
    }

    public void setCategoryRGB(String categoryRGB) {
        this.categoryRGB = categoryRGB;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
