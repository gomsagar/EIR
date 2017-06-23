/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlRootElement(name="Business")
/*     */ public class Business
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="BureauAccuMatchId")
/*     */   protected String bureauAccuMatchId;
/*     */   @XmlElement(name="BureauAccuMatchIdTypeCd")
/*     */   protected String bureauAccuMatchIdTypeCd;
/*     */   @XmlElement(name="BureauAddDate")
/*     */   protected String bureauAddDate;
/*     */   @XmlElement(name="BureauAddSourceCd")
/*     */   protected String bureauAddSourceCd;
/*     */   @XmlElement(name="BusinessName")
/*     */   protected String businessName;
/*     */   @XmlElement(name="BusinessShortName")
/*     */   protected String businessShortName;
/*     */   @XmlElement(name="BusinessID")
/*     */   protected String businessID;
/*     */   @XmlElement(name="LegalDescription")
/*     */   protected String legalDescription;
/*     */   @XmlElement(name="IndustryType")
/*     */   protected String industryType;
/*     */   @XmlElement(name="IndustryTypeDetail")
/*     */   protected String industryTypeDetail;
/*     */   @XmlElement(name="ALIASNAM")
/*  43 */   protected List<AliasNam> aliasNam = null;
/*     */   @XmlElement(name="BEDETAILS")
/*  45 */   protected List<BDetails> bDetails = null;
/*     */   @XmlElement(name="BIDCARDS")
/*  47 */   protected List<BidCards> bidCards = null;
/*     */   @XmlElement(name="BIDADDRS")
/*  49 */   protected List<Bidaddrs> bidaddrs = null;
/*     */   @XmlElement(name="BIDPHONE")
/*  51 */   protected List<Bidphone> bidphone = null;
/*     */   @XmlElement(name="BUSSFIRM")
/*  53 */   protected List<Bussfirm> bussfirm = null;
/*     */   @XmlElement(name="BUSHIST")
/*  55 */   protected List<BusHistory> busHist = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<BusHistory> getBusHist()
/*     */   {
/*  63 */     return this.busHist;
/*     */   }
/*     */   
/*     */   public void setBusHist(List<BusHistory> busHist) {
/*  67 */     this.busHist = busHist;
/*     */   }
/*     */   
/*  70 */   public String getSegmentCode() { return this.segmentCode; }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  74 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getBureauAccuMatchId() {
/*  78 */     return this.bureauAccuMatchId;
/*     */   }
/*     */   
/*     */   public void setBureauAccuMatchId(String value) {
/*  82 */     this.bureauAccuMatchId = value;
/*     */   }
/*     */   
/*     */   public String getBureauAccuMatchIdTypeCd() {
/*  86 */     return this.bureauAccuMatchIdTypeCd;
/*     */   }
/*     */   
/*     */   public void setBureauAccuMatchIdTypeCd(String value) {
/*  90 */     this.bureauAccuMatchIdTypeCd = value;
/*     */   }
/*     */   
/*     */   public String getBureauAddDate() {
/*  94 */     return this.bureauAddDate;
/*     */   }
/*     */   
/*     */   public void setBureauAddDate(String value) {
/*  98 */     this.bureauAddDate = value;
/*     */   }
/*     */   
/*     */   public String getBureauAddSourceCd() {
/* 102 */     return this.bureauAddSourceCd;
/*     */   }
/*     */   
/*     */   public void setBureauAddSourceCd(String value) {
/* 106 */     this.bureauAddSourceCd = value;
/*     */   }
/*     */   
/*     */   public String getBusinessName() {
/* 110 */     return this.businessName;
/*     */   }
/*     */   
/*     */   public void setBusinessName(String value) {
/* 114 */     this.businessName = value;
/*     */   }
/*     */   
/*     */   public String getBusinessShortName() {
/* 118 */     return this.businessShortName;
/*     */   }
/*     */   
/*     */   public void setBusinessShortName(String value) {
/* 122 */     this.businessShortName = value;
/*     */   }
/*     */   
/*     */   public String getBusinessID() {
/* 126 */     return this.businessID;
/*     */   }
/*     */   
/*     */   public void setBusinessID(String businessID) {
/* 130 */     this.businessID = businessID;
/*     */   }
/*     */   
/*     */   public List<AliasNam> getAliasNam() {
/* 134 */     if (this.aliasNam == null) {
/* 135 */       this.aliasNam = new ArrayList();
/*     */     }
/* 137 */     return this.aliasNam;
/*     */   }
/*     */   
/*     */   public void setAliasNam(List<AliasNam> aliasNam) {
/* 141 */     this.aliasNam = aliasNam;
/*     */   }
/*     */   
/*     */   public List<BDetails> getbDetails() {
/* 145 */     if (this.bDetails == null) {
/* 146 */       this.bDetails = new ArrayList();
/*     */     }
/* 148 */     return this.bDetails;
/*     */   }
/*     */   
/*     */   public void setbDetails(List<BDetails> bDetails) {
/* 152 */     this.bDetails = bDetails;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<BidCards> getBidCards()
/*     */   {
/* 158 */     if (this.bidCards == null) {
/* 159 */       this.bidCards = new ArrayList();
/*     */     }
/* 161 */     return this.bidCards;
/*     */   }
/*     */   
/*     */   public void setBidCards(List<BidCards> bidCards) {
/* 165 */     this.bidCards = bidCards;
/*     */   }
/*     */   
/*     */   public List<Bidaddrs> getBidaddrs() {
/* 169 */     if (this.bidaddrs == null) {
/* 170 */       this.bidaddrs = new ArrayList();
/*     */     }
/* 172 */     return this.bidaddrs;
/*     */   }
/*     */   
/*     */   public void setBidaddrs(List<Bidaddrs> bidaddrs) {
/* 176 */     this.bidaddrs = bidaddrs;
/*     */   }
/*     */   
/*     */   public List<Bidphone> getBidphone()
/*     */   {
/* 181 */     if (this.bidphone == null) {
/* 182 */       this.bidphone = new ArrayList();
/*     */     }
/* 184 */     return this.bidphone;
/*     */   }
/*     */   
/*     */   public void setBidphone(List<Bidphone> bidphone) {
/* 188 */     this.bidphone = bidphone;
/*     */   }
/*     */   
/*     */   public List<Bussfirm> getBussfirm() {
/* 192 */     if (this.bussfirm == null) {
/* 193 */       this.bussfirm = new ArrayList();
/*     */     }
/* 195 */     return this.bussfirm;
/*     */   }
/*     */   
/*     */   public void setBussfirm(List<Bussfirm> bussfirm) {
/* 199 */     this.bussfirm = bussfirm;
/*     */   }
/*     */   
/*     */   public String getLegalDescription() {
/* 203 */     return this.legalDescription;
/*     */   }
/*     */   
/*     */   public void setLegalDescription(String legalDescription) {
/* 207 */     this.legalDescription = legalDescription;
/*     */   }
/*     */   
/*     */   public String getIndustryType() {
/* 211 */     return this.industryType;
/*     */   }
/*     */   
/*     */   public void setIndustryType(String industryType) {
/* 215 */     this.industryType = industryType;
/*     */   }
/*     */   
/*     */   public String getIndustryTypeDetail() {
/* 219 */     return this.industryTypeDetail;
/*     */   }
/*     */   
/*     */   public void setIndustryTypeDetail(String industryTypeDetail) {
/* 223 */     this.industryTypeDetail = industryTypeDetail;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Business.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */