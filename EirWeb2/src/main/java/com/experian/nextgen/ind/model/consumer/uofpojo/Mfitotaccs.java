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
/*     */ @XmlType(name="Mfitotaccs", propOrder={"segmentCode", "totAccnts", "totActiveAccnts", "totClosedAccnts", "totWOAccnts", "totPastDueAccnts", "insuredAccnts", "uninsuredAccnts"})
/*     */ public class Mfitotaccs
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TotAccnts")
/*     */   protected String totAccnts;
/*     */   @XmlElement(name="TotActiveAccnts")
/*     */   protected String totActiveAccnts;
/*     */   @XmlElement(name="TotClosedAccnts")
/*     */   protected String totClosedAccnts;
/*     */   @XmlElement(name="TotWOAccnts")
/*     */   protected String totWOAccnts;
/*     */   @XmlElement(name="TotPastDueAccnts")
/*     */   protected String totPastDueAccnts;
/*     */   @XmlElement(name="InsuredAccnts")
/*     */   protected String insuredAccnts;
/*     */   @XmlElement(name="UninsuredAccnts")
/*     */   protected String uninsuredAccnts;
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
/*     */   public String getTotAccnts()
/*     */   {
/* 154 */     return this.totAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotAccnts(String value)
/*     */   {
/* 166 */     this.totAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotActiveAccnts()
/*     */   {
/* 178 */     return this.totActiveAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotActiveAccnts(String value)
/*     */   {
/* 190 */     this.totActiveAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotClosedAccnts()
/*     */   {
/* 202 */     return this.totClosedAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotClosedAccnts(String value)
/*     */   {
/* 214 */     this.totClosedAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotWOAccnts()
/*     */   {
/* 226 */     return this.totWOAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotWOAccnts(String value)
/*     */   {
/* 238 */     this.totWOAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotPastDueAccnts()
/*     */   {
/* 250 */     return this.totPastDueAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotPastDueAccnts(String value)
/*     */   {
/* 262 */     this.totPastDueAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInsuredAccnts()
/*     */   {
/* 274 */     return this.insuredAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInsuredAccnts(String value)
/*     */   {
/* 286 */     this.insuredAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUninsuredAccnts()
/*     */   {
/* 298 */     return this.uninsuredAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUninsuredAccnts(String value)
/*     */   {
/* 310 */     this.uninsuredAccnts = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Mfitotaccs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */