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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Nginquiry", propOrder={"segmentCode", "inqUserId", "inqBureauMemberId", "inqBureauMemberIndustry", "inqBureauMemberName", "inqRefNum", "inqPurposeCd", "inqAcctTypeCd", "inqAmt", "inqAmtMonetaryCd", "inqProductName", "inqProductCd", "inqProductSearchTypeCd", "frequency", "inqCompanyName", "enquiryApplicationType", "durationOfAgreement", "inqCompanyBankAccNumber", "InqPAN", "ngInqAddr", "ngInqTel", "perinput"})
/*     */ public class Nginquiry
/*     */ {
/*     */   @XmlElement(name="SegmentCode", required=true)
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="InqUserId", required=true)
/*     */   protected String inqUserId;
/*     */   @XmlElement(name="InqBureauMemberId", required=true)
/*     */   protected String inqBureauMemberId;
/*     */   @XmlElement(name="InqBureauMemberIndustry", required=true)
/*     */   protected String inqBureauMemberIndustry;
/*     */   @XmlElement(name="InqBureauMemberName", required=true)
/*     */   protected String inqBureauMemberName;
/*     */   @XmlElement(name="InqRefNum", required=true)
/*     */   protected String inqRefNum;
/*     */   @XmlElement(name="InqPurposeCd", required=true)
/*     */   protected String inqPurposeCd;
/*     */   @XmlElement(name="InqAcctTypeCd", required=true)
/*     */   protected String inqAcctTypeCd;
/*     */   @XmlElement(name="InqAmt", required=true)
/*     */   protected String inqAmt;
/*     */   @XmlElement(name="InqAmtMonetaryCd", required=true)
/*     */   protected String inqAmtMonetaryCd;
/*     */   @XmlElement(name="InqProductName", required=true)
/*     */   protected String inqProductName;
/*     */   @XmlElement(name="InqProductCd", required=true)
/*     */   protected String inqProductCd;
/*     */   @XmlElement(name="InqProductSearchTypeCd", required=true)
/*     */   protected String inqProductSearchTypeCd;
/*     */   @XmlElement(name="Frequency", required=true)
/*     */   protected String frequency;
/*     */   @XmlElement(name="InqCompanyName", required=true)
/*     */   protected String inqCompanyName;
/*     */   @XmlElement(name="EnquiryApplicationType", required=true)
/*     */   protected String enquiryApplicationType;
/*     */   @XmlElement(name="DurationofAgreement", required=true)
/*     */   protected String durationOfAgreement;
/*     */   @XmlElement(name="InqCompanyBankAccNumber", required=true)
/*     */   protected String inqCompanyBankAccNumber;
/*     */   @XmlElement(name="InqPAN", required=true)
/*     */   protected String InqPAN;
/*     */   @XmlElement(name="NGINQADDR", required=true)
/*     */   protected List<NgInqAddr> ngInqAddr;
/*     */   @XmlElement(name="NGINQTEL", required=true)
/*     */   protected List<NgInqTel> ngInqTel;
/*     */   @XmlElement(name="PERINPUT", required=true)
/*     */   protected Perinput perinput;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 117 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String segmentCode) {
/* 121 */     this.segmentCode = segmentCode;
/*     */   }
/*     */   
/*     */   public String getInqUserId() {
/* 125 */     return this.inqUserId;
/*     */   }
/*     */   
/*     */   public void setInqUserId(String inqUserId) {
/* 129 */     this.inqUserId = inqUserId;
/*     */   }
/*     */   
/*     */   public String getInqBureauMemberId() {
/* 133 */     return this.inqBureauMemberId;
/*     */   }
/*     */   
/*     */   public void setInqBureauMemberId(String inqBureauMemberId) {
/* 137 */     this.inqBureauMemberId = inqBureauMemberId;
/*     */   }
/*     */   
/*     */   public String getInqBureauMemberIndustry() {
/* 141 */     return this.inqBureauMemberIndustry;
/*     */   }
/*     */   
/*     */   public void setInqBureauMemberIndustry(String inqBureauMemberIndustry) {
/* 145 */     this.inqBureauMemberIndustry = inqBureauMemberIndustry;
/*     */   }
/*     */   
/*     */   public String getInqBureauMemberName() {
/* 149 */     return this.inqBureauMemberName;
/*     */   }
/*     */   
/*     */   public void setInqBureauMemberName(String inqBureauMemberName) {
/* 153 */     this.inqBureauMemberName = inqBureauMemberName;
/*     */   }
/*     */   
/*     */   public String getInqRefNum() {
/* 157 */     return this.inqRefNum;
/*     */   }
/*     */   
/*     */   public void setInqRefNum(String inqRefNum) {
/* 161 */     this.inqRefNum = inqRefNum;
/*     */   }
/*     */   
/*     */   public String getInqPurposeCd() {
/* 165 */     return this.inqPurposeCd;
/*     */   }
/*     */   
/*     */   public void setInqPurposeCd(String inqPurposeCd) {
/* 169 */     this.inqPurposeCd = inqPurposeCd;
/*     */   }
/*     */   
/*     */   public String getInqAcctTypeCd() {
/* 173 */     return this.inqAcctTypeCd;
/*     */   }
/*     */   
/*     */   public void setInqAcctTypeCd(String inqAcctTypeCd) {
/* 177 */     this.inqAcctTypeCd = inqAcctTypeCd;
/*     */   }
/*     */   
/*     */   public String getInqAmt() {
/* 181 */     return this.inqAmt;
/*     */   }
/*     */   
/*     */   public void setInqAmt(String inqAmt) {
/* 185 */     this.inqAmt = inqAmt;
/*     */   }
/*     */   
/*     */   public String getInqAmtMonetaryCd() {
/* 189 */     return this.inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */   public void setInqAmtMonetaryCd(String inqAmtMonetaryCd) {
/* 193 */     this.inqAmtMonetaryCd = inqAmtMonetaryCd;
/*     */   }
/*     */   
/*     */   public String getInqProductName() {
/* 197 */     return this.inqProductName;
/*     */   }
/*     */   
/*     */   public void setInqProductName(String inqProductName) {
/* 201 */     this.inqProductName = inqProductName;
/*     */   }
/*     */   
/*     */   public String getInqProductCd() {
/* 205 */     return this.inqProductCd;
/*     */   }
/*     */   
/*     */   public void setInqProductCd(String inqProductCd) {
/* 209 */     this.inqProductCd = inqProductCd;
/*     */   }
/*     */   
/*     */   public String getInqProductSearchTypeCd() {
/* 213 */     return this.inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */   public void setInqProductSearchTypeCd(String inqProductSearchTypeCd) {
/* 217 */     this.inqProductSearchTypeCd = inqProductSearchTypeCd;
/*     */   }
/*     */   
/*     */   public String getFrequency() {
/* 221 */     return this.frequency;
/*     */   }
/*     */   
/*     */   public void setFrequency(String frequency) {
/* 225 */     this.frequency = frequency;
/*     */   }
/*     */   
/*     */   public String getInqCompanyName() {
/* 229 */     return this.inqCompanyName;
/*     */   }
/*     */   
/*     */   public void setInqCompanyName(String inqCompanyName) {
/* 233 */     this.inqCompanyName = inqCompanyName;
/*     */   }
/*     */   
/*     */   public String getInqCompanyBankAccNumber() {
/* 237 */     return this.inqCompanyBankAccNumber;
/*     */   }
/*     */   
/*     */   public void setInqCompanyBankAccNumber(String inqCompanyBankAccNumber) {
/* 241 */     this.inqCompanyBankAccNumber = inqCompanyBankAccNumber;
/*     */   }
/*     */   
/*     */   public String getInqPAN() {
/* 245 */     return this.InqPAN;
/*     */   }
/*     */   
/*     */   public void setInqPAN(String inqPAN) {
/* 249 */     this.InqPAN = inqPAN;
/*     */   }
/*     */   
/*     */   public String getEnquiryApplicationType() {
/* 253 */     return this.enquiryApplicationType;
/*     */   }
/*     */   
/*     */   public void setEnquiryApplicationType(String enquiryApplicationType) {
/* 257 */     this.enquiryApplicationType = enquiryApplicationType;
/*     */   }
/*     */   
/*     */   public String getDurationOfAgreement() {
/* 261 */     return this.durationOfAgreement;
/*     */   }
/*     */   
/*     */   public void setDurationOfAgreement(String durationOfAgreement) {
/* 265 */     this.durationOfAgreement = durationOfAgreement;
/*     */   }
/*     */   
/*     */   public List<NgInqAddr> getNgInqAddr() {
/* 269 */     return this.ngInqAddr;
/*     */   }
/*     */   
/*     */   public void setNgInqAddr(List<NgInqAddr> ngInqAddr) {
/* 273 */     this.ngInqAddr = ngInqAddr;
/*     */   }
/*     */   
/*     */   public List<NgInqTel> getNgInqTel() {
/* 277 */     return this.ngInqTel;
/*     */   }
/*     */   
/*     */   public void setNgInqTel(List<NgInqTel> ngInqTel) {
/* 281 */     this.ngInqTel = ngInqTel;
/*     */   }
/*     */   
/*     */   public Perinput getPerinput() {
/* 285 */     return this.perinput;
/*     */   }
/*     */   
/*     */   public void setPerinput(Perinput perinput) {
/* 289 */     this.perinput = perinput;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Nginquiry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */