package com.erc.windows;

import com.erc.controls.Buttons;
import com.erc.controls.Labels;
import com.erc.controls.TextFields;
import com.erc.domain.Category;
import com.erc.domain.Colors;
import com.erc.enums.Type;
import com.erc.util.DBService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewCategoryWindow {

    private Labels labels = new Labels();
    private Buttons buttons = new Buttons();
    private TextFields textFields = new TextFields();
    private Color selectedColor = Color.WHITE;

    private final Stage addNewCategoryStage = new Stage();

    public AddNewCategoryWindow(Type dataLayoutType) {

        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        VBox layout = new VBox(20);
        ColorPane colorPane = new ColorPane();
        TilePane buttonsLayout = colorPane.createColorPane();
        Scene scene = new Scene(layout);

        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30, 30, 30, 30));

        hbox1.getChildren().addAll(labels.getCategoryLabel(), textFields.getCategoryField());
        hbox2.getChildren().addAll(buttons.getConfirmButton(), buttons.getCancelButton());
        layout.getChildren().addAll(hbox1, buttonsLayout, hbox2);

        buttons.getConfirmButton().setOnAction(event -> {

            String categoryName = textFields.getCategoryField().getText();
            Color categoryColor = selectedColor;
            Category newCategory = new Category(null, categoryName, dataLayoutType, categoryColor);
            DBService.saveCategory(newCategory);
            addNewCategoryStage.close();

        });
        buttons.getCancelButton().setOnAction(event -> addNewCategoryStage.close());

        scene.getStylesheets().add(getClass().getResource("/css/AddNewCategoryWindow.css").toExternalForm());
        addNewCategoryStage.setWidth(390);
        addNewCategoryStage.setHeight(320);
        addNewCategoryStage.initModality(Modality.APPLICATION_MODAL);
        addNewCategoryStage.setTitle("Add new category");
        addNewCategoryStage.setResizable(false);
        addNewCategoryStage.setScene(scene);
        addNewCategoryStage.show();
    }

    private class ColorPane {

        private ToggleButton[] buttons;
        private TilePane buttonsLayout;

        private TilePane createColorPane() {

            buttonsLayout = new TilePane();
            buttonsLayout.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 5");
            buttonsLayout.setPadding(new Insets(10, 10, 10, 10));
            buttonsLayout.setHgap(5);
            buttonsLayout.setVgap(5);
            buttonsLayout.setPrefRows(3);
            buttonsLayout.setAlignment(Pos.CENTER);

            createColorButtons();

            for (ToggleButton button : buttons) {
                buttonsLayout.getChildren().add(button);
            }

            return buttonsLayout;
        }

        private void createColorButtons() {

            buttons = new ToggleButton[24];
            ToggleGroup group = new ToggleGroup();

            for (int i = 0; i < buttons.length ; i++) {

                buttons[i] = new ToggleButton();
                buttons[i].setToggleGroup(group);
                buttons[i].setId("button-" + (i + 1));
                buttons[i].setCursor(Cursor.HAND);
                String buttonId = buttons[i].getId();
                buttons[i].selectedProperty().addListener(event -> {
                    selectedColor = Colors.getButtonColor(buttonId);
                    buttonsLayout.setStyle("-fx-border-color: rgb(" + Colors.getRGB(selectedColor) + ");" +
                            "-fx-border-width: 5");
                });
            }
        }
    }
}
