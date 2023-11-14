package com.ies.ed.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ies_ed")
public class EligibiltyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer edId;
	private String planName;
	private String planStatus;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private LocalDate endDate;
	private Double benifitAmount;
	private String denialReason;
	private Integer caseNumber;
	
	public Integer getEdId() {
		return edId;
	}
	public void setEdId(Integer edId) {
		this.edId = edId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Double getBenifitAmount() {
		return benifitAmount;
	}
	public void setBenifitAmount(Double benifitAmount) {
		this.benifitAmount = benifitAmount;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	public Integer getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(Integer caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	
	
}
