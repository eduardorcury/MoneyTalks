package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GridPaneItem {
	
	public Button color;
	public Label categoryLabel;
	public Label percentLabel;
	public String type;
	
	GridPaneItem(Data data) {
		color = new Button();
		color.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + ");");
		
		categoryLabel = new Label(data.getCategory().getCategoryName());
		percentLabel = new Label(data.getAmount().toString());
		type = data.getCategory().getCategoryType();
	}
	
	public Button getColor() {
		return color;
	}
	public void setColor(Button color) {
		this.color = color;
	}
	public Label getCategoryLabel() {
		return categoryLabel;
	}
	public void setCategoryLabel(Label categoryLabel) {
		this.categoryLabel = categoryLabel;
	}
	public Label getPercentLabel() {
		return percentLabel;
	}
	public void setPercentLabel(Label percentLabel) {
		this.percentLabel = percentLabel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
