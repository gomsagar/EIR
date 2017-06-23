/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="BidCards", propOrder={"segmentCode", "idNumberType", "idNumber", "IDSourceCd", "idCount", "idDate"})
/*    */ public class BidCards
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="IdNumberType")
/*    */   protected String idNumberType;
/*    */   @XmlElement(name="IdNumber")
/*    */   protected String idNumber;
/*    */   @XmlElement(name="IDSourceCd")
/*    */   protected String IDSourceCd;
/*    */   @XmlElement(name="IdCount")
/*    */   protected String idCount;
/*    */   @XmlElement(name="IdDate")
/*    */   protected String idDate;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 52 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String segmentCode) {
/* 56 */     this.segmentCode = segmentCode;
/*    */   }
/*    */   
/*    */   public String getIdNumberType() {
/* 60 */     return this.idNumberType;
/*    */   }
/*    */   
/*    */   public void setIdNumberType(String idNumberType) {
/* 64 */     this.idNumberType = idNumberType;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getIdNumber()
/*    */   {
/* 70 */     return this.idNumber;
/*    */   }
/*    */   
/*    */   public void setIdNumber(String idNumber) {
/* 74 */     this.idNumber = idNumber;
/*    */   }
/*    */   
/*    */   public String getIDSourceCd() {
/* 78 */     return this.IDSourceCd;
/*    */   }
/*    */   
/*    */   public void setIDSourceCd(String iDSourceCd) {
/* 82 */     this.IDSourceCd = iDSourceCd;
/*    */   }
/*    */   
/*    */   public String getIdCount() {
/* 86 */     return this.idCount;
/*    */   }
/*    */   
/*    */   public void setIdCount(String idCount) {
/* 90 */     this.idCount = idCount;
/*    */   }
/*    */   
/*    */   public String getIdDate() {
/* 94 */     return this.idDate;
/*    */   }
/*    */   
/*    */   public void setIdDate(String idDate) {
/* 98 */     this.idDate = idDate;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BidCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */