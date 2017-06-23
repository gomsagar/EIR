package com.eir.commercial.domains;

public class EnquiryDetails {
 private String outputInqRqstDt;
 private String outputInqPurpCd4In;
 private String outputInqCreditinstitutionNm;
 private String outputInqCreditExtAm;
 private String currency;
 private String amount;

/**
 * @return the outputInqRqstDt
 */
public String getOutputInqRqstDt() {
	return outputInqRqstDt;
}

/**
 * @param outputInqRqstDt the outputInqRqstDt to set
 */
public void setOutputInqRqstDt(String outputInqRqstDt) {
	this.outputInqRqstDt = outputInqRqstDt;
}

/**
 * @return the outputInqPurpCd4In
 */
public String getOutputInqPurpCd4In() {
	return outputInqPurpCd4In;
}

/**
 * @param outputInqPurpCd4In the outputInqPurpCd4In to set
 */
public void setOutputInqPurpCd4In(String outputInqPurpCd4In) {
	this.outputInqPurpCd4In = outputInqPurpCd4In;
}

/**
 * @return the outputInqCreditinstitutionNm
 */
public String getOutputInqCreditinstitutionNm() {
	return outputInqCreditinstitutionNm;
}

/**
 * @param outputInqCreditinstitutionNm the outputInqCreditinstitutionNm to set
 */
public void setOutputInqCreditinstitutionNm(String outputInqCreditinstitutionNm) {
	this.outputInqCreditinstitutionNm = outputInqCreditinstitutionNm;
}

/**
 * @return the outputInqCreditExtAm
 */
public String getOutputInqCreditExtAm() {
	return outputInqCreditExtAm;
}

/**
 * @param outputInqCreditExtAm the outputInqCreditExtAm to set
 */
public void setOutputInqCreditExtAm(String outputInqCreditExtAm) {
	this.outputInqCreditExtAm = outputInqCreditExtAm;
}

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
 * @return the amount
 */
public String getAmount() {
	return amount;
}

/**
 * @param amount the amount to set
 */
public void setAmount(String amount) {
	this.amount = amount;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "EnquiryDetails [outputInqRqstDt=" + outputInqRqstDt + ", outputInqPurpCd4In=" + outputInqPurpCd4In
			+ ", outputInqCreditinstitutionNm=" + outputInqCreditinstitutionNm + ", outputInqCreditExtAm="
			+ outputInqCreditExtAm + ", currency=" + currency + ", amount=" + amount + "]";
}



 
}
