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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Vintage", propOrder={"segmentCode", "totStdAccounts", "totNonStdAccounts", "totClosedAccnts"})
/*    */ public class Vintage
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="TotStdAccounts")
/*    */   protected String totStdAccounts;
/*    */   @XmlElement(name="TotNonStdAccounts")
/*    */   protected String totNonStdAccounts;
/*    */   @XmlElement(name="TotClosedAccnts")
/*    */   protected String totClosedAccnts;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 38 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 43 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getTotStdAccounts()
/*    */   {
/* 48 */     return this.totStdAccounts;
/*    */   }
/*    */   
/*    */   public void setTotStdAccounts(String value)
/*    */   {
/* 53 */     this.totStdAccounts = value;
/*    */   }
/*    */   
/*    */   public String getTotNonStdAccounts()
/*    */   {
/* 58 */     return this.totNonStdAccounts;
/*    */   }
/*    */   
/*    */   public void setTotNonStdAccounts(String value)
/*    */   {
/* 63 */     this.totNonStdAccounts = value;
/*    */   }
/*    */   
/*    */   public String getTotClosedAccnts()
/*    */   {
/* 68 */     return this.totClosedAccnts;
/*    */   }
/*    */   
/*    */   public void setTotClosedAccnts(String value)
/*    */   {
/* 73 */     this.totClosedAccnts = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Vintage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */