package com.wang.mapper;

import java.util.Date;
import java.util.List;

import com.wang.pojo.Plan;

public interface PlanMapper {
	void addPlan(Plan plan);
	void deletePlan(Integer id);
	void updatePlan(Plan plan);
	Plan selectCurrentPlans(Plan plan);
	List<Plan> selectAllPlans(Integer id);

}
