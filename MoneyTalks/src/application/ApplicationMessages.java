package application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ApplicationMessages {

	static Button yesButton;
	static Button noButton;
	static Button cancelButton;
	static Stage closeWindow;

	public static void closeWindow() {

		closeWindow = new Stage();
		closeWindow.centerOnScreen();
		closeWindow.initModality(Modality.APPLICATION_MODAL);
		closeWindow.setMinWidth(350);
		closeWindow.setMinHeight(200);
		Label confirmation = new Label("Save before exit?");
		yesButton = new Button("Yes");
		noButton = new Button("No");
		cancelButton = new Button("Cancel");

		yesButton.setOnAction(e -> {
			System.out.println("Saving File");
			Platform.exit();
		});
		noButton.setOnAction(e -> {
			Platform.exit();
		});
		cancelButton.setOnAction(e -> closeWindow.close());

		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(yesButton, noButton, cancelButton);
		buttons.setAlignment(Pos.CENTER);

		VBox layout = new VBox(20);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(confirmation, buttons);
		layout.setAlignment(Pos.CENTER);
		Scene closeScene = new Scene(layout);
		closeWindow.setScene(closeScene);
		closeWindow.show();

	}

}
