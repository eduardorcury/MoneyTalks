package com.erc.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Labels {

    //Add Data layout
    private final Label categoryLabel = new Label("Category:");
    private final Label valueLabel = new Label("Amount:");
    private final Label calendarLabel = new Label("Day:");
    private final Label messageLabel = new Label("Enter necessary data");

    //Add new Category window
    private final Label newCategoryLabel = new Label("Enter category name: ");

    private Font font = new Font("Ubuntu Bold", 16);

    public Label getCategoryLabel() {
        categoryLabel.setFont(font);
        return categoryLabel;
    }

    public Label getValueLabel() {
        valueLabel.setFont(font);
        valueLabel.setPadding(new Insets(0, 0, 0, 6));
        return valueLabel;
    }

    public Label getCalendarLabel() {
        calendarLabel.setFont(font);
        calendarLabel.setPadding(new Insets(0, 0, 0, 6));
        return calendarLabel;
    }

    public Label getMessageLabel() {
        messageLabel.setId("message-label");
        return messageLabel;
    }

    public Label getNewCategoryLabel() {
        newCategoryLabel.setAlignment(Pos.CENTER_RIGHT);
        return newCategoryLabel;
    }
}
