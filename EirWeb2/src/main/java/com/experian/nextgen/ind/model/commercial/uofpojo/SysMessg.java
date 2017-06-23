/*    */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="SysMessg", propOrder={"segmentCode", "sysMsgCd", "sysMsgText", "sysOutputFmtVersion", "systemMessageDescription"})
/*    */ public class SysMessg
/*    */ {
/*    */   @XmlElement(name="SegmentCode")
/*    */   protected String segmentCode;
/*    */   @XmlElement(name="SystemMessageCode")
/*    */   protected String sysMsgCd;
/*    */   @XmlElement(name="SystemMessageText")
/*    */   protected String sysMsgText;
/*    */   @XmlElement(name="SystemOutputFormatVersion")
/*    */   protected String sysOutputFmtVersion;
/*    */   @XmlElement(name="SystemMessageDescription")
/*    */   protected String systemMessageDescription;
/*    */   
/*    */   public String getSegmentCode()
/*    */   {
/* 34 */     return this.segmentCode;
/*    */   }
/*    */   
/*    */   public void setSegmentCode(String value)
/*    */   {
/* 39 */     this.segmentCode = value;
/*    */   }
/*    */   
/*    */   public String getSysMsgCd()
/*    */   {
/* 44 */     return this.sysMsgCd;
/*    */   }
/*    */   
/*    */   public void setSysMsgCd(String value)
/*    */   {
/* 49 */     this.sysMsgCd = value;
/*    */   }
/*    */   
/*    */   public String getSysMsgText()
/*    */   {
/* 54 */     return this.sysMsgText;
/*    */   }
/*    */   
/*    */   public void setSysMsgText(String value)
/*    */   {
/* 59 */     this.sysMsgText = value;
/*    */   }
/*    */   
/*    */   public String getSysOutputFmtVersion()
/*    */   {
/* 64 */     return this.sysOutputFmtVersion;
/*    */   }
/*    */   
/*    */   public void setSysOutputFmtVersion(String value)
/*    */   {
/* 69 */     this.sysOutputFmtVersion = value;
/*    */   }
/*    */   
/*    */   public String getSystemMessageDescription()
/*    */   {
/* 74 */     return this.systemMessageDescription;
/*    */   }
/*    */   
/*    */   public void setSystemMessageDescription(String value)
/*    */   {
/* 79 */     this.systemMessageDescription = value;
/*    */   }
/*    */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\SysMessg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */