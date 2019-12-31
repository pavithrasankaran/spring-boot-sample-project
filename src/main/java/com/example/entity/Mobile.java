package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer id;
	private String companyName;
	private String model;
	
	public Mobile(Integer id, String companyName, String model) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.model = model;
	}
	
	public Mobile() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", companyName=" + companyName + ", model=" + model + "]";
	}
	
	

}
