/*    */ package com.experian.nextgen.ind.model.uof.impl.response;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name="header", namespace="uof.shared", propOrder={"responseCode", "responseMessage", "responseDescription", "requestIdentifier", "userIPAddress"})
/*    */ public class Header
/*    */ {
/*    */   String responseCode;
/*    */   String responseMessage;
/*    */   String responseDescription;
/*    */   String requestIdentifier;
/*    */   String userIPAddress;
/*    */   
/*    */   public String getResponseCode()
/*    */   {
/* 16 */     return this.responseCode;
/*    */   }
/*    */   
/* 19 */   public void setResponseCode(String responseCode) { this.responseCode = responseCode; }
/*    */   
/*    */   public String getResponseDescription() {
/* 22 */     return this.responseDescription;
/*    */   }
/*    */   
/* 25 */   public void setResponseDescription(String responseDescription) { this.responseDescription = responseDescription; }
/*    */   
/*    */   public String getRequestIdentifier() {
/* 28 */     return this.requestIdentifier;
/*    */   }
/*    */   
/* 31 */   public void setRequestIdentifier(String requestIdentifier) { this.requestIdentifier = requestIdentifier; }
/*    */   
/*    */   public String getUserIPAddress() {
/* 34 */     return this.userIPAddress;
/*    */   }
/*    */   
/* 37 */   public void setUserIPAddress(String userIPAddress) { this.userIPAddress = userIPAddress; }
/*    */   
/*    */   public String getResponseMessage() {
/* 40 */     return this.responseMessage;
/*    */   }
/*    */   
/* 43 */   public void setResponseMessage(String responseMessage) { this.responseMessage = responseMessage; }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\\uof\impl\response\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */