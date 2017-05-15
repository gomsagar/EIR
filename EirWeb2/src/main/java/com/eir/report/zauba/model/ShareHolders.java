package com.eir.report.zauba.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShareHolders", propOrder = {
    "shareHolder"})
public class ShareHolders 
{
    @XmlElement(name = "Shareholder", required = false)
    protected List<ShareHolder> shareHolder;
    
    public List<ShareHolder> getShareholder() {
        if (shareHolder == null) {
        	shareHolder = new ArrayList<ShareHolder>();
        }
        return this.shareHolder;
    }
    
}