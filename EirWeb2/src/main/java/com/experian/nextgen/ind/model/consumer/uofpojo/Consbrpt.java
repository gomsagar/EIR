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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Consbrpt", propOrder={"segmentCode", "burProductSearchResultCd", "burProductHitNoHitInd", "burProductValueAddInd", "burRptNum", "burRptTitle", "burRptDate", "burRptTime", "burRptLanguageCd", "burRptAmtCurrencyCd"})
/*     */ public class Consbrpt
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="BurProductSearchResultCd")
/*     */   protected String burProductSearchResultCd;
/*     */   @XmlElement(name="BurProductHitNoHitInd")
/*     */   protected String burProductHitNoHitInd;
/*     */   @XmlElement(name="BurProductValueAddInd")
/*     */   protected String burProductValueAddInd;
/*     */   @XmlElement(name="BurRptNum")
/*     */   protected String burRptNum;
/*     */   @XmlElement(name="BurRptTitle")
/*     */   protected String burRptTitle;
/*     */   @XmlElement(name="BurRptDate")
/*     */   protected String burRptDate;
/*     */   @XmlElement(name="BurRptTime")
/*     */   protected String burRptTime;
/*     */   @XmlElement(name="BurRptLanguageCd")
/*     */   protected String burRptLanguageCd;
/*     */   @XmlElement(name="BurRptAmtCurrencyCd")
/*     */   protected String burRptAmtCurrencyCd;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 150 */     return this.segmentCode;
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
/* 162 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurProductSearchResultCd()
/*     */   {
/* 174 */     return this.burProductSearchResultCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurProductSearchResultCd(String value)
/*     */   {
/* 186 */     this.burProductSearchResultCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurProductHitNoHitInd()
/*     */   {
/* 198 */     return this.burProductHitNoHitInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurProductHitNoHitInd(String value)
/*     */   {
/* 210 */     this.burProductHitNoHitInd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurProductValueAddInd()
/*     */   {
/* 222 */     return this.burProductValueAddInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurProductValueAddInd(String value)
/*     */   {
/* 234 */     this.burProductValueAddInd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurRptNum()
/*     */   {
/* 246 */     return this.burRptNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurRptNum(String value)
/*     */   {
/* 258 */     this.burRptNum = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurRptTitle()
/*     */   {
/* 270 */     return this.burRptTitle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurRptTitle(String value)
/*     */   {
/* 282 */     this.burRptTitle = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurRptDate()
/*     */   {
/* 294 */     return this.burRptDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurRptDate(String value)
/*     */   {
/* 306 */     this.burRptDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurRptTime()
/*     */   {
/* 318 */     return this.burRptTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurRptTime(String value)
/*     */   {
/* 330 */     this.burRptTime = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurRptLanguageCd()
/*     */   {
/* 342 */     return this.burRptLanguageCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurRptLanguageCd(String value)
/*     */   {
/* 354 */     this.burRptLanguageCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBurRptAmtCurrencyCd()
/*     */   {
/* 366 */     return this.burRptAmtCurrencyCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBurRptAmtCurrencyCd(String value)
/*     */   {
/* 378 */     this.burRptAmtCurrencyCd = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Consbrpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */