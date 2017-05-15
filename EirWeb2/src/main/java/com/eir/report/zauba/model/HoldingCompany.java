package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HoldingCompany", propOrder = {
    "name",
    "cin",
    "percentageOfSharesHeld"
})
public class HoldingCompany 
{
    @XmlElement(name = "Name", required = false)
    protected String name;
    @XmlElement(name = "CIN", required = false)
    protected String cin;
	@XmlElement(name = "PercentageOfSharesHeld", required = false)
    protected String percentageOfSharesHeld;    
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPercentageOfSharesHeld() {
		return percentageOfSharesHeld;
	}
	public void setPercentageOfSharesHeld(String percentageOfSharesHeld) {
		this.percentageOfSharesHeld = percentageOfSharesHeld;
	}

}
