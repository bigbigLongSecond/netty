package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/8 17:29
 */
public class Service {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket= serverSocket.accept();;
        while (true){
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            String s = "hello";
            byte[] a = s.getBytes();
            outputStream.write(a);
            outputStream.close();
            inputStream.close();
            System.out.println("j11");
        }
    }
}
