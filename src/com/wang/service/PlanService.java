package com.wang.service;

import java.util.List;

import com.wang.pojo.Plan;

public interface PlanService {

	public void createPlan(Plan plan);
	public void deletePlan(Integer id);
	public void changePlan(Plan plan);
	public Plan getCurrentPlan(Plan plan);
	public List<Plan> getAllPlans(Integer user_id);
}
