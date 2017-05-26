//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.14 at 07:31:34 AM CST 
//


package com.eir.report.nextgen.service.model.consumer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="STARTENQ" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ENQHEADR" type="{http://experian.com/nextgen/schemas}EnqHeadr"/>
 *         &lt;element name="USERPREF" type="{http://experian.com/nextgen/schemas}UserPref"/>
 *         &lt;element name="ADDLPROD" type="{http://experian.com/nextgen/schemas}AddlProd" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PRSNSRCH" type="{http://experian.com/nextgen/schemas}PrsnSrch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PERSALIAS" type="{http://experian.com/nextgen/schemas}PersAlias"/>
 *         &lt;element name="PERSONID" type="{http://experian.com/nextgen/schemas}PersonId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PERSONBNK" type="{http://experian.com/nextgen/schemas}PersonBnk" minOccurs="0"/>
 *         &lt;element name="PERSADDR" type="{http://experian.com/nextgen/schemas}PersAddr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PERSPHONE" type="{http://experian.com/nextgen/schemas}PersPhone" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PERSEMAIL" type="{http://experian.com/nextgen/schemas}PersEmail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EMPLOYER" type="{http://experian.com/nextgen/schemas}Employer"/>
 *         &lt;element name="PERSDETAIL" type="{http://experian.com/nextgen/schemas}PersDetail"/>
 *         &lt;element name="ADMINSRCH" type="{http://experian.com/nextgen/schemas}AdminSrch"/>
 *         &lt;element name="PINID" type="{http://experian.com/nextgen/schemas}PersEmail" maxOccurs="3" minOccurs="0"/>
 *         &lt;element name="ENDOFENQ" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "startenq",
    "enqheader",
    "userpref",
    "addlprod",
    "prsnsrch",
    "persalias",
    "personid",
    "personbnk",
    "persaddr",
    "persphone",
    "persemail",
    "employer",
    "persdetail",
   /* "adminsrch",*/
    "pinid",
    "endofenq"
})
@XmlRootElement(name = "getConsumerProductRequest")
public class GetConsumerProductRequest {

    @XmlElement(name = "STARTENQ", required = true)
    protected String startenq;
    @XmlElement(name = "ENQHEADER", required = true)
    protected EnqHeader enqheader;
    @XmlElement(name = "USERPREF", required = true)
    protected UserPref userpref;
    @XmlElement(name = "ADDLPROD")
    protected List<AddlProd> addlprod;
    @XmlElement(name = "PRSNSRCH")
    protected List<PrsnSrch> prsnsrch;
    @XmlElement(name = "PERSALIAS", required = true)
    protected PersAlias persalias;
    @XmlElement(name = "PERSONID")
    protected List<PersonId> personid;
    @XmlElement(name = "PERSONBNK")
    protected PersonBnk personbnk;
    @XmlElement(name = "PERSADDR")
    protected List<PersAddr> persaddr;
    @XmlElement(name = "PERSPHONE")
    protected List<PersPhone> persphone;
    @XmlElement(name = "PERSEMAIL")
    protected List<PersEmail> persemail;
    @XmlElement(name = "EMPLOYER", required = true)
    protected Employer employer;
    @XmlElement(name = "PERSDETAIL", required = true)
    protected PersDetail persdetail;
   /* @XmlElement(name = "ADMINSRCH", required = true)
    protected AdminSrch adminsrch;*/
    @XmlElement(name = "PINID")
    protected List<PinId> pinid;
    @XmlElement(name = "ENDOFENQ", required = true)
    protected String endofenq;

    /**
     * Gets the value of the startenq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTENQ() {
        return startenq;
    }

    /**
     * Sets the value of the startenq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTENQ(String value) {
        this.startenq = value;
    }

    
    
    
   
	public void setADDLPROD(List<AddlProd> addlprod) {
		this.addlprod = addlprod;
	}

	
	public void setPRSNSRCH(List<PrsnSrch> prsnsrch) {
		this.prsnsrch = prsnsrch;
	}

	
	public void setPERSADDR(List<PersAddr> persaddr) {
		this.persaddr = persaddr;
	}

		public void setPERSEMAIL(List<PersEmail> persemail) {
		this.persemail = persemail;
	}

	public List<PinId> getPINID() {
		return pinid;
	}

	public void setPINID(List<PinId> pinid) {
		this.pinid = pinid;
	}
	
	
	public void setPERSPHONE(List<PersPhone> persphone) {
		this.persphone = persphone;
	}

	public void setPERSONID(List<PersonId> personid) {
		this.personid = personid;
	}

	/**
     * Gets the value of the enqheadr property.
     * 
     * @return
     *     possible object is
     *     {@link EnqHeadr }
     *     
     */
    public EnqHeader getENQHEADER() {
        return enqheader;
    }

    /**
     * Sets the value of the enqheadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnqHeadr }
     *     
     */
    public void setENQHEADER(EnqHeader value) {
        this.enqheader = value;
    }

    /**
     * Gets the value of the userpref property.
     * 
     * @return
     *     possible object is
     *     {@link UserPref }
     *     
     */
    public UserPref getUSERPREF() {
        return userpref;
    }

    /**
     * Sets the value of the userpref property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserPref }
     *     
     */
    public void setUSERPREF(UserPref value) {
        this.userpref = value;
    }

    /**
     * Gets the value of the addlprod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addlprod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getADDLPROD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddlProd }
     * 
     * 
     */
    public List<AddlProd> getADDLPROD() {
        if (addlprod == null) {
            addlprod = new ArrayList<AddlProd>();
        }
        return this.addlprod;
    }

    /**
     * Gets the value of the prsnsrch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prsnsrch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRSNSRCH().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrsnSrch }
     * 
     * 
     */
    public List<PrsnSrch> getPRSNSRCH() {
        if (prsnsrch == null) {
            prsnsrch = new ArrayList<PrsnSrch>();
        }
        return this.prsnsrch;
    }

    /**
     * Gets the value of the persalias property.
     * 
     * @return
     *     possible object is
     *     {@link PersAlias }
     *     
     */
    public PersAlias getPERSALIAS() {
        return persalias;
    }
    
    
    

    /**
     * Sets the value of the persalias property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersAlias }
     *     
     */
    public void setPERSALIAS(PersAlias value) {
        this.persalias = value;
    }

    /**
     * Gets the value of the personid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPERSONID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonId }
     * 
     * 
     */
    public List<PersonId> getPERSONID() {
        if (personid == null) {
            personid = new ArrayList<PersonId>();
        }
        return this.personid;
    }

    /**
     * Gets the value of the personbnk property.
     * 
     * @return
     *     possible object is
     *     {@link PersonBnk }
     *     
     */
    public PersonBnk getPERSONBNK() {
        return personbnk;
    }

    /**
     * Sets the value of the personbnk property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonBnk }
     *     
     */
    public void setPERSONBNK(PersonBnk value) {
        this.personbnk = value;
    }

    /**
     * Gets the value of the persaddr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the persaddr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPERSADDR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersAddr }
     * 
     * 
     */
    public List<PersAddr> getPERSADDR() {
        if (persaddr == null) {
            persaddr = new ArrayList<PersAddr>();
        }
        return this.persaddr;
    }

    /**
     * Gets the value of the persphone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the persphone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPERSPHONE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersPhone }
     * 
     * 
     */
    public List<PersPhone> getPERSPHONE() {
        if (persphone == null) {
            persphone = new ArrayList<PersPhone>();
        }
        return this.persphone;
    }

    /**
     * Gets the value of the persemail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the persemail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPERSEMAIL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersEmail }
     * 
     * 
     */
    public List<PersEmail> getPERSEMAIL() {
        if (persemail == null) {
            persemail = new ArrayList<PersEmail>();
        }
        return this.persemail;
    }

    /**
     * Gets the value of the employer property.
     * 
     * @return
     *     possible object is
     *     {@link Employer }
     *     
     */
    public Employer getEMPLOYER() {
        return employer;
    }

    /**
     * Sets the value of the employer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employer }
     *     
     */
    public void setEMPLOYER(Employer value) {
        this.employer = value;
    }

    /**
     * Gets the value of the persdetail property.
     * 
     * @return
     *     possible object is
     *     {@link PersDetail }
     *     
     */
    public PersDetail getPERSDETAIL() {
        return persdetail;
    }

    /**
     * Sets the value of the persdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersDetail }
     *     
     */
    public void setPERSDETAIL(PersDetail value) {
        this.persdetail = value;
    }

    /**
     * Gets the value of the adminsrch property.
     * 
     * @return
     *     possible object is
     *     {@link AdminSrch }
     *     
     */
   /* public AdminSrch getADMINSRCH() {
        return adminsrch;
    }

    *//**
     * Sets the value of the adminsrch property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminSrch }
     *     
     *//*
    public void setADMINSRCH(AdminSrch value) {
        this.adminsrch = value;*/
    //}

    /**
     * Gets the value of the pinid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pinid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPINID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersEmail }
     * 
     * 
     */
   
    /**
     * Gets the value of the endofenq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDOFENQ() {
        return endofenq;
    }

    /**
     * Sets the value of the endofenq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDOFENQ(String value) {
        this.endofenq = value;
    }

}
