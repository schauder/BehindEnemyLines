package de.schauderhaft.bel.network;

import de.schauderhaft.bel.friends.Friend;
import de.schauderhaft.bel.message.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * @author arno
 */
public class UdpMessageSender {
    public void send (Collection<Friend> receivers, Message message) throws IOException {
        final byte[] data = serialize (message);

        try (final DatagramSocket socket = new DatagramSocket()) {
            for (Friend receiver: receivers) {
                final DatagramPacket sendPacket = new DatagramPacket (data, data.length, receiver.address);
                socket.send(sendPacket);
            }
        }
    }

    byte[] serialize (Message msg) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream out = new ObjectOutputStream (baos);
        out.writeUTF (msg.getSender().name);
        out.writeUTF (msg.getText());
        out.close();

        return baos.toByteArray();
    }
}
