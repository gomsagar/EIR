package com.eir.report.constant;

public class IndustryType {
	
	public String indType(String value)
	{
		if(!value.equals("") && !value.equals(null))
		{
			if(value.equals("37"))
			{
				return "BANK";
			}
			else if(value.equals("43"))
			{
				return "NBFC";
			}
			else if(value.equals("39"))
			{
				return "HOUSING FINANCE COMPANY";
			}
			else if(value.equals("40"))
			{
				return "TELECOM";
			}
			else if(value.equals("41"))
			{
				return "INSURANCE";
			}
			else if(value.equals("42"))
			{
				return "MICROFINANCE INSTITUTION";
			}
			else if(value.equals("38"))
			{
				return "CREDIT RATING AGENCY";
			}
			else if(value.equals("99"))
			{
				return "OTHER";
			}
		}
		return "-";
	}
}
