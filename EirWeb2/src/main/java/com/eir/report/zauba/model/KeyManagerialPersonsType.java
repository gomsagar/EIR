//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.21 at 07:58:31 PM IST 
//


package com.eir.report.zauba.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeyManagerialPersonsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeyManagerialPersonsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KeyManagerialPerson" type="{}KeyManagerialPersonType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyManagerialPersonsType", propOrder = {
    "keyManagerialPerson"
})
public class KeyManagerialPersonsType {

    @XmlElement(name = "KeyManagerialPerson")
    protected List<KeyManagerialPersonType> keyManagerialPerson;

    /**
     * Gets the value of the keyManagerialPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyManagerialPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyManagerialPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyManagerialPersonType }
     * 
     * 
     */
    public List<KeyManagerialPersonType> getKeyManagerialPerson() {
        if (keyManagerialPerson == null) {
            keyManagerialPerson = new ArrayList<KeyManagerialPersonType>();
        }
        return this.keyManagerialPerson;
    }

}
