package application;

import javafx.scene.paint.Color;

public class Category {

	private String categoryName;
	private String categoryType;
	private Color categoryColor;
	//color array with the sequence in colorButtons.css
	public Color[] colors = {
			Color.rgb(255,102,102),
			Color.rgb(255,51,51),
			Color.rgb(255,0,0),
			Color.rgb(204,0,0),
			Color.rgb(153,0,0),
			Color.rgb(51,204,255),
			Color.rgb(51,153,255),
			Color.rgb(0,0,255),
			Color.rgb(0,0,204),
			Color.rgb(102,0,153),
			Color.rgb(102,255,102),
			Color.rgb(0,255,51),
			Color.rgb(0,204,0),
			Color.rgb(0,153,0),
			Color.rgb(0,102,0),
			Color.rgb(255,255,153),
			Color.rgb(255,255,0),
			Color.rgb(255,204,0),
			Color.rgb(255,153,0),
			Color.rgb(255,102,0),
			Color.rgb(204,204,204),
			Color.rgb(153,153,153),
			Color.rgb(102,102,102),	
			Color.rgb(51,51,51)
	};            
	

	public Category() {

		this.categoryName = "";
		this.categoryType = "Spending";
		this.categoryColor = Color.BLUE;
	}

	public Category(String categoryName, String categoryType, Color categoryColor) {

		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.categoryColor = categoryColor;

	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Color getCategoryColor() {
		return categoryColor;
	}

	public void setCategoryColor(Color categoryColor) {
		this.categoryColor = categoryColor;
	}

	public void setCategoryColor(String buttonStyle) {
		//extract number from the button selected to get the right color
		Integer buttonId = Integer.parseInt(buttonStyle.substring(7));
		categoryColor = colors[buttonId - 1];
	}

}
