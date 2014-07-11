package de.schauderhaft.bel.message;

/**
 * @author arno
 */
public interface MessageBus {
    /**
     * provides a new message to the BEL system, either a local 'new' message from the UI or
     *  a remotely received message or whatever.
     */
    void newMessage (Message msg);

    void addListener (MessageListener l);
    void removeListener (MessageListener l);
}
