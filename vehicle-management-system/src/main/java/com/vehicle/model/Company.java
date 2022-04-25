package com.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "PARENT_COMPANY_ID")
	private String parentCompanyId;

	@Column(name = "NAME")
	private String name;
	
	public Company() {
		
	}
	
	public Company(String id, String parentCompanyId, String name) {
		this.id = id;
		this.parentCompanyId = parentCompanyId;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentCompanyId() {
		return parentCompanyId;
	}

	public void setParentCompanyId(String parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
