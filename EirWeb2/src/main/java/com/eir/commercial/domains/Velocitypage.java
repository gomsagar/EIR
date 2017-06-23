
//Velocity Template page

package com.eir.commercial.domains;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

//import com.sun.javafx.scene.text.HitInfo;


public class Velocitypage {

	//public static void main(String[] args) {
		
		
		//VelocityEngine ve=new VelocityEngine();
		//ve.init();
//		Properties p = new Properties();
//	    p.setProperty("file.resource.loader.path", "/home/dambar/mayur /Collapse/src/collapsesub.vm");
	    
		//org.apache.velocity.Template t=ve.getTemplate("/velocityTemplate/Commercial.vm");
		
		
		// Header part
		//CommercialReportDetails reportDetails = new CommercialReportDetails();
		public VMReportHeader getReportHeader(){
		VMReportHeader header = new VMReportHeader();
		header.setEnquiryReference("123456789");
		header.setExperianReferenceNumber("987654321");
		header.setMemberName("Mayur Kadam");
		header.setGenerateDate("12/23/2012");
		header.setGenerateTime("12:12:12");
		return header;
		}
		//reportDetails.setReportHeader(header);
		public Score getScore(){
		Score score=new Score();
		score.setScore(440);
		score.setIsscore(1);
		//reportDetails.setScore(score);
		return score;
		}	
		//Current Apllication Section:1
		public CurrentApplication getCurrentApplication(){
		CurrentApplication applicationDetials2= new CurrentApplication();
		applicationDetials2.setInqCompanyName("Augment IQ");
		applicationDetials2.setEnquiryPurposeCd("Check");
		applicationDetials2.setEnquiryAmount(""+10000000);
		applicationDetials2.setInqCompanyAddress("Baner");
		applicationDetials2.setInqCompanyCity("Pune");
		applicationDetials2.setInqCompanyPinCode("440027");
		
		applicationDetials2.setTelephone("312334");
		applicationDetials2.setInqPan("baquwerfe");
		applicationDetials2.setLoanAccNo("12345");
		return applicationDetials2;
		}
		
		
		//reportDetails.setApplication(applicationDetials2);
		
		//Company Details section:2
		public CompanyDetails getCompanyDetails(){
		CompanyDetails companyDetails2=new CompanyDetails();
		companyDetails2.setBusNm("Augment IQ");
		companyDetails2.setBusinessTelephone("72761");
		companyDetails2.setBusFax("66458790");
		companyDetails2.setBusRegCityNum("Pune");
		companyDetails2.setBusRegDt("11/10/1970");
		companyDetails2.setBusRegNb4In("BNNX876");
		companyDetails2.setBusRegProvinceCd4In("Maharashtra");
		companyDetails2.setTotalEmpCt("600");
		companyDetails2.setBusAddress("103, Peninsula Towers,Hike Park, S. K. Marg,,Lower Parel (W");
		companyDetails2.setPanNumber("baquwerfe");
		companyDetails2.setSalesFigureAm("--");
		companyDetails2.setBusCategoryCd("Medium");
		companyDetails2.setIndusCd("Service Provider");
		companyDetails2.setLegalConstitution("Partnership");
        companyDetails2.setCin("CINR008 F/Y");
        companyDetails2.setClassOfActivity("Manufacturing");
        companyDetails2.setCreditRatingAgency("--");
        companyDetails2.setLatestCreditRating("--");
        companyDetails2.setSic("---");
        companyDetails2.setTin("TINJ00M");
        companyDetails2.setServiceTaxNumber("ABCD005");
        companyDetails2.setCompanyShortName("Aiq");
        companyDetails2.setFinancialYear("2015/2016");
		//reportDetails.setCompanyDetails(companyDetails2);
		return companyDetails2;
		}
		
		//Report Summary Section:3
		public ReportSummary getReportSummary(){
		ReportSummary reportSummary=new ReportSummary();
		reportSummary.setCurrentCreditProviders("2");
		reportSummary.setNumOfActiveAccounts("4");
		reportSummary.setTotalCreditProviders("2");
		reportSummary.setNumOfAllAccounts("6");
		reportSummary.setStandard("2");
		reportSummary.setSubStandard("2");
		reportSummary.setDoubtful("0");
		reportSummary.setLoss("0");
		reportSummary.setSma("0");
		reportSummary.setBureauMember("50%");
		reportSummary.setPvt("10%");
		reportSummary.setPsu("20%");
		reportSummary.setNbfc("20%");
		reportSummary.setFrb("0");
		reportSummary.setEnquiryinstitutionName("HDFC");
		
		//Enquiry Summary Part 1:Institution Name
		reportSummary.setMonthFourToSix("0");
		reportSummary.setMonthOne("1");
		reportSummary.setMonthTwoToThree("2");
		reportSummary.setMonthSevenToTwelve("0");
		reportSummary.setMonthTwelveToTwentyFour("0");
		reportSummary.setMonthGreaterThanTwentyFour("0");
		reportSummary.setMostRecent("12/12/12");
		reportSummary.setTotal("0");
		reportSummary.setEnquiryTotal("3");
		
		//Enquiry Summary Part 1:Others
		
		reportSummary.setOthersmonthFourToSix("0");
		reportSummary.setOthersmonthOne("1");
		reportSummary.setOthersmonthTwoToThree("2");
		reportSummary.setOthersmonthSevenToTwelve("0");
		reportSummary.setOthersmonthTwelveToTwentyFour("0");
		reportSummary.setOthersmonthGreaterThanTwentyFour("0");
		reportSummary.setOthersmostRecent("12/12/12");
		reportSummary.setOthersTotal("0");
		

		//Enquiry Summary Part 1:Total
		
		reportSummary.setTotalmonthFourToSix("0");
		reportSummary.setTotalmonthOne("1");
		reportSummary.setTotalmonthTwoToThree("2");
		reportSummary.setTotalmonthSevenToTwelve("0");
		reportSummary.setTotalmonthTwelveToTwentyFour("0");
		reportSummary.setTotalmonthGreaterThanTwentyFour("0");
		reportSummary.setTotalmostRecent("12/12/12");
		reportSummary.setTotal_total("0");
		//reportDetails.setReportSummary(reportSummary);
		return reportSummary;
		}
		// Account Summary Section:4
		public AccountSummary getAccountSummary(){
		AccountSummary accSum =new AccountSummary();
		
		
		accSum.setTCFAB("2");
		accSum.setTCFAG("2");
		accSum.setACF("1");
		accSum.setTOAG("13000");
		accSum.setLAOP("1321");
		accSum.setDCFOBAB("1");
		accSum.setDCFOBABB("1000000");
		accSum.setDCFOBAG("1");
		accSum.setDCFOBAGB("100000");
		accSum.setPSUTCFAB("3");
		accSum.setPSUTCFAG("2");
		accSum.setPSUACF("1");
		accSum.setPSUTOAG("13000");
		accSum.setPSULAOP("1321");
		accSum.setPSUDCFOBAB("1");
		accSum.setPSUDCFOBABB("100000");
		accSum.setPSUDCFOBAG("1");
		accSum.setPSUDCFOBAGB("102131");
		accSum.setPVTTCFAB("2");
		accSum.setPVTTCFAG("2");
		accSum.setPVTACF("1");
		accSum.setPVTTOAG("1300");
		accSum.setPVTLAOP("1321");
		accSum.setPVTDCFOBAB("1");
		accSum.setPVTDCFOBABB("100000");
		accSum.setPVTDCFOBAG("1");
		accSum.setPVTDCFOBAGB("100000");
		accSum.setNBFCTCFAB("2");
		accSum.setNBFCTCFAG("2");
		accSum.setNBFCACF("1");
		accSum.setNBFCTOAG("13000");
		accSum.setNBFCLAOP("1321");
		accSum.setNBFCDCFOBAB("1");
		accSum.setNBFCDCFOBABB("100000");
		accSum.setNBFCDCFOBAG("1");
		accSum.setNBFCDCFOBAGB("100000");
		accSum.setGTTCFAB("2");
		accSum.setGTTCFAG("2");
		accSum.setGTACF("1");
		accSum.setGTTOAG("13000");
		accSum.setGTLAOP("1321");
		accSum.setGTDCFOBAB("1");
		accSum.setGTDCFOBABB("100000");
		accSum.setGTDCFOBAG("100000");
		accSum.setGTDCFOBAGB("100000");
		accSum.setNSTTCFAB("2");
		accSum.setNSTTCFAG("2");
		accSum.setNSTACF("1");
		accSum.setNSTTOAG("13000");
		accSum.setNSTLAOP("1321");
		accSum.setNSTDCFOBAB("1");
		accSum.setNSTDCFOBABB("100000");
		accSum.setNSTDCFOBAG("1");
		accSum.setNSTDCFOBAGB("100000");
		
	
		accSum.setTOAB("1000");
        accSum.setPSUTOAB("1000");
        accSum.setPVTTOAB("1000");
        accSum.setNBFCTOAB("1000");
        accSum.setNSTTOAB("1000");
        accSum.setGTTOAB("1000");
//        accSum.setBank1("HDFC");
        //accSum.setBank2("PSU");
        //accSum.setBank3("PVT");
        //accSum.setBank4("NBFC & Others");
		//reportDetails.setAccountSummary(accSum);
        
        List<CreditType> list=new ArrayList<CreditType>();
        CreditType credit1=new CreditType();
        credit1.setCreditType("Demand Loan");
        credit1.setNameOfInstitution("HDFC");
       list.add(credit1);
		List<Others> list2=new ArrayList<Others>();
		Others other=new Others();
		other.setCreditType("Demand Loan");
		other.setNameOfInstitution("HDFC");
		other.setDemandloan0dpdacc("2");
		other.setDemandloan30dpdacc("-");
		other.setDemandloan60dpdacc("--");
		other.setDemandloan90dpdacc("1");
		other.setDemandloan365dpdacc("--");
		other.setDemandloan730dpdacc("--");
		other.setDemandloanlossacc("0");
		other.setDemandloanSMAacc("0");
		other.setDemandloanTotalacc("0");
		other.setDemandloan0dpdoutstanding("100000");
		other.setDemandloan30dpdoutstanding("--");
		other.setDemandloan60dpdoutstanding("--");
		other.setDemandloan90dpdoutstanding("--");
		other.setDemandloan365dpdoutstanding("--");
		other.setDemandloan730dpdoutstanding("--");
		other.setDemandloanlossoutstanding("0");
		other.setDemandloanSMAoutstanding("0");
		other.setDemandloanTotaloutstanding("0");
		
		Others other1=new Others();
		other1.setCreditType("Demand Loan");
		other1.setNameOfInstitution("HDFC");
		other1.setDemandloan0dpdacc("2");
		other1.setDemandloan30dpdacc("-");
		other1.setDemandloan60dpdacc("--");
		other1.setDemandloan90dpdacc("1");
		other1.setDemandloan365dpdacc("--");
		other1.setDemandloan730dpdacc("--");
		other1.setDemandloanlossacc("0");
		other1.setDemandloanSMAacc("0");
		other1.setDemandloanTotalacc("0");
		other1.setDemandloan0dpdoutstanding("100000");
		other1.setDemandloan30dpdoutstanding("--");
		other1.setDemandloan60dpdoutstanding("--");
		other1.setDemandloan90dpdoutstanding("--");
		other1.setDemandloan365dpdoutstanding("--");
		other1.setDemandloan730dpdoutstanding("--");
		other1.setDemandloanlossoutstanding("0");
		other1.setDemandloanSMAoutstanding("0");
		other1.setDemandloanTotaloutstanding("0");
		list2.add(other);
		list2.add(other1);
		accSum.setTypes(list);
		return accSum;
		}
	/*	
		public List<CreditType> getTypes(){
			List<CreditType> creditTypes=new ArrayList<CreditType>();
			CreditType credit1=new CreditType();
			credit1.setCreditType("Demand Loan");
			credit1.setNameOfInstitution("HDFC");
			credit1.setDemandloan0dpdacc("2");
			credit1.setDemandloan30dpdacc("-");
			credit1.setDemandloan60dpdacc("--");
			credit1.setDemandloan90dpdacc("1");
			credit1.setDemandloan365dpdacc("--");
			credit1.setDemandloan730dpdacc("--");
			credit1.setDemandloanlossacc("0");
			credit1.setDemandloanSMAacc("0");
			credit1.setDemandloanTotalacc("0");
			credit1.setDemandloan0dpdoutstanding("100000");
			credit1.setDemandloan30dpdoutstanding("--");
			credit1.setDemandloan60dpdoutstanding("--");
			credit1.setDemandloan90dpdoutstanding("--");
			credit1.setDemandloan365dpdoutstanding("--");
			credit1.setDemandloan730dpdoutstanding("--");
			credit1.setDemandloanlossoutstanding("0");
			credit1.setDemandloanSMAoutstanding("0");
			credit1.setDemandloanTotaloutstanding("0");
			
			CreditType credit2=new CreditType();
			credit2.setCreditType("Demand Cash");
			credit2.setNameOfInstitution("HDFC");
			credit2.setDemandloan0dpdacc("2");
			credit2.setDemandloan30dpdacc("-");
			credit2.setDemandloan60dpdacc("--");
			credit2.setDemandloan90dpdacc("1");
			credit2.setDemandloan365dpdacc("--");
			credit2.setDemandloan730dpdacc("--");
			credit2.setDemandloanlossacc("0");
			credit2.setDemandloanSMAacc("0");
			credit2.setDemandloanTotalacc("0");
			credit2.setDemandloan0dpdoutstanding("100000");
			credit2.setDemandloan30dpdoutstanding("--");
			credit2.setDemandloan60dpdoutstanding("--");
			credit2.setDemandloan90dpdoutstanding("--");
			credit2.setDemandloan365dpdoutstanding("--");
			credit2.setDemandloan730dpdoutstanding("--");
			credit2.setDemandloanlossoutstanding("0");
			credit2.setDemandloanSMAoutstanding("0");
			credit2.setDemandloanTotaloutstanding("0");
			creditTypes.add(credit1);
			creditTypes.add(credit2);
			return creditTypes;
		}*/
		//Locatoin Details Section :5
		public List<LocationDetails> getLocationDetails(){
		List<LocationDetails> locationDetails= new ArrayList<LocationDetails>();
		
		LocationDetails details2 =new LocationDetails();
		details2.setRegOffice("Registered Office");
		details2.setBusinessAddress("103, Peninsula Towers,Hike Park, S. K. Marg,,Lower Parel (W)");
		details2.setBusinessCity("Mumbai");
		details2.setBusinessId("AAAAR9652M");
		details2.setPinCode("400013");
		details2.setRptAsOfDt("30/06/2015");
		details2.setTelephone("02012345678");
		locationDetails.add(details2);
		
		LocationDetails details3 =new LocationDetails();
		details3.setRegOffice("LNT");
		details3.setBusinessAddress("103, Peninsula Towers,Hike Park, S. K. Marg,,Lower Parel (W)");
		details3.setBusinessCity("Pune");
		details3.setBusinessId("BBBBR9652M");
		details3.setPinCode("400012");
		details3.setRptAsOfDt("30/06/2015");
		details3.setTelephone("0201212321342");
		locationDetails.add(details3);
		//reportDetails.setLocationDetails(locationDetails);
		return locationDetails;
		}
		//Suit Filed Section :8
		public List<SuitFiledDetails> getSuitFiledDetails (){
		List<SuitFiledDetails> suitFiled =new ArrayList<SuitFiledDetails>();
		SuitFiledDetails suit=new SuitFiledDetails();;
		suit.setSuitAuthDt("15/11/2016");
		suit.setSuitFiledAm("1,00,000");
		suit.setSuitFiledStatCd("AB-102102");
		suit.setSuitRefNB("152150");
		suit.setMemberName("Abc");
		
		
		SuitFiledDetails suit1=new SuitFiledDetails();;
		suit1.setSuitAuthDt("11/11/2016");
		suit1.setSuitFiledAm("2,00,000");
		suit1.setSuitFiledStatCd("XY-102102");
		suit1.setSuitRefNB("12345");
		suit1.setMemberName("XYZ");
		
		suitFiled.add(suit);
		suitFiled.add(suit1);
		//reportDetails.setSuitFiledDetails(suit);
	//	reportDetails.sets
		return suitFiled;
		}
		//RelationShip Details:7
		
		public List<RelationshipDetails> getRelationshipDetails(){
			List<RelationshipDetails> relationshipDetails=new ArrayList<RelationshipDetails>();
			
		RelationshipDetails relationshipDetails2 =new RelationshipDetails();
		
		relationshipDetails2.setOtherId("--");
		//relationshipDetails2.setCompanyName("");
		relationshipDetails2.setEntityName("Manish Kamath");
		relationshipDetails2.setEntityAddress("254, D.N. Nagar,Andheri, Mumbai");
		relationshipDetails2.setEntityPAN("ASWQK2967F");
		relationshipDetails2.setEntityPctResp("43%");
		relationshipDetails2.setEntityPhone("022-6767766");
		relationshipDetails2.setEntityRelatedType("Resident Indian Individual");
		relationshipDetails2.setEntityRelationship("Director");
		relationshipDetails2.setLastReportedDate("31/10/2015");
		relationshipDetails2.setBusCat("--");
		relationshipDetails2.setBusIndType("--");
		relationshipDetails2.setCin("--");
		relationshipDetails2.setDin("--");
		relationshipDetails2.setTin("--");
		relationshipDetails2.setDob("12/07/1968");
		relationshipDetails2.setGender("Male");
		relationshipDetails2.setVoterId("--");
		relationshipDetails2.setPassportNo("--");
		relationshipDetails2.setDrivingLiNo("--");
		relationshipDetails2.setUid("--");
		relationshipDetails2.setRationCardNo("--");
		relationshipDetails2.setDateOfIncorporation("12/12/2012");
		relationshipDetails2.setRegNo("--");
		relationshipDetails2.setServiceTaxNo("--");
		
		
		relationshipDetails.add(relationshipDetails2);
		
		return relationshipDetails;
		}
		//Inquiry Details:10
		public List<EnquiryDetails> getEnquiryDetails(){
		List<EnquiryDetails> enquiryDetails=new ArrayList<EnquiryDetails>();
		
		EnquiryDetails enquiryDetails2 =new EnquiryDetails();
		enquiryDetails2.setOutputInqCreditExtAm("23,00,000");
		enquiryDetails2.setOutputInqCreditinstitutionNm("GBR Finvest");
		enquiryDetails2.setOutputInqPurpCd4In("Demand Loan");
//		enquiryDetails2.setOutputInqRqstDt("14/10/2015");
		enquiryDetails2.setCurrency("INR");
		enquiryDetails2.setAmount("12000");
		
		EnquiryDetails enquiryDetails3 =new EnquiryDetails();
		enquiryDetails3.setOutputInqCreditExtAm("20,00,000");
		enquiryDetails3.setOutputInqCreditinstitutionNm("PVT Bank");
		enquiryDetails3.setOutputInqPurpCd4In("Cash Credit");
		enquiryDetails3.setOutputInqRqstDt("13/10/2015");
		enquiryDetails3.setCurrency("INR");
		enquiryDetails3.setAmount("14000");
		EnquiryDetails details4=new EnquiryDetails();
		details4.setOutputInqCreditExtAm("20,00,000");
		details4.setOutputInqCreditinstitutionNm("NBFC");
		details4.setOutputInqPurpCd4In("Cash Credit");
		details4.setOutputInqRqstDt("13/10/2015");
		details4.setCurrency("INR");
		details4.setAmount("10000");
		
		enquiryDetails.add(enquiryDetails2);
		enquiryDetails.add(enquiryDetails3);
		enquiryDetails.add(details4);
		//reportDetails.setInquiryDetails(inquiryDetails);
		return enquiryDetails;
		}
		
		
		//Credit Facility Details As Guarentor:9
				public List<CreditFacilityDetailsAsGuarentor >getFacilityDetailsAsGuarentor(){
					List<CreditFacilityDetailsAsGuarentor > asGuarentors=new ArrayList<CreditFacilityDetailsAsGuarentor>();
				
					CreditFacilityDetailsAsGuarentor asGuarentor = new CreditFacilityDetailsAsGuarentor();
						asGuarentor.setAccNo("AZXJDK87312");
						asGuarentor.setAccType("Loan, Medium Term");
						asGuarentor.setSancDate("07/02/2003");
						asGuarentor.setSancAmount("300000");
						asGuarentor.setCurrency("INR");
						asGuarentor.setAccStatus("Open");
						asGuarentor.setWilfulDefault("--");
						asGuarentor.setAccStatusDate("12/08/2003");
						asGuarentor.setAssetClass("Standard");
						asGuarentor.setMarkToMarket("188323");
						asGuarentor.setLastReportedDate("31/08/2015");
						asGuarentor.setHighCredit("--");
						asGuarentor.setInstallationAmount(""+500000);
						asGuarentor.setRepaymentFreq("Month");
						asGuarentor.setTenure(""+300);
						asGuarentor.setLoanExpMat("20/2/2015");
						asGuarentor.setLoanRenewalDate("2/12/2015");
						asGuarentor.setCurrentBal("123456");
						asGuarentor.setLastRepaidAmount(""+50000);
						asGuarentor.setOverdueAm("-");
						asGuarentor.setSetteldAm(""+300);
						asGuarentor.setWrittenOfAm(""+0);
						
						asGuarentor.setDrawingPower(""+300000);
						asGuarentor.setAssetBSecCov("Partial");
						asGuarentor.setGuarenteeCov("Full");
						asGuarentor.setRestructRea("--");
						asGuarentor.setLimitUti("--");
						asGuarentor.setNaorc("--");
						asGuarentor.setNotionalAmOfCont("--");
						
						asGuarentor.setAmOfContCNPA("--");
						asGuarentor.setSuitFiled("--");
						asGuarentor.setRestructDetails("--");
						asGuarentor.setBusNm("Augment IQ");
						asGuarentor.setBusinessTelephone("72761");
						asGuarentor.setBusFax("66458790");
						asGuarentor.setBusRegCityNum("Pune");
						asGuarentor.setBusRegDt("11/10/1970");
						asGuarentor.setBusRegNb4In("BNNX876");
						asGuarentor.setBusRegProvinceCd4In("Maharashtra");
						asGuarentor.setTotalEmpCt(""+600);
						asGuarentor.setBusAddress("Baner");
						asGuarentor.setPanNumber("baquwerfe");
						asGuarentor.setSalesFigureAm("--");
						asGuarentor.setBusCategoryCd("Medium");
						asGuarentor.setIndusCd("Service Provider");
						asGuarentor.setLegalConstitution("Partnership");
						asGuarentor.setCin("CINR008 F/Y");
				        asGuarentor.setClassOfActivity("Manufacturing");
				        asGuarentor.setCreditRatingAgency("--");
				        asGuarentor.setLatestCreditRating("--");
				        asGuarentor.setSic("---");
				        asGuarentor.setTin("TINJ00M");
				        asGuarentor.setServiceTaxNumber("ABCD005");
				        asGuarentor.setCompanyShortName("Aiq");
				        asGuarentor.setFinancialYear("2015/2016");
				        asGuarentor.setDpd("--");
		        
				        CreditFacilityDetailsAsGuarentor asGuarentor1 = new CreditFacilityDetailsAsGuarentor();
					asGuarentor1.setAccNo("AZXJDK87312");
					asGuarentor1.setAccType("Loan, Medium Term");
					asGuarentor1.setSancDate("07/02/2003");
					asGuarentor1.setSancAmount("300000");
					asGuarentor1.setCurrency("INR");
					asGuarentor1.setAccStatus("Open");
					asGuarentor1.setWilfulDefault("--");
					asGuarentor1.setAccStatusDate("12/08/2003");
					asGuarentor1.setAssetClass("Standard");
					asGuarentor1.setMarkToMarket("188323");
					asGuarentor1.setLastReportedDate("31/08/2015");
					asGuarentor1.setHighCredit("--");
					asGuarentor1.setInstallationAmount(""+500000);
					asGuarentor1.setRepaymentFreq("Month");
					asGuarentor1.setTenure(""+300);
					asGuarentor1.setLoanExpMat("20/Feb/29");
					asGuarentor1.setLoanRenewalDate("20/Feb/29");
					asGuarentor1.setCurrentBal("123456");
					asGuarentor1.setLastRepaidAmount(""+50000);
					asGuarentor1.setOverdueAm(""+0);
					asGuarentor1.setSetteldAm(""+300);
					asGuarentor1.setWrittenOfAm(""+0);
					
					asGuarentor1.setDrawingPower(""+300000);
					asGuarentor1.setAssetBSecCov("Partial");
					asGuarentor1.setGuarenteeCov("Full");
					asGuarentor1.setRestructRea("--");
					asGuarentor1.setLimitUti("--");
					asGuarentor1.setNaorc("--");
					asGuarentor1.setNotionalAmOfCont("--");
					
					asGuarentor1.setAmOfContCNPA("--");
					asGuarentor1.setSuitFiled("--");
					asGuarentor1.setRestructDetails("--");
					asGuarentor1.setBusNm("Augment IQ");
					asGuarentor1.setBusinessTelephone("72761");
					asGuarentor1.setBusFax("66458790");
					asGuarentor1.setBusRegCityNum("Pune");
					asGuarentor1.setBusRegDt("11/10/1970");
					asGuarentor1.setBusRegNb4In("BNNX876");
					asGuarentor1.setBusRegProvinceCd4In("Maharashtra");
					asGuarentor1.setTotalEmpCt(""+600);
					asGuarentor1.setBusAddress("Baner");
					asGuarentor1.setPanNumber("baquwerfe");
					asGuarentor1.setSalesFigureAm("--");
					asGuarentor1.setBusCategoryCd("Medium");
					asGuarentor1.setIndusCd("Service Provider");
					asGuarentor1.setLegalConstitution("Partnership");
					asGuarentor1.setCin("CINR008 F/Y");
			        asGuarentor1.setClassOfActivity("Manufacturing");
			        asGuarentor1.setCreditRatingAgency("--");
			        asGuarentor1.setLatestCreditRating("--");
			        asGuarentor1.setSic("---");
			        asGuarentor1.setTin("TINJ00M");
			        asGuarentor1.setServiceTaxNumber("ABCD005");
			        asGuarentor1.setCompanyShortName("Aiq");
			        asGuarentor1.setFinancialYear("2015/2016");
			        asGuarentor1.setDpd("--");
			        asGuarentors.add(asGuarentor);
		        asGuarentors.add(asGuarentor1);
		      // reportDetails.setFacilityDetailsAsGuarentor(asGuarentor);
		       return asGuarentors;
				}
		//Credit facility section:6.1.1 AsBorrower
		public List<MainCreditFacility> getMianCreditFacility(){
		List<MainCreditFacility> creditFacilities = new ArrayList<MainCreditFacility>();
		
		MainCreditFacility creditFacility=new MainCreditFacility();
		creditFacility.setIndexVariableCount("6");
		creditFacility.setDerivative(true);

        creditFacility.setBorrower(true);
        creditFacility.setSecurity(true);
        creditFacility.setCheckDishonour(true);
        creditFacility.setCreditRating(true);
		CreditFacilityDetails details6 =new CreditFacilityDetails();
		//details6.setBankName1("PVT");
		details6.setBankName("HDFC");
		details6.setMarkToMarket("--");
		details6.setAccNo("AZXJDK87312");
		details6.setAccType("Loan, Medium Term");
		details6.setSancDate("07/02/2003");
		details6.setSancAmount("300000");
//		details6.setCurrency("&#2352;");
		details6.setCurrency("12345");
		details6.setAccStatus("Open");
		details6.setWieghtedAvgMatPeriodOfContract("300");
		details6.setAccStatusDate("12/08/2003");
		details6.setAssetClass("Standard");
		details6.setCurrentBal("188323");
		details6.setLastReportedDate("31/08/2015");
		details6.setHighCredit("--");
		details6.setInstallationAmount(""+500000);
		details6.setRepaymentFreq("Month");
		details6.setTenure(""+300);
		details6.setLoanExpMat("20/Feb/29");
		details6.setLoanRenewalDate("20/Feb/29");
		details6.setWillfulDefault("--");
		details6.setLastRepaidAmount(""+50000);
		details6.setOverdueAm(""+0);
		details6.setSetteldAm(""+300);
		details6.setWrittenOfAm(""+0);
		details6.setDrawingPower(""+300000);
		details6.setAssetBSecCov("Partial");
		details6.setGuarenteeCov("Full");
		details6.setRestructRea("--");
		details6.setLimitUti("--");
		details6.setNaorc("--");
		details6.setNotionalAmOfCont("--");
		details6.setAmOfContCNPA("--");
		details6.setSuitFiled("--");
		details6.setRestructDetails("--");
		details6.setDpd("123");
		creditFacility.setCreditFacilityDetails(details6);
		
	    
	  //Credit Facility Payment History :6.2
		
       List<CreditFacilityPaymentHistory> paymentHistories=new ArrayList<CreditFacilityPaymentHistory>();
       CreditFacilityPaymentHistory history=new CreditFacilityPaymentHistory();
       history.setMonth1("JAN 2016");
       history.setStatus("STD");
       history.setCurrentBalance("123456");
       history.setMonth2("DEC 2015");
       history.setStatus2("STD");
       history.setCurrentBalance2("987654");
       history.setMonth3("NOV 2015");
       history.setStatus3("STD");
       history.setCurrentBalance3("6548956");
       history.setMonth4("OCT 2015");
       history.setStatus4("STD");
       history.setCurrentBalance4("34343872");
       history.setMonth5("SEPT 2015");
       history.setStatus5("STD");
       history.setCurrentBalance5("36462345");
       history.setMonth6("AUG 2015");
       history.setStatus6("STD");
       history.setCurrentBalance6("456446");
       paymentHistories.add(history);
       CreditFacilityPaymentHistory history1=new CreditFacilityPaymentHistory();
       history1.setMonth1("JULY 2015");
       history1.setStatus("STD");
       history1.setCurrentBalance("246328");
       history1.setMonth2("JUN 2015");
       history1.setStatus2("STD");
       history1.setCurrentBalance2("123445");
       history1.setMonth3("MAY 2015");
       history1.setStatus3("STD");
       history1.setCurrentBalance3("1324244");
       history1.setMonth4("APR 2015");
       history1.setStatus4("STD");
       history1.setCurrentBalance4("1234345");
       history1.setMonth5("MARCH 2015");
       history1.setStatus5("STD");
       history1.setCurrentBalance5("349564");
       history1.setMonth6("FEB 2015");
       history1.setStatus6("STD");
       history1.setCurrentBalance6("13432425");
       
       
       paymentHistories.add(history1);
       creditFacility.setPaymentHistory(paymentHistories);
       //Credit Facility Details:6.3
	    List<CreditFacilityGuarentorDetails> guarentorDetails=new ArrayList<CreditFacilityGuarentorDetails>();
	    CreditFacilityGuarentorDetails guarentorDetails3Sec =new CreditFacilityGuarentorDetails();
	   
	    guarentorDetails3Sec.setCompanyName("");
	    guarentorDetails3Sec.setEntityName("Manish Kamath");
	    guarentorDetails3Sec.setEntityAddress("254, D.N. Nagar,Andheri, Mumbai");
	    guarentorDetails3Sec.setEntityPAN("ASWQK2967F");
	    guarentorDetails3Sec.setEntityPhone("0226767766");
	    guarentorDetails3Sec.setEntityRelatedType("Resident Indian Individual");
	    guarentorDetails3Sec.setEntityRelationship("Director");
	    guarentorDetails3Sec.setLastReportedDate("31/10/2015");
	    guarentorDetails3Sec.setBusCat("--");
	    guarentorDetails3Sec.setBusIndType("--");
	    guarentorDetails3Sec.setCin("--");
	    guarentorDetails3Sec.setDin("--");
	    guarentorDetails3Sec.setTin("--");
	    guarentorDetails3Sec.setDob("12/07/1968");
	    guarentorDetails3Sec.setGender("Male");
	    guarentorDetails3Sec.setVoterId("--");
	    guarentorDetails3Sec.setPassportNo("--");
	    guarentorDetails3Sec.setDrivingLiNo("--");
	    guarentorDetails3Sec.setUid("--");
	    guarentorDetails3Sec.setRationCardNo("--");
	    guarentorDetails3Sec.setDateOfIncorporation("--");
	    guarentorDetails3Sec.setRegNo("--");
	    guarentorDetails3Sec.setServiceTaxNo("--");
	    guarentorDetails3Sec.setType("abc");
	    guarentorDetails3Sec.setOtherid("null");
	    guarentorDetails.add(guarentorDetails3Sec);
		creditFacility.setGuarentorDetailsSec(guarentorDetails);
		//creditFacilities.add(creditFacility);
		//reportDetails.setCreditFacilities(creditFacilities);
		
		//Credit Facility Details:6.4
		List<CreditFacilityBorowerDetails> borowerDetails=new ArrayList<CreditFacilityBorowerDetails>();
		CreditFacilityBorowerDetails borowerDetails4=new CreditFacilityBorowerDetails();
		borowerDetails4.setBorrowerNm("mayur");
		borowerDetails4.setAddType("--");
		borowerDetails4.setAddress("abc");
		borowerDetails4.setPanNo("--");
		borowerDetails4.setTin("--");
		borowerDetails4.setCin("-");
		borowerDetails4.setAccStatusDate("15/01/15");
		borowerDetails4.setLastReportDate("31/03/2015");
		CreditFacilityBorowerDetails borowerDetails1=new CreditFacilityBorowerDetails();
		borowerDetails1.setBorrowerNm("XYZ");
		borowerDetails1.setAddType("--");
		borowerDetails1.setAddress("kyc");
		borowerDetails1.setPanNo("--");
		borowerDetails1.setTin("--");
		borowerDetails1.setCin("-");
		borowerDetails1.setAccStatusDate("12/01/15");
		borowerDetails1.setLastReportDate("30/03/2015");
		borowerDetails.add(borowerDetails4);
		borowerDetails.add(borowerDetails1);
		creditFacility.setBorowerDetails4(borowerDetails);
		
		//Credit Facility Details:6.5
		
		List<CreditFacilitiesSecuritiesDetails> securitiesDetails5s=new ArrayList<CreditFacilitiesSecuritiesDetails>();
		CreditFacilitiesSecuritiesDetails facilitiesSecuritiesDetails5=new CreditFacilitiesSecuritiesDetails();
		facilitiesSecuritiesDetails5.setCurrency("INR");
		facilitiesSecuritiesDetails5.setClassification("Secondary");
		facilitiesSecuritiesDetails5.setLastReportDate("12/12/12");
		facilitiesSecuritiesDetails5.setSecurityValue("abc");
		facilitiesSecuritiesDetails5.setType("abc");
		facilitiesSecuritiesDetails5.setValuationDate("12/12/2012");
		securitiesDetails5s.add(facilitiesSecuritiesDetails5);
		CreditFacilitiesSecuritiesDetails creditFacilitiesSecuritiesDetails5=new CreditFacilitiesSecuritiesDetails();
		creditFacilitiesSecuritiesDetails5.setCurrency("INR");
		creditFacilitiesSecuritiesDetails5.setClassification("primary");
		creditFacilitiesSecuritiesDetails5.setLastReportDate("12/12/12");
		creditFacilitiesSecuritiesDetails5.setSecurityValue("abc");
		creditFacilitiesSecuritiesDetails5.setType("abc");
		creditFacilitiesSecuritiesDetails5.setValuationDate("12/12/2012");
		securitiesDetails5s.add(creditFacilitiesSecuritiesDetails5);
		creditFacility.setSecuritiesDetails5s(securitiesDetails5s);
		
		//Credit Facility Details:6.6
		List<CreditFacilityCheckDishonour> dishonour6s=new ArrayList<CreditFacilityCheckDishonour>();
	CreditFacilityCheckDishonour checkDishonour=new CreditFacilityCheckDishonour();
		checkDishonour.setMonth("No of Times Dishonered");
		checkDishonour.setMonth3("4");
		checkDishonour.setMonth6("3");
		checkDishonour.setMonth9("1");
		checkDishonour.setMonth12("2");
    CreditFacilityCheckDishonour checkDishonour1=new CreditFacilityCheckDishonour();
		checkDishonour1.setMonth("No of Times Dishonered");
		checkDishonour1.setMonth3("1");
		checkDishonour1.setMonth6("2");
		checkDishonour1.setMonth9("3");
		checkDishonour1.setMonth12("4");
		dishonour6s.add(checkDishonour);
		dishonour6s.add(checkDishonour1);
		creditFacility.setCheckDishonour6s(dishonour6s);
		
		//Credit Facility Details:6.7
	
		CreditFacilityCreditRatings ratings=new CreditFacilityCreditRatings();
		
		ratings.setCreditRatingasOnaaa("20/02/2011");
		ratings.setCreditRatingasOnaa("12/12/2012");
		ratings.setCreditRatingasOnbbb("12/12/2011");
		ratings.setCreditRatingExpiryDateaa("20/02/2011");
		ratings.setCreditRatingExpiryDateaaa("12/12/2003");
		ratings.setCreditRatingExpiryDatebbb("12/12/2004");
		ratings.setCreditRatingReportedDateaa("20/03/2016");
		ratings.setCreditRatingReportedDateaaa("12/11/2010");
		ratings.setCreditRatingReportedDatebbb("12/9/2014");
		ratings.setAa("AAA");
		ratings.setAaa("AA+");
		ratings.setBbb("BBB");
		
	    
		creditFacility.setCreditRatings(ratings);
		creditFacilities.add(creditFacility);
		return creditFacilities;
		}
		public ReportCir getCir(){
			ReportCir reportCir = new ReportCir();
			reportCir.setAddress("8TH FLOOR NIKE BUILDING");
			reportCir.setCity("Mumbai");
			reportCir.setPincode("400021");
			reportCir.setCompany_name("VIVO PRIVATE LTD,");
			reportCir.setDateOfReport("06-01-2017");
			reportCir.setExperianReferenceNumber("1483713374487");
			reportCir.setEmail("consumer.support@in.experian.com");
			reportCir.setTelephone("022 6641 9000");
			reportCir.setPost("Experian Credit Information Company of India Private Limited PO Box No.9096, Goregaon (East), Mumbai 400 063.");
			reportCir.setWebsite("www.experian.in");
			return reportCir;
		}
		public SalesInvoice getInvoice(){
			SalesInvoice salesInvoice = new SalesInvoice();
			salesInvoice.setAddress("8TH FLOOR NIKE BUILDING");
			salesInvoice.setCity("Mumbai");
			salesInvoice.setCompany_name("VIVO PRIVATE LTD,");
			salesInvoice.setDate("06-01-2017");
			salesInvoice.setPincode("400021");
			salesInvoice.setTotal("138");
			salesInvoice.setRegards("Thank you for applying for your Experian Credit Information Report and for your payment of ");
			salesInvoice.setPan("AABCE6822A");
			salesInvoice.setServiceTaxNumber("AABCE6822AST002");
			salesInvoice.setInvoicenumber("2017DISCLOSURE010000000044");
			salesInvoice.setDeliveryCharges("100");
			salesInvoice.setSubTotalA("100");
			salesInvoice.setSubTotalB("100");
			salesInvoice.setEducationCees("100");
			salesInvoice.setHigherEduCees("100");
			salesInvoice.setReport_fee("100");
			salesInvoice.setServiceTax("100");
			return salesInvoice;
		}

		
		//public static void main (String args[]){
		//	System.out.println("Hello");
	
		
		public static void main(String args[]){
			VelocityEngine velocityEngine=new VelocityEngine();
			org.apache.velocity.Template t=velocityEngine.getTemplate("/velocityTemplate/MainCommercial.vm");

			CommercialReportDetails reportDetails = new CommercialReportDetails();
			//reportDetails.setRelationshipentity(false);
			reportDetails.setCurrency("INR");
			Velocitypage velocitypage = new Velocitypage();
			
			boolean bool = true;
			if (bool) {
				reportDetails.setMatchFound(true);
				reportDetails.setReportHeader(velocitypage.getReportHeader());
				reportDetails.setScore(velocitypage.getScore());
				reportDetails.setApplication(velocitypage.getCurrentApplication());
				reportDetails.setCompanyDetails(velocitypage.getCompanyDetails());
				reportDetails.setReportSummary(velocitypage.getReportSummary());
				reportDetails.setAccountSummary(velocitypage.getAccountSummary());
				reportDetails.setLocationDetails(velocitypage.getLocationDetails());
				reportDetails.setSuitFiledDetails(velocitypage.getSuitFiledDetails());
				reportDetails.setRelationshipDetails(velocitypage.getRelationshipDetails());
				reportDetails.setFacilityDetailsAsGuarentor(velocitypage.getFacilityDetailsAsGuarentor());
				reportDetails.setEnquiryDetails(velocitypage.getEnquiryDetails());
				reportDetails.setCreditFacilities(velocitypage.getMianCreditFacility());
				reportDetails.setCir(velocitypage.getCir());
				reportDetails.setInvoice(velocitypage.getInvoice());
				
			} else {
				reportDetails.setMatchFound(false);
				reportDetails.setApplication(velocitypage.getCurrentApplication());
				
			}
			
			VelocityContext context=new VelocityContext();
			context.put("reportDetails", reportDetails);
			context.put("StringUtils", StringUtils.class);
			
			StringWriter writer=new StringWriter();
			t.merge(context,writer);
	        String htmlOutput = writer.toString();
	        
	        
	        FileWriter fileWriter = null;
	        try {
	        	File file = new File("myreport.html");
				fileWriter = new FileWriter(file);
				fileWriter.write(htmlOutput);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (fileWriter != null) {
						fileWriter.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
	        CommonUtilityService commonUtilityService = new CommonUtilityService();
	        commonUtilityService.htmlToPdfFile(htmlOutput, "myreport.pdf", "");
	   
	    }
	
	}

