package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CommunicateTest2 extends Thread {
   InputStream  input ;
   OutputStream output;
   Socket socket;
   
   public void run() {
	   try {
		input = socket.getInputStream();
		output = socket.getOutputStream();
		
		String outS="Hello,welcome to my ServerSocket!\r\n";
		
		out(outS);
		
		
		
		
		
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void out(String str) {
	   byte[]   bytes = str.getBytes();
	   try {
		output.write(bytes);
		output.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void reading() throws IOException {
	   String inps="";
	   while(inps.equals("bye")) {
		   int num = input.read();
		   if (num != 13) {
			inps += num;
			num = input.read();
		}
		   System.out.println(inps);
	   }
   }
   
}
