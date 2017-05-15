package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyStructure", propOrder = {
    "holdingCompany"
})
public class CompanyStructure
{
    @XmlElement(name = "HoldingCompany", required = false)
    protected HoldingCompany holdingCompany;
    @XmlAttribute(name = "DataAsOf", required = false)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataAsOf;

    public HoldingCompany getHoldingCompany() {
		return holdingCompany;
	}
	public void setHoldingCompany(HoldingCompany holdingCompany) {
		this.holdingCompany = holdingCompany;
	}
	public XMLGregorianCalendar getDataAsOf() {
		return dataAsOf;
	}
	public void setDataAsOf(XMLGregorianCalendar dataAsOf) {
		this.dataAsOf = dataAsOf;
	}

}
