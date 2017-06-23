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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="BurError", propOrder={"segmentCode", "errCode", "errDescription"})
/*    */ public class BurError
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="ErrCode")
/*    */   protected String errCode;
/*    */   @XmlElement(name="ErrDescription")
/*    */   protected String errDescription;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 35 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value) {
/* 39 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getErrCode()
/*    */   {
/* 44 */     return this.errCode;
/*    */   }
/*    */   
/*    */   public void setErrCode(String value)
/*    */   {
/* 49 */     this.errCode = value;
/*    */   }
/*    */   
/*    */   public String getErrDescription()
/*    */   {
/* 54 */     return this.errDescription;
/*    */   }
/*    */   
/*    */   public void setErrDescription(String value) {
/* 58 */     this.errDescription = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BurError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */