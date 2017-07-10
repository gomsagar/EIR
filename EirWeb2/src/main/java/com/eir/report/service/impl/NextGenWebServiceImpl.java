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

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
import com.eir.model.bir.AllotmentOfNewEquityType;
import com.eir.model.bir.AllotmentType;
import com.eir.model.bir.BalanceSheetType;
import com.eir.model.bir.CashFlowDirectType;
import com.eir.model.bir.CashFlowInDirectType;
import com.eir.model.bir.CompanyReportType;
import com.eir.model.bir.FinancialRatios;
import com.eir.model.bir.IntangibleAssetsType;
import com.eir.model.bir.LawsuitType;
import com.eir.model.bir.LawsuitsType;
import com.eir.model.bir.ProfitAndLossType;
import com.eir.model.bir.SnapshotType;
import com.eir.report.constant.BIRReportConstant;
import com.eir.report.entity.BirRequest;
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
import com.eir.report.util.WriteFile;
import com.experian.nextgen.ind.model.consumer.uofpojo.Bpaygrid;
import com.experian.nextgen.ind.model.consumer.uofpojo.Conscred;
import com.experian.nextgen.ind.model.consumer.uofpojo.ConsumerResponse;
import com.experian.nextgen.ind.model.consumer.uofpojo.Perinpidc;
import com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo;

@Service
public class NextGenWebServiceImpl implements NextGenWebService{


	
	Logger logger = LoggerFactory.getLogger(NextGenWebServiceImpl.class);
	
	@Value("${outputXml.path}")
	private String xmlOutputPath;

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
							 /*byte[] reportXml = cirRequest.getXmlOutput();
							 ByteArrayInputStream in = new ByteArrayInputStream(reportXml);*/

							 String filePath = xmlOutputPath + Constant.SEPERATOR + cirRequest.getXmlOutputPath();
							 File fileOutput = new File(filePath);
							 ByteArrayInputStream in = new ByteArrayInputStream(FileUtils.readFileToByteArray(fileOutput));
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
							/*byte[] requestedConsXml = consumerRequest.getXmlOutput();
							ByteArrayInputStream bais = new ByteArrayInputStream(requestedConsXml);*/ //read file from folder instate of database
							 String filePath = xmlOutputPath + consumerRequest.getXmlOutputPath();
							 
							 File fileOutput = new File(filePath);
							 ByteArrayInputStream bais = new ByteArrayInputStream(FileUtils.readFileToByteArray(fileOutput));
								
							 
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
		
			//createXml(xmlString.toString());
			
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
		//userPref.setLanguage(consumerRequest.getLanguage());
		userPref.setLanguage("");
		consumerProductRequest.setUSERPREF(userPref);
		
		AddlProd addlProd = new AddlProd();
		//addlProd.setEnquiryAddOnProduct(consumerRequest.getEnquiryAddOnProduct());
		addlProd.setEnquiryAddOnProduct("");
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
		
		if(consumerRequest.getSuffix() != null)
		{
			srch.setSuffix(consumerRequest.getSuffix());	
		}
		else
		{
			srch.setSuffix("");
		}
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
		persAddr.setLocalityName(consumerRequest.getAddressId().getCity());
		persAddr.setRegionCode(consumerRequest.getAddressId().getState().toString());
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
			String statusStr = com.eir.report.constant.Status.ERROR.status();
			String cirRequestXML = getCIRRequestXML(cirRequest);
			NextGenResponseWrapper nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(cirRequestXML);
			
			if(getRequestStatusStr(nextGenResponseWrapper).equals(com.eir.report.constant.Status.ERROR.status()))
			{
				for (int i = 0; i < Constant.RETRY_COUNT; i++) 
				{
					nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(cirRequestXML);
					if(getRequestStatusStr(nextGenResponseWrapper).equals(com.eir.report.constant.Status.COMPLETED.status()))
					{
						break;
					}
				}
			}
			
			
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
				//cirRequest.setXmlOutput(nextGenResponseWrapper.getResponse().getBytes()); //commented reason -- writing into file
				//cirRequest.setXmlOutputPath(writeXmlOutputToFile(nextGenResponseWrapper.getResponse() , cirRequest.getRequest().getRequestId(), Constant.CIR));
				WriteFile writeFile = new WriteFile();
				String cirXMLOutPutFilePath = writeFile.writeXmlOutputToFile(xmlOutputPath, nextGenResponseWrapper.getResponse() , cirRequest.getRequest().getRequestId(), Constant.CIR);
				cirRequest.setXmlOutputPath(cirXMLOutPutFilePath);
			}
			else
			{
				//cirRequest.setXmlOutput("NextGen response is null".getBytes());
				
				//File f = new File("D:/BIReport/bir/6/getBusinessProductRespnse.xml");
				
				//byte[] bytesArray = new byte[(int) f.length()];
				
				//Integer xmlOutputFolderReqId = cirRequest.getRequest().getRequestId();
				//cirRequest.setXmlOutputPath(writeXmlOutputToFile(bytesArray.toString() , cirRequest.getRequest().getRequestId(), Constant.CIR));

				//FileInputStream fis = new FileInputStream(f); 
				//fis.read(bytesArray); //read file into bytes[]
				//cirRequest.setXmlOutput(bytesArray);
			}
			
			Status reqStatus = getStatusByDescription(statusStr);
			cirRequest.setStatus(reqStatus);
			logger.info("NextGenWebServiceImpl:createCIRReport() End");
			return cirRequestRepository.save(cirRequest);
		} catch (Exception e) {
			logger.error("NextGenWebServiceImpl:createCIRReport(), Nextgen service call fail: ", e);
		}
		return null;
	}

	/*private String writeXmlOutputToFile(String xmlOutputResponse,Integer xmlOutputFolderReqId, String reportType) 
	{
			//responceData write into file
		FileWriter fr = null;
		try 
		{
			String fileName = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.txt'").format(new Date());
			
			File file = new File(xmlOutputPath + Constant.SEPERATOR +  reportType + Constant.SEPERATOR  + xmlOutputFolderReqId + Constant.SEPERATOR + fileName);
			file.getParentFile().mkdirs();
			String writePath = file.getAbsolutePath();
            fr = new FileWriter(file);
            fr.write(xmlOutputResponse);
            return writePath;
	    } 
		catch (IOException e) 
		{
	          e.printStackTrace();
	    }
		finally
		{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //end write data here
		return null;
	}
	*/private String getRequestStatusStr(NextGenResponseWrapper nextGenResponseWrapper )
			throws ParserConfigurationException, SAXException, IOException 
	{
		String statusStr = com.eir.report.constant.Status.COMPLETED.status();
		
		if (nextGenResponseWrapper != null && nextGenResponseWrapper.getResponse() != null && !nextGenResponseWrapper.getResponse().isEmpty()) 
		{			
			if(nextGenResponseWrapper.getResponse().contains("BURERROR") || nextGenResponseWrapper.getResponse().contains("Error") 
					|| nextGenResponseWrapper.getResponse().contains("ERROR"))
			{
				statusStr = com.eir.report.constant.Status.ERROR.status();
			}
			
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
					
					if(getRequestStatusStr(nextGenResponseWrapper).equals(com.eir.report.constant.Status.ERROR.status()))
					{
						for (int i = 0; i < Constant.RETRY_COUNT; i++) 
						{
							nextGenResponseWrapper = experianHttDirectClient.getNextgenReport(consumerRequestXML);
							if(getRequestStatusStr(nextGenResponseWrapper).equals(com.eir.report.constant.Status.COMPLETED.status()))
							{
								break;
							}
						}
					}
					
					WriteFile writeFile = new WriteFile();
					if(nextGenResponseWrapper != null)
					{
						if(nextGenResponseWrapper.getResponseCode() == 200)
						{
							statusStr = getRequestStatusStr(nextGenResponseWrapper);
						}
						
						String consumerOutputXMLFilePath = writeFile.writeXmlOutputToFile(xmlOutputPath, nextGenResponseWrapper.getResponse(),consumerEntityRequest.getRequest().getRequestId(), Constant.CONSUMER);
						consumerEntityRequest.setXmlOutputPath(consumerOutputXMLFilePath);
						//consumerEntityRequest.setXmlOutputPath(writeXmlOutputToFile(nextGenResponseWrapper.getResponse(),consumerEntityRequest.getRequest().getRequestId(), Constant.CONSUMER));
					}
					else
					{
						//consumerEntityRequest.setXmlOutput("NextGen response is null".getBytes());
						//File f = new File("D:/BIReport/bir/6/getConsumerProductRespnse.xml");
						
						//byte[] bytesArray = new byte[(int) f.length()];
						//writeFile.writeXmlOutputToFile(xmlOutputPath, nextGenResponseWrapper.getResponse(),consumerEntityRequest.getRequest().getRequestId(), Constant.CONSUMER);
						//consumerEntityRequest.setXmlOutputPath(writeXmlOutputToFile(new String(bytesArray, "UTF-8"),consumerEntityRequest.getRequest().getRequestId(), Constant.CONSUMER));
						//FileInputStream fis = new FileInputStream(f);
						//fis.read(bytesArray); //read file into bytes[]
						//consumerEntityRequest.setXmlOutput(bytesArray);

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
	public String getEIRReport(@RequestParam Integer requestId,@RequestParam String reportType,@RequestParam Boolean isPdf)
	{
		if(requestId != null && reportType!= null && !reportType.isEmpty())
		{
			EIRDomain eirDomain = new EIRDomain();
			CreateReport  createReport = new CreateReport();
			Request request = null;
			BirRequest birRequest = null;
			
			if(reportType.equals(EIRDataConstant.EIR) || reportType.equals(EIRDataConstant.BIR))
			{
				request= requestRepository.findByRequestId(requestId);
				if(request != null)
				{
					 birRequest = request.getBirRequests();
					 if(birRequest != null)
					 {
						 CompanyReportType companyReportType = getBirReport(birRequest);
						 eirDomain.getBirDomain().setCompanyReportType(companyReportType);
					 }
				}
				
			}
			if(reportType.equals(EIRDataConstant.COMBOWITHSCORE) ||reportType.equals(EIRDataConstant.COMBOWITHOUTSCORE)|| 
					reportType.equals(EIRDataConstant.EIR) || reportType.equals(EIRDataConstant.CIRWITHSCORE) || 
					reportType.equals(EIRDataConstant.CIRWITHOUTSCORE))
			{
				ComboDomain comboDomain = getComboReport(requestId);
				eirDomain.setComboDomain(comboDomain);
			}
			
			return createReport.generatestring(eirDomain, reportType,isPdf);
			//return eirDomain;
		}
		return null;
	}
	
	public CompanyReportType getBirReport(BirRequest birRequest)
	{
		CompanyReportType companyReportType = null;
		try
		{
		if(birRequest.getStatus() != null)
		{
			String xmlStatus = birRequest.getStatus().getStatusDescription();
			 
			 if(com.eir.report.constant.Status.COMPLETED.status().equals(xmlStatus))
			 {
				//byte[] requestedBIRXml = birRequest.getXmlOutput();//commented reason -- get file path from database
				
				File fileOutput = new File(birRequest.getXmlOutputPath());
				ByteArrayInputStream bais = new ByteArrayInputStream(FileUtils.readFileToByteArray(fileOutput));
				
	            SOAPMessage message = MessageFactory.newInstance().createMessage(null, bais );
	            Unmarshaller unmarshaller = JAXBContext.newInstance(CompanyReportType.class).createUnmarshaller();
	            companyReportType = (CompanyReportType)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
	            
	            setAllTableMapping(companyReportType);
			 }
			 else
			 {
				 logger.debug("Report is in " + xmlStatus + " state.");
			 }
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return companyReportType;
	}
	
		private void setAllTableMapping(CompanyReportType companyReportType) 
	{
		if (companyReportType.getBalanceSheet() != null && companyReportType.getBalanceSheet().getSnapshotType() !=null && !companyReportType.getBalanceSheet().getSnapshotType().isEmpty() ) 
		{
			setBalanceSheetTable(companyReportType.getBalanceSheet());
		}
		if (companyReportType.getProfitAndLoss() != null && companyReportType.getProfitAndLoss().getSnapshot() !=null && !companyReportType.getProfitAndLoss().getSnapshot().isEmpty() ) 
		{
			setProfitAndLossTable(companyReportType.getProfitAndLoss());
		}
		if (companyReportType.getCashFlowDirect() != null && companyReportType.getCashFlowDirect().getSnapshot() !=null && !companyReportType.getCashFlowDirect().getSnapshot().isEmpty() ) 
		{
			setCashFlowDirectTable(companyReportType.getCashFlowDirect());
		}
		if (companyReportType.getCashFlowInDirect() != null && companyReportType.getCashFlowInDirect().getSnapshot() !=null && !companyReportType.getCashFlowInDirect().getSnapshot().isEmpty() ) 
		{
			setCashFlowInDirectTable(companyReportType.getCashFlowInDirect());
		}
		if (companyReportType.getIntangibleAssets() != null && companyReportType.getIntangibleAssets().getSnapshot() !=null && !companyReportType.getIntangibleAssets().getSnapshot().isEmpty() ) 
		{
			setIntangibleAssetsTable(companyReportType.getIntangibleAssets());
		}
		if (companyReportType.getAllotmentOfNewEquity() != null && companyReportType.getAllotmentOfNewEquity().getAllotment() !=null && !companyReportType.getAllotmentOfNewEquity().getAllotment().isEmpty() ) 
		{
			setAllotmentOfNewEquityTable(companyReportType.getAllotmentOfNewEquity());
		}
		if (companyReportType.getLawsuits() != null && companyReportType.getLawsuits().getLawsuit() !=null && !companyReportType.getLawsuits().getLawsuit().isEmpty() ) 
		{
			setLawsuitsTable(companyReportType.getLawsuits());
		}
		if (companyReportType.getFinacialRatios() != null && !companyReportType.getFinacialRatios().isEmpty() ) 
		{
			setFinacialRatiosTable(companyReportType.getFinacialRatios());
		}
				
	}

	private void setFinacialRatiosTable(List<FinancialRatios> finacialRatios) 
	{
		for (FinancialRatios finacialRatio : finacialRatios)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> finacialRatiosMap= new HashMap<String, ArrayList<String>>();
			if (finacialRatiosMap.containsKey(BIRReportConstant.FOR_THE_YEAR)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.FOR_THE_YEAR);
				pushDataList.add(finacialRatio.getAsOf().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getAsOf().toString());
				finacialRatiosMap.put(BIRReportConstant.FOR_THE_YEAR, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.CURRENT_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.CURRENT_RATIO);
				pushDataList.add(finacialRatio.getSolvencyRatios().getCurrentRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getSolvencyRatios().getCurrentRatio());
				finacialRatiosMap.put(BIRReportConstant.CURRENT_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.QUICK_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.QUICK_RATIO);
				pushDataList.add(finacialRatio.getSolvencyRatios().getQuickRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getSolvencyRatios().getQuickRatio());
				finacialRatiosMap.put(BIRReportConstant.QUICK_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.DEBT_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.DEBT_RATIO);
				pushDataList.add(finacialRatio.getLeverageRatios().getDebtRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getLeverageRatios().getDebtRatio());
				finacialRatiosMap.put(BIRReportConstant.DEBT_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.DEBT_EQUITY_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.DEBT_EQUITY_RATIO);
				pushDataList.add(finacialRatio.getLeverageRatios().getDebtEquityRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getLeverageRatios().getDebtRatio());
				finacialRatiosMap.put(BIRReportConstant.DEBT_EQUITY_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.CURRENT_LIABILITIES_TO_NETWORTH)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.CURRENT_LIABILITIES_TO_NETWORTH);
				pushDataList.add(finacialRatio.getLeverageRatios().getCurrentLiabilitiesToNetWorth());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getLeverageRatios().getCurrentLiabilitiesToNetWorth());
				finacialRatiosMap.put(BIRReportConstant.CURRENT_LIABILITIES_TO_NETWORTH, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.FIXED_ASSETS_TO_NETWORTH)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.FIXED_ASSETS_TO_NETWORTH);
				pushDataList.add(finacialRatio.getLeverageRatios().getFixedAssetsToNetWorth());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getLeverageRatios().getFixedAssetsToNetWorth());
				finacialRatiosMap.put(BIRReportConstant.FIXED_ASSETS_TO_NETWORTH, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.INTEREST_COVERAGE_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.INTEREST_COVERAGE_RATIO);
				pushDataList.add(finacialRatio.getLeverageRatios().getInterestCoverageRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getLeverageRatios().getInterestCoverageRatio());
				finacialRatiosMap.put(BIRReportConstant.INTEREST_COVERAGE_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.AVERAGE_COLLECTION_DAYS)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.AVERAGE_COLLECTION_DAYS);
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAverageCollectionDays());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAverageCollectionDays());
				finacialRatiosMap.put(BIRReportConstant.AVERAGE_COLLECTION_DAYS, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.ACCOUNT_RECEIVABLE_TURNOVER)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.ACCOUNT_RECEIVABLE_TURNOVER);
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAccountRecievableTurnover());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAccountRecievableTurnover());
				finacialRatiosMap.put(BIRReportConstant.ACCOUNT_RECEIVABLE_TURNOVER, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.AVERAGE_PAYMENT_DAYS)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.AVERAGE_PAYMENT_DAYS);
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAveragePaymentDays());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAveragePaymentDays());
				finacialRatiosMap.put(BIRReportConstant.AVERAGE_PAYMENT_DAYS, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.INVENTORY_TURNOVER_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.INVENTORY_TURNOVER_RATIO);
				pushDataList.add(finacialRatio.getEffeciencyRatios().getInventoryTurnoverRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getEffeciencyRatios().getInventoryTurnoverRatio());
				finacialRatiosMap.put(BIRReportConstant.INVENTORY_TURNOVER_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.ASSET_TURNOVER_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.ASSET_TURNOVER_RATIO);
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAssetTurnoverRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getEffeciencyRatios().getAssetTurnoverRatio());
				finacialRatiosMap.put(BIRReportConstant.ASSET_TURNOVER_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.PAT_TO_TOTAL_INCOME_RATIO)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.PAT_TO_TOTAL_INCOME_RATIO);
				pushDataList.add(finacialRatio.getProfitabilityRatios().getpATToTotalIncomeRatio());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getProfitabilityRatios().getpATToTotalIncomeRatio());
				finacialRatiosMap.put(BIRReportConstant.PAT_TO_TOTAL_INCOME_RATIO, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.NET_PROFIT_MARGIN)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.NET_PROFIT_MARGIN);
				pushDataList.add(finacialRatio.getProfitabilityRatios().getNetProfitMargin());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getProfitabilityRatios().getNetProfitMargin());
				finacialRatiosMap.put(BIRReportConstant.NET_PROFIT_MARGIN, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.RETURN_ON_ASSETS)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.RETURN_ON_ASSETS);
				pushDataList.add(finacialRatio.getProfitabilityRatios().getReturnOnAssets());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getProfitabilityRatios().getReturnOnAssets());
				finacialRatiosMap.put(BIRReportConstant.RETURN_ON_ASSETS, pushDataList);	
			}
			if (finacialRatiosMap.containsKey(BIRReportConstant.RETURN_ON_INVESTMENTS)) 
			{
				pushDataList = finacialRatiosMap.get(BIRReportConstant.RETURN_ON_INVESTMENTS);
				pushDataList.add(finacialRatio.getProfitabilityRatios().getReturnOnInvestments());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(finacialRatio.getProfitabilityRatios().getReturnOnInvestments());
				finacialRatiosMap.put(BIRReportConstant.RETURN_ON_INVESTMENTS, pushDataList);	
			}
			
		}
		
	}

	private void setLawsuitsTable(LawsuitsType lawsuits) 
	{
		List<LawsuitType> lawsuitsTypeList = lawsuits.getLawsuit();
		for (LawsuitType lawsuit : lawsuitsTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> lawsuitsMap= new HashMap<String, ArrayList<String>>();
			if (lawsuitsMap.containsKey(BIRReportConstant.STATE)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.STATE);
				pushDataList.add(lawsuit.getState());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(lawsuit.getState());
				lawsuitsMap.put(BIRReportConstant.STATE, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.DISTRICT)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.DISTRICT);
				pushDataList.add(lawsuit.getDistrict());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(lawsuit.getDistrict());
				lawsuitsMap.put(BIRReportConstant.DISTRICT, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.COURT)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.COURT);
				pushDataList.add(lawsuit.getCourt());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(lawsuit.getCourt());
				lawsuitsMap.put(BIRReportConstant.COURT, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.CASE_YEAR)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.CASE_YEAR);
				pushDataList.add(String.valueOf(lawsuit.getCaseYear()));
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(String.valueOf(lawsuit.getCaseYear()));
				lawsuitsMap.put(BIRReportConstant.CASE_YEAR, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.CASE_NO)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.CASE_NO);
				pushDataList.add(String.valueOf(lawsuit.getCaseNo()));
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(String.valueOf(lawsuit.getCaseNo()));
				lawsuitsMap.put(BIRReportConstant.CASE_NO, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.CASE_TYPE)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.CASE_TYPE);
				pushDataList.add(lawsuit.getCaseType());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(lawsuit.getCaseType());
				lawsuitsMap.put(BIRReportConstant.CASE_TYPE, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.PETITIONER)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.PETITIONER);
				pushDataList.add(lawsuit.getPetitioner());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(lawsuit.getPetitioner());
				lawsuitsMap.put(BIRReportConstant.PETITIONER, pushDataList);	
			}
			if (lawsuitsMap.containsKey(BIRReportConstant.RESPONDENT)) 
			{
				pushDataList = lawsuitsMap.get(BIRReportConstant.RESPONDENT);
				pushDataList.add(lawsuit.getRespondent());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(lawsuit.getRespondent());
				lawsuitsMap.put(BIRReportConstant.RESPONDENT, pushDataList);	
			}
			
		}
	}

	private void setAllotmentOfNewEquityTable(AllotmentOfNewEquityType allotmentOfNewEquityType) 
	{
		List<AllotmentType> allotmentTypeList = allotmentOfNewEquityType.getAllotment();
		for (AllotmentType allotment : allotmentTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> allotmentMap= new HashMap<String, ArrayList<String>>();
			if (allotmentMap.containsKey(BIRReportConstant.FOR_THE_YEAR)) 
			{
				pushDataList = allotmentMap.get(BIRReportConstant.FOR_THE_YEAR);
				pushDataList.add(allotment.getDateOfAllotment().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(allotment.getDateOfAllotment().toString());
				allotmentMap.put(BIRReportConstant.FOR_THE_YEAR, pushDataList);	
			}
			if (allotmentMap.containsKey(BIRReportConstant.ALLOTMENT_OF)) 
			{
				pushDataList = allotmentMap.get(BIRReportConstant.ALLOTMENT_OF);
				pushDataList.add(allotment.getAllotmentOf());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(allotment.getAllotmentOf());
				allotmentMap.put(BIRReportConstant.ALLOTMENT_OF, pushDataList);	
			}
			if (allotmentMap.containsKey(BIRReportConstant.PARTICULARS)) 
			{
				pushDataList = allotmentMap.get(BIRReportConstant.PARTICULARS);
				pushDataList.add(allotment.getParticulars());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(allotment.getParticulars());
				allotmentMap.put(BIRReportConstant.PARTICULARS, pushDataList);	
			}
			if (allotmentMap.containsKey(BIRReportConstant.NO_OF_SECURITY_ALLOTED)) 
			{
				pushDataList = allotmentMap.get(BIRReportConstant.NO_OF_SECURITY_ALLOTED);
				pushDataList.add(String.valueOf(allotment.getNumberOfSecuritiesAllotted()));
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(String.valueOf(allotment.getNumberOfSecuritiesAllotted()));
				allotmentMap.put(BIRReportConstant.NO_OF_SECURITY_ALLOTED, pushDataList);	
			}
			if (allotmentMap.containsKey(BIRReportConstant.NOMINAL_AMOUNT_PER_SECURITY)) 
			{
				pushDataList = allotmentMap.get(BIRReportConstant.NOMINAL_AMOUNT_PER_SECURITY);
				pushDataList.add(allotment.getNominalAmountPerSecurity().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(allotment.getNominalAmountPerSecurity().toString());
				allotmentMap.put(BIRReportConstant.NOMINAL_AMOUNT_PER_SECURITY, pushDataList);	
			}
			if (allotmentMap.containsKey(BIRReportConstant.PREMIUM_AMOUNT_PER_SECURITY)) 
			{
				pushDataList = allotmentMap.get(BIRReportConstant.PREMIUM_AMOUNT_PER_SECURITY);
				pushDataList.add(allotment.getPremiumAmountPerSecurity().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(allotment.getPremiumAmountPerSecurity().toString());
				allotmentMap.put(BIRReportConstant.PREMIUM_AMOUNT_PER_SECURITY, pushDataList);	
			}
			
		}
	}

	private void setIntangibleAssetsTable(IntangibleAssetsType intangibleAssets) 
	{
		List<SnapshotType> snapShotTypeList = intangibleAssets.getSnapshot();
		for (SnapshotType snapshotType : snapShotTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> snapShotMap= new HashMap<String, ArrayList<String>>();
			if (snapShotMap.containsKey(BIRReportConstant.FOR_THE_YEAR)) 
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FOR_THE_YEAR);
				pushDataList.add(snapshotType.getDataAsOf());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getDataAsOf());
				snapShotMap.put(BIRReportConstant.FOR_THE_YEAR, pushDataList);	
			}
			if(snapShotMap.containsKey(BIRReportConstant.COMPUTER_EQUIPMENTS_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.COMPUTER_EQUIPMENTS_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getComputerEquipmentsMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getComputerEquipmentsMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.COMPUTER_EQUIPMENTS_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OFFICE_EQUIPMENTS_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OFFICE_EQUIPMENTS_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getOfficeEquipmentsMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getOfficeEquipmentsMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.OFFICE_EQUIPMENTS_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.BUILDINGS_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.BUILDINGS_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getBuildingsMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getBuildingsMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.BUILDINGS_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.FURNITURE_AND_FIXERS_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FURNITURE_AND_FIXERS_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getFurnitureAndFixturesMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getFurnitureAndFixturesMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.FURNITURE_AND_FIXERS_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.LAND_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.LAND_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getLandMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getLandMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.LAND_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_TANGIBLE_ASSETS_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_TANGIBLE_ASSETS_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getOtherTangibleAssetsMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getOtherTangibleAssetsMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.OTHER_TANGIBLE_ASSETS_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.VEHICLES_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.VEHICLES_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getVehiclesMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getVehiclesMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.VEHICLES_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PLANT_AND_EQUIPMENT_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PLANT_AND_EQUIPMENT_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getPlantAndEquipmentMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getPlantAndEquipmentMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.PLANT_AND_EQUIPMENT_MEMBER, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.LEASEHOLD_IMPROVEMENTS_MEMBER))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.LEASEHOLD_IMPROVEMENTS_MEMBER);
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getLeaseholdImprovementsMember().getOwnedAssetsMember()))).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getDividebyLakh(Math.round(Double.parseDouble(snapshotType.getLeaseholdImprovementsMember().getOwnedAssetsMember()))).toString());
				snapShotMap.put(BIRReportConstant.LEASEHOLD_IMPROVEMENTS_MEMBER, pushDataList);				
			}
			
		}
	}

	private void setCashFlowInDirectTable(CashFlowInDirectType cashFlowInDirect) 
	{
		List<SnapshotType> snapShotTypeList = cashFlowInDirect.getSnapshot();
		for (SnapshotType snapshotType : snapShotTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> snapShotMap= new HashMap<String, ArrayList<String>>();
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_BEFORE_EXTRAORDINARY_ITEMS_AND_TAX))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_BEFORE_EXTRAORDINARY_ITEMS_AND_TAX);
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforeExtraordinaryItemsAndTax()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforeExtraordinaryItemsAndTax()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_BEFORE_EXTRAORDINARY_ITEMS_AND_TAX, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_FINANCE_COSTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_FINANCE_COSTS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForFinanceCosts()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForFinanceCosts()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_FINANCE_COSTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_DEPRECIATION_AND_AMORTISATION_EXPENSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_DEPRECIATION_AND_AMORTISATION_EXPENSE);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDepreciationAndAmortisationExpense()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDepreciationAndAmortisationExpense()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_DEPRECIATION_AND_AMORTISATION_EXPENSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_IMPAIRMENT_LOSS_REVERSAL_OF_IMPAIRMENT_LOSS_RECOGNISED_IN_PROFIT_OR_LOSS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_IMPAIRMENT_LOSS_REVERSAL_OF_IMPAIRMENT_LOSS_RECOGNISED_IN_PROFIT_OR_LOSS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForImpairmentLossReversalOfImpairmentLossRecognisedInProfitOrLoss()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForImpairmentLossReversalOfImpairmentLossRecognisedInProfitOrLoss()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_IMPAIRMENT_LOSS_REVERSAL_OF_IMPAIRMENT_LOSS_RECOGNISED_IN_PROFIT_OR_LOSS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_UNREALISED_FOREIGN_EXCHANGE_LOSSES_GAINS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_UNREALISED_FOREIGN_EXCHANGE_LOSSES_GAINS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForUnrealisedForeignExchangeLossesGains()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForUnrealisedForeignExchangeLossesGains()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_UNREALISED_FOREIGN_EXCHANGE_LOSSES_GAINS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_DIVIDEND_INCOME))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_DIVIDEND_INCOME);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDividendIncome()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDividendIncome()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_DIVIDEND_INCOME, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_SHAREBASED_PAYMENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_SHAREBASED_PAYMENTS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForSharebasedPayments()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForSharebasedPayments()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_SHAREBASED_PAYMENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_ADJUSTMENTS_FOR_WHICH_CASH_EFFECTS_ARE_INVESTING_OR_FINANCING_CASHFLOW))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_ADJUSTMENTS_FOR_WHICH_CASH_EFFECTS_ARE_INVESTING_OR_FINANCING_CASHFLOW);
				pushDataList.add(getReadyValue(snapshotType.getOtherAdjustmentsForWhichCashEffectsAreInvestingOrFinancingCashFlow()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherAdjustmentsForWhichCashEffectsAreInvestingOrFinancingCashFlow()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_ADJUSTMENTS_FOR_WHICH_CASH_EFFECTS_ARE_INVESTING_OR_FINANCING_CASHFLOW, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_ADJUSTMENTS_TO_RECONCILE_PROFIT_LOSS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_ADJUSTMENTS_TO_RECONCILE_PROFIT_LOSS);
				pushDataList.add(getReadyValue(snapshotType.getOtherAdjustmentsToReconcileProfitLoss()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherAdjustmentsToReconcileProfitLoss()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_ADJUSTMENTS_TO_RECONCILE_PROFIT_LOSS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_ADJUSTMENTS_FOR_NON_CASH_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_ADJUSTMENTS_FOR_NON_CASH_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getOtherAdjustmentsForNoncashItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherAdjustmentsForNoncashItems()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_ADJUSTMENTS_FOR_NON_CASH_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS);
				pushDataList.add(getReadyValue(snapshotType.getShareOfProfitAndLossFromPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShareOfProfitAndLossFromPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_TO_PROFIT_LOSS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_TO_PROFIT_LOSS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsToProfitLoss()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsToProfitLoss()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_TO_PROFIT_LOSS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_INVENTORIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_INVENTORIES);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInInventories()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInInventories()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_INVENTORIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_TRADE_PAYABLES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_TRADE_PAYABLES);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInTradeReceivables()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInTradeReceivables()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_TRADE_PAYABLES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_OTHER_CURRENT_AND_NONCURRENT_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_OTHER_CURRENT_AND_NONCURRENT_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInOtherCurrentAndNoncurrentAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInOtherCurrentAndNoncurrentAssets()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_OTHER_CURRENT_AND_NONCURRENT_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_OTHER_CURRENT_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_OTHER_CURRENT_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInOtherCurrentAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForDecreaseIncreaseInOtherCurrentAssets()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_DECREASE_INCREASE_IN_OTHER_CURRENT_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_TRADE_PAYABLES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_TRADE_PAYABLES);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForIncreaseDecreaseInTradePayables()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForIncreaseDecreaseInTradePayables()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_TRADE_PAYABLES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_OTHER_CURRENT_AND_NONCURRENT_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_OTHER_CURRENT_AND_NONCURRENT_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForIncreaseDecreaseInOtherCurrentAndNoncurrentLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForIncreaseDecreaseInOtherCurrentAndNoncurrentLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_OTHER_CURRENT_AND_NONCURRENT_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_OTHER_CURRENT_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_OTHER_CURRENT_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForIncreaseDecreaseInOtherCurrentLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForIncreaseDecreaseInOtherCurrentLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_INCREASE_DECREASE_IN_OTHER_CURRENT_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_PROVISIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_PROVISIONS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForProvisions()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForProvisions()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_PROVISIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_WORKING_CAPITAL))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_WORKING_CAPITAL);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForWorkingCapital()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForWorkingCapital()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_WORKING_CAPITAL, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ADJUSTMENTS_FOR_RECONCILE_PROFIT_LOSS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ADJUSTMENTS_FOR_RECONCILE_PROFIT_LOSS);
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForReconcileProfitLoss()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAdjustmentsForReconcileProfitLoss()).toString());
				snapShotMap.put(BIRReportConstant.ADJUSTMENTS_FOR_RECONCILE_PROFIT_LOSS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATIONS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperations()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperations()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivitiesBeforeExtraordinaryItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivitiesBeforeExtraordinaryItems()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_LOSING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_LOSING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromLosingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromLosingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_LOSING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_USED_IN_OBTAINING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_USED_IN_OBTAINING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsUsedInObtainingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsUsedInObtainingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_USED_IN_OBTAINING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS);
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromShareOfProfitsOfPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromShareOfProfitsOfPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_PAYMENT_FOR_INVESTMENT_IN_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_PAYMENT_FOR_INVESTMENT_IN_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS);
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentForInvestmentInPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentForInvestmentInPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
				snapShotMap.put(BIRReportConstant.CASH_PAYMENT_FOR_INVESTMENT_IN_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_SALES_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_SALES_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromSalesOfTangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromSalesOfTangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_SALES_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PURCHASE_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PURCHASE_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfTangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfTangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PURCHASE_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_SALES_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_SALES_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromSalesOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromSalesOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_SALES_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PURCHASE_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PURCHASE_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PURCHASE_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromRepaymentOfAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromRepaymentOfAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_PAYMENTS_FOR_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_PAYMENTS_FOR_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentsForFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentsForFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_PAYMENTS_FOR_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_GOVERNMENT_GRANTS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_GOVERNMENT_GRANTS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromGovernmentGrantsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromGovernmentGrantsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_GOVERNMENT_GRANTS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivitiesBeforeExtraordinaryItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivitiesBeforeExtraordinaryItems()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_ISSUING_SHARES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_ISSUING_SHARES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingShares()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingShares()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_ISSUING_SHARES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_ISSUING_OTHER_EQUITY_INSTRUMENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_ISSUING_OTHER_EQUITY_INSTRUMENTS);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingOtherEquityInstruments()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingOtherEquityInstruments()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_ISSUING_OTHER_EQUITY_INSTRUMENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_ISSUING_DEBENTURES_NOTES_BONDS_ETC))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_ISSUING_DEBENTURES_NOTES_BONDS_ETC);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingDebenturesNotesBondsEtc()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingDebenturesNotesBondsEtc()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_ISSUING_DEBENTURES_NOTES_BONDS_ETC, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromBorrowingsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromBorrowingsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.REPAYMENTS_OF_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REPAYMENTS_OF_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getRepaymentsOfBorrowingsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRepaymentsOfBorrowingsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.REPAYMENTS_OF_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DIVIDENDS_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DIVIDENDS_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getDividendsPaidClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDividendsPaidClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.DIVIDENDS_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_FINANCING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_FINANCING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivitiesBeforeExtraordinaryItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivitiesBeforeExtraordinaryItems()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_FINANCING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS_BEFORE_EFFECT_OF_EXCHANGE_RATE_CHANGES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS_BEFORE_EFFECT_OF_EXCHANGE_RATE_CHANGES);
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalentsBeforeEffectOfExchangeRateChanges()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalentsBeforeEffectOfExchangeRateChanges()).toString());
				snapShotMap.put(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS_BEFORE_EFFECT_OF_EXCHANGE_RATE_CHANGES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.EFFECT_OF_EXCHANGE_RATE_CHANGES_ON_CASH_AND_CASH_EQUIVALENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.EFFECT_OF_EXCHANGE_RATE_CHANGES_ON_CASH_AND_CASH_EQUIVALENTS);
				pushDataList.add(getReadyValue(snapshotType.getEffectOfExchangeRateChangesOnCashAndCashEquivalents()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getEffectOfExchangeRateChangesOnCashAndCashEquivalents()).toString());
				snapShotMap.put(BIRReportConstant.EFFECT_OF_EXCHANGE_RATE_CHANGES_ON_CASH_AND_CASH_EQUIVALENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS);
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalents()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalents()).toString());
				snapShotMap.put(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_EQUIVALENTS_CASHFLOW_STATEMENT))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_EQUIVALENTS_CASHFLOW_STATEMENT);
				pushDataList.add(getReadyValue(snapshotType.getCashAndCashEquivalentsCashFlowStatement()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashAndCashEquivalentsCashFlowStatement()).toString());
				snapShotMap.put(BIRReportConstant.CASH_EQUIVALENTS_CASHFLOW_STATEMENT, pushDataList);				
			}
			
		}
	}

	private void setCashFlowDirectTable(CashFlowDirectType cashFlowDirect) 
	{
		List<SnapshotType> snapShotTypeList = cashFlowDirect.getSnapshot();
		for (SnapshotType snapshotType : snapShotTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> snapShotMap= new HashMap<String, ArrayList<String>>();
			
			if (snapShotMap.containsKey(BIRReportConstant.FOR_THE_YEAR)) 
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FOR_THE_YEAR);
				pushDataList.add(snapshotType.getCashFlowAsOf().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getCashFlowAsOf().toString());
				snapShotMap.put(BIRReportConstant.FOR_THE_YEAR, pushDataList);	
			}
			if(snapShotMap.containsKey(BIRReportConstant.RECEIPTS_FROM_SALES_OF_GOODS_AND_RENDERING_OF_SERVICES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.RECEIPTS_FROM_SALES_OF_GOODS_AND_RENDERING_OF_SERVICES);
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromSalesOfGoodsAndRenderingOfServices()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromSalesOfGoodsAndRenderingOfServices()).toString());
				snapShotMap.put(BIRReportConstant.RECEIPTS_FROM_SALES_OF_GOODS_AND_RENDERING_OF_SERVICES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.RECEIPTS_FROM_ROYALTIES_FEES_COMMISSIONS_AND_OTHER_REVENUE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.RECEIPTS_FROM_ROYALTIES_FEES_COMMISSIONS_AND_OTHER_REVENUE);
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromRoyaltiesFeesCommissionsAndOtherRevenue()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromRoyaltiesFeesCommissionsAndOtherRevenue()).toString());
				snapShotMap.put(BIRReportConstant.RECEIPTS_FROM_ROYALTIES_FEES_COMMISSIONS_AND_OTHER_REVENUE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTIONS_CONTRACTS_AND_SWAP_CONTRACTS_HELD_FOR_DEALING_OR_TRADING_PURPOSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTIONS_CONTRACTS_AND_SWAP_CONTRACTS_HELD_FOR_DEALING_OR_TRADING_PURPOSE);
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromFutureContractsForwardContractsOptionsContractsAndSwapContractsHeldForDealingOrTradingPurpose()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromFutureContractsForwardContractsOptionsContractsAndSwapContractsHeldForDealingOrTradingPurpose()).toString());
				snapShotMap.put(BIRReportConstant.RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTIONS_CONTRACTS_AND_SWAP_CONTRACTS_HELD_FOR_DEALING_OR_TRADING_PURPOSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.RECEIPTS_FROM_PREMIUMS_AND_CLAIMS_ANNUITIES_AND_OTHER_POLICY_BENEFITS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.RECEIPTS_FROM_PREMIUMS_AND_CLAIMS_ANNUITIES_AND_OTHER_POLICY_BENEFITS);
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromPremiumsAndClaimsAnnuitiesAndOtherPolicyBenefits()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getReceiptsFromPremiumsAndClaimsAnnuitiesAndOtherPolicyBenefits()).toString());
				snapShotMap.put(BIRReportConstant.RECEIPTS_FROM_PREMIUMS_AND_CLAIMS_ANNUITIES_AND_OTHER_POLICY_BENEFITS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENTS_TO_SUPPLIERS_FOR_GOODS_AND_SERVICES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENTS_TO_SUPPLIERS_FOR_GOODS_AND_SERVICES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentsToSuppliersForGoodsAndServices()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentsToSuppliersForGoodsAndServices()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENTS_TO_SUPPLIERS_FOR_GOODS_AND_SERVICES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENTS_TO_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTIONS_CONTRACTS_AND_SWAP_CONTRACTS_HELD_FOR_DEALING_OR_TRADING_PURPOSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENTS_TO_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTIONS_CONTRACTS_AND_SWAP_CONTRACTS_HELD_FOR_DEALING_OR_TRADING_PURPOSE);
				pushDataList.add(getReadyValue(snapshotType.getPaymentsToFutureContractsForwardContractsOptionsContractsAndSwapContractsHeldForDealingOrTradingPurpose()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentsToFutureContractsForwardContractsOptionsContractsAndSwapContractsHeldForDealingOrTradingPurpose()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENTS_TO_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTIONS_CONTRACTS_AND_SWAP_CONTRACTS_HELD_FOR_DEALING_OR_TRADING_PURPOSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENTS_TO_AND_ON_BEHALF_OF_EMPLOYEES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENTS_TO_AND_ON_BEHALF_OF_EMPLOYEES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentsToAndOnBehalfOfEmployees()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentsToAndOnBehalfOfEmployees()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENTS_TO_AND_ON_BEHALF_OF_EMPLOYEES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENTS_FOR_PREMIUMS_AND_CLAIMS_ANNUITIES_AND_OTHER_POLICY_BENEFITS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENTS_FOR_PREMIUMS_AND_CLAIMS_ANNUITIES_AND_OTHER_POLICY_BENEFITS);
				pushDataList.add(getReadyValue(snapshotType.getPaymentsForPremiumsAndClaimsAnnuitiesAndOtherPolicyBenefits()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentsForPremiumsAndClaimsAnnuitiesAndOtherPolicyBenefits()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENTS_FOR_PREMIUMS_AND_CLAIMS_ANNUITIES_AND_OTHER_POLICY_BENEFITS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_PAYMENTS_FROM_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_PAYMENTS_FROM_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsFromOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsFromOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_PAYMENTS_FROM_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_FLOW_FROM_USED_IN_OPERATIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_FLOW_FROM_USED_IN_OPERATIONS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperations()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperations()).toString());
				snapShotMap.put(BIRReportConstant.CASH_FLOW_FROM_USED_IN_OPERATIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivitiesBeforeExtraordinaryItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivitiesBeforeExtraordinaryItems()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInOperatingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_OPERATING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_LOSING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_LOSING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromLosingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromLosingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_LOSING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_USED_IN_OBTAINING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_USED_IN_OBTAINING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsUsedInObtainingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsUsedInObtainingControlOfSubsidiariesOrOtherBusinessesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_USED_IN_OBTAINING_CONTROL_OF_SUBSIDIARIES_OR_OTHER_BUSINESSES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireEquityOrDebtInstrumentsOfOtherEntitiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashReceiptsFromSalesOfInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_RECEIPTS_FROM_SALES_OF_INTERESTS_IN_JOINT_VENTURES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCashPaymentsToAcquireInterestsInJointVenturesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CASH_PAYMENTS_TO_ACQUIRE_EQUITY_OR_DEBT_INSTRUMENTS_OF_OTHER_ENTITIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS);
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromShareOfProfitsOfPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromShareOfProfitsOfPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_SHARE_OF_PROFITS_OF_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_PAYMENT_FOR_INVESTMENT_IN_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_PAYMENT_FOR_INVESTMENT_IN_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS);
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentForInvestmentInPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentForInvestmentInPartnershipFirmOrAssociationOfPersonsOrLimitedLiabilityPartnerships()).toString());
				snapShotMap.put(BIRReportConstant.CASH_PAYMENT_FOR_INVESTMENT_IN_PARTNERSHIP_FIRM_OR_ASSOCIATION_OF_PERSONS_OR_LIMITED_LIABILITY_PARTNERSHIPS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PURCHASE_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PURCHASE_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfTangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfTangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PURCHASE_OF_TANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_SALES_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_SALES_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromSalesOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromSalesOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_SALES_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PURCHASE_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PURCHASE_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPurchaseOfIntangibleAssetsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PURCHASE_OF_INTANGIBLE_ASSETS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromRepaymentOfAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromRepaymentOfAdvancesAndLoansMadeToOtherPartiesClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_REPAYMENT_OF_ADVANCES_AND_LOANS_MADE_TO_OTHER_PARTIES_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_PAYMENTS_FOR_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_PAYMENTS_FOR_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentsForFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashPaymentsForFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_PAYMENTS_FOR_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashReceiptsFromFutureContractsForwardContractsOptionContractsAndSwapContractsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASH_RECEIPTS_FROM_FUTURE_CONTRACTS_FORWARD_CONTRACTS_OPTION_CONTRACTS_AND_SWAP_CONTRACTS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDividendsReceivedClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.DIVIDENDS_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestReceivedClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_RECEIVED_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_GOVERNMENT_GRANTS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_GOVERNMENT_GRANTS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromGovernmentGrantsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromGovernmentGrantsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_GOVERNMENT_GRANTS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivitiesBeforeExtraordinaryItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivitiesBeforeExtraordinaryItems()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getPaymentForExtraordinaryItemsClassifiedAsInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PAYMENT_FOR_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInInvestingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USED_IN_INVESTING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_ISSUING_SHARES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_ISSUING_SHARES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingShares()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingShares()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_ISSUING_SHARES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_ISSUING_OTHER_EQUITY_INSTRUMENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_ISSUING_OTHER_EQUITY_INSTRUMENTS);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingOtherEquityInstruments()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingOtherEquityInstruments()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_ISSUING_OTHER_EQUITY_INSTRUMENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_ISSUING_DEBENTURES_NOTES_BONDS_ETC))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_ISSUING_DEBENTURES_NOTES_BONDS_ETC);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingDebenturesNotesBondsEtc()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromIssuingDebenturesNotesBondsEtc()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_ISSUING_DEBENTURES_NOTES_BONDS_ETC, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromBorrowingsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromBorrowingsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.REPAYMENTS_OF_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REPAYMENTS_OF_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getRepaymentsOfBorrowingsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRepaymentsOfBorrowingsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.REPAYMENTS_OF_BORROWINGS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DIVIDENDS_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DIVIDENDS_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getDividendsPaidClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDividendsPaidClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.DIVIDENDS_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInterestPaidClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INTEREST_PAID_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncomeTaxesPaidRefundClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.INCOME_TAXES_PAID_REFUND_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherInflowsOutflowsOfCashClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INFLOWS_OUTFLOWS_OF_CASH_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivitiesBeforeExtraordinaryItems()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivitiesBeforeExtraordinaryItems()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProceedsFromExtraordinaryItemsClassifiedAsFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.PROCEEDS_FROM_EXTRAORDINARY_ITEMS_CLASSIFIED_AS_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES);
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashFlowsFromUsedInFinancingActivities()).toString());
				snapShotMap.put(BIRReportConstant.CASHFLOWS_FROM_USEDIN_FINANCING_ACTIVITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS_BEFORE_EFFECT_OF_EXCHANGE_RATE_CHANGES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS_BEFORE_EFFECT_OF_EXCHANGE_RATE_CHANGES);
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalentsBeforeEffectOfExchangeRateChanges()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalentsBeforeEffectOfExchangeRateChanges()).toString());
				snapShotMap.put(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS_BEFORE_EFFECT_OF_EXCHANGE_RATE_CHANGES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.EFFECT_OF_EXCHANGE_RATE_CHANGES_ON_CASH_AND_CASH_EQUIVALENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.EFFECT_OF_EXCHANGE_RATE_CHANGES_ON_CASH_AND_CASH_EQUIVALENTS);
				pushDataList.add(getReadyValue(snapshotType.getEffectOfExchangeRateChangesOnCashAndCashEquivalents()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getEffectOfExchangeRateChangesOnCashAndCashEquivalents()).toString());
				snapShotMap.put(BIRReportConstant.EFFECT_OF_EXCHANGE_RATE_CHANGES_ON_CASH_AND_CASH_EQUIVALENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS);
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalents()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIncreaseDecreaseInCashAndCashEquivalents()).toString());
				snapShotMap.put(BIRReportConstant.INCREASE_DECREASE_IN_CASH_AND_CASH_EQUIVALENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CASH_EQUIVALENTS_CASHFLOW_STATEMENT))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_EQUIVALENTS_CASHFLOW_STATEMENT);
				pushDataList.add(getReadyValue(snapshotType.getCashAndCashEquivalentsCashFlowStatement()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashAndCashEquivalentsCashFlowStatement()).toString());
				snapShotMap.put(BIRReportConstant.CASH_EQUIVALENTS_CASHFLOW_STATEMENT, pushDataList);				
			}
						
		}
	}

	private void setProfitAndLossTable(ProfitAndLossType profitAndLoss)
	{
		List<SnapshotType> snapShotTypeList = profitAndLoss.getSnapshot();
		for (SnapshotType snapshotType : snapShotTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> snapShotMap= new HashMap<String, ArrayList<String>>();
			
			if (snapShotMap.containsKey(BIRReportConstant.FOR_THE_YEAR)) 
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FOR_THE_YEAR);
				pushDataList.add(snapshotType.getProfitAndLossAsOf().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getProfitAndLossAsOf().toString());
				snapShotMap.put(BIRReportConstant.FOR_THE_YEAR, pushDataList);	
			}
			if(snapShotMap.containsKey(BIRReportConstant.REVENUE_FROM_SALE_OF_PRODUCTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REVENUE_FROM_SALE_OF_PRODUCTS);
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromSaleOfProducts()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromSaleOfProducts()).toString());
				snapShotMap.put(BIRReportConstant.REVENUE_FROM_SALE_OF_PRODUCTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.REVENUE_FROM_SALE_OF_SERVICES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REVENUE_FROM_SALE_OF_SERVICES);
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromSaleOfServices()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromSaleOfServices()).toString());
				snapShotMap.put(BIRReportConstant.REVENUE_FROM_SALE_OF_SERVICES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_OPERATING_REVENUES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_OPERATING_REVENUES);
				pushDataList.add(getReadyValue(snapshotType.getOtherOperatingRevenues()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherOperatingRevenues()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_OPERATING_REVENUES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.REVENUE_FROM_OPERATIONS_OTHER_THAN_FINANCE_COMPANY))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REVENUE_FROM_OPERATIONS_OTHER_THAN_FINANCE_COMPANY);
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromOperationsOtherThanFinanceCompany()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromOperationsOtherThanFinanceCompany()).toString());
				snapShotMap.put(BIRReportConstant.REVENUE_FROM_OPERATIONS_OTHER_THAN_FINANCE_COMPANY, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.REVENUE_FROM_OPERATIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REVENUE_FROM_OPERATIONS);
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromOperations()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRevenueFromOperations()).toString());
				snapShotMap.put(BIRReportConstant.REVENUE_FROM_OPERATIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_INCOME))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_INCOME);
				pushDataList.add(getReadyValue(snapshotType.getOtherIncome()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherIncome()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_INCOME, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.REVENUE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.REVENUE);
				pushDataList.add(getReadyValue(snapshotType.getRevenue()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getRevenue()).toString());
				snapShotMap.put(BIRReportConstant.REVENUE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.COST_OF_MATERIAL_CONSUMED))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.COST_OF_MATERIAL_CONSUMED);
				pushDataList.add(getReadyValue(snapshotType.getCostOfMaterialsConsumed()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCostOfMaterialsConsumed()).toString());
				snapShotMap.put(BIRReportConstant.COST_OF_MATERIAL_CONSUMED, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.EMPLOYEE_BENIFIT_EXPENSES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.EMPLOYEE_BENIFIT_EXPENSES);
				pushDataList.add(getReadyValue(snapshotType.getEmployeeBenefitExpense()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getEmployeeBenefitExpense()).toString());
				snapShotMap.put(BIRReportConstant.EMPLOYEE_BENIFIT_EXPENSES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_MANAGERIAL_REM))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_MANAGERIAL_REM);
				pushDataList.add(getReadyValue(snapshotType.getCurManagerialRem()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurManagerialRem()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_MANAGERIAL_REM, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_PAYMENT_AUDITORS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_PAYMENT_AUDITORS);
				pushDataList.add(getReadyValue(snapshotType.getCurPaymentAuditors()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurPaymentAuditors()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_PAYMENT_AUDITORS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_INSURANCE_EXPENSES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_INSURANCE_EXPENSES);
				pushDataList.add(getReadyValue(snapshotType.getCurInsuranceExp()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurInsuranceExp()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_INSURANCE_EXPENSES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.FINANCE_COSTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FINANCE_COSTS);
				pushDataList.add(getReadyValue(snapshotType.getFinanceCosts()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getFinanceCosts()).toString());
				snapShotMap.put(BIRReportConstant.FINANCE_COSTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DEPRECIATION_EXPENSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DEPRECIATION_EXPENSE);
				pushDataList.add(getReadyValue(snapshotType.getDepreciationExpense()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDepreciationExpense()).toString());
				snapShotMap.put(BIRReportConstant.DEPRECIATION_EXPENSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.AMORTISATION_EXPENSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.AMORTISATION_EXPENSE);
				pushDataList.add(getReadyValue(snapshotType.getAmortisationExpense()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAmortisationExpense()).toString());
				snapShotMap.put(BIRReportConstant.AMORTISATION_EXPENSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DEPRECIATION_DEPLETION_AND_AMORTISATION_EXPENSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DEPRECIATION_DEPLETION_AND_AMORTISATION_EXPENSE);
				pushDataList.add(getReadyValue(snapshotType.getDepreciationDepletionAndAmortisationExpense()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDepreciationDepletionAndAmortisationExpense()).toString());
				snapShotMap.put(BIRReportConstant.DEPRECIATION_DEPLETION_AND_AMORTISATION_EXPENSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_EXPENSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_EXPENSE);
				pushDataList.add(getReadyValue(snapshotType.getOtherExpenses()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherExpenses()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_EXPENSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.EXPENSES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.EXPENSES);
				pushDataList.add(getReadyValue(snapshotType.getExpenses()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getExpenses()).toString());
				snapShotMap.put(BIRReportConstant.EXPENSES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_BEFORE_PRIOR_PERIOD_ITEMS_EXCEPTIONAL_ITEMS_EXTRAORDINARY_ITEMS_AND_TAX))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_BEFORE_PRIOR_PERIOD_ITEMS_EXCEPTIONAL_ITEMS_EXTRAORDINARY_ITEMS_AND_TAX);
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforePriorPeriodItemsExceptionalItemsExtraordinaryItemsAndTax()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforePriorPeriodItemsExceptionalItemsExtraordinaryItemsAndTax()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_BEFORE_PRIOR_PERIOD_ITEMS_EXCEPTIONAL_ITEMS_EXTRAORDINARY_ITEMS_AND_TAX, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_BEFORE_EXTRAORDINARY_ITEMS_AND_TAX))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_BEFORE_EXTRAORDINARY_ITEMS_AND_TAX);
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforeExtraordinaryItemsAndTax()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforeExtraordinaryItemsAndTax()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_BEFORE_EXTRAORDINARY_ITEMS_AND_TAX, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_BEFORE_TAX))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_BEFORE_TAX);
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforeTax()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitBeforeTax()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_BEFORE_TAX, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_TAX))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_TAX);
				pushDataList.add(getReadyValue(snapshotType.getCurrentTax()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurrentTax()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_TAX, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DEFFERED_TAX))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DEFFERED_TAX);
				pushDataList.add(getReadyValue(snapshotType.getDeferredTax()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getDeferredTax()).toString());
				snapShotMap.put(BIRReportConstant.DEFFERED_TAX, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.TAX_EXPENSE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.TAX_EXPENSE);
				pushDataList.add(getReadyValue(snapshotType.getTaxExpense()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getTaxExpense()).toString());
				snapShotMap.put(BIRReportConstant.TAX_EXPENSE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD_FROM_CONTINUING_OPERATIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD_FROM_CONTINUING_OPERATIONS);
				pushDataList.add(getReadyValue(snapshotType.getProfitLossForPeriodFromContinuingOperations()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitLossForPeriodFromContinuingOperations()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD_FROM_CONTINUING_OPERATIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD_BEFORE_MINORITY_INTEREST))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD_BEFORE_MINORITY_INTEREST);
				pushDataList.add(getReadyValue(snapshotType.getProfitLossForPeriodBeforeMinorityInterest()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitLossForPeriodBeforeMinorityInterest()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD_BEFORE_MINORITY_INTEREST, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD);
				pushDataList.add(getReadyValue(snapshotType.getProfitLossForPeriod()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getProfitLossForPeriod()).toString());
				snapShotMap.put(BIRReportConstant.PROFIT_LOSS_FOR_PERIOD, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.BASIC_EARNING_PER_EQUITY_SHARE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.BASIC_EARNING_PER_EQUITY_SHARE);
				pushDataList.add(snapshotType.getBasicEarningPerEquityShare());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getBasicEarningPerEquityShare());
				snapShotMap.put(BIRReportConstant.BASIC_EARNING_PER_EQUITY_SHARE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DILUTED_EARNINGS_PER_EQUITY_SHARE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DILUTED_EARNINGS_PER_EQUITY_SHARE);
				pushDataList.add(snapshotType.getDilutedEarningsPerEquityShare());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getDilutedEarningsPerEquityShare());
				snapShotMap.put(BIRReportConstant.DILUTED_EARNINGS_PER_EQUITY_SHARE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.BASIC_EARNING_PER_EQUITY_SHARE_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.BASIC_EARNING_PER_EQUITY_SHARE_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(snapshotType.getBasicEarningPerEquityShareBeforeExtraordinaryItems());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getBasicEarningPerEquityShareBeforeExtraordinaryItems());
				snapShotMap.put(BIRReportConstant.BASIC_EARNING_PER_EQUITY_SHARE_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.DILUTED_EARNING_PER_EQUITY_SHARE_BEFORE_EXTRAORDINARY_ITEMS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.DILUTED_EARNING_PER_EQUITY_SHARE_BEFORE_EXTRAORDINARY_ITEMS);
				pushDataList.add(snapshotType.getDilutedEarningsPerEquityShareBeforeExtraordinaryItems());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getDilutedEarningsPerEquityShareBeforeExtraordinaryItems());
				snapShotMap.put(BIRReportConstant.DILUTED_EARNING_PER_EQUITY_SHARE_BEFORE_EXTRAORDINARY_ITEMS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.NOMINAL_VALUE_OF_PER_EQUITY_SHARE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.NOMINAL_VALUE_OF_PER_EQUITY_SHARE);
				pushDataList.add(snapshotType.getNominalValueOfPerEquityShare());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getNominalValueOfPerEquityShare());
				snapShotMap.put(BIRReportConstant.NOMINAL_VALUE_OF_PER_EQUITY_SHARE, pushDataList);				
			}
		}
	}

	private void setBalanceSheetTable(BalanceSheetType balanceSheet) 
	{

		List<SnapshotType> snapShotTypeList = balanceSheet.getSnapshotType();
		for (SnapshotType snapshotType : snapShotTypeList)
		{
			ArrayList<String> pushDataList = null;
			Map<String, ArrayList<String>> snapShotMap= new HashMap<String, ArrayList<String>>();
			
			if (snapShotMap.containsKey(BIRReportConstant.FOR_THE_YEAR)) 
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FOR_THE_YEAR);
				pushDataList.add(snapshotType.getBalanceSheetAsOf().toString());
			}
			else
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(snapshotType.getBalanceSheetAsOf().toString());
				snapShotMap.put(BIRReportConstant.FOR_THE_YEAR, pushDataList);	
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.SHARE_CAPITAL))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.SHARE_CAPITAL);
				pushDataList.add(getReadyValue(snapshotType.getShareCapital()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShareCapital()).toString());
				snapShotMap.put(BIRReportConstant.SHARE_CAPITAL, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.RESERVE_AND_SURPLUS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.RESERVE_AND_SURPLUS);
				pushDataList.add(getReadyValue(snapshotType.getReservesAndSurplus()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getReservesAndSurplus()).toString());
				snapShotMap.put(BIRReportConstant.RESERVE_AND_SURPLUS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.SHARE_HOLDERS_FUNDS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.SHARE_HOLDERS_FUNDS);
				pushDataList.add(getReadyValue(snapshotType.getShareholdersFunds()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShareholdersFunds()).toString());
				snapShotMap.put(BIRReportConstant.SHARE_HOLDERS_FUNDS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.SHARE_APPLICATION_MONEY))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.SHARE_APPLICATION_MONEY);
				pushDataList.add(getReadyValue(snapshotType.getShareApplicationMoneyPendingAllotment()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShareApplicationMoneyPendingAllotment()).toString());
				snapShotMap.put(BIRReportConstant.SHARE_APPLICATION_MONEY, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.MINORITY_INTEREST))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.MINORITY_INTEREST);
				pushDataList.add(getReadyValue(snapshotType.getMinorityInterest()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getMinorityInterest()).toString());
				snapShotMap.put(BIRReportConstant.MINORITY_INTEREST, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.LONG_TERM_BORROWINGS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.LONG_TERM_BORROWINGS);
				pushDataList.add(getReadyValue(snapshotType.getLongTermBorrowings()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getLongTermBorrowings()).toString());
				snapShotMap.put(BIRReportConstant.LONG_TERM_BORROWINGS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_LONG_TERM_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_LONG_TERM_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherLongTermLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherLongTermLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_LONG_TERM_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.LONG_TERM_PROVISIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.LONG_TERM_PROVISIONS);
				pushDataList.add(getReadyValue(snapshotType.getLongTermProvisions()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getLongTermProvisions()).toString());
				snapShotMap.put(BIRReportConstant.LONG_TERM_PROVISIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.NON_CURRENT_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.NON_CURRENT_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getNoncurrentLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getNoncurrentLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.NON_CURRENT_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.SHORT_TERM_BORROWINGS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.SHORT_TERM_BORROWINGS);
				pushDataList.add(getReadyValue(snapshotType.getShortTermBorrowings()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShortTermBorrowings()).toString());
				snapShotMap.put(BIRReportConstant.SHORT_TERM_BORROWINGS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.TRADE_PAYABLES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.TRADE_PAYABLES);
				pushDataList.add(getReadyValue(snapshotType.getTradePayables()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getTradePayables()).toString());
				snapShotMap.put(BIRReportConstant.TRADE_PAYABLES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CURRENT_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CURRENT_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getOtherCurrentLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCurrentLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CURRENT_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.SHORT_TERM_PROVISIONS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.SHORT_TERM_PROVISIONS);
				pushDataList.add(getReadyValue(snapshotType.getShortTermProvisions()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShortTermProvisions()).toString());
				snapShotMap.put(BIRReportConstant.SHORT_TERM_PROVISIONS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getCurrentLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurrentLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.EQUITY_AND_LIABILITIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.EQUITY_AND_LIABILITIES);
				pushDataList.add(getReadyValue(snapshotType.getEquityAndLiabilities()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getEquityAndLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.EQUITY_AND_LIABILITIES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.TANGIBLE_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.TANGIBLE_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getTangibleAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherLongTermLiabilities()).toString());
				snapShotMap.put(BIRReportConstant.TANGIBLE_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.INTANGIBLE_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INTANGIBLE_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getIntangibleAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getIntangibleAssets()).toString());
				snapShotMap.put(BIRReportConstant.INTANGIBLE_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.TANGIBLE_ASSETS_CAPITAL_WORK_IN_PROGRESS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.TANGIBLE_ASSETS_CAPITAL_WORK_IN_PROGRESS);
				pushDataList.add(getReadyValue(snapshotType.getTangibleAssetsCapitalWorkInProgress()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getTangibleAssetsCapitalWorkInProgress()).toString());
				snapShotMap.put(BIRReportConstant.TANGIBLE_ASSETS_CAPITAL_WORK_IN_PROGRESS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.FIXED_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.FIXED_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getFixedAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getFixedAssets()).toString());
				snapShotMap.put(BIRReportConstant.FIXED_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.NON_CURRENT_INVESTMENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.NON_CURRENT_INVESTMENTS);
				pushDataList.add(getReadyValue(snapshotType.getNoncurrentInvestments()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getNoncurrentInvestments()).toString());
				snapShotMap.put(BIRReportConstant.NON_CURRENT_INVESTMENTS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.LONG_TERM_LOANS_AND_ADVANCE))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.LONG_TERM_LOANS_AND_ADVANCE);
				pushDataList.add(getReadyValue(snapshotType.getLongTermLoansAndAdvances()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getLongTermLoansAndAdvances()).toString());
				snapShotMap.put(BIRReportConstant.LONG_TERM_LOANS_AND_ADVANCE, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_NON_CURRENT_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_NON_CURRENT_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getOtherNoncurrentAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherNoncurrentAssets()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_NON_CURRENT_ASSETS, pushDataList);				
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.NON_CURRENT_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.NON_CURRENT_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getNoncurrentAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getNoncurrentAssets()).toString());
				snapShotMap.put(BIRReportConstant.NON_CURRENT_ASSETS, pushDataList);				
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_INVESTMENTS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_INVESTMENTS);
				pushDataList.add(getReadyValue(snapshotType.getCurrentInvestments()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurrentInvestments()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_INVESTMENTS, pushDataList);				
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.INVENTORIES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.INVENTORIES);
				pushDataList.add(getReadyValue(snapshotType.getInventories()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getInventories()).toString());
				snapShotMap.put(BIRReportConstant.INVENTORIES, pushDataList);				
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.TRADE_RECEIVABLES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.TRADE_RECEIVABLES);
				pushDataList.add(getReadyValue(snapshotType.getTradeReceivables()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getTradeReceivables()).toString());
				snapShotMap.put(BIRReportConstant.TRADE_RECEIVABLES, pushDataList);				
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.CASH_AND_BANK_BALANCES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CASH_AND_BANK_BALANCES);
				pushDataList.add(getReadyValue(snapshotType.getCashAndBankBalances()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCashAndBankBalances()).toString());
				snapShotMap.put(BIRReportConstant.CASH_AND_BANK_BALANCES, pushDataList);				
			}
			
			if(snapShotMap.containsKey(BIRReportConstant.SHORT_TERM_LOANS_AND_ADVANCES))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.SHORT_TERM_LOANS_AND_ADVANCES);
				pushDataList.add(getReadyValue(snapshotType.getShortTermLoansAndAdvances()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getShortTermLoansAndAdvances()).toString());
				snapShotMap.put(BIRReportConstant.SHORT_TERM_LOANS_AND_ADVANCES, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.OTHER_CURRENT_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.OTHER_CURRENT_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getOtherCurrentAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getOtherCurrentAssets()).toString());
				snapShotMap.put(BIRReportConstant.OTHER_CURRENT_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.CURRENT_ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.CURRENT_ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getCurrentAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getCurrentAssets()).toString());
				snapShotMap.put(BIRReportConstant.CURRENT_ASSETS, pushDataList);				
			}
			if(snapShotMap.containsKey(BIRReportConstant.ASSETS))
			{
				pushDataList = snapShotMap.get(BIRReportConstant.ASSETS);
				pushDataList.add(getReadyValue(snapshotType.getAssets()).toString());
			}
			else 
			{
				pushDataList = new ArrayList<>();
				pushDataList.add(getReadyValue(snapshotType.getAssets()).toString());
				snapShotMap.put(BIRReportConstant.ASSETS, pushDataList);				
			}				
		}		
	
	}

	private Long getReadyValue(String str)
	{
		Long val = getDividebyLakh(Math.round(Double.parseDouble(str)));
		return val;
	}
	private Long getDividebyLakh(Long val)
	{
		Long updatedVal = val/1000;
		return updatedVal;
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
				 if(consumerRequests != null && !consumerRequests.isEmpty())
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
		long highestCredit = 0;
		long creditExtended = 0;
		
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
			            	if((!conscred.getBpaygrid().get(0).getHDETAILS().getHighCreditAmt().equals("") && !conscred.getBpaygrid().get(0).getHDETAILS().getHighCreditAmt().equals(null)) )
				            {
				            	 highestCredit = Long.parseLong(conscred.getBpaygrid().get(0).getHDETAILS().getHighCreditAmt());
				            	
				            }
			            	if(!conscred.getBpaygrid().get(0).getHDETAILS().getCreditExtendedAmt().equals("") && !conscred.getBpaygrid().get(0).getHDETAILS().getCreditExtendedAmt().equals(null))
			            	{
			            		 creditExtended =  Long.parseLong(conscred.getBpaygrid().get(0).getHDETAILS().getCreditExtendedAmt()); 
			            	}	
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
					   amount.add(String.valueOf(totSancAmt));
					   amount.add(String.valueOf(totOutAmt));
							 
					   return amount ;     
					}
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