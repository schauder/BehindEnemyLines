package de.schauderhaft.bel.friends;

import java.net.InetSocketAddress;

public class Friend {
    public final String name;
    public final InetSocketAddress address;

    public Friend (String name, String host, String port) {
        this(name, new InetSocketAddress(host, Integer.parseInt(port)));
    }

    public Friend(String name, InetSocketAddress address) {
        this.name = name;
        this.address = address;
    }
}
