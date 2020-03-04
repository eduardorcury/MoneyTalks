package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
  
public class ChartTest extends Application {
    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";
  
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");       
        yAxis.setLabel("Value");
  
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(createData(austria, 25601.34));
        series1.getData().add(createData(brazil, 20148.82));
        series1.getData().add(createData(france, 10000));
        series1.getData().add(createData(italy, 35407.15));
        series1.getData().add(createData(usa, 12000));
         
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(createData(austria, 57401.85));
        series2.getData().add(createData(brazil, 41941.19));
        series2.getData().add(createData(france, 45263.37));
        series2.getData().add(createData(italy, 117320.16));
        series2.getData().add(createData(usa, 14845.27));
         
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(createData(austria, 45000.65));
        series3.getData().add(createData(brazil, 44835.76));
        series3.getData().add(createData(france, 18722.18));
        series3.getData().add(createData(italy, 17557.31));
        series3.getData().add(createData(usa, 92633.68));
         
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }
 
    private XYChart.Data createData(String country, double value) {
        XYChart.Data data =  new XYChart.Data(country, value);
 
        String text = value < 30_000 ? "Low" : value < 100_000 ? "Medium" : "High";
 
        StackPane node = new StackPane();
        Label label = new Label(text);
        label.setRotate(-90);
        Group group = new Group(label);
        StackPane.setAlignment(group, Pos.BOTTOM_CENTER);
        StackPane.setMargin(group, new Insets(0, 0, 5, 0));
        node.getChildren().add(group);
        data.setNode(node);
 
        return data;
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}