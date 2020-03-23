package application;

import java.util.Calendar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;

public class applicationMenu {

	Menu monthMenu = new Menu("Month");
	Menu fileMenu = new Menu("File");
	Menu editMenu = new Menu("Edit");
	ToggleGroup monthToggle = new ToggleGroup();

	public MenuBar menuItems() {

		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem exit = new MenuItem("Exit");

		fileMenu.getItems().add(open);
		fileMenu.getItems().add(save);
		fileMenu.getItems().add(exit);

		exit.setOnAction(e -> ApplicationMessages.closeWindow());

		this.monthMenu();
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(monthMenu, fileMenu, editMenu);

		return menuBar;
	}

	public Menu monthMenu() {

		String[] monthsNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

		for (int counter = 0; counter < monthsNames.length; counter++) {
			RadioMenuItem month = new RadioMenuItem(monthsNames[counter]);
			month.setToggleGroup(monthToggle);
			monthMenu.getItems().add(month);
			monthMenu.getItems().add(new SeparatorMenuItem());
			if (counter == currentMonth) {
				month.setSelected(true);
			}
		}
		return monthMenu;
	}

}
