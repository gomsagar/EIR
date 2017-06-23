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
/*     */ @XmlType(name="Ccaaccthis", propOrder={"segmentCode", "oldestWOAccountMonth", "oldestWOAccountYear", "mostRecentWOAccountMonth", "mostRecentWOAccountYear", "firstCreditAccountMonth", "firstCreditAccountYear", "mostRecentCreditAccountMonth", "mostRecentCreditAccountYear"})
/*     */ public class Ccaaccthis
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="OldestWOAccountMonth")
/*     */   protected String oldestWOAccountMonth;
/*     */   @XmlElement(name="OldestWOAccountYear")
/*     */   protected String oldestWOAccountYear;
/*     */   @XmlElement(name="MostRecentWOAccountMonth")
/*     */   protected String mostRecentWOAccountMonth;
/*     */   @XmlElement(name="MostRecentWOAccountYear")
/*     */   protected String mostRecentWOAccountYear;
/*     */   @XmlElement(name="FirstCreditAccountMonth")
/*     */   protected String firstCreditAccountMonth;
/*     */   @XmlElement(name="FirstCreditAccountYear")
/*     */   protected String firstCreditAccountYear;
/*     */   @XmlElement(name="MostRecentCreditAccountMonth")
/*     */   protected String mostRecentCreditAccountMonth;
/*     */   @XmlElement(name="MostRecentCreditAccountYear")
/*     */   protected String mostRecentCreditAccountYear;
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
/*     */   public String getOldestWOAccountMonth()
/*     */   {
/* 164 */     return this.oldestWOAccountMonth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOldestWOAccountMonth(String value)
/*     */   {
/* 176 */     this.oldestWOAccountMonth = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOldestWOAccountYear()
/*     */   {
/* 188 */     return this.oldestWOAccountYear;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOldestWOAccountYear(String value)
/*     */   {
/* 200 */     this.oldestWOAccountYear = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMostRecentWOAccountMonth()
/*     */   {
/* 212 */     return this.mostRecentWOAccountMonth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMostRecentWOAccountMonth(String value)
/*     */   {
/* 224 */     this.mostRecentWOAccountMonth = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMostRecentWOAccountYear()
/*     */   {
/* 236 */     return this.mostRecentWOAccountYear;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMostRecentWOAccountYear(String value)
/*     */   {
/* 248 */     this.mostRecentWOAccountYear = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFirstCreditAccountMonth()
/*     */   {
/* 260 */     return this.firstCreditAccountMonth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFirstCreditAccountMonth(String value)
/*     */   {
/* 272 */     this.firstCreditAccountMonth = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFirstCreditAccountYear()
/*     */   {
/* 284 */     return this.firstCreditAccountYear;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFirstCreditAccountYear(String value)
/*     */   {
/* 296 */     this.firstCreditAccountYear = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMostRecentCreditAccountMonth()
/*     */   {
/* 308 */     return this.mostRecentCreditAccountMonth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMostRecentCreditAccountMonth(String value)
/*     */   {
/* 320 */     this.mostRecentCreditAccountMonth = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMostRecentCreditAccountYear()
/*     */   {
/* 332 */     return this.mostRecentCreditAccountYear;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMostRecentCreditAccountYear(String value)
/*     */   {
/* 344 */     this.mostRecentCreditAccountYear = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Ccaaccthis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */