/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlTransient;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Relations", propOrder={"segmentCode", "entityName", "entityAddress", "entityCity", "entityPINCode", "entityRelationship", "entityPAN", "entityPhone", "entityRelatedType", "percentageOfControl", "lastReportedDate"})
/*     */ public class Relations
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="EntityName")
/*     */   protected String entityName;
/*     */   @XmlElement(name="EntityAddress")
/*     */   protected String entityAddress;
/*     */   @XmlElement(name="EntityCity")
/*     */   protected String entityCity;
/*     */   @XmlElement(name="EntityPINCode")
/*     */   protected String entityPINCode;
/*     */   @XmlElement(name="EntityRelationship")
/*     */   protected String entityRelationship;
/*     */   @XmlElement(name="EntityPAN")
/*     */   protected String entityPAN;
/*     */   @XmlElement(name="EntityPhone")
/*     */   protected String entityPhone;
/*     */   @XmlElement(name="EntityRelatedType")
/*     */   protected String entityRelatedType;
/*     */   @XmlElement(name="LastReportedDate")
/*     */   protected String lastReportedDate;
/*     */   @XmlElement(name="PercentageOfControl")
/*     */   protected String percentageOfControl;
/*     */   @XmlTransient
/*     */   protected String address;
/*     */   
/*     */   public String getAddress()
/*     */   {
/*  61 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  65 */     this.address = address;
/*     */   }
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  70 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  75 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getEntityName()
/*     */   {
/*  80 */     return this.entityName;
/*     */   }
/*     */   
/*     */   public void setEntityName(String value)
/*     */   {
/*  85 */     this.entityName = value;
/*     */   }
/*     */   
/*     */   public String getEntityAddress()
/*     */   {
/*  90 */     return this.entityAddress;
/*     */   }
/*     */   
/*     */   public void setEntityAddress(String value)
/*     */   {
/*  95 */     this.entityAddress = value;
/*     */   }
/*     */   
/*     */   public String getEntityCity()
/*     */   {
/* 100 */     return this.entityCity;
/*     */   }
/*     */   
/*     */   public void setEntityCity(String value)
/*     */   {
/* 105 */     this.entityCity = value;
/*     */   }
/*     */   
/*     */   public String getEntityPINCode()
/*     */   {
/* 110 */     return this.entityPINCode;
/*     */   }
/*     */   
/*     */   public void setEntityPINCode(String value)
/*     */   {
/* 115 */     this.entityPINCode = value;
/*     */   }
/*     */   
/*     */   public String getEntityRelationship()
/*     */   {
/* 120 */     return this.entityRelationship;
/*     */   }
/*     */   
/*     */   public void setEntityRelationship(String value)
/*     */   {
/* 125 */     this.entityRelationship = value;
/*     */   }
/*     */   
/*     */   public String getEntityPAN()
/*     */   {
/* 130 */     return this.entityPAN;
/*     */   }
/*     */   
/*     */   public void setEntityPAN(String value)
/*     */   {
/* 135 */     this.entityPAN = value;
/*     */   }
/*     */   
/*     */   public String getEntityPhone()
/*     */   {
/* 140 */     return this.entityPhone;
/*     */   }
/*     */   
/*     */   public void setEntityPhone(String value)
/*     */   {
/* 145 */     this.entityPhone = value;
/*     */   }
/*     */   
/*     */   public String getEntityRelatedType()
/*     */   {
/* 150 */     return this.entityRelatedType;
/*     */   }
/*     */   
/*     */   public void setEntityRelatedType(String value)
/*     */   {
/* 155 */     this.entityRelatedType = value;
/*     */   }
/*     */   
/*     */   public String getLastReportedDate()
/*     */   {
/* 160 */     return this.lastReportedDate;
/*     */   }
/*     */   
/*     */   public void setLastReportedDate(String value)
/*     */   {
/* 165 */     this.lastReportedDate = value;
/*     */   }
/*     */   
/*     */   public String getPercentageOfControl()
/*     */   {
/* 170 */     return this.percentageOfControl;
/*     */   }
/*     */   
/*     */   public void setPercentageOfControl(String percentageOfControl) {
/* 174 */     this.percentageOfControl = percentageOfControl;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Relations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */