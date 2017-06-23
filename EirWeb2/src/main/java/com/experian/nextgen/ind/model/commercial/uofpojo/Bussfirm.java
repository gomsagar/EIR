/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Bussfirm", propOrder={"segmentCode", "registrationNumber", "registrationDate", "registrationCity", "registrationProvince", "registrationCountry", "businessStatus", "businessStartDate", "businessCloseDate", "businessClosureReason", "industryType", "issuedCapital", "yearsInBusiness", "numberOfEmployees", "salesFigureAmt"})
/*     */ public class Bussfirm
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="RegistrationNumber")
/*     */   protected String registrationNumber;
/*     */   @XmlElement(name="RegistrationDate")
/*     */   protected String registrationDate;
/*     */   @XmlElement(name="RegistrationCity")
/*     */   protected String registrationCity;
/*     */   @XmlElement(name="RegistrationProvince")
/*     */   protected String registrationProvince;
/*     */   @XmlElement(name="RegistrationCountry")
/*     */   protected String registrationCountry;
/*     */   @XmlElement(name="BusinessStatus")
/*     */   protected String businessStatus;
/*     */   @XmlElement(name="BusinessStartDate")
/*     */   protected String businessStartDate;
/*     */   @XmlElement(name="BusinessCloseDate")
/*     */   protected String businessCloseDate;
/*     */   @XmlElement(name="BusinessClosureReason")
/*     */   protected String businessClosureReason;
/*     */   @XmlElement(name="IndustryType")
/*     */   protected String industryType;
/*     */   @XmlElement(name="IssuedCapital")
/*     */   protected String issuedCapital;
/*     */   @XmlElement(name="YearsInBusiness")
/*     */   protected String yearsInBusiness;
/*     */   @XmlElement(name="NumberOfEmployees")
/*     */   protected String numberOfEmployees;
/*     */   @XmlElement(name="SalesFigureAmt")
/*     */   protected String salesFigureAmt;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  89 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  94 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getRegistrationNumber()
/*     */   {
/*  99 */     return this.registrationNumber;
/*     */   }
/*     */   
/*     */   public void setRegistrationNumber(String value)
/*     */   {
/* 104 */     this.registrationNumber = value;
/*     */   }
/*     */   
/*     */   public String getRegistrationDate()
/*     */   {
/* 109 */     return this.registrationDate;
/*     */   }
/*     */   
/*     */   public void setRegistrationDate(String value)
/*     */   {
/* 114 */     this.registrationDate = value;
/*     */   }
/*     */   
/*     */   public String getRegistrationCity()
/*     */   {
/* 119 */     return this.registrationCity;
/*     */   }
/*     */   
/*     */   public void setRegistrationCity(String value)
/*     */   {
/* 124 */     this.registrationCity = value;
/*     */   }
/*     */   
/*     */   public String getRegistrationProvince()
/*     */   {
/* 129 */     return this.registrationProvince;
/*     */   }
/*     */   
/*     */   public void setRegistrationProvince(String value)
/*     */   {
/* 134 */     this.registrationProvince = value;
/*     */   }
/*     */   
/*     */   public String getRegistrationCountry()
/*     */   {
/* 139 */     return this.registrationCountry;
/*     */   }
/*     */   
/*     */   public void setRegistrationCountry(String value)
/*     */   {
/* 144 */     this.registrationCountry = value;
/*     */   }
/*     */   
/*     */   public String getBusinessStatus()
/*     */   {
/* 149 */     return this.businessStatus;
/*     */   }
/*     */   
/*     */   public void setBusinessStatus(String value)
/*     */   {
/* 154 */     this.businessStatus = value;
/*     */   }
/*     */   
/*     */   public String getBusinessStartDate()
/*     */   {
/* 159 */     return this.businessStartDate;
/*     */   }
/*     */   
/*     */   public void setBusinessStartDate(String value)
/*     */   {
/* 164 */     this.businessStartDate = value;
/*     */   }
/*     */   
/*     */   public String getBusinessCloseDate()
/*     */   {
/* 169 */     return this.businessCloseDate;
/*     */   }
/*     */   
/*     */   public void setBusinessCloseDate(String value)
/*     */   {
/* 174 */     this.businessCloseDate = value;
/*     */   }
/*     */   
/*     */   public String getBusinessClosureReason()
/*     */   {
/* 179 */     return this.businessClosureReason;
/*     */   }
/*     */   
/*     */   public void setBusinessClosureReason(String value)
/*     */   {
/* 184 */     this.businessClosureReason = value;
/*     */   }
/*     */   
/*     */   public String getIndustryType()
/*     */   {
/* 189 */     return this.industryType;
/*     */   }
/*     */   
/*     */   public void setIndustryType(String value)
/*     */   {
/* 194 */     this.industryType = value;
/*     */   }
/*     */   
/*     */   public String getIssuedCapital()
/*     */   {
/* 199 */     return this.issuedCapital;
/*     */   }
/*     */   
/*     */   public void setIssuedCapital(String value)
/*     */   {
/* 204 */     this.issuedCapital = value;
/*     */   }
/*     */   
/*     */   public String getYearsInBusiness()
/*     */   {
/* 209 */     return this.yearsInBusiness;
/*     */   }
/*     */   
/*     */   public void setYearsInBusiness(String value)
/*     */   {
/* 214 */     this.yearsInBusiness = value;
/*     */   }
/*     */   
/*     */   public String getNumberOfEmployees()
/*     */   {
/* 219 */     return this.numberOfEmployees;
/*     */   }
/*     */   
/*     */   public void setNumberOfEmployees(String value)
/*     */   {
/* 224 */     this.numberOfEmployees = value;
/*     */   }
/*     */   
/*     */   public String getSalesFigureAmt()
/*     */   {
/* 229 */     return this.salesFigureAmt;
/*     */   }
/*     */   
/*     */   public void setSalesFigureAmt(String value)
/*     */   {
/* 234 */     this.salesFigureAmt = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Bussfirm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */