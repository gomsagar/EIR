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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="NgInqAddr", propOrder={"segmentCode", "addrType", "inqCompanyAddress", "inqCompanyCity", "inqCompanyPINCode", "countryCode"})
/*    */ public class NgInqAddr
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   private String segmentCode;
/*    */   @XmlElement(name="AddrType")
/*    */   private String addrType;
/*    */   @XmlElement(name="InqCompanyAddress")
/*    */   private String inqCompanyAddress;
/*    */   @XmlElement(name="InqCompanyCity")
/*    */   private String inqCompanyCity;
/*    */   @XmlElement(name="InqCompanyPINCode")
/*    */   private String inqCompanyPINCode;
/*    */   @XmlElement(name="CountryCode")
/*    */   private String countryCode;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 35 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String segmentCode) {
/* 39 */     this.segmentCode = segmentCode;
/*    */   }
/*    */   
/*    */   public String getAddrType() {
/* 43 */     return this.addrType;
/*    */   }
/*    */   
/*    */   public void setAddrType(String addrType) {
/* 47 */     this.addrType = addrType;
/*    */   }
/*    */   
/*    */   public String getInqCompanyAddress() {
/* 51 */     return this.inqCompanyAddress;
/*    */   }
/*    */   
/*    */   public void setInqCompanyAddress(String inqCompanyAddress) {
/* 55 */     this.inqCompanyAddress = inqCompanyAddress;
/*    */   }
/*    */   
/*    */   public String getInqCompanyCity() {
/* 59 */     return this.inqCompanyCity;
/*    */   }
/*    */   
/*    */   public void setInqCompanyCity(String inqCompanyCity) {
/* 63 */     this.inqCompanyCity = inqCompanyCity;
/*    */   }
/*    */   
/*    */   public String getInqCompanyPINCode() {
/* 67 */     return this.inqCompanyPINCode;
/*    */   }
/*    */   
/*    */   public void setInqCompanyPINCode(String inqCompanyPINCode) {
/* 71 */     this.inqCompanyPINCode = inqCompanyPINCode;
/*    */   }
/*    */   
/*    */   public String getCountryCode() {
/* 75 */     return this.countryCode;
/*    */   }
/*    */   
/*    */   public void setCountryCode(String countryCode) {
/* 79 */     this.countryCode = countryCode;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\NgInqAddr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */