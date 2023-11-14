package com.ies.ed.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ies_user")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String fullName = "";
	private String email = "";
	private String password = "";
	private String userRole = "user";
	private String mobileNumber = "";
	private String gender = "";
	private boolean isActive;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dob;
	private String ssn = "";
	private Integer createdBy;

	public UserInfo() {
	}	

	public UserInfo(String fullName, String email, String password, String userRole, String mobileNumber, String gender,
			boolean isActive, LocalDate dob, String ssn) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.isActive = isActive;
		this.dob = dob;
		this.ssn = ssn;
	}

  

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	
}

