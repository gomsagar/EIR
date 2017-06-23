/*    */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ @XmlType(name="ConsumerResponseList", propOrder={"expngrpt", "NGSYSMSG", "CENQUIRY", "BURPTHDR", "BURERROR", "BURCNDLS"})
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlRootElement(name="STARTRPT")
/*    */ public class ConsumerResponseList
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @XmlElement(name="STARTRPT", required=true)
/*    */   protected Expngrpt expngrpt;
/*    */   protected Ngsysmsg NGSYSMSG;
/*    */   protected Cenquiry CENQUIRY;
/*    */   protected Burpthdr BURPTHDR;
/*    */   protected Burerror BURERROR;
/*    */   protected List<Burcndls> BURCNDLS;
/*    */   
/*    */   public Expngrpt getExpngrpt()
/*    */   {
/* 41 */     return this.expngrpt;
/*    */   }
/*    */   
/*    */   public void setExpngrpt(Expngrpt expngrpt) {
/* 45 */     this.expngrpt = expngrpt;
/*    */   }
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
/*    */   public Ngsysmsg getNGSYSMSG()
/*    */   {
/* 62 */     return this.NGSYSMSG;
/*    */   }
/*    */   
/*    */   public void setNGSYSMSG(Ngsysmsg nGSYSMSG) {
/* 66 */     this.NGSYSMSG = nGSYSMSG;
/*    */   }
/*    */   
/*    */   public Cenquiry getCENQUIRY() {
/* 70 */     return this.CENQUIRY;
/*    */   }
/*    */   
/*    */   public void setCENQUIRY(Cenquiry cENQUIRY) {
/* 74 */     this.CENQUIRY = cENQUIRY;
/*    */   }
/*    */   
/*    */   public Burpthdr getBURPTHDR() {
/* 78 */     return this.BURPTHDR;
/*    */   }
/*    */   
/*    */   public void setBURPTHDR(Burpthdr bURPTHDR) {
/* 82 */     this.BURPTHDR = bURPTHDR;
/*    */   }
/*    */   
/*    */   public Burerror getBURERROR() {
/* 86 */     return this.BURERROR;
/*    */   }
/*    */   
/*    */   public void setBURERROR(Burerror bURERROR) {
/* 90 */     this.BURERROR = bURERROR;
/*    */   }
/*    */   
/*    */   public List<Burcndls> getBURCNDLS() {
/* 94 */     return this.BURCNDLS;
/*    */   }
/*    */   
/*    */   public void setBURCNDLS(List<Burcndls> bURCNDLS) {
/* 98 */     this.BURCNDLS = bURCNDLS;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\ConsumerResponseList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */