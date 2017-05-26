package com.eir.report.nextgen.service.model.product;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

/**
 * @author a06423a
 *
 */
@XmlType(name = "iqsAusUif", namespace="uif.shared")
public class Iqs {
	
	List<Sch> schList;
	public List<Sch> getSchList() {
		return schList;
	}
	public void setSchList(List<Sch> schList) {
		this.schList = schList;
	}

}
