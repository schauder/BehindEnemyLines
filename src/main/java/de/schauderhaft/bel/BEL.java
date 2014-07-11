package de.schauderhaft.bel;


import de.schauderhaft.bel.app.view.BelViewController;
import de.schauderhaft.bel.friends.Friend;
import de.schauderhaft.bel.message.MessageBus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class BEL extends Application{

    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader loader = new FXMLLoader();
        URL location = getClass().getResource("app/view/ChatClient.fxml");
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());

        Parent root = (Parent) loader.load(location.openStream());

        BelViewController controller = (BelViewController)loader.getController();

        MessageBus bus = null;
        controller.setMessageBus(bus);
        Friend friend = null;
        controller.setSelf(friend);


        Scene scene = new Scene(root);

        stage.setTitle("Chat Client");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}