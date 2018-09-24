package com.wang.mapper;

import java.util.Date;
import java.util.List;

import com.wang.pojo.Plan;

public interface PlanMapper {
	void addPlan(Plan plan);
	void deletePlan(Integer id);
	void updatePlan(Plan plan);
	Plan selectPlanById(Integer id);
	Plan selectCurrentPlans(Integer user_id);
	List<Plan> selectAllPlans(Integer user_id);
	Plan getWorkingUsers(List<Integer> user_ids);

}
