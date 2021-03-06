//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.08 at 06:13:32 PM IST 
//


package com.eir.report.nextgen.service.model.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnqHeadr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnqHeadr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enquiryAmtMonetaryType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enquiryApplicationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enquiryAccountType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="searchType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="purpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enquiryAmount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="clientEnquiryRefNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="frequency" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="durationofAgrement" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnqHeadr", propOrder = {
		"clientEnquiryRefNumber",
		"BureauMemberId",
		"purpose",
	    "product",
	    "searchType",
        "enquiryApplicationType",
        "enquiryAccountType",
	    "enquiryAmtMonetaryType",
        "enquiryAmount",
        "frequency",
       "durationofAgrement"
})
public class EnqHeadr {
	@XmlElement(required = true,name="ClientEnquiryRefNumber")
    protected String clientEnquiryRefNumber;
	@XmlElement(required = true,name="BureauMemberId")
    protected String BureauMemberId;
	@XmlElement(name="Purpose")
	protected String purpose;
	@XmlElement(name="Product")
    protected String product;
    @XmlElement(required = true,name="SearchType")
    protected String searchType;
	@XmlElement(required = true,name="EnquiryApplicationType")
    protected String enquiryApplicationType;
    @XmlElement(required = true,name="EnquiryAccountType")
    protected String enquiryAccountType;
    @XmlElement(name="EnquiryAmtMonetaryType")
    protected String enquiryAmtMonetaryType;
    @XmlElement(required = true,name="EnquiryAmount")
    protected String enquiryAmount;
    @XmlElement(name="Frequency")
    protected String frequency;
    @XmlElement(name="DurationofAgrement")
    protected String durationofAgrement;

    /**
     * Gets the value of the enquiryAmtMonetaryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnquiryAmtMonetaryType() {
        return enquiryAmtMonetaryType;
    }

    /**
     * Sets the value of the enquiryAmtMonetaryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnquiryAmtMonetaryType(String value) {
        this.enquiryAmtMonetaryType = value;
    }

    /**
     * Gets the value of the enquiryApplicationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnquiryApplicationType() {
        return enquiryApplicationType;
    }

    /**
     * Sets the value of the enquiryApplicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnquiryApplicationType(String value) {
        this.enquiryApplicationType = value;
    }

    /**
     * Gets the value of the enquiryAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnquiryAccountType() {
        return enquiryAccountType;
    }

    /**
     * Sets the value of the enquiryAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnquiryAccountType(String value) {
        this.enquiryAccountType = value;
    }

    /**
     * Gets the value of the searchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchType(String value) {
        this.searchType = value;
    }

    /**
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurpose(String value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the enquiryAmount property.
     * 
     */
    public String getEnquiryAmount() {
        return enquiryAmount;
    }

    /**
     * Sets the value of the enquiryAmount property.
     * 
     */
    public void setEnquiryAmount(String value) {
        this.enquiryAmount = value;
    }
    

    /**
     * Gets the value of the clientEnquiryRefNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientEnquiryRefNumber() {
        return clientEnquiryRefNumber;
    }

    /**
     * Sets the value of the clientEnquiryRefNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientEnquiryRefNumber(String value) {
        this.clientEnquiryRefNumber = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     */
    public void setFrequency(String value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the durationofAgrement property.
     * 
     */
    public String getDurationofAgrement() {
        return durationofAgrement;
    }

    /**
     * Sets the value of the durationofAgrement property.
     * 
     */
    public void setDurationofAgrement(String value) {
        this.durationofAgrement = value;
    }

	public String getBureauMemberId() {
		return BureauMemberId;
	}

	public void setBureauMemberId(String bureauMemberId) {
		BureauMemberId = bureauMemberId;
	}

}
