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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Enqrhist", propOrder={"segmentCode", "enquiryDate", "enquiryPurposeCd", "enquiryConsAmtCurrencyCd", "bureauMemberIndustryCd", "bureauMemberId", "subscriberCodeCBV2", "bureauMemberName", "enquiryAmount", "enquiryRefNum", "durationofAgreement", "frequency", "enquiryAccountType", "inqAccountPurposeCd", "inqCreditPurpose", "enquiryFinRespCd", "enquiryBankAccountNumber", "enquiryTime", "prsnsrch", "persalias", "personidinq", "persaddr", "persphone", "persemail", "employer", "persdetail", "stmtalrt", "dispute"})
/*     */ public class Enqrhist
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="EnquiryDate")
/*     */   protected String enquiryDate;
/*     */   @XmlElement(name="EnquiryPurposeCd")
/*     */   protected String enquiryPurposeCd;
/*     */   @XmlElement(name="EnquiryConsAmtCurrencyCd")
/*     */   protected String enquiryConsAmtCurrencyCd;
/*     */   @XmlElement(name="BureauMemberIndustryCd")
/*     */   protected String bureauMemberIndustryCd;
/*     */   @XmlElement(name="BureauMemberId")
/*     */   protected String bureauMemberId;
/*     */   @XmlElement(name="SubscriberCodeCBV2")
/*     */   protected String subscriberCodeCBV2;
/*     */   @XmlElement(name="BureauMemberName")
/*     */   protected String bureauMemberName;
/*     */   @XmlElement(name="EnquiryAmount")
/*     */   protected String enquiryAmount;
/*     */   @XmlElement(name="EnquiryRefNum")
/*     */   protected String enquiryRefNum;
/*     */   @XmlElement(name="DurationofAgreement")
/*     */   protected String durationofAgreement;
/*     */   @XmlElement(name="Frequency")
/*     */   protected String frequency;
/*     */   @XmlElement(name="EnquiryAccountType")
/*     */   protected String enquiryAccountType;
/*     */   @XmlElement(name="InqAccountPurposeCd")
/*     */   protected String inqAccountPurposeCd;
/*     */   @XmlElement(name="InqCreditPurpose")
/*     */   protected String inqCreditPurpose;
/*     */   @XmlElement(name="EnquiryFinRespCd")
/*     */   protected String enquiryFinRespCd;
/*     */   @XmlElement(name="EnquiryBankAccountNumber")
/*     */   protected String enquiryBankAccountNumber;
/*     */   @XmlElement(name="EnquiryTime")
/*     */   protected String enquiryTime;
/*     */   @XmlElement(name="PRSNSRCH")
/*     */   protected List<Prsnsrch> prsnsrch;
/*     */   @XmlElement(name="PERSALIAS")
/*     */   protected Persalias persalias;
/*     */   @XmlElement(name="PERSONID")
/*     */   protected List<PersonidInq> personidinq;
/*     */   @XmlElement(name="PERSADDR")
/*     */   protected List<Persaddr> persaddr;
/*     */   @XmlElement(name="PERSPHONE")
/*     */   protected List<Persphone> persphone;
/*     */   @XmlElement(name="PERSEMAIL")
/*     */   protected List<Persemail> persemail;
/*     */   @XmlElement(name="EMPLOYER")
/*     */   protected Employer employer;
/*     */   @XmlElement(name="PERSDETAIL")
/*     */   protected Persdetail persdetail;
/*     */   @XmlElement(name="STMTALRT")
/*     */   protected List<Stmtalrt> stmtalrt;
/*     */   @XmlElement(name="DISPUTE")
/*     */   protected List<Dispute> dispute;
/*     */   
/*     */   public void setPrsnsrch(List<Prsnsrch> prsnsrch)
/*     */   {
/* 253 */     this.prsnsrch = prsnsrch;
/*     */   }
/*     */   
/*     */   public void setPersaddr(List<Persaddr> persaddr) {
/* 257 */     this.persaddr = persaddr;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getFrequency()
/*     */   {
/* 263 */     return this.frequency;
/*     */   }
/*     */   
/*     */   public void setFrequency(String frequency)
/*     */   {
/* 268 */     this.frequency = frequency;
/*     */   }
/*     */   
/*     */   public void setPersphone(List<Persphone> persphone) {
/* 272 */     this.persphone = persphone;
/*     */   }
/*     */   
/*     */   public void setPersemail(List<Persemail> persemail)
/*     */   {
/* 277 */     this.persemail = persemail;
/*     */   }
/*     */   
/*     */   public void setStmtalrt(List<Stmtalrt> stmtalrt) {
/* 281 */     this.stmtalrt = stmtalrt;
/*     */   }
/*     */   
/*     */   public Employer getEmployer() {
/* 285 */     return this.employer;
/*     */   }
/*     */   
/*     */   public void setEmployer(Employer employer) {
/* 289 */     this.employer = employer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSegmentCode()
/*     */   {
/* 301 */     return this.segmentCode;
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
/* 313 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryDate()
/*     */   {
/* 325 */     return this.enquiryDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryDate(String value)
/*     */   {
/* 337 */     this.enquiryDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryPurposeCd()
/*     */   {
/* 349 */     return this.enquiryPurposeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryPurposeCd(String value)
/*     */   {
/* 361 */     this.enquiryPurposeCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryConsAmtCurrencyCd()
/*     */   {
/* 373 */     return this.enquiryConsAmtCurrencyCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryConsAmtCurrencyCd(String value)
/*     */   {
/* 385 */     this.enquiryConsAmtCurrencyCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBureauMemberIndustryCd()
/*     */   {
/* 397 */     return this.bureauMemberIndustryCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBureauMemberIndustryCd(String value)
/*     */   {
/* 409 */     this.bureauMemberIndustryCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBureauMemberId()
/*     */   {
/* 421 */     return this.bureauMemberId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBureauMemberId(String value)
/*     */   {
/* 433 */     this.bureauMemberId = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBureauMemberName()
/*     */   {
/* 445 */     return this.bureauMemberName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBureauMemberName(String value)
/*     */   {
/* 457 */     this.bureauMemberName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryAmount()
/*     */   {
/* 469 */     return this.enquiryAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryAmount(String value)
/*     */   {
/* 481 */     this.enquiryAmount = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryRefNum()
/*     */   {
/* 493 */     return this.enquiryRefNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryRefNum(String value)
/*     */   {
/* 505 */     this.enquiryRefNum = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDurationofAgreement()
/*     */   {
/* 517 */     return this.durationofAgreement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDurationofAgreement(String value)
/*     */   {
/* 529 */     this.durationofAgreement = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryAccountType()
/*     */   {
/* 541 */     return this.enquiryAccountType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryAccountType(String value)
/*     */   {
/* 553 */     this.enquiryAccountType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqAccountPurposeCd()
/*     */   {
/* 565 */     return this.inqAccountPurposeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqAccountPurposeCd(String value)
/*     */   {
/* 577 */     this.inqAccountPurposeCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqCreditPurpose()
/*     */   {
/* 589 */     return this.inqCreditPurpose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqCreditPurpose(String value)
/*     */   {
/* 601 */     this.inqCreditPurpose = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryFinRespCd()
/*     */   {
/* 613 */     return this.enquiryFinRespCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryFinRespCd(String value)
/*     */   {
/* 625 */     this.enquiryFinRespCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryBankAccountNumber()
/*     */   {
/* 637 */     return this.enquiryBankAccountNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryBankAccountNumber(String value)
/*     */   {
/* 649 */     this.enquiryBankAccountNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnquiryTime()
/*     */   {
/* 661 */     return this.enquiryTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnquiryTime(String value)
/*     */   {
/* 673 */     this.enquiryTime = value;
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
/*     */   public List<Prsnsrch> getPRSNSRCH()
/*     */   {
/* 699 */     if (this.prsnsrch == null) {
/* 700 */       this.prsnsrch = new ArrayList();
/*     */     }
/* 702 */     return this.prsnsrch;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Persalias getPERSALIAS()
/*     */   {
/* 714 */     return this.persalias;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPERSALIAS(Persalias value)
/*     */   {
/* 726 */     this.persalias = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<PersonidInq> getPERSONIDINQ()
/*     */   {
/* 738 */     return this.personidinq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPERSONIDINQ(List<PersonidInq> value)
/*     */   {
/* 750 */     this.personidinq = value;
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
/*     */   public List<Persaddr> getPERSADDR()
/*     */   {
/* 776 */     if (this.persaddr == null) {
/* 777 */       this.persaddr = new ArrayList();
/*     */     }
/* 779 */     return this.persaddr;
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
/*     */   public List<Persphone> getPERSPHONE()
/*     */   {
/* 805 */     if (this.persphone == null) {
/* 806 */       this.persphone = new ArrayList();
/*     */     }
/* 808 */     return this.persphone;
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
/*     */   public List<Persemail> getPERSEMAIL()
/*     */   {
/* 834 */     if (this.persemail == null) {
/* 835 */       this.persemail = new ArrayList();
/*     */     }
/* 837 */     return this.persemail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Persdetail getPERSDETAIL()
/*     */   {
/* 849 */     return this.persdetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPERSDETAIL(Persdetail value)
/*     */   {
/* 861 */     this.persdetail = value;
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
/*     */   public List<Stmtalrt> getSTMTALRT()
/*     */   {
/* 887 */     if (this.stmtalrt == null) {
/* 888 */       this.stmtalrt = new ArrayList();
/*     */     }
/* 890 */     return this.stmtalrt;
/*     */   }
/*     */   
/*     */   public List<Dispute> getDispute() {
/* 894 */     if (this.dispute == null) {
/* 895 */       this.dispute = new ArrayList();
/*     */     }
/* 897 */     return this.dispute;
/*     */   }
/*     */   
/*     */   public void setDispute(List<Dispute> dispute) {
/* 901 */     this.dispute = dispute;
/*     */   }
/*     */   
/*     */   public String getSubscriberCodeCBV2() {
/* 905 */     return this.subscriberCodeCBV2;
/*     */   }
/*     */   
/*     */   public void setSubscriberCodeCBV2(String subscriberCodeCBV2) {
/* 909 */     this.subscriberCodeCBV2 = subscriberCodeCBV2;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Enqrhist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */