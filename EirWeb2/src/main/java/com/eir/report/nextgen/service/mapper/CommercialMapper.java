package com.eir.report.nextgen.service.mapper;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.eir.commercial.domains.AccountSummary;
import com.eir.commercial.domains.CommercialReportDetails;
import com.eir.commercial.domains.CommonUtilityService;
import com.eir.commercial.domains.CompanyDetails;
import com.eir.commercial.domains.CreditFacilityBorowerDetails;
import com.eir.commercial.domains.CreditFacilityDetails;
import com.eir.commercial.domains.CreditFacilityDetailsAsGuarentor;
import com.eir.commercial.domains.CreditFacilityGuarentorDetails;
import com.eir.commercial.domains.CurrentApplication;
import com.eir.commercial.domains.EnquiryDetails;
import com.eir.commercial.domains.FundedList;
import com.eir.commercial.domains.LocationDetails;
import com.eir.commercial.domains.MainCreditFacility;
import com.eir.commercial.domains.RelationshipDetails;
import com.eir.commercial.domains.ReportSummary;
import com.eir.commercial.domains.Score;
import com.eir.commercial.domains.SuitFiledDetails;
import com.eir.commercial.domains.VMReportHeader;
import com.experian.nextgen.ind.model.commercial.uofpojo.Acctypinfo;
import com.experian.nextgen.ind.model.commercial.uofpojo.BidCards;
import com.experian.nextgen.ind.model.commercial.uofpojo.Bidaddrs;
import com.experian.nextgen.ind.model.commercial.uofpojo.Borrower;
import com.experian.nextgen.ind.model.commercial.uofpojo.BusHistory;
import com.experian.nextgen.ind.model.commercial.uofpojo.Bussfirm;
import com.experian.nextgen.ind.model.commercial.uofpojo.Commcred;
import com.experian.nextgen.ind.model.commercial.uofpojo.Credtype;
import com.experian.nextgen.ind.model.commercial.uofpojo.Currcycnct;
import com.experian.nextgen.ind.model.commercial.uofpojo.Enqrhist;
import com.experian.nextgen.ind.model.commercial.uofpojo.Guarantor;
import com.experian.nextgen.ind.model.commercial.uofpojo.NgInqAddr;
import com.experian.nextgen.ind.model.commercial.uofpojo.Relations;
import com.experian.nextgen.ind.model.commercial.uofpojo.ResponseInfo;







public class CommercialMapper {

	public static ResponseInfo responseInfo = null;
	public CommercialReportDetails mapData(ResponseInfo responseInfo1) throws IOException
	{
		responseInfo=responseInfo1;
			//responseInfo = ExperianHttpDirectClient.getCIRReport();
		/*VelocityEngine velocityEngine = new VelocityEngine();
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "file");
		properties
				.setProperty("file.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		velocityEngine.init(properties);
		Template template = velocityEngine
				.getTemplate("velocityTemplate/MainCommercial.vm");*/
			CommercialReportDetails reportDetails = new CommercialReportDetails();
			reportDetails.setApplication(getCurrentApplication());
			reportDetails.setScore(getScore());
			reportDetails.setCompanyDetails(getCompanyDetails());
			reportDetails.setReportSummary(getReportSummary());
			reportDetails.setAccountSummary(getAccountSummaryFields());
			reportDetails.setLocationDetails(getLocationDetails());
			reportDetails.setRelationshipDetails(getRelationshipDetails());
			reportDetails.setCreditFacilities(getMainCreditFacility());
			reportDetails.setSuitFiledDetails(getSuitFiledDetails());
			reportDetails.setFacilityDetailsAsGuarentor(getCreditFacilityDetailsAsGuarentor());
			reportDetails.setEnquiryDetails(getEnquiryDetails());
			reportDetails.setMatchFound(true);
			reportDetails.setReportIdentifier(responseInfo.getBusinessResponse().getNGINQUIRY().getInqProductName());
			reportDetails.setReportHeader(getHeaderDetails());
			
			/*VelocityContext context = new VelocityContext();
			context.put("reportDetails", reportDetails);
			context.put("responseInfo", responseInfo);
			context.put("StringUtils", StringUtils.class);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/yyyy");
			context.put("sdf", sdf);
			context.put("sdf2", sdf2);

			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			String htmlOutput = writer.toString();

			//objectMappingForRating.clear();
			return htmlOutput;*/
			
			return reportDetails;
			
	}
	
	

	private VMReportHeader getHeaderDetails() {
		// TODO Auto-generated method stub
		VMReportHeader reportHeader = new VMReportHeader();
		reportHeader.setExperianReferenceNumber(responseInfo.getBusinessResponse().getNGINQUIRY().getInqRefNum());
		reportHeader.setMemberName(responseInfo.getBusinessResponse().getNGINQUIRY().getInqBureauMemberName());
		
		return reportHeader;
	}



	private CurrentApplication getCurrentApplication()
	{
		CurrentApplication currentApplication = new CurrentApplication();
		currentApplication.setInqCompanyName(responseInfo.getBusinessResponse().getNGINQUIRY().getInqCompanyName());
		currentApplication.setEnquiryPurposeCd(responseInfo.getBusinessResponse().getNGINQUIRY().getInqPurposeCd());
		currentApplication.setEnquiryAmount(responseInfo.getBusinessResponse().getNGINQUIRY().getInqAmt());
		currentApplication.setInqPan(responseInfo.getBusinessResponse().getNGINQUIRY().getInqPAN());
		currentApplication.setLoanAccNo(responseInfo.getBusinessResponse().getNGINQUIRY().getInqCompanyBankAccNumber());
	
		NgInqAddr ngInqAddr = responseInfo.getBusinessResponse().getNGINQUIRY().getNgInqAddr().get(0);
		currentApplication.setInqCompanyAddress(ngInqAddr.getInqCompanyAddress());
		currentApplication.setInqCompanyPinCode(ngInqAddr.getInqCompanyPINCode());
		currentApplication.setInqCompanyCity(ngInqAddr.getInqCompanyCity());
		
		/*NgInqTel ngInqTel = responseInfo.getBusinessResponse().getNGINQUIRY().getNgInqTel().get(0);
		currentApplication.setTelephone(ngInqTel.getPhoneNumber());*/

		return currentApplication;
	}
	
	public Score getScore() 
	{
		Score score = new Score();
		score.setIsscore(0);
		score.setScore(0);
		return score;
	}
	
	public CompanyDetails getCompanyDetails() {
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setBusNm(responseInfo.getBusinessResponse().getBUSINESS().getBusinessName());
		companyDetails.setCompanyShortName(responseInfo.getBusinessResponse().getBUSINESS().getBusinessShortName());
		companyDetails.setLegalConstitution(responseInfo.getBusinessResponse().getBUSINESS().getLegalDescription());
		companyDetails.setIndusCd(responseInfo.getBusinessResponse().getBUSINESS().getIndustryType());
		Bidaddrs address = responseInfo.getBusinessResponse().getBUSINESS().getBidaddrs().get(0);
		String addr = address.getAddressL1() + "," + address.getAddressL2() + "," + address.getAddressL3() + ","
					+ address.getCity() + "," + address.getPinCode() + "," + address.getState();
		companyDetails.setBusAddress(addr);
		if(responseInfo.getBusinessResponse().getBUSINESS().getBidphone() != null 
				&& !responseInfo.getBusinessResponse().getBUSINESS().getBidphone().isEmpty())
		{
			companyDetails.setBusinessTelephone(responseInfo.getBusinessResponse().getBUSINESS().getBidphone().get(0).getPhoneNumber());	
		}
		
		List<BidCards> bidCards = responseInfo.getBusinessResponse().getBUSINESS().getBidCards();
		for(BidCards bidCard: bidCards)
		{
			if(bidCard.getIdNumberType().equals("10"))
			{
				companyDetails.setPanNumber(bidCard.getIdNumber());
			}
			if(bidCard.getIdNumberType().equals("13"))
			{
				companyDetails.setCin(bidCard.getIdNumber());
			}
			if(bidCard.getIdNumberType().equals("15"))
			{
				companyDetails.setServiceTaxNumber(bidCard.getIdNumber());
			}
		}
		
		if(responseInfo.getBusinessResponse().getBUSINESS().getBussfirm() != null 
				&& !responseInfo.getBusinessResponse().getBUSINESS().getBussfirm().isEmpty())
		{
			Bussfirm bussfirm = responseInfo.getBusinessResponse().getBUSINESS().getBussfirm().get(0);
			companyDetails.setBusRegNb4In(bussfirm.getRegistrationNumber());
		    companyDetails.setBusRegDt(convertDate(bussfirm.getRegistrationDate()));
			companyDetails.setBusRegCityNum(bussfirm.getRegistrationCity());
			companyDetails.setBusRegProvinceCd4In(bussfirm.getRegistrationProvince());
			companyDetails.setTotalEmpCt(bussfirm.getNumberOfEmployees());
			companyDetails.setSalesFigureAm(bussfirm.getSalesFigureAmt());	
		}
		
		
		return companyDetails;
	}
	/*private String mapToAddressInputData(List<Bidaddrs> list)
	{
		List<AddressInputData> addressInputDatas = new ArrayList<>();
		
		for(Bidaddrs bidaddrs: list)
		{
			AddressInputData  inputData = new AddressInputData();
			inputData.setAddressLine1(bidaddrs.getAddressL1());
			inputData.setAddressLine2(bidaddrs.getAddressL2());
			inputData.setAddressLine3(bidaddrs.getAddressL3());
			inputData.setCity(bidaddrs.getCity());
			inputData.setPincode(bidaddrs.getPinCode());
			inputData.setState(bidaddrs.getState());
			//addressInputDatas.add(inputData);
		}
		return "";
	}*/
	
//	TelephoneInputData telephoneData=mapToTelephoneInputData(responseInfo.getBusinessResponse().getNGINQUIRY().getNgInqTel());
	/*private TelephoneInputData mapToTelephoneInputData(List<NgInqTel> list)
	{
		List<TelephoneInputData> telephoneInputData=new ArrayList<>();
		for(NgInqTel ngInqTel: list)
		{
			TelephoneInputData telData=new TelephoneInputData();
			telData.setTelephone(ngInqTel.getPhoneNumber());
			telData.setExt(ngInqTel.getPhoneNumberExtension());
			telData.setType(ngInqTel.getPhoneType());
			
			telephoneInputData.add(telData);
			
		}
		return (TelephoneInputData) telephoneInputData;
		
	}*/
	
	private ReportSummary getReportSummary() 
	{
		ReportSummary reportSummary = new ReportSummary();
		//responseInfo.getBusinessResponse().
		reportSummary.setNumOfAllAccounts(responseInfo.getBusinessResponse().getPSUMMARY().getAccsum().getTotalCreditAccount());
		reportSummary.setNumOfActiveAccounts(responseInfo.getBusinessResponse().getPSUMMARY().getAccsum().getTotalActiveAccounts());
		reportSummary.setTotalCreditProviders(responseInfo.getBusinessResponse().getPSUMMARY().getGrantor().getTotalCreditProviders());
		reportSummary.setCurrentCreditProviders(responseInfo.getBusinessResponse().getPSUMMARY().getGrantor().getCurrentCreditProviders());
	
		List<Credtype> credtypelist=responseInfo.getBusinessResponse().getPSUMMARY().getCredtype();
		if(credtypelist != null && !credtypelist.isEmpty())
		{
			for(Credtype credtype: credtypelist)
			{
				List<Acctypinfo> acctypinfos =credtype.getAccTypeInfo();
				for(Acctypinfo acctypinfo: acctypinfos)
				{
					reportSummary.setStandard(acctypinfo.getPctTotalStandardCreditType());
					reportSummary.setSubStandard(acctypinfo.getPctTotalSubStandardCreditType());
					reportSummary.setDoubtful(acctypinfo.getPctTotalDoubtfulCreditType());
					reportSummary.setLoss(acctypinfo.getPctTotalLossCreditType());
					reportSummary.setSma(acctypinfo.getPctTotalSpecMentionCreditType());
				}
			}	
		}
		
		reportSummary.setEnquiryinstitutionName(responseInfo.getBusinessResponse().getNGINQUIRY().getInqBureauMemberName());
		
		return reportSummary;
	}
	
	private AccountSummary getAccountSummaryFields()
	{
		AccountSummary accSum = new AccountSummary();
		List<Currcycnct> currcycncts=responseInfo.getBusinessResponse().getPSUMMARY().getCurrcycnct();
	
		if(currcycncts != null && !currcycncts.isEmpty())
		{
			List<FundedList> fundedLists = new ArrayList<>();
			for(Currcycnct currcycnct: currcycncts)
			{
				FundedList fundedList=new FundedList();
				fundedList.setCurrency(currcycnct.getCurrencyCd());
				fundedList.setFunded(currcycnct.getTotalNoFundedAccountType());
				fundedList.setNonFunded(currcycnct.getTotalNoNonFundedAccountType());
				fundedList.setLongTerm(currcycnct.getTotalNoLongTermAccountType());
				fundedList.setShortTerm(currcycnct.getTotalNoShortTermAccountType());
				fundedList.setWilful(currcycnct.getTotalNoWDAccountType());
				fundedList.setSuitFiled(currcycnct.getTotalNoSFAccountType());
				
				fundedLists.add(fundedList);
			}
			accSum.setFundedLists(fundedLists);
		}
		accSum.setNameOfInstitution(responseInfo.getBusinessResponse().getNGINQUIRY().getInqBureauMemberName());
		
		return accSum;
	}
	
	private List<LocationDetails> getLocationDetails()
	{
		List<BusHistory> busHistories =responseInfo.getBusinessResponse().getBUSINESS().getBusHist();
		List<LocationDetails> locationDetailsList = null;
		if(busHistories != null && !busHistories.isEmpty())
		{
			locationDetailsList = new ArrayList<LocationDetails>();
			for(BusHistory busHistory : busHistories)
			{
				LocationDetails locationDetails = new LocationDetails();
				locationDetails.setPinCode(busHistory.getCompanyPinCode());
				locationDetails.setBusinessAddress(busHistory.getCompanyAddress());
				locationDetails.setRptAsOfDt(convertDate(busHistory.getAsOfDate()));
				locationDetails.setTelephone(busHistory.getTelephone());
				locationDetails.setBusinessCity(busHistory.getCompanyCity());
				//locationDetails.setRegOffice(regOffice);
				
				locationDetailsList.add(locationDetails);
			}
		}
		
		return locationDetailsList;
	}
	
	private List<MainCreditFacility> getMainCreditFacility()
	{
		List<MainCreditFacility> creditFacilities = null;
		List<Commcred> commcreds = responseInfo.getBusinessResponse().getCOMMCRED();
		if(commcreds != null && !commcreds.isEmpty())
		{
			creditFacilities = new ArrayList<MainCreditFacility>();
			MainCreditFacility mainCreditFacility = new MainCreditFacility();
			
			for(Commcred commcred: commcreds)
			{
				CreditFacilityDetails details = new CreditFacilityDetails();
				
				details.setAccNo(commcred.getAccountNumber());
				details.setAccStatus(commcred.getAccountStatus());
				//details.setAccStatusDate(commcred.getAccountNumber());
				details.setCurrency(commcred.getAccountCurrency());
				details.setSancDate(convertDate(commcred.getSanctionDate()));
				details.setSancAmount(commcred.getSanctionedAmount());
				details.setCurrentBal(commcred.getCurrentBalance());
				details.setLastReportedDate(convertDate(commcred.getLastReportedDate()));
				
				details.setAssetClass(commcred.getAssetClassification());
				//details.setDpd();
				//details.setDrawingPower();
				//details.setInstallationAmount();
				//details.setLastRepaidAmount();
				details.setSuitFiled(commcred.getSuitFiledStatus());
				details.setWillfulDefault(commcred.getWilfulDefaultStatus());
				mainCreditFacility.setCreditFacilityDetails(details);
				
				List<Guarantor> guarantors= commcred.getGuarantor();
				List<CreditFacilityGuarentorDetails> creditFacilityGuarentorDetails=new ArrayList<CreditFacilityGuarentorDetails>();
					for(Guarantor guarantor: guarantors)
					{
						CreditFacilityGuarentorDetails guarantorDetails = new CreditFacilityGuarentorDetails();
						guarantorDetails.setEntityName(guarantor.getGuarantorName());
						guarantorDetails.setEntityRelatedType(guarantor.getGuarantorType());
						guarantorDetails.setEntityPAN(guarantor.getGuarantorPAN());
						guarantorDetails.setEntityAddress(guarantor.getGuarantorAddress());
						guarantorDetails.setEntityPhone(guarantor.getGuarantorTelephone());
						//guarantorDetails.setGender(guarantor.get());
						guarantorDetails.setLastReportedDate(convertDate(guarantor.getGuarantorLastReportedDate()));
						
						creditFacilityGuarentorDetails.add(guarantorDetails);
						mainCreditFacility.setGuarentorDetailsSec(creditFacilityGuarentorDetails);
					}
				
				List<Borrower> borrowers= commcred.getBorrower();
				List<CreditFacilityBorowerDetails> creditFacilityBorowerDetails=new ArrayList<CreditFacilityBorowerDetails>();
					for(Borrower borrower: borrowers)
					{
						CreditFacilityBorowerDetails borrowerDetails = new CreditFacilityBorowerDetails();
						borrowerDetails.setBorrowerNm(borrower.getBorrowerName());
						borrowerDetails.setAddress(borrower.getBorrowerAddress());
						borrowerDetails.setPanNo(borrower.getBorrowerPAN());
						borrowerDetails.setAddType(borrower.getBorrowerLocationType());
						borrowerDetails.setAccStatusDate(convertDate(borrower.getAccountStatusDate()));
						borrowerDetails.setLastReportDate(convertDate(borrower.getBorrowerLastReportedDate()));
						
						creditFacilityBorowerDetails.add(borrowerDetails);
						mainCreditFacility.setBorowerDetails4(creditFacilityBorowerDetails);
					}
			}
			creditFacilities.add(mainCreditFacility);	
		}
		return creditFacilities;
	}
	
	public List<RelationshipDetails> getRelationshipDetails() 
	{
		List<RelationshipDetails> relationshipDetailList = null;		
		List<Relations> relations = responseInfo.getBusinessResponse().getRELATIONS();
		if(relations != null && !relations.isEmpty())
		{
			relationshipDetailList = new ArrayList<RelationshipDetails>();
			for(Relations relation: relations)
			{
				RelationshipDetails relationshipDetails=new RelationshipDetails();
				relationshipDetails.setEntityName(relation.getEntityName());
				relationshipDetails.setEntityAddress(relation.getEntityAddress());
				relationshipDetails.setEntityRelationship(relation.getEntityRelationship());
				relationshipDetails.setEntityPctResp(relation.getPercentageOfControl());
				relationshipDetails.setEntityPAN(relation.getEntityPAN());
				relationshipDetails.setEntityRelatedType(relation.getEntityRelatedType());
				relationshipDetails.setLastReportedDate(convertDate(relation.getLastReportedDate()));
				relationshipDetails.setEntityPhone(relation.getEntityPhone());
							
				relationshipDetailList.add(relationshipDetails);
			}
		}
		
		return relationshipDetailList;
	}
	
	private List<SuitFiledDetails> getSuitFiledDetails() 
	{
		List<Commcred> commcreds = responseInfo.getBusinessResponse().getCOMMCRED();
		List<SuitFiledDetails> suitFiledDetailsList = null;
		if(commcreds != null && !commcreds.isEmpty())
		{
			suitFiledDetailsList = new ArrayList<SuitFiledDetails>();
			
			for(Commcred commcred: commcreds)
			{
				SuitFiledDetails filedDetails = new SuitFiledDetails();
				filedDetails.setMemberName(responseInfo.getBusinessResponse().getNGINQUIRY().getInqBureauMemberName());
				filedDetails.setSuitFiledAm(commcred.getSuitFiledAmount());
				filedDetails.setSuitAuthDt(convertDate(commcred.getSuitFiledDate()));
				String status = commcred.getSuitFiledStatus();
				if(status.equals("0"))
				{
					filedDetails.setSuitFiledStatCd("Not a Suit Filed Case");
				}
				if(status.equals("1"))
				{
					filedDetails.setSuitFiledStatCd("Suit Filed");
				}
				if(status.equals("2"))
				{
					filedDetails.setSuitFiledStatCd("Trial in Progress");
				}
				if(status.equals("3"))
				{
					filedDetails.setSuitFiledStatCd("Decree issued by court");
				}
				if(status.equals("4"))
				{
					filedDetails.setSuitFiledStatCd("Execution of Decree");
				}
				filedDetails.setSuitFiledAm(commcred.getSuitFiledAmount());
				
				suitFiledDetailsList.add(filedDetails);
			}
		}
		return suitFiledDetailsList;
	}
	
	private List<CreditFacilityDetailsAsGuarentor> getCreditFacilityDetailsAsGuarentor() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<EnquiryDetails> getEnquiryDetails()
	{
		List<EnquiryDetails> enquiryDetailsList = null;
		List<Enqrhist> enqrhists = responseInfo.getBusinessResponse().getENQRHIST();
		
		if(enqrhists != null && !enqrhists.isEmpty())
		{
			enquiryDetailsList = new ArrayList<EnquiryDetails>();
			for(Enqrhist enqrhist: enqrhists)
			{
				EnquiryDetails enquiryDetails=new EnquiryDetails();
				enquiryDetails.setOutputInqRqstDt(convertDate(enqrhist.getEnquiryDate()));
				//convert purpose code
				String purpose=enqrhist.getEnquiryPurposeCd();
				if(purpose.equals("1"))
				{
					enquiryDetails.setOutputInqPurpCd4In("Application for New Credit / Loan");
				}
				else if(purpose.equals("2"))
				{
					enquiryDetails.setOutputInqPurpCd4In("Application for Credit / Loan Increase");
				}
				else if(purpose.equals("3"))
				{
					enquiryDetails.setOutputInqPurpCd4In("Credit Review");
				}
				else if(purpose.equals("4"))
				{
					enquiryDetails.setOutputInqPurpCd4In("Collection of Debt");
				}
				else if(purpose.equals("5"))
				{
					enquiryDetails.setOutputInqPurpCd4In("Debt Purchase");
				}
				else if(purpose.equals("8"))
				{
					enquiryDetails.setOutputInqPurpCd4In("Insurance Underwriting");
				}
				enquiryDetails.setCurrency(enqrhist.getEnquiryConsAmtCurrencyCd());
				enquiryDetails.setAmount(enqrhist.getEnquiryAmount());
				if(enqrhist.getBureauMemberId().equals(responseInfo.getBusinessResponse().getNGINQUIRY().getInqBureauMemberId()))
				{
					enquiryDetails.setOutputInqCreditinstitutionNm(responseInfo.getBusinessResponse().getNGINQUIRY().getInqBureauMemberName());
				}
				else
				{
					enquiryDetails.setOutputInqCreditinstitutionNm("-");
				}
				enquiryDetailsList.add(enquiryDetails);
			}
		}
		
		
		return enquiryDetailsList;
	}
	
	private String convertDate(String str) 
	{
		SimpleDateFormat format1 = new SimpleDateFormat("ddmmyyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yy");
		java.util.Date date;
		String newDate="";
		try {
			if(!(str.equals(""))||!(str.equals(null)))
			{
			date = format1.parse(str);
			newDate = format2.format(date);
			//System.out.println(format2.format(date));
			}
			else
			{
				return "";
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}

	public static void main(String[] args)
	{
			String value="";
			try 
			{
                File f = new File("C:/Experian/EIR/getBusinessProductRespnse.xml");
                FileInputStream  fileInputStream  =  new FileInputStream(f);
                SOAPMessage message = MessageFactory.newInstance().createMessage(null, fileInputStream );
                
                Unmarshaller unmarshaller = JAXBContext.newInstance(ResponseInfo.class).createUnmarshaller();
                System.out.println(message.getSOAPBody());
                responseInfo = (ResponseInfo)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
                System.out.println(responseInfo);
			    responseInfo.getBusinessResponse();
			    
			    CommercialMapper commercialMapper = new CommercialMapper();
				//value=commercialMapper.mapData(responseInfo);
				CommonUtilityService commonUtilityService = new CommonUtilityService();
		        commonUtilityService.htmlToPdfFile(value, "J:/output/CIRReport.pdf", "");
		        System.out.println("PDF File Created");
            } 
			catch (SOAPException | JAXBException | IOException e)
			{
                // TODO Auto-generated catch block
                e.printStackTrace();
         }
			
	}
}
