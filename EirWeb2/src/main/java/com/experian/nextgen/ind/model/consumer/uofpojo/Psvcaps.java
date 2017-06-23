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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Psvcaps", propOrder={"segmentCode", "bfhlCAPSLast90Days", "mfCAPSLast90Days", "telcosCAPSLast90Days", "retailCAPSLast90Days"})
/*     */ public class Psvcaps
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="BFHL_CAPS_Last_90_Days")
/*     */   protected String bfhlCAPSLast90Days;
/*     */   @XmlElement(name="MF_CAPS_Last_90_Days")
/*     */   protected String mfCAPSLast90Days;
/*     */   @XmlElement(name="Telcos_CAPS_Last_90_Days")
/*     */   protected String telcosCAPSLast90Days;
/*     */   @XmlElement(name="Retail_CAPS_Last_90_Days")
/*     */   protected String retailCAPSLast90Days;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 100 */     return this.segmentCode;
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
/* 112 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBfhlCAPSLast90Days()
/*     */   {
/* 124 */     return this.bfhlCAPSLast90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBfhlCAPSLast90Days(String value)
/*     */   {
/* 136 */     this.bfhlCAPSLast90Days = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMfCAPSLast90Days()
/*     */   {
/* 148 */     return this.mfCAPSLast90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMfCAPSLast90Days(String value)
/*     */   {
/* 160 */     this.mfCAPSLast90Days = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTelcosCAPSLast90Days()
/*     */   {
/* 172 */     return this.telcosCAPSLast90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTelcosCAPSLast90Days(String value)
/*     */   {
/* 184 */     this.telcosCAPSLast90Days = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRetailCAPSLast90Days()
/*     */   {
/* 196 */     return this.retailCAPSLast90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRetailCAPSLast90Days(String value)
/*     */   {
/* 208 */     this.retailCAPSLast90Days = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Psvcaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */