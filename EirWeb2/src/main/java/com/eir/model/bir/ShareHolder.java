package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShareHolder", propOrder = {"typeOfShares","shareHolderName","shareHolderAddreess",
		"noOfShares","nominalValue","totalValue"})
public class ShareHolder
{
    @XmlElement(name = "TypeOfShares", required = false)
    protected String typeOfShares;
    @XmlElement(name = "ShareholderName", required = false)
    protected String shareHolderName;
    @XmlElement(name = "ShareholderAddreess", required = false)
    protected String shareHolderAddreess;
    @XmlElement(name = "NoOfShares", required = false)
    protected String noOfShares;
    @XmlElement(name = "NominalValue", required = false)
    protected String nominalValue;
    @XmlElement(name = "TotalValue", required = false)
    protected String totalValue;
    
	public String getTypeOfShares() {
		return typeOfShares;
	}
	public void setTypeOfShares(String typeOfShares) {
		this.typeOfShares = typeOfShares;
	}
	public String getShareHolderName() {
		return shareHolderName;
	}
	public void setShareHolderName(String shareHolderName) {
		this.shareHolderName = shareHolderName;
	}
	public String getShareHolderAddreess() {
		return shareHolderAddreess;
	}
	public void setShareHolderAddreess(String shareHolderAddreess) {
		this.shareHolderAddreess = shareHolderAddreess;
	}
	public String getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(String noOfShares) {
		this.noOfShares = noOfShares;
	}
	public String getNominalValue() {
		return nominalValue;
	}
	public void setNominalValue(String nominalValue) {
		this.nominalValue = nominalValue;
	}
	public String getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
	
}