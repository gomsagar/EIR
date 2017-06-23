/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
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
/*    */ @XmlRootElement(name="EXPNGRPT")
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="EXPNGRPT")
/*    */ @XStreamAlias("EXPNGRPT")
/*    */ public class ResponseInfo
/*    */   implements Serializable
/*    */ {
/*    */   @XmlElement(name="BureauReport")
/*    */   private BusinessResponse businessResponse;
/*    */   @XmlElement(name="ReportResponse")
/*    */   private BusinessResponseList businessResponseList;
/*    */   
/*    */   public BusinessResponse getBusinessResponse()
/*    */   {
/* 29 */     return this.businessResponse;
/*    */   }
/*    */   
/*    */   public void setBusinessResponse(BusinessResponse businessResponse)
/*    */   {
/* 34 */     this.businessResponse = businessResponse;
/*    */   }
/*    */   
/*    */   public BusinessResponseList getBusinessResponseList()
/*    */   {
/* 39 */     return this.businessResponseList;
/*    */   }
/*    */   
/*    */   public void setBusinessResponseList(BusinessResponseList businessResponseList)
/*    */   {
/* 44 */     this.businessResponseList = businessResponseList;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\ResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */