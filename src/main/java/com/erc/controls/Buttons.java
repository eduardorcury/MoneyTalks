package com.erc.controls;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class Buttons {

    //Add Data layout
    private final Button addDataButton = new Button("Add new data");
    private final Button editDataButton = new Button("Edit");
    private final Button deleteDataButton = new Button("Delete");
    private final Button addNewCategoryButton = new Button();

    //Add new Category window
    private final Button cancelButton = new Button("Cancel");
    private final Button confirmButton = new Button("Confirm");

    public Button getAddDataButton() {
        addDataButton.setDisable(true);
        addDataButton.setId("add-data-button");
        return addDataButton;
    }

    public Button getEditDataButton() {
        editDataButton.setDisable(true);
        editDataButton.setId("edit-data-button");
        return editDataButton;
    }

    public Button getDeleteDataButton() {
        deleteDataButton.setDisable(true);
        deleteDataButton.setId("delete-data-button");
        return deleteDataButton;
    }

    public Button getAddNewCategoryButton() {
        addNewCategoryButton.setId("add-category-button");
        return addNewCategoryButton;
    }

    public Button getCancelButton() {
        cancelButton.setCursor(Cursor.HAND);
        return cancelButton;
    }

    public Button getConfirmButton() {
        confirmButton.setCursor(Cursor.HAND);
        return confirmButton;
    }
}