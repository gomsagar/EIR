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
/*     */ @XmlType(name="ConsCred", propOrder={"accountNumber", "AccountNumberSuffix", "AccountCardNumber", "AccountType", "AccountTypeDetail", "AccountFinRespTypeCd", "AccountStatus", "AccountStatusDetail", "CreditorName", "CreditorIndustryCd", "AccountComplianceDate", "PHISTORY"})
/*     */ public class ConsCred
/*     */ {
/*     */   @XmlElement(name="AccountNumber")
/*     */   protected String accountNumber;
/*     */   @XmlElement(name="AccountNumberSuffix")
/*     */   protected String AccountNumberSuffix;
/*     */   @XmlElement(name="AccountCardNumber")
/*     */   protected String AccountCardNumber;
/*     */   @XmlElement(name="AccountType")
/*     */   protected String AccountType;
/*     */   @XmlElement(name="AccountTypeDetail")
/*     */   protected String AccountTypeDetail;
/*     */   @XmlElement(name="AccountFinRespTypeCd")
/*     */   protected String AccountFinRespTypeCd;
/*     */   @XmlElement(name="AccountStatus")
/*     */   protected String AccountStatus;
/*     */   @XmlElement(name="AccountStatusDetail")
/*     */   protected String AccountStatusDetail;
/*     */   @XmlElement(name="CreditorName")
/*     */   protected String CreditorName;
/*     */   @XmlElement(name="CreditorIndustryCd")
/*     */   protected String CreditorIndustryCd;
/*     */   @XmlElement(required=true, nillable=false)
/*     */   protected String AccountComplianceDate;
/*     */   
/*     */   public String getAccountNumber()
/*     */   {
/* 220 */     return this.accountNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountNumber(String value)
/*     */   {
/* 232 */     this.accountNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountNumberSuffix()
/*     */   {
/* 244 */     return this.AccountNumberSuffix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountNumberSuffix(String value)
/*     */   {
/* 256 */     this.AccountNumberSuffix = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountCardNumber()
/*     */   {
/* 268 */     return this.AccountCardNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountCardNumber(String value)
/*     */   {
/* 280 */     this.AccountCardNumber = value;
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
/*     */   public String getAccountType()
/*     */   {
/* 294 */     return this.AccountType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountType(String value)
/*     */   {
/* 306 */     this.AccountType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountTypeDetail()
/*     */   {
/* 318 */     return this.AccountTypeDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountTypeDetail(String value)
/*     */   {
/* 330 */     this.AccountTypeDetail = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountFinRespTypeCd()
/*     */   {
/* 342 */     return this.AccountFinRespTypeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountFinRespTypeCd(String value)
/*     */   {
/* 354 */     this.AccountFinRespTypeCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountStatus()
/*     */   {
/* 366 */     return this.AccountStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountStatus(String value)
/*     */   {
/* 378 */     this.AccountStatus = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountStatusDetail()
/*     */   {
/* 390 */     return this.AccountStatusDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountStatusDetail(String value)
/*     */   {
/* 402 */     this.AccountStatusDetail = value;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getCreditorName()
/*     */   {
/* 408 */     return this.CreditorName;
/*     */   }
/*     */   
/*     */   public void setCreditorName(String creditorName) {
/* 412 */     this.CreditorName = creditorName;
/*     */   }
/*     */   
/*     */   public String getCreditorIndustryCd() {
/* 416 */     return this.CreditorIndustryCd;
/*     */   }
/*     */   
/*     */   public void setCreditorIndustryCd(String creditorIndustryCd) {
/* 420 */     this.CreditorIndustryCd = creditorIndustryCd;
/*     */   }
/*     */   
/*     */   public String getAccountComplianceDate() {
/* 424 */     return this.AccountComplianceDate;
/*     */   }
/*     */   
/*     */   public void setAccountComplianceDate(String accountComplianceDate) {
/* 428 */     this.AccountComplianceDate = accountComplianceDate;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\ConsCred.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */