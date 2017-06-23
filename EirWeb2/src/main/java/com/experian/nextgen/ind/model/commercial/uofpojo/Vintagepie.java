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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Vintagepie", propOrder={"segmentCode", "totStdAccountsPie", "totNonStdAccountsPie", "totClosedAccntsPie"})
/*    */ public class Vintagepie
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="TotStdAccountsPie")
/*    */   protected String totStdAccountsPie;
/*    */   @XmlElement(name="TotNonStdAccountsPie")
/*    */   protected String totNonStdAccountsPie;
/*    */   @XmlElement(name="TotClosedAccntsPie")
/*    */   protected String totClosedAccntsPie;
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
/*    */   public String getTotStdAccountsPie()
/*    */   {
/* 48 */     return this.totStdAccountsPie;
/*    */   }
/*    */   
/*    */   public void setTotStdAccountsPie(String value)
/*    */   {
/* 53 */     this.totStdAccountsPie = value;
/*    */   }
/*    */   
/*    */   public String getTotNonStdAccountsPie()
/*    */   {
/* 58 */     return this.totNonStdAccountsPie;
/*    */   }
/*    */   
/*    */   public void setTotNonStdAccountsPie(String value)
/*    */   {
/* 63 */     this.totNonStdAccountsPie = value;
/*    */   }
/*    */   
/*    */   public String getTotClosedAccntsPie()
/*    */   {
/* 68 */     return this.totClosedAccntsPie;
/*    */   }
/*    */   
/*    */   public void setTotClosedAccntsPie(String value)
/*    */   {
/* 73 */     this.totClosedAccntsPie = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Vintagepie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */