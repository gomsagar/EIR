/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
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
/*     */ @XmlType(name="Burcndls", propOrder={"segmentCode", "name", "addressLine1", "addressLine2", "addressLine3", "city", "district", "state", "pincode", "phoneNumber", "idNumberType", "idNumber", "experianEncryptedPIN"})
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ public class Burcndls
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="Name")
/*     */   protected String name;
/*     */   @XmlElement(name="AddressLine1")
/*     */   protected String addressLine1;
/*     */   @XmlElement(name="AddressLine2")
/*     */   protected String addressLine2;
/*     */   @XmlElement(name="AddressLine3")
/*     */   protected String addressLine3;
/*     */   @XmlElement(name="City")
/*     */   protected String city;
/*     */   @XmlElement(name="District")
/*     */   protected String district;
/*     */   @XmlElement(name="State")
/*     */   protected String state;
/*     */   @XmlElement(name="PINCode")
/*     */   protected String pincode;
/*     */   @XmlElement(name="PhoneNumber")
/*     */   protected String phoneNumber;
/*     */   @XmlElement(name="IdNumberType")
/*     */   protected String idNumberType;
/*     */   @XmlElement(name="IdNumber")
/*     */   protected String idNumber;
/*     */   @XmlElement(name="ExperianEncryptedPIN")
/*     */   protected String experianEncryptedPIN;
/*     */   
/*     */   public String getName()
/*     */   {
/*  62 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  66 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getIdNumberType() {
/*  70 */     return this.idNumberType;
/*     */   }
/*     */   
/*     */   public void setIdNumberType(String idNumberType) {
/*  74 */     this.idNumberType = idNumberType;
/*     */   }
/*     */   
/*     */   public String getIdNumber() {
/*  78 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public void setIdNumber(String idNumber) {
/*  82 */     this.idNumber = idNumber;
/*     */   }
/*     */   
/*     */   public String getSegmentCode() {
/*  86 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/*  90 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAddressLine1()
/*     */   {
/*  98 */     return this.addressLine1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddressLine2()
/*     */   {
/* 105 */     return this.addressLine2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddressLine3()
/*     */   {
/* 112 */     return this.addressLine3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 119 */     return this.city;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDistrict()
/*     */   {
/* 126 */     return this.district;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 133 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPincode()
/*     */   {
/* 140 */     return this.pincode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPhoneNumber()
/*     */   {
/* 147 */     return this.phoneNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getExperianEncryptedPIN()
/*     */   {
/* 154 */     return this.experianEncryptedPIN;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddressLine1(String addressLine1)
/*     */   {
/* 162 */     this.addressLine1 = addressLine1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddressLine2(String addressLine2)
/*     */   {
/* 169 */     this.addressLine2 = addressLine2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddressLine3(String addressLine3)
/*     */   {
/* 176 */     this.addressLine3 = addressLine3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 183 */     this.city = city;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDistrict(String district)
/*     */   {
/* 190 */     this.district = district;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 197 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPincode(String pincode)
/*     */   {
/* 204 */     this.pincode = pincode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPhoneNumber(String phoneNumber)
/*     */   {
/* 211 */     this.phoneNumber = phoneNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExperianEncryptedPIN(String experianEncryptedPIN)
/*     */   {
/* 218 */     this.experianEncryptedPIN = experianEncryptedPIN;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Burcndls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */