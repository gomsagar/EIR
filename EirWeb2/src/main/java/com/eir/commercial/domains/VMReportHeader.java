package com.eir.commercial.domains;

public class VMReportHeader {

	
	private String experianReferenceNumber;
	private String enquiryReference;
	private String memberName;
	private String generateDate;
	private String generateTime;
	
	
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
	 * @return the enquiryReference
	 */
	public String getEnquiryReference() {
		return enquiryReference;
	}


	/**
	 * @param enquiryReference the enquiryReference to set
	 */
	public void setEnquiryReference(String enquiryReference) {
		this.enquiryReference = enquiryReference;
	}


	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}


	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	/**
	 * @return the generateDate
	 */
	public String getGenerateDate() {
		return generateDate;
	}


	/**
	 * @param generateDate the generateDate to set
	 */
	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}


	/**
	 * @return the generateTime
	 */
	public String getGenerateTime() {
		return generateTime;
	}


	/**
	 * @param generateTime the generateTime to set
	 */
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}


	@Override
	public String toString() {
		return "ReportHeader [experianReferenceNumber=" + experianReferenceNumber + ", enquiryReference="
				+ enquiryReference + ", memberName=" + memberName + ", generateDate=" + generateDate + ", generateTime="
				+ generateTime + "]";
	}
	
	

	
	
}
