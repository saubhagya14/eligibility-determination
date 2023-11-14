package com.ies.ed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.ed.entity.DcIncomeEntity;

public interface IncomeRepo extends JpaRepository<DcIncomeEntity, Integer> {

	public DcIncomeEntity findByCaseNo(Integer caseNumber);
}
