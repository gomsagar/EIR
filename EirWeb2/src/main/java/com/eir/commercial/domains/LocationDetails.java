package com.eir.commercial.domains;

public class LocationDetails {
 private String businessAddress;
 private String businessCity;
 private String pinCode;
 private String telephone;
 private  String businessId;
 private String rptAsOfDt;
 private String regOffice;

/**
 * @return the businessAddress
 */
public String getBusinessAddress() {
	return businessAddress;
}

/**
 * @param businessAddress the businessAddress to set
 */
public void setBusinessAddress(String businessAddress) {
	this.businessAddress = businessAddress;
}


/**
 * @return the pinCode
 */
public String getPinCode() {
	return pinCode;
}

/**
 * @param pinCode the pinCode to set
 */
public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}

/**
 * @return the businessCity
 */
public String getBusinessCity() {
	return businessCity;
}

/**
 * @param businessCity the businessCity to set
 */
public void setBusinessCity(String businessCity) {
	this.businessCity = businessCity;
}

/**
 * @return the telephone
 */
public String getTelephone() {
	return telephone;
}

/**
 * @param telephone the telephone to set
 */
public void setTelephone(String telephone) {
	this.telephone = telephone;
}

/**
 * @return the businessId
 */
public String getBusinessId() {
	return businessId;
}

/**
 * @param businessId the businessId to set
 */
public void setBusinessId(String businessId) {
	this.businessId = businessId;
}

/**
 * @return the rptAsOfDt
 */
public String getRptAsOfDt() {
	return rptAsOfDt;
}

/**
 * @param rptAsOfDt the rptAsOfDt to set
 */
public void setRptAsOfDt(String rptAsOfDt) {
	this.rptAsOfDt = rptAsOfDt;
}

/**
 * @return the regOffice
 */
public String getRegOffice() {
	return regOffice;
}

/**
 * @param regOffice the regOffice to set
 */
public void setRegOffice(String regOffice) {
	this.regOffice = regOffice;
}



/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "LocationDetails [businessAddress=" + businessAddress
			+ ", businessCity=" + businessCity + ", pinCode=" + pinCode
			+ ", telephone=" + telephone + ", businessId=" + businessId
			+ ", rptAsOfDt=" + rptAsOfDt + ", regOffice=" + regOffice + "]";
}


}
