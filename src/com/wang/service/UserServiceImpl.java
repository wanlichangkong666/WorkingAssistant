package com.wang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;

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
	public String attend(User user) {
		
		return null;
	}
	
}
