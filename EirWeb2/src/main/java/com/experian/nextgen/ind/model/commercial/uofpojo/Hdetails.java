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
/*    */ @XmlType(name="Hdetails", propOrder={"segmentCode", "balanceAmt"})
/*    */ public class Hdetails
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="BalanceAmt")
/*    */   protected String balanceAmt;
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
/*    */   public String getBalanceAmt()
/*    */   {
/* 42 */     return this.balanceAmt;
/*    */   }
/*    */   
/*    */   public void setBalanceAmt(String value)
/*    */   {
/* 47 */     this.balanceAmt = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Hdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */