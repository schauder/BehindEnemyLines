package de.schauderhaft.bel.message;


import de.schauderhaft.bel.friends.Friend;

/**
 * @author arno
 */
public class Message {
    private final String text;
    private final Friend sender;

    public Message(String text, Friend sender) {
        this.text = text;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public Friend getSender() {
        return sender;
    }
}
