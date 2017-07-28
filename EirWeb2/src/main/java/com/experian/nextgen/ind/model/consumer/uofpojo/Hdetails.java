/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
import java.text.SimpleDateFormat;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Hdetails", propOrder={"segmentCode", "accountDate", "accountStatus", "paymentStatus", "lastPaymentDate", "indiaBalanceAmt", "indiaSanctionedAmt", "indiaAmountPastDue", "indiaCreditLimitAmt", "indiaCashLimitAmt", "indiaActualPayAmt", "indiaOrigChargOffAmt", "indiaEMIAmt", "indiaTotWriteOffAmt", "indiaPrincWriteOffAmt", "indiaSettlAmt", "indiaRepaymTenure", "suitFiledWilfulDefaultWrittenOffStatus", "suitFiledWilfulDefault", "writtenOffSettledStatus", "defaultStatusDate", "litigationStatusDate", "writeOffStatusDate", "creditExtendedAmt", "highCreditAmt", "lastPaymentAmt"})
/*     */ public class Hdetails
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="AccountDate")
/*     */   protected String accountDate;
/*     */   @XmlElement(name="AccountStatus")
/*     */   protected String accountStatus;
/*     */   @XmlElement(name="PaymentStatus")
/*     */   protected String paymentStatus;
/*     */   @XmlElement(name="LastPaymentDate")
/*     */   protected String lastPaymentDate;
/*     */   @XmlElement(name="IndiaBalanceAmt")
/*     */   protected String indiaBalanceAmt;
/*     */   @XmlElement(name="IndiaSanctionedAmt")
/*     */   protected String indiaSanctionedAmt;
/*     */   @XmlElement(name="IndiaAmountPastDue")
/*     */   protected String indiaAmountPastDue;
/*     */   @XmlElement(name="IndiaCreditLimitAmt")
/*     */   protected String indiaCreditLimitAmt;
/*     */   @XmlElement(name="IndiaCashLimitAmt")
/*     */   protected String indiaCashLimitAmt;
/*     */   @XmlElement(name="IndiaActualPayAmt")
/*     */   protected String indiaActualPayAmt;
/*     */   @XmlElement(name="IndiaOrigChargOffAmt")
/*     */   protected String indiaOrigChargOffAmt;
/*     */   @XmlElement(name="IndiaEMIAmt")
/*     */   protected String indiaEMIAmt;
/*     */   @XmlElement(name="IndiaTotWriteOffAmt")
/*     */   protected String indiaTotWriteOffAmt;
/*     */   @XmlElement(name="IndiaPrincWriteOffAmt")
/*     */   protected String indiaPrincWriteOffAmt;
/*     */   @XmlElement(name="IndiaSettlAmt")
/*     */   protected String indiaSettlAmt;
/*     */   @XmlElement(name="IndiaRepaymTenure")
/*     */   protected String indiaRepaymTenure;
/*     */   @XmlElement(name="SuitFiledWilfulDefaultWrittenOffStatus")
/*     */   protected String suitFiledWilfulDefaultWrittenOffStatus;
/*     */   @XmlElement(name="SuitFiledWilfulDefault")
/*     */   protected String suitFiledWilfulDefault;
/*     */   @XmlElement(name="WrittenOffSettledStatus")
/*     */   protected String writtenOffSettledStatus;
/*     */   @XmlElement(name="DefaultStatusDate")
/*     */   protected String defaultStatusDate;
/*     */   @XmlElement(name="LitigationStatusDate")
/*     */   protected String litigationStatusDate;
/*     */   @XmlElement(name="WriteOffStatusDate")
/*     */   protected String writeOffStatusDate;
/*     */   @XmlElement(name="CreditExtendedAmt")
/*     */   protected String creditExtendedAmt;
/*     */   @XmlElement(name="HighCreditAmt")
/*     */   protected String highCreditAmt;
/*     */   @XmlElement(name="LastPaymentAmt")
/*     */   protected String lastPaymentAmt;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 290 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public String getCreditExtendedAmt() {
/* 294 */     return this.creditExtendedAmt;
/*     */   }
/*     */   
/*     */   public void setCreditExtendedAmt(String creditExtendedAmt) {
/* 298 */     this.creditExtendedAmt = creditExtendedAmt;
/*     */   }
/*     */   
/*     */   public String getHighCreditAmt() {
/* 302 */     return this.highCreditAmt;
/*     */   }
/*     */   
/*     */   public void setHighCreditAmt(String highCreditAmt) {
/* 306 */     this.highCreditAmt = highCreditAmt;
/*     */   }
/*     */   
/*     */   public String getLastPaymentAmt() {
/* 310 */     return this.lastPaymentAmt;
/*     */   }
/*     */   
/*     */   public void setLastPaymentAmt(String lastPaymentAmt) {
/* 314 */     this.lastPaymentAmt = lastPaymentAmt;
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
/* 326 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountDate()
/*     */   {
/* 338 */     return convertDate(this.accountDate);
/*     */   }
/*     */   private String convertDate(String str) 
			{
				try 
				{
					if(str != null && !str.isEmpty())
					{
						SimpleDateFormat format1 = new SimpleDateFormat("ddmmyyyy");
						SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yy");
						java.util.Date date;
						String newDate="";
						date = format1.parse(str);
						newDate = format2.format(date);
						return newDate;
					}
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				return "";
			}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountDate(String value)
/*     */   {
/* 350 */     this.accountDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountStatus()
/*     */   {
/* 362 */     return this.accountStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountStatus(String value)
/*     */   {
/* 374 */     this.accountStatus = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPaymentStatus()
/*     */   {
/* 386 */     return this.paymentStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaymentStatus(String value)
/*     */   {
/* 398 */     this.paymentStatus = value;
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
/* 410 */     return convertDate(this.lastPaymentDate);
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
/* 422 */     this.lastPaymentDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaBalanceAmt()
/*     */   {
/* 434 */     return this.indiaBalanceAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaBalanceAmt(String value)
/*     */   {
/* 446 */     this.indiaBalanceAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaSanctionedAmt()
/*     */   {
/* 458 */     return this.indiaSanctionedAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaSanctionedAmt(String value)
/*     */   {
/* 470 */     this.indiaSanctionedAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaAmountPastDue()
/*     */   {
/* 482 */     return this.indiaAmountPastDue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaAmountPastDue(String value)
/*     */   {
/* 494 */     this.indiaAmountPastDue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaCreditLimitAmt()
/*     */   {
/* 506 */     return this.indiaCreditLimitAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaCreditLimitAmt(String value)
/*     */   {
/* 518 */     this.indiaCreditLimitAmt = value;
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
/* 530 */     return this.indiaCashLimitAmt;
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
/* 542 */     this.indiaCashLimitAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaActualPayAmt()
/*     */   {
/* 554 */     return this.indiaActualPayAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaActualPayAmt(String value)
/*     */   {
/* 566 */     this.indiaActualPayAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaOrigChargOffAmt()
/*     */   {
/* 578 */     return this.indiaOrigChargOffAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaOrigChargOffAmt(String value)
/*     */   {
/* 590 */     this.indiaOrigChargOffAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaEMIAmt()
/*     */   {
/* 602 */     return this.indiaEMIAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaEMIAmt(String value)
/*     */   {
/* 614 */     this.indiaEMIAmt = value;
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
/* 626 */     return this.indiaTotWriteOffAmt;
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
/* 638 */     this.indiaTotWriteOffAmt = value;
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
/* 650 */     return this.indiaPrincWriteOffAmt;
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
/* 662 */     this.indiaPrincWriteOffAmt = value;
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
/* 674 */     return this.indiaSettlAmt;
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
/* 686 */     this.indiaSettlAmt = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaRepaymTenure()
/*     */   {
/* 698 */     return this.indiaRepaymTenure;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaRepaymTenure(String value)
/*     */   {
/* 710 */     this.indiaRepaymTenure = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSuitFiledWilfulDefaultWrittenOffStatus()
/*     */   {
/* 722 */     return this.suitFiledWilfulDefaultWrittenOffStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSuitFiledWilfulDefaultWrittenOffStatus(String value)
/*     */   {
/* 734 */     this.suitFiledWilfulDefaultWrittenOffStatus = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSuitFiledWilfulDefault()
/*     */   {
/* 746 */     return this.suitFiledWilfulDefault;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSuitFiledWilfulDefault(String value)
/*     */   {
/* 758 */     this.suitFiledWilfulDefault = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWrittenOffSettledStatus()
/*     */   {
/* 770 */     return this.writtenOffSettledStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWrittenOffSettledStatus(String value)
/*     */   {
/* 782 */     this.writtenOffSettledStatus = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDefaultStatusDate()
/*     */   {
/* 794 */     return this.defaultStatusDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDefaultStatusDate(String value)
/*     */   {
/* 806 */     this.defaultStatusDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLitigationStatusDate()
/*     */   {
/* 818 */     return this.litigationStatusDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLitigationStatusDate(String value)
/*     */   {
/* 830 */     this.litigationStatusDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWriteOffStatusDate()
/*     */   {
/* 842 */     return this.writeOffStatusDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWriteOffStatusDate(String value)
/*     */   {
/* 854 */     this.writeOffStatusDate = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Hdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */