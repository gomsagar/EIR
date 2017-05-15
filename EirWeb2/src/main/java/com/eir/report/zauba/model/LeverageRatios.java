package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LeverageRatios", propOrder = {"debtRatio","debtEquityRatio","currentLiabilitiesToNetWorth",
		"fixedAssetsToNetWorth","interestCoverageRatio"})

public class LeverageRatios 
{
    @XmlElement(name = "DebtRatio", required = false)
    protected String debtRatio;
    @XmlElement(name = "DebtEquityRatio", required = false)
    protected String debtEquityRatio;
    @XmlElement(name = "CurrentLiabilitiesToNetWorth", required = false)
    protected String currentLiabilitiesToNetWorth;
    @XmlElement(name = "FixedAssetsToNetWorth", required = false)
    protected String fixedAssetsToNetWorth;
	@XmlElement(name = "InterestCoverageRatio", required = false)
    protected String interestCoverageRatio;

    public String getDebtRatio() {
		return debtRatio;
	}
	public void setDebtRatio(String debtRatio) {
		this.debtRatio = debtRatio;
	}
	public String getDebtEquityRatio() {
		return debtEquityRatio;
	}
	public void setDebtEquityRatio(String debtEquityRatio) {
		this.debtEquityRatio = debtEquityRatio;
	}
	public String getCurrentLiabilitiesToNetWorth() {
		return currentLiabilitiesToNetWorth;
	}
	public void setCurrentLiabilitiesToNetWorth(String currentLiabilitiesToNetWorth) {
		this.currentLiabilitiesToNetWorth = currentLiabilitiesToNetWorth;
	}
	public String getFixedAssetsToNetWorth() {
		return fixedAssetsToNetWorth;
	}
	public void setFixedAssetsToNetWorth(String fixedAssetsToNetWorth) {
		this.fixedAssetsToNetWorth = fixedAssetsToNetWorth;
	}
	public String getInterestCoverageRatio() {
		return interestCoverageRatio;
	}
	public void setInterestCoverageRatio(String interestCoverageRatio) {
		this.interestCoverageRatio = interestCoverageRatio;
	}

}
