package de.schauderhaft.bel.app;

import de.schauderhaft.bel.message.Message;
import de.schauderhaft.bel.message.MessageBus;
import de.schauderhaft.bel.message.MessageBusImpl;
import de.schauderhaft.bel.message.MessageListener;
import de.schauderhaft.bel.network.MessageDispatcher;
import de.schauderhaft.bel.network.UdpMessageDispatcher;


/**
 * @author arno
 */
public class BelApp {
    private final MessageBus messageBus = new MessageBusImpl();
    private final MessageDispatcher messageDispatcher = new UdpMessageDispatcher();

    private final MessageListener dispatchListener = new MessageListener() {
        @Override public void onMessage (Message message) {
            messageDispatcher.send(); //TODO differentiate 'local' vs 'remote' --> check sender agains 'myself'
        }
    };

    public void start() {
        messageBus.addListener (dispatchListener);
    }

    public void stop() {
        messageBus.removeListener (dispatchListener);
    }
}
