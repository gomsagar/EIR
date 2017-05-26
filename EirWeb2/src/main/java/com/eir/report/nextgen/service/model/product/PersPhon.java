/**
 * 
 */
package com.eir.report.nextgen.service.model.product;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author a06423a
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personPhone",namespace="aus.model.uif.shared.uiq1",
propOrder={"phoneNumber","phoneType"})
public class PersPhon implements Serializable{
	
	private String phoneNumber;
	private String phoneType;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	

}
