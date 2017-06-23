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
/*    */ @XmlType(name="TotAccCnt", propOrder={"segmentCode", "totalCreditAccount", "totalStandardOpenCredit", "totalNonStandardOpenCredit", "totalClosedCredit"})
/*    */ public class TotAccCnt
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="TotalCreditAccount")
/*    */   protected String totalCreditAccount;
/*    */   @XmlElement(name="TotalStandardOpenCredit")
/*    */   protected String totalStandardOpenCredit;
/*    */   @XmlElement(name="TotalNonStandardOpenCredit")
/*    */   protected String totalNonStandardOpenCredit;
/*    */   @XmlElement(name="TotalClosedCredit")
/*    */   protected String totalClosedCredit;
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
/*    */   public String getTotalCreditAccount()
/*    */   {
/* 51 */     return this.totalCreditAccount;
/*    */   }
/*    */   
/*    */   public void setTotalCreditAccount(String value)
/*    */   {
/* 56 */     this.totalCreditAccount = value;
/*    */   }
/*    */   
/*    */   public String getTotalStandardOpenCredit()
/*    */   {
/* 61 */     return this.totalStandardOpenCredit;
/*    */   }
/*    */   
/*    */   public void setTotalStandardOpenCredit(String value)
/*    */   {
/* 66 */     this.totalStandardOpenCredit = value;
/*    */   }
/*    */   
/*    */   public String getTotalNonStandardOpenCredit()
/*    */   {
/* 71 */     return this.totalNonStandardOpenCredit;
/*    */   }
/*    */   
/*    */   public void setTotalNonStandardOpenCredit(String value)
/*    */   {
/* 76 */     this.totalNonStandardOpenCredit = value;
/*    */   }
/*    */   
/*    */   public String getTotalClosedCredit()
/*    */   {
/* 81 */     return this.totalClosedCredit;
/*    */   }
/*    */   
/*    */   public void setTotalClosedCredit(String value)
/*    */   {
/* 86 */     this.totalClosedCredit = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\TotAccCnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */