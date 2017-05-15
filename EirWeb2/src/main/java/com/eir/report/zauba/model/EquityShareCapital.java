package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquityShareCapital", propOrder = {
    "authorisedCapital",
    "issuedCapital",
    "subscribedCapital",
    "paidUpCapital"
})
public class EquityShareCapital 
{
    @XmlElement(name = "AuthorisedCapital", required = false)
    protected AuthorisedCapital authorisedCapital;
    @XmlElement(name = "IssuedCapital", required = false)
    protected IssuedCapital issuedCapital;
    @XmlElement(name = "SubscribedCapital", required = false)
    protected SubscribedCapital subscribedCapital;
    @XmlElement(name = "PaidUpCapital", required = false)
    protected PaidUpCapital paidUpCapital;
	public AuthorisedCapital getAuthorisedCapital() {
		return authorisedCapital;
	}
	public void setAuthorisedCapital(AuthorisedCapital authorisedCapital) {
		this.authorisedCapital = authorisedCapital;
	}
	public IssuedCapital getIssuedCapital() {
		return issuedCapital;
	}
	public void setIssuedCapital(IssuedCapital issuedCapital) {
		this.issuedCapital = issuedCapital;
	}
	public SubscribedCapital getSubscribedCapital() {
		return subscribedCapital;
	}
	public void setSubscribedCapital(SubscribedCapital subscribedCapital) {
		this.subscribedCapital = subscribedCapital;
	}
	public PaidUpCapital getPaidUpCapital() {
		return paidUpCapital;
	}
	public void setPaidUpCapital(PaidUpCapital paidUpCapital) {
		this.paidUpCapital = paidUpCapital;
	}
}
