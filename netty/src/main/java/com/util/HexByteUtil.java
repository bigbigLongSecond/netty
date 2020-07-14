package com.util;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HexByteUtil {
	private final static byte[] hex = "0123456789ABCDEF".getBytes();

	private static int parse(char c) {
		if (c >= 'a') {
			return (c - 'a' + 10) & 0x0f;
		}
		if (c >= 'A') {
			return (c - 'A' + 10) & 0x0f;
		}
		return (c - '0') & 0x0f;
	}

	public static String Bytes2HexString(byte[] b) {
		byte[] buff = new byte[3 * b.length];
		for (int i = 0; i < b.length; i++) {
			buff[3 * i] = hex[(b[i] >> 4) & 0x0f];
			buff[3 * i + 1] = hex[b[i] & 0x0f];
			buff[3 * i + 2] = 45;
		}
		String re = new String(buff);
		return re.replace("-", " ");
	}

	public static byte[] HexString2Bytes(String hexstr) {
		hexstr = hexstr.replace(" ", "");
		byte[] b = new byte[hexstr.length() / 2];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			char c0 = hexstr.charAt(j++);
			char c1 = hexstr.charAt(j++);
			b[i] = (byte) ((parse(c0) << 4) | parse(c1));
		}
		return b;
	}

	public static String toHex(byte b) {
		String result = Integer.toHexString(b & 0xFF);
		if (result.length() == 1) {
			result = '0' + result;
		}
		return result.toUpperCase();
	}

	public static int hexStrToInt(String hexStr) {
		int result = -1;
		if (hexStr != null) {
			hexStr = hexStr.replaceAll(" ", "");
			result = Integer.parseInt(hexStr, 16);
		}

		return result;
	}

	public static Long hexStrToLong(String hexStr) {
		Long result = -1L;
		if (hexStr != null) {
			hexStr = hexStr.replaceAll(" ", "");
			result = Long.parseLong(hexStr, 16);
		}

		return result;
	}

	public static int hexStrToIntRevertPos(String hexStr) {
		int result = -1;
		StringBuilder sb = new StringBuilder();
		if (hexStr != null) {
			String[] hexs = hexStr.split(" ");
			for (int i = (hexs.length - 1); i >= 0; i--) {
				if (!"".equals(sb.toString())) {
					sb.append(" ");
				}
				sb.append(hexs[i]);
			}
			hexStr = sb.toString();
			hexStr = hexStr.replaceAll(" ", "");
			result = Integer.parseInt(hexStr, 16);
		}

		return result;
	}

	public static int byteArrayToInt(byte[] b) {
		return
		/*
		 * b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16| (b[0] & 0xFF)
		 * << 24;
		 */
		b[1] & 0xFF | (b[0] & 0xFF) << 8;
	}

	public static byte[] intToByteArray(int a) {
		return new byte[] {
				/*
				 * (byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF),
				 */
				(byte) ((a >> 8) & 0xFF), (byte) (a & 0xFF) };
	}

	public static byte[] addBytes(byte[] data1, byte[] data2) {
		byte[] data3 = new byte[data1.length + data2.length];
		System.arraycopy(data1, 0, data3, 0, data1.length);
		System.arraycopy(data2, 0, data3, data1.length, data2.length);

		return data3;

	}

	public static byte[] shortArrayToByteArray(short[] values) {
		byte[] ba = new byte[values.length];
		for (int i = 0; i < values.length; i++) {
			ba[i] = shortToByteArray(values[i]);
		}
		return ba;
	}

	/**
	 * 将16位的short转换成byte数组
	 * 
	 * @param s
	 *            short
	 * @return byte[] 长度为1
	 */
	public static byte shortToByteArray(short s) {
		byte targets = 0;
		int offset = 0;
		targets = (byte) ((s >>> offset) & 0xff);
		return targets;
	}

	public static String integerToHexStr(int val, int digit) {
		String hexVal = Integer.toHexString(val);
		int strLen = hexVal.length();

		int minus = digit - strLen;
		if (minus > 0) {
			for (int i = 0; i < minus; i++) {
				hexVal = "0" + hexVal;
			}
		}

		return hexVal;
	}

	public static String integerToHexStrRevertPos(int val, int digit) {
		String temp = integerToHexStr(val, digit);
		StringBuilder sb = new StringBuilder();

		for (int i = temp.length(); i > 0;) {
			sb.append(temp.substring(temp.length() - 2));
			temp = temp.substring(0, temp.length() - 2);
			i = temp.length();
		}

		return sb.toString();
	}

	public static String floatToHexStr(float f, int digit) {
		String hexVal = Integer.toHexString(Float.floatToIntBits(f));
		int strLen = hexVal.length();
		int minus = digit - strLen;
		if (minus > 0) {
			for (int i = 0; i < minus; i++) {
				hexVal = "0" + hexVal;
			}
		}

		return hexVal;
	}

	public static float hexStrToFloat(String hexStr) {
		Float value = Float.intBitsToFloat(Integer.valueOf(hexStr.trim(), 16));
		return value;
	}

	public static String getBit(byte by) {
		StringBuffer sb = new StringBuffer();
		sb.append((by >> 7) & 0x1).append((by >> 6) & 0x1).append((by >> 5) & 0x1).append((by >> 4) & 0x1)
				.append((by >> 3) & 0x1).append((by >> 2) & 0x1).append((by >> 1) & 0x1).append((by >> 0) & 0x1);
		return sb.toString();
	}

	public static byte bitToByte(String bit) {
		int re, len;
		if (null == bit) {
			return 0;
		}
		len = bit.length();
		if (len != 4 && len != 8) {
			return 0;
		}
		if (len == 8) {// 8 bit处理
			if (bit.charAt(0) == '0') {// 正数
				re = Integer.parseInt(bit, 2);
			} else {// 负数
				re = Integer.parseInt(bit, 2) - 256;
			}
		} else {// 4 bit处理
			re = Integer.parseInt(bit, 2);
		}
		return (byte) re;
	}

	public static long byteToLong(byte[] a) {
		return (a[0] & 0xff) | (a[1] & 0xff) << 8 | (a[2] & 0xff) << 16 | (a[3] & 0xff) << 24;
	}

	public static short[] toShortArray(byte[] src) {

		int count = src.length >> 1;
		short[] dest = new short[count];
		for (int i = 0; i < count; i++) {
			dest[i] = (short) (src[i * 2] << 8 | src[2 * i + 1] & 0xff);
		}
		return dest;
	}

	public static byte[] copyByteArr(byte[] srcBytes, int len, int srcPos, int desPos) {
		byte[] result = new byte[len];

		if (srcBytes.length > (len - 1)) {
			System.arraycopy(srcBytes, srcPos, result, desPos, len);
		}

		return result;
	}

	public static void byte2image(byte[] data, String path) {
		FileImageOutputStream imageOutput = null;
		if (data.length < 3 || path.equals("")) {
			return;
		}
		try {
			imageOutput = new FileImageOutputStream(new File(path));
			imageOutput.write(data, 0, data.length);
			System.out.println("Make Picture success,Please find image in " + path);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		} finally {
			if (imageOutput != null) {
				try {
					imageOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}



	/**
	 *
	 * <pre>
	 * 将short转换为长度为16的byte数组.
	 * 实际上每个8位byte只存储了一个0或1的数字
	 * 比较浪费.
	 * </pre>
	 *
	 * @param s
	 * @return
	 */
	public static byte[] shortToByte16(short s) {
		byte[] arr = new byte[16];
		for (int i = 15; i >= 0; i--) {
			arr[i] = (byte) (s & 1);
			s >>= 1;
		}
		return arr;
	}

	public static short byte16ToShort(byte[] arr) {
		if (arr == null || arr.length != 16) {
			throw new IllegalArgumentException("byte数组必须不为空,并且长度为16!");
		}
		short sum = 0;
		for (int i = 0; i < 16; ++i) {
			sum |= (arr[i] << (15 - i));
		}
		return sum;
	}

}