package com.eir.report.constant;

import org.apache.commons.lang.StringUtils;

public class PaymentStatus {

	public String paymentStat (String value)
	{
		if(null != value && !value.equals("") )
		{
			value = StringUtils.deleteWhitespace(value);
			switch(value)
			{
				case "1":
					return "30-59 Days Overdue";
				case "2":
					return "60-89 Days Overdue";
				case "3":
					return "90-119 days Overdue";
				case "4":
					return "120-149 Days Overdue";
				case "5":
					return "150- 179 days Overdue";
				case "6":
					return "180 or more days Overdue";
				case "20":
					return "Settled";
				case "28":
					return "Restructured Loan - Govt. Mandated";
				case "32":
					return "Restructured Loan";
				case "34":
					return "Written-off";
				case "43":
					return "Wilful Default";
				case "44":
					return "Microfinance, Business";
				case "45":
					return "Standard";
				case "46":
					return "Substandard";
				case "47":
					return "Doubtful";
				case "48":
					return "Loss";
				case "49":
					return "Special Mention Account";
				case "50":
					return "Post (WO) Settled";
				case "51":
					return "Account Sold";
				case "52":
					return "Written Off and Account Sold";
				case "53":
					return "Account Purchased";
				case "54":
					return "Account Purchased and Written Off";
				case "55":
					return "Account Purchased and Settled";
				case "56":
					return "Account Purchased and Restructured";
				case "59":
					return "0 days overdue";
				case "60":
					return "1 - 29 Days Overdue";
				case "61":
					return "Suit Filed, Account Purchased";
				case "62":
					return "Suit Filed, Account Purchased and Restructured";
				case "63":
					return "Suit Filed, Account Purchased and Settled";
				case "64":
					return "Suit Filed, Account Purchased and Written Off";
				case "65":
					return "Suit Filed, Account Sold";
				case "66":
					return "Suit Filed, Post (WO) Settled";
				case "67":
					return "Suit Filed, Restructured Loan";
				case "68":
					return "Suit Filed, Restructured Loan - Govt. Mandated";
				case "69":
					return "Suit Filed, Settled";
				case "70":
					return "Suit Filed, Wilful Default";
				case "71":
					return "Suit Filed, Wilful Default, Account Purchased";
				case "72":
					return "Suit Filed, Wilful Default, Account Purchased and Restructured";
				case "73":
					return "Suit Filed, Wilful Default, Account Purchased and Settled";
				case "74":
					return "Suit Filed, Wilful Default, Account Purchased and Written Off";
				case "75":
					return "Suit Filed, Wilful Default, Account Sold";
				case "76":
					return "Suit Filed, Wilful Default, Post (WO) Settled";
				case "77":
					return "Suit Filed, Wilful Default, Restructured Loan";
				case "78":
					return "Suit Filed, Wilful Default, Restructured Loan - Govt. Mandated";
				case "79":
					return "Suit Filed, Wilful Default, Settled";
				case "80":
					return "Suit Filed, Wilful Default, Written Off and Account Sold";
				case "81":
					return "Suit Filed, Wilful Default, Written-off";
				case "82":
					return "Suit Filed, Written Off and Account Sold";
				case "83":
					return "Suit Filed, Written-off";
				case "84":
					return "Wilful Default, Account Purchased";
				case "85":
					return "Wilful Default, Account Purchased and Restructured";
				case "86":
					return "Wilful Default, Account Purchased and Settled";
				case "87":
					return "Wilful Default, Account Purchased and Written Off";
				case "88":
					return "Wilful Default, Account Sold";
				case "89":
					return "Wilful Default, Post (WO) Settled";
				case "90":
					return "Wilful Default, Restructured Loan";
				case "91":
					return "Wilful Default, Restructured Loan - Govt. Mandated";
				case "92":
					return "Wilful Default, Settled";
				case "93":
					return "Wilful Default, Written Off and Account Sold";
				case "94":
					return "Wilful Default, Written-off";
				case "95":
					return "Closed, 0 days overdue";
				case "96":
					return "Closed, 1 - 29 Days Overdue";
				case "97":
					return "Closed, 30-59 Days Overdue";
				case "98":
					return "Closed, 60-89 Days Overdue";
				case "99":
					return "Closed, 90-119 days Overdue";
				case "100":
					return "Closed, 120-149 Days Overdue";
				case "101":
					return "Closed, 150- 179 days Overdue";
				case "102":
					return "Closed, 180 or more days Overdue";
				case "103":
					return "Closed, Standard";
				case "104":
					return "Closed, Substandard";
				case "105":
					return "Closed, Doubtful";
				case "106":
					return "Closed, Loss";
				case "107":
					return "Closed, Special Mention Account";
				case "108":
					return "BLANK";
				
			}
			
		}
		return "";
	}
}
