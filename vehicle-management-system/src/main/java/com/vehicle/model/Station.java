package com.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATION")
public class Station {
	
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "LONGITUDE")
	private String longitude;

	@Column(name = "LATITUDE")
	private String latitude;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "COMPANY_ID")
	private String companyId;

	public Station() {
		
	}
	
	public Station(String id, String longitude, String latitude, String name, String companyId) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.companyId = companyId;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
