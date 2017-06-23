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
/*     */ @XmlType(name="Bfhlxhl", propOrder={"segmentCode", "tnOfBFHLCADExHL", "totValOfBFHLCAD", "mntsmrbfhlcad"})
/*     */ public class Bfhlxhl
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_BFHL_CAD_Ex_HL", required=true, nillable=true)
/*     */   protected String tnOfBFHLCADExHL;
/*     */   @XmlElement(name="Tot_Val_of_BFHL_CAD", required=true, nillable=true)
/*     */   protected String totValOfBFHLCAD;
/*     */   @XmlElement(name="MNT_SMR_BFHL_CAD", required=true, nillable=true)
/*     */   protected String mntsmrbfhlcad;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  90 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSegmentCode(String value)
/*     */   {
/* 102 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTNOfBFHLCADExHL()
/*     */   {
/* 114 */     return this.tnOfBFHLCADExHL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTNOfBFHLCADExHL(String value)
/*     */   {
/* 126 */     this.tnOfBFHLCADExHL = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotValOfBFHLCAD()
/*     */   {
/* 138 */     return this.totValOfBFHLCAD;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotValOfBFHLCAD(String value)
/*     */   {
/* 150 */     this.totValOfBFHLCAD = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMNTSMRBFHLCAD()
/*     */   {
/* 162 */     return this.mntsmrbfhlcad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMNTSMRBFHLCAD(String value)
/*     */   {
/* 174 */     this.mntsmrbfhlcad = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Bfhlxhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */