package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GridPaneItem {
	
	public Button color;
	public Label categoryLabel;
	public Label percentLabel;
	public String type;
	public Data data;
	
	GridPaneItem(Data data) {
		this.data = data;
		this.categoryLabel = new Label(data.getCategory().getCategoryName());
		this.percentLabel = new Label(data.getAmount().toString());
		this.type = data.getCategory().getCategoryType();
	}
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
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
