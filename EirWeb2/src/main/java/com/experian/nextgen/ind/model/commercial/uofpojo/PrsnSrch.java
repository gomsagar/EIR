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
/*     */ @XmlType(name="PrsnSrch", propOrder={"segmentCode", "firstGivenName", "middleName", "otherMiddleNames", "indiaMiddleName3", "familyName", "relationship", "dateOfBirth", "martialStatus", "gender"})
/*     */ public class PrsnSrch
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="FirstGivenName")
/*     */   protected String firstGivenName;
/*     */   @XmlElement(name="MiddleName")
/*     */   protected String middleName;
/*     */   @XmlElement(name="OtherMiddleNames")
/*     */   protected String otherMiddleNames;
/*     */   @XmlElement(name="IndiaMiddleName3")
/*     */   protected String indiaMiddleName3;
/*     */   @XmlElement(name="FamilyName")
/*     */   protected String familyName;
/*     */   @XmlElement(name="Relationship")
/*     */   protected String relationship;
/*     */   @XmlElement(name="DateOfBirth")
/*     */   protected String dateOfBirth;
/*     */   @XmlElement(name="MaritalStatus")
/*     */   protected String martialStatus;
/*     */   @XmlElement(name="Gender")
/*     */   protected String gender;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  52 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  64 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFirstGivenName()
/*     */   {
/*  76 */     return this.firstGivenName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFirstGivenName(String value)
/*     */   {
/*  88 */     this.firstGivenName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMiddleName()
/*     */   {
/* 100 */     return this.middleName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMiddleName(String value)
/*     */   {
/* 112 */     this.middleName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOtherMiddleNames()
/*     */   {
/* 124 */     return this.otherMiddleNames;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOtherMiddleNames(String value)
/*     */   {
/* 136 */     this.otherMiddleNames = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFamilyName()
/*     */   {
/* 148 */     return this.familyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFamilyName(String value)
/*     */   {
/* 160 */     this.familyName = value;
/*     */   }
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
/*     */   public String getDateOfBirth()
/*     */   {
/* 175 */     return this.dateOfBirth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDateOfBirth(String value)
/*     */   {
/* 187 */     this.dateOfBirth = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getGender()
/*     */   {
/* 199 */     return this.gender;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGender(String value)
/*     */   {
/* 211 */     this.gender = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaMiddleName3()
/*     */   {
/* 223 */     return this.indiaMiddleName3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaMiddleName3(String value)
/*     */   {
/* 235 */     this.indiaMiddleName3 = value;
/*     */   }
/*     */   
/*     */   public String getRelationship() {
/* 239 */     return this.relationship;
/*     */   }
/*     */   
/*     */   public void setRelationship(String relationship) {
/* 243 */     this.relationship = relationship;
/*     */   }
/*     */   
/*     */   public String getMartialStatus() {
/* 247 */     return this.martialStatus;
/*     */   }
/*     */   
/*     */   public void setMartialStatus(String martialStatus) {
/* 251 */     this.martialStatus = martialStatus;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\PrsnSrch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */