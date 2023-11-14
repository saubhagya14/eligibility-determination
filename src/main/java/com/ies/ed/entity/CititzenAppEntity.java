package com.ies.ed.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ies_citizen_apps")
public class CititzenAppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseNo;
	private String name;
	private String email;
	private String mobileNumber;
	private String gender="";
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dob;
	private String ssn = "";
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@CreationTimestamp
	private LocalDate createdDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@UpdateTimestamp
	private LocalDate updatedDate;
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserInfo userInfo;
	private Integer planId;
	
	public Integer getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(Integer caseNo) {
		this.caseNo = caseNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}	
	
}
