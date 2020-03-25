package application;

import javafx.scene.Node;

public class NodeColor {
	
	public static void setNodeStyle(Data data, Node node) {
		
		node.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + ");");
		
	}
	
	public static void gridPaneCellStyle (Data data, Node categoryPane, Node amountPane) {
		
		categoryPane.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + "), white;");
		
		amountPane.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + "), white;");
	}
}
