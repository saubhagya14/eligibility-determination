package com.ies.ed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ies_income_details")
public class DcIncomeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private double monthlySallaryIncome;
	private double rentIncome;
	private double propertyIncome;
	@OneToOne
	@JoinColumn(name = "caseNo")
	private CititzenAppEntity cititzenAppEntity;
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserInfo user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMonthlySallaryIncome() {
		return monthlySallaryIncome;
	}

	public void setMonthlySallaryIncome(double monthlySallaryIncome) {
		this.monthlySallaryIncome = monthlySallaryIncome;
	}

	public double getRentIncome() {
		return rentIncome;
	}

	public void setRentIncome(double rentIncome) {
		this.rentIncome = rentIncome;
	}

	public double getPropertyIncome() {
		return propertyIncome;
	}

	public void setPropertyIncome(double propertyIncome) {
		this.propertyIncome = propertyIncome;
	}

	public CititzenAppEntity getCititzenAppEntity() {
		return cititzenAppEntity;
	}

	public void setCititzenAppEntity(CititzenAppEntity cititzenAppEntity) {
		this.cititzenAppEntity = cititzenAppEntity;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
