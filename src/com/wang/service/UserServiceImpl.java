package com.wang.service;

import gnu.io.PortInUseException;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import com.wang.serial.Rfid;
import com.wang.serial.Sensor;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(User user) {
		User result = userMapper.selectUser(user);
		return result;
	}

	@Override
	public void changePassword(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void createUser(User user) {
		userMapper.addUser(user);
		
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteUser(id);
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return userMapper.selectAllUsers();
	}



	//串口数据处理部分
	@Override
	public String attend(Integer id) {
		User user  = userMapper.selectUserById(id);
		if(!user.getAttendance())
		{
			
			String rfid = user.getRfid();
			try {
				Rfid.validate(rfid);
			} catch (PortInUseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Rfid.getResult() == true)
			{
				user.setAttendence(true);
				userMapper.updateUser(user);
				return "SUCCESS";
			}
		}
		return "FAIL";
	}

	@Override
	public String leave(Integer id) {
		User user  = userMapper.selectUserById(id);
		if(user.getAttendance())
		{
			
			String rfid = user.getRfid();
			try {
				 Rfid.validate(rfid);
			} catch (PortInUseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Rfid.getResult() == true)
			{
				user.setAttendence(false);
				userMapper.updateUser(user);
				return "SUCCESS";
			}
		}
		return "FAIL";
	}

	@Override
	public List<User> getAttendedUsers() {
		List<User> users = userMapper.selectAttendedUsers();
		return users;
		
	}

	@Override
	public List<User> getWorkingUsers() {
		List<String> sensors = Sensor.getDetectedSensor();
		List<User> users = userMapper.selectWorkingUsers(sensors);
		return users;
	}
	
}
