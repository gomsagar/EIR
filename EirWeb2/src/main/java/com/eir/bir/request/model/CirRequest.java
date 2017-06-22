package com.eir.bir.request.model;


public class CirRequest {
	
	String ernNumber;
	String companyName;
	String status;
	String cirRequetcol;
	Integer bankAccNo;
	ReportType productField;
	CirPurpose cirPurpose;
	Float amt;
	String accType1;
	String clientRefNo;
	String accType2;
	String cmpPan;
	AddressType addrType;
	String addrLine1;
	String addrLine2;
	String city;
	State cirState;
	String pinCode;
	String telephoneNo;
	String cin;
	String tin;
	String emailId;
	String triggers;
	
	public String getErnNumber() {
		return ernNumber;
	}
	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCirRequetcol() {
		return cirRequetcol;
	}
	public void setCirRequetcol(String cirRequetcol) {
		this.cirRequetcol = cirRequetcol;
	}
	@Override
	public String toString() {
		return "CirRequest [ernNumber=" + ernNumber + ", status=" + status + ", cirRequetcol=" + cirRequetcol + "]";
	}
	
	public Integer getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(Integer bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public ReportType getProductField() {
		return productField;
	}
	public void setProductField(ReportType productField) {
		this.productField = productField;
	}
	
	public Float getAmt() {
		return amt;
	}
	public void setAmt(Float amt) {
		this.amt = amt;
	}
	public String getAccType1() {
		return accType1;
	}
	public void setAccType1(String accType1) {
		this.accType1 = accType1;
	}
	public String getClientRefNo() {
		return clientRefNo;
	}
	public void setClientRefNo(String clientRefNo) {
		this.clientRefNo = clientRefNo;
	}
	public String getAccType2() {
		return accType2;
	}
	public void setAccType2(String accType2) {
		this.accType2 = accType2;
	}
	public String getCmpPan() {
		return cmpPan;
	}
	public void setCmpPan(String cmpPan) {
		this.cmpPan = cmpPan;
	}
	public AddressType getAddrType() {
		return addrType;
	}
	public void setAddrType(AddressType addrType) {
		this.addrType = addrType;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public State getCirState() {
		return cirState;
	}
	public void setCirState(State cirState) {
		this.cirState = cirState;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTriggers() {
		return triggers;
	}
	public void setTriggers(String triggers) {
		this.triggers = triggers;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	public CirPurpose getCirPurpose() {
		return cirPurpose;
	}
	public void setCirPurpose(CirPurpose cirPurpose) {
		this.cirPurpose = cirPurpose;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
