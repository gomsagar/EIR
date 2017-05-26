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
@XmlType(name = "personWebAddress",namespace="aus.model.uif.shared.uiq1",
propOrder={"WebAddress","WebAddressType"})
public class PerWbadr implements Serializable{

	private String webAddress;
	private String webAddressType;
	
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	public String getWebAddressType() {
		return webAddressType;
	}
	public void setWebAddressType(String webAddressType) {
		this.webAddressType = webAddressType;
	}
	
	
}
