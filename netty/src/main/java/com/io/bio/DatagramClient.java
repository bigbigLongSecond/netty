package com.io.bio;

import java.io.IOException;
import java.net.*;

/**
 * @author dzl
 * 2020/11/24 14:45
 * @Description
 */
public class DatagramClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(1000);
        socket.connect(InetAddress.getByName("localhost"),6666);
        // 发送:
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.send(packet);
        // 接收:
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
        socket.disconnect();


    }
}
