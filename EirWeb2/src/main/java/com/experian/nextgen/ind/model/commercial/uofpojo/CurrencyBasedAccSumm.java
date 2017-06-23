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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="CurrencyBasedAccSumm", propOrder={"currency", "funded", "nonFunded", "shortTerm", "longTerm", "wilful", "suitFiled"})
/*     */ public class CurrencyBasedAccSumm
/*     */ {
/*     */   @XmlElement(name="Currency")
/*     */   protected String currency;
/*     */   @XmlElement(name="Funded")
/*     */   protected String funded;
/*     */   @XmlElement(name="NonFunded")
/*     */   protected String nonFunded;
/*     */   @XmlElement(name="ShortTerm")
/*     */   protected String shortTerm;
/*     */   @XmlElement(name="LongTerm")
/*     */   protected String longTerm;
/*     */   @XmlElement(name="Wilful")
/*     */   protected String wilful;
/*     */   @XmlElement(name="SuitFiled")
/*     */   protected String suitFiled;
/*     */   
/*     */   public String getCurrency()
/*     */   {
/*  53 */     return this.currency;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getFunded()
/*     */   {
/*  59 */     return this.funded;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getNonFunded()
/*     */   {
/*  65 */     return this.nonFunded;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getShortTerm()
/*     */   {
/*  71 */     return this.shortTerm;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getLongTerm()
/*     */   {
/*  77 */     return this.longTerm;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getWilful()
/*     */   {
/*  83 */     return this.wilful;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getSuitFiled()
/*     */   {
/*  89 */     return this.suitFiled;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setCurrency(String currency)
/*     */   {
/*  95 */     this.currency = currency;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setFunded(String funded)
/*     */   {
/* 101 */     this.funded = funded;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setNonFunded(String nonFunded)
/*     */   {
/* 107 */     this.nonFunded = nonFunded;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setShortTerm(String shortTerm)
/*     */   {
/* 113 */     this.shortTerm = shortTerm;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setLongTerm(String longTerm)
/*     */   {
/* 119 */     this.longTerm = longTerm;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setWilful(String wilful)
/*     */   {
/* 125 */     this.wilful = wilful;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setSuitFiled(String suitFiled)
/*     */   {
/* 131 */     this.suitFiled = suitFiled;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\CurrencyBasedAccSumm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */