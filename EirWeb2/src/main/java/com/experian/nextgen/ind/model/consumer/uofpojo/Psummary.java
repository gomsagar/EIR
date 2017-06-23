/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Psummary", propOrder={"segmentCode", "ccatotaccs", "mfitotaccs", "ccaacctbal", "mfiacctbal", "ccaaccthis", "enqattr", "enqattrcr", "enqattrncr", "vintage", "crplpsvatt", "proveIDSum"})
/*     */ public class Psummary
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="CCATOTACCS")
/*     */   protected Ccatotaccs ccatotaccs;
/*     */   @XmlElement(name="MFITOTACCS")
/*     */   protected Mfitotaccs mfitotaccs;
/*     */   @XmlElement(name="CCAACCTBAL")
/*     */   protected Ccaacctbal ccaacctbal;
/*     */   @XmlElement(name="MFIACCTBAL")
/*     */   protected Mfiacctbal mfiacctbal;
/*     */   @XmlElement(name="CCAACCTHIS")
/*     */   protected Ccaaccthis ccaaccthis;
/*     */   @XmlElement(name="ENQATTR")
/*     */   protected Enqattr enqattr;
/*     */   @XmlElement(name="ENQATTRALL")
/*     */   protected Enqattrcr enqattrcr;
/*     */   @XmlElement(name="ENQATTRNCR")
/*     */   protected Enqattrncr enqattrncr;
/*     */   @XmlElement(name="VINTAGE")
/*     */   protected List<Vintage> vintage;
/*     */   @XmlElement(name="CRPLPSVATT")
/*     */   protected Crplpsvatt crplpsvatt;
/*     */   @XmlElement(name="PROVEIDSUM")
/*     */   protected ProveIDSum proveIDSum;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 107 */     return this.segmentCode;
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
/* 119 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ccatotaccs getCCATOTACCS()
/*     */   {
/* 131 */     return this.ccatotaccs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCCATOTACCS(Ccatotaccs value)
/*     */   {
/* 143 */     this.ccatotaccs = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Mfitotaccs getMFITOTACCS()
/*     */   {
/* 155 */     return this.mfitotaccs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMFITOTACCS(Mfitotaccs value)
/*     */   {
/* 167 */     this.mfitotaccs = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ccaacctbal getCCAACCTBAL()
/*     */   {
/* 179 */     return this.ccaacctbal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCCAACCTBAL(Ccaacctbal value)
/*     */   {
/* 191 */     this.ccaacctbal = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Mfiacctbal getMFIACCTBAL()
/*     */   {
/* 203 */     return this.mfiacctbal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMFIACCTBAL(Mfiacctbal value)
/*     */   {
/* 215 */     this.mfiacctbal = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ccaaccthis getCCAACCTHIS()
/*     */   {
/* 227 */     return this.ccaaccthis;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCCAACCTHIS(Ccaaccthis value)
/*     */   {
/* 239 */     this.ccaaccthis = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enqattr getENQATTR()
/*     */   {
/* 251 */     return this.enqattr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setENQATTR(Enqattr value)
/*     */   {
/* 263 */     this.enqattr = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enqattrcr getENQATTRCR()
/*     */   {
/* 275 */     return this.enqattrcr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setENQATTRCR(Enqattrcr value)
/*     */   {
/* 287 */     this.enqattrcr = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enqattrncr getENQATTRNCR()
/*     */   {
/* 299 */     return this.enqattrncr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setENQATTRNCR(Enqattrncr value)
/*     */   {
/* 311 */     this.enqattrncr = value;
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
/*     */   public List<Vintage> getVINTAGE()
/*     */   {
/* 337 */     if (this.vintage == null) {
/* 338 */       this.vintage = new ArrayList();
/*     */     }
/* 340 */     return this.vintage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Crplpsvatt getCRPLPSVATT()
/*     */   {
/* 352 */     return this.crplpsvatt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCRPLPSVATT(Crplpsvatt value)
/*     */   {
/* 364 */     this.crplpsvatt = value;
/*     */   }
/*     */   
/*     */   public ProveIDSum getProveIDSum() {
/* 368 */     return this.proveIDSum;
/*     */   }
/*     */   
/*     */   public void setProveIDSum(ProveIDSum proveIDSum) {
/* 372 */     this.proveIDSum = proveIDSum;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Psummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */