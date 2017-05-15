package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiclesMember", propOrder = {
    "ownedAssetsMember"
})

public class VehiclesMember 
{
    @XmlElement(name = "OwnedAssetsMember")
    protected String ownedAssetsMember;
 

	public String getOwnedAssetsMember() {
		return ownedAssetsMember;
	}

	public void setOwnedAssetsMember(String ownedAssetsMember) {
		this.ownedAssetsMember = ownedAssetsMember;
	}

}
