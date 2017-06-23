/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="BusinessResponseList")
/*     */ public class BusinessResponseList
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   @XmlElement(name="SYSMESSG")
/*     */   private SysMessg sysMessg;
/*     */   @XmlElement(name="CENQUIRY")
/*     */   private Cenquiry cenquiry;
/*     */   @XmlElement(name="BURPTHDR")
/*     */   private Burpthdr burpthdr;
/*     */   @XmlElement(name="BURERROR")
/*     */   private BurError burError;
/*     */   @XmlElement(name="BURCNDLS")
/*     */   private List<Burcndls> burcndls;
/*     */   
/*     */   public Cenquiry getCENQUIRY()
/*     */   {
/*  47 */     return this.cenquiry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Burpthdr getBURPTHDR()
/*     */   {
/*  54 */     return this.burpthdr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BurError getBURERROR()
/*     */   {
/*  61 */     return this.burError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Burcndls> getBURCNDLS()
/*     */   {
/*  68 */     return this.burcndls;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCENQUIRY(Cenquiry cENQUIRY)
/*     */   {
/*  77 */     this.cenquiry = cENQUIRY;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBURPTHDR(Burpthdr bURPTHDR)
/*     */   {
/*  84 */     this.burpthdr = bURPTHDR;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBURERROR(BurError bURERROR)
/*     */   {
/*  91 */     this.burError = bURERROR;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBURCNDLS(List<Burcndls> bURCNDLS)
/*     */   {
/*  98 */     this.burcndls = bURCNDLS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SysMessg getSYSMESSG()
/*     */   {
/* 105 */     return this.sysMessg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSYSMESSG(SysMessg sYSMESSG)
/*     */   {
/* 112 */     this.sysMessg = sYSMESSG;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\BusinessResponseList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */