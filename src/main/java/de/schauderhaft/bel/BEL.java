package de.schauderhaft.bel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BEL{

    public static void main(String args[]){
        new BEL();
    }

    public BEL(){
        // read ip adresses+ port to connect to
        List<Friend> friends  = readFriends();

        for (Friend friend : friends) {
            send(friend, "hello world");
        }

    }

    private void send(Friend friend, String s) {
    }

    private List<Friend> readFriends() {
        try {
            FileInputStream fis = new FileInputStream("friends");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<Friend>();
    }
}