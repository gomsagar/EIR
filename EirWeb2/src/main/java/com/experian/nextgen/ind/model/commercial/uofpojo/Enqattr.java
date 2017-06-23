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
/*     */ @XmlType(name="Enqattr", propOrder={"segmentCode", "mostRecentEnqDate", "totEnq", "totEnq7Days", "totEnq30Days", "totEnq90Days", "totEnq180Days"})
/*     */ public class Enqattr
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="MostRecentEnqDate")
/*     */   protected String mostRecentEnqDate;
/*     */   @XmlElement(name="TotEnq")
/*     */   protected String totEnq;
/*     */   @XmlElement(name="TotEnq7days")
/*     */   protected String totEnq7Days;
/*     */   @XmlElement(name="TotEnq30days")
/*     */   protected String totEnq30Days;
/*     */   @XmlElement(name="TotEnq90days")
/*     */   protected String totEnq90Days;
/*     */   @XmlElement(name="TotEnq180days")
/*     */   protected String totEnq180Days;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  46 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  51 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getMostRecentEnqDate()
/*     */   {
/*  56 */     return this.mostRecentEnqDate;
/*     */   }
/*     */   
/*     */   public void setMostRecentEnqDate(String value)
/*     */   {
/*  61 */     this.mostRecentEnqDate = value;
/*     */   }
/*     */   
/*     */   public String getTotEnq()
/*     */   {
/*  66 */     return this.totEnq;
/*     */   }
/*     */   
/*     */   public void setTotEnq(String value)
/*     */   {
/*  71 */     this.totEnq = value;
/*     */   }
/*     */   
/*     */   public String getTotEnq7Days()
/*     */   {
/*  76 */     return this.totEnq7Days;
/*     */   }
/*     */   
/*     */   public void setTotEnq7Days(String value)
/*     */   {
/*  81 */     this.totEnq7Days = value;
/*     */   }
/*     */   
/*     */   public String getTotEnq30Days()
/*     */   {
/*  86 */     return this.totEnq30Days;
/*     */   }
/*     */   
/*     */   public void setTotEnq30Days(String value)
/*     */   {
/*  91 */     this.totEnq30Days = value;
/*     */   }
/*     */   
/*     */   public String getTotEnq90Days()
/*     */   {
/*  96 */     return this.totEnq90Days;
/*     */   }
/*     */   
/*     */   public void setTotEnq90Days(String value)
/*     */   {
/* 101 */     this.totEnq90Days = value;
/*     */   }
/*     */   
/*     */   public String getTotEnq180Days()
/*     */   {
/* 106 */     return this.totEnq180Days;
/*     */   }
/*     */   
/*     */   public void setTotEnq180Days(String value) {
/* 110 */     this.totEnq180Days = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Enqattr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */