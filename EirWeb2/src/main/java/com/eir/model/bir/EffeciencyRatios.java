package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EffeciencyRatios", propOrder = {"averageCollectionDays","accountRecievableTurnover","averagePaymentDays",
		"inventoryTurnoverRatio","assetTurnoverRatio"})

public class EffeciencyRatios 
{
    @XmlElement(name = "AverageCollectionDays", required = false)
    protected String averageCollectionDays;
    @XmlElement(name = "AccountReceivableTurnover", required = false)
    protected String accountRecievableTurnover;
    @XmlElement(name = "AveragePaymentDays", required = false)
    protected String averagePaymentDays;
    @XmlElement(name = "InventoryTurnoverRatio", required = false)
    protected String inventoryTurnoverRatio;
    @XmlElement(name = "AssetTurnoverRatio", required = false)
    protected String assetTurnoverRatio;
	public String getAverageCollectionDays() {
		return averageCollectionDays;
	}
	public void setAverageCollectionDays(String averageCollectionDays) {
		this.averageCollectionDays = averageCollectionDays;
	}
	public String getAccountRecievableTurnover() {
		return accountRecievableTurnover;
	}
	public void setAccountRecievableTurnover(String accountRecievableTurnover) {
		this.accountRecievableTurnover = accountRecievableTurnover;
	}
	public String getAveragePaymentDays() {
		return averagePaymentDays;
	}
	public void setAveragePaymentDays(String averagePaymentDays) {
		this.averagePaymentDays = averagePaymentDays;
	}
	public String getInventoryTurnoverRatio() {
		return inventoryTurnoverRatio;
	}
	public void setInventoryTurnoverRatio(String inventoryTurnoverRatio) {
		this.inventoryTurnoverRatio = inventoryTurnoverRatio;
	}
	public String getAssetTurnoverRatio() {
		return assetTurnoverRatio;
	}
	public void setAssetTurnoverRatio(String assetTurnoverRatio) {
		this.assetTurnoverRatio = assetTurnoverRatio;
	}

}
