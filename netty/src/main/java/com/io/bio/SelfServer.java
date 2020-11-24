package com.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author dzl
 * 2020/11/24 14:10
 * @Description
 */
public class SelfServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8848);
        System.out.println("socket is running");
        for (; ; ) {
            Socket accept = serverSocket.accept();
            SelfHandle selfHandle = new SelfHandle(accept);
            new Thread(selfHandle).start();
        }
    }
}

class SelfHandle implements Runnable {
    Socket sock;

    public SelfHandle(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try (InputStream inputStream = sock.getInputStream()) {
            try (OutputStream outputStream = sock.getOutputStream()) {
                handle(inputStream, outputStream);
            }

        } catch (Exception e) {
            try {
                sock.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private void handle(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        bufferedWriter.write("hello client\n");
        bufferedWriter.flush();
        for (; ; ) {
            System.out.println("****");
            String text = bufferedReader.readLine();
            if ("bye".equals(text)) {
                bufferedWriter.write("bye\n");
                bufferedWriter.flush();
                break;
            }
            bufferedWriter.write("server send " + text+"\n");
            bufferedWriter.flush();
        }
    }

}
