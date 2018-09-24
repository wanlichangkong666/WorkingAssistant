package com.wang.serial;

import java.sql.Date;

import javax.sound.sampled.Port;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import com.wang.pojo.User;
import com.wang.utils.SerialPortManager;
import com.wang.utils.ByteUtils;

public class Rfid {
	public static Boolean getResult() {
		return result;
	}
	public static void setResult(Boolean result) {
		Rfid.result = result;
	}
	private static SerialPort port;
	private static Boolean result = false;
	//private static final String compare = "13660c3e";
	private static String portName = "COM5";
	private static int baudrate = 19200;
	public static void validate(final String compare) throws PortInUseException {

		//String finalData;
		port = SerialPortManager.openPort(portName, baudrate);
		System.out.println(port);
		String xunka = "0200000446529c03";
		String fangchongtu = "0200000447044f03";
		SerialPortManager.addListener(port,
				new SerialPortManager.DataAvailableListener() {

					@Override
					public void dataAvailable() {
						byte[] data = null;
						try {
							if (port == null) {
								return;
							} else {
								// 璇诲彇涓插彛鏁版嵁
								data = SerialPortManager.readFromPort(port);				
								String number = ByteUtils.byteArrayToHexString(data);
								String card = number.substring(12);
								System.out.println(card);
								if (card.equals(compare)) {
								
									    result = true;
									    	
								}

							}
						} catch (Exception e) {

							System.exit(0);
						}
						
					}
	
		
	
	});
		SerialPortManager.sendToPort(port, ByteUtils.hexStr2Byte(xunka));
		
		SerialPortManager.sendToPort(port, ByteUtils.hexStr2Byte(fangchongtu));
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
