/*    */ package com.experian.nextgen.ind.model.consumer.uofpojo;
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
/*    */ @XmlType(name="ProveIDSum", propOrder={"segmentCode", "proveIDSummaryCnt"})
/*    */ public class ProveIDSum
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="ProveIDSummaryCnt")
/*    */   protected String proveIDSummaryCnt;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 34 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 46 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getProveIDSummaryCnt()
/*    */   {
/* 58 */     return this.proveIDSummaryCnt;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setProveIDSummaryCnt(String value)
/*    */   {
/* 70 */     this.proveIDSummaryCnt = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\ProveIDSum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */