/*      */ package com.experian.nextgen.ind.model.consumer.uofpojo;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.xml.bind.annotation.XmlAccessType;
/*      */ import javax.xml.bind.annotation.XmlAccessorType;
/*      */ import javax.xml.bind.annotation.XmlElement;
/*      */ import javax.xml.bind.annotation.XmlType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @XmlAccessorType(XmlAccessType.FIELD)
/*      */ @XmlType(name="Borrower", propOrder={"segmentCode", "borrowerName", "borrowerTypeCd", "finResp", "pctResp", "startDate", "endDate", "terminationReason", "borrowerLastReportedDate", "borrowerDOB", "borrowerGender", "borrowerMaritalStatus", "borrowerOccupationCode", "borrowerIncomeAmt", "borrowerMonthlyFamilyExpenseAmt", "borrowerAddress", "borrowerCity", "borrowerPINCode", "borrowerLocationType", "borrowerPhoneNumberType", "borrowerPhoneNumber", "borrowerWebAddrType", "borrowerWebAddress", "monthlyFamilyExpenseAmt", "povertyIndex", "assetOwnershipIndicator", "netMonthlyIncome", "occYearEmployed", "occMonthsEmployed", "incomeIndicator", "incomeFrequencyIndicator", "borrowernm", "borrowerad", "borrowerph", "bidcards"})
/*      */ public class Borrower
/*      */ {
/*      */   @XmlElement(name="SegmentCode")
/*      */   protected String segmentCode;
/*      */   @XmlElement(name="BorrowerName")
/*      */   protected String borrowerName;
/*      */   @XmlElement(name="BorrowerTypeCd")
/*      */   protected String borrowerTypeCd;
/*      */   @XmlElement(name="FinResp")
/*      */   protected String finResp;
/*      */   @XmlElement(name="PctResp")
/*      */   protected String pctResp;
/*      */   @XmlElement(name="StartDate")
/*      */   protected String startDate;
/*      */   @XmlElement(name="EndDate")
/*      */   protected String endDate;
/*      */   @XmlElement(name="TerminationReason")
/*      */   protected String terminationReason;
/*      */   @XmlElement(name="BorrowerLastReportedDate")
/*      */   protected String borrowerLastReportedDate;
/*      */   @XmlElement(name="BorrowerDOB")
/*      */   protected String borrowerDOB;
/*      */   @XmlElement(name="BorrowerGender")
/*      */   protected String borrowerGender;
/*      */   @XmlElement(name="BorrowerMaritalStatus")
/*      */   protected String borrowerMaritalStatus;
/*      */   @XmlElement(name="BorrowerOccupationCode")
/*      */   protected String borrowerOccupationCode;
/*      */   @XmlElement(name="BorrowerIncomeAmt")
/*      */   protected String borrowerIncomeAmt;
/*      */   @XmlElement(name="BorrowerMonthlyFamilyExpenseAmt")
/*      */   protected String borrowerMonthlyFamilyExpenseAmt;
/*      */   @XmlElement(name="BorrowerAddress")
/*      */   protected String borrowerAddress;
/*      */   @XmlElement(name="BorrowerCity")
/*      */   protected String borrowerCity;
/*      */   @XmlElement(name="BorrowerPINCode")
/*      */   protected String borrowerPINCode;
/*      */   @XmlElement(name="BorrowerLocationType")
/*      */   protected String borrowerLocationType;
/*      */   @XmlElement(name="BorrowerPhoneNumberType")
/*      */   protected String borrowerPhoneNumberType;
/*      */   @XmlElement(name="BorrowerPhoneNumber")
/*      */   protected String borrowerPhoneNumber;
/*      */   @XmlElement(name="BorrowerWebAddrType")
/*      */   protected String borrowerWebAddrType;
/*      */   @XmlElement(name="BorrowerWebAddress")
/*      */   protected String borrowerWebAddress;
/*      */   @XmlElement(name="MonthlyFamilyExpenseAmt")
/*      */   protected String monthlyFamilyExpenseAmt;
/*      */   @XmlElement(name="PovertyIndex")
/*      */   protected String povertyIndex;
/*      */   @XmlElement(name="AssetOwnershipIndicator")
/*      */   protected String assetOwnershipIndicator;
/*      */   @XmlElement(name="NetMonthlyIncome")
/*      */   protected String netMonthlyIncome;
/*      */   @XmlElement(name="OccYearEmployed")
/*      */   protected String occYearEmployed;
/*      */   @XmlElement(name="OccMonthsEmployed")
/*      */   protected String occMonthsEmployed;
/*      */   @XmlElement(name="Income_Indicator")
/*      */   protected String incomeIndicator;
/*      */   @XmlElement(name="Income_Frequency_Indicator")
/*      */   protected String incomeFrequencyIndicator;
/*      */   @XmlElement(name="BORROWERNM")
/*      */   protected List<Borrowernm> borrowernm;
/*      */   @XmlElement(name="BORROWERAD")
/*      */   protected List<Borrowerad> borrowerad;
/*      */   @XmlElement(name="BORROWERPH")
/*      */   protected List<Borrowerph> borrowerph;
/*      */   @XmlElement(name="BIDCARDS")
/*      */   protected List<Bidcards> bidcards;
/*      */   
/*      */   public List<Bidcards> getBIDCARDS()
/*      */   {
/*  378 */     if (this.bidcards == null) {
/*  379 */       this.bidcards = new ArrayList();
/*      */     }
/*  381 */     return this.bidcards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSegmentCode()
/*      */   {
/*  393 */     return this.segmentCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSegmentCode(String value)
/*      */   {
/*  405 */     this.segmentCode = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerName()
/*      */   {
/*  417 */     return this.borrowerName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerName(String value)
/*      */   {
/*  429 */     this.borrowerName = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerTypeCd()
/*      */   {
/*  441 */     return this.borrowerTypeCd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerTypeCd(String value)
/*      */   {
/*  453 */     this.borrowerTypeCd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getFinResp()
/*      */   {
/*  465 */     return this.finResp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setFinResp(String value)
/*      */   {
/*  477 */     this.finResp = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getPctResp()
/*      */   {
/*  489 */     return this.pctResp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setPctResp(String value)
/*      */   {
/*  501 */     this.pctResp = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getStartDate()
/*      */   {
/*  513 */     return this.startDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setStartDate(String value)
/*      */   {
/*  525 */     this.startDate = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getEndDate()
/*      */   {
/*  537 */     return this.endDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setEndDate(String value)
/*      */   {
/*  549 */     this.endDate = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getTerminationReason()
/*      */   {
/*  561 */     return this.terminationReason;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTerminationReason(String value)
/*      */   {
/*  573 */     this.terminationReason = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerLastReportedDate()
/*      */   {
/*  585 */     return this.borrowerLastReportedDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerLastReportedDate(String value)
/*      */   {
/*  597 */     this.borrowerLastReportedDate = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerDOB()
/*      */   {
/*  609 */     return this.borrowerDOB;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerDOB(String value)
/*      */   {
/*  621 */     this.borrowerDOB = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerGender()
/*      */   {
/*  633 */     return this.borrowerGender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerGender(String value)
/*      */   {
/*  645 */     this.borrowerGender = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerMaritalStatus()
/*      */   {
/*  657 */     return this.borrowerMaritalStatus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerMaritalStatus(String value)
/*      */   {
/*  669 */     this.borrowerMaritalStatus = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerOccupationCode()
/*      */   {
/*  681 */     return this.borrowerOccupationCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerOccupationCode(String value)
/*      */   {
/*  693 */     this.borrowerOccupationCode = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerIncomeAmt()
/*      */   {
/*  705 */     return this.borrowerIncomeAmt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerIncomeAmt(String value)
/*      */   {
/*  717 */     this.borrowerIncomeAmt = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerMonthlyFamilyExpenseAmt()
/*      */   {
/*  729 */     return this.borrowerMonthlyFamilyExpenseAmt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerMonthlyFamilyExpenseAmt(String value)
/*      */   {
/*  741 */     this.borrowerMonthlyFamilyExpenseAmt = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerAddress()
/*      */   {
/*  753 */     return this.borrowerAddress;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerAddress(String value)
/*      */   {
/*  765 */     this.borrowerAddress = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerCity()
/*      */   {
/*  777 */     return this.borrowerCity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerCity(String value)
/*      */   {
/*  789 */     this.borrowerCity = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerPINCode()
/*      */   {
/*  801 */     return this.borrowerPINCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerPINCode(String value)
/*      */   {
/*  813 */     this.borrowerPINCode = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerLocationType()
/*      */   {
/*  825 */     return this.borrowerLocationType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerLocationType(String value)
/*      */   {
/*  837 */     this.borrowerLocationType = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerPhoneNumberType()
/*      */   {
/*  849 */     return this.borrowerPhoneNumberType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerPhoneNumberType(String value)
/*      */   {
/*  861 */     this.borrowerPhoneNumberType = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerPhoneNumber()
/*      */   {
/*  873 */     return this.borrowerPhoneNumber;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerPhoneNumber(String value)
/*      */   {
/*  885 */     this.borrowerPhoneNumber = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerWebAddrType()
/*      */   {
/*  897 */     return this.borrowerWebAddrType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerWebAddrType(String value)
/*      */   {
/*  909 */     this.borrowerWebAddrType = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBorrowerWebAddress()
/*      */   {
/*  921 */     return this.borrowerWebAddress;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBorrowerWebAddress(String value)
/*      */   {
/*  933 */     this.borrowerWebAddress = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getMonthlyFamilyExpenseAmt()
/*      */   {
/*  945 */     return this.monthlyFamilyExpenseAmt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setMonthlyFamilyExpenseAmt(String value)
/*      */   {
/*  957 */     this.monthlyFamilyExpenseAmt = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getPovertyIndex()
/*      */   {
/*  969 */     return this.povertyIndex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setPovertyIndex(String value)
/*      */   {
/*  981 */     this.povertyIndex = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getAssetOwnershipIndicator()
/*      */   {
/*  993 */     return this.assetOwnershipIndicator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setAssetOwnershipIndicator(String value)
/*      */   {
/* 1005 */     this.assetOwnershipIndicator = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getNetMonthlyIncome()
/*      */   {
/* 1017 */     return this.netMonthlyIncome;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNetMonthlyIncome(String value)
/*      */   {
/* 1029 */     this.netMonthlyIncome = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getOccYearEmployed()
/*      */   {
/* 1041 */     return this.occYearEmployed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setOccYearEmployed(String value)
/*      */   {
/* 1053 */     this.occYearEmployed = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getOccMonthsEmployed()
/*      */   {
/* 1065 */     return this.occMonthsEmployed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setOccMonthsEmployed(String value)
/*      */   {
/* 1077 */     this.occMonthsEmployed = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getIncomeIndicator()
/*      */   {
/* 1089 */     return this.incomeIndicator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setIncomeIndicator(String value)
/*      */   {
/* 1101 */     this.incomeIndicator = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getIncomeFrequencyIndicator()
/*      */   {
/* 1113 */     return this.incomeFrequencyIndicator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setIncomeFrequencyIndicator(String value)
/*      */   {
/* 1125 */     this.incomeFrequencyIndicator = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Borrowernm> getBORROWERNM()
/*      */   {
/* 1151 */     if (this.borrowernm == null) {
/* 1152 */       this.borrowernm = new ArrayList();
/*      */     }
/* 1154 */     return this.borrowernm;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Borrowerad> getBORROWERAD()
/*      */   {
/* 1180 */     if (this.borrowerad == null) {
/* 1181 */       this.borrowerad = new ArrayList();
/*      */     }
/* 1183 */     return this.borrowerad;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Borrowerph> getBORROWERPH()
/*      */   {
/* 1209 */     if (this.borrowerph == null) {
/* 1210 */       this.borrowerph = new ArrayList();
/*      */     }
/* 1212 */     return this.borrowerph;
/*      */   }
/*      */   
/*      */ 
/*      */   public void setBorrowernm(List<Borrowernm> borrowernm)
/*      */   {
/* 1218 */     this.borrowernm = borrowernm;
/*      */   }
/*      */   
/*      */ 
/*      */   public void setBorrowerad(List<Borrowerad> borrowerad)
/*      */   {
/* 1224 */     this.borrowerad = borrowerad;
/*      */   }
/*      */   
/*      */ 
/*      */   public void setBorrowerph(List<Borrowerph> borrowerph)
/*      */   {
/* 1230 */     this.borrowerph = borrowerph;
/*      */   }
/*      */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Borrower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */