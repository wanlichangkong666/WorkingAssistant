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
	public @ResponseBody String attend(@RequestBody String id) {
		
		String result = userService.attend(Integer.parseInt(id));
		return result;
	}
	@RequestMapping(value = "/leave")
	public @ResponseBody String leave(@RequestBody String id) {
		
		String result = userService.leave(Integer.parseInt(id));
		return result;
	}
	@RequestMapping(value = "/changePassword")
	public void changePassword(HttpServletResponse response, @RequestBody User user) {
		userService.changePassword(user);
	}
	@RequestMapping(value = "/createUser")
	public void createUser(HttpServletResponse response, @RequestBody User user) {
		userService.createUser(user);
		
	}
	@RequestMapping(value = "/deleteUser")
	public void deleteUser(HttpServletResponse response, @RequestBody String id) {
		userService.deleteUser(Integer.parseInt(id));
	}
	@RequestMapping(value = "/getAllUsers")
	public @ResponseBody List<User> login(HttpServletResponse response) {
		List<User> result = userService.getAllUsers();
		return result;
	}

}
