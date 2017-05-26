/**
 * 
 */
package com.eir.report.nextgen.service.model.product;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author a06423a
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businessAddress",namespace="aus.model.uif.shared.uiq1",propOrder={
		"addrType","addrCurPrevInd","addrOwnershipInd","propertyName","houseNumber","streetName"
		,"streetSuffix","localityName","regionCode","postalCode","countryCode","freeFormAddress"
})
public class BusnAddr implements Serializable{

	@XmlElement(name="AddrType")
	private String addrType ;
	@XmlElement(name="AddrCurPrevInd")
	private String addrCurPrevInd;
	@XmlElement(name="AddrOwnershipInd")
	private String addrOwnershipInd;
	@XmlElement(name="PropertyName")
	private String propertyName;
	@XmlElement(required=true,name="HouseNumber")
	private String houseNumber;
	@XmlElement(name="StreetName")
	private String streetName;
	@XmlElement(name="StreetSuffix")
	private String streetSuffix;
	@XmlElement(name="LocalityName")
	private String localityName;
	@XmlElement(name="RegionCode")
	private String regionCode;
	@XmlElement(required=true,name="PostalCode")
	private String postalCode;
	@XmlElement(name="CountryCode")
	private String countryCode;
	@XmlElement(name="FreeFormAddress")
	private String freeFormAddress;
	
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	public String getAddrCurPrevInd() {
		return addrCurPrevInd;
	}
	public void setAddrCurPrevInd(String addrCurPrevInd) {
		this.addrCurPrevInd = addrCurPrevInd;
	}
	public String getAddrOwnershipInd() {
		return addrOwnershipInd;
	}
	public void setAddrOwnershipInd(String addrOwnershipInd) {
		this.addrOwnershipInd = addrOwnershipInd;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetSuffix() {
		return streetSuffix;
	}
	public void setStreetSuffix(String streetSuffix) {
		this.streetSuffix = streetSuffix;
	}
	public String getLocalityName() {
		return localityName;
	}
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getFreeFormAddress() {
		return freeFormAddress;
	}
	public void setFreeFormAddress(String freeFormAddress) {
		this.freeFormAddress = freeFormAddress;
	}
}
