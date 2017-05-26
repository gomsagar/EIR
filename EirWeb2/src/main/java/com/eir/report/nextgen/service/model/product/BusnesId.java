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
@XmlType(name = "businessIdentification",namespace="aus.model.uif.shared.uiq1",propOrder={
		"idNumberType","idNumber","idPlaceOfIssue"
})
public class BusnesId implements Serializable{
	
	@XmlElement(required=true,nillable=true,name="IdNumberType")
	private String idNumberType;
	@XmlElement(required=true,nillable=true,name="IdNumber")
	private String idNumber;
	@XmlElement(name="IdPlaceOfIssue")
	private String idPlaceOfIssue;
	
	public String getIdNumberType() {
		return idNumberType;
	}
	public void setIdNumberType(String idNumberType) {
		this.idNumberType = idNumberType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdPlaceOfIssue() {
		return idPlaceOfIssue;
	}
	public void setIdPlaceOfIssue(String idPlaceOfIssue) {
		this.idPlaceOfIssue = idPlaceOfIssue;
	}
	
	

}
