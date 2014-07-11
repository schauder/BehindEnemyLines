package de.schauderhaft.bel;


import de.schauderhaft.bel.app.BelApp;
import de.schauderhaft.bel.app.view.BelViewController;
import de.schauderhaft.bel.message.Message;
import de.schauderhaft.bel.message.MessageListener;
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

        BelApp app = new BelApp();

        FXMLLoader loader = new FXMLLoader();
        URL location = getClass().getResource("app/view/ChatClient.fxml");
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());

        Parent root = (Parent) loader.load(location.openStream());

        final BelViewController controller = (BelViewController)loader.getController();

        controller.setMessageBus(app.getMessageBus());
        controller.setSelf(app.getSelf());


        Scene scene = new Scene(root);

        stage.setTitle("Chat Client");
        stage.setScene(scene);
        stage.show();

        app.start();
        app.getMessageBus().addListener(new MessageListener() {
            @Override public void onMessage(Message message) {
                controller.onMessage (message);
            }
        });
    }

    //TODO call 'stop' on BelApp when the application is shut down

    public static void main(String[] args) {
        launch(args);

    }
}