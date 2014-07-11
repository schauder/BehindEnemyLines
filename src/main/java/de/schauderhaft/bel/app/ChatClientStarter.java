package de.schauderhaft.bel.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatClientStarter extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader
				.load(getClass().getResource("ChatClient.fxml"));
		Scene scene = new Scene(root);

		stage.setTitle("Chat Client");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
}
