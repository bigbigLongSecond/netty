package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketAccept { 
    // 接收数据 
    public static void sockets(int m)  { 
        // ，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 
        // 字符串的拼接 
        StringBuilder stringBuilder = null; 
        stringBuilder = new StringBuilder(""); 
        // 创建TCP客户端socket服务 
        ServerSocket socket = null; 
        Socket s = null; 
        try { 
            try { 
                socket = new ServerSocket(m); 
                // 服务端接收客户端数据 
                s = socket.accept(); 
            } catch (IOException e1) { 
                // TODO Auto-generated catch block 
                e1.printStackTrace(); 
            } 
            // 此方法只有放在in =s.getInputStream();之前才有效，一旦in.read()阻塞就会抛出异常，程序结束！ 
            socket.setSoTimeout(8000); 
            try { 
                byte[] buf = new byte[1024]; 
                // 获取客户端socket输入流对象 
                InputStream in = null; 
                in = s.getInputStream(); 
                int len = -1; 
                len = in.read(buf); 
                for (int i = 0; i < len; i++) { 
                    int v = buf[i] & 0xFF; // 可以使得高位清零 
                    // 如果integer.tohexstring(buf[i])会导致byte（8位）转化int32位自动补位，结果误差大 
                    String hv = Integer.toHexString(v); 
                    if (hv.length() < 2) { 
                        stringBuilder.append(0); 
                    } 
                    stringBuilder.append(hv); 
                } 
                // 获得接收的数据 
                if (stringBuilder != null) { 
//                    try {
//                        TenToHex.othernum(stringBuilder.toString());
//                    } catch (SQLException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                } 
                s.close(); 
                socket.close(); 
            } catch (IOException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
            }// 获取客户端socket对象 
        } catch (SocketException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
    } 
}
