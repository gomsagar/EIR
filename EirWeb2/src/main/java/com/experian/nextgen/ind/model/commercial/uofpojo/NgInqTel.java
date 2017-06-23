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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="NgInqTel", propOrder={"segmentCode", "phoneNumber", "phoneType", "phoneNumberExtension"})
/*    */ public class NgInqTel
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   private String segmentCode;
/*    */   @XmlElement(name="PhoneNumber")
/*    */   private String phoneNumber;
/*    */   @XmlElement(name="PhoneType")
/*    */   private String phoneType;
/*    */   @XmlElement(name="PhoneNumberExtension")
/*    */   private String phoneNumberExtension;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 29 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String segmentCode) {
/* 33 */     this.segmentCode = segmentCode;
/*    */   }
/*    */   
/*    */   public String getPhoneNumber() {
/* 37 */     return this.phoneNumber;
/*    */   }
/*    */   
/*    */   public void setPhoneNumber(String phoneNumber) {
/* 41 */     this.phoneNumber = phoneNumber;
/*    */   }
/*    */   
/*    */   public String getPhoneType() {
/* 45 */     return this.phoneType;
/*    */   }
/*    */   
/*    */   public void setPhoneType(String phoneType) {
/* 49 */     this.phoneType = phoneType;
/*    */   }
/*    */   
/*    */   public String getPhoneNumberExtension() {
/* 53 */     return this.phoneNumberExtension;
/*    */   }
/*    */   
/*    */   public void setPhoneNumberExtension(String phoneNumberExtension) {
/* 57 */     this.phoneNumberExtension = phoneNumberExtension;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\NgInqTel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */