package de.schauderhaft.bel.app.view;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BelViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextArea chatbox;

	@FXML
	private TextField chatinput;

	@FXML
	private Button pushButton;

	@FXML
	void pushInput(ActionEvent event) {
	}

	@FXML
	void pushinput(KeyEvent event) {
	}

	@FXML
	void initialize() {
		assert chatbox != null : "fx:id=\"chatbox\" was not injected: check your FXML file 'ChatClient.fxml'.";
		assert chatinput != null : "fx:id=\"chatinput\" was not injected: check your FXML file 'ChatClient.fxml'.";
		assert pushButton != null : "fx:id=\"pushButton\" was not injected: check your FXML file 'ChatClient.fxml'.";

	}

}
