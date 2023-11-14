package com.ies.ed.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.ed.entity.DcKidEntity;

public interface KidRepo extends JpaRepository<DcKidEntity, Integer> {

	public List<DcKidEntity> findByCaseNo(Integer caseNumber);
}
