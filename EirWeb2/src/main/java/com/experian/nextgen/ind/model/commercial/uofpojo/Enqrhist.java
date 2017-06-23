/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import com.experian.nextgen.ind.model.consumer.uofpojo.Persaddr;
/*     */ import com.experian.nextgen.ind.model.consumer.uofpojo.Persphone;
/*     */ import com.experian.nextgen.ind.model.consumer.uofpojo.Pidcards;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Enqrhist", propOrder={"segmentCode", "enquiryDate", "enquiryPurposeCd", "accountType", "enquiryConsAmtCurrencyCd", "bureauMemberId", "enquiryAmount", "enquiryIndustryCd", "personSrchInfo", "personIdInfo", "personAddrInfo", "personPhoneInfo", "dispute"})
/*     */ public class Enqrhist
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="EnquiryDate")
/*     */   protected String enquiryDate;
/*     */   @XmlElement(name="EnquiryPurposeCd")
/*     */   protected String enquiryPurposeCd;
/*     */   @XmlElement(name="AccountType")
/*     */   protected String accountType;
/*     */   @XmlElement(name="EnquiryConsAmtCurrencyCd")
/*     */   protected String enquiryConsAmtCurrencyCd;
/*     */   @XmlElement(name="BureauMemberId")
/*     */   protected String bureauMemberId;
/*     */   @XmlElement(name="EnquiryAmount")
/*     */   protected String enquiryAmount;
/*     */   @XmlElement(name="EnquiryIndustryCd")
/*     */   protected String enquiryIndustryCd;
/*     */   @XmlElement(name="PRSNSRCH")
/*  54 */   protected List<PrsnSrch> personSrchInfo = null;
/*     */   @XmlElement(name="PERSONID")
/*  56 */   protected List<Pidcards> personIdInfo = null;
/*     */   @XmlElement(name="PERSADDR")
/*  58 */   protected List<Persaddr> personAddrInfo = null;
/*     */   @XmlElement(name="PERSPHONE")
/*  60 */   protected List<Persphone> personPhoneInfo = null;
/*     */   @XmlElement(name="Dispute")
/*  62 */   protected List<Dispute> dispute = null;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  66 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  71 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getEnquiryDate()
/*     */   {
/*  76 */     return this.enquiryDate;
/*     */   }
/*     */   
/*     */   public void setEnquiryDate(String value)
/*     */   {
/*  81 */     this.enquiryDate = value;
/*     */   }
/*     */   
/*     */   public String getEnquiryPurposeCd()
/*     */   {
/*  86 */     return this.enquiryPurposeCd;
/*     */   }
/*     */   
/*     */   public void setEnquiryPurposeCd(String value)
/*     */   {
/*  91 */     this.enquiryPurposeCd = value;
/*     */   }
/*     */   
/*     */   public String getAccountType() {
/*  95 */     return this.accountType;
/*     */   }
/*     */   
/*     */   public void setAccountType(String value)
/*     */   {
/* 100 */     this.accountType = value;
/*     */   }
/*     */   
/*     */   public String getEnquiryConsAmtCurrencyCd() {
/* 104 */     return this.enquiryConsAmtCurrencyCd;
/*     */   }
/*     */   
/*     */   public void setEnquiryConsAmtCurrencyCd(String value) {
/* 108 */     this.enquiryConsAmtCurrencyCd = value;
/*     */   }
/*     */   
/*     */   public String getBureauMemberId()
/*     */   {
/* 113 */     return this.bureauMemberId;
/*     */   }
/*     */   
/*     */   public void setBureauMemberId(String value)
/*     */   {
/* 118 */     this.bureauMemberId = value;
/*     */   }
/*     */   
/*     */   public String getEnquiryAmount()
/*     */   {
/* 123 */     return this.enquiryAmount;
/*     */   }
/*     */   
/*     */   public void setEnquiryAmount(String value)
/*     */   {
/* 128 */     this.enquiryAmount = value;
/*     */   }
/*     */   
/*     */   public String getEnquiryIndustryCd()
/*     */   {
/* 133 */     return this.enquiryIndustryCd;
/*     */   }
/*     */   
/*     */   public void setEnquiryIndustryCd(String value)
/*     */   {
/* 138 */     this.enquiryIndustryCd = value;
/*     */   }
/*     */   
/*     */   public List<PrsnSrch> getPersonSrchInfo() {
/* 142 */     return this.personSrchInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setPersonSrchInfo(List<PrsnSrch> personSrchInfo)
/*     */   {
/* 148 */     this.personSrchInfo = personSrchInfo;
/*     */   }
/*     */   
/*     */   public List<Pidcards> getPersonIdInfo()
/*     */   {
/* 153 */     return this.personIdInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setPersonIdInfo(List<Pidcards> personIdInfo)
/*     */   {
/* 159 */     this.personIdInfo = personIdInfo;
/*     */   }
/*     */   
/*     */   public List<Persaddr> getPersonAddrInfo()
/*     */   {
/* 164 */     return this.personAddrInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setPersonAddrInfo(List<Persaddr> personAddrInfo)
/*     */   {
/* 170 */     this.personAddrInfo = personAddrInfo;
/*     */   }
/*     */   
/*     */   public List<Persphone> getPersonPhoneInfo()
/*     */   {
/* 175 */     return this.personPhoneInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setPersonPhoneInfo(List<Persphone> personPhoneInfo)
/*     */   {
/* 181 */     this.personPhoneInfo = personPhoneInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Dispute> getDispute()
/*     */   {
/* 188 */     return this.dispute;
/*     */   }
/*     */   
/*     */   public void setDispute(List<Dispute> dispute)
/*     */   {
/* 193 */     this.dispute = dispute;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Enqrhist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */