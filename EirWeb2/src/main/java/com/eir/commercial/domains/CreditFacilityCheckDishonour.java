package com.eir.commercial.domains;

public class CreditFacilityCheckDishonour {

	private String month;
	private String month3;
	private String month6;
	private String month9;
	private String month12;
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the month3
	 */
	public String getMonth3() {
		return month3;
	}

	/**
	 * @param month3 the month3 to set
	 */
	public void setMonth3(String month3) {
		this.month3 = month3;
	}

	/**
	 * @return the month6
	 */
	public String getMonth6() {
		return month6;
	}

	/**
	 * @param month6 the month6 to set
	 */
	public void setMonth6(String month6) {
		this.month6 = month6;
	}

	/**
	 * @return the month9
	 */
	public String getMonth9() {
		return month9;
	}

	/**
	 * @param month9 the month9 to set
	 */
	public void setMonth9(String month9) {
		this.month9 = month9;
	}

	/**
	 * @return the month12
	 */
	public String getMonth12() {
		return month12;
	}

	/**
	 * @param month12 the month12 to set
	 */
	public void setMonth12(String month12) {
		this.month12 = month12;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreditFAcilityCheckDishonour6 [month=");
		builder.append(month);
		builder.append(", month3=");
		builder.append(month3);
		builder.append(", month6=");
		builder.append(month6);
		builder.append(", month9=");
		builder.append(month9);
		builder.append(", month12=");
		builder.append(month12);
		builder.append("]");
		return builder.toString();
	}
	
}
