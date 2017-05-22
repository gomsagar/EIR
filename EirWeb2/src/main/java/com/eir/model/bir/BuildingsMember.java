package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildingsMember", propOrder = {
    "ownedAssetsMember"
})
public class BuildingsMember 
{
	
    @XmlElement(name = "OwnedAssetsMember")
    protected String ownedAssetsMember;
 

	public String getOwnedAssetsMember() {
		return ownedAssetsMember;
	}

	public void setOwnedAssetsMember(String ownedAssetsMember) {
		this.ownedAssetsMember = ownedAssetsMember;
	}
	
	@Override
	public String toString() {
		
		
		return ownedAssetsMember;
	}

}
