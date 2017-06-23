package com.eir.commercial.domains;

public class CreditFacilityBorowerDetails {
 private String borrowerNm;
 private String panNo;
 private String cin;
 private String tin;
 private String address;
 private String addType;
 private String accStatusDate;
 private String lastReportDate;

/**
 * @return the borrowerNm
 */
public String getBorrowerNm() {
	return borrowerNm;
}

/**
 * @param borrowerNm the borrowerNm to set
 */
public void setBorrowerNm(String borrowerNm) {
	this.borrowerNm = borrowerNm;
}

/**
 * @return the panNo
 */
public String getPanNo() {
	return panNo;
}

/**
 * @param panNo the panNo to set
 */
public void setPanNo(String panNo) {
	this.panNo = panNo;
}

/**
 * @return the cin
 */
public String getCin() {
	return cin;
}

/**
 * @param cin the cin to set
 */
public void setCin(String cin) {
	this.cin = cin;
}

/**
 * @return the tin
 */
public String getTin() {
	return tin;
}

/**
 * @param tin the tin to set
 */
public void setTin(String tin) {
	this.tin = tin;
}

/**
 * @return the address
 */
public String getAddress() {
	return address;
}

/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}

/**
 * @return the addType
 */
public String getAddType() {
	return addType;
}

/**
 * @param addType the addType to set
 */
public void setAddType(String addType) {
	this.addType = addType;
}

/**
 * @return the accStatusDate
 */
public String getAccStatusDate() {
	return accStatusDate;
}

/**
 * @param accStatusDate the accStatusDate to set
 */
public void setAccStatusDate(String accStatusDate) {
	this.accStatusDate = accStatusDate;
}

/**
 * @return the lastReportDate
 */
public String getLastReportDate() {
	return lastReportDate;
}

/**
 * @param lastReportDate the lastReportDate to set
 */
public void setLastReportDate(String lastReportDate) {
	this.lastReportDate = lastReportDate;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CreditFacilityBorowerDetails4 [borrowerNm=");
	builder.append(borrowerNm);
	builder.append(", panNo=");
	builder.append(panNo);
	builder.append(", cin=");
	builder.append(cin);
	builder.append(", tin=");
	builder.append(tin);
	builder.append(", address=");
	builder.append(address);
	builder.append(", addType=");
	builder.append(addType);
	builder.append(", accStatusDate=");
	builder.append(accStatusDate);
	builder.append(", lastReportDate=");
	builder.append(lastReportDate);
	builder.append("]");
	return builder.toString();
}
 
}
