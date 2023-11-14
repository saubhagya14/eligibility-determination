package com.ies.ed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.ed.entity.DcEducationEntity;

public interface EducationRepo extends JpaRepository<DcEducationEntity, Integer> {

	public DcEducationEntity findByCaseNo(Integer caseNumber);
}
