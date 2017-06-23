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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Nginquiry", propOrder={"segmentCode", "inqUserId", "inqBureauMemberId", "inqSubscriberCodeCBV2", "inqBureauMemberIndustry", "inqBureauMemberName", "clientEnquiryRefNumber", "inqPurposeCd", "inqAcctTypeCd", "inqFinRespCd", "inqAmt", "inqAmtMonetaryCd", "inqFrequency", "inqProductName", "inqProductCd", "inqProductSearchTypeCd", "inqAccountPurposeCd", "inqCreditPurpose", "inqDurationofAgreement", "perinput"})
/*     */ public class Nginquiry
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="InqUserId")
/*     */   protected String inqUserId;
/*     */   @XmlElement(name="InqBureauMemberId")
/*     */   protected String inqBureauMemberId;
/*     */   @XmlElement(name="inqSubscriberCodeCBV2")
/*     */   protected String inqSubscriberCodeCBV2;
/*     */   @XmlElement(name="InqBureauMemberIndustry")
/*     */   protected String inqBureauMemberIndustry;
/*     */   @XmlElement(name="InqBureauMemberName")
/*     */   protected String inqBureauMemberName;
/*     */   @XmlElement(name="ClientEnquiryRefNumber")
/*     */   protected String clientEnquiryRefNumber;
/*     */   @XmlElement(name="InqPurposeCd")
/*     */   protected String inqPurposeCd;
/*     */   @XmlElement(name="InqAcctTypeCd")
/*     */   protected String inqAcctTypeCd;
/*     */   @XmlElement(name="InqFinRespCd")
/*     */   protected String inqFinRespCd;
/*     */   @XmlElement(name="InqAmt")
/*     */   protected String inqAmt;
/*     */   @XmlElement(name="InqAmtMonetaryCd")
/*     */   protected String inqAmtMonetaryCd;
/*     */   @XmlElement(name="InqFrequency")
/*     */   protected String inqFrequency;
/*     */   @XmlElement(name="InqProductName")
/*     */   protected String inqProductName;
/*     */   @XmlElement(name="InqProductCd")
/*     */   protected String inqProductCd;
/*     */   @XmlElement(name="InqProductSearchTypeCd")
/*     */   protected String inqProductSearchTypeCd;
/*     */   @XmlElement(name="InqAccountPurposeCd")
/*     */   protected String inqAccountPurposeCd;
/*     */   @XmlElement(name="InqCreditPurpose", required=true)
/*     */   protected String inqCreditPurpose;
/*     */   @XmlElement(name="InqDurationofAgreement", required=true)
/*     */   protected String inqDurationofAgreement;
/*     */   @XmlElement(name="PERINPUT")
/*     */   protected Perinput perinput;
/*     */   
/*     */   public Perinput getPerinput()
/*     */   {
/* 189 */     return this.perinput;
/*     */   }
/*     */   
/*     */   public void setPerinput(Perinput perinput) {
/* 193 */     this.perinput = perinput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 248 */     return this.segmentCode;
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
/* 260 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqUserId()
/*     */   {
/* 272 */     return this.inqUserId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqUserId(String value)
/*     */   {
/* 284 */     this.inqUserId = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqBureauMemberId()
/*     */   {
/* 296 */     return this.inqBureauMemberId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqBureauMemberId(String value)
/*     */   {
/* 308 */     this.inqBureauMemberId = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqBureauMemberIndustry()
/*     */   {
/* 320 */     return this.inqBureauMemberIndustry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqBureauMemberIndustry(String value)
/*     */   {
/* 332 */     this.inqBureauMemberIndustry = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqBureauMemberName()
/*     */   {
/* 344 */     return this.inqBureauMemberName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqBureauMemberName(String value)
/*     */   {
/* 356 */     this.inqBureauMemberName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getClientEnquiryRefNumber()
/*     */   {
/* 368 */     return this.clientEnquiryRefNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setClientEnquiryRefNumber(String value)
/*     */   {
/* 380 */     this.clientEnquiryRefNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqPurposeCd()
/*     */   {
/* 392 */     return this.inqPurposeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqPurposeCd(String value)
/*     */   {
/* 404 */     this.inqPurposeCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqAcctTypeCd()
/*     */   {
/* 416 */     return this.inqAcctTypeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqAcctTypeCd(String value)
/*     */   {
/* 428 */     this.inqAcctTypeCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqFinRespCd()
/*     */   {
/* 440 */     return this.inqFinRespCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqFinRespCd(String value)
/*     */   {
/* 452 */     this.inqFinRespCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqAmt()
/*     */   {
/* 464 */     return this.inqAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqAmt(String value)
/*     */   {
/* 476 */     this.inqAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqAmtMonetaryCd()
/*     */   {
/* 488 */     return this.inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqAmtMonetaryCd(String value)
/*     */   {
/* 500 */     this.inqAmtMonetaryCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqFrequency()
/*     */   {
/* 512 */     return this.inqFrequency;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqFrequency(String value)
/*     */   {
/* 524 */     this.inqFrequency = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqProductName()
/*     */   {
/* 536 */     return this.inqProductName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqProductName(String value)
/*     */   {
/* 548 */     this.inqProductName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqProductCd()
/*     */   {
/* 560 */     return this.inqProductCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqProductCd(String value)
/*     */   {
/* 572 */     this.inqProductCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqProductSearchTypeCd()
/*     */   {
/* 584 */     return this.inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqProductSearchTypeCd(String value)
/*     */   {
/* 596 */     this.inqProductSearchTypeCd = value;
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
/* 608 */     return this.inqAccountPurposeCd;
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
/* 620 */     this.inqAccountPurposeCd = value;
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
/* 632 */     return this.inqCreditPurpose;
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
/* 644 */     this.inqCreditPurpose = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInqDurationofAgreement()
/*     */   {
/* 656 */     return this.inqDurationofAgreement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInqDurationofAgreement(String value)
/*     */   {
/* 668 */     this.inqDurationofAgreement = value;
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
/*     */   public Perinput getPERINPUT()
/*     */   {
/* 694 */     return this.perinput;
/*     */   }
/*     */   
/*     */   public String getInqSubscriberCodeCBV2() {
/* 698 */     return this.inqSubscriberCodeCBV2;
/*     */   }
/*     */   
/*     */   public void setInqSubscriberCodeCBV2(String inqSubscriberCodeCBV2) {
/* 702 */     this.inqSubscriberCodeCBV2 = inqSubscriberCodeCBV2;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Nginquiry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */