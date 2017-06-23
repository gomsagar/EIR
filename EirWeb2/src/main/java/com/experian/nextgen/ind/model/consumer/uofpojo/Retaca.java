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
/*     */ @XmlType(name="Retaca", propOrder={"segmentCode", "tnOfRetailACA", "totalBalRetailACA", "wcdStRetailACA", "wdsPr6MNTRetailACA", "wdsPr712MNTRetailACA", "ageOfOldestRetailACA", "hcbLmPerRevAccRet", "totCurBalLmPerRevAccRet"})
/*     */ public class Retaca
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_Retail_ACA")
/*     */   protected String tnOfRetailACA;
/*     */   @XmlElement(name="Total_Bal_Retail_ACA")
/*     */   protected String totalBalRetailACA;
/*     */   @XmlElement(name="WCD_St_Retail_ACA")
/*     */   protected String wcdStRetailACA;
/*     */   @XmlElement(name="WDS_Pr_6_MNT_Retail_ACA")
/*     */   protected String wdsPr6MNTRetailACA;
/*     */   @XmlElement(name="WDS_Pr_7_12_MNT_Retail_ACA")
/*     */   protected String wdsPr712MNTRetailACA;
/*     */   @XmlElement(name="Age_of_Oldest_Retail_ACA")
/*     */   protected String ageOfOldestRetailACA;
/*     */   @XmlElement(name="HCB_Lm_Per_Rev_Acc_Ret")
/*     */   protected String hcbLmPerRevAccRet;
/*     */   @XmlElement(name="Tot_Cur_Bal_Lm_Per_Rev_Acc_Ret")
/*     */   protected String totCurBalLmPerRevAccRet;
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
/*     */   public String getTnOfRetailACA()
/*     */   {
/* 164 */     return this.tnOfRetailACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfRetailACA(String value)
/*     */   {
/* 176 */     this.tnOfRetailACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalBalRetailACA()
/*     */   {
/* 188 */     return this.totalBalRetailACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalBalRetailACA(String value)
/*     */   {
/* 200 */     this.totalBalRetailACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWcdStRetailACA()
/*     */   {
/* 212 */     return this.wcdStRetailACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWcdStRetailACA(String value)
/*     */   {
/* 224 */     this.wcdStRetailACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr6MNTRetailACA()
/*     */   {
/* 236 */     return this.wdsPr6MNTRetailACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr6MNTRetailACA(String value)
/*     */   {
/* 248 */     this.wdsPr6MNTRetailACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr712MNTRetailACA()
/*     */   {
/* 260 */     return this.wdsPr712MNTRetailACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr712MNTRetailACA(String value)
/*     */   {
/* 272 */     this.wdsPr712MNTRetailACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAgeOfOldestRetailACA()
/*     */   {
/* 284 */     return this.ageOfOldestRetailACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAgeOfOldestRetailACA(String value)
/*     */   {
/* 296 */     this.ageOfOldestRetailACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHcbLmPerRevAccRet()
/*     */   {
/* 308 */     return this.hcbLmPerRevAccRet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHcbLmPerRevAccRet(String value)
/*     */   {
/* 320 */     this.hcbLmPerRevAccRet = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotCurBalLmPerRevAccRet()
/*     */   {
/* 332 */     return this.totCurBalLmPerRevAccRet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotCurBalLmPerRevAccRet(String value)
/*     */   {
/* 344 */     this.totCurBalLmPerRevAccRet = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Retaca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */