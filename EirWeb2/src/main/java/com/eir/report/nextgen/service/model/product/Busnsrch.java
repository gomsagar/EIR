/**
 * 
 */
package com.eir.report.nextgen.service.model.product;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author a06423a
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busnsrch",namespace="aus.model.uif.shared.uiq1",
propOrder={"busName","applicationRole","busnesId","busnAddr","busPhone","busWbadr"})
public class Busnsrch implements Serializable{
	
	@XmlElement(required=true,nillable=true,name="BusName")
	private String busName;
	@XmlElement(name="ApplicationRole")
	private String applicationRole;
	@XmlElement(name="BUSNESID")
	private List<BusnesId> busnesId;
	@XmlElement(name="BUSNADDR")
	private List<BusnAddr> busnAddr;
	@XmlElement(name="BUSPHONE")
	private BusPhone busPhone;
	@XmlElement(name="BUSWBADR")
	private BusWbadr busWbadr;
	
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getApplicationRole() {
		return applicationRole;
	}
	public void setApplicationRole(String applicationRole) {
		this.applicationRole = applicationRole;
	}
	public List<BusnesId> getBusnesId() {
		return busnesId;
	}
	public void setBusnesId(List<BusnesId> busnesId) {
		this.busnesId = busnesId;
	}
	public List<BusnAddr> getBusnAddr() {
		return busnAddr;
	}
	public void setBusnAddr(List<BusnAddr> busnAddr) {
		this.busnAddr = busnAddr;
	}
	public BusPhone getBusPhone() {
		return busPhone;
	}
	public void setBusPhone(BusPhone busPhone) {
		this.busPhone = busPhone;
	}
	public BusWbadr getBusWbadr() {
		return busWbadr;
	}
	public void setBusWbadr(BusWbadr busWbadr) {
		this.busWbadr = busWbadr;
	}
	
	

}
