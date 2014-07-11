package de.schauderhaft.bel.friends;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author arno
 */
public class FriendPoolImpl implements FriendPool {
    private final Friend myself;
    private final Collection<Friend> friends;

    public FriendPoolImpl() {
        myself = null; //TODO myself
        friends = readFriends();
    }

    @Override public Friend getMyself() {
        return null;
    }

    @Override public Collection<Friend> getFriends() {
        return null;
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
                friends.add(new Friend(parts[0], parts[1], parts[2]));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return friends;
    }

}
