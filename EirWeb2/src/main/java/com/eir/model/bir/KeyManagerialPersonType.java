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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for KeyManagerialPersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeyManagerialPersonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DinOrPAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Designation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfAppointment" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DateOfCessation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmailID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FatherName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CompaniesAssociatedWith" type="{}CompaniesAssociatedWithType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyManagerialPersonType", propOrder = {
    "name",
    "dinOrPAN",
    "designation",
    "dateOfAppointment",
    "dateOfCessation",
    "address",
    "emailID",
    "fatherName",
    "dateOfBirth",
    "companiesAssociatedWith"
})
public class KeyManagerialPersonType {

    @XmlElement(name = "Name", required = false)
    protected String name;
    @XmlElement(name = "DinOrPAN", required = false)
    protected String dinOrPAN;
    @XmlElement(name = "Designation", required = false)
    protected String designation;
    @XmlElement(name = "DateOfAppointment", required = false)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfAppointment;
    @XmlElement(name = "DateOfCessation", required = false)
    protected String dateOfCessation;
    @XmlElement(name = "Address", required = false)
    protected String address;
    @XmlElement(name = "EmailID", required = false)
    protected String emailID;
    @XmlElement(name = "FatherName", required = false)
    protected String fatherName;
    @XmlElement(name = "DateOfBirth", required = false)
    protected String dateOfBirth;
    @XmlElement(name = "CompaniesAssociatedWith", required = false)
    protected CompaniesAssociatedWithType companiesAssociatedWith;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the dinOrPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDinOrPAN() {
        return dinOrPAN;
    }

    /**
     * Sets the value of the dinOrPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDinOrPAN(String value) {
        this.dinOrPAN = value;
    }

    /**
     * Gets the value of the designation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Gets the value of the dateOfAppointment property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfAppointment() {
        return dateOfAppointment;
    }

    /**
     * Sets the value of the dateOfAppointment property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfAppointment(XMLGregorianCalendar value) {
        this.dateOfAppointment = value;
    }

    /**
     * Gets the value of the dateOfCessation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfCessation() {
        return dateOfCessation;
    }

    /**
     * Sets the value of the dateOfCessation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfCessation(String value) {
        this.dateOfCessation = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the emailID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * Sets the value of the emailID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailID(String value) {
        this.emailID = value;
    }

    /**
     * Gets the value of the fatherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Sets the value of the fatherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherName(String value) {
        this.fatherName = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the companiesAssociatedWith property.
     * 
     * @return
     *     possible object is
     *     {@link CompaniesAssociatedWithType }
     *     
     */
    public CompaniesAssociatedWithType getCompaniesAssociatedWith() {
        return companiesAssociatedWith;
    }

    /**
     * Sets the value of the companiesAssociatedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompaniesAssociatedWithType }
     *     
     */
    public void setCompaniesAssociatedWith(CompaniesAssociatedWithType value) {
        this.companiesAssociatedWith = value;
    }

}
