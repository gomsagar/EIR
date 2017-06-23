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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Currcystat", propOrder={"segmentCode", "fundCurrentBalance", "nonFundCurrentBalance", "shortTermsCurrentBalance", "longTermsCurrentBalance", "wilfullDefaultCurrentBalance", "suitFiledCurrentBalance"})
/*     */ public class Currcystat
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="FundCurrentBalance")
/*     */   protected String fundCurrentBalance;
/*     */   @XmlElement(name="NonFundCurrentBalance")
/*     */   protected String nonFundCurrentBalance;
/*     */   @XmlElement(name="ShortTermsCurrentBalance")
/*     */   protected String shortTermsCurrentBalance;
/*     */   @XmlElement(name="LongTermsCurrentBalance")
/*     */   protected String longTermsCurrentBalance;
/*     */   @XmlElement(name="WilfullDefaultCurrentBalance")
/*     */   protected String wilfullDefaultCurrentBalance;
/*     */   @XmlElement(name="SuitFiledCurrentBalance")
/*     */   protected String suitFiledCurrentBalance;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  47 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  52 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getFundCurrentBalance()
/*     */   {
/*  57 */     return this.fundCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setFundCurrentBalance(String value)
/*     */   {
/*  62 */     this.fundCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getNonFundCurrentBalance()
/*     */   {
/*  67 */     return this.nonFundCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setNonFundCurrentBalance(String value)
/*     */   {
/*  72 */     this.nonFundCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getShortTermsCurrentBalance()
/*     */   {
/*  77 */     return this.shortTermsCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setShortTermsCurrentBalance(String value)
/*     */   {
/*  82 */     this.shortTermsCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getLongTermsCurrentBalance()
/*     */   {
/*  87 */     return this.longTermsCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setLongTermsCurrentBalance(String value)
/*     */   {
/*  92 */     this.longTermsCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getWilfullDefaultCurrentBalance()
/*     */   {
/*  97 */     return this.wilfullDefaultCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setWilfullDefaultCurrentBalance(String value)
/*     */   {
/* 102 */     this.wilfullDefaultCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getSuitFiledCurrentBalance()
/*     */   {
/* 107 */     return this.suitFiledCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setSuitFiledCurrentBalance(String value)
/*     */   {
/* 112 */     this.suitFiledCurrentBalance = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Currcystat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */