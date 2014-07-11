package de.schauderhaft.bel.friends;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Friend {
    public final String name;
    public final SocketAddress address;

    public Friend (String name, String host, String port){
        this(name, new InetSocketAddress(host, Integer.parseInt(port)));
    }

    public Friend(String name, SocketAddress address) {
        this.name = name;
        this.address = address;
    }
}
