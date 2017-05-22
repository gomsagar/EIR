package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfficeEquipmentsMemberType", propOrder = {
    "ownedAssetsMember"
})
public class OfficeEquipmentsMemberType 
{
    @XmlElement(name = "OwnedAssetsMember")
    protected String ownedAssetsMember;

    /**
     * Gets the value of the ownedAssetsMember property.
     * 
     */
    public String getOwnedAssetsMember() {
        return ownedAssetsMember;
    }

    /**
     * Sets the value of the ownedAssetsMember property.
     * 
     */
    public void setOwnedAssetsMember(String value) {
        this.ownedAssetsMember = value;
    }

}
