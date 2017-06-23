/*    */ package com.experian.nextgen.ind.model.uof.impl.response;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="error", namespace="uof.error")
/*    */ public class Error
/*    */ {
/*    */   List<Integer> errorCodes;
/*    */   List<String> errorDescription;
/*    */   
/*    */   public List<Integer> getErrorCodes()
/*    */   {
/* 17 */     return this.errorCodes;
/*    */   }
/*    */   
/* 20 */   public void setErrorCodes(List<Integer> errorCodes) { this.errorCodes = errorCodes; }
/*    */   
/*    */   public List<String> getErrorDescription() {
/* 23 */     return this.errorDescription;
/*    */   }
/*    */   
/* 26 */   public void setErrorDescription(List<String> errorDescription) { this.errorDescription = errorDescription; }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\\uof\impl\response\Error.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */