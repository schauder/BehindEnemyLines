package de.schauderhaft.bel.network;

import de.schauderhaft.bel.friends.FriendPool;
import de.schauderhaft.bel.message.Message;
import de.schauderhaft.bel.message.MessageBus;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by gerrit on 11.07.14.
 */
public class UdpMessageReceiver extends Thread {
    public static final int BUFFER_SIZE = 32768;

    private final FriendPool friendPool;
    private final MessageBus messageBus;

    private volatile boolean shutdown;
    private final DatagramSocket socket;

    public UdpMessageReceiver(MessageBus messageBus, FriendPool friendPool) throws SocketException {
        this.messageBus = messageBus;
        this.friendPool = friendPool;
        socket = new DatagramSocket(friendPool.getMyself().address.getPort());
    }

    public void shutdown() {
        shutdown = true;
        interrupt();
        socket.close();
    }

    @Override
    public void run() {
        final byte[] buffer = new byte[BUFFER_SIZE];
        final DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while (!shutdown) {
            try {
                socket.receive(packet);
                final Message msg = deserialize (buffer);
                messageBus.newMessage (msg);
            } catch (Exception e) {
                // gnarf
                e.printStackTrace(); //TODO error handling
            }

        }
    }

    private Message deserialize (byte[] raw) throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream (raw);
        final ObjectInputStream in = new ObjectInputStream (bais);

        final String sender = in.readUTF();
        final String text = in.readUTF();

        in.close();
        return new Message (text, friendPool.lookup (sender));
    }
}
