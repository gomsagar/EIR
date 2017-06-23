/*    */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Burpthdr", propOrder={"burRptAmtMonetaryCd"})
/*    */ public class Burpthdr
/*    */   extends Consbrpt
/*    */ {
/*    */   @XmlElement(name="BurRptAmtMonetaryCd")
/*    */   protected String burRptAmtMonetaryCd;
/*    */   
/*    */   public String getBurRptAmtMonetaryCd()
/*    */   {
/* 18 */     return this.burRptAmtMonetaryCd;
/*    */   }
/*    */   
/* 21 */   public void setBurRptAmtMonetaryCd(String burRptAmtMonetaryCd) { this.burRptAmtMonetaryCd = burRptAmtMonetaryCd; }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Burpthdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */