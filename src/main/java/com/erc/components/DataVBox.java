package com.erc.components;

import com.erc.controls.Buttons;
import com.erc.controls.Labels;
import com.erc.controls.Separators;
import com.erc.controls.TextFields;
import com.erc.domain.Category;
import com.erc.domain.Data;
import com.erc.domain.Lists;
import com.erc.enums.Type;
import com.erc.util.HibernateUtil;
import com.erc.windows.AddNewCategoryWindow;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NonUniqueResultException;

public class DataVBox {

    private DatePicker calendar;
    private Stage addNewCategoryStage;

    private Separators separators = new Separators();
    private Buttons buttons = new Buttons();
    private Labels labels = new Labels();
    private TextFields textFields = new TextFields();

    private final Type dataLayoutType;

    private ObservableList<Boolean> checkData = FXCollections.observableArrayList(false, false, false);

    private final VBox newDataVBox = new VBox(5);
    private final ComboBox<String> categoryComboBox = new ComboBox<>();
    private final TableView<Data> dataLogs = new TableView<>();
    private final HBox logsHBox = new HBox(5);

    public DataVBox(Type type) {

        this.dataLayoutType = type;
        createNewDataVBox();
        createCategoryComboBox();
        createDataLogs();

    }

    private void createNewDataVBox() {

        calendar = new DatePicker();
        calendar.getStylesheets().add(getClass().getResource("/css/DatePicker.css").toExternalForm());
        calendar.setPromptText("Enter item date");
        calendar.setEditable(false);

        HBox valueHBox = new HBox(10);
        HBox categoryHBox = new HBox(10);
        HBox calendarHBox = new HBox(10);

        logsHBox.getChildren().addAll(buttons.getEditDataButton(), buttons.getDeleteDataButton());
        logsHBox.setAlignment(Pos.CENTER);
        logsHBox.setPadding(new Insets(0, 5, 5, 5));

        valueHBox.setPadding(new Insets(0, 0, 0, 10));
        calendarHBox.setPadding(new Insets(0, 0, 0, 32));

        valueHBox.setAlignment(Pos.CENTER);
        categoryHBox.setAlignment(Pos.CENTER);
        calendarHBox.setAlignment(Pos.CENTER);
        newDataVBox.setAlignment(Pos.CENTER);

        buttons.getAddNewCategoryButton().setOnAction(event -> new AddNewCategoryWindow(dataLayoutType));

        valueHBox.getChildren().addAll(labels.getValueLabel(), textFields.getValueInput());
        categoryHBox.getChildren().addAll(labels.getCategoryLabel(), getCategoryComboBox(), buttons.getAddNewCategoryButton());
        calendarHBox.getChildren().addAll(labels.getCalendarLabel(), calendar);
        newDataVBox.getChildren().addAll(valueHBox, separators.getSeparator1(), categoryHBox, separators.getSeparator2(), calendarHBox,
                separators.getSeparator3(), buttons.getAddDataButton());

        // Add new application.Data with amount, category and date
        buttons.getAddDataButton().setOnAction(event -> {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query findCategoryByName = session.createQuery("from Category where name=:name");
            findCategoryByName.setParameter("name", categoryComboBox.getValue());
            try {
                Category category = (Category) findCategoryByName.uniqueResult();
            } catch (NonUniqueResultException exception) {

            }
            Data newData = new Data(null, Float.parseFloat(textFields.getValueInput().getText()),
                    (Category) findCategoryByName.uniqueResult(),
                    calendar.getValue());
            textFields.getValueInput().clear();
        });

        //check if necessary data is informed
        //TODO: put this in a new method?
        checkData.addListener((ListChangeListener<Boolean>) c -> {
            buttons.getAddDataButton().setDisable(!checkData.get(0) || !checkData.get(1) || !checkData.get(2));
        });

        categoryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> checkData.set(0, true));
        calendar.setOnAction(event -> {
            if (!calendar.getValue().toString().isBlank()) {
                checkData.set(1, true);
            } else {
                checkData.set(1, false);
            }
        });
        textFields.getValueInput().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!textFields.getValueInput().getText().isBlank()) {
                try {
                    Float.parseFloat(textFields.getValueInput().getText());
                    checkData.set(2, true);
                } catch (NumberFormatException e) {
                    checkData.set(2, false);
                }
            } else {
                checkData.set(2, false);
            }
        });

        calendar.setStyle("-fx-font: 14px \"Ubuntu Bold\";");
        categoryComboBox.setStyle("-fx-font: 14px \"Ubuntu Bold\";");

        newDataVBox.getStylesheets().add(getClass().getResource("/css/DataLayout.css").toExternalForm());
        newDataVBox.getStyleClass().add("vbox");
        categoryHBox.getStyleClass().add("hbox");
        valueHBox.getStyleClass().add("hbox");
        calendarHBox.getStyleClass().add("hbox");
        newDataVBox.setPadding(new Insets(10, 10, 10, 10));

    }

    private void createCategoryComboBox() {

        Button addCategory = new Button("Add category");
        addCategory.setPrefWidth(170);

        categoryComboBox.setId("combo-box2");
        categoryComboBox.setOnHiding(event -> categoryComboBox.setPromptText("Select category"));
        categoryComboBox.setPlaceholder(addCategory);
        categoryComboBox.getPlaceholder().setOnMousePressed(event -> new AddNewCategoryWindow(dataLayoutType));
        categoryComboBox.setPromptText("Select category");
        categoryComboBox.setItems(Lists.getComboBoxList());

    }

    private void createDataLogs() {

        TableColumn<Data, Float> amountColumn = new TableColumn<>("Amount");
        TableColumn<Data, Category> categoryColumn = new TableColumn<>("Category");
        TableColumn<Data, String> dateColumn = new TableColumn<>("Date");

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        dataLogs.setPrefSize(330, 450);
        amountColumn.setMinWidth(107);
        categoryColumn.setMinWidth(107);
        dateColumn.setMinWidth(107);

        dataLogs.getStylesheets().add(getClass().getResource("/css/DataLayout.css").toExternalForm());
        dataLogs.setId("table-view");
        dataLogs.getColumns().setAll(amountColumn, categoryColumn, dateColumn);

    }

    public VBox getNewDataVBox() {
        return newDataVBox;
    }

    public ComboBox<String> getCategoryComboBox() {
        return categoryComboBox;
    }

    public TableView<Data> getDataLogs() {
        return dataLogs;
    }

    public HBox getLogsHBox() {
        logsHBox.getStylesheets().add(getClass().getResource("/css/DataLayout.css").toExternalForm());
        return logsHBox;
    }
}
