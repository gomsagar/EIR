//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.21 at 07:58:31 PM IST 
//


package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StateGovernmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StateGovernmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NoOfEquityShares" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PercentageOfEquityShares" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StateGovernmentType", propOrder = {
    "noOfEquityShares",
    "percentageOfEquityShares"
})
public class StateGovernmentType {

    @XmlElement(name = "NoOfEquityShares")
    protected float noOfEquityShares;
    @XmlElement(name = "PercentageOfEquityShares")
    protected float percentageOfEquityShares;

    /**
     * Gets the value of the noOfEquityShares property.
     * 
     */
    public float getNoOfEquityShares() {
        return noOfEquityShares;
    }

    /**
     * Sets the value of the noOfEquityShares property.
     * 
     */
    public void setNoOfEquityShares(float value) {
        this.noOfEquityShares = value;
    }

    /**
     * Gets the value of the percentageOfEquityShares property.
     * 
     */
    public float getPercentageOfEquityShares() {
        return percentageOfEquityShares;
    }

    /**
     * Sets the value of the percentageOfEquityShares property.
     * 
     */
    public void setPercentageOfEquityShares(float value) {
        this.percentageOfEquityShares = value;
    }

}
