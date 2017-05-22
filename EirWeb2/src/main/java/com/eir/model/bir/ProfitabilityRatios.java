package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfitabilityRatios", propOrder = {"pATToTotalIncomeRatio","netProfitMargin","returnOnAssets",
		"returnOnInvestments"})
public class ProfitabilityRatios 
{
    @XmlElement(name = "PATToTotalIncomeRatio", required = false)
    protected String pATToTotalIncomeRatio;
    @XmlElement(name = "NetProfitMargin", required = false)
    protected String netProfitMargin;
    @XmlElement(name = "ReturnOnAssets", required = false)
    protected String returnOnAssets;
    @XmlElement(name = "ReturnOnInvestments", required = false)
    protected String returnOnInvestments;
	public String getpATToTotalIncomeRatio() {
		return pATToTotalIncomeRatio;
	}
	public void setpATToTotalIncomeRatio(String pATToTotalIncomeRatio) {
		this.pATToTotalIncomeRatio = pATToTotalIncomeRatio;
	}
	public String getNetProfitMargin() {
		return netProfitMargin;
	}
	public void setNetProfitMargin(String netProfitMargin) {
		this.netProfitMargin = netProfitMargin;
	}
	public String getReturnOnAssets() {
		return returnOnAssets;
	}
	public void setReturnOnAssets(String returnOnAssets) {
		this.returnOnAssets = returnOnAssets;
	}
	public String getReturnOnInvestments() {
		return returnOnInvestments;
	}
	public void setReturnOnInvestments(String returnOnInvestments) {
		this.returnOnInvestments = returnOnInvestments;
	}

}
