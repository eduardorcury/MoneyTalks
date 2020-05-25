package com.erc.controls;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class TextFields {

    //Add Data layout
    private final TextField valueInput = new TextField();

    //Add new Category window
    private final TextField categoryField = new TextField();

    public TextField getValueInput() {
        valueInput.setPromptText("Enter Value");
        valueInput.setStyle("-fx-font: 16px \"Ubuntu Bold\";" + "-fx-text-fill: white");
        return valueInput;
    }

    public TextField getCategoryField() {
        categoryField.setAlignment(Pos.CENTER);
        categoryField.setPromptText("Category name");
        return categoryField;
    }
}
