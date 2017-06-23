/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="BusinessResponse")
/*     */ public class BusinessResponse
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @XmlElement(name="NGSYSMSG")
/*     */   private Ngsysmsg ngSysmsg;
/*     */   @XmlElement(name="BURERROR")
/*     */   private BurError burError;
/*     */   @XmlElement(name="NGINQUIRY")
/*     */   private Nginquiry ngInquiry;
/*     */   @XmlElement(name="COMMBRPT")
/*     */   private CommBrpt commBrpt;
/*     */   @XmlElement(name="BUSINESS")
/*     */   private Business business;
/*     */   @XmlElement(name="PSUMMARY")
/*     */   private Psummary pSummary;
/*     */   @XmlElement(name="COMMCRED")
/*     */   private List<Commcred> commCred;
/*     */   @XmlElement(name="RELATIONS")
/*     */   private List<Relations> relations;
/*     */   @XmlElement(name="ENQRHIST")
/*     */   private List<Enqrhist> enqrHist;
/*     */   @XmlElement(name="STMTALRT")
/*     */   private List<CommercialStmtalrt> stmtAlrt;
/*     */   
/*     */   public Business getBUSINESS()
/*     */   {
/*  46 */     return this.business;
/*     */   }
/*     */   
/*     */   public void setBUSINESS(Business bUSINESS) {
/*  50 */     this.business = bUSINESS;
/*     */   }
/*     */   
/*     */   public List<Enqrhist> getENQRHIST() {
/*  54 */     return this.enqrHist;
/*     */   }
/*     */   
/*     */   public void setENQRHIST(List<Enqrhist> eNQRHIST) {
/*  58 */     this.enqrHist = eNQRHIST;
/*     */   }
/*     */   
/*     */   public Ngsysmsg getNGSYSMSG() {
/*  62 */     return this.ngSysmsg;
/*     */   }
/*     */   
/*     */   public void setNGSYSMSG(Ngsysmsg nGSYSMSG) {
/*  66 */     this.ngSysmsg = nGSYSMSG;
/*     */   }
/*     */   
/*  69 */   public CommBrpt getCOMMBRPT() { return this.commBrpt; }
/*     */   
/*     */   public void setCOMMBRPT(CommBrpt cOMMBRPT)
/*     */   {
/*  73 */     this.commBrpt = cOMMBRPT;
/*     */   }
/*     */   
/*  76 */   public Nginquiry getNGINQUIRY() { return this.ngInquiry; }
/*     */   
/*     */   public void setNGINQUIRY(Nginquiry nGINQUIRY) {
/*  79 */     this.ngInquiry = nGINQUIRY;
/*     */   }
/*     */   
/*  82 */   public List<Relations> getRELATIONS() { return this.relations; }
/*     */   
/*     */   public void setRELATIONS(List<Relations> rELATIONS) {
/*  85 */     this.relations = rELATIONS;
/*     */   }
/*     */   
/*     */   public List<Commcred> getCOMMCRED() {
/*  89 */     return this.commCred;
/*     */   }
/*     */   
/*  92 */   public void setCOMMCRED(List<Commcred> cOMMCRED) { this.commCred = cOMMCRED; }
/*     */   
/*     */   public Psummary getPSUMMARY() {
/*  95 */     return this.pSummary;
/*     */   }
/*     */   
/*  98 */   public void setPSUMMARY(Psummary pSUMMARY) { this.pSummary = pSUMMARY; }
/*     */   
/*     */   public BurError getBURERROR()
/*     */   {
/* 102 */     return this.burError;
/*     */   }
/*     */   
/*     */   public void setBURERROR(BurError bURERROR) {
/* 106 */     this.burError = bURERROR;
/*     */   }
/*     */   
/*     */   public List<CommercialStmtalrt> getSTMTALRT() {
/* 110 */     return this.stmtAlrt;
/*     */   }
/*     */   
/*     */   public void setSTMTALRT(List<CommercialStmtalrt> sTMTALRT) {
/* 114 */     this.stmtAlrt = sTMTALRT;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BusinessResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */