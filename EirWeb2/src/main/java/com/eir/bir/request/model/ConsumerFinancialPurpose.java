package com.eir.bir.request.model;

public class ConsumerFinancialPurpose {

	Integer financialPurposeId;
	Integer purposeId;
	String financialDescription;

	public Integer getFinancialPurposeId() {
		return financialPurposeId;
	}

	public void setFinancialPurposeId(Integer financialPurposeId) {
		this.financialPurposeId = financialPurposeId;
	}

	public Integer getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(Integer purposeId) {
		this.purposeId = purposeId;
	}

	public String getFinancialDescription() {
		return financialDescription;
	}

	public void setFinancialDescription(String financialDescription) {
		this.financialDescription = financialDescription;
	}

}
