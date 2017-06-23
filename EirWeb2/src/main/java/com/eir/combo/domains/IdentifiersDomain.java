package com.eir.combo.domains;

/**
 * 
 *Setter & Getter methods of Identifiers Domain*	
 */
public class IdentifiersDomain 
{
	
	private String pan;
	private String cin;
	private String tin;
	private String sic;
	private String serviceTaxNo;
	private String noOfEmp;
	private String salesFig;
	private String financialYear;
	private String latestCreditRating;
	private String creditRatingAgency;
	
	public String getPan() 
	{
		return pan;
	}
	public void setPan(String pan) 
	{
		this.pan = pan;
	}
	public String getCin()
	{
		return cin;
	}
	public void setCin(String cin) 
	{
		this.cin = cin;
	}
	public String getTin() 
	{
		return tin;
	}
	public void setTin(String tin) 
	{
		this.tin = tin;
	}
	public String getSic() 
	{
		return sic;
	}
	public void setSic(String sic)
	{
		this.sic = sic;
	}
	public String getServiceTaxNo()
	{
		return serviceTaxNo;
	}
	public void setServiceTaxNo(String serviceTaxNo) 
	{
		this.serviceTaxNo = serviceTaxNo;
	}
	public String getNoOfEmp() 
	{
		return noOfEmp;
	}
	public void setNoOfEmp(String noOfEmp)
	{
		this.noOfEmp = noOfEmp;
	}
	public String getSalesFig()
	{
		return salesFig;
	}
	public void setSalesFig(String salesFig)
	{
		this.salesFig = salesFig;
	}
	public String getFinancialYear() 
	{
		return financialYear;
	}
	public void setFinancialYear(String financialYear)
	{
		this.financialYear = financialYear;
	}
	public String getLatestCreditRating() 
	{
		return latestCreditRating;
	}
	public void setLatestCreditRating(String latestCreditRating) 
	{
		this.latestCreditRating = latestCreditRating;
	}
	public String getCreditRatingAgency() 
	{
		return creditRatingAgency;
	}
	public void setCreditRatingAgency(String creditRatingAgency) 
	{
		this.creditRatingAgency = creditRatingAgency;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("IdentifiersDomain [pan=");
		builder.append(pan);
		builder.append(", cin=");
		builder.append(cin);
		builder.append(", tin=");
		builder.append(tin);
		builder.append(", sic=");
		builder.append(sic);
		builder.append(", serviceTaxNo=");
		builder.append(serviceTaxNo);
		builder.append(", noOfEmp=");
		builder.append(noOfEmp);
		builder.append(", salesFig=");
		builder.append(salesFig);
		builder.append(", financialYear=");
		builder.append(financialYear);
		builder.append(", latestCreditRating=");
		builder.append(latestCreditRating);
		builder.append(", creditRatingAgency=");
		builder.append(creditRatingAgency);
		builder.append("]");
		return builder.toString();
	}

}
