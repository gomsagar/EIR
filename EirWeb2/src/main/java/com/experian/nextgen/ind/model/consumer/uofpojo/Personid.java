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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ @XmlType(name="Personid", propOrder={"segmentCode", "bureauAccuMatchId", "bureauAccuMatchIdTypeCd", "bureauMatchScore", "bureauRanking", "deceasedInd", "deceasedDate", "vipCd", "title", "firstGivenName", "middleName", "otherMiddleNames", "familyName", "suffix", "birthYear", "birthMonth", "birthDay", "gender", "maritalStatus", "dependents", "mothersMaidenName", "fathersName", "birthCountry", "birthCity", "countryOfResidence", "nationality", "educationLevel", "bestNameInd", "inqNameMatchInd", "inqDOBMatchInd", "suppressInd", "addSrc", "indiaNamePrefix", "indiaMiddleName3", "pidname", "aliasnam", "pidcards", "pidaddrs", "pidphone", "pidemail"})
/*      */ public class Personid
/*      */ {
/*      */   @XmlElement(name="SegmentCode")
/*      */   protected String segmentCode;
/*      */   @XmlElement(name="BureauAccuMatchId")
/*      */   protected String bureauAccuMatchId;
/*      */   @XmlElement(name="BureauAccuMatchIdTypeCd")
/*      */   protected String bureauAccuMatchIdTypeCd;
/*      */   @XmlElement(name="BureauMatchScore")
/*      */   protected String bureauMatchScore;
/*      */   @XmlElement(name="BureauRanking")
/*      */   protected String bureauRanking;
/*      */   @XmlElement(name="DeceasedInd")
/*      */   protected String deceasedInd;
/*      */   @XmlElement(name="DeceasedDate")
/*      */   protected String deceasedDate;
/*      */   @XmlElement(name="VipCd")
/*      */   protected String vipCd;
/*      */   @XmlElement(name="Title")
/*      */   protected String title;
/*      */   @XmlElement(name="FirstGivenName")
/*      */   protected String firstGivenName;
/*      */   @XmlElement(name="MiddleName")
/*      */   protected String middleName;
/*      */   @XmlElement(name="OtherMiddleNames")
/*      */   protected String otherMiddleNames;
/*      */   @XmlElement(name="FamilyName")
/*      */   protected String familyName;
/*      */   @XmlElement(name="Suffix")
/*      */   protected String suffix;
/*      */   @XmlElement(name="BirthYear")
/*      */   protected String birthYear;
/*      */   @XmlElement(name="BirthMonth")
/*      */   protected String birthMonth;
/*      */   @XmlElement(name="BirthDay")
/*      */   protected String birthDay;
/*      */   @XmlElement(name="Gender")
/*      */   protected String gender;
/*      */   @XmlElement(name="MaritalStatus")
/*      */   protected String maritalStatus;
/*      */   @XmlElement(name="Dependents")
/*      */   protected String dependents;
/*      */   @XmlElement(name="MothersMaidenName")
/*      */   protected String mothersMaidenName;
/*      */   @XmlElement(name="FathersName")
/*      */   protected String fathersName;
/*      */   @XmlElement(name="BirthCountry")
/*      */   protected String birthCountry;
/*      */   @XmlElement(name="BirthCity")
/*      */   protected String birthCity;
/*      */   @XmlElement(name="CountryOfResidence")
/*      */   protected String countryOfResidence;
/*      */   @XmlElement(name="Nationality")
/*      */   protected String nationality;
/*      */   @XmlElement(name="EducationLevel")
/*      */   protected String educationLevel;
/*      */   @XmlElement(name="BestNameInd")
/*      */   protected String bestNameInd;
/*      */   @XmlElement(name="InqNameMatchInd")
/*      */   protected String inqNameMatchInd;
/*      */   @XmlElement(name="InqDOBMatchInd")
/*      */   protected String inqDOBMatchInd;
/*      */   @XmlElement(name="SuppressInd")
/*      */   protected String suppressInd;
/*      */   @XmlElement(name="AddSrc")
/*      */   protected String addSrc;
/*      */   @XmlElement(name="IndiaNamePrefix")
/*      */   protected String indiaNamePrefix;
/*      */   @XmlElement(name="IndiaMiddleName3")
/*      */   protected String indiaMiddleName3;
/*      */   @XmlElement(name="PIDNAME")
/*      */   protected List<Pidname> pidname;
/*      */   @XmlElement(name="ALIASNAM")
/*      */   protected List<Aliasnam> aliasnam;
/*      */   @XmlElement(name="PIDCARDS")
/*      */   protected List<Pidcards> pidcards;
/*      */   @XmlElement(name="PIDADDRS")
/*      */   protected List<Pidaddrs> pidaddrs;
/*      */   @XmlElement(name="PIDPHONE")
/*      */   protected List<Pidphone> pidphone;
/*      */   @XmlElement(name="PIDEMAIL")
/*      */   protected Pidemail pidemail;
/*      */   
/*      */   public String getSegmentCode()
/*      */   {
/*  415 */     return this.segmentCode;
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
/*  427 */     this.segmentCode = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBureauAccuMatchId()
/*      */   {
/*  439 */     return this.bureauAccuMatchId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBureauAccuMatchId(String value)
/*      */   {
/*  451 */     this.bureauAccuMatchId = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBureauAccuMatchIdTypeCd()
/*      */   {
/*  463 */     return this.bureauAccuMatchIdTypeCd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBureauAccuMatchIdTypeCd(String value)
/*      */   {
/*  475 */     this.bureauAccuMatchIdTypeCd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBureauMatchScore()
/*      */   {
/*  487 */     return this.bureauMatchScore;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBureauMatchScore(String value)
/*      */   {
/*  499 */     this.bureauMatchScore = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBureauRanking()
/*      */   {
/*  511 */     return this.bureauRanking;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBureauRanking(String value)
/*      */   {
/*  523 */     this.bureauRanking = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getDeceasedInd()
/*      */   {
/*  535 */     return this.deceasedInd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setDeceasedInd(String value)
/*      */   {
/*  547 */     this.deceasedInd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getDeceasedDate()
/*      */   {
/*  559 */     return this.deceasedDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setDeceasedDate(String value)
/*      */   {
/*  571 */     this.deceasedDate = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getVIPCd()
/*      */   {
/*  583 */     return this.vipCd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setVIPCd(String value)
/*      */   {
/*  595 */     this.vipCd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getTitle()
/*      */   {
/*  607 */     return this.title;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTitle(String value)
/*      */   {
/*  619 */     this.title = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getFirstGivenName()
/*      */   {
/*  631 */     return this.firstGivenName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setFirstGivenName(String value)
/*      */   {
/*  643 */     this.firstGivenName = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getMiddleName()
/*      */   {
/*  655 */     return this.middleName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setMiddleName(String value)
/*      */   {
/*  667 */     this.middleName = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getOtherMiddleNames()
/*      */   {
/*  679 */     return this.otherMiddleNames;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setOtherMiddleNames(String value)
/*      */   {
/*  691 */     this.otherMiddleNames = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getFamilyName()
/*      */   {
/*  703 */     return this.familyName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setFamilyName(String value)
/*      */   {
/*  715 */     this.familyName = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSuffix()
/*      */   {
/*  727 */     return this.suffix;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSuffix(String value)
/*      */   {
/*  739 */     this.suffix = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBirthYear()
/*      */   {
/*  751 */     return this.birthYear;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBirthYear(String value)
/*      */   {
/*  763 */     this.birthYear = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBirthMonth()
/*      */   {
/*  775 */     return this.birthMonth;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBirthMonth(String value)
/*      */   {
/*  787 */     this.birthMonth = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBirthDay()
/*      */   {
/*  799 */     return this.birthDay;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBirthDay(String value)
/*      */   {
/*  811 */     this.birthDay = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getGender()
/*      */   {
/*  823 */     return this.gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setGender(String value)
/*      */   {
/*  835 */     this.gender = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getMaritalStatus()
/*      */   {
/*  847 */     return this.maritalStatus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setMaritalStatus(String value)
/*      */   {
/*  859 */     this.maritalStatus = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getDependents()
/*      */   {
/*  871 */     return this.dependents;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setDependents(String value)
/*      */   {
/*  883 */     this.dependents = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getMothersMaidenName()
/*      */   {
/*  895 */     return this.mothersMaidenName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setMothersMaidenName(String value)
/*      */   {
/*  907 */     this.mothersMaidenName = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getFathersName()
/*      */   {
/*  919 */     return this.fathersName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setFathersName(String value)
/*      */   {
/*  931 */     this.fathersName = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBirthCountry()
/*      */   {
/*  943 */     return this.birthCountry;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBirthCountry(String value)
/*      */   {
/*  955 */     this.birthCountry = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBirthCity()
/*      */   {
/*  967 */     return this.birthCity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBirthCity(String value)
/*      */   {
/*  979 */     this.birthCity = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getCountryOfResidence()
/*      */   {
/*  991 */     return this.countryOfResidence;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setCountryOfResidence(String value)
/*      */   {
/* 1003 */     this.countryOfResidence = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getNationality()
/*      */   {
/* 1015 */     return this.nationality;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNationality(String value)
/*      */   {
/* 1027 */     this.nationality = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getEducationLevel()
/*      */   {
/* 1039 */     return this.educationLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setEducationLevel(String value)
/*      */   {
/* 1051 */     this.educationLevel = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBestNameInd()
/*      */   {
/* 1063 */     return this.bestNameInd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBestNameInd(String value)
/*      */   {
/* 1075 */     this.bestNameInd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getInqNameMatchInd()
/*      */   {
/* 1087 */     return this.inqNameMatchInd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setInqNameMatchInd(String value)
/*      */   {
/* 1099 */     this.inqNameMatchInd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getInqDOBMatchInd()
/*      */   {
/* 1111 */     return this.inqDOBMatchInd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setInqDOBMatchInd(String value)
/*      */   {
/* 1123 */     this.inqDOBMatchInd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSuppressInd()
/*      */   {
/* 1135 */     return this.suppressInd;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSuppressInd(String value)
/*      */   {
/* 1147 */     this.suppressInd = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getAddSrc()
/*      */   {
/* 1159 */     return this.addSrc;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setAddSrc(String value)
/*      */   {
/* 1171 */     this.addSrc = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getIndiaNamePrefix()
/*      */   {
/* 1183 */     return this.indiaNamePrefix;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setIndiaNamePrefix(String value)
/*      */   {
/* 1195 */     this.indiaNamePrefix = value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getIndiaMiddleName3()
/*      */   {
/* 1207 */     return this.indiaMiddleName3;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setIndiaMiddleName3(String value)
/*      */   {
/* 1219 */     this.indiaMiddleName3 = value;
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
/*      */   public List<Aliasnam> getALIASNAM()
/*      */   {
/* 1245 */     if (this.aliasnam == null) {
/* 1246 */       this.aliasnam = new ArrayList();
/*      */     }
/* 1248 */     return this.aliasnam;
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
/*      */   public List<Pidcards> getPIDCARDS()
/*      */   {
/* 1274 */     if (this.pidcards == null) {
/* 1275 */       this.pidcards = new ArrayList();
/*      */     }
/* 1277 */     return this.pidcards;
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
/*      */   public List<Pidaddrs> getPIDADDRS()
/*      */   {
/* 1303 */     if (this.pidaddrs == null) {
/* 1304 */       this.pidaddrs = new ArrayList();
/*      */     }
/* 1306 */     return this.pidaddrs;
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
/*      */   public List<Pidphone> getPIDPHONE()
/*      */   {
/* 1332 */     if (this.pidphone == null) {
/* 1333 */       this.pidphone = new ArrayList();
/*      */     }
/* 1335 */     return this.pidphone;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Pidemail getPIDEMAIL()
/*      */   {
/* 1347 */     return this.pidemail;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setPIDEMAIL(Pidemail value)
/*      */   {
/* 1359 */     this.pidemail = value;
/*      */   }
/*      */   
/*      */   public List<Pidname> getPidname()
/*      */   {
/* 1364 */     if (this.pidname == null) {
/* 1365 */       this.pidname = new ArrayList();
/*      */     }
/* 1367 */     return this.pidname;
/*      */   }
/*      */   
/*      */   public void setPidname(List<Pidname> pidname) {
/* 1371 */     this.pidname = pidname;
/*      */   }
/*      */   
/*      */   public List<Pidcards> getPidcards() {
/* 1375 */     if (this.pidcards == null) {
/* 1376 */       this.pidcards = new ArrayList();
/*      */     }
/* 1378 */     return this.pidcards;
/*      */   }
/*      */   
/*      */   public void setPidcards(List<Pidcards> pidcards) {
/* 1382 */     this.pidcards = pidcards;
/*      */   }
/*      */   
/*      */   public List<Pidaddrs> getPidaddrs() {
/* 1386 */     if (this.pidaddrs == null) {
/* 1387 */       this.pidaddrs = new ArrayList();
/*      */     }
/* 1389 */     return this.pidaddrs;
/*      */   }
/*      */   
/*      */   public void setPidaddrs(List<Pidaddrs> pidaddrs) {
/* 1393 */     this.pidaddrs = pidaddrs;
/*      */   }
/*      */   
/*      */   public List<Pidphone> getPidphone() {
/* 1397 */     if (this.pidphone == null) {
/* 1398 */       this.pidphone = new ArrayList();
/*      */     }
/* 1400 */     return this.pidphone;
/*      */   }
/*      */   
/*      */   public void setPidphone(List<Pidphone> pidphone) {
/* 1404 */     this.pidphone = pidphone;
/*      */   }
/*      */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Personid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */