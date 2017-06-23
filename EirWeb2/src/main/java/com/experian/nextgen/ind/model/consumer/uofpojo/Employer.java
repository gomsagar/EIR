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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Employer", propOrder={"segmentCode", "occupationCode", "netMontlyIncome", "occYearsEmployed", "occMonthsEmployed"})
/*     */ public class Employer
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="OccupationCode")
/*     */   protected String occupationCode;
/*     */   @XmlElement(name="NetMontlyIncome")
/*     */   protected String netMontlyIncome;
/*     */   @XmlElement(name="OccYearsEmployed")
/*     */   protected String occYearsEmployed;
/*     */   @XmlElement(name="OccMonthsEmployed")
/*     */   protected String occMonthsEmployed;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  88 */     return this.segmentCode;
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
/* 100 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getOccupationCode() {
/* 104 */     return this.occupationCode;
/*     */   }
/*     */   
/*     */   public void setOccupationCode(String occupationCode) {
/* 108 */     this.occupationCode = occupationCode;
/*     */   }
/*     */   
/*     */   public String getNetMontlyIncome() {
/* 112 */     return this.netMontlyIncome;
/*     */   }
/*     */   
/*     */   public void setNetMontlyIncome(String netMontlyIncome) {
/* 116 */     this.netMontlyIncome = netMontlyIncome;
/*     */   }
/*     */   
/*     */   public String getOccYearsEmployed() {
/* 120 */     return this.occYearsEmployed;
/*     */   }
/*     */   
/*     */   public void setOccYearsEmployed(String occYearsEmployed) {
/* 124 */     this.occYearsEmployed = occYearsEmployed;
/*     */   }
/*     */   
/*     */   public String getOccMonthsEmployed() {
/* 128 */     return this.occMonthsEmployed;
/*     */   }
/*     */   
/*     */   public void setOccMonthsEmployed(String occMonthsEmployed) {
/* 132 */     this.occMonthsEmployed = occMonthsEmployed;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Employer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */