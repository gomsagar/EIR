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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="BDetails", propOrder={"segmentCode", "legalDescription", "industryType", "industryTypeDetail", "businessStatus", "businessPAN", "businessAddress", "businessCity", "businessPINCode"})
/*     */ public class BDetails
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="LegalDescription")
/*     */   protected String legalDescription;
/*     */   @XmlElement(name="IndustryType")
/*     */   protected String industryType;
/*     */   @XmlElement(name="IndustryTypeDetail")
/*     */   protected String industryTypeDetail;
/*     */   @XmlElement(name="BusinessStatus")
/*     */   protected String businessStatus;
/*     */   @XmlElement(name="BusinessPAN")
/*     */   protected String businessPAN;
/*     */   @XmlElement(name="BusinessAddress")
/*     */   protected String businessAddress;
/*     */   @XmlElement(name="BusinessCity")
/*     */   protected String businessCity;
/*     */   @XmlElement(name="BusinessPINCode")
/*     */   protected String businessPINCode;
/*     */   
/*     */   public String getLegalDescription()
/*     */   {
/*  65 */     return this.legalDescription;
/*     */   }
/*     */   
/*     */   public void setLegalDescription(String value) {
/*  69 */     this.legalDescription = value;
/*     */   }
/*     */   
/*     */   public String getIndustryType() {
/*  73 */     return this.industryType;
/*     */   }
/*     */   
/*     */   public void setIndustryType(String value) {
/*  77 */     this.industryType = value;
/*     */   }
/*     */   
/*     */   public String getIndustryTypeDetail() {
/*  81 */     return this.industryTypeDetail;
/*     */   }
/*     */   
/*     */   public void setIndustryTypeDetail(String value) {
/*  85 */     this.industryTypeDetail = value;
/*     */   }
/*     */   
/*     */   public String getBusinessStatus() {
/*  89 */     return this.businessStatus;
/*     */   }
/*     */   
/*     */   public void setBusinessStatus(String value) {
/*  93 */     this.businessStatus = value;
/*     */   }
/*     */   
/*     */   public String getBusinessPAN() {
/*  97 */     return this.businessPAN;
/*     */   }
/*     */   
/*     */   public void setBusinessPAN(String value) {
/* 101 */     this.businessPAN = value;
/*     */   }
/*     */   
/*     */   public String getBusinessAddress() {
/* 105 */     return this.businessAddress;
/*     */   }
/*     */   
/*     */   public void setBusinessAddress(String value) {
/* 109 */     this.businessAddress = value;
/*     */   }
/*     */   
/*     */   public String getBusinessCity() {
/* 113 */     return this.businessCity;
/*     */   }
/*     */   
/*     */   public void setBusinessCity(String value) {
/* 117 */     this.businessCity = value;
/*     */   }
/*     */   
/*     */   public String getBusinessPINCode() {
/* 121 */     return this.businessPINCode;
/*     */   }
/*     */   
/*     */   public void setBusinessPINCode(String value)
/*     */   {
/* 126 */     this.businessPINCode = value;
/*     */   }
/*     */   
/*     */   public String getSegmentCode() {
/* 130 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String segmentCode) {
/* 134 */     this.segmentCode = segmentCode;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */