package com.wang.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.management.Query;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wang.pojo.User;
import com.wang.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

//	public User login(User user);
//	public void changePassword(User user);
//	public void createUser(User user);
//	public void deleteUser(Integer id);
//	public List<User> getAllUsers();
	
	@RequestMapping(value = "/login")
	public @ResponseBody User login(@RequestBody User user) {
		User result = userService.login(user);
		return result;
	}
	@RequestMapping(value = "/attend")
	public @ResponseBody String attend(@RequestBody User user) {
		
		String result = userService.attend(user.getId());
		return result;
	}
	@RequestMapping(value = "/leave")
	public @ResponseBody String leave(@RequestBody User user) {
		
		String result = userService.leave(user.getId());
		return result;
	}
	@RequestMapping(value = "/changePassword")
	public @ResponseBody String changePassword(HttpServletResponse response, @RequestBody User user) {
		try {
			userService.changePassword(user);
			return "SUCCESS";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		    return "FAIL";
	}
	@RequestMapping(value = "/createUser")
	public @ResponseBody String createUser(HttpServletResponse response, @RequestBody User user) {
		try {
			userService.createUser(user);
			return "SUCCESS";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "FAIL";
	}
	@RequestMapping(value = "/deleteUser")
	public @ResponseBody String deleteUser(HttpServletResponse response, @RequestBody User user) {
		try {
			userService.deleteUser(user.getId());
			return "SUCCESS";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "FAIL";
	}
	@RequestMapping(value = "/getAllUsers")
	public @ResponseBody List<User> getAllUsers(HttpServletResponse response) {
		List<User> result = userService.getAllUsers();
		return result;
	}
	@RequestMapping(value = "/getAttendedUsers")
	public @ResponseBody List<User> getAttendedUsers(HttpServletResponse response) {
		List<User> result = userService.getAttendedUsers();
		return result;
	}
	@RequestMapping(value = "/getWorkingUsers")
	public @ResponseBody List<User> getWorkingUsers(HttpServletResponse response) {
		List<User> result = userService.getWorkingUsers();
		return result;
	}

}
