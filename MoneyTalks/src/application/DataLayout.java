package application;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class DataLayout {

	private DataLayoutVBox incomeVBox = new DataLayoutVBox("Income");
	private DataLayoutVBox spendingsVBox = new DataLayoutVBox("Spendings");
	
	public ApplicationCharts charts = new ApplicationCharts();
	
	public BorderPane incomeLayout;
	public BorderPane spendingsLayout;
	
	public BorderPane createIncomeLayout() {
		
		BorderPane incomeLayout = new BorderPane();
		incomeLayout.setRight(incomeVBox.createVBox());
		incomeLayout.setCenter(charts.createIncomeChart());
		incomeLayout.setStyle("-fx-background-color: white;");
		BorderPane.setMargin(incomeLayout.getCenter(), new Insets(0, 10, 0, 0));
		
		return incomeLayout;
	}
	
	public BorderPane createSpendingsLayout() {
		
		BorderPane spendingsLayout = new BorderPane();
		spendingsLayout.setRight(spendingsVBox.createVBox());
		spendingsLayout.setCenter(charts.createSpendingsChart());
		spendingsLayout.setStyle("-fx-background-color: white;");
		BorderPane.setMargin(spendingsLayout.getCenter(), new Insets(0, 10, 0, 0));
		
		return spendingsLayout;
	}
}
