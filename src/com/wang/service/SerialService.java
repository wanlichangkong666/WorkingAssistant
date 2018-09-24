package com.wang.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.wang.serial.Rfid;
import com.wang.serial.Sensor;

@Service
public class SerialService implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		Sensor.getSensors();
		//Rfid.validate(compare);
		
	}
	

}