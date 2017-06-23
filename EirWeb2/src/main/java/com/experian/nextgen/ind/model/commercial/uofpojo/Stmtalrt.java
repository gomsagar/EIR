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
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Stmtalrt", propOrder={"segmentCode", "statementDate", "statementExpirationDate", "statementTypeCode", "contactPhone", "statementText"})
/*    */ public class Stmtalrt
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="StatementDate")
/*    */   protected String statementDate;
/*    */   @XmlElement(name="StatementExpirationDate")
/*    */   protected String statementExpirationDate;
/*    */   @XmlElement(name="StatementTypeCode")
/*    */   protected String statementTypeCode;
/*    */   @XmlElement(name="ContactPhone")
/*    */   protected String contactPhone;
/*    */   @XmlElement(name="StatementText")
/*    */   protected String statementText;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 44 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 49 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getStatementDate()
/*    */   {
/* 54 */     return this.statementDate;
/*    */   }
/*    */   
/*    */   public void setStatementDate(String value)
/*    */   {
/* 59 */     this.statementDate = value;
/*    */   }
/*    */   
/*    */   public String getStatementExpirationDate()
/*    */   {
/* 64 */     return this.statementExpirationDate;
/*    */   }
/*    */   
/*    */   public void setStatementExpirationDate(String value)
/*    */   {
/* 69 */     this.statementExpirationDate = value;
/*    */   }
/*    */   
/*    */   public String getStatementTypeCode()
/*    */   {
/* 74 */     return this.statementTypeCode;
/*    */   }
/*    */   
/*    */   public void setStatementTypeCode(String value)
/*    */   {
/* 79 */     this.statementTypeCode = value;
/*    */   }
/*    */   
/*    */   public String getContactPhone()
/*    */   {
/* 84 */     return this.contactPhone;
/*    */   }
/*    */   
/*    */   public void setContactPhone(String value)
/*    */   {
/* 89 */     this.contactPhone = value;
/*    */   }
/*    */   
/*    */   public String getStatementText()
/*    */   {
/* 94 */     return this.statementText;
/*    */   }
/*    */   
/*    */   public void setStatementText(String value)
/*    */   {
/* 99 */     this.statementText = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Stmtalrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */