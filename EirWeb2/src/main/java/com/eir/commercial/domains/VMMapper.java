package com.eir.commercial.domains;

public class VMMapper {/*

	private static final String SAME_COMPANY_FLAG_Y = "Y";
	private static final String MASKING_STRING_XXX = "XXX";
	private static final String OPEN_ACCOUNT_STATUS = "Open";
	private static final String SANCTIONED_AMOUNT = "SanctionedAmount";
	private static final String BANKING_INDUSTRY_TYPE_CLASSIFICATION = "bankingIndustryTypeClassification";
	private static final String PVT_BANK = "PVT Bank";
	private static final String PSU_BANK = "PSU Bank";
	private static final String FRB_BANK = "FRB Bank";
	private static String reportIdentifier = "Commercial";
	private static String DISCLOSURE_IDENTIFIER = "Commercial - Disclosure";
	private static String COVER_LETTER = "cover_letter_content.properties";
	private static String INVOICE = "invoice.properties";
	
	private ConsumerProductInputData piData;
	private HttpServletRequest request;
	private ReportBO reportData;
	private Report inquiry;
	private ExtractDataFromBO extractDataFromBO;

	private String backgroundDataBOBin = "";
	private List<String> backgroundDataBOBinList = new ArrayList<String>();
	private HashMap<String, List<BusinessRating>> objectMappingForRating = new HashMap<String, List<BusinessRating>>();
	private List<BCADataBO> listOfBorrowerBasedAccounts = new ArrayList<BCADataBO>();
	private List<BCADataBO> listOfGuarantorBasedAccounts = new ArrayList<BCADataBO>();
	private List<BusinessBackgroundDataBO> backgroundDataBOs = new ArrayList<BusinessBackgroundDataBO>();
	private List<BusinessBestIdentityDataBO> bestIdentityDataBOs = null;

	Object dateObj = null;
	private boolean modeIsPds = true;
	private boolean modeIsAdmDisclosure = false;
	private String bureauMemberName = "";
	private static Properties prop = null;
	private static InputStream inputStream = null;
	private InvoiceSeq invoiceSeq;
	
	private static Log logger = LogFactory.getLog(VMMapper.class);
	
	public static String DEFAULT_DATE = "19010201";
	
	public VMMapper(ConsumerProductInputData piData, HttpServletRequest request, String reportIdentifier, boolean modeIsAdmDisclosure) {
		this.piData = piData;
		this.request = request;
		this.modeIsAdmDisclosure = modeIsAdmDisclosure;
		this.reportIdentifier = reportIdentifier;
		extractDataFromBO = new ExtractDataFromBO();
	}

	public String getHtmlVM() {
		VelocityEngine velocityEngine = new VelocityEngine();
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "file");
		properties
				.setProperty("file.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		velocityEngine.init(properties);
		Template template = velocityEngine
				.getTemplate("velocityTemplate/MainCommercial.vm");
		CommercialReportDetails reportDetails = new CommercialReportDetails();
		reportDetails.setDisclosure(modeIsAdmDisclosure);
		reportDetails.setReportIdentifier(reportIdentifier);
		reportData = (ReportBO) request.getSession().getAttribute("reportData");
		inquiry = (Report) request.getSession().getAttribute("InquiryData");
		bestIdentityDataBOs = getBusinessBestIdentity();
		reportDetails.setYear(Calendar.getInstance().get(Calendar.YEAR));
		
		if (isNotEmpty(bestIdentityDataBOs)) {
			createActiveAccountList();
			reportDetails.setScore(getScore());
			reportDetails.setReportHeader(getVMReportHeader());
			reportDetails.setApplication(getCurrentApplication());
			reportDetails.setCompanyDetails(getCompanyDetails());
			getBCAInformationforListPopulation();
			reportDetails.setReportSummary(getReportSummary());
			reportDetails.setAccountSummary(getAccountSummaryFields());
			reportDetails.setLocationDetails(getLocationDetails());
			reportDetails.setRelationshipDetails(getRelationshipDetails());
			reportDetails.setCreditFacilities(getMainCreditFacility());
			reportDetails.setSuitFiledDetails(getSuitFiledDetails());
			reportDetails
					.setFacilityDetailsAsGuarentor(getCreditFacilityDetailsAsGuarentor());
			reportDetails.setEnquiryDetails(getEnquiryDetails());
			if (reportIdentifier.equalsIgnoreCase(DISCLOSURE_IDENTIFIER)){
				reportDetails.setCir(getCoverLetter());
				reportDetails.setInvoice(getInvoice());
			}
			reportDetails.setMatchFound(true);
		} else {
			reportDetails.setApplication(getCurrentApplication());
			System.out.println("No Match Found");
			reportDetails.setMatchFound(false);
		}

		VelocityContext context = new VelocityContext();
		context.put("reportDetails", reportDetails);
		context.put("StringUtils", StringUtils.class);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/yyyy");
		context.put("sdf", sdf);
		context.put("sdf2", sdf2);

		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		String htmlOutput = writer.toString();

		objectMappingForRating.clear();
		return htmlOutput;
	}
	
	public ReportCir getCoverLetter(){
		ReportCir reportCir = new ReportCir();
		prop = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(COVER_LETTER);
		try {
			prop.load(inputStream);
			reportCir.setCompany_name(getStringValue(inquiry.getInquiryData().getCompanyName()));
			
			List<AddressInputData> addressInputData = inquiry.getInquiryData().getAddressDetails();

			if (isNotEmpty(addressInputData)) {
				AddressInputData inquiryaddress = addressInputData.get(0);
				reportCir.setAddress(inquiryaddress.getAddressLine1()
						+ " "+ inquiryaddress.getAddressLine2()
						+ " "+ inquiryaddress.getAddressLine3());
				reportCir.setCity(inquiryaddress.getCity());
				reportCir.setPincode(inquiryaddress.getPincode());
			}
			Calendar calobj = Calendar.getInstance();
			Format sdf = new SimpleDateFormat("dd/MM/yyyy");
			reportCir.setDateOfReport(sdf.format(calobj.getTime()));
			
			reportCir.setExperianReferenceNumber(getStringValue(inquiry.getCommbrpt().getBurRptNum()));
			reportCir.setEmail(prop.getProperty("cover.letter.email"));
			reportCir.setTelephone(prop.getProperty("cover.letter.phone"));
			reportCir.setPost(prop.getProperty("cover.letter.post"));
			reportCir.setWebsite(prop.getProperty("cover.letter.website"));
		} catch (IOException IO) {
			logger.info("getcir:"+IO.getMessage(),IO);
			IO.printStackTrace();
		}
		return reportCir;
	}

	public Score getScore() 
	{
		Score score = new Score();
		score.setIsscore(0);
		score.setScore(0);
		
		try
		{
			if (ElFunctions.get(reportData, Constants.COMMERCIAL_MODL_SCR) != null
	                && !(ElFunctions.get(reportData, Constants.COMMERCIAL_MODL_SCR) instanceof String)) {
				
				CommercialModelScrBO commercialModelScrBO = (CommercialModelScrBO)ElFunctions.get(reportData, Constants.COMMERCIAL_MODL_SCR);
				CommercialModelScrDataBO commercialModelScrDataBO = 
						(CommercialModelScrDataBO)ElFunctions.get(commercialModelScrBO, Constants.COMMERCIAL_MODEL_SCORE_DATABO);
				Double commercialModelScore = (Double)ElFunctions.get(commercialModelScrDataBO, Constants.MODEL_SCORE_VALUE);
				if(piData.isDelphiScoreChk())
				{
					score.setIsscore(1);
				}
				else
				{
					score.setIsscore(0);
				}
				Long L = Math.round(commercialModelScore);
				int comScore = Integer.valueOf(L.intValue());
				
				score.setScore(comScore);
				//score.setScore(735.0);
				return score;
			}
		}
		catch(Exception e)
		{
			logger.error("Exception - getScore:", e);
			e.printStackTrace();
		}
		return score;
	}

	private VMReportHeader getVMReportHeader() {
		VMReportHeader vmHeader = new VMReportHeader();
		ReportHeader header = inquiry.getCommbrpt();
		if (null != header) {
			vmHeader.setEnquiryReference(getStringValue(header.getInqRefNum()));
			vmHeader.setExperianReferenceNumber(getStringValue(header
					.getBurRptNum()));
			bureauMemberName = getStringValue(header.getInqBureauMemberName());
			vmHeader.setMemberName(bureauMemberName);
			dateObj = header.getReportDate();
			Date date = getSqlDate(dateObj);
			vmHeader
					.setGenerateDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			vmHeader.setGenerateTime(getStringValue(header.getBurRptTime()));
		}
		return vmHeader;
	}

	private CurrentApplication getCurrentApplication() {
		CurrentApplication currentApplication = new CurrentApplication();
		currentApplication.setInqCompanyName(getStringValue(inquiry
				.getInquiryData().getCompanyName()));
		currentApplication.setEnquiryPurposeCd(getStringValue(inquiry.getInqHistory().getEnquiryPurposeCd()));
		currentApplication.setEnquiryPurposeCd(getStringValue(piData
				.getPurpose()));
		currentApplication.setEnquiryAmount(getStringValue(getFormattedAmt(piData.getAmount())));
		List<AddressInputData> addressInputData = inquiry.getInquiryData()
				.getAddressDetails();

		if (isNotEmpty(addressInputData)) {
			AddressInputData inquiryaddress = addressInputData.get(0);
			currentApplication.setInqCompanyAddress(inquiryaddress
					.getAddressLine1()
					+ " "
					+ inquiryaddress.getAddressLine2()
					+ " "
					+ inquiryaddress.getAddressLine3());
			currentApplication.setInqCompanyCity(inquiryaddress.getCity());
			currentApplication
					.setInqCompanyPinCode(inquiryaddress.getPincode());
		}

		if (null != inquiry.getInqHistory().getHomePhoneNumber()
				&& inquiry.getInqHistory().getHomePhoneNumber().length() > 0) {
			currentApplication.setTelephone(inquiry.getInqHistory()
					.getHomePhoneNumber());
		} else if (null != inquiry.getInqHistory().getMobilePhoneNumber()
				&& inquiry.getInqHistory().getMobilePhoneNumber().length() > 0) {
			currentApplication.setTelephone(inquiry.getInqHistory()
					.getMobilePhoneNumber());
		} else if (null != inquiry.getInqHistory().getOfficePhoneNumber()
				&& inquiry.getInqHistory().getOfficePhoneNumber().length() > 0) {
			currentApplication.setTelephone(inquiry.getInqHistory()
					.getOfficePhoneNumber());
		} else {
			currentApplication.setTelephone("-");
		}

		currentApplication.setInqPan(getStringValue(inquiry.getInqHistory()
				.getInqPAN()));
		currentApplication.setLoanAccNo(getStringValue(inquiry.getInqHistory()
				.getInqCompanyBankAccNumber()));
		return currentApplication;

	}

	public CompanyDetails getCompanyDetails() {
		CompanyDetails companyDetails = new CompanyDetails();

		Date date = null;
		Object objDate = null;
		List<BusinessBestIdentityDataBO> bestIdentityDataBOs = getBusinessBestIdentity();
		BusinessBestIdentityDataBO bestIdentityDataBO = bestIdentityDataBOs
				.get(0);

		backgroundDataBOs = getBusinessBackground();

		try {
			for (BusinessBackgroundDataBO backgroundDataBO : backgroundDataBOs) {
				backgroundDataBOBinList.add(""
						+ (Long) backgroundDataBO.get("bin"));
			}
		} catch (NextGenBusinessObjectException ne) {
			logger.error("::getCompanyDetails::" + ne.getMessage(),ne);
			ne.printStackTrace();
		}


		List<BorrowerDetail> borrowerDetails = getBorrowerDetailList();
		try {
			extractBusinessRatingToBinBasedMap(backgroundDataBOs);
			companyDetails.setBusNm(getStringValue((String) bestIdentityDataBO
					.get("busNm")));
			companyDetails
					.setCompanyShortName(getStringValue((String) bestIdentityDataBO
							.get("businessAliasName")));
			companyDetails
					.setBusAddress(getStringValue((String) bestIdentityDataBO
							.get("businessAddress")));
			companyDetails
					.setPanNumber(getStringValue((String) bestIdentityDataBO
							.get("panNumber")));
			companyDetails
					.setBusinessTelephone(getStringValue((String) bestIdentityDataBO
							.get("businessTelephone")));

			companyDetails.setBusFax(getStringValue((String) bestIdentityDataBO
					.get("businessFax")));
			companyDetails
					.setLegalConstitution(getStringValue((String) bestIdentityDataBO
							.get("legalConstitution")));
			companyDetails
					.setClassOfActivity(getStringValue((String) bestIdentityDataBO
							.get("lineOfBusiness")));


			companyDetails
					.setBusRegCityNum(getStringValue((String) bestIdentityDataBO
							.get("businessCity")));
			companyDetails
					.setBusRegProvinceCd4In(getStringValue((String) bestIdentityDataBO
							.get("businessState")));
			
			if (null != backgroundDataBOs && backgroundDataBOs.size() > 0) {
				BusinessBackgroundDataBO backgroundDataBO = backgroundDataBOs.get(0);
				backgroundDataBOBin = "" + (Long) backgroundDataBO.get("bin");
	
	
				companyDetails
						.setBusCategoryCd(getStringValue((String) backgroundDataBO
								.get("busCategoryCd")));
				objDate = backgroundDataBO.get("busRegDt");
				date = getSqlDate(objDate);
				companyDetails.setBusRegDt(convertDateToDDMMYYYWithSlashes(date));
	
				String busRegNb4In = "";
				String busRegNb4InType = "9";
				busRegNb4In = extractIdFromBorrowerDetailListForRelatedBin(
						borrowerDetails, backgroundDataBOBin, busRegNb4In,
						busRegNb4InType);
				if (busRegNb4In.length() == 0)
					busRegNb4In = extractIdFromBorrowerDetailListForRelatedBin(
							borrowerDetails, backgroundDataBOBin, busRegNb4In,
							"Company Registration ID");
	
				companyDetails.setBusRegNb4In(busRegNb4In);
	
				companyDetails.setTotalEmpCt(getStringValue(Integer
						.toString((Integer) backgroundDataBO.get("totalEmpCt"))));
				companyDetails.setSalesFigureAm(getStringValue(getFormattedAmt(Long
						.toString((Long) backgroundDataBO.get("salesFigureAm")))));
	
				String serviceTaxNumber = "";
				String serviceTaxNumberType = "15";
				serviceTaxNumber = extractIdFromBorrowerDetailListForRelatedBin(
						borrowerDetails, backgroundDataBOBin, serviceTaxNumber,
						serviceTaxNumberType);
				if (serviceTaxNumber.length() == 0)
					serviceTaxNumber = extractIdFromBorrowerDetailListForRelatedBin(
							borrowerDetails, backgroundDataBOBin, serviceTaxNumber,
							"Service Tax Number");
	
				String cin = "";
				String cinNumberType = "13";
				cin = extractIdFromBorrowerDetailListForRelatedBin(borrowerDetails,
						backgroundDataBOBin, cin, cinNumberType);
				if (cin.length() == 0)
					cin = extractIdFromBorrowerDetailListForRelatedBin(
							borrowerDetails, backgroundDataBOBin, cin,
							"Corporate Identification Number (CIN)");
	
				String taxIdentificationNumber = "";
				String taxIdentificationNumberType = "6";
				taxIdentificationNumber = extractIdFromBorrowerDetailListForRelatedBin(
						borrowerDetails, backgroundDataBOBin,
						taxIdentificationNumber, taxIdentificationNumberType);
				if (taxIdentificationNumber.length() == 0)
					taxIdentificationNumber = extractIdFromBorrowerDetailListForRelatedBin(
							borrowerDetails, backgroundDataBOBin,
							taxIdentificationNumber, "Tax Identification Number");
	
				companyDetails.setIndusCd(getStringValue((String) backgroundDataBO
						.get("busCategoryCd")));
				companyDetails.setCin(getStringValue(cin));
				companyDetails
						.setSic(getStringValue(getStringValue((String) backgroundDataBO
								.get("sicCode"))));
				companyDetails.setTin(getStringValue(taxIdentificationNumber));
				companyDetails
						.setServiceTaxNumber(getStringValue(serviceTaxNumber));
				List<BusinessRating> listForBin = objectMappingForRating
						.get(backgroundDataBOBin);
	
				BusinessRating businessRating = null;
				if (isNotEmpty(listForBin)) {
					businessRating = listForBin.get(0);
				}
				if (null != businessRating) {
					companyDetails
							.setCreditRatingAgency(getStringValue((String) businessRating
									.get("assmntCd")));
					objDate = backgroundDataBO.get("busRegDt");
					date = getSqlDate(objDate);
					companyDetails
							.setLatestCreditRating(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
				} else {
					companyDetails.setCreditRatingAgency("-");
					companyDetails.setLatestCreditRating("-");
				}
	
				objDate = backgroundDataBO.get("finYr");
				date = getSqlDate(objDate);
				companyDetails
						.setFinancialYear(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			}

		} catch (NextGenBusinessObjectException exception) {
			logger.error("::CompanyDetails::" + exception.getMessage(),exception);
			exception.printStackTrace();
		}
		return companyDetails;
	}

	private ReportSummary getReportSummary() {
		ReportSummary reportSummary = new ReportSummary();

		List<BCADataBO> bcaDataBOList = listOfBorrowerBasedAccounts;
		List<BilOutputData> bilOutputDataList = extractDataFromBO
				.getInquiryDetailsList(reportData);
		String MostRecent = "";

		boolean bool = true;
		Date date = null;
		int first = 0, sec = 0, third = 0, forth = 0, fifth = 0, sixth = 0;
		int other_first = 0, other_sec = 0, other_third = 0, other_forth = 0, other_fifth = 0, other_sixth = 0;

		try {
			for (BilOutputData bilOutputData : bilOutputDataList) {
				Object ObjDate = bilOutputData.get("outputInqRqstDt");
				date = getSqlDate(ObjDate);
				String datev = convertDateToDDMMYYYWithSlashes(date);
				if (bool) {
					MostRecent = datev;
					bool = false;
				}

				String institutionName = (String) bilOutputData
						.get("outputInqCreditinstitutionNm");
				institutionName = institutionName.trim();

				int diff = getMonthDifference(date, null);
				institutionName = getStringValue(institutionName);

				if (institutionName.equalsIgnoreCase(bureauMemberName)  && !modeIsAdmDisclosure) {
					if (diff == 0 || diff == 1) {
						first++;
					} else if (diff == 2 || diff == 3) {
						sec++;
					} else if (diff >= 4 && diff <= 6) {
						third++;
					} else if (diff >= 7 && diff <= 11) {
						forth++;
					} else if (diff >= 12 && diff <= 24) {
						fifth++;
					} else {
						sixth++;
					}
				} else {

					if (diff == 1 || diff == 0) {
						other_first++;
					} else if (diff == 2 || diff == 3) {
						other_sec++;
					} else if (diff >= 4 && diff <= 6) {
						other_third++;
					} else if (diff >= 7 && diff <= 11) {
						other_forth++;
					} else if (diff >= 12 && diff <= 24) {
						other_fifth++;
					} else {
						other_sixth++;
					}
				}
			}

		} catch (NextGenBusinessObjectException exception) {
			logger.error("::getReportSummary::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}

		double buruMember = 0, pvt = 0, psu = 0, frb = 0, total = 0, nbfc = 0;
		String bankingIndustryType = "";
		String accountNumber = "";
		String assetClassifCd = "";
		String daysPastDueCt = "";
		String acctStatDetilCD = "";
		int standard = 0, substandard = 0, doubtful = 0, loss = 0, sma = 0, assitClassCode, activeAccounts = 0, totalAccount = 0;
		HashMap<Integer, Integer> totalCreditPro = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> activeCreditPro = new HashMap<Integer, Integer>();
		try {
			if (isNotEmpty(bcaDataBOList)) {
				for (BCADataBO bcaDataBO : bcaDataBOList) {
					accountNumber = (String) bcaDataBO.get("AccountNumber");
					bankingIndustryType = (String) bcaDataBO.get(BANKING_INDUSTRY_TYPE_CLASSIFICATION);
					String CreditProvider = (String) bcaDataBO
							.get("CreditProvider");
					boolean ownCompany = SAME_COMPANY_FLAG_Y.equals((String) bcaDataBO.get("ownCompanyFlag"));

					if ((CreditProvider.equalsIgnoreCase(bureauMemberName) || (modeIsPds && ownCompany))
							&& !modeIsAdmDisclosure) {
						buruMember += Double.parseDouble((String) bcaDataBO
								.get("CurrentBalance"));
					} else if (bankingIndustryType.equalsIgnoreCase(PSU_BANK)) {
						psu += Double.parseDouble((String) bcaDataBO
								.get("CurrentBalance"));
					} else if (bankingIndustryType.equalsIgnoreCase(PVT_BANK)) {
						pvt += Double.parseDouble((String) bcaDataBO
								.get("CurrentBalance"));

					} else if (bankingIndustryType.equalsIgnoreCase(FRB_BANK)) {
						frb += Double.parseDouble((String) bcaDataBO
								.get("CurrentBalance"));
					} else {
						nbfc += Double.parseDouble((String) bcaDataBO
								.get("CurrentBalance"));
					}
					bankingIndustryType = "";
					PaymentHistoryDetail paymentHistoryDetail = null;
					if (((List) bcaDataBO.get("listOfPaymentHistory")).size() > 0) {
						paymentHistoryDetail = (PaymentHistoryDetail) ((List) bcaDataBO
								.get("listOfPaymentHistory")).get(0);
						AccountDetails accountDetails = (AccountDetails) paymentHistoryDetail
								.get("accountDetails");
						acctStatDetilCD = (String) accountDetails
								.get("acctStatDetilCD");
						acctStatDetilCD = acctStatDetilCD.trim();
						assetClassifCd = (String) accountDetails
								.get("assetClassifCd");
						daysPastDueCt = ""
								+ (Short) accountDetails.get("daysPastDueCt");
						assitClassCode = getAssetClassification(assetClassifCd,
								daysPastDueCt);

						totalCreditPro.put((Integer) accountDetails.get("bureauMbrId"), 0);
						if (activeAccountList.contains(acctStatDetilCD)) {
							activeCreditPro.put((Integer) accountDetails.get("bureauMbrId"), 0);
							activeAccounts = activeAccounts + 1;
							if (assitClassCode >= 1 && assitClassCode <= 4) {
								standard = standard + 1;
							} else if (assitClassCode == 5) {
								substandard = substandard + 1;
							} else if (assitClassCode == 6) {
								doubtful = doubtful + 1;
							} else if (assitClassCode == 7) {
								loss = loss + 1;
							} else if (assitClassCode == 8) {
								sma = sma + 1;
							}
						}

					} else {
						acctStatDetilCD = (String) bcaDataBO
								.get("accountStatusDetail");
						acctStatDetilCD = acctStatDetilCD.trim();
						assetClassifCd = (String) bcaDataBO
								.get("assetClassCd");
						daysPastDueCt = "";
						assitClassCode = getAssetClassification(assetClassifCd,
								daysPastDueCt);

						totalCreditPro.put((Integer) bcaDataBO.get("bureauMbrId"), 0);
						if (activeAccountList.contains(acctStatDetilCD)) {
							activeCreditPro.put((Integer) bcaDataBO.get("bureauMbrId"), 0);
							activeAccounts = activeAccounts + 1;
							if (assitClassCode >= 1 && assitClassCode <= 4) {
								standard = standard + 1;
							} else if (assitClassCode == 5) {
								substandard = substandard + 1;
							} else if (assitClassCode == 6) {
								doubtful = doubtful + 1;
							} else if (assitClassCode == 7) {
								loss = loss + 1;
							} else if (assitClassCode == 8) {
								sma = sma + 1;
							}
						}

					}
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getReportSummary::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}

		String totalCreditProviders = "", currentCreditProviders = "";
		if (isNotEmpty(bcaDataBOList)) {
			totalAccount = bcaDataBOList.size();
		}
		
		totalCreditProviders = ""+totalCreditPro.size();
		currentCreditProviders  = ""+activeCreditPro.size();
		total += buruMember + psu + pvt + frb + nbfc;

		if (total != 0) {
			buruMember = (buruMember * 100) / total;
			pvt = (pvt * 100) / total;
			psu = (psu * 100) / total;
			frb = (frb * 100) / total;
			nbfc = (nbfc * 100) / total;

		}
		reportSummary.setEnquiryinstitutionName(bureauMemberName);
		reportSummary.setNumOfActiveAccounts("" + activeAccounts);
		reportSummary.setNumOfAllAccounts("" + totalAccount);
		reportSummary.setCurrentCreditProviders(currentCreditProviders);
		reportSummary.setTotalCreditProviders(totalCreditProviders);
		reportSummary.setStandard("" + standard);
		reportSummary.setSubStandard("" + substandard);
		reportSummary.setDoubtful("" + doubtful);
		reportSummary.setLoss("" + loss);
		reportSummary.setSma("" + sma);

		reportSummary
				.setBureauMember(getTwoDigitDecimalValue(buruMember) + "%");
		reportSummary.setPvt(getTwoDigitDecimalValue(pvt) + "%");
		reportSummary.setPsu(getTwoDigitDecimalValue(psu) + "%");
		reportSummary.setFrb(getTwoDigitDecimalValue(frb) + "%");
		reportSummary.setNbfc(getTwoDigitDecimalValue(nbfc) + "%");

		reportSummary.setMonthOne("" + first);
		reportSummary.setMonthTwoToThree("" + sec);
		reportSummary.setMonthFourToSix("" + third);
		reportSummary.setMonthSevenToTwelve("" + forth);
		reportSummary.setMonthTwelveToTwentyFour("" + fifth);
		reportSummary.setMonthGreaterThanTwentyFour("" + sixth);
		if (first + sec + third + forth + fifth + sixth > 0) {
			reportSummary.setMostRecent(MostRecent);
		} else {
			reportSummary.setMostRecent("-");
		}

		reportSummary.setEnquiryTotal(Integer.toString(first + sec + third
				+ forth + fifth + sixth));

		// Enquiry Summary Part 1:Others

		reportSummary.setOthersmonthOne("" + other_first);
		reportSummary.setOthersmonthTwoToThree("" + other_sec);
		reportSummary.setOthersmonthFourToSix("" + other_third);
		reportSummary.setOthersmonthSevenToTwelve("" + other_forth);
		reportSummary.setOthersmonthTwelveToTwentyFour("" + other_fifth);
		reportSummary.setOthersmonthGreaterThanTwentyFour("" + other_sixth);
		if (other_first + other_sec + other_third + other_forth + other_fifth
				+ other_sixth > 0) {
			reportSummary.setOthersmostRecent(MostRecent);
		} else {
			reportSummary.setOthersmostRecent("-");
		}
		reportSummary.setOthersTotal(Integer.toString(other_first + other_sec
				+ other_third + other_forth + other_fifth + other_sixth));

		// Enquiry Summary Part 1:Total
		reportSummary.setTotalmonthOne(Integer.toString(first + other_first));
		reportSummary
				.setTotalmonthTwoToThree(Integer.toString(sec + other_sec));
		reportSummary.setTotalmonthFourToSix(Integer.toString(third
				+ other_third));
		reportSummary.setTotalmonthSevenToTwelve(Integer.toString(forth
				+ other_forth));
		reportSummary.setTotalmonthTwelveToTwentyFour(Integer.toString(fifth
				+ other_fifth));
		reportSummary.setTotalmonthGreaterThanTwentyFour(Integer.toString(sixth
				+ other_sixth));

		if (first + other_first + sec + other_sec + third + other_third + forth
				+ other_forth + fifth + other_fifth + sixth + other_sixth > 0) {
			reportSummary.setTotalmostRecent(MostRecent);
		} else {
			reportSummary.setTotalmostRecent("-");
		}

		reportSummary.setTotal_total(Integer.toString(first + other_first + sec
				+ other_sec + third + other_third + forth + other_forth + fifth
				+ other_fifth + sixth + other_sixth));
		return reportSummary;
	}

	@SuppressWarnings("unchecked")
	private int getCheckDishonourCount(List<BCADataBO> CRBcaDataList) {
		List<BCADataBO> bcaDataBOsList = CRBcaDataList;
		int dcq = 0;
		Object obj = null;
		try {
			if (isNotEmpty(bcaDataBOsList)) {
				for (BCADataBO bcaDataBO : bcaDataBOsList) {
					obj = bcaDataBO.get("chequesDishonourList");
					if (obj instanceof List) {
						List<BusinessAccountDcqDetail> accountDcqDetails = (List<BusinessAccountDcqDetail>) bcaDataBO
								.get("chequesDishonourList");
						if (isNotEmpty(accountDcqDetails)) {
							if (accountDcqDetails.size() > 0)
								dcq++;
						}
					} else
						return 0;

				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getCheckDisonourCount::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return dcq;
	}

	private List<BusinessAccountDcqDetail> getUniqueDcqList(
			List<BusinessAccountDcqDetail> dcqList) {
		HashMap<String, BusinessAccountDcqDetail> dcqMap = new HashMap<String, BusinessAccountDcqDetail>();
		String key = "";
		int diff = 0;
		Date mapDate = null, dcqDate = null;
		BusinessAccountDcqDetail businessAccountDcqDetail = null;
		List<BusinessAccountDcqDetail> uniqueDcq = new ArrayList<BusinessAccountDcqDetail>();
		Object dateObj;
		try {
			for (BusinessAccountDcqDetail dcqDetail : dcqList) {
				key = (String) dcqDetail.get("dshnrChequeNb");
				
				if (dcqMap.containsKey(key)) {
					businessAccountDcqDetail = dcqMap.get(key);

					dateObj = businessAccountDcqDetail.get("dshnrChequeDt");
					mapDate = getSqlDate(dateObj);

					dateObj = dcqDetail.get("dshnrChequeDt");
					dcqDate = getSqlDate(dateObj);

					diff = getMonthDifference(dcqDate, mapDate);
					
					if (diff > 0) {
						dcqMap.put(key, dcqDetail);
					}

				} else {
					dcqMap.put(key, dcqDetail);
				}
			}
			
			for(String mapKey : dcqMap.keySet()){
				uniqueDcq.add(dcqMap.get(mapKey));
			}
			
		} catch (Exception ex) {
			logger.error(": getUniqueDcqList :" + ex.getMessage(),ex);
			ex.printStackTrace();
		}
		return uniqueDcq;
	}

	private Integer getMonthDifference(Date date, Date date2) {
		int diff = 0;
		Calendar startCalendar = Calendar.getInstance();

		if (date2 == null) {
			startCalendar.setTime(startCalendar.getTime());
		} else {
			startCalendar.setTime(date2);
		}

		Calendar currentDateCal = Calendar.getInstance();
		currentDateCal.setTime(date);

		int diffYear = currentDateCal.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		diff = diffYear * 12 + currentDateCal.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);
		return Math.abs(diff);
	}

	private List<BusinessHistory> getUniqueLocationDetails(
			List<BusinessHistory> businessHistoriesList) {
		List<BusinessHistory> histories = new ArrayList<BusinessHistory>();
		Map<String, BusinessHistory> map = new HashMap<String, BusinessHistory>();
		String key;
		try {
			if (isNotEmpty(businessHistoriesList)) {
				for (BusinessHistory businessHistory : businessHistoriesList) {
					key = "";
					if (businessHistory.getAsReportedBusinessAddressIndBO() != null)
						key = getStringValue((String) businessHistory
								.getAsReportedBusinessAddressIndBO().get("addrTypeCd"));
					key += getStringValue(businessHistory.getBusinessCity());
					key += businessHistory.getBusinessPINCode();
					if (!map.containsKey(key)) {
						map.put(key, businessHistory);
					}
				}
				for (String str : map.keySet()) {
					histories.add(map.get(str));
				}
			}
		} catch (Exception exception) {
			logger.error("getUniqueLocationDetails::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return histories;
	}

	private List<LocationDetails> getLocationDetails() {

		List<LocationDetails> locationDetailsList = new ArrayList<LocationDetails>();
		List<BusinessHistory> businessHistoriesList = getBusinessHistoryDataBOList();
		Date date = null;
		String addType = "";
		try {
			if (isNotEmpty(businessHistoriesList)) {
				businessHistoriesList = getUniqueLocationDetails(businessHistoriesList);
				for (BusinessHistory businessHistory : businessHistoriesList) {
					if (null != businessHistory) {
						LocationDetails details = new LocationDetails();
						if (null != businessHistory.getAsReportedBusinessAddressIndBO())
							addType = (String) businessHistory
									.getAsReportedBusinessAddressIndBO().get(
											"addrTypeCd");
						details
								.setRegOffice(getStringValue(getAddressType((null == addType
										|| addType.trim() == "" || addType
										.trim().length() == 0) ? 19 : Integer
										.parseInt(addType.trim()))));
						details
								.setBusinessAddress(getStringValue(businessHistory
										.getBusinessAddress()));
						details.setBusinessCity(getStringValue(businessHistory
								.getBusinessCity()));
						details.setBusinessId(getStringValue(businessHistory
								.getBusinessId()));
						details.setPinCode(businessHistory.getBusinessPINCode());
						Object ObjDate = businessHistory.getRptAsOfDt();
						date = getSqlDate(ObjDate);
						String datev = convertDateToDDMMYYYWithSlashes(date);
						details.setRptAsOfDt(getStringValue(datev));
						details.setTelephone(getStringValue(businessHistory
								.getBusinessTelephone()));
						locationDetailsList.add(details);
					}

				}
			}

		} catch (NextGenBusinessObjectException ngex) {
			logger.error("LocationDetails::" + ngex.getMessage(), ngex);
			ngex.printStackTrace();
		}
		return locationDetailsList;
	}

	@SuppressWarnings("unchecked")
	private List<SuitFiledDetails> getSuitFiledDetails() {
		List<SuitFiledDetails> suitFiledDetailsList = new ArrayList<SuitFiledDetails>();
		List<BCADataBO> bcaDataBOs = extractDataFromBO
				.getCreditAccount(reportData);
		try {
			for (BCADataBO bcaDataBO : bcaDataBOs) {
				String creditorName = (String) ElFunctions.get(bcaDataBO,
						"CreditProvider") != null
						&& ((String) ElFunctions.get(bcaDataBO,
								"CreditProvider")).length() > 0 ? (String) ElFunctions
						.get(bcaDataBO, "CreditProvider")
						: "";
				List<PaymentHistoryDetail> paymentHistoryDetails = (List<PaymentHistoryDetail>) ElFunctions
						.get(bcaDataBO, "listOfPaymentHistory");

				if (isNotEmpty(paymentHistoryDetails)) {
					PaymentHistoryDetail firstHistoryDetailObject = paymentHistoryDetails
							.get(0);
					AccountDetails accountDetails = (AccountDetails) ElFunctions
							.get(firstHistoryDetailObject, "accountDetails");
					String suitFieldStatus = (String) ElFunctions.get(
							accountDetails, "suitFieldStatus");

					Object ObjDate = ElFunctions.get(accountDetails,
							"suitFilledDate");
					Date suitFilledDate = getSqlDate(ObjDate);
					String datev = convertDateToDDMMYYYWithSlashes(suitFilledDate);

					String suitFiledAm = getFormattedAmt(Long.toString((Long) ElFunctions.get(
							accountDetails, "suitFiledAm")));
					String suitRefNB = (String) ElFunctions.get(accountDetails,
							"suitRefNB");
					SuitFiledDetails suit = new SuitFiledDetails();
					if (suitFieldStatus != null
							&& !"Not a Suit Filed Case"
									.equalsIgnoreCase(suitFieldStatus)) {
						suit.setMemberName(getStringValue(creditorName));
						suit.setSuitFiledAm(getDecimalVelue(suitFiledAm));
						suit
								.setSuitFiledStatCd(getStringValue(suitFieldStatus));
						suit.setSuitRefNB(getStringValue(suitRefNB));
						suit.setSuitAuthDt(getStringValue(datev));
						suitFiledDetailsList.add(suit);
					}
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getSuitFiledDetails::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return suitFiledDetailsList;
	}

	private List<RelationshipInformationDataBO> getUniqueRelationshipDetails (List<RelationshipInformationDataBO> relationshipInformationDataBOsList) {
		HashMap<String, RelationshipInformationDataBO> hashMap = new HashMap<String, RelationshipInformationDataBO>();
		String key = "";
		try {
			for (RelationshipInformationDataBO relationshipInformationDataBO: relationshipInformationDataBOsList){
				key  = getStringValue((String) relationshipInformationDataBO.get("EntityName"))+""+getStringValue((String) relationshipInformationDataBO.get("EntityPAN"));
				hashMap.put(key, relationshipInformationDataBO);
			}
		}catch (NextGenException exception) {
			exception.printStackTrace();
			logger.error("getUniqueRelationshipDetails::" + exception.getMessage(),
					exception);
		}
		List<RelationshipInformationDataBO> dataBOs = new ArrayList<RelationshipInformationDataBO>();
		for (String str :hashMap.keySet() ){
			dataBOs.add(hashMap.get(str));
		}
		return dataBOs;
	}
	
	public List<RelationshipDetails> getRelationshipDetails() {
		List<RelationshipInformationDataBO> relationshipInformationDataBOsList = getRelationShipInfoData();
		relationshipInformationDataBOsList = getUniqueRelationshipDetails(relationshipInformationDataBOsList);
		List<RelationshipDetails> relationshipDetailList = new ArrayList<RelationshipDetails>();
		Object objDate = null;
		Date date = null;

		try {
			for (RelationshipInformationDataBO relationshipInformationDataBO : relationshipInformationDataBOsList) {
				if (null != relationshipInformationDataBO) {
					RelationshipDetails relationshipDetails = new RelationshipDetails();
					String busCategoryCd = (String) relationshipInformationDataBO
							.get("busCategoryCd");
					relationshipDetails
							.setEntityName(getStringValue((String) relationshipInformationDataBO
									.get("CompanyName")));
					relationshipDetails
							.setEntityAddress(getStringValue((String) relationshipInformationDataBO
									.get("EntityAddress")));
					relationshipDetails
							.setEntityPAN(getStringValue((String) relationshipInformationDataBO
									.get("EntityPAN")));
					relationshipDetails
							.setEntityPhone(getStringValue((String) relationshipInformationDataBO
									.get("EntityPhone")));

					objDate = relationshipInformationDataBO
							.get("LastReportedDate");
					date = getSqlDate(objDate);
					relationshipDetails
							.setLastReportedDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

					relationshipDetails
							.setBusCat(getStringValue(busCategoryCd));
					relationshipDetails
							.setBusIndType(getStringValue((String) relationshipInformationDataBO
									.get("indusCd")));
					relationshipDetails
							.setEntityRelatedType(getStringValue((String) relationshipInformationDataBO
									.get("EntityRelatedType")));

					Object ob = relationshipInformationDataBO.get("dob");
					if (ob instanceof Date) {
						date = getSqlDate(ob);
						relationshipDetails
								.setDob(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
					} else
						relationshipDetails
								.setDob(getStringValue((String) (ob)));

					relationshipDetails
							.setGender((String) relationshipInformationDataBO
									.get("genderCd"));
					relationshipDetails
							.setEntityRelationship((String) relationshipInformationDataBO
									.get("EntityRelationship"));

					String rType = (String) relationshipInformationDataBO
							.get("EntityRelatedType");
					rType = rType.toLowerCase().trim();

					if (rType.contains("business")) {
						relationshipDetails.setRelationshipEntity(true);
					} else {
						relationshipDetails.setRelationshipEntity(false);
					}

					String pan = "";
					String panNumberType = "10";
					pan = getIDCodesForRelationship(
							relationshipInformationDataBO, pan, panNumberType);
					if (pan.length() == 0) {
						pan = getIDCodesForRelationship(
								relationshipInformationDataBO, pan, "PAN");
					}
					relationshipDetails.setEntityPAN(getStringValue(pan));

					String cin = "";
					String cinNumberType = "13";
					cin = getIDCodesForRelationship(
							relationshipInformationDataBO, cin, cinNumberType);
					if (cin.length() == 0) {
						cin = getIDCodesForRelationship(
								relationshipInformationDataBO, cin,
								"Corporate Identification Number (CIN)");
					}
					relationshipDetails.setCin(getStringValue(cin));

					relationshipDetails.setOtherId("-");
					String dinNumber = "";
					String dinNumberType = "14";
					dinNumber = getIDCodesForRelationship(
							relationshipInformationDataBO, dinNumber,
							dinNumberType);
					if (dinNumber.length() == 0) {
						dinNumber = getIDCodesForRelationship(
								relationshipInformationDataBO, dinNumber,
								"Director Identification Number (DIN)");
					}
					relationshipDetails.setDin(getStringValue(dinNumber));

					String taxIdentificationNumber = "";
					String taxIdentificationNumberType = "6";
					taxIdentificationNumber = getIDCodesForRelationship(
							relationshipInformationDataBO,
							taxIdentificationNumber,
							taxIdentificationNumberType);
					if (taxIdentificationNumber.length() == 0) {
						taxIdentificationNumber = getIDCodesForRelationship(
								relationshipInformationDataBO,
								taxIdentificationNumber,
								"Tax Identification Number");
					}
					relationshipDetails
							.setTin(getStringValue(taxIdentificationNumber));

					String voterRegistrationNumber = "";
					String voterRegistrationNumberType = "7";
					voterRegistrationNumber = getIDCodesForRelationship(
							relationshipInformationDataBO,
							voterRegistrationNumber,
							voterRegistrationNumberType);
					if (voterRegistrationNumberType.length() == 0) {
						voterRegistrationNumberType = getIDCodesForRelationship(
								relationshipInformationDataBO,
								voterRegistrationNumberType, "Voter ID Number");
					}
					relationshipDetails
							.setVoterId(getStringValue(voterRegistrationNumber));

					String passportNumber = "";
					String passportNumberType = "4";
					passportNumber = getIDCodesForRelationship(
							relationshipInformationDataBO, passportNumber,
							passportNumberType);
					if (passportNumber.length() == 0) {
						passportNumber = getIDCodesForRelationship(
								relationshipInformationDataBO, passportNumber,
								"Passport Number");
					}
					relationshipDetails
							.setPassportNo(getStringValue(passportNumber));

					String dLNumber = "";
					String dLNumberType = "1";
					dLNumber = getIDCodesForRelationship(
							relationshipInformationDataBO, dLNumber,
							dLNumberType);
					if (dLNumber.length() == 0) {
						dLNumber = getIDCodesForRelationship(
								relationshipInformationDataBO, dLNumber,
								"Driver's License Number");
					}
					relationshipDetails
							.setDrivingLiNo(getStringValue(dLNumber));

					String uId = "";
					String uIdType = "12";
					uId = getIDCodesForRelationship(
							relationshipInformationDataBO, uId, uIdType);
					if (uId.length() == 0) {
						uId = getIDCodesForRelationship(
								relationshipInformationDataBO, uId, "AADHAAR");
					}
					relationshipDetails.setUid(getStringValue(uId));

					String rationCardNumber = "";
					String rationCardNumberType = "11";
					rationCardNumber = getIDCodesForRelationship(
							relationshipInformationDataBO, rationCardNumber,
							rationCardNumberType);
					if (rationCardNumber.length() == 0) {
						rationCardNumber = getIDCodesForRelationship(
								relationshipInformationDataBO,
								rationCardNumber, "Ration Card Number");
					}
					relationshipDetails
							.setRationCardNo(getStringValue(rationCardNumber));

					String serviceTaxNumber = "";
					String serviceTaxNumberType = "15";
					serviceTaxNumber = getIDCodesForRelationship(
							relationshipInformationDataBO, serviceTaxNumber,
							serviceTaxNumberType);
					if (serviceTaxNumber.length() == 0) {
						serviceTaxNumber = getIDCodesForRelationship(
								relationshipInformationDataBO,
								serviceTaxNumber, "Service Tax Number");
					}
					relationshipDetails
							.setServiceTaxNo(getStringValue(serviceTaxNumber));

					String dateOfIncorporation = "";
					String dateOfIncorporationType = "";
					dateOfIncorporation = getIDCodesForRelationship(
							relationshipInformationDataBO, dateOfIncorporation,
							dateOfIncorporationType);
					relationshipDetails
							.setDateOfIncorporation(getStringValue(dateOfIncorporation));

					String regNumber = "";
					String regNumberType = "9";
					regNumber = getIDCodesForRelationship(
							relationshipInformationDataBO, regNumber,
							regNumberType);
					if (regNumber.length() == 0) {
						regNumber = getIDCodesForRelationship(
								relationshipInformationDataBO, regNumber,
								"Company Registration ID");
					}
					relationshipDetails.setRegNo(getStringValue(regNumber));
					relationshipDetails
							.setEntityPctResp(getStringValue(((BigDecimal) relationshipInformationDataBO
									.get("EntityPctResp")).toString())
									+ "%");
					relationshipDetailList.add(relationshipDetails);
				}
			}
		} catch (Exception exception) {
			logger.error("RelationshipDetails::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return relationshipDetailList;

	}

	private List<EnquiryDetails> getEnquiryDetails() {
		List<BilOutputData> bilOutputDataList = extractDataFromBO
				.getInquiryDetailsList(reportData);
		List<EnquiryDetails> enquiryDetailsList = new ArrayList<EnquiryDetails>();
		EnquiryDetails inquiryDetails = null;
		Date date = null;
		for (BilOutputData bilOutputData : bilOutputDataList) {
			try {
				inquiryDetails = new EnquiryDetails();
				Object objDate = bilOutputData.get("outputInqRqstDt");
				date = getSqlDate(objDate);
				String datev = convertDateToDDMMYYYWithSlashes(date);

				inquiryDetails.setOutputInqRqstDt(getStringValue(datev));
				inquiryDetails
						.setOutputInqPurpCd4In(getStringValue((String) bilOutputData
								.get("outputInqPurpCd4In")));
				inquiryDetails
						.setCurrency(getStringValue((String) bilOutputData
								.get("outputInqTradeCurrCd")));
				inquiryDetails.setAmount(getStringValue(getFormattedAmt(Long
						.toString((Long) bilOutputData
								.get("outputInqCreditExtAm")))));

				if (null != bilOutputData.get("bureauMbrId") && backgroundDataBOBin.equalsIgnoreCase(Integer
						.toString((Integer) bilOutputData.get("bureauMbrId")))) {
					inquiryDetails
							.setOutputInqCreditinstitutionNm(bureauMemberName);
				} else {
					inquiryDetails
							.setOutputInqCreditinstitutionNm(getStringValue((String) bilOutputData
									.get("outputInqCreditinstitutionNm")));
				}

				enquiryDetailsList.add(inquiryDetails);

			} catch (NextGenBusinessObjectException exception) {
				logger.error("InquiryDetails::" + exception.getMessage(),
						exception);
				exception.printStackTrace();
			}
		}
		return enquiryDetailsList;
	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	private List<CreditFacilityDetailsAsGuarentor> getCreditFacilityDetailsAsGuarentor() {
		List<CreditFacilityDetailsAsGuarentor> creditFacilityDetailsAsGuarentors = new ArrayList<CreditFacilityDetailsAsGuarentor>();
		List<BCADataBO> bcaDataBOs = listOfGuarantorBasedAccounts;
		BusinessBackgroundDataBO businessBackground = null;
		String bin = "";
		Object objDate = null;
		Date date = null;

		if (null == bcaDataBOs || bcaDataBOs.size() == 0)
			return creditFacilityDetailsAsGuarentors;
		try {
			for (BCADataBO bcaDataBO : bcaDataBOs) {

				List<BorrowerDetail> listOfBorrower = (List<BorrowerDetail>) bcaDataBO
						.get("listOfBorrower");

				BorrowerDetail borrowerDetail = listOfBorrower.get(0);
				CreditFacilityDetailsAsGuarentor asGuarantor = new CreditFacilityDetailsAsGuarentor();
				if (!isNotEmpty((List) bcaDataBO.get("listOfPaymentHistory")))
					continue;
				PaymentHistoryDetail paymentHistoryDetail = (PaymentHistoryDetail) ((List) bcaDataBO
						.get("listOfPaymentHistory")).get(0);
				AccountDetails accountDetails = (AccountDetails) paymentHistoryDetail
						.get("accountDetails");
				List<GenericAddress> genericAddresseList = (List<GenericAddress>) borrowerDetail
						.get("BorrowerAddresses");
				GenericAddress genericAddress = genericAddresseList.get(0);

				List<GenericContactDetail> genericContactDetailsList = (List<GenericContactDetail>) borrowerDetail
						.get("BorrowerContactDetails");
				GenericContactDetail genericContactDetail = genericContactDetailsList
						.get(0);

				asGuarantor.setAccNo(getStringValue((String) bcaDataBO
						.get("AccountNumber")));
				asGuarantor.setAccType(getStringValue((String) bcaDataBO
						.get("AccountType")));

				objDate = bcaDataBO.get("SanctionDate");
				date = getSqlDate(objDate);
				asGuarantor
						.setSancDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

				asGuarantor.setSancAmount(getStringValue(getFormattedAmt((String) bcaDataBO
						.get(SANCTIONED_AMOUNT))));
				asGuarantor.setCurrency(getStringValue((String) bcaDataBO
						.get("Currency")));
				asGuarantor.setAccStatus(getStringValue((String) bcaDataBO
						.get("AccountStatus")));
				asGuarantor.setCurrentBal(getStringValue(getFormattedAmt((String) bcaDataBO
						.get("CurrentBalance"))));

				objDate = bcaDataBO.get("LastReportedDate");
				date = getSqlDate(objDate);
				asGuarantor
						.setLastReportedDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

				objDate = borrowerDetail.get("AccountStatusDate");
				date = getSqlDate(objDate);
				asGuarantor
						.setAccStatusDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

				asGuarantor
						.setAssetClass(getStringValue((String) accountDetails
								.get("assetClassification")));

				asGuarantor
						.setWilfulDefault(getStringValue((String) accountDetails
								.get("willfulDefaultStatus")));

				asGuarantor.setHighCredit(getStringValue(""
						+ (Long) accountDetails.get("highestCredit")));
				asGuarantor
						.setInstallationAmount(getDecimalVelue(getFormattedAmt(Long
								.toString((Long) accountDetails
										.get("nextSchdPymtAm")))));
				asGuarantor
						.setRepaymentFreq(getStringValue((String) accountDetails
								.get("pymtTermsDtlCd")));
				asGuarantor.setTenure(getDecimalVelue((String) accountDetails
						.get("termCd")));

				objDate = accountDetails.get("expctPayoffDt");
				date = getSqlDate(objDate);
				asGuarantor
						.setLoanExpMat(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

				objDate = accountDetails.get("loanRenewDt");
				date = getSqlDate(objDate);
				asGuarantor
						.setLoanRenewalDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
				asGuarantor.setLastRepaidAmount(getDecimalVelue(getFormattedAmt(Long
						.toString((Long) accountDetails.get("lastPymtAmt")))));
				asGuarantor.setOverdueAm(getDecimalVelue(getFormattedAmt(Long
						.toString((Long) accountDetails.get("amtOverdue")))));
				asGuarantor.setSetteldAm(getDecimalVelue(getFormattedAmt(Long
						.toString((Long) accountDetails.get("settlementAmt")))));
				asGuarantor.setWrittenOfAm(getDecimalVelue(getFormattedAmt(Long
						.toString((Long) accountDetails
								.get("totalWrittenOffAmt")))));
				asGuarantor
						.setDrawingPower(getDecimalVelue(getFormattedAmt(Long
								.toString((Long) accountDetails
										.get("drawingPowerAm")))));

				asGuarantor
						.setBusRegCityNum(getStringValue((String) genericAddress
								.get("city")));
				asGuarantor
						.setAssetBSecCov(getStringValue((String) accountDetails
								.get("securityCvrgCd")));
				asGuarantor
						.setGuarenteeCov(getStringValue((String) accountDetails
								.get("guarCvrgCd")));
				asGuarantor
						.setRestructRea(getStringValue((String) accountDetails
								.get("rstrucRsnCd")));
				asGuarantor.setSuitFiled(getStringValue((String) accountDetails
						.get("suitFieldStatus")));

				asGuarantor.setBusNm(getStringValue((String) borrowerDetail
						.get("BorrowerName")));
				asGuarantor
						.setCompanyShortName(getStringValue((String) borrowerDetail
								.get("AliasName")));
				asGuarantor
						.setBusRegProvinceCd4In(getStringValue((String) genericAddress
								.get("state")));

				asGuarantor
						.setBusinessTelephone(getStringValue((String) genericContactDetail.get("phoneNumber")));
				String busAddress = (String) genericAddress.get("addressLine1")
						+ " " + genericAddress.get("addressLine2") + " "
						+ genericAddress.get("addressLine3");
				asGuarantor.setBusAddress(getStringValue(busAddress));
				String sicCode = "";
				String sicCodeType = "1";
				sicCode = getIDCodesForBorrower(borrowerDetail,
						backgroundDataBOBin, sicCode, sicCodeType);
				asGuarantor.setSic(getStringValue(sicCode));

				String taxIdentificationNumber = "";
				String taxIdentificationNumberType = "6";
				taxIdentificationNumber = getIDCodesForGuarantorBasedBorrower(
						borrowerDetail, taxIdentificationNumber,
						taxIdentificationNumberType);
				if (taxIdentificationNumber.length() == 0) {
					taxIdentificationNumber = getIDCodesForGuarantorBasedBorrower(
							borrowerDetail, taxIdentificationNumber,
							"Tax Identification Number");
				}
				asGuarantor.setTin(getStringValue(taxIdentificationNumber));

				String panNumber = "";
				String panNumberType = "10";
				panNumber = getIDCodesForGuarantorBasedBorrower(borrowerDetail,
						panNumber, panNumberType);
				if (panNumber.length() == 0) {
					panNumber = getIDCodesForGuarantorBasedBorrower(
							borrowerDetail, panNumber, "PAN");
				}
				asGuarantor.setPanNumber(getStringValue(panNumber));

				String serviceTaxNumber = "";
				String serviceTaxNumberType = "15";
				serviceTaxNumber = getIDCodesForGuarantorBasedBorrower(
						borrowerDetail, serviceTaxNumber, serviceTaxNumberType);
				if (serviceTaxNumber.length() == 0) {
					serviceTaxNumber = getIDCodesForGuarantorBasedBorrower(
							borrowerDetail, serviceTaxNumber,
							"Service Tax Number");
				}
				asGuarantor
						.setServiceTaxNumber(getStringValue(serviceTaxNumber));

				String cin = "";
				String cinNumberType = "13";
				cin = getIDCodesForGuarantorBasedBorrower(borrowerDetail, cin,
						cinNumberType);
				if (cin.length() == 0) {
					cin = getIDCodesForGuarantorBasedBorrower(borrowerDetail,
							cin, "Corporate Identification Number (CIN)");
				}
				asGuarantor.setCin(getStringValue(cin));

				asGuarantor.setMarkToMarket(getStringValue(""
						+ (Long) accountDetails.get("currentBalance")));

				asGuarantor
						.setRestructDetails(getStringValue((String) accountDetails
								.get("rstrucRsnCd")));
				asGuarantor.setNaorc(getStringValue(""
						+ (Long) accountDetails.get("rstrucContractAm")));
				asGuarantor.setNotionalAmOfCont(getStringValue(""
						+ (Long) accountDetails.get("creditExtended")));
				asGuarantor.setAmOfContCNPA(getStringValue(""
						+ (Long) accountDetails.get("npaContractAm")));
				asGuarantor
						.setBusFax(getFaxNumberFromContactDetail(genericContactDetailsList));
				String busRegNb4In = "";
				String busRegNb4InType = "9";
				busRegNb4In = getIDCodesForGuarantorBasedBorrower(
						borrowerDetail, busRegNb4In, busRegNb4InType);
				if (busRegNb4In.length() == 0) {
					busRegNb4In = getIDCodesForGuarantorBasedBorrower(
							borrowerDetail, busRegNb4In,
							"Company Registration ID");
				}

				asGuarantor.setBusRegNb4In(busRegNb4In);

				bin = (String) borrowerDetail.get("bin");
				businessBackground = getBusinessBackgroundDataBOForBorrower(bin);

				asGuarantor.setDpd("-");
				asGuarantor.setBusRegDt("-");
				asGuarantor.setTotalEmpCt(getStringValue("-"));
				asGuarantor.setSalesFigureAm(getStringValue(getFormattedAmt("-")));
				asGuarantor.setIndusCd(getStringValue("-"));
				asGuarantor.setBusCategoryCd(getStringValue("-"));
				asGuarantor.setFinancialYear(getStringValue("-"));
				asGuarantor.setLatestCreditRating(getStringValue(""));
				asGuarantor.setCreditRatingAgency(getStringValue(""));
				asGuarantor.setLegalConstitution("-"); //
				asGuarantor.setClassOfActivity("-");

				creditFacilityDetailsAsGuarentors.add(asGuarantor);
			}
		} catch (Exception e) {
			logger
					.info(
							":: Error in generation of getCreditFacilityDetailsAsGuarentor() method ::",
							e);
			e.printStackTrace();
		}
		return creditFacilityDetailsAsGuarentors;
	}

	private BusinessBackgroundDataBO getBusinessBackgroundDataBOForBorrower(
			String bin) {
		String backgroundBin = "";

		try {
			for (BusinessBackgroundDataBO backgroundDataBO : backgroundDataBOs) {
				backgroundBin = Long.toString((Long) backgroundDataBO
						.get("bin"));
				if (bin == backgroundBin) {
					return backgroundDataBO;
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.info("::getBusinessBackgroundDataBOForBorrower::"
					+ exception.getMessage(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	private String getFaxNumberFromContactDetail(
			List<GenericContactDetail> genericContactDetailsList) {
		String phoneType = "";
		String fax = "";
		try {
			for (GenericContactDetail contactDetail : genericContactDetailsList) {
				phoneType = (String) contactDetail.get("phoneType");
				if (phoneType == "2" || phoneType == "4") {
					fax = (String) contactDetail.get("phoneNumber");
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.info("::getFaxNumberFromContactDetail::"
					+ exception.getMessage(), exception);
			exception.printStackTrace();
		}
		return fax;
	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	private List<MainCreditFacility> getMainCreditFacility() {
		List<BCADataBO> bcaDataBOs = listOfBorrowerBasedAccounts;

		Object dateObj = null;
		Date date = null;
		List<MainCreditFacility> creditFacilities = new ArrayList<MainCreditFacility>();
		String accountType = "";
		String bankingIndustryTypeClassification = "", creditProvider = "";
		String accountNumber = "";
		String suitFiled = "", willfulDefault = "";
		try {
			for (BCADataBO bcaDataBO : bcaDataBOs) {
				MainCreditFacility creditFacility = new MainCreditFacility();
				String assetClassifCd = null;
				String daysPastDueCt = null;
				String acctStatDetilCD = null;
				AccountDetails accountDetails = null;
				if (((List) bcaDataBO.get("listOfPaymentHistory")).size() == 0){

					acctStatDetilCD = (String) bcaDataBO
							.get("accountStatusDetail");
					acctStatDetilCD = acctStatDetilCD.trim();
					assetClassifCd = (String) bcaDataBO
							.get("assetClassCd");
					daysPastDueCt = "";
				} else {
					PaymentHistoryDetail paymentHistoryDetail = (PaymentHistoryDetail) ((List) bcaDataBO
						.get("listOfPaymentHistory")).get(0);
					accountDetails = (AccountDetails) paymentHistoryDetail
							.get("accountDetails");
	
					assetClassifCd = (String) accountDetails
							.get("assetClassifCd");
					daysPastDueCt = ""
							+ (Short) accountDetails.get("daysPastDueCt");
					acctStatDetilCD = (String) accountDetails
							.get("acctStatDetilCD");

				}
				CreditFacilityDetails details = new CreditFacilityDetails();
				bankingIndustryTypeClassification = getStringValue((String) bcaDataBO
						.get(BANKING_INDUSTRY_TYPE_CLASSIFICATION));
				creditProvider = getStringValue((String) bcaDataBO
						.get("CreditProvider"));
				accountNumber = (String) bcaDataBO.get("AccountNumber");

				boolean ownCompany = SAME_COMPANY_FLAG_Y.equals((String) bcaDataBO.get("ownCompanyFlag"));
				
				if (bureauMemberName.equalsIgnoreCase(creditProvider)
						|| (modeIsPds && ownCompany) && !modeIsAdmDisclosure) {
					details.setBankName(creditProvider);
				} else if (modeIsAdmDisclosure){
					details.setBankName(creditProvider);
				} else {
					details.setBankName(bankingIndustryTypeClassification);
				}

				details.setAccNo(getStringValue((String) bcaDataBO
						.get("AccountNumber")));
				accountType = getStringValue(
						(String) bcaDataBO.get("AccountType")).toLowerCase();

				if (accountType.equalsIgnoreCase("derivatives")) {
					creditFacility.setDerivative(true);
				} else {
					creditFacility.setDerivative(false);
				}

				details.setAccType(getStringValue((String) bcaDataBO
						.get("AccountType")));
				details.setCurrency(getStringValue((String) bcaDataBO
						.get("Currency")));
				details.setSancAmount(getStringValue(getFormattedAmt((String) bcaDataBO
						.get(SANCTIONED_AMOUNT))));

				dateObj = bcaDataBO.get("SanctionDate");
				date = getSqlDate(dateObj);
				details
						.setSancDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

				details.setAccStatus(getStringValue((String) bcaDataBO
						.get("AccountStatus")));

				*//**
				 * Set the value of Account Status Date to blank, If the
				 * borrower details carries the said value then this data will
				 * get populated
				 *//*
				
				details.setAccStatusDate(getStringValue(null));

				details.setCurrentBal(getStringValue(getFormattedAmt((String) bcaDataBO.get("CurrentBalance"))));
				details.setMarkToMarket(getStringValue(getFormattedAmt((String)bcaDataBO.get("CurrentBalance"))));
//				details.setCurrentBal(getStringValue((String) accountDetails.get("currentBalance")));
				
				dateObj = bcaDataBO.get("LastReportedDate");
				date = getSqlDate(dateObj);
				
				details.setLastReportedDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

				details.setAssetClass(getStringValue((String) bcaDataBO.get("CurrentAssetClassification")));
				
				details.setDpd(getStringValue(daysPastDueCt));
				if (null != accountDetails) {
					details
							.setDrawingPower(getDecimalVelue(getFormattedAmt(Long
									.toString((Long) accountDetails
											.get("drawingPowerAm"))))); // ??
					details
							.setInstallationAmount(getDecimalVelue(getFormattedAmt(Long
									.toString((Long) accountDetails
											.get("nextSchdPymtAm"))))); // ??
					details.setLastRepaidAmount(getDecimalVelue(getFormattedAmt(Long
							.toString((Long) accountDetails.get("lastPymtAmt")))));
					details.setRepaymentFreq(getStringValue((String) accountDetails
							.get("pymtTermsDtlCd"))); // ??
					details.setTenure(getStringValue((String) accountDetails
							.get("termCd")));
	
					dateObj = accountDetails.get("expctPayoffDt");
					date = getSqlDate(dateObj);
					details
							.setLoanExpMat(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
	
					dateObj = accountDetails.get("loanRenewDt");
					date = getSqlDate(dateObj);
					details
							.setLoanRenewalDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
	
					suitFiled = getStringValue((String) accountDetails
							.get("suitFieldStatus"));
					suitFiled = suitFiled.toLowerCase().trim();
					if (suitFiled.contains("not")) {
						details.setSuitFiled(getStringValue(""));
					} else {
						details.setSuitFiled(getStringValue((String) accountDetails
								.get("suitFieldStatus")));
					}
	
					willfulDefault = getStringValue((String) accountDetails
							.get("willfulDefaultStatus"));
					willfulDefault = willfulDefault.toLowerCase().trim();
					if (willfulDefault.contains("not")) {
						details.setWillfulDefault(getStringValue(""));
					} else {
						details
								.setWillfulDefault(getStringValue((String) accountDetails
										.get("willfulDefaultStatus")));
					}
					details.setHighCredit(getDecimalVelue(""
							+ (Long) accountDetails.get("highestCredit")));
					details.setOverdueAm(getDecimalVelue(getFormattedAmt(Long
							.toString((Long) accountDetails.get("amtOverdue")))));
					details.setSetteldAm(getDecimalVelue(getFormattedAmt(Long
							.toString((Long) accountDetails.get("settlementAmt")))));
					details.setAssetBSecCov(getStringValue((String) accountDetails
							.get("securityCvrgCd")));
					details.setGuarenteeCov(getStringValue((String) accountDetails
							.get("guarCvrgCd")));
					details.setRestructRea(getStringValue((String) accountDetails
							.get("rstrucRsnCd")));
					details
							.setRestructDetails(getStringValue((String) accountDetails
									.get("rstrucRsnCd")));
					details.setWrittenOfAm(getDecimalVelue(getFormattedAmt(Long
							.toString((Long) accountDetails
									.get("totalWrittenOffAmt")))));
					details.setNotionalAmOfCont(getStringValue(getFormattedAmt(""
							+ (Long) accountDetails.get("creditExtended"))));
					details.setNaorc(getStringValue(""
							+ (Long) accountDetails.get("rstrucContractAm")));
					details.setAmOfContCNPA(getStringValue(getFormattedAmt(""
							+ (Long) accountDetails.get("npaContractAm"))));
					details
							.setWieghtedAvgMatPeriodOfContract(getStringValue((String) accountDetails
									.get("termCd")));
				}
				creditFacility.setCreditFacilityDetails(details);

				
				
				Date lastPayDate = null, lastReportedDate = null;
				List<PaymentHistoryDetail> paymentHistoryDetailsList = (List<PaymentHistoryDetail>) bcaDataBO
						.get("listOfPaymentHistory");
				if (isNotEmpty(paymentHistoryDetailsList)) {
					PaymentHistoryDetail historyDetail = paymentHistoryDetailsList.get(0);
					date = getSqlDate(historyDetail.get("pymtDate"));
					lastPayDate = date;
					lastReportedDate = date;
					details.setLastReportedDate(convertDateToDDMMYYYWithSlashes(date));
				}
//				
				int cout = 0;
				int lenth = paymentHistoryDetailsList.size();
				if (lenth > 24) {
					lenth = 24;
				}
				int counter = 24;

				List<CreditFacilityPaymentHistory> paymentHistoriesList = new ArrayList<CreditFacilityPaymentHistory>();
				CreditFacilityPaymentHistory history = null;
				PaymentHistoryDetail historyDetail = null;
				
				for (int i = 1; i <= counter; i++) {
					if (lenth-1 > 0 ) {
						historyDetail = paymentHistoryDetailsList.get(i);
						if (cout == 0) {
							history = new CreditFacilityPaymentHistory();
							date = getSqlDate(historyDetail.get("pymtDate"));
							history
									.setMonth1(getStringValue(convertDateToMMMYYYWithSlashes(date)));
							history.setCurrentBalance(getFormattedAmt(getStringValue(""+ (Long) historyDetail.get("currBalance"))));
							history
									.setStatus(getStringValue((String) historyDetail
											.get("pymtStatus")));
						} else if (cout == 1) {
							date = getSqlDate(historyDetail.get("pymtDate"));
							history
									.setMonth2(getStringValue(convertDateToMMMYYYWithSlashes(date)));
							history.setCurrentBalance2(getFormattedAmt(getStringValue(""+ (Long) historyDetail.get("currBalance"))));
							history.setStatus2((String) historyDetail
									.get("pymtStatus"));
						} else if (cout == 2) {
							date = getSqlDate(historyDetail.get("pymtDate"));
							history
									.setMonth3(getStringValue(convertDateToMMMYYYWithSlashes(date)));
							history.setCurrentBalance3(getFormattedAmt(getStringValue(""+ (Long) historyDetail.get("currBalance"))));
							history.setStatus3((String) historyDetail
									.get("pymtStatus"));
						} else if (cout == 3) {
							date = getSqlDate(historyDetail.get("pymtDate"));
							history
									.setMonth4(getStringValue(convertDateToMMMYYYWithSlashes(date)));
							history.setCurrentBalance4(getFormattedAmt(getStringValue(""+ (Long) historyDetail.get("currBalance"))));
							history.setStatus4((String) historyDetail
									.get("pymtStatus"));
						} else if (cout == 4) {
							date = getSqlDate(historyDetail.get("pymtDate"));
							history
									.setMonth5(getStringValue(convertDateToMMMYYYWithSlashes(date)));
							history.setCurrentBalance5(getFormattedAmt(getStringValue(""+ (Long) historyDetail.get("currBalance"))));
							history.setStatus5((String) historyDetail
									.get("pymtStatus"));
						} else if (cout == 5) {
							date = getSqlDate(historyDetail.get("pymtDate"));
							history
									.setMonth6(getStringValue(convertDateToMMMYYYWithSlashes(date)));
							history.setCurrentBalance6(getFormattedAmt(getStringValue(""+ (Long) historyDetail.get("currBalance"))));
							history.setStatus6((String) historyDetail
									.get("pymtStatus"));
						}
						lastPayDate = date;
					} else {
						lastPayDate = reduceDateByOneMonth(lastPayDate);
						if (cout == 0) {
							history = new CreditFacilityPaymentHistory();
							history
									.setMonth1(getStringValue(convertDateToMMMYYYWithSlashes(lastPayDate)));
							history.setCurrentBalance(getStringValue(""));
							history.setStatus(getStringValue(""));
						} else if (cout == 1) {
							history
									.setMonth2(getStringValue(convertDateToMMMYYYWithSlashes(lastPayDate)));
							history.setCurrentBalance2(getStringValue(""));
							history.setStatus2(getStringValue(""));
						} else if (cout == 2) {
							history
									.setMonth3(getStringValue(convertDateToMMMYYYWithSlashes(lastPayDate)));
							history.setCurrentBalance3(getStringValue(""));
							history.setStatus3(getStringValue(""));
						} else if (cout == 3) {
							history
									.setMonth4(getStringValue(convertDateToMMMYYYWithSlashes(lastPayDate)));
							history.setCurrentBalance4(getStringValue(""));
							history.setStatus4(getStringValue(""));
						} else if (cout == 4) {
							history
									.setMonth5(getStringValue(convertDateToMMMYYYWithSlashes(lastPayDate)));
							history.setCurrentBalance5(getStringValue(""));
							history.setStatus5(getStringValue(""));
						} else if (cout == 5) {
							history
									.setMonth6(getStringValue(convertDateToMMMYYYWithSlashes(lastPayDate)));
							history.setCurrentBalance6(getStringValue(""));
							history.setStatus6(getStringValue(""));
						}
					}
					if (cout == 5) {
						paymentHistoriesList.add(history);
						cout = 0;
					} else {
						cout++;
					}
					lenth--;
				}

				creditFacility.setPaymentHistory(paymentHistoriesList);

				List<GuarantorDetail> guarantorDetails = (List<GuarantorDetail>) bcaDataBO
						.get("listOfGuarantor");
				List<CreditFacilityGuarentorDetails> creditFacilityGuarentorDetailsList = new ArrayList<CreditFacilityGuarentorDetails>();
				if (isNotEmpty(guarantorDetails)) {
					for (GuarantorDetail guarantorDetail : guarantorDetails) {
						List<GenericNameDetails> genericNameDetailsList = (List<GenericNameDetails>) guarantorDetail
								.get("GuarantorNameDetails");
						GenericNameDetails genericNameDetails = null;
						CreditFacilityGuarentorDetails creditFacilityGuarentorDetails = new CreditFacilityGuarentorDetails();
						if (null != genericNameDetailsList
								&& genericNameDetailsList.size() > 0) {
							genericNameDetails = genericNameDetailsList.get(0);
							creditFacilityGuarentorDetails
									.setCompanyName(getStringValue((String) genericNameDetails
											.get("FirstName"))
											+ " "
											+ getStringValue((String) genericNameDetails
													.get("FamilyName")));
							creditFacilityGuarentorDetails
									.setEntityName(getStringValue((String) genericNameDetails
											.get("FirstName"))
											+ " "
											+ getStringValue((String) genericNameDetails
													.get("FamilyName")));
						} else {
							creditFacilityGuarentorDetails
									.setCompanyName(getStringValue((String) guarantorDetail
											.get("GuarantorName")));
							creditFacilityGuarentorDetails
									.setEntityName(getStringValue((String) guarantorDetail
											.get("GuarantorName")));
						}
						List<GenericAddress> addresses = (List<GenericAddress>) guarantorDetail
								.get("GuarantorAddresses");
						if (isNotEmpty(addresses)) {
							GenericAddress address = addresses.get(0);
							creditFacilityGuarentorDetails
									.setEntityAddress(address
											.get("addressLine1")
											+ " "
											+ address.get("addressLine2")
											+ " " + address.get("addressLine3"));
						}

						String panNumber = "";
						String panNumberType = "10";
						panNumber = getIDCodesForGuarantor(guarantorDetail,
								panNumber, panNumberType);
						if (panNumber.length() == 0) {
							panNumber = getIDCodesForGuarantor(guarantorDetail,
									panNumber, "PAN");
						}
						creditFacilityGuarentorDetails
								.setEntityPAN(getStringValue(panNumber));

						String cin = "";
						String cinNumberType = "13";
						cin = getIDCodesForGuarantor(guarantorDetail, cin,
								cinNumberType);
						if (cin.length() == 0) {
							cin = getIDCodesForGuarantor(guarantorDetail, cin,
									"Corporate Identification Number (CIN)");
						}
						creditFacilityGuarentorDetails
								.setCin(getStringValue(cin));

						String taxIdentificationNumber = "";
						String taxIdentificationNumberType = "6";
						taxIdentificationNumber = getIDCodesForGuarantor(
								guarantorDetail, taxIdentificationNumber,
								taxIdentificationNumberType);
						if (taxIdentificationNumber.length() == 0) {
							taxIdentificationNumber = getIDCodesForGuarantor(
									guarantorDetail, taxIdentificationNumber,
									"Tax Identification Number");
						}
						creditFacilityGuarentorDetails
								.setTin(getStringValue(taxIdentificationNumber));

						String dinNumber = "";
						String dinNumberType = "14";
						dinNumber = getIDCodesForGuarantor(guarantorDetail,
								dinNumber, dinNumberType);
						if (dinNumber.length() == 0) {
							dinNumber = getIDCodesForGuarantor(guarantorDetail,
									dinNumber, "Director Identification Number");
						}
						creditFacilityGuarentorDetails
								.setDin(getStringValue(dinNumber));

						String serviceTaxNumber = "";
						String serviceTaxNumberType = "15";
						serviceTaxNumber = getIDCodesForGuarantor(
								guarantorDetail, serviceTaxNumber,
								serviceTaxNumberType);
						if (serviceTaxNumber.length() == 0) {
							serviceTaxNumber = getIDCodesForGuarantor(
									guarantorDetail, serviceTaxNumber,
									"Service Tax Number");
						}
						creditFacilityGuarentorDetails
								.setServiceTaxNo(getStringValue(serviceTaxNumber));

						String passportNumber = "";
						String passportNumberType = "4";
						passportNumber = getIDCodesForGuarantor(
								guarantorDetail, passportNumber,
								passportNumberType);
						if (passportNumber.length() == 0) {
							passportNumber = getIDCodesForGuarantor(
									guarantorDetail, passportNumber,
									"Passport Number");
						}
						creditFacilityGuarentorDetails
								.setPassportNo(getStringValue(passportNumber));

						String voterRegistrationNumber = "";
						String voterRegistrationNumberType = "7";
						voterRegistrationNumber = getIDCodesForGuarantor(
								guarantorDetail, voterRegistrationNumber,
								voterRegistrationNumberType);
						if (voterRegistrationNumber.length() == 0) {
							voterRegistrationNumber = getIDCodesForGuarantor(
									guarantorDetail, voterRegistrationNumber,
									"Voter ID Number");
						}
						creditFacilityGuarentorDetails
								.setVoterId(getStringValue(voterRegistrationNumber));

						String rationCardNumber = "";
						String rationCardNumberType = "11";
						rationCardNumber = getIDCodesForGuarantor(
								guarantorDetail, rationCardNumber,
								rationCardNumberType);
						if (rationCardNumber.length() == 0) {
							rationCardNumber = getIDCodesForGuarantor(
									guarantorDetail, rationCardNumber,
									"Ration Card Number");
						}
						creditFacilityGuarentorDetails
								.setRationCardNo(getStringValue(rationCardNumber));

						String uId = "";
						String uIdType = "12";
						uId = getIDCodesForGuarantor(guarantorDetail, uId,
								uIdType);
						if (uId.length() == 0) {
							uId = getIDCodesForGuarantor(guarantorDetail, uId,
									"AADHAAR");
						}
						creditFacilityGuarentorDetails
								.setUid(getStringValue(uId));

						String dLNumber = "";
						String dLNumberType = "1";
						dLNumber = getIDCodesForGuarantor(guarantorDetail,
								dLNumber, dLNumberType);
						if (dLNumber.length() == 0) {
							dLNumber = getIDCodesForGuarantor(guarantorDetail,
									dLNumber, "Driver's License Number");
						}
						creditFacilityGuarentorDetails
								.setDrivingLiNo(getStringValue(dLNumber));

						if (null != genericNameDetails) {
							creditFacilityGuarentorDetails
									.setDob(getStringValue(convertDateToDDMMYYYWithSlashes(getSqlDate((Date) genericNameDetails
											.get("DateOfBirth")))));
							creditFacilityGuarentorDetails
									.setGender(getStringValue((String) genericNameDetails
											.get("Gender")));
						} else {
							creditFacilityGuarentorDetails.setDob("-");
							creditFacilityGuarentorDetails.setGender("-");
						}

						String GuarantorType = (String) guarantorDetail
								.get("GuarantorType");
						GuarantorType = GuarantorType.toLowerCase().trim();

						if (GuarantorType.contains("business")) {
							creditFacilityGuarentorDetails.setIndividual(false);
						} else {
							creditFacilityGuarentorDetails.setIndividual(true);
						}

						creditFacilityGuarentorDetails
								.setType(getStringValue((String) guarantorDetail
										.get("GuarantorType")));

						dateObj = guarantorDetail
								.get("GuarantorLastReportedDate");
						creditFacilityGuarentorDetails
								.setLastReportedDate(getStringValue(convertDateToDDMMYYYWithSlashes(getSqlDate(dateObj))));

						List<GenericContactDetail> genericContactDetailsList = (List<GenericContactDetail>) guarantorDetail
								.get("GuarantorContactDetails");
						GenericContactDetail genericContactDetail;
						if (null != genericContactDetailsList
								&& genericContactDetailsList.size() > 0) {
							genericContactDetail = genericContactDetailsList
									.get(0);
							creditFacilityGuarentorDetails
									.setEntityPhone(getStringValue((String) genericContactDetail
											.get("phoneNumber")));
						}

						creditFacilityGuarentorDetails
								.setEntityRelatedType("-");
						creditFacilityGuarentorDetails
								.setEntityRelationship("-");
						creditFacilityGuarentorDetails.setOtherid("-");

						creditFacilityGuarentorDetails
								.setBusCat(getStringValue(""));
						creditFacilityGuarentorDetails
								.setBusIndType(getStringValue(""));
						creditFacilityGuarentorDetails
								.setDateOfIncorporation(getStringValue(""));
						creditFacilityGuarentorDetails
								.setRegNo(getStringValue(""));

						creditFacilityGuarentorDetailsList
								.add(creditFacilityGuarentorDetails);
					}
				}
				creditFacility
						.setGuarentorDetailsSec(creditFacilityGuarentorDetailsList);

				// Credit Facility Details:6.4

				List<BorrowerDetail> listOfBorrower = (List<BorrowerDetail>) bcaDataBO
						.get("listOfBorrower");

				String binOfFirstBorrower = (String) listOfBorrower.get(0).get(
						"bin");
				List<CreditFacilityBorowerDetails> borowerDetailsList = new ArrayList<CreditFacilityBorowerDetails>();

				boolean borrow = true;
				if (isNotEmpty(listOfBorrower)) {
					creditFacility.setBorrower(true);
					for (BorrowerDetail borrowerDetail : listOfBorrower) {
						if (borrow) {
							borrow = false;
						} else {
							break;
						}
						CreditFacilityBorowerDetails creditFacilityBorowerDetails = new CreditFacilityBorowerDetails();
						creditFacilityBorowerDetails
								.setBorrowerNm(getStringValue((String) borrowerDetail
										.get("BorrowerName")));
						List<GenericAddress> addresses = (List<GenericAddress>) borrowerDetail
								.get("BorrowerAddresses");
						if (isNotEmpty(addresses)) {
							GenericAddress address = addresses.get(0);
							creditFacilityBorowerDetails
									.setAddress(getStringValue(address
											.get("addressLine1")
											+ " "
											+ address.get("addressLine2")
											+ " " + address.get("addressLine3")));

							creditFacilityBorowerDetails.setAddType(getStringValue((String)address.get("locationType")));
						}

						String cin = "";
						String cinNumberType = "13";
						cin = getIDCodesForBorrower(borrowerDetail, backgroundDataBOBin, 
								cin, cinNumberType);
						if (cin.length() == 0) {
							cin = getIDCodesForBorrower(borrowerDetail,
									backgroundDataBOBin, cin,
									"Corporate Identification Number (CIN)");
						}
						creditFacilityBorowerDetails
								.setCin(getStringValue(cin));
						
						String taxIdentificationNumber = "";
						String taxIdentificationNumberType = "6";
						taxIdentificationNumber = getIDCodesForBorrower(
								borrowerDetail, 
								backgroundDataBOBin,
								taxIdentificationNumber, taxIdentificationNumberType);
						if (taxIdentificationNumber.length() == 0) {
							taxIdentificationNumber = getIDCodesForBorrower(
									borrowerDetail, backgroundDataBOBin, taxIdentificationNumber,
									"Tax Identification Number");
						}
						creditFacilityBorowerDetails
								.setTin(getStringValue(taxIdentificationNumber));

						Object object = borrowerDetail.get("AccountStatusDate");
						date = getSqlDate(object);
						
						details.setAccStatusDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
						creditFacilityBorowerDetails.setAccStatusDate(getStringValue(convertDateToDDMMYYYWithSlashes(date)));

						String panNumber = "";
						String panNumberType = "10";
						panNumber = getIDCodesForBorrower(borrowerDetail,
								backgroundDataBOBin, panNumber, panNumberType);
						if (panNumber.length() == 0) {
							panNumber = getIDCodesForBorrower(borrowerDetail,
									backgroundDataBOBin, panNumber,
									"PAN");
						}

						creditFacilityBorowerDetails
								.setPanNo(getStringValue(panNumber));

						dateObj = borrowerDetail
								.get("BorrowerLastReportedDate");
						creditFacilityBorowerDetails
								.setLastReportDate(convertDateToDDMMYYYWithSlashes(getSqlDate(dateObj))); // ??
						borowerDetailsList.add(creditFacilityBorowerDetails);
					}
				} else {
					creditFacility.setBorrower(false);
				}

				creditFacility.setBorowerDetails4(borowerDetailsList);

				List<CreditFacilitiesSecuritiesDetails> securitiesDetails = new ArrayList<CreditFacilitiesSecuritiesDetails>();

				Object ob = bcaDataBO.get("securityList");
				List<BusinessAccountSecurityDetail> businessAccountSecurityDetails = null;
				if (ob instanceof List) {
					businessAccountSecurityDetails = (List) ob;
					businessAccountSecurityDetails = getUniqueSecuritiesDetails(businessAccountSecurityDetails, lastReportedDate);
				} else if (ob instanceof String)

				if (isNotEmpty(businessAccountSecurityDetails)) {
					System.out.println(businessAccountSecurityDetails.size()+ "businessAccountSecurityDetails.size()");
				}

				if (null != businessAccountSecurityDetails
						&& businessAccountSecurityDetails.size() > 0) {
					creditFacility.setSecurity(true);
					for (BusinessAccountSecurityDetail businessAccountSecurityDetail : businessAccountSecurityDetails) {
						if (null != businessAccountSecurityDetail ){
							CreditFacilitiesSecuritiesDetails creditFacilitiesSecuritiesDetails = new CreditFacilitiesSecuritiesDetails();
							creditFacilitiesSecuritiesDetails
									.setCurrency(getStringValue((String) businessAccountSecurityDetail
											.get("tradeCurrCd")));
							creditFacilitiesSecuritiesDetails
									.setType(getStringValue((String) businessAccountSecurityDetail
											.get("secTypeCd")));
							creditFacilitiesSecuritiesDetails
									.setClassification(getStringValue(getFormattedAmt((String) businessAccountSecurityDetail
											.get("secClassCd"))));
							creditFacilitiesSecuritiesDetails
									.setSecurityValue(getStringValue((String) businessAccountSecurityDetail
											.get("securedAm")));
							creditFacilitiesSecuritiesDetails
									.setValuationDate(getStringValue(convertDateToDDMMYYYWithSlashes((Date) businessAccountSecurityDetail
											.get("valuationDt"))));
							creditFacilitiesSecuritiesDetails
									.setLastReportDate(getStringValue(convertDateToDDMMYYYWithSlashes((Date) businessAccountSecurityDetail
											.get("rptAsOfDt"))));
							securitiesDetails
									.add(creditFacilitiesSecuritiesDetails);
						
						}
					}
				} else {
					creditFacility.setSecurity(false);
				}
				creditFacility.setSecuritiesDetails5s(securitiesDetails);

				// Credit Facility Details:6.6

				List<CreditFacilityCheckDishonour> dishonour = new ArrayList<CreditFacilityCheckDishonour>();
				List<BusinessAccountDcqDetail> businessAccountDcqDetails = null;
				ob = bcaDataBO.get("chequesDishonourList");

				if (ob instanceof List) {
					businessAccountDcqDetails = (List<BusinessAccountDcqDetail>) ob;
					businessAccountDcqDetails = getUniqueDcqList(businessAccountDcqDetails);
				} else if (ob instanceof String)
					System.out.println("chequesDishonourList::" + (String) ob);
				
				int month3 = 0;
				int month6 = 0;
				int month9 = 0;
				int month12 = 0;

				if (isNotEmpty(businessAccountDcqDetails)) {
					creditFacility.setCheckDishonour(true);
					int diff = 0;
					for (BusinessAccountDcqDetail accountDcqDetail : businessAccountDcqDetails) {
						dateObj = accountDcqDetail.get("dshnrChequeDt");
						date = getSqlDate(dateObj);
						diff = getMonthDifference(date, null);
						if (diff >= 0 && diff < 3) {
							month3++;
						} else if (diff >= 3 && diff < 6) {
							month3++;
							month6++;
						} else if (diff >= 6 && diff < 9) {
							month3++;
							month6++;
							month9++;
						} else {
							month3++;
							month6++;
							month9++;
							month12++;
						}
					}
					CreditFacilityCheckDishonour checkDishonour = new CreditFacilityCheckDishonour();
					checkDishonour.setMonth("No of Times Dishonered");
					checkDishonour.setMonth3(Integer.toString(month3));
					checkDishonour.setMonth6(Integer.toString(month6));
					checkDishonour.setMonth9(Integer.toString(month9));
					checkDishonour.setMonth12(Integer.toString(month12));
					dishonour.add(checkDishonour);

				} else {
					creditFacility.setCheckDishonour(false);
				}

				creditFacility.setCheckDishonour6s(dishonour);

				// Credit Facility Details:6.7

				List<BusinessRating> listForBin = objectMappingForRating
						.get(binOfFirstBorrower);
				CreditFacilityCreditRatings ratings = new CreditFacilityCreditRatings();
				
				if (isNotEmpty(listForBin)) {
					creditFacility.setCreditRating(true);
					int totalSize = listForBin.size();
					String creditRatingAsOn = "";
					String creditRatingExpDate = "";
					String creditRatingReportDate = "";
					if (totalSize < 3) {
						for (int i = 0; i < totalSize; i++) {
							BusinessRating businessRating = listForBin.get(i);
							creditRatingAsOn = getStringValue((String) businessRating
									.get("rptAsOfDt"));
							creditRatingExpDate = getStringValue((String) businessRating
									.get("creditRatingExpiryDt"));
							creditRatingReportDate = getStringValue((String) businessRating
									.get("creditRatingIssueDt"));
							fillRatings(ratings, i, creditRatingAsOn,
									creditRatingExpDate, creditRatingReportDate);
						}
						for (int j = totalSize; j < 3; j++) {
							fillRatings(ratings, j, "", "", "");
						}
					} else {
						for (int i = 0; i < 3; i++) {
							BusinessRating businessRating = listForBin.get(i);
							creditRatingAsOn = getStringValue((String) businessRating
									.get("rptAsOfDt"));
							creditRatingExpDate = getStringValue((String) businessRating
									.get("creditRatingExpiryDt"));
							creditRatingReportDate = getStringValue((String) businessRating
									.get("creditRatingIssueDt"));
							fillRatings(ratings, i, creditRatingAsOn,
									creditRatingExpDate, creditRatingReportDate);
						}
					}
				} else {
					creditFacility.setCreditRating(false);
				}

				creditFacility.setCreditRatings(ratings);
				creditFacilities.add(creditFacility);
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getMainCreditFacility ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return creditFacilities;
	}
	
	
	
	private static List<BusinessAccountSecurityDetail> getUniqueSecuritiesDetails (List<BusinessAccountSecurityDetail> businessAccountSecurityDetailList, Date lastReportedDate){
		Date securityDate = null;
		List<BusinessAccountSecurityDetail> accountSecurityDetails = new ArrayList<BusinessAccountSecurityDetail>();
		if (isNotEmpty(businessAccountSecurityDetailList)) {
			try {
				for(BusinessAccountSecurityDetail securityDetail :  businessAccountSecurityDetailList) {
					if (null != securityDetail){
						if (null != securityDetail.get("rptAsOfDt"))
							securityDate = (Date)securityDetail.get("rptAsOfDt");
						if (null !=lastReportedDate && null != securityDate && lastReportedDate.equals(securityDate)) {
							accountSecurityDetails.add(securityDetail);
						}
					}
				}
			} catch (NextGenException exception) {
				logger.error(":getUniqueSecuritiesDetails:"+exception.getMessage(),exception);
				exception.printStackTrace();
			}
		}
		return accountSecurityDetails;
	}

	private void fillRatings(CreditFacilityCreditRatings ratings, int i,
			String creditRatingAsOn, String creditRatingExpDate,
			String creditRatingReportDate) {
		if (i == 1) {
			ratings.setCreditRatingasOnaaa(creditRatingAsOn);
			ratings.setCreditRatingExpiryDateaaa(creditRatingExpDate);
			ratings.setCreditRatingReportedDateaaa(creditRatingReportDate);
		}

		if (i == 2) {
			ratings.setCreditRatingasOnaa(creditRatingAsOn);
			ratings.setCreditRatingExpiryDateaa(creditRatingExpDate);
			ratings.setCreditRatingReportedDateaa(creditRatingReportDate);
		}

		if (i == 3) {
			ratings.setCreditRatingasOnbbb(creditRatingAsOn);
			ratings.setCreditRatingExpiryDatebbb(creditRatingExpDate);
			ratings.setCreditRatingReportedDatebbb(creditRatingReportDate);
		}
	}

	@SuppressWarnings("unchecked")
	private List<BusinessBestIdentityDataBO> getBusinessBestIdentity() {
		List<BusinessBestIdentityDataBO> bestIdentityDataBOs = new ArrayList<BusinessBestIdentityDataBO>();
		try {
			List<BusinessBestIdentityBO> bestIdentityBOs = (List<BusinessBestIdentityBO>) reportData
					.get("BusinessIdentity");
			if (isNotEmpty(bestIdentityBOs)) {
				for (BusinessBestIdentityBO bestIdentityBO : bestIdentityBOs) {
					bestIdentityDataBOs
							.addAll((List<BusinessBestIdentityDataBO>) bestIdentityBO
									.get("businessIdentity"));
				}
			} else {
				System.err.println("Profile not Found");
				return null;
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getBusinessBestIdentity ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return bestIdentityDataBOs;
	}

	@SuppressWarnings("unchecked")
	private List<BusinessBackgroundDataBO> getBusinessBackground() {
		List<BusinessBackgroundBO> businessBackgroundBOList = null;
		List<BusinessBackgroundDataAttrsBO> businessBackgroundDataAttrsBOList = null;
		List<BusinessBackgroundDataBO> businessBackgroundDataBO = new ArrayList<BusinessBackgroundDataBO>();

		try {
			businessBackgroundBOList = (List<BusinessBackgroundBO>) reportData
					.get("BusinessBackground");
			for (BusinessBackgroundBO backgroundBO : businessBackgroundBOList) {
				businessBackgroundDataAttrsBOList = (List<BusinessBackgroundDataAttrsBO>) backgroundBO
						.get("businessBackground");
				for (BusinessBackgroundDataAttrsBO backgroundDataAttrsBO : businessBackgroundDataAttrsBOList) {
					businessBackgroundDataBO
							.addAll((List<BusinessBackgroundDataBO>) backgroundDataAttrsBO
									.get("businessBackground"));
				}
			}

		} catch (NextGenBusinessObjectException exception) {
			logger.error("getBusinessBackground ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return businessBackgroundDataBO;
	}

	@SuppressWarnings("unchecked")
	private List<ReportSummaryDataBO> getReportSummaryList() {
		List<ReportSummaryBO> reportSummaryBOList = null;
		List<ReportSummaryDataBO> reportSummaryDataBOList = new ArrayList<ReportSummaryDataBO>();
		try {
			reportSummaryBOList = (List<ReportSummaryBO>) reportData
					.get("reportSummary");
			if (isNotEmpty(reportSummaryBOList)) {
				for (ReportSummaryBO reportSummaryBO : reportSummaryBOList) {
					reportSummaryDataBOList
							.addAll((List<ReportSummaryDataBO>) reportSummaryBO
									.get("reportSummaryInfo"));
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getReportSummaryList ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return reportSummaryDataBOList;
	}

	@SuppressWarnings("unchecked")
	private List<BCADataBO> getBCAInformation() {
		List<BCABO> bcabos = null;
		List<BCADataBO> bcaDataBOs = new ArrayList<BCADataBO>();
		try {
			bcabos = (List<BCABO>) reportData.get("BCAInformation");
			if (null != bcabos && bcabos.size() > 0) {
				for (BCABO bcabo : bcabos) {
					bcaDataBOs.addAll((List<BCADataBO>) bcabo.get("BCAData"));
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getBCAInformation ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return bcaDataBOs;
	}

	@SuppressWarnings("unchecked")
	private void getBCAInformationforListPopulation() {
		List<BCABO> bcabos = null;
		boolean guarantorBasedAccounts = false;
		try {
			bcabos = (List<BCABO>) reportData.get("BCAInformation");
			if (null != bcabos && bcabos.size() > 0) {
				for (BCABO bcabo : bcabos) {
					List<BCADataBO> bcaDataBoList = (List<BCADataBO>) bcabo
							.get("BCAData");
					for (BCADataBO bcaAccountObject : bcaDataBoList) {
						guarantorBasedAccounts = false;

						for (GuarantorDetail guarantorDetail : (List<GuarantorDetail>) bcaAccountObject
								.get("listOfGuarantor")) {
							String guarantorBin = (String) guarantorDetail
									.get("bin");
							if (backgroundDataBOBinList.contains(guarantorBin)) {
								guarantorBasedAccounts = true;
								break;
							}
						}

						if (guarantorBasedAccounts) {
							if (null == listOfGuarantorBasedAccounts)
								listOfGuarantorBasedAccounts = new ArrayList<BCADataBO>();
							listOfGuarantorBasedAccounts.add(bcaAccountObject);
						} else {
							if (null == listOfBorrowerBasedAccounts)
								listOfBorrowerBasedAccounts = new ArrayList<BCADataBO>();
							listOfBorrowerBasedAccounts.add(bcaAccountObject);
						}
					}
				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getBCAInformation ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private List<BorrowerDetail> getBorrowerDetailList() {
		List<BorrowerDetail> borrowerDetails = new ArrayList<BorrowerDetail>();
		List<BCADataBO> bcaDataBOs = getBCAInformation();
		if (isNotEmpty(bcaDataBOs)) {
			try {
				for (BCADataBO bcaDataBO : bcaDataBOs) {
					borrowerDetails.addAll((List<BorrowerDetail>) bcaDataBO
							.get("listOfBorrower"));
				}
			} catch (NextGenBusinessObjectException exception) {
				logger.error("getBorrowerDetailList ::"
						+ exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		return borrowerDetails;
	}

	private List<BusinessHistory> getBusinessHistoryDataBOList() {
		List<BusinessHistory> businessHistories = inquiry.getBusHistoryList();
		if (isNotEmpty(businessHistories)) {
			return businessHistories;
		} else {
			return new ArrayList<BusinessHistory>();
		}
	}

	@SuppressWarnings("unchecked")
	private List<RelationshipInformationDataBO> getRelationShipInfoData() {
		List<RelationshipInformationBO> relationshipInformationBOList = null;
		List<RelationshipInformationDataBO> relationshipInformationDataBOList = new ArrayList<RelationshipInformationDataBO>();
		if (reportData != null) {
			try {
				if (!(ElFunctions.get(reportData, "relationshipInformation") instanceof String)) {
					relationshipInformationBOList = (List<RelationshipInformationBO>) ElFunctions
							.get(reportData, "relationshipInformation");
					if (isNotEmpty(relationshipInformationBOList)) {
						for (RelationshipInformationBO relationshipInformationBO : relationshipInformationBOList) {
							if (relationshipInformationBO != null
									&& !(ElFunctions.get(
											relationshipInformationBO,
											"relationshipInformationData") instanceof String)
									&& isNotEmpty((List<RelationshipInformationDataBO>) ElFunctions
											.get(relationshipInformationBO,
													"relationshipInformationData"))) {
								relationshipInformationDataBOList
										.addAll((List<RelationshipInformationDataBO>) ElFunctions
												.get(relationshipInformationBO,
														"relationshipInformationData"));
							}
						}
					}
				}
			} catch (NextGenBusinessObjectException exception) {
				logger.error("getRelationShipInfoData::"
						+ exception.getMessage());
				return relationshipInformationDataBOList;
			}
		}
		return relationshipInformationDataBOList;
	}

	@SuppressWarnings( { "unchecked" })
	public List<BCADataBO> getCreditAccount() {
		List<BCABO> bCABOList = null;
		List<BCADataBO> bCADataBO = new ArrayList<BCADataBO>();
		try {
			bCABOList = (List<BCABO>) reportData.get("BCAInformation");
			for (BCABO bcabo : bCABOList) {
				bCADataBO.addAll(((List<BCADataBO>) bcabo.get("BCAData")));
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getCreditAccount ::" + exception.getMessage(),
					exception);
			exception.printStackTrace();
		}
		return bCADataBO;
	}

	@SuppressWarnings("unchecked")
	private String getGenericIDS(BorrowerDetail borrowerDetail,
			String backgroundDataBOBin, String targetIdNumber,
			String targetIdNumberType) {
		List<GenericIdNumber> genericIdNumbers;
		try {
			genericIdNumbers = (List<GenericIdNumber>) borrowerDetail
					.get("BorrowerIdNumbers");
			if (isNotEmpty(genericIdNumbers)) {

			}
			for (GenericIdNumber genericIdNumber : genericIdNumbers) {
				String idNumberType = ((String) genericIdNumber
						.get("idNumberType")).trim();
				String idNum = ((String) genericIdNumber.get("idNumber"))
						.trim();
				if (targetIdNumber.length() == 0
						&& idNumberType.equalsIgnoreCase(targetIdNumberType)
						&& idNum.length() > 0) {
					targetIdNumber = idNum;
				}
				if (targetIdNumber.length() > 0)
					break;
			}
		} catch (NextGenBusinessObjectException nex) {
			logger.error("getGenericIDS ::" + nex.getMessage(),nex);
			nex.printStackTrace();
		}

		return targetIdNumberType;
	}

	@SuppressWarnings("unchecked")
	private String getIDCodesForRelationship(
			RelationshipInformationDataBO relationshipInformationDataBO,
			String targetIdNumber, String targetIdNumberType) {
		try {

			List<GenericIdNumber> genericIdNumbers = (List<GenericIdNumber>) relationshipInformationDataBO
					.get("relationIdNumbers");
			for (GenericIdNumber genericIdNumber : genericIdNumbers) {
				String idNumberType = ((String) genericIdNumber
						.get("idNumberType")).trim();
				String idNum = ((String) genericIdNumber.get("idNumber"))
						.trim();
				if (targetIdNumber.length() == 0
						&& idNumberType.equalsIgnoreCase(targetIdNumberType)
						&& idNum.length() > 0) {
					targetIdNumber = idNum;
				}
				if (targetIdNumber.length() > 0)
					break;

			}
		} catch (NextGenBusinessObjectException ngex) {
			logger.error("getIDCodesForRelationship"+ngex.getMessage(),ngex);
			ngex.printStackTrace();
		}

		return targetIdNumber;
	}

	@SuppressWarnings("unchecked")
	private String getIDCodesForGuarantor(GuarantorDetail guarantorDetail,
			String targetIdNumber, String targetIdNumberType) {
		try {

			List<GenericIdNumber> genericIdNumbers = (List<GenericIdNumber>) guarantorDetail
					.get("GuarantorIdNumbers");
			for (GenericIdNumber genericIdNumber : genericIdNumbers) {
				String idNumberType = ((String) genericIdNumber
						.get("idNumberType")).trim();
				String idNum = ((String) genericIdNumber.get("idNumber"))
						.trim();
				if (targetIdNumber.length() == 0
						&& idNumberType.equalsIgnoreCase(targetIdNumberType)
						&& idNum.length() > 0) {
					targetIdNumber = idNum;
				}
				if (targetIdNumber.length() > 0)
					break;

			}

		} catch (NextGenBusinessObjectException nboex) {
			logger.error("::Exception in getIDCodesForGuarantor()::"+nboex.getMessage(),nboex);
			nboex.printStackTrace();
		}
		return targetIdNumber;
	}

	@SuppressWarnings("unchecked")
	private String getIDCodesForBorrower(BorrowerDetail borrowerDetail,
			String backgroundDataBOBin, String targetIdNumber,
			String targetIdNumberType) {
		try {
			String borrowerDetailBin = (String) borrowerDetail.get("bin");
			if (backgroundDataBOBinList.contains(borrowerDetailBin)) {
//			if (borrowerDetailBin.equalsIgnoreCase(backgroundDataBOBin)) {
				List<GenericIdNumber> genericIdNumbers = (List<GenericIdNumber>) borrowerDetail
						.get("BorrowerIdNumbers");
				for (GenericIdNumber genericIdNumber : genericIdNumbers) {
					String idNumberType = ((String) genericIdNumber
							.get("idNumberType")).trim();
					String idNum = ((String) genericIdNumber.get("idNumber"))
							.trim();
					if (targetIdNumber.length() == 0
							&& idNumberType
									.equalsIgnoreCase(targetIdNumberType)
							&& idNum.length() > 0) {
						targetIdNumber = idNum;
					}
					if (targetIdNumber.length() > 0)
						break;

				}
			}
		} catch (NextGenBusinessObjectException ngex) {
			logger.info("::Exception in getIDCodesForBorrower()::"+ngex.getMessage(), ngex);
			ngex.printStackTrace();
		}
		return targetIdNumber;
	}

	@SuppressWarnings("unchecked")
	private String getIDCodesForGuarantorBasedBorrower(
			BorrowerDetail borrowerDetail, String targetIdNumber,
			String targetIdNumberType) {
		try {
			List<GenericIdNumber> genericIdNumbers = (List<GenericIdNumber>) borrowerDetail
					.get("BorrowerIdNumbers");
			for (GenericIdNumber genericIdNumber : genericIdNumbers) {
				String idNumberType = ((String) genericIdNumber
						.get("idNumberType")).trim();
				String idNum = ((String) genericIdNumber.get("idNumber"))
						.trim();
				if (targetIdNumber.length() == 0
						&& idNumberType.equalsIgnoreCase(targetIdNumberType)
						&& idNum.length() > 0) {
					targetIdNumber = idNum;
				}
				if (targetIdNumber.length() > 0)
					break;

			}

		} catch (NextGenBusinessObjectException ngex) {
			logger.error("::getIDCodesForGuarantorBasedBorrower ::"+ngex.getMessage(),ngex);
			ngex.printStackTrace();
		}
		return targetIdNumber;
	}

	@SuppressWarnings("unchecked")
	private String extractIdFromBorrowerDetailListForRelatedBin(
			List<BorrowerDetail> borrowerDetails, String backgroundDataBOBin,
			String targetIdNumber, String targetIdNumberType) {
		try {
			for (BorrowerDetail borrowerDetail : borrowerDetails) {
				String borrowerDetailBin = (String) borrowerDetail.get("bin");
				if (backgroundDataBOBin.equals(borrowerDetailBin)) {
					List<GenericIdNumber> genericIdNumbers = (List<GenericIdNumber>) borrowerDetail
							.get("BorrowerIdNumbers");
					for (GenericIdNumber genericIdNumber : genericIdNumbers) {
						String idNumberType = ((String) genericIdNumber
								.get("idNumberType")).trim();
						String idNum = ((String) genericIdNumber
								.get("idNumber")).trim();
						if (targetIdNumber.length() == 0
								&& idNumberType
										.equalsIgnoreCase(targetIdNumberType)
								&& idNum.length() > 0) {
							targetIdNumber = idNum;
						}
						if (targetIdNumber.length() > 0)
							break;
					}
				}
				if (targetIdNumber.length() > 0)
					break;
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("extractIdFromBorrowerDetailListForRelatedBin::"
					+ exception.getMessage(), exception);
			exception.printStackTrace();
		}
		return targetIdNumber;
	}

	@SuppressWarnings("unchecked")
	private void extractBusinessRatingToBinBasedMap(
			List<BusinessBackgroundDataBO> backgroundDataBOs) {
		try {
			for (BusinessBackgroundDataBO backgroundDataBoObject : backgroundDataBOs) {
				String bin = "" + (Long) backgroundDataBoObject.get("bin");
				List<BusinessRating> list = (List<BusinessRating>) backgroundDataBoObject
						.get("listOfBusinessRatings");
				if (null == list || list.size() == 0)
					continue;
				if (objectMappingForRating.get(bin) == null)
					objectMappingForRating.put(bin,
							new ArrayList<BusinessRating>());
				objectMappingForRating.get(bin).addAll(list);
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("extractBusinessRatingToBinBasedMap::"
					+ exception.getMessage(), exception);
			exception.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CreditFacCurrencySummaryDataBO> getCreditFacility() {
		List<CreditFacCurrencySummaryDataBO> creditFacCurrencySummaryDataBOList = new ArrayList<CreditFacCurrencySummaryDataBO>();
		List<CreditFacilityOutBO> creditFacilityOutBOList = null;
		try {
			creditFacilityOutBOList = (List<CreditFacilityOutBO>) reportData
					.get("creditFacility");
			if (isNotEmpty(creditFacilityOutBOList)) {
				for (CreditFacilityOutBO creditFacilityOutBO : creditFacilityOutBOList) {
					creditFacCurrencySummaryDataBOList
							.addAll((List<CreditFacCurrencySummaryDataBO>) creditFacilityOutBO
									.get("creditFacilityData"));
				}
			}

		} catch (NextGenBusinessObjectException ngex) {
			logger.error("::getIDCodesForGuarantorBasedBorrower ::"+ngex.getMessage(),ngex);
			ngex.printStackTrace();
		}

		return creditFacCurrencySummaryDataBOList;
	}

	private String convertDateToDDMMYYYWithSlashes(Date date) {
		if (date != null) {
			Format sdf = new SimpleDateFormat("dd/MM/yyyy");
			String datev = sdf.format(date);
			if (datev.contains("0001")) {
				return " ";
			} else {
				return datev;
			}
		}
		return "";
	}

	private String convertDateToMMMYYYWithSlashes(Date date) {
		if (date != null) {
			Format sdf = new SimpleDateFormat("MMM-yyyy");
			String datev = sdf.format(date);
			if (datev.contains("0001")) {
				return " ";
			} else {
				return datev;
			}
		}
		return "";
	}

	private static boolean isNotNull(String str) {
		if (null != str) {
			str = str.trim();
		}
		return null != str && !"".equals(str) && !"-1".equals(str);
	}

	private static String getStringValue(String str) {
		if (isNotNull(str)) {
			return str;
		} else
			return "-";
	}

	private static String getDecimalVelue(String value) {
		if (value != null) {
			value = value.trim();
		}
		if (value == null || "-1".equals(value) || value.contains("-1")) {
			return "0";
		} else
			return value;
	}

	public static String getTwoDigitDecimalValue(double val) {
		DecimalFormat df = new DecimalFormat("#.##");
		String str = df.format(val);
		return str;
	}

	private static boolean isNotEmpty(List<?> list) {
		return (list != null && list.size() > 0);
	}

	private AccountSummary getAccountSummaryFields() {
		AccountSummary accSum = new AccountSummary();
		List<CurrencyBasedAccSummDataBO> currencyBasedAccSummDataBOList = extractDataFromBO
				.getAccountSummaryData(reportData);
		int cfb_self = 0, cfb_PSU = 0, cfb_PVT = 0, cfb_NBFC = 0, cfb_Non_Self = 0, cfb_Grand = 0;
		int cfg_self = 0, cfg_PSU = 0, cfg_PVT = 0, cfg_NBFC = 0, cfg_Non_Self = 0, cfg_Grand = 0;
		int acf_self = 0, acf_PSU = 0, acf_PVT = 0, acf_NBFC = 0, acf_Non_Self = 0, acf_Grand = 0;

		long TOAB_self = 0, TOAB_PSU = 0, TOAB_PVT = 0, TOAB_NBFC = 0, TOAB_Non_Self = 0, TOAB_Grand = 0;
		long TOAG_self = 0, TOAG_PSU = 0, TOAG_PVT = 0, TOAG_NBFC = 0, TOAG_Non_Self = 0, TOAG_Grand = 0;

		int DCFAB_self = 0, DCFAB_PSU = 0, DCFAB_PVT = 0, DCFAB_NBFC = 0, DCFAB_Non_Self = 0, DCFAB_Grand = 0;
		int DCFABB_self = 0, DCFABB_PSU = 0, DCFABB_PVT = 0, DCFABB_NBFC = 0, DCFABB_Non_Self = 0, DCFABB_Grand = 0;

		int DCFAG_self = 0, DCFAG_PSU = 0, DCFAG_PVT = 0, DCFAG_NBFC = 0, DCFAG_Non_Self = 0, DCFAG_Grand = 0;
		int DCFAGB_self = 0, DCFAGB_PSU = 0, DCFAGB_PVT = 0, DCFAGB_NBFC = 0, DCFAGB_Non_Self = 0, DCFAGB_Grand = 0;

		List<Date> LAOD_self = new ArrayList<Date>(), LAOD_PSU = new ArrayList<Date>(), LAOD_PVT = new ArrayList<Date>(), LAOD_NBFC = new ArrayList<Date>(), LAOD_Non_Self = new ArrayList<Date>(), LAOD_Grand = new ArrayList<Date>();
		List<BCADataBO> bcaDataBOBorrowerList = listOfBorrowerBasedAccounts;
		List<BCADataBO> bcaDataBOGuarantorList = listOfGuarantorBasedAccounts;

		String CreditProvider = "";
		Object objDate = null;
		String bankingIndustryTypeClassification = "", CurrentBalance = "";
		Date date = null;
		String activeCreditfacility = "";
		String CurrentAssetClassification = "";
		String PaymentStatus = "";
		List<CreditType> creditTypesList = new ArrayList<CreditType>();
		List<CreditType> otherTypeList = new ArrayList<CreditType>();
		String assetClassifCd = "", daysPastDueCt = "", acctStatDetilCD = "";
		int assetCOde = 1;
		List<FundedList> fundedLists = new ArrayList<FundedList>();
		HashMap<String, Integer> hashMap = getCRWiseHashMap();
		String curreny = "";
		try {

			for (CurrencyBasedAccSummDataBO currencyBasedAccSummDataBO : currencyBasedAccSummDataBOList) {
				FundedList funded = new FundedList();
				curreny = (String) currencyBasedAccSummDataBO.get("Currency");
				funded.setCurrency(curreny);
				funded.setFunded((String) currencyBasedAccSummDataBO
						.get("Funded"));
				funded.setLongTerm((String) currencyBasedAccSummDataBO
						.get("LongTerm"));
				funded.setNonFunded((String) currencyBasedAccSummDataBO
						.get("NonFunded"));
				funded.setShortTerm((String) currencyBasedAccSummDataBO
						.get("ShortTerm"));
				funded.setSuitFiled((String) currencyBasedAccSummDataBO
						.get("SuitFiled"));
				funded.setWilful((String) currencyBasedAccSummDataBO
						.get("Wilful"));
				funded.setCheckDishonor("" + (Integer) hashMap.get(curreny));
				fundedLists.add(funded);
			}
			accSum.setFundedLists(fundedLists);
			if (isNotEmpty(bcaDataBOBorrowerList)) {
				for (BCADataBO bcaDataBO : bcaDataBOBorrowerList) {
					CreditProvider = (String) bcaDataBO.get("CreditProvider");
					CreditProvider = getStringValue(CreditProvider);

					bankingIndustryTypeClassification = (String) bcaDataBO
							.get(BANKING_INDUSTRY_TYPE_CLASSIFICATION);
					bankingIndustryTypeClassification = getStringValue(bankingIndustryTypeClassification);

					List<PaymentHistoryDetail> paymentHistoryDetails = (List<PaymentHistoryDetail>) ElFunctions
							.get(bcaDataBO, "listOfPaymentHistory");
					if (paymentHistoryDetails.size() == 0) {
						acctStatDetilCD = (String) bcaDataBO
								.get("accountStatusDetail");
						acctStatDetilCD = acctStatDetilCD.trim();
						assetClassifCd = (String) bcaDataBO
								.get("assetClassCd");
						daysPastDueCt = "";

					} else {
						PaymentHistoryDetail firstHistoryDetailObject = paymentHistoryDetails
							.get(0);
						AccountDetails accountDetails = (AccountDetails) ElFunctions
								.get(firstHistoryDetailObject, "accountDetails");
	
						assetClassifCd = (String) accountDetails
								.get("assetClassifCd");
						daysPastDueCt = ""
								+ (Short) accountDetails.get("daysPastDueCt");
						acctStatDetilCD = (String) accountDetails
								.get("acctStatDetilCD");
					}
					assetCOde = getAssetClassification(assetClassifCd,
							daysPastDueCt);
					objDate = bcaDataBO.get("SanctionDate");
					date = getSqlDate(objDate);

					CurrentBalance = (String) bcaDataBO.get("CurrentBalance");
					activeCreditfacility = (String) bcaDataBO
							.get("AccountStatus");
					if (activeCreditfacility.length()==0)
						activeCreditfacility=OPEN_ACCOUNT_STATUS;

					CurrentAssetClassification = (String) bcaDataBO
							.get("CurrentAssetClassification");
					CurrentAssetClassification = getStringValue(CurrentAssetClassification);

					PaymentStatus = (String) bcaDataBO.get("PaymentStatus");
					PaymentStatus = getStringValue(PaymentStatus);

					String accountNumber = (String) bcaDataBO
							.get("AccountNumber");

					bankingIndustryTypeClassification = getStringValue(bankingIndustryTypeClassification);
					boolean ownCompany = SAME_COMPANY_FLAG_Y.equals((String) bcaDataBO.get("ownCompanyFlag"));
					if (CreditProvider.equalsIgnoreCase(bureauMemberName)
							|| (modeIsPds && ownCompany) && !modeIsAdmDisclosure) {
						cfb_self++;
						TOAB_self += Long.parseLong(CurrentBalance);
						if (null == LAOD_self) {
							LAOD_self = new ArrayList<Date>();
						}
						LAOD_self.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_self++;
						}
					} else if (bankingIndustryTypeClassification
							.equalsIgnoreCase(PSU_BANK)) {
						cfb_PSU++;
						TOAB_PSU += Long.parseLong(CurrentBalance);
						if (null == LAOD_PSU) {
							LAOD_PSU = new ArrayList<Date>();
						}
						LAOD_PSU.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_PSU++;
						}
					} else if (bankingIndustryTypeClassification
							.equalsIgnoreCase(PVT_BANK)) {
						cfb_PVT++;
						TOAB_PVT += Long.parseLong(CurrentBalance);
						if (null == LAOD_PVT) {
							LAOD_PVT = new ArrayList<Date>();
						}
						LAOD_PVT.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_PVT++;
						}
					} else {
						cfb_NBFC++;
						TOAB_NBFC += Long.parseLong(CurrentBalance);
						if (null == LAOD_NBFC) {
							LAOD_NBFC = new ArrayList<Date>();
						}
						LAOD_NBFC.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_NBFC++;
						}
					}

					if (isDelinquent(assetCOde, acctStatDetilCD)) {
						if (CreditProvider.equalsIgnoreCase(bureauMemberName)
								|| (modeIsPds && ownCompany)&& !modeIsAdmDisclosure) {
							DCFAB_self++;
							DCFABB_self += Long.parseLong(CurrentBalance);
						} else if (bankingIndustryTypeClassification
								.equalsIgnoreCase(PSU_BANK)) {
							DCFAB_PSU++;
							DCFABB_PSU += Long.parseLong(CurrentBalance);
						} else if (bankingIndustryTypeClassification
								.equalsIgnoreCase(PVT_BANK)) {
							DCFAB_PVT++;
							DCFABB_PVT += Long.parseLong(CurrentBalance);
						} else {
							DCFAB_NBFC++;
							DCFABB_NBFC += Long.parseLong(CurrentBalance);
						}
					}
				}
			}

			if (isNotEmpty(bcaDataBOGuarantorList)) {
				for (BCADataBO bcaDataBO : bcaDataBOGuarantorList) {
					CreditProvider = (String) bcaDataBO.get("CreditProvider");
					bankingIndustryTypeClassification = (String) bcaDataBO
							.get(BANKING_INDUSTRY_TYPE_CLASSIFICATION);
					bankingIndustryTypeClassification = getStringValue(bankingIndustryTypeClassification);

					objDate = bcaDataBO.get("SanctionDate");
					date = getSqlDate(objDate);

					CurrentBalance = (String) bcaDataBO.get("CurrentBalance");
					CurrentBalance = getDecimalVelue(CurrentBalance);

					activeCreditfacility = (String) bcaDataBO
							.get("AccountStatus");
					activeCreditfacility = getStringValue(activeCreditfacility);

					CurrentAssetClassification = (String) bcaDataBO
							.get("CurrentAssetClassification");
					CurrentAssetClassification = getStringValue(CurrentAssetClassification);

					PaymentStatus = (String) bcaDataBO.get("PaymentStatus");
					PaymentStatus = getStringValue(PaymentStatus);

					String accountNumber = (String) bcaDataBO
							.get("AccountNumber");

					List<PaymentHistoryDetail> paymentHistoryDetails = (List<PaymentHistoryDetail>) ElFunctions
							.get(bcaDataBO, "listOfPaymentHistory");
					PaymentHistoryDetail firstHistoryDetailObject = paymentHistoryDetails
							.get(0);
					AccountDetails accountDetails = (AccountDetails) ElFunctions
							.get(firstHistoryDetailObject, "accountDetails");

					assetClassifCd = (String) accountDetails
							.get("assetClassifCd");
					daysPastDueCt = ""
							+ (Short) accountDetails.get("daysPastDueCt");
					acctStatDetilCD = (String) accountDetails
							.get("acctStatDetilCD");
					assetCOde = getAssetClassification(assetClassifCd,
							daysPastDueCt);

					boolean ownCompany = SAME_COMPANY_FLAG_Y.equals((String) bcaDataBO.get("ownCompanyFlag"));
					if (CreditProvider.equalsIgnoreCase(bureauMemberName)
							|| (modeIsPds && ownCompany)&& !modeIsAdmDisclosure) {
						cfg_self++;
						TOAG_self += Long.parseLong(CurrentBalance);
						if (null == LAOD_self) {
							LAOD_self = new ArrayList<Date>();
						}
						LAOD_self.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_self++;
						}
					} else if (bankingIndustryTypeClassification
							.equalsIgnoreCase(PSU_BANK)) {
						cfg_PSU++;
						TOAG_PSU += Long.parseLong(CurrentBalance);
						if (null == LAOD_PSU) {
							LAOD_PSU = new ArrayList<Date>();
						}
						LAOD_PSU.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_PSU++;
						}
					} else if (bankingIndustryTypeClassification
							.equalsIgnoreCase(PVT_BANK)) {
						cfg_PVT++;
						TOAG_PVT += Long.parseLong(CurrentBalance);
						if (null == LAOD_PVT) {
							LAOD_PVT = new ArrayList<Date>();
						}
						LAOD_PVT.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_PVT++;
						}
					} else {
						cfg_NBFC++;
						TOAG_NBFC += Long.parseLong(CurrentBalance);
						if (null == LAOD_NBFC) {
							LAOD_NBFC = new ArrayList<Date>();
						}
						LAOD_NBFC.add(date);
						if (activeCreditfacility.equalsIgnoreCase(OPEN_ACCOUNT_STATUS)) {
							acf_NBFC++;
						}
					}

					if (isDelinquent(assetCOde, acctStatDetilCD)) {
						if (CreditProvider.equalsIgnoreCase(bureauMemberName)
								|| (modeIsPds && ownCompany) && !modeIsAdmDisclosure) {
							DCFAG_self++;
							DCFAGB_self += Long.parseLong(CurrentBalance);
						} else if (bankingIndustryTypeClassification
								.equalsIgnoreCase(PSU_BANK)) {
							DCFAG_PSU++;
							DCFAGB_PSU += Long.parseLong(CurrentBalance);
						} else if (bankingIndustryTypeClassification
								.equalsIgnoreCase(PVT_BANK)) {
							DCFAG_PVT++;
							DCFAGB_PVT += Long.parseLong(CurrentBalance);
						} else {
							DCFAG_NBFC++;
							DCFAGB_NBFC += Long.parseLong(CurrentBalance);
						}
					}
				}
			}

			HashMap<String, CreditType> creditTypeMap = new HashMap<String, CreditType>();
			HashMap<String, CreditType> otherMap = new HashMap<String, CreditType>();
			String AccountType = "";

			long CurrentBalanceLong = 0;
			int classifiCode = 0;
			int noOfAcc = 0;
			long outStading = 0;
			int totalAcc = 0;
			long totalOutStang = 0;
			for (BCADataBO bcaDataBO : bcaDataBOBorrowerList) {
				CreditProvider = (String) bcaDataBO.get("CreditProvider");
				CreditProvider = getStringValue(CreditProvider);

				AccountType = (String) bcaDataBO.get("AccountType");
				AccountType = getStringValue(AccountType);

				CurrentAssetClassification = (String) bcaDataBO
						.get("CurrentAssetClassification");
				CurrentAssetClassification = getStringValue(CurrentAssetClassification);

				PaymentStatus = (String) bcaDataBO.get("PaymentStatus");
				PaymentStatus = getStringValue(PaymentStatus);

				CurrentBalanceLong = Long.parseLong((String) bcaDataBO
						.get("CurrentBalance"));

				String accountNumber = (String) bcaDataBO.get("AccountNumber");

				bankingIndustryTypeClassification = (String) bcaDataBO
						.get(BANKING_INDUSTRY_TYPE_CLASSIFICATION);
				bankingIndustryTypeClassification = getStringValue(bankingIndustryTypeClassification);

				List<PaymentHistoryDetail> paymentHistoryDetails = (List<PaymentHistoryDetail>) ElFunctions
						.get(bcaDataBO, "listOfPaymentHistory");
				if (paymentHistoryDetails.size() == 0) {
					acctStatDetilCD = (String) bcaDataBO
							.get("accountStatusDetail");
					acctStatDetilCD = acctStatDetilCD.trim();
					assetClassifCd = (String) bcaDataBO.get("assetClassCd");
					daysPastDueCt = "";

				} else {
					PaymentHistoryDetail firstHistoryDetailObject = paymentHistoryDetails
						.get(0);
					AccountDetails accountDetails = (AccountDetails) ElFunctions
							.get(firstHistoryDetailObject, "accountDetails");

					assetClassifCd = (String) accountDetails
							.get("assetClassifCd");
					daysPastDueCt = ""
							+ (Short) accountDetails.get("daysPastDueCt");
					acctStatDetilCD = (String) accountDetails
							.get("acctStatDetilCD");
				}

				classifiCode = getAssetClassification(assetClassifCd,
						daysPastDueCt);
				boolean ownCompany = SAME_COMPANY_FLAG_Y.equals((String) bcaDataBO.get("ownCompanyFlag"));
				if (CreditProvider.equalsIgnoreCase(bureauMemberName)
						|| (modeIsPds && ownCompany) && !modeIsAdmDisclosure) {

					if (!creditTypeMap.containsKey(AccountType)) {
						CreditType creditType = new CreditType();
						creditTypeMap.put(AccountType, creditType);
					}
					CreditType type = creditTypeMap.get(AccountType);
					if (classifiCode == 1) {
						noOfAcc = type.getCreditType0dpdacc();
						type.setCreditType0dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType0dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType0dpdoutstanding(""+outStading);
					} else if (classifiCode == 2) {
						noOfAcc = type.getCreditType30dpdacc();
						type.setCreditType30dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType30dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType30dpdoutstanding(""+outStading);
					} else if (classifiCode == 3) {
						noOfAcc = type.getCreditType60dpdacc();
						type.setCreditType60dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType60dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType60dpdoutstanding(""+outStading);
					} else if (classifiCode == 4) {
						noOfAcc = type.getCreditType90dpdacc();
						type.setCreditType90dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType90dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType90dpdoutstanding(""+outStading);
					} else if (classifiCode == 5) {
						noOfAcc = type.getCreditType365dpdacc();
						type.setCreditType365dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType365dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType365dpdoutstanding(""+outStading);
					} else if (classifiCode == 6) {
						noOfAcc = type.getCreditType730dpdacc();
						type.setCreditType730dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType730dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType730dpdoutstanding(""+outStading);
					} else if (classifiCode == 7) {
						noOfAcc = type.getCreditTypelossacc();
						type.setCreditTypelossacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditTypelossoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditTypelossoutstanding(""+outStading);
					} else if (classifiCode == 8) {
						noOfAcc = type.getCreditTypeSMAacc();
						type.setCreditTypeSMAacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditTypeSMAoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditTypeSMAoutstanding(""+outStading);
					}
					totalAcc = type.getCreditTypeTotalacc();
					type.setCreditTypeTotalacc(++totalAcc);
					totalOutStang = Long.parseLong(getDecimalVelue(type.getCreditTypeTotaloutstanding()));
					totalOutStang += CurrentBalanceLong;
					type.setCreditTypeTotaloutstanding(""+totalOutStang);
					creditTypeMap.put(AccountType, type);

				} else {
					if (!otherMap.containsKey(AccountType)) {
						CreditType creditType = new CreditType();
						otherMap.put(AccountType, creditType);
					}
					CreditType type = otherMap.get(AccountType);
					if (classifiCode == 1) {
						noOfAcc = type.getCreditType0dpdacc();
						type.setCreditType0dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType0dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType0dpdoutstanding(""+outStading);
					} else if (classifiCode == 2) {
						noOfAcc = type.getCreditType30dpdacc();
						type.setCreditType30dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType30dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType30dpdoutstanding(""+outStading);
					} else if (classifiCode == 3) {
						noOfAcc = type.getCreditType60dpdacc();
						type.setCreditType60dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType60dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType60dpdoutstanding(""+outStading);
					} else if (classifiCode == 4) {
						noOfAcc = type.getCreditType90dpdacc();
						type.setCreditType90dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType90dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType90dpdoutstanding(""+outStading);
					} else if (classifiCode == 5) {
						noOfAcc = type.getCreditType365dpdacc();
						type.setCreditType365dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType365dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType365dpdoutstanding(""+outStading);
					} else if (classifiCode == 6) {
						noOfAcc = type.getCreditType730dpdacc();
						type.setCreditType730dpdacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditType730dpdoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditType730dpdoutstanding(""+outStading);
					} else if (classifiCode == 7) {
						noOfAcc = type.getCreditTypelossacc();
						type.setCreditTypelossacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditTypelossoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditTypelossoutstanding(""+outStading);
					} else if (classifiCode == 8) {
						noOfAcc = type.getCreditTypeSMAacc();
						type.setCreditTypeSMAacc(++noOfAcc);
						outStading = Long.parseLong(getDecimalVelue(type.getCreditTypeSMAoutstanding()));
						outStading += CurrentBalanceLong;
						type.setCreditTypeSMAoutstanding(""+outStading);
					}

					totalAcc = type.getCreditTypeTotalacc();
					type.setCreditTypeTotalacc(++totalAcc);

					totalOutStang = Long.parseLong(getDecimalVelue(type.getCreditTypeTotaloutstanding()));
					totalOutStang += CurrentBalanceLong;
					type.setCreditTypeTotaloutstanding(""+totalOutStang);

					otherMap.put(AccountType, type);
				}
			}

			CreditType cType = null;
			for (String key : creditTypeMap.keySet()) {
				cType = creditTypeMap.get(key);
				cType.setCreditType(key);
				creditTypesList.add(cType);
			}
			if (isNotEmpty(creditTypesList)) {
				cType = getCreditTypeObj(creditTypesList);
				cType.setCreditType("Grand Total");
				creditTypesList.add(cType);
			}
			for (String key : otherMap.keySet()) {
				cType = otherMap.get(key);
				cType.setCreditType(key);
				otherTypeList.add(cType);
			}
			if (isNotEmpty(otherTypeList)) {
				cType = getCreditTypeObj(otherTypeList);
				cType.setCreditType("Grand Total");
				otherTypeList.add(cType);
			}
			return accSum;
		} catch (NextGenBusinessObjectException exception) {
			logger.error("::" + exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			cfb_Non_Self = cfb_PSU + cfb_PVT + cfb_NBFC;
			cfg_Non_Self = cfg_PSU + cfg_PVT + cfg_NBFC;
			acf_Non_Self = acf_PSU + acf_PVT + acf_NBFC;
			TOAB_Non_Self = TOAB_PSU + TOAB_PVT + TOAB_NBFC;
			TOAG_Non_Self = TOAG_PSU + TOAG_PVT + TOAG_NBFC;

			LAOD_Non_Self.addAll(LAOD_PSU);
			LAOD_Non_Self.addAll(LAOD_PVT);
			LAOD_Non_Self.addAll(LAOD_NBFC);

			DCFAB_Non_Self = DCFAB_PSU + DCFAB_PVT + DCFAB_NBFC;
			DCFABB_Non_Self = DCFABB_PSU + DCFABB_PVT + DCFABB_NBFC;

			DCFAG_Non_Self = DCFAG_PSU + DCFAG_PVT + DCFAG_NBFC;
			DCFAGB_Non_Self = DCFAGB_PSU + DCFAGB_PVT + DCFAGB_NBFC;

			cfb_Grand = cfb_self + cfb_Non_Self;
			cfg_Grand = cfg_self + cfg_Non_Self;
			acf_Grand = acf_self + acf_Non_Self;
			TOAB_Grand = TOAB_self + TOAB_Non_Self;
			TOAG_Grand = TOAG_self + TOAG_Non_Self;

			if (null == LAOD_Grand) {
				LAOD_Grand = new ArrayList<Date>();
			}

			LAOD_Grand.addAll(LAOD_self);
			LAOD_Grand.addAll(LAOD_Non_Self);

			DCFAB_Grand = DCFAB_self + DCFAB_Non_Self;
			DCFABB_Grand = DCFABB_self + DCFABB_Non_Self;

			DCFAG_Grand = DCFAG_self + DCFAG_Non_Self;
			DCFAGB_Grand = DCFAGB_self + DCFAGB_Non_Self;

			accSum.setNameOfInstitution(bureauMemberName);
			accSum.setTCFAB("" + cfb_self);
			accSum.setTCFAG("" + cfg_self);
			accSum.setACF("" + acf_self);
			accSum.setTOAB(getFormattedAmt("" + TOAB_self));
			accSum.setTOAG(getFormattedAmt("" + TOAG_self));
			date = LAOD_self.size() > 0 ? Collections.max(LAOD_self) : null;
			accSum
					.setLAOP(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			accSum.setDCFOBAB("" + DCFAB_self);
			accSum.setDCFOBABB(getFormattedAmt("" + DCFABB_self));
			accSum.setDCFOBAG("" + DCFAG_self);
			accSum.setDCFOBAGB(getFormattedAmt("" + DCFAGB_self));

			accSum.setPSUTCFAB("" + cfb_PSU);
			accSum.setPSUTCFAG("" + cfg_PSU);
			accSum.setPSUACF("" + acf_PSU);
			accSum.setPSUTOAB(getFormattedAmt("" + TOAB_PSU));
			accSum.setPSUTOAG(getFormattedAmt("" + TOAG_PSU));
			date = LAOD_PSU.size() > 0 ? Collections.max(LAOD_PSU) : null;
			accSum
					.setPSULAOP(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			accSum.setPSUDCFOBAB("" + DCFAB_PSU);
			accSum.setPSUDCFOBABB(getFormattedAmt("" + DCFABB_PSU));
			accSum.setPSUDCFOBAG("" + DCFAG_PSU);
			accSum.setPSUDCFOBAGB(getFormattedAmt("" + DCFAGB_PSU));

			accSum.setPVTTCFAB("" + cfb_PVT);
			accSum.setPVTTCFAG("" + cfg_PVT);
			accSum.setPVTACF("" + acf_PVT);
			accSum.setPVTTOAB(getFormattedAmt("" + TOAB_PVT));
			accSum.setPVTTOAG(getFormattedAmt("" + TOAG_PVT));
			date = LAOD_PVT.size() > 0 ? Collections.max(LAOD_PVT) : null;
			accSum
					.setPVTLAOP(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			accSum.setPVTDCFOBAB("" + DCFAB_PVT);
			accSum.setPVTDCFOBABB(getFormattedAmt("" + DCFABB_PVT));
			accSum.setPVTDCFOBAG("" + DCFAG_PVT);
			accSum.setPVTDCFOBAGB(getFormattedAmt("" + DCFAGB_PVT));

			accSum.setNBFCTCFAB("" + cfb_NBFC);
			accSum.setNBFCTCFAG("" + cfg_NBFC);
			accSum.setNBFCACF("" + acf_NBFC);
			accSum.setNBFCTOAB(getFormattedAmt("" + TOAB_NBFC));
			accSum.setNBFCTOAG(getFormattedAmt("" + TOAG_NBFC));
			date = LAOD_NBFC.size() > 0 ? Collections.max(LAOD_NBFC) : null;
			accSum
					.setNBFCLAOP(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			accSum.setNBFCDCFOBAB("" + DCFAB_NBFC);
			accSum.setNBFCDCFOBABB(getFormattedAmt("" + DCFABB_NBFC));
			accSum.setNBFCDCFOBAG("" + DCFAG_NBFC);
			accSum.setNBFCDCFOBAGB(getFormattedAmt("" + DCFAGB_NBFC));
			accSum.setNSTTCFAB("" + cfb_Non_Self);
			accSum.setNSTTCFAG("" + cfg_Non_Self);
			accSum.setNSTACF("" + acf_Non_Self);
			accSum.setNSTTOAB(getFormattedAmt("" + TOAB_Non_Self));
			accSum.setNSTTOAG(getFormattedAmt("" + TOAG_Non_Self));
			date = LAOD_Non_Self.size() > 0 ? Collections.max(LAOD_Non_Self)
					: null;
			accSum
					.setNSTLAOP(getStringValue(convertDateToDDMMYYYWithSlashes(date)));
			accSum.setNSTDCFOBAB("" + DCFAB_Non_Self);
			accSum.setNSTDCFOBABB(getFormattedAmt("" + DCFABB_Non_Self));
			accSum.setNSTDCFOBAG("" + DCFAG_Non_Self);
			accSum.setNSTDCFOBAGB(getFormattedAmt("" + DCFAGB_Non_Self));

			accSum.setGTTCFAB("" + cfb_Grand);
			accSum.setGTTCFAG("" + cfg_Grand);
			accSum.setGTACF("" + acf_Grand);
			accSum.setGTTOAB(getFormattedAmt("" + TOAB_Grand));
			accSum.setGTTOAG(getFormattedAmt("" + TOAG_Grand));
			date = LAOD_Grand.size() > 0 ? Collections.max(LAOD_Grand) : null;
			accSum.setGTLAOP(getStringValue("-"));
			accSum.setGTDCFOBAB("" + DCFAB_Grand);
			accSum.setGTDCFOBABB(getFormattedAmt("" + DCFABB_Grand));
			accSum.setGTDCFOBAG("" + DCFAG_Grand);
			accSum.setGTDCFOBAGB(getFormattedAmt("" + DCFAGB_Grand));

			accSum.setTypes(creditTypesList);
			accSum.setOthers(otherTypeList);

		}
		return accSum;
	}
	public SalesInvoice getInvoice(){
		SalesInvoice salesInvoice = new SalesInvoice();
		
		prop = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(INVOICE);
		
		try {
			prop.load(inputStream);
			salesInvoice.setCompany_name(getStringValue(inquiry.getInquiryData().getCompanyName()));
			List<AddressInputData> addressInputData = inquiry.getInquiryData().getAddressDetails();
			if (isNotEmpty(addressInputData)) {
				AddressInputData inquiryaddress = addressInputData.get(0);
				salesInvoice.setAddress(inquiryaddress.getAddressLine1()
						+ " "+ inquiryaddress.getAddressLine2()
						+ " "+ inquiryaddress.getAddressLine3());
				salesInvoice.setCity(inquiryaddress.getCity());
				salesInvoice.setPincode(inquiryaddress.getPincode());
			}
			Calendar calobj = Calendar.getInstance();
			Format sdf = new SimpleDateFormat("dd/MM/yyyy");
			salesInvoice.setDate(sdf.format(calobj.getTime()));
			salesInvoice.setRegards(prop.getProperty("invoice.text"));
			
			salesInvoice.setPan(prop.getProperty("invoice.pan.number.value"));
			salesInvoice.setServiceTaxNumber(prop.getProperty("invoice.service.tax.number.value"));
			salesInvoice.setInvoicenumber((String)request.getSession().getAttribute("invoiceNumber"));
			
			salesInvoice.setReport_fee(prop.getProperty("invoice.fee.value"));
			salesInvoice.setSubTotalA(prop.getProperty("invoice.fee.value"));
			
			String deliveryCharges= prop.getProperty("invoice.delivery.charges.value");
			salesInvoice.setDeliveryCharges(deliveryCharges);
			
			String serviceTex = prop.getProperty("invoice.servicetax.value");
			salesInvoice.setServiceTax(serviceTex);
			
			String educationFee = prop.getProperty("invoice.educationcess.value");
			salesInvoice.setEducationCees(educationFee);
			
			String higherFee = prop.getProperty("invoice.education.value");
			salesInvoice.setHigherEduCees(higherFee);
			double subTotal = Double.parseDouble(deliveryCharges) + Double.parseDouble(serviceTex) + Double.parseDouble(educationFee) + Double.parseDouble(higherFee);
			salesInvoice.setSubTotalB(""+subTotal);
			
			double total = subTotal + Double.parseDouble(prop.getProperty("invoice.fee.value"));
			salesInvoice.setTotal(""+total);

		} catch (IOException IO) {
			logger.info("getInvoice:"+IO.getMessage(),IO);
			IO.printStackTrace();
		}
		return salesInvoice;
	}

	private String getAddressType(int addressCode) {
		if (addressCode == 1 || addressCode == 01) {
			return "Current Mailing Address ";
		} else if (addressCode == 2 || addressCode == 02) {
			return "Current Residence Address";
		} else if (addressCode == 3 || addressCode == 03) {
			return "Previous Residence Address";
		} else if (addressCode == 4 || addressCode == 04) {
			return "Branch Location";
		} else if (addressCode == 5 || addressCode == 05) {
			return "Company Headquarters Location";
		} else if (addressCode == 6 || addressCode == 02) {
			return "Head Branch Location";
		} else if (addressCode == 7) {
			return "Operating Unit Location";
		} else if (addressCode == 8) {
			return "Parent Company Headquarters Location";
		} else if (addressCode == 9) {
			return "Peer Location";
		} else if (addressCode == 10) {
			return "Subsidiary Location";
		} else if (addressCode == 11) {
			return "Highest Parent Location";
		} else if (addressCode == 12) {
			return "Highest Parent Location  ";
		} else if (addressCode == 13) {
			return "Office Address";
		} else if (addressCode == 14) {
			return "Registered Legal Office Address";
		} else if (addressCode == 15) {
			return "Plant/Factory Address";
		} else if (addressCode == 16) {
			return "Warehouse Address";
		} else if (addressCode == 17) {
			return "Branch/Regional Office Address";
		} else if (addressCode == 18) {
			return "Other than Registered Office";
		} else {
			return "Other";
		}
	}

	public static String addBig(ArrayList<String> list) {
		BigInteger bigInteger = new BigInteger("0");
		for (String str : list) {
			bigInteger = bigInteger.add(new BigInteger(str));
		}
		return bigInteger.toString();
	}

	public static String mulBig(ArrayList<String> list) {
		BigInteger bigInteger = new BigInteger("1");
		for (String str : list) {
			bigInteger = bigInteger.multiply(new BigInteger(str));
		}
		return bigInteger.toString();
	}

	public static String subBig(ArrayList<String> list) {
		BigInteger bigInteger;
		if (list == null || list.size() == 0) {
			return "0";
		} else if (list.size() == 1) {
			return list.get(0).toString();
		} else {
			bigInteger = new BigInteger("0");
		}

		for (String str : list) {
			bigInteger = bigInteger.subtract(new BigInteger(str));
		}
		return bigInteger.toString();
	}

	private static List<String> activeAccountList;

	private static void createActiveAccountList() {
		activeAccountList = new ArrayList<String>();
		activeAccountList.add("21");
		activeAccountList.add("24");
		activeAccountList.add("27");
		activeAccountList.add("28");
		activeAccountList.add("29");
		// Treat all empty Account Status Detail Code field as Active; as not other identifying information has been specified - C02809A
		activeAccountList.add("");
	}

	private HashMap<String, Integer> getCRWiseHashMap() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		HashMap<String, List<BCADataBO>> hashMapBcaDataBO = new HashMap<String, List<BCADataBO>>();
		List<BCADataBO> borrowerBasedAccounts = listOfBorrowerBasedAccounts;
		String currency = "";
		List<BCADataBO> bcaList = null;
		try {
			for (BCADataBO bcaDataBO : borrowerBasedAccounts) {
				currency = (String) bcaDataBO.get("Currency");
				if (hashMapBcaDataBO.containsKey(currency)) {
					bcaList = hashMapBcaDataBO.get(currency);
					bcaList.add(bcaDataBO);
					hashMapBcaDataBO.put(currency, bcaList);
				} else {
					bcaList = new ArrayList<BCADataBO>();
					bcaList.add(bcaDataBO);
					hashMapBcaDataBO.put(currency, bcaList);
				}
			}
			for (String key : hashMapBcaDataBO.keySet()) {
				hashMap.put(key, 0);
				hashMap.put(key, getCheckDishonourCount(hashMapBcaDataBO
						.get(key)));
			}

		} catch (NextGenBusinessObjectException ngex) {
			logger.error("::getCRWiseHashMap ::"+ngex.getMessage(),ngex);
			ngex.printStackTrace();
		}
		return hashMap;
	}

	private CreditType getCreditTypeObj(List<CreditType> list) {
		CreditType totalCtype = new CreditType();
		for (CreditType cType : list) {
			totalCtype.setCreditType0dpdacc(totalCtype.getCreditType0dpdacc()
					+ cType.getCreditType0dpdacc());
			totalCtype.setCreditType30dpdacc(totalCtype.getCreditType30dpdacc()
					+ cType.getCreditType30dpdacc());
			totalCtype.setCreditType60dpdacc(totalCtype.getCreditType60dpdacc()
					+ cType.getCreditType60dpdacc());
			totalCtype.setCreditType90dpdacc(totalCtype.getCreditType90dpdacc()
					+ cType.getCreditType90dpdacc());
			totalCtype.setCreditType365dpdacc(totalCtype
					.getCreditType365dpdacc()
					+ cType.getCreditType365dpdacc());
			totalCtype.setCreditType730dpdacc(totalCtype
					.getCreditType730dpdacc()
					+ cType.getCreditType730dpdacc());
			totalCtype.setCreditTypelossacc(totalCtype.getCreditTypelossacc()
					+ cType.getCreditTypelossacc());
			totalCtype.setCreditTypeSMAacc(totalCtype.getCreditTypeSMAacc()
					+ cType.getCreditTypeSMAacc());
			totalCtype.setCreditTypeTotalacc(totalCtype.getCreditTypeTotalacc()
					+ cType.getCreditTypeTotalacc());

			totalCtype.setCreditType0dpdoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditType0dpdoutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditType0dpdoutstanding()))));
			cType.setCreditType0dpdoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditType0dpdoutstanding())));
			
			totalCtype.setCreditType30dpdoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditType30dpdoutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditType30dpdoutstanding()))));
			cType.setCreditType30dpdoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditType30dpdoutstanding())));
			
			totalCtype.setCreditType60dpdoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditType60dpdoutstanding())) + Long.parseLong(getDecimalVelue(cType.getCreditType60dpdoutstanding()))));
			cType.setCreditType60dpdoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditType60dpdoutstanding())));
			
			totalCtype.setCreditType90dpdoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditType90dpdoutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditType90dpdoutstanding()))));
			cType.setCreditType90dpdoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditType90dpdoutstanding())));
			
			totalCtype.setCreditType365dpdoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditType365dpdoutstanding())) + Long.parseLong(getDecimalVelue(cType.getCreditType365dpdoutstanding()))));
			cType.setCreditType365dpdoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditType365dpdoutstanding())));
			
			totalCtype.setCreditType730dpdoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditType730dpdoutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditType730dpdoutstanding()))));
			cType.setCreditType730dpdoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditType730dpdoutstanding())));
			
			totalCtype.setCreditTypelossoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditTypelossoutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditTypelossoutstanding()))));
			cType.setCreditTypelossoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditTypelossoutstanding())));
			
			totalCtype.setCreditTypeSMAoutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditTypeSMAoutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditTypeSMAoutstanding()))));
			cType.setCreditTypeSMAoutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditTypeSMAoutstanding())));
			
			totalCtype.setCreditTypeTotaloutstanding(""+(Long.parseLong(getDecimalVelue(totalCtype.getCreditTypeTotaloutstanding()))+ Long.parseLong(getDecimalVelue(cType.getCreditTypeTotaloutstanding()))));
			cType.setCreditTypeTotaloutstanding(getFormattedAmt(getDecimalVelue(cType.getCreditTypeTotaloutstanding())));
		}
		totalCtype.setCreditType0dpdoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditType0dpdoutstanding())));
		totalCtype.setCreditType30dpdoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditType30dpdoutstanding())));
		totalCtype.setCreditType60dpdoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditType60dpdoutstanding())));
		totalCtype.setCreditType90dpdoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditType90dpdoutstanding())));
		totalCtype.setCreditType365dpdoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditType365dpdoutstanding())));
		totalCtype.setCreditType730dpdoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditType730dpdoutstanding())));
		totalCtype.setCreditTypelossoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditTypelossoutstanding())));
		totalCtype.setCreditTypeSMAoutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditTypeSMAoutstanding())));
		totalCtype.setCreditTypeTotaloutstanding(getFormattedAmt(getDecimalVelue(totalCtype.getCreditTypeTotaloutstanding())));
		
		
		return totalCtype;
	}

	@SuppressWarnings("unchecked")
	private List<ReportSummaryDataBO> getReportSummaryData() {
		List<ReportSummaryBO> reportSummaryBOList = null;
		List<ReportSummaryDataBO> reportSummaryDataBOList = new ArrayList<ReportSummaryDataBO>();
		try {
			if (!(ElFunctions.get(reportData, "reportSummary") instanceof String)) {
				reportSummaryBOList = (List<ReportSummaryBO>) ElFunctions.get(
						reportData, "reportSummary");
				if (isNotEmpty(reportSummaryBOList)) {
					for (ReportSummaryBO reportSummaryBO : reportSummaryBOList) {
						if (reportSummaryBO != null
								&& !(ElFunctions.get(reportSummaryBO,
										"reportSummaryInfo") instanceof String)) {
							if (isNotEmpty((List<ReportSummaryDataBO>) ElFunctions
									.get(reportSummaryBO, "reportSummaryInfo"))) {
								reportSummaryDataBOList
										.addAll((List<ReportSummaryDataBO>) ElFunctions
												.get(reportSummaryBO,
														"reportSummaryInfo"));
							}

						}
					}

				}
			}
		} catch (NextGenBusinessObjectException exception) {
			logger.error("getCreditAccount::" + exception.getMessage());
			exception.printStackTrace();
			return reportSummaryDataBOList;
		}
		return reportSummaryDataBOList;
	}

	private static int getAssetClassification(String assetClassifCd,
			String daysPastDueCt) {
		int daysPastDueCtNum = 0;

		assetClassifCd = assetClassifCd.trim();
		daysPastDueCt = daysPastDueCt.trim();

		if (!("".equalsIgnoreCase(assetClassifCd)) && null != assetClassifCd) {
			if (assetClassifCd.equalsIgnoreCase("s")) {
				return 1; // Standard
			} else if (assetClassifCd.equalsIgnoreCase("b")) {
				return 5; // Substandard
			} else if (assetClassifCd.equalsIgnoreCase("d")
					|| assetClassifCd.equalsIgnoreCase("d1")
					|| assetClassifCd.equalsIgnoreCase("d2")
					|| assetClassifCd.equalsIgnoreCase("d3")) {
				return 6; // Substandard
			} else if (assetClassifCd.equalsIgnoreCase("m")
					|| assetClassifCd.equalsIgnoreCase("m0")
					|| assetClassifCd.equalsIgnoreCase("m1")
					|| assetClassifCd.equalsIgnoreCase("m2")) {
				return 8; // SMA
			} else if (assetClassifCd.equalsIgnoreCase("l")) {
				return 7; // Loss
			} else {
				return 7;
			}
		} else if (!("".equalsIgnoreCase(daysPastDueCt))
				&& null != daysPastDueCt) {
			daysPastDueCtNum = Integer.parseInt(daysPastDueCt);
			if (daysPastDueCtNum == 0) {
				return 1;
			} else if (daysPastDueCtNum >= 1 && daysPastDueCtNum <= 30) {
				return 2;
			} else if (daysPastDueCtNum >= 31 && daysPastDueCtNum <= 60) {
				return 3;
			} else if (daysPastDueCtNum >= 61 && daysPastDueCtNum <= 90) {
				return 4;
			} else if (daysPastDueCtNum >= 91 && daysPastDueCtNum <= 365) {
				return 5;
			} else if (daysPastDueCtNum >= 366 && daysPastDueCtNum <= 730) {
				return 6;
			} else {
				return 7;
			}
		}
		return 7;
	}

	private static boolean isDelinquent(int assitClassCode,
			String acctStatDetilCD) {
		acctStatDetilCD = acctStatDetilCD.trim();
		if (activeAccountList.contains(acctStatDetilCD)) {
			if ((assitClassCode > 4)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private Date getSqlDate(Object objDate) {
		Date date = null;
		if (objDate instanceof String) {
			return null;
		}
		if (objDate instanceof java.util.Date) {
			java.util.Date javaDate = (java.util.Date) objDate;
			date = new Date(javaDate.getTime());
		} else if (objDate instanceof Date) {
			date = (Date) objDate;
		} else {
			return null;
		}
		return date;
	}
	
	
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

	public static String getFormattedAmt(Object objStr) {
		String amtStr ="";
		if (objStr instanceof Long){
			amtStr = Long.toString((Long)objStr);
		} else{
			amtStr = (String) objStr;
		}
		
		if (StringUtils.isNotBlank(amtStr) && isNumeric(amtStr)) {
			String[] splits = null;
			String decimalPart = "";
			boolean contains = StringUtils.contains(amtStr, ".");
			if (contains) {
				splits = StringUtils.split(amtStr, ".");

				amtStr = splits[0];
				decimalPart = splits[1];
			}

			int length = StringUtils.length(amtStr);

			amtStr = StringUtils.reverse(amtStr);
			char[] charArray = amtStr.toCharArray();
			StringBuffer buffer = new StringBuffer();
			int cnt = 0;

			boolean isFirstChuckDone = false;
			int chunkLength = 3;
			for (int i = 0; i < charArray.length; i++) {
				buffer.append(charArray[i]);
				cnt += 1;
				if (cnt == chunkLength && i < (length - 1)) {
					buffer.append(",");

					if (!isFirstChuckDone) {
						isFirstChuckDone = true;
						chunkLength = 2;
					}

					cnt = 0;
				}
			}

			amtStr = buffer.toString();
			if (StringUtils.isNotBlank(amtStr)) {
				amtStr = StringUtils.reverse(amtStr);
				if (contains) {
					amtStr = amtStr.concat(".");
					amtStr = amtStr.concat(decimalPart);
				}
			}
			return amtStr;
		}

		if (StringUtils.isBlank(amtStr)) {
			amtStr = "-";
		}

		return amtStr;
	}
	
	private static Date reduceDateByOneMonth(Date sqldate) {
		java.util.Date javaDate = null;
		Calendar calendar = Calendar.getInstance();
		if (null == sqldate) {
			javaDate = calendar.getTime();
		} else {
			javaDate = new Date(sqldate.getTime());
		}

		calendar.setTime(javaDate);
		calendar.add(Calendar.MONTH, -1);
		javaDate = calendar.getTime();
		sqldate = new Date(javaDate.getTime());
		return sqldate;
	}

*/}