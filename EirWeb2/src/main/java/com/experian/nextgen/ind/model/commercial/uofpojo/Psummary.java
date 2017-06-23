/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
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
/*     */ @XmlType(name="Psummary", propOrder={"segmentCode", "grantor", "accsum", "guaranto", "currcystat", "currcycnct", "credtype", "enqattr"})
/*     */ public class Psummary
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="GRANTOR")
/*     */   protected Grantor grantor;
/*     */   @XmlElement(name="ACCSUM")
/*     */   protected Accsum accsum;
/*     */   @XmlElement(name="GUARANTO")
/*     */   protected Guaranto guaranto;
/*     */   @XmlElement(name="CURRCYSTAT")
/*     */   protected Currcystat currcystat;
/*     */   @XmlElement(name="CURRCYCNCT")
/*     */   protected List<Currcycnct> currcycnct;
/*     */   @XmlElement(name="CREDTYPE")
/*     */   protected List<Credtype> credtype;
/*     */   @XmlElement(name="ENQATTR")
/*     */   protected Enqattr enqattr;
/*     */   
/*     */   public List<Credtype> getCredtype()
/*     */   {
/*  49 */     return this.credtype;
/*     */   }
/*     */   
/*     */   public void setCredtype(List<Credtype> credtype) {
/*  53 */     this.credtype = credtype;
/*     */   }
/*     */   
/*     */   public String getSegmentCode() {
/*  57 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value) {
/*  61 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Currcycnct> getCurrcycnct()
/*     */   {
/*  68 */     return this.currcycnct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCurrcycnct(List<Currcycnct> currcycnct)
/*     */   {
/*  76 */     this.currcycnct = currcycnct;
/*     */   }
/*     */   
/*     */   public Grantor getGrantor() {
/*  80 */     return this.grantor;
/*     */   }
/*     */   
/*     */   public void setGrantor(Grantor grantor) {
/*  84 */     this.grantor = grantor;
/*     */   }
/*     */   
/*     */   public Accsum getAccsum() {
/*  88 */     return this.accsum;
/*     */   }
/*     */   
/*     */   public void setAccsum(Accsum accsum) {
/*  92 */     this.accsum = accsum;
/*     */   }
/*     */   
/*     */   public Guaranto getGuaranto() {
/*  96 */     return this.guaranto;
/*     */   }
/*     */   
/*     */   public void setGuaranto(Guaranto guaranto) {
/* 100 */     this.guaranto = guaranto;
/*     */   }
/*     */   
/*     */   public Enqattr getEnqattr() {
/* 104 */     return this.enqattr;
/*     */   }
/*     */   
/*     */   public void setEnqattr(Enqattr enqattr) {
/* 108 */     this.enqattr = enqattr;
/*     */   }
/*     */   
/*     */   public Currcystat getCurrcystat()
/*     */   {
/* 113 */     return this.currcystat;
/*     */   }
/*     */   
/*     */   public void setCurrcystat(Currcystat currcystat) {
/* 117 */     this.currcystat = currcystat;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Psummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */