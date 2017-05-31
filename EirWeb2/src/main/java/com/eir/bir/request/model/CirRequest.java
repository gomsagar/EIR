package com.eir.bir.request.model;


public class CirRequest {
	
	String ernNumber;
	String status;
	String cirRequetcol;
	Integer bankAccNo;
	String productField;
	String purpose;
	Float amt;
	String accType1;
	String clientRefNo;
	String accType2;
	String cmpPan;
	String addrType;
	String addrLinen1;
	String addrline2;
	String city;
	String state;
	String pinCode;
	String telephoneNo;
	String pan;
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
	public String getProductField() {
		return productField;
	}
	public void setProductField(String productField) {
		this.productField = productField;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
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
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	public String getAddrLinen1() {
		return addrLinen1;
	}
	public void setAddrLinen1(String addrLinen1) {
		this.addrLinen1 = addrLinen1;
	}
	public String getAddrline2() {
		return addrline2;
	}
	public void setAddrline2(String addrline2) {
		this.addrline2 = addrline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
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

}