/*     */ package com.experian.nextgen.ind.model.consumer.uofpojo;
import java.text.SimpleDateFormat;

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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Perinpidc", propOrder={"segmentCode", "idNumberType", "indiaIdNumber", "idIssueDate", "idExpirationDate"})
/*     */ public class Perinpidc
/*     */ {
/*     */   @XmlElement(name="SegmentCode")
/*     */   protected String segmentCode;
/*     */   @XmlElement(name="IdNumberType")
/*     */   protected String idNumberType;
/*     */   @XmlElement(name="IndiaIdNumber")
/*     */   protected String indiaIdNumber;
/*     */   @XmlElement(name="IdIssueDate")
/*     */   protected String idIssueDate;
/*     */   @XmlElement(name="IdExpirationDate")
/*     */   protected String idExpirationDate;
/*     */   
/*     */   public String getSegmentCode()
/*     */   {
/* 100 */     return this.segmentCode;
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
/* 112 */     this.segmentCode = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdNumberType()
/*     */   {
/* 124 */     return this.idNumberType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdNumberType(String value)
/*     */   {
/* 136 */     this.idNumberType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIndiaIdNumber()
/*     */   {
/* 148 */     return this.indiaIdNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIndiaIdNumber(String value)
/*     */   {
/* 160 */     this.indiaIdNumber = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdIssueDate()
/*     */   {
/* 172 */     return convertDate(this.idIssueDate);
/*     */   }
/*     */   private String convertDate(String str) 
			{
				try 
				{
					if(str != null && !str.isEmpty())
					{
						SimpleDateFormat format1 = new SimpleDateFormat("ddmmyyyy");
						SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yy");
						java.util.Date date;
						String newDate="";
						date = format1.parse(str);
						newDate = format2.format(date);
						return newDate;
					}
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				return "";
			}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdIssueDate(String value)
/*     */   {
/* 184 */     this.idIssueDate = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdExpirationDate()
/*     */   {
/* 196 */     return convertDate(this.idExpirationDate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdExpirationDate(String value)
/*     */   {
/* 208 */     this.idExpirationDate = value;
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\consumer\\uofpojo\Perinpidc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */