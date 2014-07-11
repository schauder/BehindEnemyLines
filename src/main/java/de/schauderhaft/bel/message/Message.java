package de.schauderhaft.bel.message;


/**
 * @author arno
 */
public class Message {
    private final String text;
    private final Friend friend;

    public Message(String text, Friend friend) {
        this.text = text;
        this.friend = friend;
    }

    public String getText() {
        return text;
    }

    public Friend getFriend() {
        return friend;
    }
}
