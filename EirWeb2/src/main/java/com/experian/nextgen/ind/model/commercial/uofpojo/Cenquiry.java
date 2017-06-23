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
/*     */ @XmlType(name="Cenquiry", propOrder={"segmentCode", "inqUserId", "clientEnquiryRefNumber", "inqBureauMemberId", "inqRefNum", "inqPurposeCd", "inqAcctTypeCd", "inqAmt", "inqAmtMonetaryCd", "inqProductName", "inqProductCd", "inqProductSearchTypeCd", "frequency", "durationofAgreement"})
/*     */ public class Cenquiry
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="InqUserId")
/*     */   protected String inqUserId;
/*     */   @XmlElement(name="ClientEnquiryRefNumber")
/*     */   protected String clientEnquiryRefNumber;
/*     */   @XmlElement(name="InqBureauMemberId")
/*     */   protected String inqBureauMemberId;
/*     */   @XmlElement(name="InqRefNum")
/*     */   protected String inqRefNum;
/*     */   @XmlElement(name="InqPurposeCd")
/*     */   protected String inqPurposeCd;
/*     */   @XmlElement(name="InqAcctTypeCd")
/*     */   protected String inqAcctTypeCd;
/*     */   @XmlElement(name="InqAmt")
/*     */   protected String inqAmt;
/*     */   @XmlElement(name="InqAmtMonetaryCd")
/*     */   protected String inqAmtMonetaryCd;
/*     */   @XmlElement(name="InqProductName")
/*     */   protected String inqProductName;
/*     */   @XmlElement(name="InqProductCd")
/*     */   protected String inqProductCd;
/*     */   @XmlElement(name="InqProductSearchTypeCd")
/*     */   protected String inqProductSearchTypeCd;
/*     */   @XmlElement(name="Frequency")
/*     */   protected String frequency;
/*     */   @XmlElement(name="DurationofAgreement")
/*     */   protected String durationofAgreement;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  87 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String segmentCode) {
/*  91 */     this.segmentCode = segmentCode;
/*     */   }
/*     */   
/*     */   public String getInqUserId() {
/*  95 */     return this.inqUserId;
/*     */   }
/*     */   
/*     */   public void setInqUserId(String inqUserId) {
/*  99 */     this.inqUserId = inqUserId;
/*     */   }
/*     */   
/*     */   public String getInqBureauMemberId() {
/* 103 */     return this.inqBureauMemberId;
/*     */   }
/*     */   
/*     */   public void setInqBureauMemberId(String inqBureauMemberId) {
/* 107 */     this.inqBureauMemberId = inqBureauMemberId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getInqRefNum()
/*     */   {
/* 114 */     return this.inqRefNum;
/*     */   }
/*     */   
/*     */   public void setInqRefNum(String inqRefNum) {
/* 118 */     this.inqRefNum = inqRefNum;
/*     */   }
/*     */   
/*     */   public String getClientEnquiryRefNumber() {
/* 122 */     return this.clientEnquiryRefNumber;
/*     */   }
/*     */   
/*     */   public void setClientEnquiryRefNumber(String clientEnquiryRefNumber) {
/* 126 */     this.clientEnquiryRefNumber = clientEnquiryRefNumber;
/*     */   }
/*     */   
/*     */   public String getInqPurposeCd() {
/* 130 */     return this.inqPurposeCd;
/*     */   }
/*     */   
/*     */   public void setInqPurposeCd(String inqPurposeCd) {
/* 134 */     this.inqPurposeCd = inqPurposeCd;
/*     */   }
/*     */   
/*     */   public String getInqAcctTypeCd() {
/* 138 */     return this.inqAcctTypeCd;
/*     */   }
/*     */   
/*     */   public void setInqAcctTypeCd(String inqAcctTypeCd) {
/* 142 */     this.inqAcctTypeCd = inqAcctTypeCd;
/*     */   }
/*     */   
/*     */   public String getInqAmt() {
/* 146 */     return this.inqAmt;
/*     */   }
/*     */   
/*     */   public void setInqAmt(String inqAmt) {
/* 150 */     this.inqAmt = inqAmt;
/*     */   }
/*     */   
/*     */   public String getInqAmtMonetaryCd() {
/* 154 */     return this.inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */   public void setInqAmtMonetaryCd(String inqAmtMonetaryCd) {
/* 158 */     this.inqAmtMonetaryCd = inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */   public String getInqProductName() {
/* 162 */     return this.inqProductName;
/*     */   }
/*     */   
/*     */   public void setInqProductName(String inqProductName) {
/* 166 */     this.inqProductName = inqProductName;
/*     */   }
/*     */   
/*     */   public String getInqProductCd() {
/* 170 */     return this.inqProductCd;
/*     */   }
/*     */   
/*     */   public void setInqProductCd(String inqProductCd) {
/* 174 */     this.inqProductCd = inqProductCd;
/*     */   }
/*     */   
/*     */   public String getInqProductSearchTypeCd() {
/* 178 */     return this.inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */   public void setInqProductSearchTypeCd(String inqProductSearchTypeCd) {
/* 182 */     this.inqProductSearchTypeCd = inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */   public String getFrequency() {
/* 186 */     return this.frequency;
/*     */   }
/*     */   
/*     */   public void setFrequency(String frequency) {
/* 190 */     this.frequency = frequency;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDurationofAgreement()
/*     */   {
/* 197 */     return this.durationofAgreement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDurationofAgreement(String durationofAgreement)
/*     */   {
/* 204 */     this.durationofAgreement = durationofAgreement;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Cenquiry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */