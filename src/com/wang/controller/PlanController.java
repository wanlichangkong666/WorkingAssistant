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
	public @ResponseBody String createPlan(@RequestBody Plan plan) {
		try {
			planService.createPlan(plan);
			return "SUCCESS";
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return "FAIL";
	}
	@RequestMapping(value = "/deletePlan")
	public @ResponseBody String deletePlan(@RequestBody Plan plan) {
		try {
			planService.deletePlan(plan.getId());
			return "SUCCESS";
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return "FAIL";
	}
	@RequestMapping(value = "/changePlan")
	public @ResponseBody String changePlan(@RequestBody Plan plan) {
		try {
			planService.changePlan(plan);
			return "SUCCESS";
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "FAIL";
	}
	@RequestMapping(value = "/getCurrentPlan")
	public @ResponseBody Plan getCurrentPlan(@RequestBody Plan plan) {
		Plan result  = planService.getCurrentPlan(plan.getUser_id());
		return result;
	}
	@RequestMapping(value = "/getAllPlans")
	public @ResponseBody List<Plan> getAllPlans(@RequestBody Plan plan) {
		List<Plan> result = planService.getAllPlans(plan.getUser_id());
		return result;
	}
	@RequestMapping(value = "/finishPlan")
	public @ResponseBody String finishPlan(@RequestBody Plan plan) {
		try {
			planService.finishPlan(plan.getId());
			return "SUCCESS";
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "FAIL";
	}
}
