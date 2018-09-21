package com.wang.mapper;

import java.util.Date;
import java.util.List;

import com.wang.pojo.Plan;

public interface PlanMapper {
	void addPlan(Plan plan);
	void deletePlan(Integer id);
	void updatePlan(Plan plan);
	Plan selectCurrentPlans(Integer id);
	List<Plan> selectAllPlans(Integer id);
	Plan getWorkingUsers(List<Integer> user_ids);

}
