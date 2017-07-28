package com.eir.report.constant;

import org.apache.commons.lang.StringUtils;

public class AccountType {

	public String accountType (String value)
	{
		if(!value.equals("") && !value.equals(null))
		{
			value = StringUtils.deleteWhitespace(value);
			switch(value)
			{
				case "5":
					return "Credit Card";
				case "47":
					return "Instalment Loan, Automobile";
				case "58":
					return "Instalment Loan, Mortgage";
				case "121":
					return "Overdraft";
				case "123":
					return "Loan, Personal Cash";
				case "130":
					return "Loan, Student";
				case "167":
					return "Microfinance, Business";
				case "168":
					return "Microfinance, Housing";
				case "169":
					return "Microfinance, Personal";
				case "170":
					return "Microfinance, Other";
				case "172":
					return "Commercial Vehicle Loan";
				case "173":
					return "Instalment Loan, Two-Wheeler";
				case "175":
					return "Business Loan Against Bank Deposits";
				case "176":
					return "Business Loan, General";
				case "177":
					return "Business Loan, Priority Sector - Small Business";
				case "178":
					return "Business Loan, Priority Sector - Agriculture";
				case "179":
					return "Business Loan, Priority Sector - Others";
				case "181":
					return "Credit Facility, Non-Funded";
				case "184":
					return "Loan Against Bank Deposits";
				case "185":
					return "Loan Against Shares/Securities";
				case "187":
					return "Loan to Professional";
				case "189":
					return "Loan, Consumer";
				case "191":
					return "Loan, Gold";
				case "195":
					return "Loan, Property";
				case "196":
					return "Loan, Staff";
				case "197":
					return "Non-Funded Credit Facility, General";
				case "198":
					return "Non-Funded Credit Facility, Priority Sector - Small Business";
				case "199":
					return "Non-Funded Credit Facility, Priority Sector - Agriculture";
				case "200":
					return "Non-Funded Credit Facility, Priority Sector - Others";
				case "214":
					return "Credit Card, Fleet";
				case "215":
					return "Service, Telco – Broadband";
				case "216":
					return "Service, Telco – Landline";
				case "217":
					return "Service, Telco – Wireless";
				case "219":
					return "Leasing, Other";
				case "220":
					return "Secured Credit Card";
				case "221":
					return "Used Car Loan";
				case "222":
					return "Construction Equipment Loan";
				case "223":
					return "Tractor Loan";
				case "999":
					return "Other";
				
			}
			
		}
		return " ";
	}
}
