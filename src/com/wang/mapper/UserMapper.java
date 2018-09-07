package com.wang.mapper;

import java.util.Date;
import java.util.List;

import com.wang.pojo.Plan;
import com.wang.pojo.User;

public interface UserMapper {
	
	User selectUser(Integer id,String password);
	List<Plan> selectCurrentPlans(Integer id,Date end_time);
	List<Plan> selectAllPlans(Integer id);
	void addPlan(Plan plan);
	void deletePlan(Integer id);

}
