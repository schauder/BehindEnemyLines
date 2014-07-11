package de.schauderhaft.bel.friends;

import java.util.Collection;

/**
 * @author arno
 */
public interface FriendPool {
    Friend getMyself();
    Collection<Friend> getFriends();
}
