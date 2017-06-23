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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="BPayGrid", propOrder={"segmentCode", "timePeriodInd", "year", "weekNumber", "monthvalue", "paymentStatusValue", "daysPastDue", "assetClassification", "hDetails"})
/*     */ public class BPayGrid
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TimePeriodInd")
/*     */   protected String timePeriodInd;
/*     */   @XmlElement(name="Year")
/*     */   protected String year;
/*     */   @XmlElement(name="WeekNumber")
/*     */   protected String weekNumber;
/*     */   @XmlElement(name="Monthvalue")
/*     */   protected String monthvalue;
/*     */   @XmlElement(name="PaymentStatusValue")
/*     */   protected String paymentStatusValue;
/*     */   @XmlElement(name="DaysPastDue")
/*     */   protected String daysPastDue;
/*     */   @XmlElement(name="AssetClassification")
/*     */   protected String assetClassification;
/*     */   @XmlElement(name="HDETAILS")
/*     */   protected Hdetails hDetails;
/*     */   
/*     */   public String getDaysPastDue()
/*     */   {
/*  53 */     return this.daysPastDue;
/*     */   }
/*     */   
/*     */   public void setDaysPastDue(String daysPastDue)
/*     */   {
/*  58 */     this.daysPastDue = daysPastDue;
/*     */   }
/*     */   
/*     */   public String getAssetClassification()
/*     */   {
/*  63 */     return this.assetClassification;
/*     */   }
/*     */   
/*     */   public void setAssetClassification(String assetClassification)
/*     */   {
/*  68 */     this.assetClassification = assetClassification;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Hdetails gethDetails()
/*     */   {
/*  76 */     return this.hDetails;
/*     */   }
/*     */   
/*     */   public void sethDetails(Hdetails hDetails)
/*     */   {
/*  81 */     this.hDetails = hDetails;
/*     */   }
/*     */   
/*  84 */   public String getSegmentCode() { return this.segmentCode; }
/*     */   
/*     */ 
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  89 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getTimePeriodInd()
/*     */   {
/*  94 */     return this.timePeriodInd;
/*     */   }
/*     */   
/*     */   public void setTimePeriodInd(String value)
/*     */   {
/*  99 */     this.timePeriodInd = value;
/*     */   }
/*     */   
/*     */   public String getYear()
/*     */   {
/* 104 */     return this.year;
/*     */   }
/*     */   
/*     */   public void setYear(String value)
/*     */   {
/* 109 */     this.year = value;
/*     */   }
/*     */   
/*     */   public String getWeekNumber()
/*     */   {
/* 114 */     return this.weekNumber;
/*     */   }
/*     */   
/*     */   public void setWeekNumber(String value)
/*     */   {
/* 119 */     this.weekNumber = value;
/*     */   }
/*     */   
/*     */   public String getMonthvalue()
/*     */   {
/* 124 */     return this.monthvalue;
/*     */   }
/*     */   
/*     */   public void setMonthvalue(String value)
/*     */   {
/* 129 */     this.monthvalue = value;
/*     */   }
/*     */   
/*     */   public String getPaymentStatusValue()
/*     */   {
/* 134 */     return this.paymentStatusValue;
/*     */   }
/*     */   
/*     */   public void setPaymentStatusValue(String value)
/*     */   {
/* 139 */     this.paymentStatusValue = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BPayGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */