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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Creditor", propOrder={"segmentCode", "creditorIndustryCd", "creditorName"})
/*    */ public class Creditor
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="CreditorIndustryCd")
/*    */   protected String creditorIndustryCd;
/*    */   @XmlElement(name="CreditorName")
/*    */   protected String creditorName;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 25 */     return this.segmentCode;
/*    */   }
/*    */   
/* 28 */   public void setSegmentCode(String segmentCode) { this.segmentCode = segmentCode; }
/*    */   
/*    */   public String getCreditorIndustryCd() {
/* 31 */     return this.creditorIndustryCd;
/*    */   }
/*    */   
/* 34 */   public void setCreditorIndustryCd(String creditorIndustryCd) { this.creditorIndustryCd = creditorIndustryCd; }
/*    */   
/*    */   public String getCreditorName() {
/* 37 */     return this.creditorName;
/*    */   }
/*    */   
/* 40 */   public void setCreditorName(String creditorName) { this.creditorName = creditorName; }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Creditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */