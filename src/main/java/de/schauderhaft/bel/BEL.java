package de.schauderhaft.bel;

import java.io.FileReader;
import java.util.List;

public class BEL{
    public static void main(String args[]){
            // read ip adresses+ port to connect to
        List<Friend> friends  = readFriends();

        for (Friend friend : friends) {
            send(friend, "hello world");
        }

    }

    private static void send(Friend friend, String s) {
    }

    private static List<Friend> readFriends() {
        return null;
    }
}