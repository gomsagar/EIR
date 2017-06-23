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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Asclatrend", propOrder={"segmentCode", "standardWorstAssetClass", "nonStandardWorstAssetClass", "closedWorstAssetClass"})
/*    */ public class Asclatrend
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="StandardWorstAssetClass")
/*    */   protected String standardWorstAssetClass;
/*    */   @XmlElement(name="NonStandardWorstAssetClass")
/*    */   protected String nonStandardWorstAssetClass;
/*    */   @XmlElement(name="ClosedWorstAssetClass")
/*    */   protected String closedWorstAssetClass;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 35 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value) {
/* 39 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getStandardWorstAssetClass() {
/* 43 */     return this.standardWorstAssetClass;
/*    */   }
/*    */   
/*    */   public void setStandardWorstAssetClass(String value) {
/* 47 */     this.standardWorstAssetClass = value;
/*    */   }
/*    */   
/*    */   public String getNonStandardWorstAssetClass() {
/* 51 */     return this.nonStandardWorstAssetClass;
/*    */   }
/*    */   
/*    */   public void setNonStandardWorstAssetClass(String value) {
/* 55 */     this.nonStandardWorstAssetClass = value;
/*    */   }
/*    */   
/*    */   public String getClosedWorstAssetClass() {
/* 59 */     return this.closedWorstAssetClass;
/*    */   }
/*    */   
/*    */   public void setClosedWorstAssetClass(String value) {
/* 63 */     this.closedWorstAssetClass = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Asclatrend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */