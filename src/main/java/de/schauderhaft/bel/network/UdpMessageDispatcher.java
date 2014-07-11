package de.schauderhaft.bel.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by gerrit on 11.07.14.
 */
public class UdpMessageDispatcher extends Thread {

    private boolean shutdown;
    private final DatagramSocket socket;

    public UdpMessageDispatcher() throws SocketException {
        socket = new DatagramSocket(8383);

    }

    public void shutdown() {
        shutdown = true;
    }

    synchronized void processIncomingMessage(DatagramPacket packet) {

    }

    @Override
    public void run() {
        while (!shutdown) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                processIncomingMessage(packet);
            } catch (IOException e) {
                // gnarf
                e.printStackTrace();
            }

        }
    }
}
