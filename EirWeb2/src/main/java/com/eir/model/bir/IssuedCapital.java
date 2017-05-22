package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IssuedCapital", propOrder = {
    "numberOfShares",
    "nominalValuePerShare",
    "totalAmountOfShares"
})
public class IssuedCapital 
{
    @XmlElement(name = "NumberOfShares", required = false)
    protected String numberOfShares;
    @XmlElement(name = "NominalValuePerShare", required = false)
    protected String nominalValuePerShare;
    @XmlElement(name = "TotalAmountOfShares", required = false)
    protected String totalAmountOfShares;
	public String getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(String numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public String getNominalValuePerShare() {
		return nominalValuePerShare;
	}
	public void setNominalValuePerShare(String nominalValuePerShare) {
		this.nominalValuePerShare = nominalValuePerShare;
	}
	public String getTotalAmountOfShares() {
		return totalAmountOfShares;
	}
	public void setTotalAmountOfShares(String totalAmountOfShares) {
		this.totalAmountOfShares = totalAmountOfShares;
	}

}
