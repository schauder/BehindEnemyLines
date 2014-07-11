package de.schauderhaft.bel.app;

import de.schauderhaft.bel.friends.FriendPool;
import de.schauderhaft.bel.friends.FriendPoolImpl;
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
    private final FriendPool friendPool = new FriendPoolImpl();

    private final MessageListener dispatchListener = new MessageListener() {
        @Override public void onMessage (Message message) {
            if (friendPool.getMyself().equals (message.getSender())) {
                messageDispatcher.send();
            }
        }
    };

    public void start() {
        messageBus.addListener (dispatchListener);
    }

    public void stop() {
        messageBus.removeListener (dispatchListener);
    }
}
