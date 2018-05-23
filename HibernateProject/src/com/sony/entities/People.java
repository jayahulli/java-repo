package com.sony.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PEOPLE")
public class People {
	
	@Id
	@Column(name = "pplId" , unique = true , nullable = false)
	private int pplId;
	
	@Column(name = "pplName")
	private String pplName;
	
	@Embedded
	private Address address;
	
	@Column(name = "pplPhone")
	private String pplPhone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;
	
	public People() {
		super();
	}
	
	public People(int pplId, String pplName, Address address, String pplPhone, Date dob) {
		super();
		this.pplId = pplId;
		this.pplName = pplName;
		this.address = address;
		this.pplPhone = pplPhone;
		this.dob = dob;
	}

	public int getPplId() {
		return pplId;
	}

	public void setPplId(int pplId) {
		this.pplId = pplId;
	}

	public String getPplName() {
		return pplName;
	}

	public void setPplName(String pplName) {
		this.pplName = pplName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPplPhone() {
		return pplPhone;
	}

	public void setPplPhone(String pplPhone) {
		this.pplPhone = pplPhone;
	}

	public Date getDate() {
		return dob;
	}

	public void setDate(Date dob) {
		this.dob = dob;
	}

}
