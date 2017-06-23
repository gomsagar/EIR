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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Burcndls", propOrder={"segmentCode", "legalRepresentativeName", "businessName", "addressLine1", "addressLine2", "addressLine3", "city", "district", "state", "pincode", "phoneNumber", "PAN", "businessPerson", "matchType", "relationship", "experianEncryptedBIN"})
/*     */ public class Burcndls
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="LegalRepresentativeName")
/*     */   protected String legalRepresentativeName;
/*     */   @XmlElement(name="BusinessName")
/*     */   protected String businessName;
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
/*     */   @XmlElement(name="PAN")
/*     */   protected String PAN;
/*     */   @XmlElement(name="BusinessPerson")
/*     */   protected String businessPerson;
/*     */   @XmlElement(name="MatchType")
/*     */   protected String matchType;
/*     */   @XmlElement(name="Relationship")
/*     */   protected String relationship;
/*     */   @XmlElement(name="ExperianEncryptedBIN")
/*     */   protected String experianEncryptedBIN;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  64 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/*  68 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getLegalRepresentativeName()
/*     */   {
/*  75 */     return this.legalRepresentativeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBusinessName()
/*     */   {
/*  82 */     return this.businessName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddressLine1()
/*     */   {
/*  89 */     return this.addressLine1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddressLine2()
/*     */   {
/*  96 */     return this.addressLine2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddressLine3()
/*     */   {
/* 103 */     return this.addressLine3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 110 */     return this.city;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDistrict()
/*     */   {
/* 117 */     return this.district;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 124 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPincode()
/*     */   {
/* 131 */     return this.pincode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPhoneNumber()
/*     */   {
/* 138 */     return this.phoneNumber;
/*     */   }
/*     */   
/*     */   public String getPAN()
/*     */   {
/* 143 */     return this.PAN;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getExperianEncryptedBIN()
/*     */   {
/* 151 */     return this.experianEncryptedBIN;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLegalRepresentativeName(String legalRepresentativeName)
/*     */   {
/* 158 */     this.legalRepresentativeName = legalRepresentativeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBusinessName(String businessName)
/*     */   {
/* 165 */     this.businessName = businessName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddressLine1(String addressLine1)
/*     */   {
/* 172 */     this.addressLine1 = addressLine1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddressLine2(String addressLine2)
/*     */   {
/* 179 */     this.addressLine2 = addressLine2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddressLine3(String addressLine3)
/*     */   {
/* 186 */     this.addressLine3 = addressLine3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 193 */     this.city = city;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDistrict(String district)
/*     */   {
/* 200 */     this.district = district;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 207 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPincode(String pincode)
/*     */   {
/* 214 */     this.pincode = pincode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneNumber(String phoneNumber)
/*     */   {
/* 223 */     this.phoneNumber = phoneNumber;
/*     */   }
/*     */   
/*     */   public void setPAN(String pAN) {
/* 227 */     this.PAN = pAN;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExperianEncryptedBIN(String experianEncryptedBIN)
/*     */   {
/* 235 */     this.experianEncryptedBIN = experianEncryptedBIN;
/*     */   }
/*     */   
/*     */   public String getBusinessPerson() {
/* 239 */     return this.businessPerson;
/*     */   }
/*     */   
/*     */   public void setBusinessPerson(String businessPerson) {
/* 243 */     this.businessPerson = businessPerson;
/*     */   }
/*     */   
/*     */   public String getMatchType() {
/* 247 */     return this.matchType;
/*     */   }
/*     */   
/*     */   public void setMatchType(String matchType) {
/* 251 */     this.matchType = matchType;
/*     */   }
/*     */   
/*     */   public String getRelationship() {
/* 255 */     return this.relationship;
/*     */   }
/*     */   
/*     */   public void setRelationship(String relationship) {
/* 259 */     this.relationship = relationship;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Burcndls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */