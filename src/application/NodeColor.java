package application;

import javafx.scene.Node;

public class NodeColor {
	
	public static void setNodeStyle(Data data, Node node) {
		
		node.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + ");");
		
	}
	
	public static void gridPaneCellStyle (Data data, Node categoryPane, Node percentPane) {
		
		categoryPane.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + "), white;" + 
				"-fx-background-insets: 0, 5 0 0 5");
		
		percentPane.setStyle("-fx-background-color: rgb(" +            
				data.getCategory().getCategoryColor().getRed()*255 + "," +  
				data.getCategory().getCategoryColor().getGreen()*255 + "," +
				data.getCategory().getCategoryColor().getBlue()*255 + "), white;" + 
				"-fx-background-insets: 0, 5 5 0 0");
	}
}
