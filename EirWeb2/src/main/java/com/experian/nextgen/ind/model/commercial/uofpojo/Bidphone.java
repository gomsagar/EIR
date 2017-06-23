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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Bidphone", propOrder={"segmentCode", "phoneType", "phoneNumber"})
/*    */ public class Bidphone
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="PhoneType")
/*    */   protected String phoneType;
/*    */   @XmlElement(name="PhoneNumber")
/*    */   protected String phoneNumber;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 38 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 43 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getPhoneType()
/*    */   {
/* 48 */     return this.phoneType;
/*    */   }
/*    */   
/*    */   public void setPhoneType(String value)
/*    */   {
/* 53 */     this.phoneType = value;
/*    */   }
/*    */   
/*    */   public String getPhoneNumber()
/*    */   {
/* 58 */     return this.phoneNumber;
/*    */   }
/*    */   
/*    */   public void setPhoneNumber(String value)
/*    */   {
/* 63 */     this.phoneNumber = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Bidphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */