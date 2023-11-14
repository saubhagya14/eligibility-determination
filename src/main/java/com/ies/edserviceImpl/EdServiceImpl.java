package com.ies.edserviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ies.ed.entity.CititzenAppEntity;
import com.ies.ed.entity.DcEducationEntity;
import com.ies.ed.entity.DcIncomeEntity;
import com.ies.ed.entity.DcKidEntity;
import com.ies.ed.entity.EligibiltyEntity;
import com.ies.ed.entity.Plan;
import com.ies.ed.repo.CitizenAppRepo;
import com.ies.ed.repo.EducationRepo;
import com.ies.ed.repo.EligibilityRepo;
import com.ies.ed.repo.IncomeRepo;
import com.ies.ed.repo.KidRepo;
import com.ies.ed.repo.PlanRepo;
import com.ies.ed.service.EdService;

public class EdServiceImpl implements EdService {

	@Autowired
	CitizenAppRepo citizenAppRepo;
	@Autowired
	PlanRepo planRepo;
	@Autowired
	IncomeRepo incomeRepo;
	@Autowired
	KidRepo kidRepo;
	@Autowired
	EducationRepo educationRepo;
	@Autowired
	EligibilityRepo eligibilityRepo;

	@Override
	public Object checkEligibility(Integer caseNumber) {
		
		Optional<EligibiltyEntity> optional =  eligibilityRepo.findByCaseNumber(caseNumber);
		
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return getEligibility(caseNumber);
		}
		
	}
	
	public Object getEligibility(int caseNumber) {
		EligibiltyEntity eligibiltyEntity = new EligibiltyEntity();

		String planName = "";
		Integer planId;
		boolean isPassKidCond = false;
		int age = 0;
		String graduationName = "";
		Double sallaryInCome;
		Double propertyIncome;
		Double rentIncome;

		Optional<CititzenAppEntity> findCaseNumber = citizenAppRepo.findById(caseNumber);

		if (findCaseNumber.isPresent()) {
			CititzenAppEntity cititzenAppEntity = findCaseNumber.get();
			planId = cititzenAppEntity.getPlanId();
			LocalDate today = LocalDate.now();
			Period period = Period.between(cititzenAppEntity.getDob(), today);
			age = period.getYears();

			Optional<Plan> findPlanId = planRepo.findById(planId);

			if (findPlanId.isPresent()) {
				planName = findPlanId.get().getPlanName();

				DcIncomeEntity dcIncomeEntity = incomeRepo.findByCaseNo(caseNumber);
				List<DcKidEntity> dcKidEntities = kidRepo.findByCaseNo(caseNumber);
				DcEducationEntity dcEducationEntity = educationRepo.findByCaseNo(caseNumber);

				sallaryInCome = dcIncomeEntity.getMonthlySallaryIncome();
				propertyIncome = dcIncomeEntity.getPropertyIncome();
				rentIncome = dcIncomeEntity.getRentIncome();

				for (DcKidEntity dcKidEntity : dcKidEntities) {
					if (dcKidEntity.getKidAge() <= 16) {
						isPassKidCond = true;
					} else {
						isPassKidCond = false;
					}
				}

				graduationName = dcEducationEntity.getGraduationName();

				switch (planName) {

				case "SNAP":
					if (sallaryInCome <= 30000) {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Approved");
						eligibiltyEntity.setBenifitAmount(35000.0);

						LocalDate localDate = LocalDate.now();
						eligibiltyEntity.setStartDate(localDate);
						eligibiltyEntity.setEndDate(localDate.plusMonths(3));

					} else {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Denied");
						eligibiltyEntity.setDenialReason("Income Condition Failed");
					}
					break;
				case "CCAP":
					if (sallaryInCome <= 30000) {

						if (isPassKidCond) {
							eligibiltyEntity.setPlanName(planName);
							eligibiltyEntity.setPlanStatus("Approved");
							eligibiltyEntity.setBenifitAmount(40000.0);

							LocalDate localDate = LocalDate.now();
							eligibiltyEntity.setStartDate(localDate);
							eligibiltyEntity.setEndDate(localDate.plusMonths(6));
						} else {
							eligibiltyEntity.setPlanName(planName);
							eligibiltyEntity.setPlanStatus("Denied");
							eligibiltyEntity.setDenialReason("Kids condition failed");
						}

					} else {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Denied");
						eligibiltyEntity.setDenialReason("Income Condition Failed");
					}
					break;

				case "Medicaid":
					if (sallaryInCome <= 30000 && propertyIncome <= 0.0 && rentIncome <= 0.0) {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Approved");
						eligibiltyEntity.setBenifitAmount(35000.0);

						LocalDate localDate = LocalDate.now();
						eligibiltyEntity.setStartDate(localDate);
						eligibiltyEntity.setEndDate(localDate.plusMonths(3));

					} else {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Denied");
						eligibiltyEntity.setDenialReason("Income Condition Failed");
					}
					break;
				case "Medicare":
					if (age >= 65) {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Approved");
						eligibiltyEntity.setBenifitAmount(35000.0);

						LocalDate localDate = LocalDate.now();
						eligibiltyEntity.setStartDate(localDate);
						eligibiltyEntity.setEndDate(localDate.plusMonths(12));

					} else {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Denied");
						eligibiltyEntity.setDenialReason("Age Condition Failed");
					}
					break;

				case "RIW":
					if (sallaryInCome == 0.0 && graduationName != null) {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Approved");
						eligibiltyEntity.setBenifitAmount(35000.0);

						LocalDate localDate = LocalDate.now();
						eligibiltyEntity.setStartDate(localDate);
						eligibiltyEntity.setEndDate(localDate.plusMonths(12));

					} else {
						eligibiltyEntity.setPlanName(planName);
						eligibiltyEntity.setPlanStatus("Denied");
						eligibiltyEntity.setDenialReason("RIW Condition Failed");
					}
					break;

				}

			}

			eligibilityRepo.save(eligibiltyEntity);
		}

		return null;
	}

}
