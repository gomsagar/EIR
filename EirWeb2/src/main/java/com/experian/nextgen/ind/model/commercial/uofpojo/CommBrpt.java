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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="CommBrpt", propOrder={"segmentCode", "burProductSearchResultCd", "burProductHitNoHitInd", "burProductValueAddInd", "burRptNum", "burRptTitle", "burRptDate", "burRptTime", "burRptLanguageCd"})
/*     */ public class CommBrpt
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   private String segmentCode;
/*     */   @XmlElement(name="BurProductSearchResultCd")
/*     */   private String burProductSearchResultCd;
/*     */   @XmlElement(name="BurProductHitNoHitInd")
/*     */   private String burProductHitNoHitInd;
/*     */   @XmlElement(name="BurProductValueAddInd")
/*     */   private String burProductValueAddInd;
/*     */   @XmlElement(name="BurRptNum")
/*     */   private String burRptNum;
/*     */   @XmlElement(name="BurRptTitle")
/*     */   private String burRptTitle;
/*     */   @XmlElement(name="BurRptDate")
/*     */   private String burRptDate;
/*     */   @XmlElement(name="BurRptTime")
/*     */   private String burRptTime;
/*     */   @XmlElement(name="BurRptLanguageCd")
/*     */   private String burRptLanguageCd;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  62 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/*  66 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getBurProductSearchResultCd()
/*     */   {
/*  71 */     return this.burProductSearchResultCd;
/*     */   }
/*     */   
/*     */   public void setBurProductSearchResultCd(String value)
/*     */   {
/*  76 */     this.burProductSearchResultCd = value;
/*     */   }
/*     */   
/*     */   public String getBurProductHitNoHitInd()
/*     */   {
/*  81 */     return this.burProductHitNoHitInd;
/*     */   }
/*     */   
/*     */   public void setBurProductHitNoHitInd(String value)
/*     */   {
/*  86 */     this.burProductHitNoHitInd = value;
/*     */   }
/*     */   
/*     */   public String getBurProductValueAddInd()
/*     */   {
/*  91 */     return this.burProductValueAddInd;
/*     */   }
/*     */   
/*     */   public void setBurProductValueAddInd(String value)
/*     */   {
/*  96 */     this.burProductValueAddInd = value;
/*     */   }
/*     */   
/*     */   public String getBurRptNum()
/*     */   {
/* 101 */     return this.burRptNum;
/*     */   }
/*     */   
/*     */   public void setBurRptNum(String value)
/*     */   {
/* 106 */     this.burRptNum = value;
/*     */   }
/*     */   
/*     */   public String getBurRptTitle()
/*     */   {
/* 111 */     return this.burRptTitle;
/*     */   }
/*     */   
/*     */   public void setBurRptTitle(String value)
/*     */   {
/* 116 */     this.burRptTitle = value;
/*     */   }
/*     */   
/*     */   public String getBurRptDate()
/*     */   {
/* 121 */     return this.burRptDate;
/*     */   }
/*     */   
/*     */   public void setBurRptDate(String value)
/*     */   {
/* 126 */     this.burRptDate = value;
/*     */   }
/*     */   
/*     */   public String getBurRptTime()
/*     */   {
/* 131 */     return this.burRptTime;
/*     */   }
/*     */   
/*     */   public void setBurRptTime(String value)
/*     */   {
/* 136 */     this.burRptTime = value;
/*     */   }
/*     */   
/*     */   public String getBurRptLanguageCd()
/*     */   {
/* 141 */     return this.burRptLanguageCd;
/*     */   }
/*     */   
/*     */   public void setBurRptLanguageCd(String value)
/*     */   {
/* 146 */     this.burRptLanguageCd = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\CommBrpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */