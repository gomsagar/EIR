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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Currcycnct", propOrder={"segmentCode", "currencyCd", "totalNoFundedAccountType", "totalNoNonFundedAccountType", "totalNoShortTermAccountType", "totalNoLongTermAccountType", "totalNoWDAccountType", "totalNoSFAccountType"})
/*     */ public class Currcycnct
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="CurrencyCd")
/*     */   protected String currencyCd;
/*     */   @XmlElement(name="TotalNoFundedAccountType")
/*     */   protected String totalNoFundedAccountType;
/*     */   @XmlElement(name="TotalNoNonFundedAccountType")
/*     */   protected String totalNoNonFundedAccountType;
/*     */   @XmlElement(name="TotalNoShortTermAccountType")
/*     */   protected String totalNoShortTermAccountType;
/*     */   @XmlElement(name="TotalNoLongTermAccountType")
/*     */   protected String totalNoLongTermAccountType;
/*     */   @XmlElement(name="TotalNoWDAccountType")
/*     */   protected String totalNoWDAccountType;
/*     */   @XmlElement(name="TotalNoSFAccountType")
/*     */   protected String totalNoSFAccountType;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  48 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/*  52 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getCurrencyCd()
/*     */   {
/*  57 */     return this.currencyCd;
/*     */   }
/*     */   
/*     */   public void setCurrencyCd(String value)
/*     */   {
/*  62 */     this.currencyCd = value;
/*     */   }
/*     */   
/*     */   public String getTotalNoFundedAccountType()
/*     */   {
/*  67 */     return this.totalNoFundedAccountType;
/*     */   }
/*     */   
/*     */   public void setTotalNoFundedAccountType(String value)
/*     */   {
/*  72 */     this.totalNoFundedAccountType = value;
/*     */   }
/*     */   
/*     */   public String getTotalNoNonFundedAccountType()
/*     */   {
/*  77 */     return this.totalNoNonFundedAccountType;
/*     */   }
/*     */   
/*     */   public void setTotalNoNonFundedAccountType(String value)
/*     */   {
/*  82 */     this.totalNoNonFundedAccountType = value;
/*     */   }
/*     */   
/*     */   public String getTotalNoShortTermAccountType()
/*     */   {
/*  87 */     return this.totalNoShortTermAccountType;
/*     */   }
/*     */   
/*     */   public void setTotalNoShortTermAccountType(String value)
/*     */   {
/*  92 */     this.totalNoShortTermAccountType = value;
/*     */   }
/*     */   
/*     */   public String getTotalNoLongTermAccountType()
/*     */   {
/*  97 */     return this.totalNoLongTermAccountType;
/*     */   }
/*     */   
/*     */   public void setTotalNoLongTermAccountType(String value)
/*     */   {
/* 102 */     this.totalNoLongTermAccountType = value;
/*     */   }
/*     */   
/*     */   public String getTotalNoWDAccountType()
/*     */   {
/* 107 */     return this.totalNoWDAccountType;
/*     */   }
/*     */   
/*     */   public void setTotalNoWDAccountType(String value)
/*     */   {
/* 112 */     this.totalNoWDAccountType = value;
/*     */   }
/*     */   
/*     */   public String getTotalNoSFAccountType()
/*     */   {
/* 117 */     return this.totalNoSFAccountType;
/*     */   }
/*     */   
/*     */   public void setTotalNoSFAccountType(String value)
/*     */   {
/* 122 */     this.totalNoSFAccountType = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Currcycnct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */