package de.schauderhaft.bel.friends;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author arno
 */
public class FriendPoolImpl implements FriendPool {
    private final Friend myself;
    private final Collection<Friend> friends;
    private final Collection<Friend> others;

    public FriendPoolImpl() {
        myself = null; //TODO myself
        friends = readFriends();
        others = new ArrayList<>(friends);
        others.remove (myself);
    }

    @Override public Friend getMyself() {
        return myself;
    }

    @Override public Collection<Friend> getFriends() {
        return friends;
    }

    @Override public Collection<Friend> getOthers() {
        return others;
    }

    @Override public Friend lookup (String name) {
        for (Friend friend : friends) {
            if (friend.name.equals (name)) {
                return friend;
            }
        }
        throw new IllegalArgumentException ("no friend " + name);
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
