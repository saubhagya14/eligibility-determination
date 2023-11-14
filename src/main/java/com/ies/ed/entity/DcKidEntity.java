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
@Table(name = "ies_kids")
public class DcKidEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String kidName;
	private Integer kidAge;
	private String kidSsn;
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

	public String getKidName() {
		return kidName;
	}

	public void setKidName(String kidName) {
		this.kidName = kidName;
	}

	public Integer getKidAge() {
		return kidAge;
	}

	public void setKidAge(Integer kidAge) {
		this.kidAge = kidAge;
	}

	public String getKidSsn() {
		return kidSsn;
	}

	public void setKidSsn(String kidSsn) {
		this.kidSsn = kidSsn;
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
