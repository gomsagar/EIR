/*    */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*    */ 
/*    */ import com.thoughtworks.xstream.annotations.XStreamAlias;
/*    */ import java.io.Serializable;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
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
/*    */ @XmlRootElement(name="EXPNGRPT")
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="EXPNGRPT")
/*    */ @XStreamAlias("EXPNGRPT")
/*    */ public class ResponseInfo
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @XmlElement(name="BureauReport")
/*    */   private ConsumerResponse consumerResponse;
/*    */   @XmlElement(name="ConsumerResponseList")
/*    */   private ConsumerResponseList consumerResponseList;
/*    */   
/*    */   public ConsumerResponse getConsumerResponse()
/*    */   {
/* 37 */     return this.consumerResponse;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setConsumerResponse(ConsumerResponse consumerResponse)
/*    */   {
/* 44 */     this.consumerResponse = consumerResponse;
/*    */   }
/*    */   
/*    */   public ConsumerResponseList getConsumerResponseList() {
/* 48 */     return this.consumerResponseList;
/*    */   }
/*    */   
/*    */   public void setConsumerResponseList(ConsumerResponseList consumerResponseList) {
/* 52 */     this.consumerResponseList = consumerResponseList;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\ResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */