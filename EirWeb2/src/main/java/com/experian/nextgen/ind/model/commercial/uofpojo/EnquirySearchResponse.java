/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*    */ 
/*    */ import com.experian.nextgen.ind.model.uof.impl.response.Sysmessg;
/*    */ import com.thoughtworks.xstream.annotations.XStreamAlias;
/*    */ import java.io.Serializable;
/*    */ import javax.activation.DataHandler;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlMimeType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlRootElement
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="enquirySearchResponse", namespace="uof.shared", propOrder={"systemMessage", "BURPTHDR", "BURERROR", "srchrsp1", "attachment2"})
/*    */ @XStreamAlias("enquirySearchResponse")
/*    */ public class EnquirySearchResponse
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Sysmessg systemMessage;
/*    */   protected BurError BURERROR;
/*    */   @XmlMimeType("application/pdf")
/*    */   private DataHandler attachment2;
/*    */   
/*    */   public DataHandler getAttachment2()
/*    */   {
/* 42 */     return this.attachment2;
/*    */   }
/*    */   
/* 45 */   public void setAttachment2(DataHandler attachment2) { this.attachment2 = attachment2; }
/*    */   
/*    */   public Sysmessg getSystemMessage() {
/* 48 */     return this.systemMessage;
/*    */   }
/*    */   
/* 51 */   public void setSystemMessage(Sysmessg systemMessage) { this.systemMessage = systemMessage; }
/*    */   
/*    */   public BurError getBURERROR()
/*    */   {
/* 55 */     return this.BURERROR;
/*    */   }
/*    */   
/* 58 */   public void setBURERROR(BurError bURERROR) { this.BURERROR = bURERROR; }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\EnquirySearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */