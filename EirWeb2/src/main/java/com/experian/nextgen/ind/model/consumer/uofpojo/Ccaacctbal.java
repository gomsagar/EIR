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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Ccaacctbal", propOrder={"segmentCode", "totDefaultBalance", "totOutstandingBalance", "totSecuredBalance", "percSecuredBalance", "totUnSecuredBalance", "percUnSecuredBalance", "percSFWDWOSTLAccnts"})
/*     */ public class Ccaacctbal
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TotDefaultBalance")
/*     */   protected String totDefaultBalance;
/*     */   @XmlElement(name="TotOutstandingBalance")
/*     */   protected String totOutstandingBalance;
/*     */   @XmlElement(name="TotSecuredBalance")
/*     */   protected String totSecuredBalance;
/*     */   @XmlElement(name="PercSecuredBalance")
/*     */   protected String percSecuredBalance;
/*     */   @XmlElement(name="TotUnSecuredBalance")
/*     */   protected String totUnSecuredBalance;
/*     */   @XmlElement(name="PercUnSecuredBalance")
/*     */   protected String percUnSecuredBalance;
/*     */   @XmlElement(name="PercSFWDWOSTLAccnts")
/*     */   protected String percSFWDWOSTLAccnts;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 130 */     return this.segmentCode;
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
/* 142 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotDefaultBalance()
/*     */   {
/* 154 */     return this.totDefaultBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotDefaultBalance(String value)
/*     */   {
/* 166 */     this.totDefaultBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotOutstandingBalance()
/*     */   {
/* 178 */     return this.totOutstandingBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotOutstandingBalance(String value)
/*     */   {
/* 190 */     this.totOutstandingBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotSecuredBalance()
/*     */   {
/* 202 */     return this.totSecuredBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotSecuredBalance(String value)
/*     */   {
/* 214 */     this.totSecuredBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPercSecuredBalance()
/*     */   {
/* 226 */     return this.percSecuredBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPercSecuredBalance(String value)
/*     */   {
/* 238 */     this.percSecuredBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotUnSecuredBalance()
/*     */   {
/* 250 */     return this.totUnSecuredBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotUnSecuredBalance(String value)
/*     */   {
/* 262 */     this.totUnSecuredBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPercUnSecuredBalance()
/*     */   {
/* 274 */     return this.percUnSecuredBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPercUnSecuredBalance(String value)
/*     */   {
/* 286 */     this.percUnSecuredBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPercSFWDWOSTLAccnts()
/*     */   {
/* 298 */     return this.percSFWDWOSTLAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPercSFWDWOSTLAccnts(String value)
/*     */   {
/* 310 */     this.percSFWDWOSTLAccnts = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Ccaacctbal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */