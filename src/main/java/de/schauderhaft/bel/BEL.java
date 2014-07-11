package de.schauderhaft.bel;

import de.schauderhaft.bel.friends.Friend;

import java.io.*;
import java.net.InetSocketAddress;
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
        ArrayList<Friend> friends = new ArrayList<Friend>();
        try {
            FileInputStream fis = new FileInputStream("friends.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                String[] parts = line.split(":");
                friends.add(new Friend(parts[0],parts[1], parts[2]));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return friends;
    }
}