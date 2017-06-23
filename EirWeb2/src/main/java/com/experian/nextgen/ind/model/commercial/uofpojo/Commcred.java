/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Commcred", propOrder={"segmentCode", "accountNumber", "accountPortfolioType", "accountType", "accountCurrency", "accountFinRespTypeCd", "accountStatus", "paymentStatus", "accountOpenDate", "accountClosedDate", "sanctionedAmount", "assetClassification", "currentBalance", "wilfulDefaultStatus", "wilfulDefaultDate", "suitFiledStatus", "suitFiledDate", "suitFiledAmount", "lastReportedDate", "sanctionDate", "creditor", "borrower", "guarantor", "stmtalrt", "bpaygrid", "dispute"})
/*     */ public class Commcred
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="AccountNumber")
/*     */   protected String accountNumber;
/*     */   @XmlElement(name="AccountPortfolioType")
/*     */   protected String accountPortfolioType;
/*     */   @XmlElement(name="AccountType")
/*     */   protected String accountType;
/*     */   @XmlElement(name="AccountCurrency")
/*     */   protected String accountCurrency;
/*     */   @XmlElement(name="AccountFinRespTypeCd")
/*     */   protected String accountFinRespTypeCd;
/*     */   @XmlElement(name="AccountStatus")
/*     */   protected String accountStatus;
/*     */   @XmlElement(name="PaymentStatus")
/*     */   protected String paymentStatus;
/*     */   @XmlElement(name="AccountOpenDate")
/*     */   protected String accountOpenDate;
/*     */   @XmlElement(name="AccountClosedDate")
/*     */   protected String accountClosedDate;
/*     */   @XmlElement(name="SanctionedAmount")
/*     */   protected String sanctionedAmount;
/*     */   @XmlElement(name="AssetClassification")
/*     */   protected String assetClassification;
/*     */   @XmlElement(name="CurrentBalance")
/*     */   protected String currentBalance;
/*     */   @XmlElement(name="WilfulDefaultStatus")
/*     */   protected String wilfulDefaultStatus;
/*     */   @XmlElement(name="WilfulDefaultDate")
/*     */   protected String wilfulDefaultDate;
/*     */   @XmlElement(name="SuitFiledStatus")
/*     */   protected String suitFiledStatus;
/*     */   @XmlElement(name="SuitFiledDate")
/*     */   protected String suitFiledDate;
/*     */   @XmlElement(name="SuitFiledAmount")
/*     */   protected String suitFiledAmount;
/*     */   @XmlElement(name="LastReportedDate")
/*     */   protected String lastReportedDate;
/*     */   @XmlElement(name="SanctionDate")
/*     */   protected String sanctionDate;
/*     */   @XmlElement(name="BORROWER")
/*  92 */   protected List<Borrower> borrower = null;
/*     */   @XmlElement(name="CREDITOR")
/*  94 */   protected Creditor creditor = null;
/*     */   @XmlElement(name="GUARANTOR")
/*  96 */   protected List<Guarantor> guarantor = null;
/*     */   @XmlElement(name="STMTALRT")
/*  98 */   protected Stmtalrt stmtalrt = null;
/*     */   @XmlElement(name="DISPUTE")
/* 100 */   protected List<Dispute> dispute = null;
/*     */   
/*     */   public String getPaymentStatus() {
/* 103 */     return this.paymentStatus;
/*     */   }
/*     */   
/*     */   public void setPaymentStatus(String paymentStatus) {
/* 107 */     this.paymentStatus = paymentStatus;
/*     */   }
/*     */   
/*     */   public String getSanctionedAmount() {
/* 111 */     return this.sanctionedAmount;
/*     */   }
/*     */   
/*     */   public void setSanctionedAmount(String sanctionedAmount) {
/* 115 */     this.sanctionedAmount = sanctionedAmount;
/*     */   }
/*     */   
/*     */   public String getLastReportedDate() {
/* 119 */     return this.lastReportedDate;
/*     */   }
/*     */   
/*     */   public void setLastReportedDate(String lastReportedDate) {
/* 123 */     this.lastReportedDate = lastReportedDate;
/*     */   }
/*     */   
/*     */   public String getSanctionDate() {
/* 127 */     return this.sanctionDate;
/*     */   }
/*     */   
/*     */ 
/* 131 */   public void setSanctionDate(String sanctionDate) { this.sanctionDate = sanctionDate; }
/*     */   @XmlElement(name="BPAYGRID")
/* 133 */   protected List<BPayGrid> bpaygrid = null;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 137 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/* 141 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getAccountNumber()
/*     */   {
/* 146 */     return this.accountNumber;
/*     */   }
/*     */   
/*     */   public void setAccountNumber(String value)
/*     */   {
/* 151 */     this.accountNumber = value;
/*     */   }
/*     */   
/*     */   public String getAccountPortfolioType()
/*     */   {
/* 156 */     return this.accountPortfolioType;
/*     */   }
/*     */   
/*     */   public void setAccountPortfolioType(String value)
/*     */   {
/* 161 */     this.accountPortfolioType = value;
/*     */   }
/*     */   
/*     */   public String getAccountType()
/*     */   {
/* 166 */     return this.accountType;
/*     */   }
/*     */   
/*     */   public void setAccountType(String value)
/*     */   {
/* 171 */     this.accountType = value;
/*     */   }
/*     */   
/*     */   public String getAccountCurrency()
/*     */   {
/* 176 */     return this.accountCurrency;
/*     */   }
/*     */   
/*     */   public void setAccountCurrency(String value) {
/* 180 */     this.accountCurrency = value;
/*     */   }
/*     */   
/*     */   public String getAccountFinRespTypeCd()
/*     */   {
/* 185 */     return this.accountFinRespTypeCd;
/*     */   }
/*     */   
/*     */   public void setAccountFinRespTypeCd(String value)
/*     */   {
/* 190 */     this.accountFinRespTypeCd = value;
/*     */   }
/*     */   
/*     */   public String getAccountStatus()
/*     */   {
/* 195 */     return this.accountStatus;
/*     */   }
/*     */   
/*     */   public void setAccountStatus(String value)
/*     */   {
/* 200 */     this.accountStatus = value;
/*     */   }
/*     */   
/*     */   public String getAccountOpenDate()
/*     */   {
/* 205 */     return this.accountOpenDate;
/*     */   }
/*     */   
/*     */   public void setAccountOpenDate(String value)
/*     */   {
/* 210 */     this.accountOpenDate = value;
/*     */   }
/*     */   
/*     */   public String getAccountClosedDate()
/*     */   {
/* 215 */     return this.accountClosedDate;
/*     */   }
/*     */   
/*     */   public void setAccountClosedDate(String value)
/*     */   {
/* 220 */     this.accountClosedDate = value;
/*     */   }
/*     */   
/*     */   public String getAssetClassification()
/*     */   {
/* 225 */     return this.assetClassification;
/*     */   }
/*     */   
/*     */   public void setAssetClassification(String value)
/*     */   {
/* 230 */     this.assetClassification = value;
/*     */   }
/*     */   
/*     */   public String getCurrentBalance()
/*     */   {
/* 235 */     return this.currentBalance;
/*     */   }
/*     */   
/*     */   public void setCurrentBalance(String value)
/*     */   {
/* 240 */     this.currentBalance = value;
/*     */   }
/*     */   
/*     */   public String getWilfulDefaultStatus()
/*     */   {
/* 245 */     return this.wilfulDefaultStatus;
/*     */   }
/*     */   
/*     */   public void setWilfulDefaultStatus(String value)
/*     */   {
/* 250 */     this.wilfulDefaultStatus = value;
/*     */   }
/*     */   
/*     */   public String getWilfulDefaultDate()
/*     */   {
/* 255 */     return this.wilfulDefaultDate;
/*     */   }
/*     */   
/*     */   public void setWilfulDefaultDate(String value)
/*     */   {
/* 260 */     this.wilfulDefaultDate = value;
/*     */   }
/*     */   
/*     */   public String getSuitFiledStatus()
/*     */   {
/* 265 */     return this.suitFiledStatus;
/*     */   }
/*     */   
/*     */   public void setSuitFiledStatus(String value)
/*     */   {
/* 270 */     this.suitFiledStatus = value;
/*     */   }
/*     */   
/*     */   public String getSuitFiledDate()
/*     */   {
/* 275 */     return this.suitFiledDate;
/*     */   }
/*     */   
/*     */   public void setSuitFiledDate(String value)
/*     */   {
/* 280 */     this.suitFiledDate = value;
/*     */   }
/*     */   
/*     */   public String getSuitFiledAmount()
/*     */   {
/* 285 */     return this.suitFiledAmount;
/*     */   }
/*     */   
/*     */   public void setSuitFiledAmount(String value) {
/* 289 */     this.suitFiledAmount = value;
/*     */   }
/*     */   
/*     */   public Creditor getCreditor() {
/* 293 */     if (this.creditor == null) {
/* 294 */       this.creditor = new Creditor();
/*     */     }
/* 296 */     return this.creditor;
/*     */   }
/*     */   
/*     */   public void setCreditor(Creditor creditor) {
/* 300 */     this.creditor = creditor;
/*     */   }
/*     */   
/*     */   public Stmtalrt getStmtalrt() {
/* 304 */     if (this.stmtalrt == null) {
/* 305 */       this.stmtalrt = new Stmtalrt();
/*     */     }
/* 307 */     return this.stmtalrt;
/*     */   }
/*     */   
/*     */   public void setStmtalrt(Stmtalrt stmtalrt) {
/* 311 */     this.stmtalrt = stmtalrt;
/*     */   }
/*     */   
/*     */   public List<BPayGrid> getBpaygrid() {
/* 315 */     return this.bpaygrid;
/*     */   }
/*     */   
/* 318 */   public void setBpaygrid(List<BPayGrid> bpaygrid) { this.bpaygrid = bpaygrid; }
/*     */   
/*     */   public List<Dispute> getDispute()
/*     */   {
/* 322 */     return this.dispute;
/*     */   }
/*     */   
/*     */   public void setDispute(List<Dispute> dispute) {
/* 326 */     this.dispute = dispute;
/*     */   }
/*     */   
/*     */   public List<Borrower> getBorrower() {
/* 330 */     if (this.borrower == null) {
/* 331 */       this.borrower = new ArrayList();
/*     */     }
/* 333 */     return this.borrower;
/*     */   }
/*     */   
/*     */   public void setBorrower(List<Borrower> borrower) {
/* 337 */     this.borrower = borrower;
/*     */   }
/*     */   
/*     */   public List<Guarantor> getGuarantor() {
/* 341 */     if (this.guarantor == null) {
/* 342 */       this.guarantor = new ArrayList();
/*     */     }
/* 344 */     return this.guarantor;
/*     */   }
/*     */   
/*     */   public void setGuarantor(List<Guarantor> guarantor) {
/* 348 */     this.guarantor = guarantor;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Commcred.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */