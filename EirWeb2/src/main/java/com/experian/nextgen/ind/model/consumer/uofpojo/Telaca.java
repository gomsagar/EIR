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
/*     */ @XmlType(name="Telaca", propOrder={"segmentCode", "tnOfTelcosACA", "totalBalTelcosACA", "wcdStTelcosACA", "wdsPr6MNTTelcosACA", "wdsPr712MNTTelcosACA", "ageOfOldestTelcosACA"})
/*     */ public class Telaca
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_Telcos_ACA")
/*     */   protected String tnOfTelcosACA;
/*     */   @XmlElement(name="Total_Bal_Telcos_ACA")
/*     */   protected String totalBalTelcosACA;
/*     */   @XmlElement(name="WCD_St_Telcos_ACA")
/*     */   protected String wcdStTelcosACA;
/*     */   @XmlElement(name="WDS_Pr_6_MNT_Telcos_ACA")
/*     */   protected String wdsPr6MNTTelcosACA;
/*     */   @XmlElement(name="WDS_Pr_7_12_MNT_Telcos_ACA")
/*     */   protected String wdsPr712MNTTelcosACA;
/*     */   @XmlElement(name="Age_of_Oldest_Telcos_ACA")
/*     */   protected String ageOfOldestTelcosACA;
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
/*     */   public String getTnOfTelcosACA()
/*     */   {
/* 144 */     return this.tnOfTelcosACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfTelcosACA(String value)
/*     */   {
/* 156 */     this.tnOfTelcosACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotalBalTelcosACA()
/*     */   {
/* 168 */     return this.totalBalTelcosACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotalBalTelcosACA(String value)
/*     */   {
/* 180 */     this.totalBalTelcosACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWcdStTelcosACA()
/*     */   {
/* 192 */     return this.wcdStTelcosACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWcdStTelcosACA(String value)
/*     */   {
/* 204 */     this.wcdStTelcosACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr6MNTTelcosACA()
/*     */   {
/* 216 */     return this.wdsPr6MNTTelcosACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr6MNTTelcosACA(String value)
/*     */   {
/* 228 */     this.wdsPr6MNTTelcosACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWdsPr712MNTTelcosACA()
/*     */   {
/* 240 */     return this.wdsPr712MNTTelcosACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWdsPr712MNTTelcosACA(String value)
/*     */   {
/* 252 */     this.wdsPr712MNTTelcosACA = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAgeOfOldestTelcosACA()
/*     */   {
/* 264 */     return this.ageOfOldestTelcosACA;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAgeOfOldestTelcosACA(String value)
/*     */   {
/* 276 */     this.ageOfOldestTelcosACA = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Telaca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */