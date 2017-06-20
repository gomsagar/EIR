package com.eir.report.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eir.bir.request.model.CirRequest;
import com.eir.bir.request.model.Consumer;
import com.eir.report.entity.ConsumerRequest;
import com.eir.report.entity.Request;
import com.eir.report.entity.Status;
import com.eir.report.exception.NextGenCallException;
import com.eir.report.nextgen.service.client.ExperianHttpDirectClient;
import com.eir.report.nextgen.service.client.NextGenResponseWrapper;
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
import com.eir.report.repository.StatusRepository;
import com.eir.report.service.NextGenWebService;

@Service
public class NextGenWebServiceImpl implements NextGenWebService{

	Logger logger = LoggerFactory.getLogger(NextGenWebServiceImpl.class);

	ExperianHttpDirectClient experianHttDirectClient;
	
	public NextGenWebServiceImpl()
	{
		experianHttDirectClient = new ExperianHttpDirectClient();
	}
	
	@Autowired
	CirRequestRepository cirRequestRepository;
	
	@Autowired
	ConsumerRequetRepository consumerRequetRepository; 
	
	@Autowired
	StatusRepository statusRepository;
	
	@Override
	public void getCIRReport()
	{
		logger.info("NextGenWebServiceImpl: - getCIRReport()");
		
		try {
			//NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(getCIRRequestXML());
			
			//Save nextGenResponseWrapper to db
			
		} catch (Exception e) {
			logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
		}
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
		param.setPurpose(cirRequest.getPurposeId().toString());
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
		
		com.eir.report.nextgen.service.model.product.BusnesAcct e = new com.eir.report.nextgen.service.model.product.BusnesAcct();
		e.setBankAccountNumber("");
		businessProductRequest.getBUSNESACCT().add(e);
		com.eir.report.nextgen.service.model.product.AddlProd addlProd = new com.eir.report.nextgen.service.model.product.AddlProd();
		addlProd.setEnquiryAddOnProduct(cirRequest.getEnquiryAddProduct());
		businessProductRequest.getADDLPROD().add(addlProd);
		
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
		busAddr.setAddrType(cirRequest.getAddress().getAddressType().getAddressTypeId().toString());
		busAddr.setCountryCode("IND");
		busAddr.setCity(cirRequest.getAddress().getCity());
		busAddr.setState(cirRequest.getAddress().getState().toString());
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
	
	@Override
	public void getConsumerReport()
	{
		logger.info("NextGenWebServiceImpl: - getCIRReport()");
		
		/*try {
			NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(getConsumerRequestXML());
			
			//Save nextGenResponseWrapper to db
			
		} catch (IOException e) {
			logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
		} catch (NextGenCallException e) {
			logger.error("NextGenWebServiceImpl:getCIRReport(), Nextgen service call fail:  ", e);
		}*/
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
		
			return xmlString.toString(); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private GetConsumerProductRequest getConsumerRequestObj(ConsumerRequest consumerRequest)
	{
		com.eir.report.nextgen.service.model.consumer.ObjectFactory objectFactory = new com.eir.report.nextgen.service.model.consumer.ObjectFactory();
		GetConsumerProductRequest consumerProductRequest = objectFactory.createGetConsumerProductRequest();
		consumerProductRequest.setSTARTENQ("START");
		EnqHeader enqHeader = new EnqHeader();
		enqHeader.setClientEnquiryRefNumber(consumerRequest.getClientEnquiryRefNumber());
		enqHeader.setBureauMemberId(consumerRequest.getBureauMemberId().toString());
		enqHeader.setPurposeOfInquiry(consumerRequest.getPurposeOfInquiry().toString());
		enqHeader.setPurpose(consumerRequest.getPurposeId().toString());
		enqHeader.setProduct(consumerRequest.getProductField());
		enqHeader.setSearchType(consumerRequest.getSearchType());
		enqHeader.setEnquiryApplicationType(consumerRequest.getEnquiryApplicationType());
		enqHeader.setEnquiryAccountType(consumerRequest.getEnquiryAccountType());
		enqHeader.setEnquiryAmtMonetaryType(consumerRequest.getEnquiryAmtMonetaryType());
		enqHeader.setEnquiryAmount(consumerRequest.getEnquiryAmount());
		enqHeader.setEnquiryCreditPurpose(consumerRequest.getEnquiryCreditPurpose());
		enqHeader.setDurationofAgreement(consumerRequest.getDurationOfAgreement());
		enqHeader.setFrequency(consumerRequest.getFrequencyId());
		consumerProductRequest.setENQHEADER(enqHeader);
		
		UserPref userPref = new UserPref();
		userPref.setLanguage(consumerRequest.getLanguage());
		consumerProductRequest.setUSERPREF(userPref);
		
		AddlProd addlProd = new AddlProd();
		addlProd.setEnquiryAddOnProduct(consumerRequest.getEnquiryAddOnProduct());
		consumerProductRequest.getADDLPROD().add(addlProd);
		
		
		
		List<PrsnSrch> prsnsrchList = new ArrayList<>();
		PrsnSrch srch = new PrsnSrch();
		srch.setFirstGivenName(consumerRequest.getFirstName());
		srch.setMiddleName(consumerRequest.getMiddleName());
		srch.setOtherMiddleNames(consumerRequest.getOtherMiddleNames());
		srch.setFamilyName(consumerRequest.getFamilyName());
		srch.setSuffix(consumerRequest.getSuffix());
		srch.setApplicationRole(consumerRequest.getApplicationRole());
		srch.setDateOfBirth(consumerRequest.getDateOfBirth().toString());
		srch.setGender(consumerRequest.getGender().toString());
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
		personId.setIdNumberType(consumerRequest.getIdNumberType());
		personId.setIdNumber(consumerRequest.getIdNumber());
		personidList.add(personId);
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
		persPhone.setPhoneNumber(consumerRequest.getPhoneNumber());
		persPhone.setPhoneType(consumerRequest.getPhoneType().toString());
		List<com.eir.report.nextgen.service.model.consumer.PersPhone> phoneList = new ArrayList<>();
		phoneList.add(persPhone);
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
		persDetail.setPovertyIndex(consumerRequest.getPovertyIndex().toString());
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
			
			Status cirReqStatus = getStatusByDescription(com.eir.report.constant.Status.ERROR.toString());
			
			if(nextGenResponseWrapper != null)
			{
				if(nextGenResponseWrapper.getResponseCode() == 200)
				{
					//unmarshling code to get the response, whether it is business exception of connection error
					boolean isFailed = true;
					
					if(!isFailed)
					{
						cirReqStatus = getStatusByDescription(com.eir.report.constant.Status.COMPLETED.toString());
					}
					
				}
				cirRequest.setXmlOutput(nextGenResponseWrapper.getResponse().getBytes());
			}
			else
			{
				cirRequest.setXmlOutput("NextGen response is null".getBytes());
			}
			
			cirRequest.setStatus(cirReqStatus);
			logger.info("NextGenWebServiceImpl:createCIRReport() success End");
			return cirRequestRepository.save(cirRequest);
		} catch (Exception e) {
			logger.error("NextGenWebServiceImpl:createCIRReport(), Nextgen service call fail: ", e);
		}
		return null;
	}


	@Override
	public void createConsumerReport(List<ConsumerRequest> consumerEntityRequestList) 
	{
		logger.info("NextGenWebServiceImpl: - createConsumerReport() Start");
		try 
		{
			if(consumerEntityRequestList != null && !consumerEntityRequestList.isEmpty())
			{
				Status consumerReqStatusSuccess = getStatusByDescription(com.eir.report.constant.Status.COMPLETED.toString());
				Status consumerReqStatusFailure = getStatusByDescription(com.eir.report.constant.Status.ERROR.toString());
				
				for(ConsumerRequest consumerEntityRequest: consumerEntityRequestList )
				{
					String consumerRequestXML = getConsumerRequestXML(consumerEntityRequest);
					NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(consumerRequestXML);
					consumerEntityRequest.setStatusId(consumerReqStatusFailure);
					if(nextGenResponseWrapper != null)
					{
						if(nextGenResponseWrapper.getResponseCode() == 200)
						{
							//unmarshling code to get the response, whether it is business exception of connection error
							boolean isFailed = true;
							
							if(!isFailed)
							{
								consumerEntityRequest.setStatusId(consumerReqStatusSuccess);
							}
						}
						consumerEntityRequest.setXmlOutput(nextGenResponseWrapper.getResponse().getBytes());
					}
					else
					{
						consumerEntityRequest.setXmlOutput("NextGen response is null".getBytes());
					}
					
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
}