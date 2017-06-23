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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="AliasNam", propOrder={"segmentCode", "aliasName", "aliasType"})
/*    */ public class AliasNam
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="AliasName")
/*    */   protected String aliasName;
/*    */   @XmlElement(name="AliasType")
/*    */   protected String aliasType;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 39 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value) {
/* 43 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getAliasName() {
/* 47 */     return this.aliasName;
/*    */   }
/*    */   
/*    */   public void setAliasName(String value) {
/* 51 */     this.aliasName = value;
/*    */   }
/*    */   
/*    */   public String getAliasType() {
/* 55 */     return this.aliasType;
/*    */   }
/*    */   
/*    */   public void setAliasType(String value) {
/* 59 */     this.aliasType = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\AliasNam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */