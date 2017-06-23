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
/*     */ @XmlType(name="Crplpsvatt", propOrder={"segmentCode", "attributeSetNameCd", "bfhlxhl", "hlcad", "telcad", "mfcad", "retcad", "totalcad", "bfhlacaxhl", "hlaca", "mfaca", "telaca", "retaca", "totalaca", "bfhlicaxhl", "hlica", "mfica", "telica", "retica", "psvcaps", "owndata", "othbrinfo", "indiavar"})
/*     */ public class Crplpsvatt
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="AttributeSetNameCd")
/*     */   protected String attributeSetNameCd;
/*     */   @XmlElement(name="BFHLXHL")
/*     */   protected Bfhlxhl bfhlxhl;
/*     */   @XmlElement(name="HLCAD")
/*     */   protected Hlcad hlcad;
/*     */   @XmlElement(name="TELCAD")
/*     */   protected Telcad telcad;
/*     */   @XmlElement(name="MFCAD")
/*     */   protected Mfcad mfcad;
/*     */   @XmlElement(name="RETCAD")
/*     */   protected Retcad retcad;
/*     */   @XmlElement(name="TOTALCAD")
/*     */   protected Totalcad totalcad;
/*     */   @XmlElement(name="BFHLACAXHL")
/*     */   protected Bfhlacaxhl bfhlacaxhl;
/*     */   @XmlElement(name="HLACA")
/*     */   protected Hlaca hlaca;
/*     */   @XmlElement(name="MFACA")
/*     */   protected Mfaca mfaca;
/*     */   @XmlElement(name="TELACA")
/*     */   protected Telaca telaca;
/*     */   @XmlElement(name="RETACA")
/*     */   protected Retaca retaca;
/*     */   @XmlElement(name="TOTALACA")
/*     */   protected Totalaca totalaca;
/*     */   @XmlElement(name="BFHLICAXHL")
/*     */   protected Bfhlicaxhl bfhlicaxhl;
/*     */   @XmlElement(name="HLICA")
/*     */   protected Hlica hlica;
/*     */   @XmlElement(name="MFICA")
/*     */   protected Mfica mfica;
/*     */   @XmlElement(name="TELICA")
/*     */   protected Telica telica;
/*     */   @XmlElement(name="RETICA")
/*     */   protected Retica retica;
/*     */   @XmlElement(name="PSVCAPS")
/*     */   protected Psvcaps psvcaps;
/*     */   @XmlElement(name="OWNDATA")
/*     */   protected Owndata owndata;
/*     */   @XmlElement(name="OTHBRINFO")
/*     */   protected Othbrinfo othbrinfo;
/*     */   @XmlElement(name="INDIAVAR")
/*     */   protected Indiavar indiavar;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 155 */     return this.segmentCode;
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
/* 167 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAttributeSetNameCd()
/*     */   {
/* 179 */     return this.attributeSetNameCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAttributeSetNameCd(String value)
/*     */   {
/* 191 */     this.attributeSetNameCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bfhlxhl getBFHLXHL()
/*     */   {
/* 203 */     return this.bfhlxhl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBFHLXHL(Bfhlxhl value)
/*     */   {
/* 215 */     this.bfhlxhl = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Hlcad getHLCAD()
/*     */   {
/* 227 */     return this.hlcad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHLCAD(Hlcad value)
/*     */   {
/* 239 */     this.hlcad = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Telcad getTELCAD()
/*     */   {
/* 251 */     return this.telcad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTELCAD(Telcad value)
/*     */   {
/* 263 */     this.telcad = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Mfcad getMFCAD()
/*     */   {
/* 275 */     return this.mfcad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMFCAD(Mfcad value)
/*     */   {
/* 287 */     this.mfcad = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Retcad getRETCAD()
/*     */   {
/* 299 */     return this.retcad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRETCAD(Retcad value)
/*     */   {
/* 311 */     this.retcad = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bfhlacaxhl getBFHLACAXHL()
/*     */   {
/* 323 */     return this.bfhlacaxhl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBFHLACAXHL(Bfhlacaxhl value)
/*     */   {
/* 335 */     this.bfhlacaxhl = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Hlaca getHLACA()
/*     */   {
/* 347 */     return this.hlaca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHLACA(Hlaca value)
/*     */   {
/* 359 */     this.hlaca = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Mfaca getMFACA()
/*     */   {
/* 371 */     return this.mfaca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMFACA(Mfaca value)
/*     */   {
/* 383 */     this.mfaca = value;
/*     */   }
/*     */   
/*     */ 
/*     */   public Telaca getTELACA()
/*     */   {
/* 389 */     return this.telaca;
/*     */   }
/*     */   
/*     */   public void setTELACA(Telaca telaca) {
/* 393 */     this.telaca = telaca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Retaca getRETACA()
/*     */   {
/* 405 */     return this.retaca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRETACA(Retaca value)
/*     */   {
/* 417 */     this.retaca = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Totalaca getTOTALACA()
/*     */   {
/* 429 */     return this.totalaca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTOTALACA(Totalaca value)
/*     */   {
/* 441 */     this.totalaca = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Totalcad getTOTALCAD()
/*     */   {
/* 453 */     return this.totalcad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTOTALCAD(Totalcad value)
/*     */   {
/* 465 */     this.totalcad = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bfhlicaxhl getBFHLICAXHL()
/*     */   {
/* 477 */     return this.bfhlicaxhl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBFHLICAXHL(Bfhlicaxhl value)
/*     */   {
/* 489 */     this.bfhlicaxhl = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Hlica getHLICA()
/*     */   {
/* 501 */     return this.hlica;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHLICA(Hlica value)
/*     */   {
/* 513 */     this.hlica = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Mfica getMFICA()
/*     */   {
/* 525 */     return this.mfica;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMFICA(Mfica value)
/*     */   {
/* 537 */     this.mfica = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Telica getTELICA()
/*     */   {
/* 549 */     return this.telica;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTELICA(Telica value)
/*     */   {
/* 561 */     this.telica = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Retica getRETICA()
/*     */   {
/* 573 */     return this.retica;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRETICA(Retica value)
/*     */   {
/* 585 */     this.retica = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Psvcaps getPSVCAPS()
/*     */   {
/* 597 */     return this.psvcaps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPSVCAPS(Psvcaps value)
/*     */   {
/* 609 */     this.psvcaps = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Owndata getOWNDATA()
/*     */   {
/* 621 */     return this.owndata;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOWNDATA(Owndata value)
/*     */   {
/* 633 */     this.owndata = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Othbrinfo getOTHBRINFO()
/*     */   {
/* 645 */     return this.othbrinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOTHBRINFO(Othbrinfo value)
/*     */   {
/* 657 */     this.othbrinfo = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Indiavar getINDIAVAR()
/*     */   {
/* 669 */     return this.indiavar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setINDIAVAR(Indiavar value)
/*     */   {
/* 681 */     this.indiavar = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Crplpsvatt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */