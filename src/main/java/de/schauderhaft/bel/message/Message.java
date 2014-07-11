package de.schauderhaft.bel.message;


/**
 * @author arno
 */
public class Message {
    private final String text;
    private final User user;

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }
}
