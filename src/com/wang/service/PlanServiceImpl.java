package com.wang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mapper.PlanMapper;
import com.wang.pojo.Plan;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired 
	private PlanMapper planMapper;

	@Override
	public void createPlan(Plan plan) {
		planMapper.addPlan(plan);
		
	}

	@Override
	public void deletePlan(Integer id) {
		planMapper.deletePlan(id);
		
	}

	@Override
	public void changePlan(Plan plan) {
		planMapper.updatePlan(plan);
		
	}

	@Override
	public Plan getCurrentPlan(Integer user_id) {
		
		return planMapper.selectCurrentPlans(user_id);
	}

	@Override
	public List<Plan> getAllPlans(Integer user_id) {

		return planMapper.selectAllPlans(user_id);
	}

	@Override
	public void finishPlan(Integer id) {
		Plan plan = planMapper.selectPlanById(id);
		plan.setFinish(true);
		planMapper.updatePlan(plan);
		
	}

}
