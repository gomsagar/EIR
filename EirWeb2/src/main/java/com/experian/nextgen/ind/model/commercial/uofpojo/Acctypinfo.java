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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Acctypinfo", propOrder={"segmentCode", "accountType", "currencyCd", "totalCurrentBalance", "totalCreditTypeNo", "pctTotalStandardCreditType", "pctTotalSubStandardCreditType", "pctTotalDoubtfulCreditType", "pctTotalLossCreditType", "pctTotalSpecMentionCreditType"})
/*     */ public class Acctypinfo
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="AccountType")
/*     */   protected String accountType;
/*     */   @XmlElement(name="CurrencyCd")
/*     */   protected String currencyCd;
/*     */   @XmlElement(name="TotalCurrentBalance")
/*     */   protected String totalCurrentBalance;
/*     */   @XmlElement(name="TotalCreditTypeNo")
/*     */   protected String totalCreditTypeNo;
/*     */   @XmlElement(name="PctTotalStandardCreditType")
/*     */   protected String pctTotalStandardCreditType;
/*     */   @XmlElement(name="PctTotalSubStandardCreditType")
/*     */   protected String pctTotalSubStandardCreditType;
/*     */   @XmlElement(name="PctTotalDoubtfulCreditType")
/*     */   protected String pctTotalDoubtfulCreditType;
/*     */   @XmlElement(name="PctTotalLossCreditType")
/*     */   protected String pctTotalLossCreditType;
/*     */   @XmlElement(name="PctTotalSpecMentionCreditType")
/*     */   protected String pctTotalSpecMentionCreditType;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  55 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/*  59 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getAccountType() {
/*  63 */     return this.accountType;
/*     */   }
/*     */   
/*     */   public void setAccountType(String value) {
/*  67 */     this.accountType = value;
/*     */   }
/*     */   
/*     */   public String getCurrencyCd() {
/*  71 */     return this.currencyCd;
/*     */   }
/*     */   
/*     */   public void setCurrencyCd(String value) {
/*  75 */     this.currencyCd = value;
/*     */   }
/*     */   
/*     */   public String getTotalCurrentBalance() {
/*  79 */     return this.totalCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setTotalCurrentBalance(String value) {
/*  83 */     this.totalCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getTotalCreditTypeNo() {
/*  87 */     return this.totalCreditTypeNo;
/*     */   }
/*     */   
/*     */   public void setTotalCreditTypeNo(String value) {
/*  91 */     this.totalCreditTypeNo = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalStandardCreditType() {
/*  95 */     return this.pctTotalStandardCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalStandardCreditType(String value) {
/*  99 */     this.pctTotalStandardCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalSubStandardCreditType() {
/* 103 */     return this.pctTotalSubStandardCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalSubStandardCreditType(String value) {
/* 107 */     this.pctTotalSubStandardCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalDoubtfulCreditType() {
/* 111 */     return this.pctTotalDoubtfulCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalDoubtfulCreditType(String value) {
/* 115 */     this.pctTotalDoubtfulCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalLossCreditType() {
/* 119 */     return this.pctTotalLossCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalLossCreditType(String value) {
/* 123 */     this.pctTotalLossCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalSpecMentionCreditType() {
/* 127 */     return this.pctTotalSpecMentionCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalSpecMentionCreditType(String value) {
/* 131 */     this.pctTotalSpecMentionCreditType = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Acctypinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */