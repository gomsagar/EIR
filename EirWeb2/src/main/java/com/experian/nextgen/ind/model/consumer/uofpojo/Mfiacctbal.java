/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Mfiacctbal", propOrder={"segmentCode", "totBalanceAllAccounts", "totBalanceActiveAccounts", "totAmtOverdue", "totWrittenOffAmt", "totSanctionedAmt", "totDisbursedAmt"})
/*     */ public class Mfiacctbal
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TotBalanceAllAccounts")
/*     */   protected String totBalanceAllAccounts;
/*     */   @XmlElement(name="TotBalanceActiveAccounts")
/*     */   protected String totBalanceActiveAccounts;
/*     */   @XmlElement(name="TotAmtOverdue")
/*     */   protected String totAmtOverdue;
/*     */   @XmlElement(name="TotWrittenOffAmt")
/*     */   protected String totWrittenOffAmt;
/*     */   @XmlElement(name="TotSanctionedAmt")
/*     */   protected String totSanctionedAmt;
/*     */   @XmlElement(name="TotDisbursedAmt")
/*     */   protected String totDisbursedAmt;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 120 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSegmentCode(String value)
/*     */   {
/* 132 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotBalanceAllAccounts()
/*     */   {
/* 144 */     return this.totBalanceAllAccounts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotBalanceAllAccounts(String value)
/*     */   {
/* 156 */     this.totBalanceAllAccounts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotBalanceActiveAccounts()
/*     */   {
/* 168 */     return this.totBalanceActiveAccounts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotBalanceActiveAccounts(String value)
/*     */   {
/* 180 */     this.totBalanceActiveAccounts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotAmtOverdue()
/*     */   {
/* 192 */     return this.totAmtOverdue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotAmtOverdue(String value)
/*     */   {
/* 204 */     this.totAmtOverdue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotWrittenOffAmt()
/*     */   {
/* 216 */     return this.totWrittenOffAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotWrittenOffAmt(String value)
/*     */   {
/* 228 */     this.totWrittenOffAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotSanctionedAmt()
/*     */   {
/* 240 */     return this.totSanctionedAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotSanctionedAmt(String value)
/*     */   {
/* 252 */     this.totSanctionedAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotDisbursedAmt()
/*     */   {
/* 264 */     return this.totDisbursedAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotDisbursedAmt(String value)
/*     */   {
/* 276 */     this.totDisbursedAmt = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Mfiacctbal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */