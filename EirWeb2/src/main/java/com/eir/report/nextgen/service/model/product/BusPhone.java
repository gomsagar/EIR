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
@XmlType(name = "businessPhone",namespace="aus.model.uif.shared.uiq1",
propOrder={"phoneNumber","phonseType"})
public class BusPhone implements Serializable{

	@XmlElement(name="PhoneNumber")
	private String phoneNumber ;

	@XmlElement(name="PhonseType")
	private String phonseType;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhonseType() {
		return phonseType;
	}
	public void setPhonseType(String phonseType) {
		this.phonseType = phonseType;
	}
	
	
}
