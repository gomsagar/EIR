package com.eir.report.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eir.report.exception.NextGenCallException;
import com.eir.report.nextgen.service.client.ExperianHttpDirectClient;
import com.eir.report.nextgen.service.client.NextGenResponseWrapper;
import com.eir.report.nextgen.service.model.consumer.EnqHeader;
import com.eir.report.nextgen.service.model.consumer.GetConsumerProductRequest;
import com.eir.report.nextgen.service.model.consumer.PersAddr;
import com.eir.report.nextgen.service.model.consumer.PersonId;
import com.eir.report.nextgen.service.model.consumer.PrsnSrch;
import com.eir.report.nextgen.service.model.product.BusAddr;
import com.eir.report.nextgen.service.model.product.GetBusinessProductRequest;
import com.eir.report.nextgen.service.model.product.ObjectFactory;
import com.eir.report.service.NextGenWebService;
import com.experian.nextgen.ind.model.commercial.uofpojo.ResponseInfo;

@Service
public class NextGenWebServiceImpl implements NextGenWebService{

	Logger logger = LoggerFactory.getLogger(NextGenWebServiceImpl.class);

	ExperianHttpDirectClient experianHttDirectClient;
	
	public NextGenWebServiceImpl()
	{
		experianHttDirectClient = new ExperianHttpDirectClient();
	}
	
	
	@Override
	public void getCIRReport()
	{
		logger.info("NextGenWebServiceImpl: - getCIRReport()");
		
		try {
			NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(getCIRRequestXML());
			
			//Save nextGenResponseWrapper to db
			
		} catch (Exception e) {
			logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
		}
	}
	
	private String getCIRRequestXML()
	{
		try 
		{
			GetBusinessProductRequest productRequest = getCIRrequestObj();
			
			StringBuilder xmlString = new StringBuilder();
			xmlString.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"http://experian.com/nextgen/schemas\">   "
					+ "<soapenv:Header/>   <soapenv:Body>");
			
			JAXBContext context = JAXBContext.newInstance(GetBusinessProductRequest.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
	
			StringWriter sw = new StringWriter();
			m.marshal(productRequest, sw);
			String reqString = sw.toString();
			reqString = reqString.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();	
			
			xmlString.append(reqString);
			xmlString.append("</soapenv:Body>			 </soapenv:Envelope>");
		
			return xmlString.toString(); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*private ResponseInfo getProduct(String xmlOutput)
	{
		logger.info("NextGenWebServiceImpl:getProduct(), Start:  ");
		try 
		{
			
			StringReader stringReader = new StringReader(xmlOutput);
		
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(ResponseInfo.class);
		   
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			ResponseInfo responseInfo = (ResponseInfo) jaxbUnmarshaller.unmarshal(stringReader);
			
			logger.info("NextGenWebServiceImpl:getProduct(), End: ");
			return responseInfo;
		} catch (JAXBException e) {
			logger.error("NextGenWebServiceImpl:getProduct(), Exception while convert xmlOutput to responseInfo :  ", e);
		}  
		return null;
	}*/
	
	
	private GetBusinessProductRequest getCIRrequestObj()
	{
		ObjectFactory objectFactory = new ObjectFactory();
		GetBusinessProductRequest businessProductRequest = objectFactory.createGetProductRequest();
		
		businessProductRequest.setSTARTENQ("START");
		com.eir.report.nextgen.service.model.product.EnqHeadr param = new com.eir.report.nextgen.service.model.product.EnqHeadr();
		param.setBureauMemberId("3388");
		param.setPurpose("1");
		param.setProduct("INBCIR001");
		param.setSearchType("1");
		//param.setEnquiryApplicationType("1");
		param.setEnquiryAccountType("999");
		param.setEnquiryAmount("10");
		param.setFrequency("99");
		param.setClientEnquiryRefNumber("");
		param.setEnquiryAmtMonetaryType("INR");
		param.setDurationofAgrement("365");
		businessProductRequest.setENQHEADR(param);
		com.eir.report.nextgen.service.model.product.UserPref userPref = new com.eir.report.nextgen.service.model.product.UserPref();
		businessProductRequest.setUSERPREF(userPref);
		
		com.eir.report.nextgen.service.model.product.BusnesAcct e = new com.eir.report.nextgen.service.model.product.BusnesAcct();
		e.setBankAccountNumber("");
		businessProductRequest.getBUSNESACCT().add(e);
		com.eir.report.nextgen.service.model.product.AddlProd addlProd = new com.eir.report.nextgen.service.model.product.AddlProd();
		addlProd.setEnquiryAddOnProduct("1");
		businessProductRequest.getADDLPROD().add(addlProd);
		
		com.eir.report.nextgen.service.model.product.BinId binId = new com.eir.report.nextgen.service.model.product.BinId();
		businessProductRequest.getBINID().add(binId);
		
		List<com.eir.report.nextgen.service.model.product.BusSrch> busSrchArr = new ArrayList<com.eir.report.nextgen.service.model.product.BusSrch>();
		com.eir.report.nextgen.service.model.product.BusSrch busSrch = new com.eir.report.nextgen.service.model.product.BusSrch();
		busSrch.setBusName("Amex INCORPORATED");
		busSrch.setCompanyPan("ASBCP1234A");
		busSrchArr .add(busSrch);
		businessProductRequest.getBUSNSRCH().add(busSrch);
		
		List<BusAddr> busAddrArr = new ArrayList<>();
		BusAddr busAddr = new BusAddr();
		busAddr.setAddrType("14");
		busAddr.setCountryCode("IND");
		busAddr.setCity("BANGALORE");
		busAddr.setState("31");
		busAddr.setDistrict("");
		busAddr.setPINCode("560031");
		busAddr.setAddressLine1("TEST_YASHODHAR MAHADIK");
		busAddr.setAddressLine2("TEST_CHS LTD");
		busAddr.setAddressLine3("TEST_YASHODHAR MAHADIK");
		busAddrArr.add(busAddr);
		businessProductRequest.getBUSNADDR().add(busAddr);

		businessProductRequest.setENDOFENQ("END");

		return businessProductRequest;
		
	}
	
	@Override
	public void getConsumerReport()
	{
		logger.info("NextGenWebServiceImpl: - getCIRReport()");
		
		try {
			NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(getConsumerRequestXML());
			
			//Save nextGenResponseWrapper to db
			
		} catch (IOException e) {
			logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
		} catch (NextGenCallException e) {
			logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
		}
	}
	
	private String getConsumerRequestXML()
	{
		try 
		{
			GetConsumerProductRequest consumerProductRequest = getConsumerRequestObj();
			
			StringBuilder xmlString = new StringBuilder();
			xmlString.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"http://experian.com/nextgen/schemas\">   "
					+ "<soapenv:Header/>   <soapenv:Body>");
			
			JAXBContext context = JAXBContext.newInstance(GetConsumerProductRequest.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
	
			StringWriter sw = new StringWriter();
			m.marshal(consumerProductRequest, sw);
			String reqString = sw.toString();
			reqString = reqString.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();	
			
			xmlString.append(reqString);
			xmlString.append("</soapenv:Body>			 </soapenv:Envelope>");
		
			return xmlString.toString(); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private GetConsumerProductRequest getConsumerRequestObj()
	{
		com.eir.report.nextgen.service.model.consumer.ObjectFactory objectFactory = new com.eir.report.nextgen.service.model.consumer.ObjectFactory();
		GetConsumerProductRequest consumerProductRequest = objectFactory.createGetConsumerProductRequest();
		consumerProductRequest.setSTARTENQ("START");
		EnqHeader enqHeader = new EnqHeader();
		enqHeader.setClientEnquiryRefNumber("");
		enqHeader.setBureauMemberId("3388");
		enqHeader.setPurposeOfInquiry("1");
		enqHeader.setPurpose("1");
		enqHeader.setProduct("INCCIR002");
		enqHeader.setSearchType("1");
		enqHeader.setEnquiryApplicationType("");
		enqHeader.setEnquiryAccountType("999");
		enqHeader.setEnquiryAmtMonetaryType("");
		enqHeader.setEnquiryAmount("11000");
		enqHeader.setEnquiryCreditPurpose("1");
		enqHeader.setDurationofAgreement("1");
		enqHeader.setFrequency("99");
		consumerProductRequest.setENQHEADER(enqHeader);
		
		List<PrsnSrch> prsnsrchList = new ArrayList<>();
		PrsnSrch srch = new PrsnSrch();
		srch.setFirstGivenName("NISHITH");
		srch.setMiddleName("");
		srch.setOtherMiddleNames("");
		srch.setFamilyName("GAJJAR");
		srch.setSuffix("");
		srch.setApplicationRole("");
		srch.setDateOfBirth("25071994");
		srch.setGender("3");
		srch.getIndiaMiddleName3();
		srch.setIndiaNameTitle("");
		consumerProductRequest.setPRSNSRCH(prsnsrchList);
		
		List<PersonId> personidList = new ArrayList<>();
		PersonId personId = new PersonId();
		personId.setIdNumberType("10");
		personId.setIdNumber("BUQPT2355G");
		personidList.add(personId);
		consumerProductRequest.setPERSONID(personidList);
		
		List<PersAddr> persaddrList = new ArrayList<>();
		PersAddr persAddr = new PersAddr();
		persAddr.setLocalityName("MUMBAI");
		persAddr.setRegionCode("27");
		persAddr.setPostalCode("401009");
		persAddr.setAddressLine1("LTMARG60");
		persAddr.setAddressLine2("MALAD");
		consumerProductRequest.setPERSADDR(persaddrList);
		
		return consumerProductRequest;
	}
	
}