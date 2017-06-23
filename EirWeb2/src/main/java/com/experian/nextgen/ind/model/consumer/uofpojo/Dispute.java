/*    */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
/*    */ @XmlType(name="Dispute", propOrder={"segmentCode", "DisputeRegisteredDate", "DisputeUpdatedDate", "DisputeFieldName", "DisputeText", "DisputeReasonCode", "DisputeResCode"})
/*    */ public class Dispute
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="DisputeRegisteredDate")
/*    */   protected String DisputeRegisteredDate;
/*    */   @XmlElement(name="DisputeUpdatedDate")
/*    */   protected String DisputeUpdatedDate;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 20 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */ 
/* 24 */   public void setSegmentCode(String segmentCode) { this.segmentCode = segmentCode; }
/*    */   
/*    */   @XmlElement(name="DisputeFieldName")
/*    */   protected String DisputeFieldName;
/* 28 */   public String getDisputeRegisteredDate() { return this.DisputeRegisteredDate; }
/*    */   
/*    */   @XmlElement(name="DisputeText")
/*    */   protected String DisputeText;
/* 32 */   public void setDisputeRegisteredDate(String disputeRegisteredDate) { this.DisputeRegisteredDate = disputeRegisteredDate; }
/*    */   
/*    */   public String getDisputeUpdatedDate()
/*    */   {
/* 36 */     return this.DisputeUpdatedDate;
/*    */   }
/*    */   
/*    */   public void setDisputeUpdatedDate(String disputeUpdatedDate) {
/* 40 */     this.DisputeUpdatedDate = disputeUpdatedDate;
/*    */   }
/*    */   
/*    */   public String getDisputeFieldName() {
/* 44 */     return this.DisputeFieldName;
/*    */   }
/*    */   
/*    */   public void setDisputeFieldName(String disputeFieldName) {
/* 48 */     this.DisputeFieldName = disputeFieldName;
/*    */   }
/*    */   
/*    */ 
/* 52 */   public String getDisputeText() { return this.DisputeText; }
/*    */   @XmlElement(name="DisputeReasonCode")
/*    */   protected String DisputeReasonCode;
/*    */   
/* 56 */   public void setDisputeText(String disputeText) { this.DisputeText = disputeText; }
/*    */   
/*    */ 
/*    */ 
/* 60 */   public String getDisputeReasonCode() { return this.DisputeReasonCode; }
/*    */   
/*    */   @XmlElement(name="DisputeResCode")
/*    */   protected String DisputeResCode;
/* 64 */   public void setDisputeReasonCode(String disputeReasonCode) { this.DisputeReasonCode = disputeReasonCode; }
/*    */   
/*    */   public String getDisputeResCode()
/*    */   {
/* 68 */     return this.DisputeResCode;
/*    */   }
/*    */   
/*    */   public void setDisputeResCode(String disputeResCode) {
/* 72 */     this.DisputeResCode = disputeResCode;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Dispute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */