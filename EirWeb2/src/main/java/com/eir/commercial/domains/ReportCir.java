package com.eir.commercial.domains;

public class ReportCir {
	private String address;
	  private String city;
	  private String pincode;
	  private String experianReferenceNumber;
	  private String dateOfReport;
	  private String company_name;
	  private String email;
	  private String telephone;
	  private String post;
	  private String website;
	  
	  
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the experianReferenceNumber
	 */
	public String getExperianReferenceNumber() {
		return experianReferenceNumber;
	}
	/**
	 * @param experianReferenceNumber the experianReferenceNumber to set
	 */
	public void setExperianReferenceNumber(String experianReferenceNumber) {
		this.experianReferenceNumber = experianReferenceNumber;
	}
	/**
	 * @return the dateOfReport
	 */
	public String getDateOfReport() {
		return dateOfReport;
	}
	/**
	 * @param dateOfReport the dateOfReport to set
	 */
	public void setDateOfReport(String dateOfReport) {
		this.dateOfReport = dateOfReport;
	}
	/**
	 * @return the company_name
	 */
	public String getCompany_name() {
		return company_name;
	}
	/**
	 * @param company_name the company_name to set
	 */
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportCir [address=" + address + ", city=" + city + ", pincode=" + pincode + ", experianReferenceNumber="
				+ experianReferenceNumber + ", dateOfReport=" + dateOfReport + ", company_name=" + company_name + "]";
	}
	  
	
}
