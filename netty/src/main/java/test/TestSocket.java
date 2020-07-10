package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class TestSocket {

	// 客户端模式

	private static Socket socket;
	private static InputStream inputStream; // 输入流，用于从服务器获取数据
	private static OutputStream outputStream;// 输出流，用于写数据给服务器

	public static void main(String[] args) throws Exception {

		// 创建一个流套接字并将其连接到指定主机上的指定端口号。
		socket = new Socket(); // 实例化socket
		SocketAddress socketAddress = new InetSocketAddress("192.168.36.196", 4001); // 获取sockaddress对象
		socket.connect(socketAddress, 15000); // 连接socket并设置连接超时为5秒，如果5秒后服务端还没有响应，则弹出异常信息。
		outputStream = socket.getOutputStream();
		inputStream = socket.getInputStream();

	}

	public static void getMsg() {

		// 组装实际数据，将short数据强制转换为byte
		byte[] msgbyte = { (byte) 0xE5, (byte) 0xFA, 00, 02, 00, 0x05, 0x17, 00, 00, 00, 00, 00, 0x0F };

		try {
			outputStream.write(msgbyte, 0, msgbyte.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 监听接收数据
	 * 
	 */

	private class FrmRecvRunnable implements Runnable {

		@Override

		public void run() {

			int nCount = 0;

			while (true) {

				try {

					if (!socket.isConnected()) {

						// 通知设备已经断开连接

						return;

					}

					// 1.接收数据缓冲区，每一帧数据为13字节

					byte[] buffer = new byte[13];

					int bytes;

					// 2.不断循环接收数据

					while (true) {

						// 3.读数据，每次读取一帧数据，13字节

						bytes = inputStream.read(buffer);// , 0, 13);

						if (bytes > 0) {

							byte[] data = new byte[bytes];

							System.arraycopy(buffer, 0, data, 0, bytes);

							short[] msg = new short[13];// LeopaardCANCtrl.toShortArray(data);

							// 4.根据自己需要将字节数据转换为short类型

							for (int i = 0; i < bytes; i++) {

								msg[i] = (short) (0x0FF & buffer[i]);

							}

							// 5.根据数据需要将13字节数据转为需要的CAN数据
//
//							LeopaardFrmData frmData = new LeopaardFrmData();
//
//							LeopaardCANCtrl.canPack(frmData, msg, msg.length);
//
//							sendDataToJS(frmData, 0); // 0暂未使用

//                               Thread.sleep(2000);

						}

					}

				} catch (Exception exception) {

					// 暂不处理

				}

			}

		}

	}

}
