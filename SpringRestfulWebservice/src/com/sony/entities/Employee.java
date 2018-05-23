package com.sony.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement(name = "employee")
@JsonPropertyOrder({"empId","empName"})
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "employee1")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = -3501772243949297054L;
	
	@Id
	@Column(name = "empId" , unique = true , nullable = false)
	@JsonProperty("empId")
	private int empId;
	
	@Column(name = "empName")
	@JsonProperty("empId")
	private String empName;
	
	@Column(name = "empSalary")
	@JsonProperty("empSalary")
	private double empSalary;
	
	@Column(name = "empDesignation")
	@JsonProperty("empDesignation")
	private String empDesignation;
	
	@Column(name = "empLocation")
	@JsonProperty("empLocation")
	private String empLocation;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, double empSalary, String empDesignation, String empLocation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDesignation = empDesignation;
		this.empLocation = empLocation;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	@XmlElement
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	@XmlElement
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public double getEmpSalary() {
		return empSalary;
	}
	
	@XmlElement
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	public String getEmpDesignation() {
		return empDesignation;
	}
	
	@XmlElement
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
	public String getEmpLocation() {
		return empLocation;
	}
	
	@XmlElement
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

}
