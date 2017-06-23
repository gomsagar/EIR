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
/*    */ @XmlType(name="Grantor", propOrder={"segmentCode", "totalCreditProviders", "currentCreditProviders", "totalSameCreditProviders", "totalOtherCreditProviders"})
/*    */ public class Grantor
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="TotalCreditProviders")
/*    */   protected String totalCreditProviders;
/*    */   @XmlElement(name="CurrentCreditProviders")
/*    */   protected String currentCreditProviders;
/*    */   @XmlElement(name="TotalSameCreditProviders")
/*    */   protected String totalSameCreditProviders;
/*    */   @XmlElement(name="TotalOtherCreditProviders")
/*    */   protected String totalOtherCreditProviders;
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
/*    */   public String getTotalCreditProviders()
/*    */   {
/* 51 */     return this.totalCreditProviders;
/*    */   }
/*    */   
/*    */   public void setTotalCreditProviders(String value)
/*    */   {
/* 56 */     this.totalCreditProviders = value;
/*    */   }
/*    */   
/*    */   public String getCurrentCreditProviders()
/*    */   {
/* 61 */     return this.currentCreditProviders;
/*    */   }
/*    */   
/*    */   public void setCurrentCreditProviders(String value)
/*    */   {
/* 66 */     this.currentCreditProviders = value;
/*    */   }
/*    */   
/*    */   public String getTotalSameCreditProviders()
/*    */   {
/* 71 */     return this.totalSameCreditProviders;
/*    */   }
/*    */   
/*    */   public void setTotalSameCreditProviders(String value)
/*    */   {
/* 76 */     this.totalSameCreditProviders = value;
/*    */   }
/*    */   
/*    */   public String getTotalOtherCreditProviders()
/*    */   {
/* 81 */     return this.totalOtherCreditProviders;
/*    */   }
/*    */   
/*    */   public void setTotalOtherCreditProviders(String value)
/*    */   {
/* 86 */     this.totalOtherCreditProviders = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Grantor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */