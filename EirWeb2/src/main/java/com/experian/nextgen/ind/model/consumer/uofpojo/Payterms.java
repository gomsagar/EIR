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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Payterms", propOrder={"segmentCode", "interestRate", "collateral", "amountCurrencyCd", "totalNumberOfPayments", "paymentFrequency", "paymentDuration", "collateralAmt"})
/*     */ public class Payterms
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="InterestRate")
/*     */   protected String interestRate;
/*     */   @XmlElement(name="Collateral")
/*     */   protected String collateral;
/*     */   @XmlElement(name="AmountCurrencyCd")
/*     */   protected String amountCurrencyCd;
/*     */   @XmlElement(name="TotalNumberOfPayments")
/*     */   protected String totalNumberOfPayments;
/*     */   @XmlElement(name="PaymentFrequency")
/*     */   protected String paymentFrequency;
/*     */   @XmlElement(name="PaymentDuration")
/*     */   protected String paymentDuration;
/*     */   @XmlElement(name="CollateralAmt")
/*     */   protected String collateralAmt;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 123 */     return this.segmentCode;
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
/* 135 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInterestRate()
/*     */   {
/* 147 */     return this.interestRate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInterestRate(String value)
/*     */   {
/* 159 */     this.interestRate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCollateral()
/*     */   {
/* 171 */     return this.collateral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCollateral(String value)
/*     */   {
/* 183 */     this.collateral = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAmountCurrencyCd()
/*     */   {
/* 195 */     return this.amountCurrencyCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmountCurrencyCd(String value)
/*     */   {
/* 207 */     this.amountCurrencyCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalNumberOfPayments()
/*     */   {
/* 219 */     return this.totalNumberOfPayments;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalNumberOfPayments(String value)
/*     */   {
/* 231 */     this.totalNumberOfPayments = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPaymentFrequency()
/*     */   {
/* 243 */     return this.paymentFrequency;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaymentFrequency(String value)
/*     */   {
/* 255 */     this.paymentFrequency = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCollateralAmt()
/*     */   {
/* 267 */     return this.collateralAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCollateralAmt(String value)
/*     */   {
/* 279 */     this.collateralAmt = value;
/*     */   }
/*     */   
/*     */   public String getPaymentDuration() {
/* 283 */     return this.paymentDuration;
/*     */   }
/*     */   
/*     */   public void setPaymentDuration(String paymentDuration) {
/* 287 */     this.paymentDuration = paymentDuration;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Payterms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */