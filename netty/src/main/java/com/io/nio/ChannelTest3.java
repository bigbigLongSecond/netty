package com.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dzl
 * 2020/11/18 14:49
 * @Description
 */
public class ChannelTest3 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("1.txt");
        FileChannel channel = in.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        channel.read(byteBuffer);
        byteBuffer.flip();
        byte[] bytes1 = "\ndzl".getBytes();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(byteBuffer.capacity() + bytes1.length);
        byteBuffer1.put(byteBuffer);
        for (byte b:bytes1 ) {
            byteBuffer1.put(b);
        }
        byteBuffer1.flip();
        FileOutputStream out = new FileOutputStream("1.txt");
        FileChannel channel1 = out.getChannel();
        channel1.write(byteBuffer1);
        out.close();
        in.close();

    }
}
