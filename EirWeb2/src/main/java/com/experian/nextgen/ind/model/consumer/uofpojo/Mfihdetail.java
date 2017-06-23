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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Mfihdetail", propOrder={"segmentCode", "loanPurposeDescription", "accountStatusDetail", "paymentStatusDetail", "amtOfCreditExtended", "amountPastDue", "actualPaymentAmt", "lastPaymentDate", "indiaCashLimitAmt", "indiaTotWriteOffAmt", "indiaPrincWriteOffAmt", "indiaSettlAmt", "disbursedAmount", "loanOfficer", "loanApplicationDate", "dateWrittenOff", "writenOffReason", "nomineeName", "nomineeRelationshipDesc"})
/*     */ public class Mfihdetail
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="LoanPurposeDescription")
/*     */   protected String loanPurposeDescription;
/*     */   @XmlElement(name="AccountStatusDetail")
/*     */   protected String accountStatusDetail;
/*     */   @XmlElement(name="PaymentStatusDetail")
/*     */   protected String paymentStatusDetail;
/*     */   @XmlElement(name="AmtOfCreditExtended")
/*     */   protected String amtOfCreditExtended;
/*     */   @XmlElement(name="AmountPastDue")
/*     */   protected String amountPastDue;
/*     */   @XmlElement(name="ActualPaymentAmt")
/*     */   protected String actualPaymentAmt;
/*     */   @XmlElement(name="LastPaymentDate")
/*     */   protected String lastPaymentDate;
/*     */   @XmlElement(name="IndiaCashLimitAmt")
/*     */   protected String indiaCashLimitAmt;
/*     */   @XmlElement(name="IndiaTotWriteOffAmt")
/*     */   protected String indiaTotWriteOffAmt;
/*     */   @XmlElement(name="IndiaPrincWriteOffAmt")
/*     */   protected String indiaPrincWriteOffAmt;
/*     */   @XmlElement(name="IndiaSettlAmt")
/*     */   protected String indiaSettlAmt;
/*     */   @XmlElement(name="DisbursedAmount")
/*     */   protected String disbursedAmount;
/*     */   @XmlElement(name="LoanOfficer")
/*     */   protected String loanOfficer;
/*     */   @XmlElement(name="LoanApplicationDate")
/*     */   protected String loanApplicationDate;
/*     */   @XmlElement(name="DateWrittenOff")
/*     */   protected String dateWrittenOff;
/*     */   @XmlElement(name="WritenOffReason")
/*     */   protected String writenOffReason;
/*     */   @XmlElement(name="NomineeName")
/*     */   protected String nomineeName;
/*     */   @XmlElement(name="NomineeRelationshipDesc")
/*     */   protected String nomineeRelationshipDesc;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 240 */     return this.segmentCode;
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
/* 252 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanPurposeDescription()
/*     */   {
/* 264 */     return this.loanPurposeDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanPurposeDescription(String value)
/*     */   {
/* 276 */     this.loanPurposeDescription = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountStatusDetail()
/*     */   {
/* 288 */     return this.accountStatusDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountStatusDetail(String value)
/*     */   {
/* 300 */     this.accountStatusDetail = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPaymentStatusDetail()
/*     */   {
/* 312 */     return this.paymentStatusDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaymentStatusDetail(String value)
/*     */   {
/* 324 */     this.paymentStatusDetail = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAmtOfCreditExtended()
/*     */   {
/* 336 */     return this.amtOfCreditExtended;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmtOfCreditExtended(String value)
/*     */   {
/* 348 */     this.amtOfCreditExtended = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAmountPastDue()
/*     */   {
/* 360 */     return this.amountPastDue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmountPastDue(String value)
/*     */   {
/* 372 */     this.amountPastDue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getActualPaymentAmt()
/*     */   {
/* 384 */     return this.actualPaymentAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setActualPaymentAmt(String value)
/*     */   {
/* 396 */     this.actualPaymentAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastPaymentDate()
/*     */   {
/* 408 */     return this.lastPaymentDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLastPaymentDate(String value)
/*     */   {
/* 420 */     this.lastPaymentDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaCashLimitAmt()
/*     */   {
/* 432 */     return this.indiaCashLimitAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaCashLimitAmt(String value)
/*     */   {
/* 444 */     this.indiaCashLimitAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaTotWriteOffAmt()
/*     */   {
/* 456 */     return this.indiaTotWriteOffAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaTotWriteOffAmt(String value)
/*     */   {
/* 468 */     this.indiaTotWriteOffAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaPrincWriteOffAmt()
/*     */   {
/* 480 */     return this.indiaPrincWriteOffAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaPrincWriteOffAmt(String value)
/*     */   {
/* 492 */     this.indiaPrincWriteOffAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaSettlAmt()
/*     */   {
/* 504 */     return this.indiaSettlAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaSettlAmt(String value)
/*     */   {
/* 516 */     this.indiaSettlAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDisbursedAmount()
/*     */   {
/* 528 */     return this.disbursedAmount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDisbursedAmount(String value)
/*     */   {
/* 540 */     this.disbursedAmount = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanOfficer()
/*     */   {
/* 552 */     return this.loanOfficer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanOfficer(String value)
/*     */   {
/* 564 */     this.loanOfficer = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoanApplicationDate()
/*     */   {
/* 576 */     return this.loanApplicationDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoanApplicationDate(String value)
/*     */   {
/* 588 */     this.loanApplicationDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDateWrittenOff()
/*     */   {
/* 600 */     return this.dateWrittenOff;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDateWrittenOff(String value)
/*     */   {
/* 612 */     this.dateWrittenOff = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWritenOffReason()
/*     */   {
/* 624 */     return this.writenOffReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWritenOffReason(String value)
/*     */   {
/* 636 */     this.writenOffReason = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNomineeName()
/*     */   {
/* 648 */     return this.nomineeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNomineeName(String value)
/*     */   {
/* 660 */     this.nomineeName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNomineeRelationshipDesc()
/*     */   {
/* 672 */     return this.nomineeRelationshipDesc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNomineeRelationshipDesc(String value)
/*     */   {
/* 684 */     this.nomineeRelationshipDesc = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Mfihdetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */