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
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Bhistory", propOrder={"segmentCode", "countStdAssetClassification", "countSubStdAssetClassification", "countDoubtfulAssetClassification", "countLossAssetClassification"})
/*    */ public class Bhistory
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="CountStdAssetClassification", required=true, nillable=true)
/*    */   protected String countStdAssetClassification;
/*    */   @XmlElement(name="CountSubStdAssetClassification", required=true, nillable=true)
/*    */   protected String countSubStdAssetClassification;
/*    */   @XmlElement(name="CountDoubtfulAssetClassification", required=true, nillable=true)
/*    */   protected String countDoubtfulAssetClassification;
/*    */   @XmlElement(name="CountLossAssetClassification", required=true, nillable=true)
/*    */   protected String countLossAssetClassification;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 41 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 46 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getCountStdAssetClassification() {
/* 50 */     return this.countStdAssetClassification;
/*    */   }
/*    */   
/*    */   public void setCountStdAssetClassification(String value) {
/* 54 */     this.countStdAssetClassification = value;
/*    */   }
/*    */   
/*    */   public String getCountSubStdAssetClassification()
/*    */   {
/* 59 */     return this.countSubStdAssetClassification;
/*    */   }
/*    */   
/*    */   public void setCountSubStdAssetClassification(String value) {
/* 63 */     this.countSubStdAssetClassification = value;
/*    */   }
/*    */   
/*    */   public String getCountDoubtfulAssetClassification() {
/* 67 */     return this.countDoubtfulAssetClassification;
/*    */   }
/*    */   
/*    */   public void setCountDoubtfulAssetClassification(String value) {
/* 71 */     this.countDoubtfulAssetClassification = value;
/*    */   }
/*    */   
/*    */   public String getCountLossAssetClassification() {
/* 75 */     return this.countLossAssetClassification;
/*    */   }
/*    */   
/*    */   public void setCountLossAssetClassification(String value) {
/* 79 */     this.countLossAssetClassification = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Bhistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */