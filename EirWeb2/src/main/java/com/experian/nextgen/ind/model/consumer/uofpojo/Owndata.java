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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Owndata", propOrder={"segmentCode", "tnOfOComCAD", "totValOfOComCAD", "mntSMROComCAD", "tnOfOComACA", "balOComACAExHL", "balOComACAHLOnly", "wcdStOComACA", "hcbLmPerRevOComACA", "tnOfNDelOComInACA", "tnOfDelOComInACA", "tnOfOComCAPSLast90Days"})
/*     */ public class Owndata
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_OCom_CAD")
/*     */   protected String tnOfOComCAD;
/*     */   @XmlElement(name="Tot_Val_of_OCom_CAD")
/*     */   protected String totValOfOComCAD;
/*     */   @XmlElement(name="MNT_SMR_OCom_CAD")
/*     */   protected String mntSMROComCAD;
/*     */   @XmlElement(name="TN_of_OCom_ACA")
/*     */   protected String tnOfOComACA;
/*     */   @XmlElement(name="Bal_OCom_ACA_Ex_HL")
/*     */   protected String balOComACAExHL;
/*     */   @XmlElement(name="Bal_OCom_ACA_HL_Only")
/*     */   protected String balOComACAHLOnly;
/*     */   @XmlElement(name="WCD_St_OCom_ACA")
/*     */   protected String wcdStOComACA;
/*     */   @XmlElement(name="HCB_Lm_Per_Rev_OCom_ACA")
/*     */   protected String hcbLmPerRevOComACA;
/*     */   @XmlElement(name="TN_of_NDel_OCom_InACA")
/*     */   protected String tnOfNDelOComInACA;
/*     */   @XmlElement(name="TN_of_Del_OCom_InACA")
/*     */   protected String tnOfDelOComInACA;
/*     */   @XmlElement(name="TN_of_OCom_CAPS_Last_90_days")
/*     */   protected String tnOfOComCAPSLast90Days;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 170 */     return this.segmentCode;
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
/* 182 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfOComCAD()
/*     */   {
/* 194 */     return this.tnOfOComCAD;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfOComCAD(String value)
/*     */   {
/* 206 */     this.tnOfOComCAD = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotValOfOComCAD()
/*     */   {
/* 218 */     return this.totValOfOComCAD;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotValOfOComCAD(String value)
/*     */   {
/* 230 */     this.totValOfOComCAD = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMntSMROComCAD()
/*     */   {
/* 242 */     return this.mntSMROComCAD;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMntSMROComCAD(String value)
/*     */   {
/* 254 */     this.mntSMROComCAD = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfOComACA()
/*     */   {
/* 266 */     return this.tnOfOComACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfOComACA(String value)
/*     */   {
/* 278 */     this.tnOfOComACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBalOComACAExHL()
/*     */   {
/* 290 */     return this.balOComACAExHL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBalOComACAExHL(String value)
/*     */   {
/* 302 */     this.balOComACAExHL = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBalOComACAHLOnly()
/*     */   {
/* 314 */     return this.balOComACAHLOnly;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBalOComACAHLOnly(String value)
/*     */   {
/* 326 */     this.balOComACAHLOnly = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWcdStOComACA()
/*     */   {
/* 338 */     return this.wcdStOComACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWcdStOComACA(String value)
/*     */   {
/* 350 */     this.wcdStOComACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHcbLmPerRevOComACA()
/*     */   {
/* 362 */     return this.hcbLmPerRevOComACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHcbLmPerRevOComACA(String value)
/*     */   {
/* 374 */     this.hcbLmPerRevOComACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfNDelOComInACA()
/*     */   {
/* 386 */     return this.tnOfNDelOComInACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfNDelOComInACA(String value)
/*     */   {
/* 398 */     this.tnOfNDelOComInACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfDelOComInACA()
/*     */   {
/* 410 */     return this.tnOfDelOComInACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfDelOComInACA(String value)
/*     */   {
/* 422 */     this.tnOfDelOComInACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfOComCAPSLast90Days()
/*     */   {
/* 434 */     return this.tnOfOComCAPSLast90Days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfOComCAPSLast90Days(String value)
/*     */   {
/* 446 */     this.tnOfOComCAPSLast90Days = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Owndata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */