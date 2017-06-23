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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Bfhlicaxhl", propOrder={"segmentCode", "tnOfNDelBFHLInACAExHL", "tnOfDelBFHLInACAExHL"})
/*     */ public class Bfhlicaxhl
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_NDel_BFHL_InACA_Ex_HL")
/*     */   protected String tnOfNDelBFHLInACAExHL;
/*     */   @XmlElement(name="TN_of_Del_BFHL_InACA_Ex_HL")
/*     */   protected String tnOfDelBFHLInACAExHL;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  80 */     return this.segmentCode;
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
/*  92 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfNDelBFHLInACAExHL()
/*     */   {
/* 104 */     return this.tnOfNDelBFHLInACAExHL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfNDelBFHLInACAExHL(String value)
/*     */   {
/* 116 */     this.tnOfNDelBFHLInACAExHL = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfDelBFHLInACAExHL()
/*     */   {
/* 128 */     return this.tnOfDelBFHLInACAExHL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfDelBFHLInACAExHL(String value)
/*     */   {
/* 140 */     this.tnOfDelBFHLInACAExHL = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Bfhlicaxhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */