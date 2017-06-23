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
/*     */ @XmlType(name="Cenquiry", propOrder={"segmentCode", "inqUserId", "clientEnquiryRefNumber", "inqBureauMemberId", "inqRefNum", "inqPurposeCd", "inqAcctTypeCd", "inqAmt", "inqAmtMonetaryCd", "inqProductName", "inqProductCd", "inqProductSearchTypeCd", "inqAccountPurposeCd", "inqCreditPurpose", "inqDurationofAgreement", "inqFrequency"})
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
/*     */   @XmlElement(name="InqAcctTypeCd", required=true)
/*     */   protected String inqAcctTypeCd;
/*     */   @XmlElement(name="InqAmt", required=true)
/*     */   protected String inqAmt;
/*     */   @XmlElement(name="InqAmtMonetaryCd", required=true)
/*     */   protected String inqAmtMonetaryCd;
/*     */   @XmlElement(name="InqProductName", required=true)
/*     */   protected String inqProductName;
/*     */   @XmlElement(name="InqProductCd", required=true)
/*     */   protected String inqProductCd;
/*     */   @XmlElement(name="InqProductSearchTypeCd", required=true)
/*     */   protected String inqProductSearchTypeCd;
/*     */   @XmlElement(name="InqAccountPurposeCd", required=true)
/*     */   protected String inqAccountPurposeCd;
/*     */   @XmlElement(name="InqCreditPurpose", required=true)
/*     */   protected String inqCreditPurpose;
/*     */   @XmlElement(name="InqDurationofAgreement", required=true)
/*     */   protected String inqDurationofAgreement;
/*     */   @XmlElement(name="InqFrequency", required=true)
/*     */   protected String inqFrequency;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  94 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String segmentCode) {
/*  98 */     this.segmentCode = segmentCode;
/*     */   }
/*     */   
/*     */   public String getInqUserId() {
/* 102 */     return this.inqUserId;
/*     */   }
/*     */   
/*     */   public void setInqUserId(String inqUserId) {
/* 106 */     this.inqUserId = inqUserId;
/*     */   }
/*     */   
/*     */   public String getInqBureauMemberId() {
/* 110 */     return this.inqBureauMemberId;
/*     */   }
/*     */   
/*     */   public void setInqBureauMemberId(String inqBureauMemberId) {
/* 114 */     this.inqBureauMemberId = inqBureauMemberId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getInqRefNum()
/*     */   {
/* 121 */     return this.inqRefNum;
/*     */   }
/*     */   
/*     */   public void setInqRefNum(String inqRefNum) {
/* 125 */     this.inqRefNum = inqRefNum;
/*     */   }
/*     */   
/*     */   public String getClientEnquiryRefNumber() {
/* 129 */     return this.clientEnquiryRefNumber;
/*     */   }
/*     */   
/*     */   public void setClientEnquiryRefNumber(String clientEnquiryRefNumber) {
/* 133 */     this.clientEnquiryRefNumber = clientEnquiryRefNumber;
/*     */   }
/*     */   
/*     */   public String getInqPurposeCd() {
/* 137 */     return this.inqPurposeCd;
/*     */   }
/*     */   
/*     */   public void setInqPurposeCd(String inqPurposeCd) {
/* 141 */     this.inqPurposeCd = inqPurposeCd;
/*     */   }
/*     */   
/*     */   public String getInqAcctTypeCd() {
/* 145 */     return this.inqAcctTypeCd;
/*     */   }
/*     */   
/*     */   public void setInqAcctTypeCd(String inqAcctTypeCd) {
/* 149 */     this.inqAcctTypeCd = inqAcctTypeCd;
/*     */   }
/*     */   
/*     */   public String getInqAmt() {
/* 153 */     return this.inqAmt;
/*     */   }
/*     */   
/*     */   public void setInqAmt(String inqAmt) {
/* 157 */     this.inqAmt = inqAmt;
/*     */   }
/*     */   
/*     */   public String getInqAmtMonetaryCd() {
/* 161 */     return this.inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */   public void setInqAmtMonetaryCd(String inqAmtMonetaryCd) {
/* 165 */     this.inqAmtMonetaryCd = inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */   public String getInqProductName() {
/* 169 */     return this.inqProductName;
/*     */   }
/*     */   
/*     */   public void setInqProductName(String inqProductName) {
/* 173 */     this.inqProductName = inqProductName;
/*     */   }
/*     */   
/*     */   public String getInqProductCd() {
/* 177 */     return this.inqProductCd;
/*     */   }
/*     */   
/*     */   public void setInqProductCd(String inqProductCd) {
/* 181 */     this.inqProductCd = inqProductCd;
/*     */   }
/*     */   
/*     */   public String getInqProductSearchTypeCd() {
/* 185 */     return this.inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */   public void setInqProductSearchTypeCd(String inqProductSearchTypeCd) {
/* 189 */     this.inqProductSearchTypeCd = inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */   public String getInqAccountPurposeCd() {
/* 193 */     return this.inqAccountPurposeCd;
/*     */   }
/*     */   
/*     */   public void setInqAccountPurposeCd(String inqAccountPurposeCd) {
/* 197 */     this.inqAccountPurposeCd = inqAccountPurposeCd;
/*     */   }
/*     */   
/*     */   public String getInqCreditPurpose() {
/* 201 */     return this.inqCreditPurpose;
/*     */   }
/*     */   
/*     */   public void setInqCreditPurpose(String inqCreditPurpose) {
/* 205 */     this.inqCreditPurpose = inqCreditPurpose;
/*     */   }
/*     */   
/*     */   public String getInqDurationofAgreement() {
/* 209 */     return this.inqDurationofAgreement;
/*     */   }
/*     */   
/*     */   public void setInqDurationofAgreement(String inqDurationofAgreement) {
/* 213 */     this.inqDurationofAgreement = inqDurationofAgreement;
/*     */   }
/*     */   
/*     */   public String getInqFrequency() {
/* 217 */     return this.inqFrequency;
/*     */   }
/*     */   
/*     */   public void setInqFrequency(String inqFrequency) {
/* 221 */     this.inqFrequency = inqFrequency;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Cenquiry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */