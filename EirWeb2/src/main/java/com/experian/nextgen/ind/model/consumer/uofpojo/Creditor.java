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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Creditor", propOrder={"segmentCode", "creditorIndustryCd", "creditorName", "bureauMemberId", "creditorSubscriberCodeCBV2"})
/*     */ public class Creditor
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="CreditorIndustryCd")
/*     */   protected String creditorIndustryCd;
/*     */   @XmlElement(name="CreditorName")
/*     */   protected String creditorName;
/*     */   @XmlElement(name="BureauMemberId")
/*     */   protected String bureauMemberId;
/*     */   @XmlElement(name="CreditorSubscriberCodeCBV2")
/*     */   protected String creditorSubscriberCodeCBV2;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  87 */     return this.segmentCode;
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
/*  99 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditorIndustryCd()
/*     */   {
/* 111 */     return this.creditorIndustryCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditorIndustryCd(String value)
/*     */   {
/* 123 */     this.creditorIndustryCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditorName()
/*     */   {
/* 135 */     return this.creditorName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditorName(String value)
/*     */   {
/* 147 */     this.creditorName = value;
/*     */   }
/*     */   
/*     */   public String getCreditorSubscriberCodeCBV2() {
/* 151 */     return this.creditorSubscriberCodeCBV2;
/*     */   }
/*     */   
/*     */   public void setCreditorSubscriberCodeCBV2(String creditorSubscriberCodeCBV2) {
/* 155 */     this.creditorSubscriberCodeCBV2 = creditorSubscriberCodeCBV2;
/*     */   }
/*     */   
/*     */   public String getBureauMemberId() {
/* 159 */     return this.bureauMemberId;
/*     */   }
/*     */   
/*     */   public void setBureauMemberId(String bureauMemberId) {
/* 163 */     this.bureauMemberId = bureauMemberId;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Creditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */