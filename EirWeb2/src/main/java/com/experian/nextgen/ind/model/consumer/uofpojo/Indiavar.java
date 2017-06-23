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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Indiavar", propOrder={"segmentCode", "tnOfCADClassedAsSFWDWO", "mntSMRCADClassedAsSFWDWO", "numOfCADSFWDWOLast24MNT", "totCurBalLiveSAcc", "totCurBalLiveUAcc", "totCurBalMaxBalLiveSAcc", "totCurBalMaxBalLiveUAcc"})
/*     */ public class Indiavar
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="TN_of_CAD_classed_as_SFWDWO")
/*     */   protected String tnOfCADClassedAsSFWDWO;
/*     */   @XmlElement(name="MNT_SMR_CAD_classed_as_SFWDWO")
/*     */   protected String mntSMRCADClassedAsSFWDWO;
/*     */   @XmlElement(name="Num_of_CAD_SFWDWO_Last_24_MNT")
/*     */   protected String numOfCADSFWDWOLast24MNT;
/*     */   @XmlElement(name="Tot_Cur_Bal_Live_SAcc")
/*     */   protected String totCurBalLiveSAcc;
/*     */   @XmlElement(name="Tot_Cur_Bal_Live_UAcc")
/*     */   protected String totCurBalLiveUAcc;
/*     */   @XmlElement(name="Tot_Cur_Bal_Max_Bal_Live_SAcc")
/*     */   protected String totCurBalMaxBalLiveSAcc;
/*     */   @XmlElement(name="Tot_Cur_Bal_Max_Bal_Live_UAcc")
/*     */   protected String totCurBalMaxBalLiveUAcc;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 130 */     return this.segmentCode;
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
/* 142 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTnOfCADClassedAsSFWDWO()
/*     */   {
/* 154 */     return this.tnOfCADClassedAsSFWDWO;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnOfCADClassedAsSFWDWO(String value)
/*     */   {
/* 166 */     this.tnOfCADClassedAsSFWDWO = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMntSMRCADClassedAsSFWDWO()
/*     */   {
/* 178 */     return this.mntSMRCADClassedAsSFWDWO;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMntSMRCADClassedAsSFWDWO(String value)
/*     */   {
/* 190 */     this.mntSMRCADClassedAsSFWDWO = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNumOfCADSFWDWOLast24MNT()
/*     */   {
/* 202 */     return this.numOfCADSFWDWOLast24MNT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNumOfCADSFWDWOLast24MNT(String value)
/*     */   {
/* 214 */     this.numOfCADSFWDWOLast24MNT = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotCurBalLiveSAcc()
/*     */   {
/* 226 */     return this.totCurBalLiveSAcc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotCurBalLiveSAcc(String value)
/*     */   {
/* 238 */     this.totCurBalLiveSAcc = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotCurBalLiveUAcc()
/*     */   {
/* 250 */     return this.totCurBalLiveUAcc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotCurBalLiveUAcc(String value)
/*     */   {
/* 262 */     this.totCurBalLiveUAcc = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotCurBalMaxBalLiveSAcc()
/*     */   {
/* 274 */     return this.totCurBalMaxBalLiveSAcc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotCurBalMaxBalLiveSAcc(String value)
/*     */   {
/* 286 */     this.totCurBalMaxBalLiveSAcc = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTotCurBalMaxBalLiveUAcc()
/*     */   {
/* 298 */     return this.totCurBalMaxBalLiveUAcc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTotCurBalMaxBalLiveUAcc(String value)
/*     */   {
/* 310 */     this.totCurBalMaxBalLiveUAcc = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Indiavar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */