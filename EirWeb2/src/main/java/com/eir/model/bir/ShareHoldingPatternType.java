//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.21 at 07:58:31 PM IST 
//


package com.eir.model.bir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShareHoldingPatternType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShareHoldingPatternType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Promoters" type="{}PromotersType"/>
 *         &lt;element name="NonPromoters" type="{}NonPromotersType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShareHoldingPatternType", propOrder = {
    "promoters",
    "nonPromoters"
})
public class ShareHoldingPatternType {

    @XmlElement(name = "Promoters", required = true)
    protected PromotersType promoters;
    @XmlElement(name = "NonPromoters", required = true)
    protected NonPromotersType nonPromoters;

    /**
     * Gets the value of the promoters property.
     * 
     * @return
     *     possible object is
     *     {@link PromotersType }
     *     
     */
    public PromotersType getPromoters() {
        return promoters;
    }

    /**
     * Sets the value of the promoters property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromotersType }
     *     
     */
    public void setPromoters(PromotersType value) {
        this.promoters = value;
    }

    /**
     * Gets the value of the nonPromoters property.
     * 
     * @return
     *     possible object is
     *     {@link NonPromotersType }
     *     
     */
    public NonPromotersType getNonPromoters() {
        return nonPromoters;
    }

    /**
     * Sets the value of the nonPromoters property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonPromotersType }
     *     
     */
    public void setNonPromoters(NonPromotersType value) {
        this.nonPromoters = value;
    }

}
