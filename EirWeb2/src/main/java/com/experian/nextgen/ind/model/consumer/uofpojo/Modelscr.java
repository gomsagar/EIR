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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Modelscr", propOrder={"segmentCode", "modelNameCd", "modelScoreValue", "riskGrading", "scoreCardNum", "lowScoreRange", "highScoreRange", "scoreFactor1", "scoreFactor2", "scoreFactor3", "scoreFactor4", "scoreFactor5", "scoreConfLevel", "creditRating"})
/*     */ public class Modelscr
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="ModelNameCd")
/*     */   protected String modelNameCd;
/*     */   @XmlElement(name="ModelScoreValue")
/*     */   protected String modelScoreValue;
/*     */   @XmlElement(name="RiskGrading")
/*     */   protected String riskGrading;
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
/*     */   public String getRiskGrading()
/*     */   {
/* 161 */     return this.riskGrading;
/*     */   }
/*     */   
/*     */   public void setRiskGrading(String riskGrading) {
/* 165 */     this.riskGrading = riskGrading;
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
/*     */   public String getSegmentCode()
/*     */   {
/* 198 */     return this.segmentCode;
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
/* 210 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getModelNameCd()
/*     */   {
/* 222 */     return this.modelNameCd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setModelNameCd(String value)
/*     */   {
/* 234 */     this.modelNameCd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getModelScoreValue()
/*     */   {
/* 246 */     return this.modelScoreValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setModelScoreValue(String value)
/*     */   {
/* 258 */     this.modelScoreValue = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreCardNum()
/*     */   {
/* 270 */     return this.scoreCardNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreCardNum(String value)
/*     */   {
/* 282 */     this.scoreCardNum = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLowScoreRange()
/*     */   {
/* 294 */     return this.lowScoreRange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLowScoreRange(String value)
/*     */   {
/* 306 */     this.lowScoreRange = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHighScoreRange()
/*     */   {
/* 318 */     return this.highScoreRange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHighScoreRange(String value)
/*     */   {
/* 330 */     this.highScoreRange = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreFactor1()
/*     */   {
/* 342 */     return this.scoreFactor1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreFactor1(String value)
/*     */   {
/* 354 */     this.scoreFactor1 = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreFactor2()
/*     */   {
/* 366 */     return this.scoreFactor2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreFactor2(String value)
/*     */   {
/* 378 */     this.scoreFactor2 = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreFactor3()
/*     */   {
/* 390 */     return this.scoreFactor3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreFactor3(String value)
/*     */   {
/* 402 */     this.scoreFactor3 = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreFactor4()
/*     */   {
/* 414 */     return this.scoreFactor4;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreFactor4(String value)
/*     */   {
/* 426 */     this.scoreFactor4 = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreFactor5()
/*     */   {
/* 438 */     return this.scoreFactor5;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreFactor5(String value)
/*     */   {
/* 450 */     this.scoreFactor5 = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScoreConfLevel()
/*     */   {
/* 462 */     return this.scoreConfLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScoreConfLevel(String value)
/*     */   {
/* 474 */     this.scoreConfLevel = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCreditRating()
/*     */   {
/* 486 */     return this.creditRating;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreditRating(String value)
/*     */   {
/* 498 */     this.creditRating = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Modelscr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */