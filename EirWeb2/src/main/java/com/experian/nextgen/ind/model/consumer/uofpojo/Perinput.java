/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name="Perinput", propOrder={"segmentCode", "firstGivenName", "middleName", "otherMiddleNames", "indiaMiddleName3", "familyName", "indiaNamePrefix", "birthYear", "birthMonth", "birthDay", "gender", "maritalStatus", "netMontlyIncome", "occYearsEmployed", "occMonthsEmployed", "numberOfCreditCardHeld", "occupationCode", "perinpaddr", "perinpphn", "perinpidc", "perinpeml", "perinpbnk"})
/*     */ public class Perinput
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="FirstGivenName")
/*     */   protected String firstGivenName;
/*     */   @XmlElement(name="MiddleName")
/*     */   protected String middleName;
/*     */   @XmlElement(name="OtherMiddleNames")
/*     */   protected String otherMiddleNames;
/*     */   @XmlElement(name="IndiaMiddleName3")
/*     */   protected String indiaMiddleName3;
/*     */   @XmlElement(name="FamilyName")
/*     */   protected String familyName;
/*     */   @XmlElement(name="IndiaNamePrefix")
/*     */   protected String indiaNamePrefix;
/*     */   @XmlElement(name="BirthYear")
/*     */   protected String birthYear;
/*     */   @XmlElement(name="BirthMonth")
/*     */   protected String birthMonth;
/*     */   @XmlElement(name="BirthDay")
/*     */   protected String birthDay;
/*     */   @XmlElement(name="Gender")
/*     */   protected String gender;
/*     */   @XmlElement(name="MaritalStatus")
/*     */   protected String maritalStatus;
/*     */   @XmlElement(name="NetMontlyIncome")
/*     */   protected String netMontlyIncome;
/*     */   @XmlElement(name="OccYearsEmployed")
/*     */   protected String occYearsEmployed;
/*     */   @XmlElement(name="OccMonthsEmployed")
/*     */   protected String occMonthsEmployed;
/*     */   @XmlElement(name="NumberOfCreditCardHeld")
/*     */   protected String numberOfCreditCardHeld;
/*     */   @XmlElement(name="OccupationCode")
/*     */   protected String occupationCode;
/*     */   @XmlElement(name="PERINPADDR")
/*     */   protected List<Perinpaddr> perinpaddr;
/*     */   @XmlElement(name="PERINPPHN")
/*     */   protected List<Perinpphn> perinpphn;
/*     */   @XmlElement(name="PERINPIDC")
/*     */   protected List<Perinpidc> perinpidc;
/*     */   @XmlElement(name="PERINPEML")
/*     */   protected Perinpeml perinpeml;
/*     */   @XmlElement(name="PERINPBNK")
/*     */   protected Perinpbnk perinpbnk;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 262 */     return this.segmentCode;
/*     */   }
/*     */   
/* 265 */   public void setSegmentCode(String segmentCode) { this.segmentCode = segmentCode; }
/*     */   
/*     */   public String getFirstGivenName() {
/* 268 */     return this.firstGivenName;
/*     */   }
/*     */   
/* 271 */   public void setFirstGivenName(String firstGivenName) { this.firstGivenName = firstGivenName; }
/*     */   
/*     */   public String getMiddleName() {
/* 274 */     return this.middleName;
/*     */   }
/*     */   
/* 277 */   public void setMiddleName(String middleName) { this.middleName = middleName; }
/*     */   
/*     */   public String getOtherMiddleNames() {
/* 280 */     return this.otherMiddleNames;
/*     */   }
/*     */   
/* 283 */   public void setOtherMiddleNames(String otherMiddleNames) { this.otherMiddleNames = otherMiddleNames; }
/*     */   
/*     */   public String getIndiaMiddleName3() {
/* 286 */     return this.indiaMiddleName3;
/*     */   }
/*     */   
/* 289 */   public void setIndiaMiddleName3(String indiaMiddleName3) { this.indiaMiddleName3 = indiaMiddleName3; }
/*     */   
/*     */   public String getFamilyName() {
/* 292 */     return this.familyName;
/*     */   }
/*     */   
/* 295 */   public void setFamilyName(String familyName) { this.familyName = familyName; }
/*     */   
/*     */   public String getIndiaNamePrefix() {
/* 298 */     return this.indiaNamePrefix;
/*     */   }
/*     */   
/* 301 */   public void setIndiaNamePrefix(String indiaNamePrefix) { this.indiaNamePrefix = indiaNamePrefix; }
/*     */   
/*     */   public String getBirthYear() {
/* 304 */     return this.birthYear;
/*     */   }
/*     */   
/* 307 */   public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
/*     */   
/*     */   public String getBirthMonth() {
/* 310 */     return this.birthMonth;
/*     */   }
/*     */   
/* 313 */   public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }
/*     */   
/*     */   public String getBirthDay() {
/* 316 */     return this.birthDay;
/*     */   }
/*     */   
/* 319 */   public void setBirthDay(String birthDay) { this.birthDay = birthDay; }
/*     */   
/*     */   public String getGender() {
/* 322 */     return this.gender;
/*     */   }
/*     */   
/* 325 */   public void setGender(String gender) { this.gender = gender; }
/*     */   
/*     */   public String getMaritalStatus() {
/* 328 */     return this.maritalStatus;
/*     */   }
/*     */   
/* 331 */   public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }
/*     */   
/*     */   public String getNetMontlyIncome() {
/* 334 */     return this.netMontlyIncome;
/*     */   }
/*     */   
/* 337 */   public void setNetMontlyIncome(String netMontlyIncome) { this.netMontlyIncome = netMontlyIncome; }
/*     */   
/*     */   public String getOccYearsEmployed() {
/* 340 */     return this.occYearsEmployed;
/*     */   }
/*     */   
/* 343 */   public void setOccYearsEmployed(String occYearsEmployed) { this.occYearsEmployed = occYearsEmployed; }
/*     */   
/*     */   public String getOccMonthsEmployed() {
/* 346 */     return this.occMonthsEmployed;
/*     */   }
/*     */   
/* 349 */   public void setOccMonthsEmployed(String occMonthsEmployed) { this.occMonthsEmployed = occMonthsEmployed; }
/*     */   
/*     */   public String getNumberOfCreditCardHeld() {
/* 352 */     return this.numberOfCreditCardHeld;
/*     */   }
/*     */   
/* 355 */   public void setNumberOfCreditCardHeld(String numberOfCreditCardHeld) { this.numberOfCreditCardHeld = numberOfCreditCardHeld; }
/*     */   
/*     */   public String getOccupationCode() {
/* 358 */     return this.occupationCode;
/*     */   }
/*     */   
/* 361 */   public void setOccupationCode(String occupationCode) { this.occupationCode = occupationCode; }
/*     */   
/*     */   public List<Perinpaddr> getPerinpaddr() {
/* 364 */     return this.perinpaddr;
/*     */   }
/*     */   
/* 367 */   public void setPerinpaddr(List<Perinpaddr> perinpaddr) { this.perinpaddr = perinpaddr; }
/*     */   
/*     */   public List<Perinpphn> getPerinpphn() {
/* 370 */     return this.perinpphn;
/*     */   }
/*     */   
/* 373 */   public void setPerinpphn(List<Perinpphn> perinpphn) { this.perinpphn = perinpphn; }
/*     */   
/*     */   public List<Perinpidc> getPerinpidc() {
/* 376 */     return this.perinpidc;
/*     */   }
/*     */   
/* 379 */   public void setPerinpidc(List<Perinpidc> perinpidc) { this.perinpidc = perinpidc; }
/*     */   
/*     */   public Perinpeml getPerinpeml() {
/* 382 */     return this.perinpeml;
/*     */   }
/*     */   
/* 385 */   public void setPerinpeml(Perinpeml perinpeml) { this.perinpeml = perinpeml; }
/*     */   
/*     */   public Perinpbnk getPerinpbnk() {
/* 388 */     return this.perinpbnk;
/*     */   }
/*     */   
/* 391 */   public void setPerinpbnk(Perinpbnk perinpbnk) { this.perinpbnk = perinpbnk; }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Perinput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */