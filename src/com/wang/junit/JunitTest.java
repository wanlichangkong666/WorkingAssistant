package com.wang.junit;

import java.util.List;

import gnu.io.PortInUseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import com.wang.serial.Rfid;
import com.wang.serial.Sensor;
import com.wang.service.UserService;
//import com.wang.service.UserServiceImpl;

public class JunitTest {

	
	@Test
	public void test()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		UserMapper mapper = ac.getBean(UserMapper.class);
		//UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		User sUser = new User();
		sUser.setId(123);
		sUser.setPassword("abc");
		User user = mapper.selectUser(sUser);
		System.out.println(user);
		
	}
	@Test
	public void testRfid() throws PortInUseException
	{
		Rfid.validate("435e0f3e");
		System.out.println(Rfid.getResult());
		
	}
	@Test
	public void testSensor() throws PortInUseException
	{
		Sensor.getSensors();
		List<String> sensors = Sensor.getDetectedSensor();
		for (String string : sensors) {
			System.out.println(string);
		}
		
	}
	@Test
	public void testUserService()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

		//UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		User sUser = new User();
		sUser.setId(123);
		sUser.setPassword("abc");
//		String result = userService.login(sUser);
//		System.out.println(result);
		
	}
	public static void main(String args[])
	{
		try {
			//Sensor.getSensors();
			Rfid.validate("13660C3E");
			System.out.println(Rfid.getResult());
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
