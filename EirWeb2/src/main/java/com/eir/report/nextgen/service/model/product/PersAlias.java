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
 * @author a08226a
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persalias",namespace="aus.model.uif.shared.uiq1",
propOrder={"aliasName","aliasType"})
public class PersAlias implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4473671983202003288L;
	@XmlElement(required=true)
	private String aliasName ;
	private String aliasType ;
	
	
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getAliasType() {
		return aliasType;
	}
	public void setAliasType(String aliasType) {
		this.aliasType = aliasType;
	}
	
	

}
