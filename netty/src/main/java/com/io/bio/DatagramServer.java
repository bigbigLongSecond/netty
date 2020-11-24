package com.io.bio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author dzl
 * 2020/11/24 14:41
 * @Description
 */
public class DatagramServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        for (; ; ) {
            byte[] buff = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            datagramSocket.receive(packet);
            String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println(s);
            byte[] bytes = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(bytes);
            datagramSocket.send(packet);
        }
    }
}
