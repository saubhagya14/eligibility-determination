package com.ies.ed.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.ed.entity.EligibiltyEntity;

public interface EligibilityRepo extends JpaRepository<EligibiltyEntity, Integer> {

	public Optional<EligibiltyEntity> findByCaseNumber(Integer caseNumber);
}
