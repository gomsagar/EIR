package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LandMember", propOrder = {
    "ownedAssetsMember","assetsHeldUnderLeaseMember"
})
public class LandMember 
{
    @XmlElement(name = "OwnedAssetsMember")
    protected String ownedAssetsMember;
    @XmlElement(name = "AssetsHeldUnderLeaseMember")
    protected String assetsHeldUnderLeaseMember;
 

	public String getAssetsHeldUnderLeaseMember() {
		return assetsHeldUnderLeaseMember;
	}

	public void setAssetsHeldUnderLeaseMember(String assetsHeldUnderLeaseMember) {
		this.assetsHeldUnderLeaseMember = assetsHeldUnderLeaseMember;
	}

	public String getOwnedAssetsMember() {
		return ownedAssetsMember;
	}

	public void setOwnedAssetsMember(String ownedAssetsMember) {
		this.ownedAssetsMember = ownedAssetsMember;
	}

}
