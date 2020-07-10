package io.netty.study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket编程  ： 服务端
 * 步骤：
 * 1.创建ServerSocket对象
 * 2.绑定端口号
 * 3.通过accept监听端口请求
 * 4.建立连接后，通过输入流读取数据
 * 5.通过输出流，向客户端回复数据
 *
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            Socket socket = serverSocket.accept();
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader   = new BufferedReader(inputStreamReader);
            String info = "";
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("收到信息" + info);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
