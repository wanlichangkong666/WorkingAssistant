package com.wang.serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.css.Counter;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import com.wang.utils.ByteUtils;
import com.wang.utils.SerialPortManager;

public class Sensor {
	private static SerialPort port;
	private static int sensorNum = 2;
	//private static List<String> detectedSensors;
	private static String portName = "COM4";
	private static int baudrate = 115200;
	//private static List<String> sensors = new ArrayList<String>();
	private static Map<String, Boolean> sensorMap = new HashMap<String, Boolean>();
	private static Map<String, Integer> sensorIndex = new HashMap<String,Integer>();
//	static{
//		sensorMap.put("B7A5", false);
//		sensorMap.put("7154", false);
//	}
	private static  List<String> detectedSensor = new ArrayList<String>();
	public static List<String> getDetectedSensor() {
		return detectedSensor;
	}
	public static void setDetectedSensor(List<String> detectedSensor) {
		Sensor.detectedSensor = detectedSensor;
	}
	public static void getSensors() throws PortInUseException {
		sensorMap.put("B7A5", false);
		sensorMap.put("7154", false);

		//sensors.add("7154");
		//sensors.add("B7A5");
		//String finalData;
		port = SerialPortManager.openPort(portName, baudrate);
		System.out.println(port);
		SerialPortManager.addListener(port,
				new SerialPortManager.DataAvailableListener() {
			    //private int counter = 0;
					
					@Override
					public void dataAvailable() {
//						System.out.println("receive");
//						counter++;
//						if(counter > sensorNum)
//							
//							SerialPortManager.closePort(port);
						byte[] data = null;
						try {
							if (port == null) {
								return;
							} else {
						
								data = SerialPortManager.readFromPort(port);					
								String raw = ByteUtils.byteArrayToHexString(data);	
								if(raw.length()==40)
								{
									for(int i = 0;i< sensorNum;i++)
									{
										String address = raw.substring(10+i*20,14+i*20);//+20
										//System.out.println(address);
										String isWorking = raw.substring(16+i*20,18+i*20);
										//System.out.println(isWorking);
										if(isWorking.equals("01")&&sensorMap.get(address) == false )
										{
											System.out.println(sensorIndex.get(address));
											detectedSensor.add(address);
											sensorMap.put(address, true);
											sensorIndex.put(address, detectedSensor.indexOf(address));
										}	
										else if(isWorking.equals("02")&&sensorMap.get(address) == true)
										{
											detectedSensor.remove(sensorIndex.get(address));
											sensorMap.put(address, false);
										}	
										
									}
									
									System.out.println(detectedSensor.size());
							
								}
								
							}
					
						} catch (Exception e) {

							System.exit(0);
						}
					}
				});
		
		

	}

}
