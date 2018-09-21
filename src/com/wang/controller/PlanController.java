package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.pojo.Plan;
import com.wang.pojo.User;
import com.wang.service.PlanService;

@Controller
public class PlanController {
//	public void createPlan(Plan plan);
//	public void deletePlan(Integer id);
//	public void changePlan(Plan plan);
//	public Plan getCurrentPlan(Plan plan);
//	public List<Plan> getAllPlans(Integer user_id);
	
	@Autowired
	private PlanService planService;
	
	@RequestMapping(value = "/createPlan")
	public void createPlan(@RequestBody Plan plan) {
		planService.createPlan(plan);
	}
	@RequestMapping(value = "/deletePlan")
	public void deletePlan(@RequestBody String id) {
		planService.deletePlan(Integer.parseInt(id));
	}
	@RequestMapping(value = "/changePlan")
	public void changePlan(@RequestBody Plan plan) {
		planService.changePlan(plan);
	}
	@RequestMapping(value = "/getCurrentPlan")
	public @ResponseBody Plan getCurrentPlan(@RequestBody String id) {
		Plan result  = planService.getCurrentPlan(Integer.parseInt(id));
		return result;
	}
	@RequestMapping(value = "/getAllPlans")
	public @ResponseBody List<Plan> getAllPlans(@RequestBody String user_id) {
		List<Plan> result = planService.getAllPlans(Integer.parseInt(user_id));
		return result;
	}

}
