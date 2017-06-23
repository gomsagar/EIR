/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="CommercialStmtalrt", propOrder={"segmentCode", "statementDate", "statementExpirationDate", "statementTypeCode", "contactPhone", "statementText"})
/*     */ public class ConsumerStmtalrt
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="StatementDate")
/*     */   protected String statementDate;
/*     */   @XmlElement(name="StatementExpirationDate")
/*     */   protected String statementExpirationDate;
/*     */   @XmlElement(name="StatementTypeCode")
/*     */   protected String statementTypeCode;
/*     */   @XmlElement(name="ContactPhone")
/*     */   protected String contactPhone;
/*     */   @XmlElement(name="StatementText")
/*     */   protected String statementText;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  45 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  50 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getStatementDate()
/*     */   {
/*  55 */     return this.statementDate;
/*     */   }
/*     */   
/*     */   public void setStatementDate(String value)
/*     */   {
/*  60 */     this.statementDate = value;
/*     */   }
/*     */   
/*     */   public String getStatementExpirationDate()
/*     */   {
/*  65 */     return this.statementExpirationDate;
/*     */   }
/*     */   
/*     */   public void setStatementExpirationDate(String value)
/*     */   {
/*  70 */     this.statementExpirationDate = value;
/*     */   }
/*     */   
/*     */   public String getStatementTypeCode()
/*     */   {
/*  75 */     return this.statementTypeCode;
/*     */   }
/*     */   
/*     */   public void setStatementTypeCode(String value)
/*     */   {
/*  80 */     this.statementTypeCode = value;
/*     */   }
/*     */   
/*     */   public String getContactPhone()
/*     */   {
/*  85 */     return this.contactPhone;
/*     */   }
/*     */   
/*     */   public void setContactPhone(String value)
/*     */   {
/*  90 */     this.contactPhone = value;
/*     */   }
/*     */   
/*     */   public String getStatementText()
/*     */   {
/*  95 */     return this.statementText;
/*     */   }
/*     */   
/*     */   public void setStatementText(String value)
/*     */   {
/* 100 */     this.statementText = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\ConsumerStmtalrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */