/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*    */ 
/*    */ import com.experian.nextgen.ind.model.consumer.uofpojo.Consbrpt;
/*    */ import com.experian.nextgen.ind.model.uof.impl.response.Sysmessg;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="consumerResponse")
/*    */ public class ConsumerResponse
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2L;
/*    */   protected Sysmessg SYSMESSG;
/*    */   protected PersonPf PERSONPF;
/*    */   protected List<ConsCred> CONSCRED;
/*    */   protected Consbrpt CONSBRPT;
/*    */   
/*    */   public List<ConsCred> getCONSCRED()
/*    */   {
/* 30 */     return this.CONSCRED;
/*    */   }
/*    */   
/*    */   public void setCONSCRED(List<ConsCred> cONSCRED) {
/* 34 */     this.CONSCRED = cONSCRED;
/*    */   }
/*    */   
/*    */   public PersonPf getPERSONPF() {
/* 38 */     return this.PERSONPF;
/*    */   }
/*    */   
/*    */   public void setPERSONPF(PersonPf pERSONPF) {
/* 42 */     this.PERSONPF = pERSONPF;
/*    */   }
/*    */   
/*    */   public Sysmessg getSYSMESSG() {
/* 46 */     return this.SYSMESSG;
/*    */   }
/*    */   
/*    */   public void setSYSMESSG(Sysmessg systemmessage) {
/* 50 */     this.SYSMESSG = systemmessage;
/*    */   }
/*    */   
/*    */   public Consbrpt getCONSBRPT() {
/* 54 */     return this.CONSBRPT;
/*    */   }
/*    */   
/*    */   public void setCONSBRPT(Consbrpt cONSBRPT) {
/* 58 */     this.CONSBRPT = cONSBRPT;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\ConsumerResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */