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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Borrower", propOrder={"segmentCode", "borrowerName", "borrowerLastReportedDate", "borrowerPAN", "borrowerAddress", "borrowerCity", "borrowerPINCode", "borrowerLocationType", "startDate", "accountStatusDate"})
/*     */ public class Borrower
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="BorrowerName")
/*     */   protected String borrowerName;
/*     */   @XmlElement(name="BorrowerLastReportedDate")
/*     */   protected String borrowerLastReportedDate;
/*     */   @XmlElement(name="BorrowerPAN")
/*     */   protected String borrowerPAN;
/*     */   @XmlElement(name="BorrowerAddress")
/*     */   protected String borrowerAddress;
/*     */   @XmlElement(name="BorrowerCity")
/*     */   protected String borrowerCity;
/*     */   @XmlElement(name="BorrowerPINCode")
/*     */   protected String borrowerPINCode;
/*     */   @XmlElement(name="BorrowerLocationType")
/*     */   protected String borrowerLocationType;
/*     */   @XmlElement(name="StartDate")
/*     */   protected String startDate;
/*     */   @XmlElement(name="AccountStatusDate")
/*     */   protected String accountStatusDate;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  57 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  62 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerName()
/*     */   {
/*  67 */     return this.borrowerName;
/*     */   }
/*     */   
/*     */   public void setBorrowerName(String value)
/*     */   {
/*  72 */     this.borrowerName = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerLastReportedDate()
/*     */   {
/*  77 */     return this.borrowerLastReportedDate;
/*     */   }
/*     */   
/*     */   public void setBorrowerLastReportedDate(String value)
/*     */   {
/*  82 */     this.borrowerLastReportedDate = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerPAN()
/*     */   {
/*  87 */     return this.borrowerPAN;
/*     */   }
/*     */   
/*     */   public void setBorrowerPAN(String value)
/*     */   {
/*  92 */     this.borrowerPAN = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerAddress()
/*     */   {
/*  97 */     return this.borrowerAddress;
/*     */   }
/*     */   
/*     */   public void setBorrowerAddress(String value)
/*     */   {
/* 102 */     this.borrowerAddress = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerCity()
/*     */   {
/* 107 */     return this.borrowerCity;
/*     */   }
/*     */   
/*     */   public void setBorrowerCity(String value)
/*     */   {
/* 112 */     this.borrowerCity = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerPINCode()
/*     */   {
/* 117 */     return this.borrowerPINCode;
/*     */   }
/*     */   
/*     */   public void setBorrowerPINCode(String value)
/*     */   {
/* 122 */     this.borrowerPINCode = value;
/*     */   }
/*     */   
/*     */   public String getBorrowerLocationType()
/*     */   {
/* 127 */     return this.borrowerLocationType;
/*     */   }
/*     */   
/*     */   public void setBorrowerLocationType(String value)
/*     */   {
/* 132 */     this.borrowerLocationType = value;
/*     */   }
/*     */   
/*     */   public String getStartDate()
/*     */   {
/* 137 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(String value)
/*     */   {
/* 142 */     this.startDate = value;
/*     */   }
/*     */   
/*     */   public String getAccountStatusDate()
/*     */   {
/* 147 */     return this.accountStatusDate;
/*     */   }
/*     */   
/*     */   public void setAccountStatusDate(String accountStatusDate)
/*     */   {
/* 152 */     this.accountStatusDate = accountStatusDate;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Borrower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */