package com.wang.mapper;

import java.util.Date;
import java.util.List;

import com.wang.pojo.Plan;
import com.wang.pojo.User;

public interface UserMapper {
	void addUser(User user);
	void deleteUser(Integer id);
	void updateUser(User user);
	List<User> selectAllUsers();
	User selectUser(User user);
	

}
