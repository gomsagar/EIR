/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"expngrpt", "ngsysmsg", "nginquiry", "consbrpt", "burerror", "personid", "stmtalrt", "psummary", "modelscr", "conscred", "enqrhist", "endofrpt", "constmtalrt"})
/*     */ @XmlRootElement(name="consumerResponse")
/*     */ public class ConsumerResponse
/*     */ {
/*     */   @XmlElement(name="EXPNGRPT", required=true)
/*     */   protected Expngrpt expngrpt;
/*     */   @XmlElement(name="NGSYSMSG", required=true)
/*     */   protected Ngsysmsg ngsysmsg;
/*     */   @XmlElement(name="NGINQUIRY", required=true)
/*     */   protected Nginquiry nginquiry;
/*     */   @XmlElement(name="CONSBRPT", required=true)
/*     */   protected Consbrpt consbrpt;
/*     */   @XmlElement(name="BURERROR")
/*     */   protected Burerror burerror;
/*     */   @XmlElement(name="PERSONID")
/*     */   protected Personid personid;
/*     */   @XmlElement(name="STMTALRT")
/*     */   protected List<Stmtalrt> stmtalrt;
/*     */   @XmlElement(name="PSUMMARY")
/*     */   protected Psummary psummary;
/*     */   @XmlElement(name="MODELSCR")
/*     */   protected Modelscr modelscr;
/*     */   @XmlElement(name="CONSCRED")
/*     */   protected List<Conscred> conscred;
/*     */   @XmlElement(name="ENQRHIST")
/*     */   protected List<Enqrhist> enqrhist;
/*     */   @XmlElement(name="ENDOFRPT", required=true)
/*     */   protected Endofrpt endofrpt;
/*     */   @XmlElement(name="CONSTMTALRT")
/*     */   protected List<ConsumerStmtalrt> constmtalrt;
/*     */   
/*     */   public Expngrpt getEXPNGRPT()
/*     */   {
/* 108 */     return this.expngrpt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEXPNGRPT(Expngrpt value)
/*     */   {
/* 120 */     this.expngrpt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ngsysmsg getNGSYSMSG()
/*     */   {
/* 132 */     return this.ngsysmsg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNGSYSMSG(Ngsysmsg value)
/*     */   {
/* 144 */     this.ngsysmsg = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Nginquiry getNGINQUIRY()
/*     */   {
/* 156 */     return this.nginquiry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNGINQUIRY(Nginquiry value)
/*     */   {
/* 168 */     this.nginquiry = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Consbrpt getCONSBRPT()
/*     */   {
/* 180 */     return this.consbrpt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCONSBRPT(Consbrpt value)
/*     */   {
/* 192 */     this.consbrpt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Burerror getBURERROR()
/*     */   {
/* 204 */     return this.burerror;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBURERROR(Burerror value)
/*     */   {
/* 216 */     this.burerror = value;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Personid getPERSONID()
/*     */   {
/* 243 */     return this.personid;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPersonid(Personid personid)
/*     */   {
/* 272 */     this.personid = personid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Psummary getPSUMMARY()
/*     */   {
/* 284 */     return this.psummary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPSUMMARY(Psummary value)
/*     */   {
/* 296 */     this.psummary = value;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Modelscr getModelscr()
/*     */   {
/* 326 */     return this.modelscr;
/*     */   }
/*     */   
/*     */   public void setModelscr(Modelscr modelscr) {
/* 330 */     this.modelscr = modelscr;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Enqrhist> getENQRHIST()
/*     */   {
/* 356 */     if (this.enqrhist == null) {
/* 357 */       this.enqrhist = new ArrayList();
/*     */     }
/* 359 */     return this.enqrhist;
/*     */   }
/*     */   
/*     */   public void setENQRHIST(List<Enqrhist> value)
/*     */   {
/* 364 */     this.enqrhist = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Endofrpt getENDOFRPT()
/*     */   {
/* 375 */     return this.endofrpt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setENDOFRPT(Endofrpt value)
/*     */   {
/* 387 */     this.endofrpt = value;
/*     */   }
/*     */   
/*     */   public List<Conscred> getConscred() {
/* 391 */     return this.conscred;
/*     */   }
/*     */   
/*     */   public void setConscred(List<Conscred> conscred) {
/* 395 */     this.conscred = conscred;
/*     */   }
/*     */   
/*     */   public List<ConsumerStmtalrt> getConstmtalrt() {
/* 399 */     return this.constmtalrt;
/*     */   }
/*     */   
/*     */   public void setConstmtalrt(List<ConsumerStmtalrt> constmtalrt) {
/* 403 */     this.constmtalrt = constmtalrt;
/*     */   }
/*     */   
/*     */   public List<Stmtalrt> getSTMTALRT() {
/* 407 */     if (this.stmtalrt == null) {
/* 408 */       this.stmtalrt = new ArrayList();
/*     */     }
/* 410 */     return this.stmtalrt;
/*     */   }
/*     */   
/*     */   public void setSTMTALRT(List<Stmtalrt> stmtalrt) {
/* 414 */     this.stmtalrt = stmtalrt;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\ConsumerResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */