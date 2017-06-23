/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Credtype", propOrder={"segmentCode", "currencyCd", "totalCurrentBalance", "totalCreditTypeNo", "pctTotalStandardCreditType", "pctTotalSubStandardCreditType", "pctTotalDoubtfulCreditType", "pctTotalLossCreditType", "pctTotalSpecMentionCreditType", "AccTypeInfo"})
/*     */ public class Credtype
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
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
/*     */   @XmlElement(name="ACCTYPINFO")
/*     */   protected List<Acctypinfo> AccTypeInfo;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  58 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public List<Acctypinfo> getAccTypeInfo()
/*     */   {
/*  63 */     return this.AccTypeInfo;
/*     */   }
/*     */   
/*     */   public void setAccTypeInfo(List<Acctypinfo> accTypeInfo)
/*     */   {
/*  68 */     this.AccTypeInfo = accTypeInfo;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  73 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getCurrencyCd()
/*     */   {
/*  78 */     return this.currencyCd;
/*     */   }
/*     */   
/*     */   public void setCurrencyCd(String value)
/*     */   {
/*  83 */     this.currencyCd = value;
/*     */   }
/*     */   
/*     */   public String getTotalCurrentBalance()
/*     */   {
/*  88 */     return this.totalCurrentBalance;
/*     */   }
/*     */   
/*     */   public void setTotalCurrentBalance(String value)
/*     */   {
/*  93 */     this.totalCurrentBalance = value;
/*     */   }
/*     */   
/*     */   public String getTotalCreditTypeNo()
/*     */   {
/*  98 */     return this.totalCreditTypeNo;
/*     */   }
/*     */   
/*     */   public void setTotalCreditTypeNo(String value)
/*     */   {
/* 103 */     this.totalCreditTypeNo = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalStandardCreditType()
/*     */   {
/* 108 */     return this.pctTotalStandardCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalStandardCreditType(String value)
/*     */   {
/* 113 */     this.pctTotalStandardCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalSubStandardCreditType()
/*     */   {
/* 118 */     return this.pctTotalSubStandardCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalSubStandardCreditType(String value)
/*     */   {
/* 123 */     this.pctTotalSubStandardCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalDoubtfulCreditType()
/*     */   {
/* 128 */     return this.pctTotalDoubtfulCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalDoubtfulCreditType(String value)
/*     */   {
/* 133 */     this.pctTotalDoubtfulCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalLossCreditType()
/*     */   {
/* 138 */     return this.pctTotalLossCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalLossCreditType(String value)
/*     */   {
/* 143 */     this.pctTotalLossCreditType = value;
/*     */   }
/*     */   
/*     */   public String getPctTotalSpecMentionCreditType()
/*     */   {
/* 148 */     return this.pctTotalSpecMentionCreditType;
/*     */   }
/*     */   
/*     */   public void setPctTotalSpecMentionCreditType(String value)
/*     */   {
/* 153 */     this.pctTotalSpecMentionCreditType = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Credtype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */