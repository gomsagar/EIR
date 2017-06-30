package com.eir.report.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.eir.combo.domains.ComboSummaryDomain;
//import com.eir.bir.request.model.CirRequest;
import com.eir.combo.domains.RelatedDirectorsDomain;
import com.eir.commercial.domains.CommercialReportDetails;
import com.eir.domain.BIRDomain;
import com.eir.domain.ComboDomain;
import com.eir.domain.EIRDomain;
import com.eir.model.EIRDataConstant;
import com.eir.bir.request.model.Consumer;
import com.eir.report.constant.Constant;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.ConsumerRequest;
import com.eir.report.entity.Request;
import com.eir.report.entity.Status;
import com.eir.report.exception.NextGenCallException;
import com.eir.report.nextgen.service.client.ExperianHttpDirectClient;
import com.eir.report.nextgen.service.client.NextGenResponseWrapper;
import com.eir.report.nextgen.service.mapper.CommercialMapper;
import com.eir.report.nextgen.service.mapper.CreateReport;
import com.eir.report.nextgen.service.model.consumer.AddlProd;
import com.eir.report.nextgen.service.model.consumer.EnqHeader;
import com.eir.report.nextgen.service.model.consumer.GetConsumerProductRequest;
import com.eir.report.nextgen.service.model.consumer.PersAddr;
import com.eir.report.nextgen.service.model.consumer.PersonId;
import com.eir.report.nextgen.service.model.consumer.PrsnSrch;
import com.eir.report.nextgen.service.model.consumer.UserPref;
import com.eir.report.nextgen.service.model.product.BusAddr;
import com.eir.report.nextgen.service.model.product.GetBusinessProductRequest;
import com.eir.report.nextgen.service.model.product.ObjectFactory;
import com.eir.report.repository.CirRequestRepository;
import com.eir.report.repository.ConsumerRequetRepository;
import com.eir.report.repository.RequestRepository;
import com.eir.report.repository.StatusRepository;
import com.eir.report.service.NextGenWebService;
import com.experian.nextgen.ind.model.consumer.uofpojo.Bpaygrid;
import com.experian.nextgen.ind.model.consumer.uofpojo.Conscred;
import com.experian.nextgen.ind.model.consumer.uofpojo.ConsumerResponse;
import com.experian.nextgen.ind.model.consumer.uofpojo.Perinpidc;
import com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo;

@Service
public class NextGenWebServiceImpl implements NextGenWebService{


	
	Logger logger = LoggerFactory.getLogger(NextGenWebServiceImpl.class);

	ExperianHttpDirectClient experianHttDirectClient;
	
	public NextGenWebServiceImpl()
	{
		System.out.println("NextGenWebServiceImpl constructor");
		experianHttDirectClient = new ExperianHttpDirectClient();
	}
	
	@Autowired
	CirRequestRepository cirRequestRepository;
	
	@Autowired
	ConsumerRequetRepository consumerRequetRepository; 
	
	@Autowired
	RequestRepository requestRepository; 
	
	@Autowired
	StatusRepository statusRepository;
	
	@Override
	public CommercialReportDetails getCIRReport(CirRequest cirRequest)
	{
		logger.info("NextGenWebServiceImpl: - getCIRReport()");
		
		if(cirRequest != null)
		{
			try {
					//NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(getCIRRequestXML());
					 if(cirRequest.getStatus() != null)
					 {
						 String reportStatus = cirRequest.getStatus().getStatusDescription();
						 if(com.eir.report.constant.Status.COMPLETED.status().equals(reportStatus))
						 {
							 byte[] reportXml = cirRequest.getXmlOutput();
							 ByteArrayInputStream in = new ByteArrayInputStream(reportXml);
							 //FileInputStream  fileInputStream  =  new FileInputStream(reportXml.toString());
							  
				             SOAPMessage message = MessageFactory.newInstance().createMessage(null, in );
				             Unmarshaller unmarshaller = JAXBContext.newInstance(com.experian.nextgen.ind.model.commercial.uofpojo.ResponseInfo.class).createUnmarshaller();
				             com.experian.nextgen.ind.model.commercial.uofpojo.ResponseInfo responseInfo = (com.experian.nextgen.ind.model.commercial.uofpojo.ResponseInfo)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
				             CommercialMapper commercialMapper = new CommercialMapper();
				             CommercialReportDetails cirReportDetails = commercialMapper.mapData(responseInfo);
							
							 return cirReportDetails;
					     }
						 else
						 {
							 logger.debug("Report is in " + reportStatus + " state.");
						 }
					 }
				} 
		
			catch (Exception e)
			{
				logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
			}
		}
			return null;
	}
	
	private String getCIRRequestXML(com.eir.report.entity.CirRequest cirRequest)
	{
		try 
		{
			GetBusinessProductRequest productRequest = getCIRrequestObj(cirRequest);
			
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
	
	
	private GetBusinessProductRequest getCIRrequestObj(com.eir.report.entity.CirRequest cirRequest)
	{
		ObjectFactory objectFactory = new ObjectFactory();
		GetBusinessProductRequest businessProductRequest = objectFactory.createGetProductRequest();
		
		businessProductRequest.setSTARTENQ("START");
		com.eir.report.nextgen.service.model.product.EnqHeadr param = new com.eir.report.nextgen.service.model.product.EnqHeadr();
		param.setBureauMemberId("3388");
		param.setPurpose(checkNull(cirRequest.getPurposeId()));
		param.setProduct(cirRequest.getProductField());
		param.setSearchType(cirRequest.getSearchType());
		//param.setEnquiryApplicationType("1");
		param.setEnquiryAccountType(cirRequest.getEnquiryAccntType());
		param.setEnquiryAmount(cirRequest.getEnquiryAmount());
		param.setFrequency(cirRequest.getFrequency());
		param.setClientEnquiryRefNumber("");
		param.setEnquiryAmtMonetaryType(cirRequest.getEnquiryAmntMomentaryType());
		param.setDurationofAgrement(cirRequest.getDurationOfAgrement());
		businessProductRequest.setENQHEADR(param);
		
		com.eir.report.nextgen.service.model.product.UserPref userPref = new com.eir.report.nextgen.service.model.product.UserPref();
		businessProductRequest.setUSERPREF(userPref);
		
		com.eir.report.nextgen.service.model.product.AddlProd addlProd = new com.eir.report.nextgen.service.model.product.AddlProd();
		addlProd.setEnquiryAddOnProduct(cirRequest.getEnquiryAddProduct());
		businessProductRequest.getADDLPROD().add(addlProd);
		
		com.eir.report.nextgen.service.model.product.BusnesAcct e = new com.eir.report.nextgen.service.model.product.BusnesAcct();
		e.setBankAccountNumber("");
		businessProductRequest.getBUSNESACCT().add(e);
		
		com.eir.report.nextgen.service.model.product.BinId binId = new com.eir.report.nextgen.service.model.product.BinId();
		businessProductRequest.getBINID().add(binId);
		
		List<com.eir.report.nextgen.service.model.product.BusSrch> busSrchArr = new ArrayList<com.eir.report.nextgen.service.model.product.BusSrch>();
		com.eir.report.nextgen.service.model.product.BusSrch busSrch = new com.eir.report.nextgen.service.model.product.BusSrch();
		busSrch.setBusName(cirRequest.getBusName());
		busSrch.setCompanyPan(cirRequest.getCompanyPan());
		busSrchArr .add(busSrch);
		businessProductRequest.getBUSNSRCH().add(busSrch);
		
		List<BusAddr> busAddrArr = new ArrayList<>();
		BusAddr busAddr = new BusAddr();
		busAddr.setAddrType(checkNull(cirRequest.getAddress().getAddressType().getAddressTypeId()));
		busAddr.setCountryCode("IND");
		busAddr.setCity(cirRequest.getAddress().getCity());
		busAddr.setState(checkNull(cirRequest.getAddress().getState()));
		busAddr.setDistrict("");
		busAddr.setPINCode(cirRequest.getAddress().getPincode());
		busAddr.setAddressLine1(cirRequest.getAddress().getAddressLine1());
		busAddr.setAddressLine2(cirRequest.getAddress().getAddressLine2());
		busAddr.setAddressLine3(cirRequest.getAddress().getAddressLine3());
		busAddrArr.add(busAddr);
		businessProductRequest.getBUSNADDR().add(busAddr);

		businessProductRequest.setENDOFENQ("END");

		return businessProductRequest;
		
	}
	
	public List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> getConsumerReport(List<ConsumerRequest> consumerRequests)
	{
		List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> responseInfoList = new ArrayList();
		logger.info("NextGenWebServiceImpl: - getCIRReport()");
		
		if(consumerRequests != null && consumerRequests.size() > 0)
		{
			try
			{
				for(ConsumerRequest consumerRequest : consumerRequests)
				{
					//NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(getConsumerRequestXML());
					
					//Save nextGenResponseWrapper to db  consumerRequest
					
					/*File f = new File("C:/Experian/EIR/getConsumerProductRespnse.xml");
		            FileInputStream  fileInputStream  =  new FileInputStream(f);*/
					if(consumerRequest.getStatusId() != null)
					{
						String xmlStatus = consumerRequest.getStatusId().getStatusDescription();
						 
						 if(com.eir.report.constant.Status.COMPLETED.status().equals(xmlStatus))
						 {
							byte[] requestedConsXml = consumerRequest.getXmlOutput();
							ByteArrayInputStream bais = new ByteArrayInputStream(requestedConsXml);
							//FileInputStream  fileInputStream  =  new FileInputStream(requestedConsXml.toString());
							
				            SOAPMessage message = MessageFactory.newInstance().createMessage(null, bais );
				            Unmarshaller unmarshaller = JAXBContext.newInstance(com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo.class).createUnmarshaller();
				            com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo responseInfoCons = (com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
				           
						    setPaymentHistoryMap(responseInfoCons);
							
							responseInfoList.add(responseInfoCons);
						
						 }
						 else
						 {
							 logger.debug("Report is in " + xmlStatus + " state.");
						 }
					}
				}
				return responseInfoList;
			}
			
			catch (Exception e) 
			{
				logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
			}
		}
		return null;
	}

	private void setPaymentHistoryMap(com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo responseInfoCons) 
	{
		if(responseInfoCons.getConsumerResponse() != null && responseInfoCons.getConsumerResponse().getConscred() != null 
				&& !responseInfoCons.getConsumerResponse().getConscred().isEmpty())
		{
			List<Conscred> conscredList = responseInfoCons.getConsumerResponse().getConscred();
			for(Conscred conscred: conscredList)
			{
				List<Bpaygrid> bpaygridList = conscred.getBpaygrid();
				
				Map<String, ArrayList<Bpaygrid>> paymentHistMap = new HashMap<String, ArrayList<Bpaygrid>>();
				
				ArrayList<Bpaygrid> bpayGridList = null; 
				
				for(Bpaygrid bpaygrid: bpaygridList)
				{
					if(paymentHistMap.containsKey(bpaygrid.getYear()))
					{
						bpayGridList = paymentHistMap.get(bpaygrid.getYear());
						bpayGridList.add(bpaygrid);
					}
					else
					{
						bpayGridList = new ArrayList<>();
						bpayGridList.add(bpaygrid);
						paymentHistMap.put(bpaygrid.getYear(), bpayGridList);
					}
					
				}
				conscred.setPaymentHistMap(paymentHistMap);
			}
		}
		
	}
	
	private String getConsumerRequestXML(ConsumerRequest consumerRequestXml)
	{
		try 
		{
			GetConsumerProductRequest consumerProductRequest = getConsumerRequestObj(consumerRequestXml);
			
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
		
			createXml(xmlString.toString());
			
			return xmlString.toString(); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void createXml(String xmlString) {
		// TODO Auto-generated method stub
		
		File file = new File("D:/output");
        FileWriter fileWriter = null;
		
		if (!file.exists())
		{
		 file.mkdirs();
		}      
        
        try
        {
        	file = new File("D:/output/Request.xml");
			fileWriter = new FileWriter(file);
			fileWriter.write(xmlString);
			System.out.println("Xml File Created");
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        
        finally
        {
			try 
			{
				if (fileWriter != null) 
				{
					fileWriter.close();
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	private String checkNull(Integer value)
	{
		if(value != null )
		{
			return value.toString();
		}
		
		return "";
	}
	
	private String checkNull(Double value)
	{
		if(value != null )
		{
			return value.toString();
		}
		
		return "";
	}
	
	private String checkNull(Date value)
	{
		if(value != null )
		{
			return value.toString();
		}
		
		return "";
	}
	
	
	private GetConsumerProductRequest getConsumerRequestObj(ConsumerRequest consumerRequest)
	{
		com.eir.report.nextgen.service.model.consumer.ObjectFactory objectFactory = new com.eir.report.nextgen.service.model.consumer.ObjectFactory();
		GetConsumerProductRequest consumerProductRequest = objectFactory.createGetConsumerProductRequest();
		consumerProductRequest.setSTARTENQ("START");
		EnqHeader enqHeader = new EnqHeader();
		enqHeader.setClientEnquiryRefNumber(consumerRequest.getClientEnquiryRefNumber());
		enqHeader.setBureauMemberId(checkNull(consumerRequest.getBureauMemberId()));
		enqHeader.setPurposeOfInquiry(checkNull(consumerRequest.getPurposeOfInquiry()));
		enqHeader.setPurpose(checkNull(consumerRequest.getPurposeId()));
		enqHeader.setProduct(consumerRequest.getProductField());
		enqHeader.setSearchType(consumerRequest.getSearchType());
		enqHeader.setEnquiryApplicationType(consumerRequest.getEnquiryApplicationType());
		enqHeader.setEnquiryAccountType(checkNull(consumerRequest.getEnquiryAccountTypeId()));
		enqHeader.setEnquiryAmtMonetaryType(consumerRequest.getEnquiryAmtMonetaryType());
		enqHeader.setEnquiryAmount(checkNull(consumerRequest.getEnquiryAmount()));
		enqHeader.setEnquiryCreditPurpose(checkNull(consumerRequest.getEnquiryCreditPurposeId()));
		enqHeader.setDurationofAgreement(consumerRequest.getDurationOfAgreement());
		enqHeader.setFrequency(checkNull(consumerRequest.getFrequencyId()));
		consumerProductRequest.setENQHEADER(enqHeader);
		
		UserPref userPref = new UserPref();
		userPref.setLanguage(consumerRequest.getLanguage());
		consumerProductRequest.setUSERPREF(userPref);
		
		AddlProd addlProd = new AddlProd();
		addlProd.setEnquiryAddOnProduct(consumerRequest.getEnquiryAddOnProduct());
		consumerProductRequest.getADDLPROD().add(addlProd);
		
		//set Date format in ddMMyyyy form for NExtgen request
		DateTimeFormatter formatter = DateTimeFormat.forPattern("ddMMyyyy");
		String dateFormat = formatter.print(consumerRequest.getDateOfBirth());
		//end dateformat here
		
		List<PrsnSrch> prsnsrchList = new ArrayList<>();
		PrsnSrch srch = new PrsnSrch();
		srch.setFirstGivenName(consumerRequest.getFirstName());
		srch.setMiddleName(consumerRequest.getMiddleName());
		srch.setOtherMiddleNames(consumerRequest.getOtherMiddleNames());
		srch.setFamilyName(consumerRequest.getLastName());
		srch.setSuffix(consumerRequest.getSuffix());
		srch.setApplicationRole(consumerRequest.getApplicationRole());
		srch.setDateOfBirth(dateFormat);
		srch.setGender(checkNull(consumerRequest.getGenderId()));
		srch.getIndiaMiddleName3();
		srch.setIndiaNameTitle(consumerRequest.getIndiaNameTitle());
		prsnsrchList.add(srch);
		consumerProductRequest.setPRSNSRCH(prsnsrchList);
		
		com.eir.report.nextgen.service.model.consumer.PersAlias persAlias = new com.eir.report.nextgen.service.model.consumer.PersAlias();
		persAlias.setAliasName(consumerRequest.getAliasName());
		persAlias.setAliasType(consumerRequest.getAliasType());
		consumerProductRequest.setPERSALIAS(persAlias);
		
		List<PersonId> personidList = new ArrayList<>();
		PersonId personId = new PersonId();
		
		String pan =consumerRequest.getPersonPan();
		String drivingLic =consumerRequest.getDrivingLic();
		String aadharCard =consumerRequest.getAadharCard();
		String voterId =consumerRequest.getVoterId();
		String rationCard =consumerRequest.getRationCard();
		String passportNo =consumerRequest.getPassportNo();
		
		if(pan != null && !pan.isEmpty())
		{
		personId.setIdNumberType("10");
		personId.setIdNumber(pan);
		personidList.add(personId);
		}
		
		if(drivingLic != null && !drivingLic.isEmpty())
		{
			personId.setIdNumberType("1");
			personId.setIdNumber(drivingLic);
			personidList.add(personId);
		}
		
		if(aadharCard != null && !aadharCard.isEmpty())
		{
			personId.setIdNumberType("12");
			personId.setIdNumber(aadharCard);
			personidList.add(personId);
		}
		
		if(voterId != null && !voterId.isEmpty())
		{
			personId.setIdNumberType("7");
			personId.setIdNumber(voterId);
			personidList.add(personId);
		}
		
		if(rationCard != null && !rationCard.isEmpty())
		{
			personId.setIdNumberType("11");
			personId.setIdNumber(rationCard);
			personidList.add(personId);
		}
		
		if(passportNo != null && !passportNo.isEmpty())
		{
			personId.setIdNumberType("7");
			personId.setIdNumber(passportNo);
			personidList.add(personId);
		}
		
		consumerProductRequest.setPERSONID(personidList);

		com.eir.report.nextgen.service.model.consumer.PersonBnk personBnk = new com.eir.report.nextgen.service.model.consumer.PersonBnk();
		personBnk.setBankAccountNumber(consumerRequest.getBankAccountNumber());
		consumerProductRequest.setPERSONBNK(personBnk);
		
		List<PersAddr> persaddrList = new ArrayList<>();
		PersAddr persAddr = new PersAddr();
		persAddr.setLocalityName("MUMBAI");
		persAddr.setRegionCode("27");
		persAddr.setPostalCode(consumerRequest.getAddressId().getPincode());
		persAddr.setAddressLine1(consumerRequest.getAddressId().getAddressLine1());
		persAddr.setAddressLine2(consumerRequest.getAddressId().getAddressLine2());
		persaddrList.add(persAddr);
		consumerProductRequest.setPERSADDR(persaddrList);

		com.eir.report.nextgen.service.model.consumer.PersPhone persPhone = new com.eir.report.nextgen.service.model.consumer.PersPhone();
		List<com.eir.report.nextgen.service.model.consumer.PersPhone> phoneList = new ArrayList<>();
		String home =consumerRequest.getHomeTelephoneNo();
		String office =consumerRequest.getOfficeTelephoneNo();
		String mobileNo =consumerRequest.getMobileNo();
		
		if(home != null && !home.isEmpty())
		{
			persPhone.setPhoneNumber(home);
			persPhone.setPhoneType("1");
			phoneList.add(persPhone);
		}
		if(office != null && !office.isEmpty())
		{
			persPhone.setPhoneNumber(office);
			persPhone.setPhoneType("3");
			phoneList.add(persPhone);
		}
		if(mobileNo != null && !mobileNo.isEmpty())
		{
			persPhone.setPhoneNumber(mobileNo);
			persPhone.setPhoneType("6");
			phoneList.add(persPhone);
		}
		
		consumerProductRequest.setPERSPHONE(phoneList);
		
		com.eir.report.nextgen.service.model.consumer.PersEmail persemail = new com.eir.report.nextgen.service.model.consumer.PersEmail();
		persemail.setWebAddr(consumerRequest.getWebAddr());
		persemail.setWebAddrType("");//TODO
		List<com.eir.report.nextgen.service.model.consumer.PersEmail> persemailList = new ArrayList<>();
		persemailList.add(persemail);
		consumerProductRequest.setPERSEMAIL(persemailList);
		
		com.eir.report.nextgen.service.model.consumer.Employer employer = new com.eir.report.nextgen.service.model.consumer.Employer();
		employer.setOccupationCode(consumerRequest.getOccupationCode());
		employer.setNetMontlyIncome(consumerRequest.getNetMontlyIncome());
		employer.setOccYearsEmployed(consumerRequest.getOccYearsEmployed());
		employer.setOccMonthsEmployed(consumerRequest.getOccMonthsEmployed());
		consumerProductRequest.setEMPLOYER(employer);
		
		com.eir.report.nextgen.service.model.consumer.PersDetail persDetail = new com.eir.report.nextgen.service.model.consumer.PersDetail();
		persDetail.setAssetOwnershipIndicator(consumerRequest.getAssetOwnershipIndicator());
		persDetail.setMaritalStatus(consumerRequest.getMaritalStatus());
		persDetail.setMonthlyFamilyExpenseAmt(consumerRequest.getMonthlyFamilyExpenseAmt());
		persDetail.setNumberDependents(consumerRequest.getNumberDependents());
		persDetail.setNumberOfCreditCardHeld(consumerRequest.getNumberOfCreditCardHeld());
		persDetail.setPovertyIndex(checkNull(consumerRequest.getPovertyIndex()));
		consumerProductRequest.setPERSDETAIL(persDetail);
		
		com.eir.report.nextgen.service.model.consumer.PinId pinId = new com.eir.report.nextgen.service.model.consumer.PinId();
		pinId.setEperianEncryptedPIN(consumerRequest.getMonthlyFamilyExpenseAmt());
		List<com.eir.report.nextgen.service.model.consumer.PinId> pinIdList = new ArrayList<>();
		pinIdList .add(pinId);
		consumerProductRequest.setPINID(pinIdList);
		
		return consumerProductRequest;
	}

	@Override
	public com.eir.report.entity.CirRequest createCIRReport(com.eir.report.entity.CirRequest cirRequest) 
	{
		logger.info("NextGenWebServiceImpl: - createCIRReport() Start");
		try 
		{
			String cirRequestXML = getCIRRequestXML(cirRequest);
			NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(cirRequestXML);
			
			String statusStr = com.eir.report.constant.Status.ERROR.status();
			
			if(nextGenResponseWrapper != null)
			{
				if(nextGenResponseWrapper.getResponseCode() == 200)
				{
					statusStr = getRequestStatusStr(nextGenResponseWrapper);
		             
					/*if(nextGenResponseWrapper.getResponse().contains("Error") || nextGenResponseWrapper.getResponse().contains("ERROR"))
					{
						statusStr = com.eir.report.constant.Status.ERROR.status();
					}*/
				}
				cirRequest.setXmlOutput(nextGenResponseWrapper.getResponse().getBytes());
			}
			else
			{
				//statusStr = com.eir.report.constant.Status.ERROR.status();
				//cirRequest.setXmlOutput("NextGen response is null".getBytes());
				/*File f = new File("C:/Experian/EIR/getBusinessProductRespnse.xml");
				
				byte[] bytesArray = new byte[(int) f.length()];

				FileInputStream fis = new FileInputStream(f);
				fis.read(bytesArray); //read file into bytes[]
				cirRequest.setXmlOutput(bytesArray);
*/			}
			
			Status reqStatus = getStatusByDescription(statusStr);
			cirRequest.setStatus(reqStatus);
			logger.info("NextGenWebServiceImpl:createCIRReport() End");
			return cirRequestRepository.save(cirRequest);
		} catch (Exception e) {
			logger.error("NextGenWebServiceImpl:createCIRReport(), Nextgen service call fail: ", e);
		}
		return null;
	}

	private String getRequestStatusStr(NextGenResponseWrapper nextGenResponseWrapper )
			throws ParserConfigurationException, SAXException, IOException 
	{
		String statusStr = com.eir.report.constant.Status.ERROR.status();
		
		if(!nextGenResponseWrapper.getResponse().contains("BURERROR"))
		{
			statusStr = com.eir.report.constant.Status.COMPLETED.status();
		}
		return statusStr;
	}


	@Override
	public void createConsumerReport(List<ConsumerRequest> consumerEntityRequestList) 
	{
		logger.info("NextGenWebServiceImpl: - createConsumerReport() Start");
		try 
		{
			if(consumerEntityRequestList != null && !consumerEntityRequestList.isEmpty())
			{
				String statusStr = com.eir.report.constant.Status.ERROR.status();
				for(ConsumerRequest consumerEntityRequest: consumerEntityRequestList )
				{
					String consumerRequestXML = getConsumerRequestXML(consumerEntityRequest);
					NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(consumerRequestXML);
					//consumerEntityRequest.setStatusId(consumerReqStatusFailure);
					if(nextGenResponseWrapper != null)
					{
						if(nextGenResponseWrapper.getResponseCode() == 200)
						{
							statusStr = getRequestStatusStr(nextGenResponseWrapper);
						}
						consumerEntityRequest.setXmlOutput(nextGenResponseWrapper.getResponse().getBytes());
					}
					else
					{
						//consumerEntityRequest.setXmlOutput("NextGen response is null".getBytes());
						/*File f = new File("C:/Experian/EIR/getConsumerProductRespnse.xml");
						
						byte[] bytesArray = new byte[(int) f.length()];

						FileInputStream fis = new FileInputStream(f);
						fis.read(bytesArray); //read file into bytes[]
						consumerEntityRequest.setXmlOutput(bytesArray);
						 */
					}
					Status consumerReqStatusSuccess = getStatusByDescription(statusStr);
					consumerEntityRequest.setStatusId(consumerReqStatusSuccess);
					consumerRequetRepository.save(consumerEntityRequest);
				}
				logger.info("NextGenWebServiceImpl:createCIRReport() success End");
			}
		} catch (Exception e) {
			logger.error("NextGenWebServiceImpl:createCIRReport(), Nextgen service call fail: ", e);
		}
	}
	public Status getStatusByDescription(String statusDesc)
	{
		if(statusDesc != null && !statusDesc.isEmpty())
		{
			return statusRepository.findBystatusDescription(statusDesc);	
		}
		return null;
	}
	
	@Override
	public void getEIRReport(@RequestParam Integer requestId,@RequestParam String reportType)
	{
		if(requestId != null && reportType!= null && !reportType.isEmpty())
		{
			EIRDomain eirDomain = new EIRDomain();
			CreateReport  createReport = new CreateReport();
			
			if(reportType.equals(EIRDataConstant.EIR) || reportType.equals(EIRDataConstant.BIR))
			{
				BIRDomain birDomain = getBirReprot(requestId);
				eirDomain.setBirDomain(birDomain);
			}
			if(reportType.equals(EIRDataConstant.COMBOWITHSCORE) ||reportType.equals(EIRDataConstant.COMBOWITHOUTSCORE)|| 
					reportType.equals(EIRDataConstant.EIR) || reportType.equals(EIRDataConstant.CIRWITHSCORE) || 
					reportType.equals(EIRDataConstant.CIRWITHOUTSCORE))
			{
				ComboDomain comboDomain = getComboReport(requestId);
				eirDomain.setComboDomain(comboDomain);
			}
			
			createReport.generatestring(eirDomain, reportType);
			//return eirDomain;
		}
	}
	
	public BIRDomain getBirReprot(Integer requestId)
	{
		BIRDomain birDomain = null;
		
		return birDomain;
	}

	public ComboDomain getComboReport(Integer requestId)
	{
		CommercialReportDetails reportDetails = new CommercialReportDetails();
		ComboSummaryDomain summaryDetails = new ComboSummaryDomain();
		List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> responseInfoList = null;
		
		Request request =null;
		CirRequest cirRequest = null;
		List<ConsumerRequest> consumerRequests = null;
		 
		if(requestId != null)
		{
			request= requestRepository.findByRequestId(requestId);
			if(request != null)
			{
				 ComboDomain comboDomain= new ComboDomain();
				 cirRequest = request.getCirRequets();
				 if(cirRequest != null)
				 {
				    reportDetails = getCIRReport(cirRequest);
				    comboDomain.setReportDetails(reportDetails);
				 }
				 
				 consumerRequests = request.getConsumerRequets();
				 if(consumerRequests != null)
				 {
					responseInfoList = getConsumerReport(consumerRequests);
					comboDomain.setResponseInfoList(responseInfoList);
				 }
				 if(reportDetails != null && responseInfoList != null)
				 {
					summaryDetails = getSummaryDetails(reportDetails,responseInfoList);
					comboDomain.setSummaryDetails(summaryDetails);
				 }
				 return comboDomain;
			}
		}
		return null;
	}
	
	public ComboSummaryDomain getSummaryDetails(CommercialReportDetails cirReportDetails,
			List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> consumerReportDetailsList)
	{
		String pan = "";
		String dl = "";
		String ration = "";
		String passport = "";
		String aadhar = "";
		String voterId = "";
		String type = "";
		String account = "";
		
		ComboSummaryDomain summaryDetails = new ComboSummaryDomain();
		
		summaryDetails.setCompanyDetails(cirReportDetails.getCompanyDetails());
		//summaryDetails.setScoreCom(score.getScore());
		summaryDetails.setScoreCom(735);
        //Boolean check = piData.isDelphiScoreChk();
		boolean check = true;
        if(check)
        {
        	summaryDetails.setDelphiChck(1);
        }
        else
        {
        	summaryDetails.setDelphiChck(0);
        }
        
        if(consumerReportDetailsList != null && !consumerReportDetailsList.isEmpty())
        {
        	List<RelatedDirectorsDomain> relatedDirectorsDomainList = new ArrayList<RelatedDirectorsDomain>();
			for(ResponseInfo responseInfo: consumerReportDetailsList)
			{
				RelatedDirectorsDomain relatedDirectorsDomain = getConsumerSummaryDetilas(responseInfo.getConsumerResponse());
				
				if(responseInfo.getConsumerResponse() != null && responseInfo.getConsumerResponse().getNGINQUIRY() != null
						&& responseInfo.getConsumerResponse().getNGINQUIRY().getPerinput() != null)
				{
					relatedDirectorsDomain.setName(responseInfo.getConsumerResponse().getNGINQUIRY().getPerinput().getFirstGivenName() + " " +
							responseInfo.getConsumerResponse().getNGINQUIRY().getPerinput().getFamilyName());


					List<Perinpidc> perinpidcs = responseInfo.getConsumerResponse().getNGINQUIRY().getPerinput().getPerinpidc();	
					
					for(Perinpidc perinpidc: perinpidcs)
					{
						type = perinpidc.getIdNumberType();
						switch(type)
						{
						case "10":
									pan = perinpidc.getIndiaIdNumber();
							break;
						case "4":
									passport = perinpidc.getIndiaIdNumber();
							break;
						case "7":
									voterId = perinpidc.getIndiaIdNumber();
							break;
						case "1":
									dl = perinpidc.getIndiaIdNumber();
							break;
						case "11":
									ration = perinpidc.getIndiaIdNumber();
							break;
						case "12":
									aadhar = perinpidc.getIndiaIdNumber();
									
							break;
						case "19":
									account = perinpidc.getIndiaIdNumber();
							break;
						
						default:
							break;
							
						}
					}
					
					if(!pan.isEmpty())
					{
						relatedDirectorsDomain.setIdType("PAN");
						relatedDirectorsDomain.setIdNum(pan);
					}
					else if(!voterId.isEmpty())
					{
						relatedDirectorsDomain.setIdType("VOTER ID");
						relatedDirectorsDomain.setIdNum(voterId);
					}
					else if(!aadhar.isEmpty())
					{
						relatedDirectorsDomain.setIdType("UID");
						relatedDirectorsDomain.setIdNum(aadhar);
					}
					else if(!dl.isEmpty())
					{
						relatedDirectorsDomain.setIdType("D/L");
						relatedDirectorsDomain.setIdNum(dl);
					}
					else if(!ration.isEmpty())
					{
						relatedDirectorsDomain.setIdType("RATION CARD");
						relatedDirectorsDomain.setIdNum(ration);
					}
					else if(!account.isEmpty())
					{
						relatedDirectorsDomain.setIdType("ACCOUNT NUMBER");
						relatedDirectorsDomain.setIdNum(account);
					}
					
				}
				
				relatedDirectorsDomainList.add(relatedDirectorsDomain);
			}
			summaryDetails.setDirDomain(relatedDirectorsDomainList);
        }
		
		return summaryDetails;
	}
	
	private RelatedDirectorsDomain getConsumerSummaryDetilas(ConsumerResponse consumerResponse)
	{
		int modelScore = 0;
		int modelName = 0;
		int riskScore = 0;
		 
		RelatedDirectorsDomain relatedDirectorsDomain = new RelatedDirectorsDomain();
		if(consumerResponse.getPSUMMARY() != null && consumerResponse.getPSUMMARY().getCCATOTACCS() != null )
		{
			relatedDirectorsDomain.setAllAccts(consumerResponse.getPSUMMARY().getCCATOTACCS().getTotAccnts());
			relatedDirectorsDomain.setNoOfActAccts(consumerResponse.getPSUMMARY().getCCATOTACCS().getTotActiveAccnts());
		}
		
	   if(consumerResponse.getModelscr() != null )
	   {
		   String scoreCon = consumerResponse.getModelscr().getModelScoreValue(); 
		   try 
		   {
			   modelScore = Integer.parseInt(scoreCon);
		   } 
		   catch (NumberFormatException e) 
		   {
			   modelScore = 0;
		   }
		   
		   relatedDirectorsDomain.setScore(modelScore);
		   relatedDirectorsDomain.setConfScore(consumerResponse.getModelscr().getScoreConfLevel());
		   
		   String name = consumerResponse.getModelscr().getModelNameCd();
		  
		   if(name.equals("No Hit Scorecard"))
		   {
			   modelName = 0;
			  
		   }
		   else if(name.equals("Hit Scorecard"))
		   {
			   modelName = 1;
			   
		   }
		   relatedDirectorsDomain.setModelName(modelName);
		   
		   String risk = consumerResponse.getModelscr().getRiskGrading();
		   
		   if(risk != null)
		   {
			   try 
			   {
				   riskScore = Integer.parseInt(risk);
			   } 
			   catch (NumberFormatException e) 
			   {
					riskScore = 0;
			   }
		   }
			   
		   relatedDirectorsDomain.setRiskScore(riskScore);
	   }
		   
	   ArrayList<String> amount = getTotalAmt(consumerResponse.getConscred());
	   relatedDirectorsDomain.setTotSanctioned(amount.get(0));
	   relatedDirectorsDomain.setTotOutstanding(amount.get(1));
	   
	   ArrayList<String> delinqAcct = getNoActiveDelinquent(consumerResponse.getConscred());
	   relatedDirectorsDomain.setNoOfActDelinquent(delinqAcct.get(0));
	   relatedDirectorsDomain.setTotOutActDelinquent(delinqAcct.get(1));
		   
		return relatedDirectorsDomain;
	}
	
	
	private ArrayList<String> getTotalAmt(List<Conscred> conscredlist) 
	{
		long totSancAmt=0;
		long totOutAmt=0;
		
		ArrayList<String> amount = new ArrayList<String>();
		
		if (conscredlist != null && !conscredlist.isEmpty())
		{
			try 
			{
				for (Conscred conscred : conscredlist) 
				{
					
					String closeDate =  conscred.getAccountClosedDate();
		            if (StringUtils.isBlank(closeDate) ) 
		            {
		            	String accType = conscred.getAccountType();
		            	long highestCredit = Long.parseLong(conscred.getBpaygrid().get(0).getHDETAILS().getHighCreditAmt());
		            	long creditExtended =  Long.parseLong(conscred.getBpaygrid().get(0).getHDETAILS().getCreditExtendedAmt()); 
		            	
		            	if(accType.toLowerCase().contains("credit card") || accType.toLowerCase().contains("fleet"))
		            	{
		            		 if(highestCredit > 0 && creditExtended <= 0)
		            		 {
		            			 totSancAmt = totSancAmt + highestCredit ;
		            		 }
		            		 else if(highestCredit <= 0 && creditExtended > 0)
		            		 {
		            			 totSancAmt = totSancAmt + creditExtended ;
		            		 }
		            	}
		            	else
		            	{
		            		totSancAmt = totSancAmt + creditExtended ;
		            	}
		            	
						int cur = Integer.parseInt(conscred.getCurrentBalance()); 
						long curBal = Long.valueOf(cur); 
						totOutAmt = totOutAmt + curBal;
					}
				}
				amount.add(String.valueOf(totSancAmt));
				amount.add(String.valueOf(totOutAmt));
					 
				return amount ;       
			} 
			catch (Exception e) 
			{
					e.printStackTrace();
			}
		}
		
		amount.add("0");
		amount.add("0");
		
		return amount;
	}

	private ArrayList<String> getNoActiveDelinquent(List<Conscred> conscredlist) {
		
		long totalCount=0;
		long totalDelAmt = 0;
		
		ArrayList<String> delinq = new ArrayList<String>();
		if (conscredlist != null && !conscredlist.isEmpty())
		{
			try 
			{
				for (Conscred conscred : conscredlist) 
				{
					
					String closeDate =  conscred.getAccountClosedDate();
		            if (StringUtils.isBlank(closeDate) ) 
		            {
		            	long amount= getCount(conscred);
						if(amount != 0)
						{
						totalCount = totalCount + 1 ;
						totalDelAmt = totalDelAmt + amount;
						}
		            } 

				}
				
				delinq.add(String.valueOf(totalCount));
				delinq.add(String.valueOf(totalDelAmt));
				
				return delinq;       
			} 
			catch (Exception e) 
			{
					e.printStackTrace();
			}
		}
		delinq.add("0");
		delinq.add("0");
		
		return delinq;
	}
	
	private long getCount(Conscred conscred)
 	{
 		long totOutDelAmt = 0;

 		try
	 	{
 			String dt = convertDate(conscred.getAccountOpenDate());
 			Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dt);  
		 	SimpleDateFormat simpleDateFormat;
			
			simpleDateFormat = new SimpleDateFormat("MMM");
		    String month = simpleDateFormat.format(date).toUpperCase();
		    
		    simpleDateFormat = new SimpleDateFormat("yyyy");
		    String year = simpleDateFormat.format(date).toUpperCase();
		    
		    List<Bpaygrid> bpaygridList = (List<Bpaygrid>)conscred.getBpaygrid();
		    
			 for (Bpaygrid bpaygrid : bpaygridList)
			 {
				 String dpdMonth = bpaygrid.getMonthvalue().toUpperCase();
				 String dpdYear = bpaygrid.getYear().toUpperCase();
				 
				 if(month.equals(dpdMonth) && year.equals(dpdYear))
				 {
					 String countStr = bpaygrid.getDaysPastDue()!=null?bpaygrid.getDaysPastDue().toString():"0";
					 boolean deliquent = false;
					 if(countStr.matches("^[0-9]*$"))
					 {
						try 
						{
							if(Integer.parseInt(countStr) > 90)
					 		{	
								deliquent = true;
					 		}
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						deliquent = isDelinquentAccount(countStr);
					}
					 
					if(deliquent)
					{
						int cur = Integer.parseInt(conscred.getCurrentBalance()); 
						long curBal = Long.valueOf(cur); 
						totOutDelAmt = totOutDelAmt + curBal;
					}
					
			 		return totOutDelAmt;
			 	}
		 	}
	 	}
	 	catch (Exception e) 
	 	{
	 		e.printStackTrace();
	 	}
	
	 	return 0;

 	}
	
	private boolean isDelinquentAccount(String delStr)
 	{
 		delStr = delStr.trim().toUpperCase();
 		
 		if(delStr.equals("M") || delStr.equals("B") || delStr.equals("D") || delStr.equals("L"))
 		{
 			return true;
 		}
 		
 		return false;
 	}
	
	
	private String convertDate(String str) 
	{
		SimpleDateFormat format1 = new SimpleDateFormat("ddmmyyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yy");
		java.util.Date date;
		
		String newDate="";
		try
		{
			if(!(str.equals(""))||!(str.equals(null)))
			{
				date = format1.parse(str);
				newDate = format2.format(date);
			}
			else
			{
				return "";
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return newDate;
	}
	
}