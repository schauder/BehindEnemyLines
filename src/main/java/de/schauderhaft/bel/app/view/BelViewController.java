package de.schauderhaft.bel.app.view;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import de.schauderhaft.bel.friends.Friend;
import de.schauderhaft.bel.message.Message;
import de.schauderhaft.bel.message.MessageBus;

public class BelViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextArea chatbox;

	@FXML
	private TextField chatinput;

	@FXML
	private Button pushButton;
	private MessageBus messageBus;
	private Friend self;

	@FXML
	void pushInput(ActionEvent event) {
		sendMessage();
	}

	@FXML
	void pushinput(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			sendMessage();
		}
	}

	private void sendMessage() {
		if (chatinput != null && !chatinput.getText().isEmpty()) {
			messageBus.newMessage(new Message(chatinput.getText(), self));
		}
	}

	@FXML
	void initialize() {
		assert chatbox != null : "fx:id=\"chatbox\" was not injected: check your FXML file 'ChatClient.fxml'.";
		assert chatinput != null : "fx:id=\"chatinput\" was not injected: check your FXML file 'ChatClient.fxml'.";
		assert pushButton != null : "fx:id=\"pushButton\" was not injected: check your FXML file 'ChatClient.fxml'.";

	}

	public void setMessageBus(MessageBus messageBus) {
		this.messageBus = messageBus;
	}

	public void setSelf(Friend self) {
		this.self = self;
	}

	public void onMessage(Message message) {
		if (message.getSender().equals(self)) {
			// make it red
			fillChatBox("<<<", message);

		} else {
			fillChatBox(">>>", message);
		}
		chatinput.clear();
	}

	private void fillChatBox(String fromTO, Message message) {
		StringBuilder sb = new StringBuilder(chatbox.getText());
		sb.append("\n\r");
		sb.append(fromTO);
		sb.append(" ");
		sb.append(message.getSender().name);
		sb.append(" : ");
		sb.append(message.getText());
		chatbox.setText(sb.toString());
	}
}
