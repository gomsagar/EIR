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
/*     */ @XmlType(name="Pidcards", propOrder={"segmentCode", "idNumberType", "idNumber", "idIssueDate", "idExpirationDate", "bestIdInd", "enqIdMatchInd"})
/*     */ public class Pidcards
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="IdNumberType")
/*     */   protected String idNumberType;
/*     */   @XmlElement(name="IdNumber")
/*     */   protected String idNumber;
/*     */   @XmlElement(name="IdIssueDate")
/*     */   protected String idIssueDate;
/*     */   @XmlElement(name="IdExpirationDate")
/*     */   protected String idExpirationDate;
/*     */   @XmlElement(name="BestIdInd")
/*     */   protected String bestIdInd;
/*     */   @XmlElement(name="EnqIdMatchInd")
/*     */   protected String enqIdMatchInd;
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
/*     */   public String getIdNumberType()
/*     */   {
/* 144 */     return this.idNumberType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdNumberType(String value)
/*     */   {
/* 156 */     this.idNumberType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdNumber()
/*     */   {
/* 168 */     return this.idNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdNumber(String value)
/*     */   {
/* 180 */     this.idNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdIssueDate()
/*     */   {
/* 192 */     return this.idIssueDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdIssueDate(String value)
/*     */   {
/* 204 */     this.idIssueDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdExpirationDate()
/*     */   {
/* 216 */     return this.idExpirationDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdExpirationDate(String value)
/*     */   {
/* 228 */     this.idExpirationDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBestIdInd()
/*     */   {
/* 240 */     return this.bestIdInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBestIdInd(String value)
/*     */   {
/* 252 */     this.bestIdInd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnqIdMatchInd()
/*     */   {
/* 264 */     return this.enqIdMatchInd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnqIdMatchInd(String value)
/*     */   {
/* 276 */     this.enqIdMatchInd = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Pidcards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */