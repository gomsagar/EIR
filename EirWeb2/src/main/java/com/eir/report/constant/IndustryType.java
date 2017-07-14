package com.eir.report.constant;

public class IndustryType {
	
	public String indType(String value)
	{
		if(!value.equals("") && !value.equals(null))
		{
			switch(value)
			{
				case "37":
					return "BANK";
				case "43":
					return "NBFC";
				case "39":
					return "HOUSING FINANCE COMPANY";
				case "40":
					return "TELECOM";
				case "41":
					return "INSURANCE";
				case "42":
					return "MICROFINANCE INSTITUTION";
				case "38":
					return "CREDIT RATING AGENCY";
				case "99":
					return "OTHER";
			}
			
		}
		return "-";
	}
}
