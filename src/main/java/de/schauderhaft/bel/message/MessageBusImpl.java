package de.schauderhaft.bel.message;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author arno
 */
public class MessageBusImpl implements MessageBus {
    private final List<MessageListener> listeners = new CopyOnWriteArrayList<>();

    @Override public void newMessage(Message msg) {
        for(MessageListener l: listeners) {
            l.onMessage (msg);
        }
    }

    @Override public void addListener (MessageListener l) {
        listeners.add(l);
    }

    @Override public void removeListener(MessageListener l) {
        listeners.remove (l);
    }
}
