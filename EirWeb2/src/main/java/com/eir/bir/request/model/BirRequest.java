package com.eir.bir.request.model;

public class BirRequest {
	
	String entityName;
	String cinNumber;
	String companyName;
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getCinNumber() {
		return cinNumber;
	}
	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "BirRequest [entityName=" + entityName + ", cinNumber=" + cinNumber + ", companyName=" + companyName
				+ "]";
	}
}
