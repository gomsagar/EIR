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
/*     */ @XmlType(name="Hlaca", propOrder={"segmentCode", "tnOfHLACA", "balHLACA", "wcdStHLACA", "wdsPr6MNTHLACA", "wdsPr712MNTHLACA", "ageOfOldestHLACA"})
/*     */ public class Hlaca
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_HL_ACA")
/*     */   protected String tnOfHLACA;
/*     */   @XmlElement(name="Bal_HL_ACA")
/*     */   protected String balHLACA;
/*     */   @XmlElement(name="WCD_St_HL_ACA")
/*     */   protected String wcdStHLACA;
/*     */   @XmlElement(name="WDS_Pr_6_MNT_HL_ACA")
/*     */   protected String wdsPr6MNTHLACA;
/*     */   @XmlElement(name="WDS_Pr_7_12_MNT_HL_ACA")
/*     */   protected String wdsPr712MNTHLACA;
/*     */   @XmlElement(name="Age_of_Oldest_HL_ACA")
/*     */   protected String ageOfOldestHLACA;
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
/*     */   public String getTnOfHLACA()
/*     */   {
/* 144 */     return this.tnOfHLACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfHLACA(String value)
/*     */   {
/* 156 */     this.tnOfHLACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBalHLACA()
/*     */   {
/* 168 */     return this.balHLACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBalHLACA(String value)
/*     */   {
/* 180 */     this.balHLACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWcdStHLACA()
/*     */   {
/* 192 */     return this.wcdStHLACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWcdStHLACA(String value)
/*     */   {
/* 204 */     this.wcdStHLACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr6MNTHLACA()
/*     */   {
/* 216 */     return this.wdsPr6MNTHLACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr6MNTHLACA(String value)
/*     */   {
/* 228 */     this.wdsPr6MNTHLACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr712MNTHLACA()
/*     */   {
/* 240 */     return this.wdsPr712MNTHLACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr712MNTHLACA(String value)
/*     */   {
/* 252 */     this.wdsPr712MNTHLACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAgeOfOldestHLACA()
/*     */   {
/* 264 */     return this.ageOfOldestHLACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAgeOfOldestHLACA(String value)
/*     */   {
/* 276 */     this.ageOfOldestHLACA = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Hlaca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */