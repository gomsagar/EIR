package com.eir.report.nextgen.service.model.product;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkBusnsrch",namespace="aus.model.uif.shared.uiq1", propOrder = {"busnsrchList"})
public class BulkBusnsrch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @XmlElementWrapper(name="BusnsrchList")
	 @XmlElement(name="Busnsrch")
	private List<Busnsrch> busnsrchList;

	public List<Busnsrch> getBusnsrchList() {
		return busnsrchList;
	}

	public void setBusnsrchList(List<Busnsrch> busnsrchList) {
		this.busnsrchList = busnsrchList;
	}
	
}
