/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Bidaddrs", propOrder={"segmentCode", "locationType", "addressL1", "addressL2", "addressL3", "city", "pinCode", "state", "countryCode"})
/*     */ public class Bidaddrs
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="LocationType")
/*     */   protected String locationType;
/*     */   @XmlElement(name="AddressL1")
/*     */   protected String addressL1;
/*     */   @XmlElement(name="AddressL2")
/*     */   protected String addressL2;
/*     */   @XmlElement(name="AddressL3")
/*     */   protected String addressL3;
/*     */   @XmlElement(name="City")
/*     */   protected String city;
/*     */   @XmlElement(name="State")
/*     */   protected String state;
/*     */   @XmlElement(name="CountryCode")
/*     */   protected String countryCode;
/*     */   @XmlElement(name="PinCode")
/*     */   protected String pinCode;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  57 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  62 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getLocationType() {
/*  66 */     return this.locationType;
/*     */   }
/*     */   
/*     */   public void setLocationType(String value) {
/*  70 */     this.locationType = value;
/*     */   }
/*     */   
/*     */   public String getAddressL1() {
/*  74 */     return this.addressL1;
/*     */   }
/*     */   
/*     */   public void setAddressL1(String value) {
/*  78 */     this.addressL1 = value;
/*     */   }
/*     */   
/*     */   public String getAddressL2() {
/*  82 */     return this.addressL2;
/*     */   }
/*     */   
/*     */   public void setAddressL2(String value) {
/*  86 */     this.addressL2 = value;
/*     */   }
/*     */   
/*     */   public String getAddressL3() {
/*  90 */     return this.addressL3;
/*     */   }
/*     */   
/*     */   public void setAddressL3(String value) {
/*  94 */     this.addressL3 = value;
/*     */   }
/*     */   
/*     */   public String getCity() {
/*  98 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String value) {
/* 102 */     this.city = value;
/*     */   }
/*     */   
/*     */   public String getPinCode()
/*     */   {
/* 107 */     return this.pinCode;
/*     */   }
/*     */   
/*     */   public void setPinCode(String value) {
/* 111 */     this.pinCode = value;
/*     */   }
/*     */   
/*     */   public String getState()
/*     */   {
/* 116 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state)
/*     */   {
/* 121 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getCountryCode()
/*     */   {
/* 126 */     return this.countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String countryCode)
/*     */   {
/* 131 */     this.countryCode = countryCode;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Bidaddrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */