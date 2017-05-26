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
@XmlType(name = "businessWebAddress",namespace="aus.model.uif.shared.uiq1",
propOrder={"webAddress","webAddressType"})
public class BusWbadr implements Serializable{

	@XmlElement(name="WebAddress")
	private String webAddress;
	@XmlElement(name="WebAddressType")
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
