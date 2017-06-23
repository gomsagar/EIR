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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Acctcnt", propOrder={"segmentCode", "noCreditAccount", "noNonStandardOpenCredit", "noStandardOpenCredit", "noClosedCredit"})
/*    */ public class Acctcnt
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="NoCreditAccount")
/*    */   protected String noCreditAccount;
/*    */   @XmlElement(name="NoNonStandardOpenCredit")
/*    */   protected String noNonStandardOpenCredit;
/*    */   @XmlElement(name="NoStandardOpenCredit")
/*    */   protected String noStandardOpenCredit;
/*    */   @XmlElement(name="NoClosedCredit")
/*    */   protected String noClosedCredit;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 39 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 44 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getNoCreditAccount() {
/* 48 */     return this.noCreditAccount;
/*    */   }
/*    */   
/*    */   public void setNoCreditAccount(String value) {
/* 52 */     this.noCreditAccount = value;
/*    */   }
/*    */   
/*    */   public String getNoNonStandardOpenCredit() {
/* 56 */     return this.noNonStandardOpenCredit;
/*    */   }
/*    */   
/*    */   public void setNoNonStandardOpenCredit(String value) {
/* 60 */     this.noNonStandardOpenCredit = value;
/*    */   }
/*    */   
/*    */   public String getNoStandardOpenCredit() {
/* 64 */     return this.noStandardOpenCredit;
/*    */   }
/*    */   
/*    */   public void setNoStandardOpenCredit(String value) {
/* 68 */     this.noStandardOpenCredit = value;
/*    */   }
/*    */   
/* 71 */   public String getNoClosedCredit() { return this.noClosedCredit; }
/*    */   
/*    */   public void setNoClosedCredit(String value)
/*    */   {
/* 75 */     this.noClosedCredit = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Acctcnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */