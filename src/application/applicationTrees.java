package application;

import java.util.ArrayList;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class applicationTrees {

	TreeView<String> monthTree;
	
	public TreeView<String> getMonths() {

		TreeItem<String> currentYear;
		currentYear = new TreeItem<>();
		currentYear.setExpanded(true);

		// making months tree
		String[] monthsNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		
		for (int counter = 0; counter < monthsNames.length; counter++) {
			TreeItem<String> month = new TreeItem<>(monthsNames[counter]);
			currentYear.getChildren().add(month);
		}
		
		monthTree = new TreeView<>(currentYear);
		monthTree.setShowRoot(false);
		return monthTree;
	}

}
