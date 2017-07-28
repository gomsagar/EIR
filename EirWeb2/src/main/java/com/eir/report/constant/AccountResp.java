package com.eir.report.constant;

import org.apache.commons.lang.StringUtils;

public class AccountResp {
	public String acctResp (String value)
	{
		if(null != value && !value.equals("") )
		{
			value = StringUtils.deleteWhitespace(value);
			switch(value)
			{
				case "1":
					return "Individual";
				case "2":
					return "Joint";
				case "19":
					return "Authorized User";
				case "4":
					return "Guarantor";
				case "20":
					return "Deceased";
				
			}
			
		}
		return "";
	}
}



