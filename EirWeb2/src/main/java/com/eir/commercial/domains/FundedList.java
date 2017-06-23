package com.eir.commercial.domains;

public class FundedList {

	
	private String currency;
	 //private String noOfAcc;/** *No of Account */
	 private String Funded;
	 private String NonFunded;
	 private String ShortTerm;
	 private String checkDishonor;
	 private String LongTerm;
	 private String Wilful;
	 private String SuitFiled;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getFunded() {
		return Funded;
	}
	public void setFunded(String funded) {
		Funded = funded;
	}
	public String getNonFunded() {
		return NonFunded;
	}
	public void setNonFunded(String nonFunded) {
		NonFunded = nonFunded;
	}
	public String getShortTerm() {
		return ShortTerm;
	}
	public void setShortTerm(String shortTerm) {
		ShortTerm = shortTerm;
	}
	public String getCheckDishonor() {
		return checkDishonor;
	}
	public void setCheckDishonor(String checkDishonor) {
		this.checkDishonor = checkDishonor;
	}
	public String getLongTerm() {
		return LongTerm;
	}
	public void setLongTerm(String longTerm) {
		LongTerm = longTerm;
	}
	public String getWilful() {
		return Wilful;
	}
	public void setWilful(String wilful) {
		Wilful = wilful;
	}
	public String getSuitFiled() {
		return SuitFiled;
	}
	public void setSuitFiled(String suitFiled) {
		SuitFiled = suitFiled;
	}
	@Override
	public String toString() {
		return "FundedList [currency=" + currency + ", Funded=" + Funded
				+ ", NonFunded=" + NonFunded + ", ShortTerm=" + ShortTerm
				+ ", checkDishonor=" + checkDishonor + ", LongTerm=" + LongTerm
				+ ", Wilful=" + Wilful + ", SuitFiled=" + SuitFiled + "]";
	}
	 
	 
}
