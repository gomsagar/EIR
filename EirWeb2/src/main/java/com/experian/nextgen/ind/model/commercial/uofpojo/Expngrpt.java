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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Expngrpt", propOrder={"bureauReport"})
/*    */ public class Expngrpt
/*    */ {
/*    */   @XmlElement(name="BureauReport")
/*    */   protected String bureauReport;
/*    */   
/*    */   public String getBureauReport()
/*    */   {
/* 29 */     return this.bureauReport;
/*    */   }
/*    */   
/*    */   public void setBureauReport(String value)
/*    */   {
/* 34 */     this.bureauReport = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Expngrpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */