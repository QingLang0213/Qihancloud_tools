package com.common;

/**
 * Java基本数据类型和byte数组相互转化
 * 
 * @author hai
 * 
 */
public class ByteUtil {
	/**
	 * 将网络字节数组转整形
	 * 
	 * @param bytes
	 * @param off
	 * @return
	 */
	public static int byte4ToInt(byte[] bytes) {
		int b0 = bytes[0] & 0xFF;
		int b1 = bytes[1] & 0xFF;
		int b2 = bytes[2] & 0xFF;
		int b3 = bytes[3] & 0xFF;
		return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
	}

	/**
	 * 将整形转网络字节序
	 * 
	 * @param n
	 * @return
	 */
	public static byte[] IntTobyte4(int n) {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >> 8 & 0xff);
		b[1] = (byte) (n >> 16 & 0xff);
		b[0] = (byte) (n >> 24 & 0xff);
		return b;

	}
}