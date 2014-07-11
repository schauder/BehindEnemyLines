package de.schauderhaft.bel.app;

import de.schauderhaft.bel.friends.FriendPool;
import de.schauderhaft.bel.friends.FriendPoolImpl;
import de.schauderhaft.bel.message.Message;
import de.schauderhaft.bel.message.MessageBus;
import de.schauderhaft.bel.message.MessageBusImpl;
import de.schauderhaft.bel.message.MessageListener;
import de.schauderhaft.bel.network.UdpMessageDispatcher;
import de.schauderhaft.bel.network.UdpMessageSender;

import java.io.IOException;
import java.net.SocketException;


/**
 * @author arno
 */
public class BelApp {
    private final MessageBus messageBus = new MessageBusImpl();
    private final UdpMessageSender messageSender = new UdpMessageSender();
    private final FriendPool friendPool = new FriendPoolImpl();
    private volatile UdpMessageDispatcher messageDispatcher;

    private final MessageListener dispatchListener = new MessageListener() {
        @Override public void onMessage (Message message) {
            if (friendPool.getMyself().equals (message.getSender())) {
                try {
                    messageSender.send (friendPool.getFriends(), message); //TODO without myself
                } catch (IOException e) {
                    e.printStackTrace(); //TODO error handling
                }
            }
        }
    };

    public void start() throws SocketException {
        messageBus.addListener (dispatchListener);
        messageDispatcher = new UdpMessageDispatcher();
        messageDispatcher.start();
    }

    public void stop() {
        messageBus.removeListener (dispatchListener);
        messageDispatcher.shutdown();
    }
}
