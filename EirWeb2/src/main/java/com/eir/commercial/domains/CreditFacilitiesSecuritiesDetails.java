package com.eir.commercial.domains;

public class CreditFacilitiesSecuritiesDetails {

	private String currency;
	private String type;
	private String classification;
	private String valuationDate;
	private String securityValue;
	private String lastReportDate;
	
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * @param classification the classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * @return the valuationDate
	 */
	public String getValuationDate() {
		return valuationDate;
	}

	/**
	 * @param valuationDate the valuationDate to set
	 */
	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	/**
	 * @return the securityValue
	 */
	public String getSecurityValue() {
		return securityValue;
	}

	/**
	 * @param securityValue the securityValue to set
	 */
	public void setSecurityValue(String securityValue) {
		this.securityValue = securityValue;
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
		builder.append("CreditFacilitiesSecuritiesDetails5 [currency=");
		builder.append(currency);
		builder.append(", type=");
		builder.append(type);
		builder.append(", classification=");
		builder.append(classification);
		builder.append(", valuationDate=");
		builder.append(valuationDate);
		builder.append(", securityValue=");
		builder.append(securityValue);
		builder.append(", lastReportDate=");
		builder.append(lastReportDate);
		builder.append("]");
		return builder.toString();
	}
	
}
