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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Modelscr", propOrder={"segmentCode", "modelNameCd", "modelScoreValue", "scoreCardNum", "lowScoreRange", "highScoreRange", "scoreFactor1", "scoreFactor2", "scoreFactor3", "scoreFactor4", "scoreFactor5", "scoreConfLevel", "creditRating"})
/*     */ public class Modelscr
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="ModelNameCd")
/*     */   protected String modelNameCd;
/*     */   @XmlElement(name="ModelScoreValue")
/*     */   protected String modelScoreValue;
/*     */   @XmlElement(name="ScoreCardNum")
/*     */   protected String scoreCardNum;
/*     */   @XmlElement(name="LowScoreRange")
/*     */   protected String lowScoreRange;
/*     */   @XmlElement(name="HighScoreRange")
/*     */   protected String highScoreRange;
/*     */   @XmlElement(name="ScoreFactor1")
/*     */   protected String scoreFactor1;
/*     */   @XmlElement(name="ScoreFactor2")
/*     */   protected String scoreFactor2;
/*     */   @XmlElement(name="ScoreFactor3")
/*     */   protected String scoreFactor3;
/*     */   @XmlElement(name="ScoreFactor4")
/*     */   protected String scoreFactor4;
/*     */   @XmlElement(name="ScoreFactor5")
/*     */   protected String scoreFactor5;
/*     */   @XmlElement(name="ScoreConfLevel")
/*     */   protected String scoreConfLevel;
/*     */   @XmlElement(name="CreditRating")
/*     */   protected String creditRating;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/*  65 */     return this.segmentCode;
/*     */   }
/*     */   
/*     */   public void setSegmentCode(String value)
/*     */   {
/*  70 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */   public String getModelNameCd()
/*     */   {
/*  75 */     return this.modelNameCd;
/*     */   }
/*     */   
/*     */   public void setModelNameCd(String value)
/*     */   {
/*  80 */     this.modelNameCd = value;
/*     */   }
/*     */   
/*     */   public String getModelScoreValue()
/*     */   {
/*  85 */     return this.modelScoreValue;
/*     */   }
/*     */   
/*     */   public void setModelScoreValue(String value)
/*     */   {
/*  90 */     this.modelScoreValue = value;
/*     */   }
/*     */   
/*     */   public String getScoreCardNum()
/*     */   {
/*  95 */     return this.scoreCardNum;
/*     */   }
/*     */   
/*     */   public void setScoreCardNum(String value)
/*     */   {
/* 100 */     this.scoreCardNum = value;
/*     */   }
/*     */   
/*     */   public String getLowScoreRange()
/*     */   {
/* 105 */     return this.lowScoreRange;
/*     */   }
/*     */   
/*     */   public void setLowScoreRange(String value)
/*     */   {
/* 110 */     this.lowScoreRange = value;
/*     */   }
/*     */   
/*     */   public String getHighScoreRange()
/*     */   {
/* 115 */     return this.highScoreRange;
/*     */   }
/*     */   
/*     */   public void setHighScoreRange(String value)
/*     */   {
/* 120 */     this.highScoreRange = value;
/*     */   }
/*     */   
/*     */   public String getScoreFactor1()
/*     */   {
/* 125 */     return this.scoreFactor1;
/*     */   }
/*     */   
/*     */   public void setScoreFactor1(String value)
/*     */   {
/* 130 */     this.scoreFactor1 = value;
/*     */   }
/*     */   
/*     */   public String getScoreFactor2()
/*     */   {
/* 135 */     return this.scoreFactor2;
/*     */   }
/*     */   
/*     */   public void setScoreFactor2(String value)
/*     */   {
/* 140 */     this.scoreFactor2 = value;
/*     */   }
/*     */   
/*     */   public String getScoreFactor3()
/*     */   {
/* 145 */     return this.scoreFactor3;
/*     */   }
/*     */   
/*     */   public void setScoreFactor3(String value)
/*     */   {
/* 150 */     this.scoreFactor3 = value;
/*     */   }
/*     */   
/*     */   public String getScoreFactor4()
/*     */   {
/* 155 */     return this.scoreFactor4;
/*     */   }
/*     */   
/*     */   public void setScoreFactor4(String value)
/*     */   {
/* 160 */     this.scoreFactor4 = value;
/*     */   }
/*     */   
/*     */   public String getScoreFactor5()
/*     */   {
/* 165 */     return this.scoreFactor5;
/*     */   }
/*     */   
/*     */   public void setScoreFactor5(String value)
/*     */   {
/* 170 */     this.scoreFactor5 = value;
/*     */   }
/*     */   
/*     */   public String getScoreConfLevel()
/*     */   {
/* 175 */     return this.scoreConfLevel;
/*     */   }
/*     */   
/*     */   public void setScoreConfLevel(String value)
/*     */   {
/* 180 */     this.scoreConfLevel = value;
/*     */   }
/*     */   
/*     */   public String getCreditRating()
/*     */   {
/* 185 */     return this.creditRating;
/*     */   }
/*     */   
/*     */   public void setCreditRating(String value)
/*     */   {
/* 190 */     this.creditRating = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\Modelscr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */