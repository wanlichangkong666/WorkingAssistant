package com.wang.serial;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.Counter;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import com.wang.utils.ByteUtils;
import com.wang.utils.SerialPortManager;

public class Sensor {
	private static SerialPort port;
	private static int sensorNum = 2;
	//private static List<String> detectedSensors;
	private static String portName = "COM3";
	private static int baudrate = 115200;
	private static int counter = 0;
	public static List<String> getDetectedSensors(final String compare) throws PortInUseException {

		final List<String> detectedSensor = new ArrayList<String>();
		//String finalData;
		port = SerialPortManager.openPort(portName, baudrate);
		SerialPortManager.addListener(port,
				new SerialPortManager.DataAvailableListener() {

					
					@Override
					public void dataAvailable() {
						counter++;
						if(counter == sensorNum)
							return;
						byte[] data = null;
						try {
							if (port == null) {
								return;
							} else {
								// 读取串口数据				
								data = SerialPortManager.readFromPort(port);
								// 以十六进制的形式接收数据
								String raw = ByteUtils.byteArrayToHexString(data);
								//截取传感器地址
								String address = raw.substring(10,15);
								detectedSensor.add(address);																																	
							}
							SerialPortManager.closePort(port);
						} catch (Exception e) {

							System.exit(0);
						}
					}
				});
		
		return detectedSensor;

	}

}
