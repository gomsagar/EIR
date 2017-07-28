/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
import java.text.SimpleDateFormat;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
import java.util.Map;

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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Conscred", propOrder={"segmentCode", "bureauMemberId", "accountNumber", "accountPortfolioType", "accountType", "accountFinRespTypeCd", "accountStatus", "accountStatusDetailCode", "accountOpenDate", "accountClosedDate", "currentBalance", "creditor", "mficreditr", "payterms", "bhistory", "bpaygrid", "borrower", "pidreltn", "crplushst", "stmtalrt", "dispute","paymentHistMap"})
/*     */ public class Conscred
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="BureauMemberID")
/*     */   protected String bureauMemberId;
/*     */   @XmlElement(name="AccountNumber")
/*     */   protected String accountNumber;
/*     */   @XmlElement(name="AccountPortfolioType")
/*     */   protected String accountPortfolioType;
/*     */   @XmlElement(name="AccountType")
/*     */   protected String accountType;
/*     */   @XmlElement(name="AccountFinRespTypeCd")
/*     */   protected String accountFinRespTypeCd;
/*     */   @XmlElement(name="AccountStatus")
/*     */   protected String accountStatus;
/*     */   @XmlElement(name="AccountStatusDetailCode")
/*     */   protected String accountStatusDetailCode;
/*     */   @XmlElement(name="AccountOpenDate")
/*     */   protected String accountOpenDate;
/*     */   @XmlElement(name="AccountClosedDate")
/*     */   protected String accountClosedDate;
/*     */   @XmlElement(name="CurrentBalance")
/*     */   protected String currentBalance;
/*     */   @XmlElement(name="CREDITOR")
/*     */   protected Creditor creditor;
/*     */   @XmlElement(name="MFICREDITR")
/*     */   protected Mficreditr mficreditr;
/*     */   @XmlElement(name="PAYTERMS")
/*     */   protected Payterms payterms;
/*     */   @XmlElement(name="BHISTORY")
/*     */   protected Bhistory bhistory;
/*     */   @XmlElement(name="BPAYGRID")
/*     */   protected List<Bpaygrid> bpaygrid;
/*     */   @XmlElement(name="BORROWER")
/*     */   protected List<Borrower> borrower;
/*     */   @XmlElement(name="PIDRELTN")
/*     */   protected List<Pidreltn> pidreltn;
/*     */   @XmlElement(name="CRPLUSHST")
/*     */   protected List<Crplushst> crplushst;
/*     */   @XmlElement(name="STMTALRT")
/*     */   protected List<Stmtalrt> stmtalrt;
/*     */   @XmlElement(name="DISPUTE")
/*     */   protected List<Dispute> dispute;
/*     */   @XmlElement
			protected Map<String, ArrayList<Bpaygrid>> paymentHistMap;
			
			
			public Map<String, ArrayList<Bpaygrid>> getPaymentHistMap() {
				return paymentHistMap;
			}
			public void setPaymentHistMap(Map<String, ArrayList<Bpaygrid>> paymentHistMap) {
				this.paymentHistMap = paymentHistMap;
			}
/*     */   public String getSegmentCode()
/*     */   {
/* 200 */     return this.segmentCode;
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
/* 212 */     this.segmentCode = value;
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
/* 224 */     return this.bureauMemberId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBureauMemberId(String bureauMemberId)
/*     */   {
/* 235 */     this.bureauMemberId = bureauMemberId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountNumber()
/*     */   {
/* 247 */     return this.accountNumber;
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
/*     */   public void setAccountNumber(String value)
/*     */   {
/* 260 */     this.accountNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountPortfolioType()
/*     */   {
/* 272 */     return this.accountPortfolioType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountPortfolioType(String value)
/*     */   {
/* 284 */     this.accountPortfolioType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountType()
/*     */   {
/* 296 */     return this.accountType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountType(String value)
/*     */   {
/* 308 */     this.accountType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountFinRespTypeCd()
/*     */   {
/* 320 */     return this.accountFinRespTypeCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountFinRespTypeCd(String value)
/*     */   {
/* 332 */     this.accountFinRespTypeCd = value;
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
/* 344 */     return this.accountStatus;
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
/* 356 */     this.accountStatus = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountStatusDetailCode()
/*     */   {
/* 368 */     return this.accountStatusDetailCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountStatusDetailCode(String value)
/*     */   {
/* 380 */     this.accountStatusDetailCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountOpenDate()
/*     */   {
/* 392 */     return convertDate(this.accountOpenDate);
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
/*     */   public void setAccountOpenDate(String value)
/*     */   {
/* 404 */     this.accountOpenDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAccountClosedDate()
/*     */   {
/* 416 */     return convertDate(this.accountClosedDate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAccountClosedDate(String value)
/*     */   {
/* 428 */     this.accountClosedDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCurrentBalance()
/*     */   {
/* 440 */     return this.currentBalance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCurrentBalance(String value)
/*     */   {
/* 452 */     this.currentBalance = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Creditor getCREDITOR()
/*     */   {
/* 464 */     return this.creditor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCREDITOR(Creditor value)
/*     */   {
/* 476 */     this.creditor = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Mficreditr getMFICREDITR()
/*     */   {
/* 488 */     return this.mficreditr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMFICREDITR(Mficreditr value)
/*     */   {
/* 500 */     this.mficreditr = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Payterms getPAYTERMS()
/*     */   {
/* 512 */     return this.payterms;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPAYTERMS(Payterms value)
/*     */   {
/* 524 */     this.payterms = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bhistory getBHISTORY()
/*     */   {
/* 536 */     return this.bhistory;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBHISTORY(Bhistory value)
/*     */   {
/* 548 */     this.bhistory = value;
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
/*     */   public List<Borrower> getBORROWER()
/*     */   {
/* 598 */     if (this.borrower == null) {
/* 599 */       this.borrower = new ArrayList();
/*     */     }
/* 601 */     return this.borrower;
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
/*     */   public List<Pidreltn> getPIDRELTN()
/*     */   {
/* 627 */     if (this.pidreltn == null) {
/* 628 */       this.pidreltn = new ArrayList();
/*     */     }
/* 630 */     return this.pidreltn;
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
/*     */   public List<Bpaygrid> getBpaygrid()
/*     */   {
/* 683 */     return this.bpaygrid;
/*     */   }
/*     */   
/*     */   public void setBpaygrid(List<Bpaygrid> bpaygrid) {
/* 687 */     this.bpaygrid = bpaygrid;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setBorrower(List<Borrower> borrower)
/*     */   {
/* 693 */     this.borrower = borrower;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Dispute> getDispute()
/*     */   {
/* 699 */     if (this.dispute == null) {
/* 700 */       this.dispute = new ArrayList();
/*     */     }
/* 702 */     return this.dispute;
/*     */   }
/*     */   
/*     */   public void setDispute(List<Dispute> dispute) {
/* 706 */     this.dispute = dispute;
/*     */   }
/*     */   
/*     */   public List<Crplushst> getCrplushst() {
/* 710 */     return this.crplushst;
/*     */   }
/*     */   
/*     */   public void setCrplushst(List<Crplushst> crplushst) {
/* 714 */     this.crplushst = crplushst;
/*     */   }
/*     */   
/*     */   public List<Stmtalrt> getStmtalrt() {
/* 718 */     return this.stmtalrt;
/*     */   }
/*     */   
/*     */   public void setStmtalrt(List<Stmtalrt> stmtalrt) {
/* 722 */     this.stmtalrt = stmtalrt;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Conscred.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */