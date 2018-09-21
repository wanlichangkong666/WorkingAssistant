package com.wang.serial;

import javax.sound.sampled.Port;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import com.wang.pojo.User;
import com.wang.utils.SerialPortManager;
import com.wang.utils.ByteUtils;

public class Rfid {
	private static SerialPort port;
	private static Boolean result = false;
	//private static final String compare = "13660c3e";
	private static String portName = "COM4";
	private static int baudrate = 19200;
	public static Boolean validate(final String compare) throws PortInUseException {

		//String finalData;
		port = SerialPortManager.openPort(portName, baudrate);
		String toSend = "0200000447044f03";
		SerialPortManager.sendToPort(port, ByteUtils.hexStr2Byte(toSend));
		SerialPortManager.addListener(port,
				new SerialPortManager.DataAvailableListener() {

					@Override
					public void dataAvailable() {
						byte[] data = null;
						try {
							if (port == null) {
								return;
							} else {
								// 读取串口数据
								data = SerialPortManager.readFromPort(port);

								// 以十六进制的形式接收数据

								if (ByteUtils.byteArrayToHexString(data)
										.equals(compare)) {
									    result = true;
									    	
								}

							}
						} catch (Exception e) {

							System.exit(0);
						}
						SerialPortManager.closePort(port);
					}
				});
		
		return result;

	}
}
