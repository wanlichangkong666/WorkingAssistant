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
	private static String portName = "COM3";
	private static int baudrate = 19200;
	public static void validate(final String compare) throws PortInUseException {

		//String finalData;
		result = false;
		port = SerialPortManager.openPort(portName, baudrate);
		System.out.println(port);
		String xunka = "0200000446529c03";
		final String fangchongtu = "0200000447044f03";
		SerialPortManager.addListener(port,
				new SerialPortManager.DataAvailableListener() {

					@Override
					public void dataAvailable() {
						byte[] data = null;
						try {
							if (port == null) {
								return;
							} else {
								
								data = SerialPortManager.readFromPort(port);				
								String number = ByteUtils.byteArrayToHexString(data);
								if(number.equals("02000005460004004F03"))
									SerialPortManager.sendToPort(port, ByteUtils.hexStr2Byte(fangchongtu));
								else
								{
									String card = number.substring(12,20);
									System.out.println(card);
									if (card.equals(compare)) {
								
									    result = true;
									    	
									}
								}
							}
						} catch (Exception e) {

							System.exit(0);
						}
						
					}
	
		
	
	});
		//发送寻卡帧和防冲突帧
		SerialPortManager.sendToPort(port, ByteUtils.hexStr2Byte(xunka));		
		
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
