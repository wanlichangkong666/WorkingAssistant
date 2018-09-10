package com.wang.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;

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


}
