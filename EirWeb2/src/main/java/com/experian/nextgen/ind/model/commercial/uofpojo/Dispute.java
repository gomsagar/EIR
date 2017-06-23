/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ 
/*    */ @javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
/*    */ @javax.xml.bind.annotation.XmlType(name="Dispute", propOrder={"segmentCode", "DisputeRegisteredDate", "DisputeUpdatedDate", "DisputeFieldName", "DisputeText", "DisputeReasonCode", "DisputeResCode"})
/*    */ public class Dispute {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="DisputeRegisteredDate")
/*    */   protected String DisputeRegisteredDate;
/*    */   @XmlElement(name="DisputeUpdatedDate")
/*    */   protected String DisputeUpdatedDate;
/*    */   @XmlElement(name="DisputeFieldName")
/*    */   protected String DisputeFieldName;
/*    */   @XmlElement(name="DisputeText")
/*    */   protected String DisputeText;
/*    */   @XmlElement(name="DisputeReasonCode")
/*    */   protected String DisputeReasonCode;
/*    */   @XmlElement(name="DisputeResCode")
/*    */   protected String DisputeResCode;
/*    */   
/* 23 */   public String getSegmentCode() { return this.segmentCode; }
/*    */   
/*    */   public void setSegmentCode(String segmentCode) {
/* 26 */     this.segmentCode = segmentCode;
/*    */   }
/*    */   
/* 29 */   public String getDisputeRegisteredDate() { return this.DisputeRegisteredDate; }
/*    */   
/*    */   public void setDisputeRegisteredDate(String disputeRegisteredDate) {
/* 32 */     this.DisputeRegisteredDate = disputeRegisteredDate;
/*    */   }
/*    */   
/* 35 */   public String getDisputeUpdatedDate() { return this.DisputeUpdatedDate; }
/*    */   
/*    */   public void setDisputeUpdatedDate(String disputeUpdatedDate) {
/* 38 */     this.DisputeUpdatedDate = disputeUpdatedDate;
/*    */   }
/*    */   
/* 41 */   public String getDisputeFieldName() { return this.DisputeFieldName; }
/*    */   
/*    */   public void setDisputeFieldName(String disputeFieldName) {
/* 44 */     this.DisputeFieldName = disputeFieldName;
/*    */   }
/*    */   
/* 47 */   public String getDisputeText() { return this.DisputeText; }
/*    */   
/*    */   public void setDisputeText(String disputeText) {
/* 50 */     this.DisputeText = disputeText;
/*    */   }
/*    */   
/* 53 */   public String getDisputeReasonCode() { return this.DisputeReasonCode; }
/*    */   
/*    */   public void setDisputeReasonCode(String disputeReasonCode) {
/* 56 */     this.DisputeReasonCode = disputeReasonCode;
/*    */   }
/*    */   
/* 59 */   public String getDisputeResCode() { return this.DisputeResCode; }
/*    */   
/*    */   public void setDisputeResCode(String disputeResCode) {
/* 62 */     this.DisputeResCode = disputeResCode;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Dispute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */