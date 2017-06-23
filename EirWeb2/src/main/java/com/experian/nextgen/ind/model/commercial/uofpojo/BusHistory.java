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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="BusHist", propOrder={"segmentCode", "asOfDate", "companyName", "companyAddress", "companyCity", "companyPinCode", "telephone", "companyID"})
/*     */ public class BusHistory
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="AsOfDate")
/*     */   protected String asOfDate;
/*     */   @XmlElement(name="CompanyName")
/*     */   protected String companyName;
/*     */   @XmlElement(name="CompanyAddress")
/*     */   protected String companyAddress;
/*     */   @XmlElement(name="CompanyCity")
/*     */   protected String companyCity;
/*     */   @XmlElement(name="CompanyPinCode")
/*     */   protected String companyPinCode;
/*     */   @XmlElement(name="Telephone")
/*     */   protected String telephone;
/*     */   @XmlElement(name="CompanyID")
/*     */   protected String companyID;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  56 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String segmentCode) {
/*  60 */     this.segmentCode = segmentCode;
/*     */   }
/*     */   
/*     */   public String getAsOfDate() {
/*  64 */     return this.asOfDate;
/*     */   }
/*     */   
/*     */   public void setAsOfDate(String asOfDate) {
/*  68 */     this.asOfDate = asOfDate;
/*     */   }
/*     */   
/*     */   public String getCompanyName() {
/*  72 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/*  76 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   public String getCompanyAddress() {
/*  80 */     return this.companyAddress;
/*     */   }
/*     */   
/*     */   public void setCompanyAddress(String companyAddress) {
/*  84 */     this.companyAddress = companyAddress;
/*     */   }
/*     */   
/*     */   public String getCompanyCity() {
/*  88 */     return this.companyCity;
/*     */   }
/*     */   
/*     */   public void setCompanyCity(String companyCity) {
/*  92 */     this.companyCity = companyCity;
/*     */   }
/*     */   
/*     */   public String getCompanyPinCode() {
/*  96 */     return this.companyPinCode;
/*     */   }
/*     */   
/*     */   public void setCompanyPinCode(String companyPinCode) {
/* 100 */     this.companyPinCode = companyPinCode;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 104 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/* 108 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public String getCompanyID() {
/* 112 */     return this.companyID;
/*     */   }
/*     */   
/*     */   public void setCompanyID(String companyID) {
/* 116 */     this.companyID = companyID;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BusHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */