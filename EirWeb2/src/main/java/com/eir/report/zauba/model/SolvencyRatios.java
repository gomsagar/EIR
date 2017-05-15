package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SolvencyRatios", propOrder = {"currentRatio","quickRatio"})
public class SolvencyRatios
{
    @XmlElement(name = "CurrentRatio", required = false)
    protected String currentRatio;
    @XmlElement(name = "QuickRatio", required = false)
    protected String quickRatio;
	public String getCurrentRatio() {
		return currentRatio;
	}
	public void setCurrentRatio(String currentRatio) {
		this.currentRatio = currentRatio;
	}
	public String getQuickRatio() {
		return quickRatio;
	}
	public void setQuickRatio(String quickRatio) {
		this.quickRatio = quickRatio;
	}

}
