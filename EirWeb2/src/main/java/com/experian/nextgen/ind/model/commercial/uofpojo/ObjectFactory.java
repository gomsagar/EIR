/*     */ package com.experian.nextgen.ind.model.commercial.uofpojo;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  34 */   private static final QName BID_CARDS_ID_COUNTRY_OF_ISSUE_QNAME = new QName("", "idCountryOfIssue");
/*  35 */   private static final QName BID_CARDS_ID_SOURCES_CD_QNAME = new QName("", "idSourceCd");
/*  36 */   private static final QName BID_CARDS_ID_COUNT_QNAME = new QName("", "idCount");
/*  37 */   private static final QName BID_CARDS_ID_NUM_TYPE_QNAME = new QName("", "idNumberType");
/*  38 */   private static final QName BID_CARDS_ID_PLACE_OF_ISSUE_QNAME = new QName("", "idPlaceOfIssue");
/*  39 */   private static final QName BID_CARDS_ID_ISSUE_DATE_QNAME = new QName("", "idIssueDate");
/*  40 */   private static final QName BID_CARDS_ID_DATE_QNAME = new QName("", "idDate");
/*  41 */   private static final QName BID_CARDS_ID_EXPIRATION_DATE_QNAME = new QName("", "IdExpirationDate");
/*  42 */   private static final QName BID_CARDS_SEGMENT_CODE_QNAME = new QName("", "segmentCode");
/*  43 */   private static final QName BID_CARDS_ID_ISSUER_NAME_QNAME = new QName("", "idIssuerName");
/*  44 */   private static final QName BID_CARDS_ID_NUM_QNAME = new QName("", "idNumber");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BDetails createBDetails()
/*     */   {
/*  58 */     return new BDetails();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bidaddrs createBidaddrs()
/*     */   {
/*  66 */     return new Bidaddrs();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Business createBusiness()
/*     */   {
/*  74 */     return new Business();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Nginquiry createNginquiry()
/*     */   {
/*  82 */     return new Nginquiry();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bussfirm createBussfirm()
/*     */   {
/*  90 */     return new Bussfirm();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Psummary createPsummary()
/*     */   {
/*  98 */     return new Psummary();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Accsum createAccsum()
/*     */   {
/* 106 */     return new Accsum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bhistory createBhistory()
/*     */   {
/* 114 */     return new Bhistory();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ngsysmsg createNgsysmsg()
/*     */   {
/* 122 */     return new Ngsysmsg();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Currcycnct createCurrcycnct()
/*     */   {
/* 130 */     return new Currcycnct();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Guaranto createGuaranto()
/*     */   {
/* 138 */     return new Guaranto();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BPayGrid createBPayGrid()
/*     */   {
/* 146 */     return new BPayGrid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Guarantor createGuarantor()
/*     */   {
/* 154 */     return new Guarantor();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Creditor createCreditor()
/*     */   {
/* 162 */     return new Creditor();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Asclatrend createAsclatrend()
/*     */   {
/* 170 */     return new Asclatrend();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bidphone createBidphone()
/*     */   {
/* 178 */     return new Bidphone();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Relations createRelations()
/*     */   {
/* 186 */     return new Relations();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vintage createVintage()
/*     */   {
/* 194 */     return new Vintage();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enqattr createEnqattr()
/*     */   {
/* 202 */     return new Enqattr();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Credtype createCredtype()
/*     */   {
/* 210 */     return new Credtype();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BurError createBurError()
/*     */   {
/* 218 */     return new BurError();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Expngrpt createExpngrpt()
/*     */   {
/* 226 */     return new Expngrpt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vintagepie createVintagepie()
/*     */   {
/* 234 */     return new Vintagepie();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CommBrpt createCommBrpt()
/*     */   {
/* 242 */     return new CommBrpt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enqrhist createEnqrhist()
/*     */   {
/* 250 */     return new Enqrhist();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TotAccCnt createTotAccCnt()
/*     */   {
/* 258 */     return new TotAccCnt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Acctypinfo createAcctypinfo()
/*     */   {
/* 266 */     return new Acctypinfo();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Currcystat createCurrcystat()
/*     */   {
/* 274 */     return new Currcystat();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Hdetails createHdetails()
/*     */   {
/* 282 */     return new Hdetails();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Modelscr createModelscr()
/*     */   {
/* 290 */     return new Modelscr();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Borrower createBorrower()
/*     */   {
/* 298 */     return new Borrower();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Commcred createCommcred()
/*     */   {
/* 306 */     return new Commcred();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BidCards createBidCards()
/*     */   {
/* 314 */     return new BidCards();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Acctcnt createAcctcnt()
/*     */   {
/* 322 */     return new Acctcnt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Grantor createGrantor()
/*     */   {
/* 330 */     return new Grantor();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Stmtalrt createStmtalrt()
/*     */   {
/* 338 */     return new Stmtalrt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AliasNam createAliasNam()
/*     */   {
/* 346 */     return new AliasNam();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idCountryOfIssue", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdCountryOfIssue(String value)
/*     */   {
/* 355 */     return new JAXBElement(BID_CARDS_ID_COUNTRY_OF_ISSUE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idSourceCd", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdSourceCd(String value)
/*     */   {
/* 364 */     return new JAXBElement(BID_CARDS_ID_SOURCES_CD_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idCount", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdCount(String value)
/*     */   {
/* 373 */     return new JAXBElement(BID_CARDS_ID_COUNT_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idNumberType", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdNumberType(String value)
/*     */   {
/* 382 */     return new JAXBElement(BID_CARDS_ID_NUM_TYPE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idPlaceOfIssue", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdPlaceOfIssue(String value)
/*     */   {
/* 391 */     return new JAXBElement(BID_CARDS_ID_PLACE_OF_ISSUE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idIssueDate", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdIssueDate(String value)
/*     */   {
/* 400 */     return new JAXBElement(BID_CARDS_ID_ISSUE_DATE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idDate", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdDate(String value)
/*     */   {
/* 409 */     return new JAXBElement(BID_CARDS_ID_DATE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="IdExpirationDate", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdExpirationDate(String value)
/*     */   {
/* 418 */     return new JAXBElement(BID_CARDS_ID_EXPIRATION_DATE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="segmentCode", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsSegmentCode(String value)
/*     */   {
/* 427 */     return new JAXBElement(BID_CARDS_SEGMENT_CODE_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idIssuerName", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdIssuerName(String value)
/*     */   {
/* 436 */     return new JAXBElement(BID_CARDS_ID_ISSUER_NAME_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="idNumber", scope=BidCards.class)
/*     */   public JAXBElement<String> createBidCardsIdNumber(String value)
/*     */   {
/* 445 */     return new JAXBElement(BID_CARDS_ID_NUM_QNAME, String.class, BidCards.class, value);
/*     */   }
/*     */ }


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */