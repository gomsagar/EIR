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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Pidname", propOrder={"segmentCode", "vipCd", "title", "firstGivenName", "middleName", "otherMiddleNames", "indiaMiddleName3", "familyName", "suffix", "indiaNamePrefix", "bestNameInd", "inqNameMatchInd"})
/*     */ public class Pidname
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="VIPCd")
/*     */   protected String vipCd;
/*     */   @XmlElement(name="Title")
/*     */   protected String title;
/*     */   @XmlElement(name="FirstGivenName")
/*     */   protected String firstGivenName;
/*     */   @XmlElement(name="MiddleName")
/*     */   protected String middleName;
/*     */   @XmlElement(name="OtherMiddleNames")
/*     */   protected String otherMiddleNames;
/*     */   @XmlElement(name="IndiaMiddleName3")
/*     */   protected String indiaMiddleName3;
/*     */   @XmlElement(name="FamilyName")
/*     */   protected String familyName;
/*     */   @XmlElement(name="Suffix")
/*     */   protected String suffix;
/*     */   @XmlElement(name="IndiaNamePrefix")
/*     */   protected String indiaNamePrefix;
/*     */   @XmlElement(name="BestNameInd")
/*     */   protected String bestNameInd;
/*     */   @XmlElement(name="InqNameMatchInd")
/*     */   protected String inqNameMatchInd;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  81 */     return this.segmentCode;
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
/*  93 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getVIPCd()
/*     */   {
/* 106 */     return this.vipCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVIPCd(String value)
/*     */   {
/* 118 */     this.vipCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 130 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTitle(String value)
/*     */   {
/* 142 */     this.title = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFirstGivenName()
/*     */   {
/* 154 */     return this.firstGivenName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFirstGivenName(String value)
/*     */   {
/* 166 */     this.firstGivenName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMiddleName()
/*     */   {
/* 178 */     return this.middleName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMiddleName(String value)
/*     */   {
/* 190 */     this.middleName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOtherMiddleNames()
/*     */   {
/* 202 */     return this.otherMiddleNames;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOtherMiddleNames(String value)
/*     */   {
/* 214 */     this.otherMiddleNames = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFamilyName()
/*     */   {
/* 226 */     return this.familyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFamilyName(String value)
/*     */   {
/* 238 */     this.familyName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSuffix()
/*     */   {
/* 250 */     return this.suffix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSuffix(String value)
/*     */   {
/* 262 */     this.suffix = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBestNameInd()
/*     */   {
/* 274 */     return this.bestNameInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBestNameInd(String value)
/*     */   {
/* 286 */     this.bestNameInd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqNameMatchInd()
/*     */   {
/* 298 */     return this.inqNameMatchInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqNameMatchInd(String value)
/*     */   {
/* 310 */     this.inqNameMatchInd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaNamePrefix()
/*     */   {
/* 323 */     return this.indiaNamePrefix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaNamePrefix(String value)
/*     */   {
/* 335 */     this.indiaNamePrefix = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaMiddleName3()
/*     */   {
/* 347 */     return this.indiaMiddleName3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaMiddleName3(String value)
/*     */   {
/* 359 */     this.indiaMiddleName3 = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Pidname.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */