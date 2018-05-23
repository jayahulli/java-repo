package com.sony.entities;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE")
public class College {
	
	@Id
	@Column(name = "collegeId" , nullable = false , unique = true)
	private int collegeId;
	
	@Column(name = "collegeName")
	private String collegeName;
	
	@ElementCollection
	@CollectionTable(name = "STUDENT" , joinColumns = @JoinColumn(name = "collegeId"))
	@Column(name = "studentName")
	private Set<Student> listStudent = null;
	
	public College() {
		super();
	}

	public College(int collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}

	public College(int collegeId, String collegeName, Set<Student> listStudent) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.listStudent = listStudent;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Set<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(Set<Student> listStudent) {
		this.listStudent = listStudent;
	}
}
