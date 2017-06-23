/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Guaranto", propOrder={"segmentCode", "totalGuarantors"})
/*    */ public class Guaranto
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="TotalGuarantors")
/*    */   protected String totalGuarantors;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 32 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 37 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getTotalGuarantors()
/*    */   {
/* 42 */     return this.totalGuarantors;
/*    */   }
/*    */   
/*    */   public void setTotalGuarantors(String value)
/*    */   {
/* 47 */     this.totalGuarantors = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Guaranto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */