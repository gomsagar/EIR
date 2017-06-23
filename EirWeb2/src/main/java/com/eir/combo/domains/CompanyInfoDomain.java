package com.eir.combo.domains;

/**
 *Setter & Getter methods of Company Information Domain*	
 */
public class CompanyInfoDomain 
{
	
	private String companyName;
	private String companyShortName;
	private String address;
	private String telephone;
	private String fax;
	private String legalConst;
	private String businessCategory;
	private String industryType;
	private String classOfActivity;
	private String registrationNo;
	private String regDate;
	private String regCity;
	private String regState;
	private String score;
	private String creditRating;
	
	public String getScore() 
	{
		return score;
	}

	public void setScore(String score) 
	{
		this.score = score;
	}


	public String getCreditRating() 
	{
		return creditRating;
	}

	public void setCreditRating(String creditRating) 
	{
		this.creditRating = creditRating;
	}

	public String getLegalConst() 
	{
		return legalConst;
	}

	public void setLegalConst(String legalConst) 
	{
		this.legalConst = legalConst;
	}

	public String getBusinessCategory() 
	{
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) 
	{
		this.businessCategory = businessCategory;
	}

	public String getIndustryType() 
	{
		return industryType;
	}

	public void setIndustryType(String industryType) 
	{
		this.industryType = industryType;
	}

	public String getClassOfActivity() 
	{
		return classOfActivity;
	}

	public void setClassOfActivity(String classOfActivity) 
	{
		this.classOfActivity = classOfActivity;
	}

	public String getRegistrationNo() 
	{
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo)
	{
		this.registrationNo = registrationNo;
	}

	public String getRegDate()
	{
		return regDate;
	}

	public void setRegDate(String regDate) 
	{
		this.regDate = regDate;
	}

	public String getRegCity() 
	{
		return regCity;
	}

	public void setRegCity(String regCity) 
	{
		this.regCity = regCity;
	}

	public String getRegState() 
	{
		return regState;
	}

	public void setRegState(String regState) 
	{
		this.regState = regState;
	}

	public String getCompanyName() 
	{
		return companyName;
	}

	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	public String getCompanyShortName() 
	{
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) 
	{
		this.companyShortName = companyShortName;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getFax() 
	{
		return fax;
	}
	
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyInfoDomain [companyName=");
		builder.append(companyName);
		builder.append(", companyShortName=");
		builder.append(companyShortName);
		builder.append(", address=");
		builder.append(address);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", legalConst=");
		builder.append(legalConst);
		builder.append(", businessCategory=");
		builder.append(businessCategory);
		builder.append(", industryType=");
		builder.append(industryType);
		builder.append(", classOfActivity=");
		builder.append(classOfActivity);
		builder.append(", registrationNo=");
		builder.append(registrationNo);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", regCity=");
		builder.append(regCity);
		builder.append(", regState=");
		builder.append(regState);
		builder.append(", creditRating=");
		builder.append(creditRating);
		builder.append("]");
		return builder.toString();
	}

}
