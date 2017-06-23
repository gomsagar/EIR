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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Bpaygrid", propOrder={"segmentCode", "timePeriodInd", "year", "weekNumber", "monthvalue", "paymentStatusValue", "daysPastDue", "assetClassification", "worstAccountStatusValue", "hdetails"})
/*     */ public class Bpaygrid
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
/*     */   @XmlElement(name="WorstAccountStatusValue")
/*     */   protected String worstAccountStatusValue;
/*     */   @XmlElement(name="HDETAILS")
/*     */   protected Hdetails hdetails;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 137 */     return this.segmentCode;
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
/* 149 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTimePeriodInd()
/*     */   {
/* 161 */     return this.timePeriodInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTimePeriodInd(String value)
/*     */   {
/* 173 */     this.timePeriodInd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getYear()
/*     */   {
/* 185 */     return this.year;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYear(String value)
/*     */   {
/* 197 */     this.year = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWeekNumber()
/*     */   {
/* 209 */     return this.weekNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWeekNumber(String value)
/*     */   {
/* 221 */     this.weekNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMonthvalue()
/*     */   {
/* 233 */     return this.monthvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMonthvalue(String value)
/*     */   {
/* 245 */     this.monthvalue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPaymentStatusValue()
/*     */   {
/* 257 */     return this.paymentStatusValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaymentStatusValue(String value)
/*     */   {
/* 269 */     this.paymentStatusValue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDaysPastDue()
/*     */   {
/* 281 */     return this.daysPastDue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDaysPastDue(String value)
/*     */   {
/* 293 */     this.daysPastDue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWorstAccountStatusValue()
/*     */   {
/* 305 */     return this.worstAccountStatusValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWorstAccountStatusValue(String value)
/*     */   {
/* 317 */     this.worstAccountStatusValue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Hdetails getHDETAILS()
/*     */   {
/* 329 */     return this.hdetails;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHDETAILS(Hdetails value)
/*     */   {
/* 341 */     this.hdetails = value;
/*     */   }
/*     */   
/*     */   public String getAssetClassification() {
/* 345 */     return this.assetClassification;
/*     */   }
/*     */   
/*     */   public void setAssetClassification(String assetClassification) {
/* 349 */     this.assetClassification = assetClassification;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Bpaygrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */