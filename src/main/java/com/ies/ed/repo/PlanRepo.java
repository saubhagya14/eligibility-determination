package com.ies.ed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.ed.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
