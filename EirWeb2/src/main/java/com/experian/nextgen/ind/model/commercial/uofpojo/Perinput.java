/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import com.experian.nextgen.ind.model.consumer.uofpojo.Perinpaddr;
/*     */ import com.experian.nextgen.ind.model.consumer.uofpojo.Perinpphn;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Perinput", propOrder={"segmentCode", "firstGivenName", "middleName", "otherMiddleNames", "indiaMiddleName3", "familyName", "indiaNamePrefix", "birthYear", "birthMonth", "birthDay", "gender", "maritalStatus", "relationship", "perinpaddr", "perinpphn", "perinpidc"})
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
/*     */   @XmlElement(name="Relationship")
/*     */   protected String relationship;
/*     */   @XmlElement(name="PERINPADDR")
/*     */   protected List<Perinpaddr> perinpaddr;
/*     */   @XmlElement(name="PERINPPHN")
/*     */   protected List<Perinpphn> perinpphn;
/*     */   @XmlElement(name="PERINPIDC")
/*     */   protected List<Perinpidc> perinpidc;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  75 */     return this.segmentCode;
/*     */   }
/*     */   
/*  78 */   public void setSegmentCode(String segmentCode) { this.segmentCode = segmentCode; }
/*     */   
/*     */   public String getFirstGivenName() {
/*  81 */     return this.firstGivenName;
/*     */   }
/*     */   
/*  84 */   public void setFirstGivenName(String firstGivenName) { this.firstGivenName = firstGivenName; }
/*     */   
/*     */   public String getMiddleName() {
/*  87 */     return this.middleName;
/*     */   }
/*     */   
/*  90 */   public void setMiddleName(String middleName) { this.middleName = middleName; }
/*     */   
/*     */   public String getOtherMiddleNames() {
/*  93 */     return this.otherMiddleNames;
/*     */   }
/*     */   
/*  96 */   public void setOtherMiddleNames(String otherMiddleNames) { this.otherMiddleNames = otherMiddleNames; }
/*     */   
/*     */   public String getIndiaMiddleName3() {
/*  99 */     return this.indiaMiddleName3;
/*     */   }
/*     */   
/* 102 */   public void setIndiaMiddleName3(String indiaMiddleName3) { this.indiaMiddleName3 = indiaMiddleName3; }
/*     */   
/*     */   public String getFamilyName() {
/* 105 */     return this.familyName;
/*     */   }
/*     */   
/* 108 */   public void setFamilyName(String familyName) { this.familyName = familyName; }
/*     */   
/*     */   public String getIndiaNamePrefix() {
/* 111 */     return this.indiaNamePrefix;
/*     */   }
/*     */   
/* 114 */   public void setIndiaNamePrefix(String indiaNamePrefix) { this.indiaNamePrefix = indiaNamePrefix; }
/*     */   
/*     */   public String getBirthYear() {
/* 117 */     return this.birthYear;
/*     */   }
/*     */   
/* 120 */   public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
/*     */   
/*     */   public String getBirthMonth() {
/* 123 */     return this.birthMonth;
/*     */   }
/*     */   
/* 126 */   public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }
/*     */   
/*     */   public String getBirthDay() {
/* 129 */     return this.birthDay;
/*     */   }
/*     */   
/* 132 */   public void setBirthDay(String birthDay) { this.birthDay = birthDay; }
/*     */   
/*     */   public String getGender() {
/* 135 */     return this.gender;
/*     */   }
/*     */   
/* 138 */   public void setGender(String gender) { this.gender = gender; }
/*     */   
/*     */   public String getMaritalStatus() {
/* 141 */     return this.maritalStatus;
/*     */   }
/*     */   
/* 144 */   public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }
/*     */   
/*     */   public String getRelationship() {
/* 147 */     return this.relationship;
/*     */   }
/*     */   
/* 150 */   public void setRelationship(String relationship) { this.relationship = relationship; }
/*     */   
/*     */   public List<Perinpaddr> getPerinpaddr() {
/* 153 */     return this.perinpaddr;
/*     */   }
/*     */   
/* 156 */   public void setPerinpaddr(List<Perinpaddr> perinpaddr) { this.perinpaddr = perinpaddr; }
/*     */   
/*     */   public List<Perinpphn> getPerinpphn() {
/* 159 */     return this.perinpphn;
/*     */   }
/*     */   
/* 162 */   public void setPerinpphn(List<Perinpphn> perinpphn) { this.perinpphn = perinpphn; }
/*     */   
/*     */   public List<Perinpidc> getPerinpidc() {
/* 165 */     return this.perinpidc;
/*     */   }
/*     */   
/* 168 */   public void setPerinpidc(List<Perinpidc> perinpidc) { this.perinpidc = perinpidc; }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Perinput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */