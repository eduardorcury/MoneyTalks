package application;


import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class CategoryColor extends Category{

	private ToggleButton[] buttons = new ToggleButton[24];
	private ToggleGroup group = new ToggleGroup();
	private TilePane buttonsLayout;
	public Color buttonColor;
	int i;
	
	public void createColorButtons() {
		
		for (i = 0; i < buttons.length ; i++) {
			
			buttons[i] = new ToggleButton();
			buttons[i].setToggleGroup(group);
			buttons[i].setId("button-" + (i + 1));
			buttons[i].setOnMouseEntered(event -> buttonsLayout.setCursor(Cursor.HAND));
			
		}
	}

	public TilePane colorButtonsLayout() {

		buttonsLayout = new TilePane();
		buttonsLayout.setPadding(new Insets(10, 10, 10, 10));
		buttonsLayout.setHgap(5);
		buttonsLayout.setVgap(5);
		buttonsLayout.setPrefRows(3);

		createColorButtons();

		buttonsLayout.getStylesheets().add("colorButtons.css");
		
		for (i = 0; i < buttons.length; i++) {
			buttonsLayout.getChildren().add(buttons[i]);
			getColor(i);
		}

		return buttonsLayout;

	}
	
	public Color getColor(int i) {
		
		buttons[i].selectedProperty().addListener(event -> {
			this.setCategoryColor(buttons[i].getId());
			buttonsLayout.setStyle("-fx-border-color: rgb(" +            
					this.getCategoryColor().getRed()*255 + "," +  
					this.getCategoryColor().getGreen()*255 + "," +
					this.getCategoryColor().getBlue()*255 + ");" +
					"-fx-border-width: 5");
			buttonColor = new Color(this.getCategoryColor().getRed(), 
					this.getCategoryColor().getGreen(),
					this.getCategoryColor().getBlue(), 1.0);
		});
		
		return buttonColor;
			
	}
}
