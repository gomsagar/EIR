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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Ccatotaccs", propOrder={"segmentCode", "totAccnts", "totActiveAccnts", "percActiveAccnts", "totDefaultAccnts", "percDefaultAccnts", "totClosedAccnts", "percClosedAccnts", "totSFWDWOSTLAccnts"})
/*     */ public class Ccatotaccs
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TotAccnts")
/*     */   protected String totAccnts;
/*     */   @XmlElement(name="TotActiveAccnts")
/*     */   protected String totActiveAccnts;
/*     */   @XmlElement(name="PercActiveAccnts")
/*     */   protected String percActiveAccnts;
/*     */   @XmlElement(name="TotDefaultAccnts")
/*     */   protected String totDefaultAccnts;
/*     */   @XmlElement(name="PercDefaultAccnts")
/*     */   protected String percDefaultAccnts;
/*     */   @XmlElement(name="TotClosedAccnts")
/*     */   protected String totClosedAccnts;
/*     */   @XmlElement(name="PercClosedAccnts")
/*     */   protected String percClosedAccnts;
/*     */   @XmlElement(name="TotSFWDWOSTLAccnts")
/*     */   protected String totSFWDWOSTLAccnts;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 140 */     return this.segmentCode;
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
/* 152 */     this.segmentCode = value;
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
/* 164 */     return this.totAccnts;
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
/* 176 */     this.totAccnts = value;
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
/* 188 */     return this.totActiveAccnts;
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
/* 200 */     this.totActiveAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPercActiveAccnts()
/*     */   {
/* 212 */     return this.percActiveAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPercActiveAccnts(String value)
/*     */   {
/* 224 */     this.percActiveAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotDefaultAccnts()
/*     */   {
/* 236 */     return this.totDefaultAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotDefaultAccnts(String value)
/*     */   {
/* 248 */     this.totDefaultAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPercDefaultAccnts()
/*     */   {
/* 260 */     return this.percDefaultAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPercDefaultAccnts(String value)
/*     */   {
/* 272 */     this.percDefaultAccnts = value;
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
/* 284 */     return this.totClosedAccnts;
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
/* 296 */     this.totClosedAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPercClosedAccnts()
/*     */   {
/* 308 */     return this.percClosedAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPercClosedAccnts(String value)
/*     */   {
/* 320 */     this.percClosedAccnts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotSFWDWOSTLAccnts()
/*     */   {
/* 332 */     return this.totSFWDWOSTLAccnts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotSFWDWOSTLAccnts(String value)
/*     */   {
/* 344 */     this.totSFWDWOSTLAccnts = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Ccatotaccs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */