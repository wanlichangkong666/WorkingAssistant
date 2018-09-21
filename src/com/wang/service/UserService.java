package com.wang.service;

import java.util.List;

import com.wang.pojo.User;

public interface UserService {

	public User login(User user);
	public String attend(User user);
	public void changePassword(User user);
	public void createUser(User user);
	public void deleteUser(Integer id);
	public List<User> getAllUsers();
}
