package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) {
		try {
			RandomAccessFile  file = new RandomAccessFile("D:\\ass.txt", "rw");
			FileChannel fileChannel = file.getChannel();
			ByteBuffer buff =ByteBuffer.allocate(1024);
			int byteread = fileChannel.read(buff);
			while(byteread != -1) {
				System.out.println("read-->" + byteread);
//				buff.flip();
				while (buff.hasRemaining()) {
                System.out.println(buff.get());					
				}
				buff.clear();
				byteread = fileChannel.read(buff);
			}
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
