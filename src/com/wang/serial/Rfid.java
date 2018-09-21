//package com.wang.serial;
//
//import javax.sound.sampled.Port;
//
//import gnu.io.PortInUseException;
//import gnu.io.SerialPort;
//
//import com.wang.pojo.User;
//import com.wang.utils.SerialPortManager;
//import com.wang.utils.ByteUtils;
//
//public class Rfid {
//	private static SerialPort port;
//
//	public static String attend(User user) throws PortInUseException {
//		final String result = "fail";
//		final String compare = "13660c3e";
//		String finalData;
//		port = SerialPortManager.openPort("COM4", 19200);
//		String toSend = "0200000447044f03";
//		SerialPortManager.sendToPort(port, ByteUtils.hexStr2Byte(toSend));
//		SerialPortManager.addListener(port,
//				new SerialPortManager.DataAvailableListener() {
//
//					@Override
//					public void dataAvailable() {
//						byte[] data = null;
//						try {
//							if (port == null) {
//								return;
//							} else {
//								// 读取串口数据
//								data = SerialPortManager.readFromPort(port);
//
//								// 以十六进制的形式接收数据
//
//								if (ByteUtils.byteArrayToHexString(data)
//										.equals(compare)) {
//									result = "true";
//
//								}
//
//							}
//						} catch (Exception e) {
//
//							System.exit(0);
//						}
//					}
//				});
//		SerialPortManager.closePort(port);
//		return result;
//
//	}
//}
