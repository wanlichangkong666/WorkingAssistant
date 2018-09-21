package com.wang.service;

import java.util.List;

import javax.swing.ListModel;

import com.wang.pojo.User;

public interface UserService {

	public User login(User user);
	public String attend(Integer id);
	public String leave(Integer id);
	public void changePassword(User user);
	public void createUser(User user);
	public void deleteUser(Integer id);
	public List<User> getAllUsers();
	public List<User> getAttendedUsers();
	public List<User> getWorkingUsers();
}
