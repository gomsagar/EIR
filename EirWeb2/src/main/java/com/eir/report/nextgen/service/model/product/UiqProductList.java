package com.eir.report.nextgen.service.model.product;
import javax.xml.bind.annotation.XmlRootElement;


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
*         &lt;element name="BUSNSRCH" type="{http://experian.com/nextgen/schemas}BusSrch" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="BUSNESACCT" type="{http://experian.com/nextgen/schemas}BusnesAcct" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="BUSNADDR" type="{http://experian.com/nextgen/schemas}BusAddr" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="BUSNPHONE" type="{http://experian.com/nextgen/schemas}BusnPhone" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="ADMINSRCH" type="{http://experian.com/nextgen/schemas}AdminSrch" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="BINID" type="{http://experian.com/nextgen/schemas}BinId" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="ENDOFENQ" type="{http://www.w3.org/2001/XMLSchema}string"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
 "startenq",
 "enqheadr",
 "userpref",
 "addlprod",
 "busnsrch",
 "busnesacct",
 "busnaddr",
 "busnphone",
 "adminsrch",
 "binid",
 "endofenq"
})*/
@XmlRootElement(name = "getBusinessProductListRequest")
public class UiqProductList extends Uiq {/*

 @XmlElement(name = "STARTENQ", required = true)
 protected String startenq;
 @XmlElement(name = "ENQHEADR", required = true)
 protected EnqHeadr enqheadr;
 @XmlElement(name = "USERPREF", required = true)
 protected UserPref userpref;
 @XmlElement(name = "ADDLPROD")
 protected List<AddlProd> addlprod;
 @XmlElement(name = "BUSNSRCH")
 protected List<BusSrch> busnsrch;
 @XmlElement(name = "BUSNESACCT")
 protected List<BusnesAcct> busnesacct;
 @XmlElement(name = "BUSNADDR")
 protected List<BusAddr> busnaddr;
 @XmlElement(name = "BUSNPHONE")
 protected List<BusnPhone> busnphone;
 @XmlElement(name = "ADMINSRCH")
 protected List<AdminSrch> adminsrch;
 @XmlElement(name = "BINID")
 protected List<BinId> binid;
 @XmlElement(name = "ENDOFENQ", required = true)
 protected String endofenq;

 *//**
  * Gets the value of the startenq property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  *//*
 public String getSTARTENQ() {
     return startenq;
 }

 *//**
  * Sets the value of the startenq property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  *//*
 public void setSTARTENQ(String value) {
     this.startenq = value;
 }

 *//**
  * Gets the value of the enqheadr property.
  * 
  * @return
  *     possible object is
  *     {@link EnqHeadr }
  *     
  *//*
 public EnqHeadr getENQHEADR() {
     return enqheadr;
 }

 *//**
  * Sets the value of the enqheadr property.
  * 
  * @param value
  *     allowed object is
  *     {@link EnqHeadr }
  *     
  *//*
 public void setENQHEADR(EnqHeadr value) {
     this.enqheadr = value;
 }

 *//**
  * Gets the value of the userpref property.
  * 
  * @return
  *     possible object is
  *     {@link UserPref }
  *     
  *//*
 public UserPref getUSERPREF() {
     return userpref;
 }

 *//**
  * Sets the value of the userpref property.
  * 
  * @param value
  *     allowed object is
  *     {@link UserPref }
  *     
  *//*
 public void setUSERPREF(UserPref value) {
     this.userpref = value;
 }

 *//**
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
  *//*
 public List<AddlProd> getADDLPROD() {
     if (addlprod == null) {
         addlprod = new ArrayList<AddlProd>();
     }
     return this.addlprod;
 }

 *//**
  * Gets the value of the busnsrch property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the busnsrch property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getBUSNSRCH().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link BusSrch }
  * 
  * 
  *//*
 public List<BusSrch> getBUSNSRCH() {
     if (busnsrch == null) {
         busnsrch = new ArrayList<BusSrch>();
     }
     return this.busnsrch;
 }

 *//**
  * Gets the value of the busnesacct property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the busnesacct property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getBUSNESACCT().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link BusnesAcct }
  * 
  * 
  *//*
 public List<BusnesAcct> getBUSNESACCT() {
     if (busnesacct == null) {
         busnesacct = new ArrayList<BusnesAcct>();
     }
     return this.busnesacct;
 }

 *//**
  * Gets the value of the busnaddr property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the busnaddr property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getBUSNADDR().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link BusAddr }
  * 
  * 
  *//*
 public List<BusAddr> getBUSNADDR() {
     if (busnaddr == null) {
         busnaddr = new ArrayList<BusAddr>();
     }
     return this.busnaddr;
 }

 *//**
  * Gets the value of the busnphone property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the busnphone property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getBUSNPHONE().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link BusnPhone }
  * 
  * 
  *//*
 public List<BusnPhone> getBUSNPHONE() {
     if (busnphone == null) {
         busnphone = new ArrayList<BusnPhone>();
     }
     return this.busnphone;
 }

 *//**
  * Gets the value of the adminsrch property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the adminsrch property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getADMINSRCH().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link AdminSrch }
  * 
  * 
  *//*
 public List<AdminSrch> getADMINSRCH() {
     if (adminsrch == null) {
         adminsrch = new ArrayList<AdminSrch>();
     }
     return this.adminsrch;
 }

 *//**
  * Gets the value of the binid property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the binid property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getBINID().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link BinId }
  * 
  * 
  *//*
 public List<BinId> getBINID() {
     if (binid == null) {
         binid = new ArrayList<BinId>();
     }
     return this.binid;
 }

 *//**
  * Gets the value of the endofenq property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  *//*
 public String getENDOFENQ() {
     return endofenq;
 }

 *//**
  * Sets the value of the endofenq property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  *//*
 public void setENDOFENQ(String value) {
     this.endofenq = value;
 }

*/}

