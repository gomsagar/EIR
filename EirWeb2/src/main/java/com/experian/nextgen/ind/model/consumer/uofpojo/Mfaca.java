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
/*     */ @XmlType(name="Mfaca", propOrder={"segmentCode", "tnOfMFACA", "totalBalMFACA", "wcdStMFACA", "wdsPr6MNTMFACA", "wdsPr712MNTMFACA", "ageOfOldestMFACA"})
/*     */ public class Mfaca
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_MF_ACA")
/*     */   protected String tnOfMFACA;
/*     */   @XmlElement(name="Total_Bal_MF_ACA")
/*     */   protected String totalBalMFACA;
/*     */   @XmlElement(name="WCD_St_MF_ACA")
/*     */   protected String wcdStMFACA;
/*     */   @XmlElement(name="WDS_Pr_6_MNT_MF_ACA")
/*     */   protected String wdsPr6MNTMFACA;
/*     */   @XmlElement(name="WDS_Pr_7_12_MNT_MF_ACA")
/*     */   protected String wdsPr712MNTMFACA;
/*     */   @XmlElement(name="Age_of_Oldest_MF_ACA")
/*     */   protected String ageOfOldestMFACA;
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
/*     */   public String getTnOfMFACA()
/*     */   {
/* 144 */     return this.tnOfMFACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfMFACA(String value)
/*     */   {
/* 156 */     this.tnOfMFACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalBalMFACA()
/*     */   {
/* 168 */     return this.totalBalMFACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalBalMFACA(String value)
/*     */   {
/* 180 */     this.totalBalMFACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWcdStMFACA()
/*     */   {
/* 192 */     return this.wcdStMFACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWcdStMFACA(String value)
/*     */   {
/* 204 */     this.wcdStMFACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr6MNTMFACA()
/*     */   {
/* 216 */     return this.wdsPr6MNTMFACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr6MNTMFACA(String value)
/*     */   {
/* 228 */     this.wdsPr6MNTMFACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr712MNTMFACA()
/*     */   {
/* 240 */     return this.wdsPr712MNTMFACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr712MNTMFACA(String value)
/*     */   {
/* 252 */     this.wdsPr712MNTMFACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAgeOfOldestMFACA()
/*     */   {
/* 264 */     return this.ageOfOldestMFACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAgeOfOldestMFACA(String value)
/*     */   {
/* 276 */     this.ageOfOldestMFACA = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Mfaca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */