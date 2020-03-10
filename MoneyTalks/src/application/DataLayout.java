package application;

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
		
		return incomeLayout;
	}
	
	public BorderPane createSpendingsLayout() {
		
		BorderPane spendingsLayout = new BorderPane();
		spendingsLayout.setRight(spendingsVBox.createVBox());
		spendingsLayout.setCenter(charts.createSpendingsChart());
		
		return spendingsLayout;
	}
}
