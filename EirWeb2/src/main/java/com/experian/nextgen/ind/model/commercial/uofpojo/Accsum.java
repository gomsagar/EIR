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
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Accsum", propOrder={"segmentCode", "totalCreditAccount", "totalActiveAccounts", "totalClosedAccounts", "monthFirstToCredit", "yearFirstToCredit"})
/*    */ public class Accsum
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="TotalCreditAccount")
/*    */   protected String totalCreditAccount;
/*    */   @XmlElement(name="TotalActiveAccounts")
/*    */   protected String totalActiveAccounts;
/*    */   @XmlElement(name="TotalClosedAccounts")
/*    */   protected String totalClosedAccounts;
/*    */   @XmlElement(name="MonthFirstToCredit")
/*    */   protected String monthFirstToCredit;
/*    */   @XmlElement(name="YearFirstToCredit")
/*    */   protected String yearFirstToCredit;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 44 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 49 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getTotalCreditAccount()
/*    */   {
/* 54 */     return this.totalCreditAccount;
/*    */   }
/*    */   
/*    */   public void setTotalCreditAccount(String value)
/*    */   {
/* 59 */     this.totalCreditAccount = value;
/*    */   }
/*    */   
/*    */   public String getTotalActiveAccounts()
/*    */   {
/* 64 */     return this.totalActiveAccounts;
/*    */   }
/*    */   
/*    */   public void setTotalActiveAccounts(String value)
/*    */   {
/* 69 */     this.totalActiveAccounts = value;
/*    */   }
/*    */   
/*    */   public String getTotalClosedAccounts()
/*    */   {
/* 74 */     return this.totalClosedAccounts;
/*    */   }
/*    */   
/*    */   public void setTotalClosedAccounts(String value)
/*    */   {
/* 79 */     this.totalClosedAccounts = value;
/*    */   }
/*    */   
/*    */   public String getMonthFirstToCredit()
/*    */   {
/* 84 */     return this.monthFirstToCredit;
/*    */   }
/*    */   
/*    */   public void setMonthFirstToCredit(String value)
/*    */   {
/* 89 */     this.monthFirstToCredit = value;
/*    */   }
/*    */   
/*    */   public String getYearFirstToCredit()
/*    */   {
/* 94 */     return this.yearFirstToCredit;
/*    */   }
/*    */   
/*    */   public void setYearFirstToCredit(String value)
/*    */   {
/* 99 */     this.yearFirstToCredit = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Accsum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */