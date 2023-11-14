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
@Table(name = "ies_education")
public class DcEducationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String highestDegree;
	private String graduationName;
	private String universityName;
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

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getGraduationName() {
		return graduationName;
	}

	public void setGraduationName(String graduationName) {
		this.graduationName = graduationName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
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
