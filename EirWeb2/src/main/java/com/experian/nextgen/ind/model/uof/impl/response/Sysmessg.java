/*    */ package com.experian.nextgen.ind.model.uof.impl.response;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="sysmessg", propOrder={"systemMessageCode", "systemMessageText", "systemOutputFormatVersion", "systemMessageDescription"})
/*    */ public class Sysmessg
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String systemMessageCode;
/*    */   private String systemMessageText;
/*    */   private String systemOutputFormatVersion;
/*    */   private String systemMessageDescription;
/*    */   
/*    */   public String getSystemMessageDescription()
/*    */   {
/* 31 */     return this.systemMessageDescription;
/*    */   }
/*    */   
/* 34 */   public void setSystemMessageDescription(String systemMessageDescription) { this.systemMessageDescription = systemMessageDescription; }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getSystemMessageCode()
/*    */   {
/* 42 */     return this.systemMessageCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setSystemMessageCode(String systemMessageCode)
/*    */   {
/* 49 */     this.systemMessageCode = systemMessageCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getSystemMessageText()
/*    */   {
/* 56 */     return this.systemMessageText;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setSystemMessageText(String systemMessageText)
/*    */   {
/* 63 */     this.systemMessageText = systemMessageText;
/*    */   }
/*    */   
/*    */   public String getSystemOutputFormatVersion() {
/* 67 */     return this.systemOutputFormatVersion;
/*    */   }
/*    */   
/*    */   public void setSystemOutputFormatVersion(String systemOutputFormatVersion) {
/* 71 */     this.systemOutputFormatVersion = systemOutputFormatVersion;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\\uof\impl\response\Sysmessg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */