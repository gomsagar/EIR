package com.eir.report.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.eir.model.EIRDataConstant;
import com.eir.model.EligibleReport;
import com.eir.model.bir.CompanyReportType;
import com.eir.model.bir.report.CalculateScore;
import com.eir.report.constant.Constant;
import com.eir.report.entity.Address;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.CompanyList;
import com.eir.report.entity.ConsumerRequet;
import com.eir.report.entity.MemberProductMapping;
import com.eir.bir.request.model.ConsumerList;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.report.entity.ReportSelection;
import com.eir.report.entity.Response;
import com.eir.report.repository.AddressRepository;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.CirRequestRepository;
import com.eir.report.repository.ConsumerRequetRepository;
import com.eir.report.repository.MemberProductMappingRepository;
import com.eir.report.repository.ProductRepository;
import com.eir.report.repository.ReportSelectionRepository;
import com.eir.report.repository.StatusRepository;
import com.eir.report.service.BirReportService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@PropertySource("classpath:zaubaConfig.properties")
public class BirReportServiceImpl implements BirReportService {
	
	
	@Value("${application.ID}")
	private String applicationID1;

	@Value("${access.key}")
	private String key;

	@Value("${secret.value}")
	private String secretValue;

	@Value("${trustStore.value}")
	private String trustStore;

	@Value("${jks.path}")
	private String jksPath;

	@Value("${accessTocken.url}")
	private String accessTockenURL;

	@Value("${strict.Search}")
	private String strictSearch;

	@Value("${company.search.url}")
	private String companySearchURL;

	@Value("${request.report.url}")
	private String reqReportURL;

	@Value("${report.url}")
	private String reportURL;
	
	Logger logger = LoggerFactory.getLogger(BirReportServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	BirRequestRepository birReqRepository;
	
	@Autowired
	CirRequestRepository cirReqRepository;
	
	@Autowired
	MemberProductMappingRepository memberProductMappingRepo;
	
	@Autowired
	StatusRepository statusrepository;
	
	@Autowired
	ReportSelectionRepository reportSelectionRepository;
	
	@Autowired
	ConsumerRequetRepository consumerListRepository;
	
	@Autowired
	AddressRepository addressRepository;
		
	CloseableHttpResponse httpResponse = null;
	HttpEntity entity = null;
	static Unmarshaller unmarsh = null;
	private CloseableHttpClient httpclient;
	private BasicCookieStore cookieStore;
	CompanyReportType bipr = null;
	static JAXBContext jc = null;

	public BirReportServiceImpl() {
		cookieStore = new BasicCookieStore();
		httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

	}

	public String callZaubaApplication(String url, List<BasicNameValuePair> params) 
	{
		logger.debug("BirReportServiceImpl callZaubaApplication()");
		
		System.setProperty(trustStore, jksPath);
		HttpPost httpost = new HttpPost(url);
		String responseString = null;
		try {
			httpost.setEntity(new UrlEncodedFormEntity(params));
			// ------ Execute URL with encoded form -------//
			httpResponse = httpclient.execute(httpost);
			entity = httpResponse.getEntity();

			if (entity == null) {
				logger.debug("Get Case Type - Empty Response Received");
			} else {
				responseString = EntityUtils.toString(entity, "UTF-8");

				if (responseString.contains("Invalid")) {
					logger.debug("Invalid Access Token Used. Sending Request for new Access Token Again...");
					System.out.println("Invalid Access Token Used. Sending Request for new Access Token Again...");
					getAccessToken();
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				httpResponse.close();
				httpost.releaseConnection();
				httpost = null;
			} catch (IOException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}
		return responseString;
	}

	@Override
	public String getAccessToken() {
		
		logger.debug("BirReportServiceImpl getAccessToken()");

		String access_token = null;

		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(); // List created for adding post parameters to url
																				
		params.add(new BasicNameValuePair("ClientKey", key)); // added post parameters in url
		params.add(new BasicNameValuePair("ClientSecret", secretValue));

		String respoceobj = callZaubaApplication(accessTockenURL, params);

		JSONObject json = new JSONObject(respoceobj);
		access_token = (String) json.get("AccessToken");
		
		logger.debug("Access Token is : "+ access_token);
		System.out.println("Access Token is " + access_token);

		return access_token;
	}

	@Override
	public List<Response> companySearch(String companyName) {
		
		logger.debug("BirReportServiceImpl companySearch()");

		// one more parameter will come here from jsp which is company name.
		String cinNew = null;
		JSONArray array = new JSONArray();
		CompanyList list = null;
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("AccessToken", getAccessToken())); // added post parameters in url
																				
		params.add(new BasicNameValuePair("Name", companyName));
		params.add(new BasicNameValuePair("StrictSearch", strictSearch));

		String respoceobj = callZaubaApplication(companySearchURL, params);

		JSONObject json = new JSONObject(respoceobj);

		ObjectMapper mapper = new ObjectMapper();

		try {
			list = mapper.readValue(respoceobj, CompanyList.class);
			// list =
			// mapper.readValue(respoceobj,TypeFactory.defaultInstance().constructCollectionType(List.class,
			// BIRZaubaRequest.class));

		} catch (IOException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}

		logger.debug(json.toString());
		System.out.println(json);

		if (respoceobj.contains("Invalid")) {
			logger.debug("Invalid Access Token Used. Sending Request for new Access Token Again...");
			System.out.println("Invalid Access Token Used. Sending Request for new Access Token Again...");
			getAccessToken();
			companySearch(companyName);
		} else {// we will have multiple company names in Reponse. So we will
				// have to search for which company we wants.
			if (respoceobj.contains("600")) {
				array = (JSONArray) json.get("Response");
				logger.debug("ResponseArray  : " + array);
				System.out.println("ResponseArray " + array);
			} else {
				if (respoceobj.contains("611")) {
					logger.debug("Request Limit exceeded.");
					System.out.println("Request Limit exceeded.");
				}
			}
		}
		;

		return list.getResponse();
	}

	@Override
	public String reportRequest(String cin) {
		
		logger.debug("BirReportServiceImpl reportRequest()"+cin);

		String statusCode = null;
		String reportToken = null;
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("AccessToken", getAccessToken())); // added post parametre in url
																				
		params.add(new BasicNameValuePair("Cin", cin));

		String respoceobj = callZaubaApplication(reqReportURL, params);
		
		logger.debug("respoceobj : "+respoceobj);

		if (respoceobj.contains("StatusCode")) 
		{
			JSONObject json = new JSONObject(respoceobj);
			System.out.println(json);
			statusCode = (String) json.get("StatusCode");
			if (statusCode.contains("600")) {
				reportToken = (String) json.get("RequestToken");
				logger.info("Report Token is : " + reportToken);
				logger.info("Now set for getting xml Response");
				System.out.println("Report Token is " + reportToken);
				System.out.println("Now set for getting xml Response");
			}
		}
		return reportToken;
	}

	@Override
	public void saveCompanyDetails(BIRZaubaRequest birZaubaRequest) {
		
		logger.info("BirReportServiceImpl saveCompanyDetails() : "+birZaubaRequest);

		String status = "PENDING";
		String reportToken = reportRequest(birZaubaRequest.getCin());
		
		logger.info("Report Tocken - " + reportToken);
		System.out.println("Report Tocken - " + reportToken);

		if (reportToken != null && !reportToken.isEmpty()) {

			BirRequest birReq = new BirRequest();			
			birReq.setEntityName(birZaubaRequest.getName());
			birReq.setCinNumber(birZaubaRequest.getCin());
			// setBirReq.setScore("15");
			birReq.setReportToken(reportToken);
			birReq.setStatus(statusrepository.findBystatusDescription(Constant.PENDING).getStatusId());
			birReqRepository.save(birReq);// pass one more parameter as status.
			logger.debug("saved bir req - "+birReq);
			logger.info("Sending Request for xml");
			System.out.println("Sending Request for xml");
			if (null != reportToken) // && null!=access_token)
			{
				logger.info("inside if. Nobody is null");
				System.out.println("inside if. Nobody is null");
				getZaubaResponseAndProcess(birReq);
			}
		} else {
			logger.info("Report Token is null");
			System.out.println("Report Token is null");
		}
	}

	@Override
	public boolean getAndProcessBirReport(List<BirRequest> list) {
		logger.debug("BirReportServiceImpl getAndProcessBirReport() -" + list);
		String statusRes = null;
		for (BirRequest birRequest : list) {
			getZaubaResponseAndProcess(birRequest);
		}
		logger.debug("BirReportServiceImpl getAndProcessBirReport() end -");
		return true;
	}

	@Override
	public void getZaubaResponseAndProcess(BirRequest birRequest) {
		
		logger.info("BirReportServiceImpl getZaubaResponseAndProcess() - "+birRequest);
		
		try {
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			params.add(new BasicNameValuePair("AccessToken", getAccessToken())); // added post parameter in url
																					
			params.add(new BasicNameValuePair("Cin", birRequest.getCinNumber()));
			//params.add(new BasicNameValuePair("ReportToken", birRequest.getReportToken()));//12b9aa6ea0c5a359b6e3edada19b267a
			params.add(new BasicNameValuePair("ReportToken", "12b9aa6ea0c5a359b6e3edada19b267a"));

			//String respoceObj = callZaubaApplication(reportURL, params);
			
			//Testing xml code generated to  uncomment below lines
			
			File folder = new File("D:/EIR Docs/MANJEET COTTON PRIVATE LIMITED(22-03-2017).xml");
			String respoceObj = FileUtils.readFileToString(folder);
			birRequest.setXmlOutput(respoceObj.getBytes());

			if (respoceObj.contains("Expired")) {
				logger.debug("Expired Access token.Getting Fresh Access Token And Sending request again. : "+respoceObj);
				System.out.println("Expired Access token.Getting Fresh Access Token And Sending request again.");//
				String fresh_access_token = getAccessToken();
				birRequest.setAccessToken(fresh_access_token);
				getZaubaResponseAndProcess(birRequest);
			} else if (respoceObj.contains("xml version")) {
				logger.info("Got xml. Writing it to file.....");
				logger.info("Checking for Litigation and ShareHolders Data.");
				System.out.println("Got xml. Writing it to file.....");
				System.out.println("Checking for Litigation and ShareHolders Data.");

				Map<Float, String> calculatedScoreMap = CalculateScore.getCalculatedScore(new StringReader(respoceObj));
				if (calculatedScoreMap != null && !calculatedScoreMap.isEmpty()) {
					String scoreXMlOutput;
					Set<Entry<Float, String>> entrySet = calculatedScoreMap.entrySet();
					for (Entry<Float, String> mapEntry : entrySet) 
					{
						Float score = mapEntry.getKey();
						scoreXMlOutput = mapEntry.getValue();
						birRequest.setScoreXMlOutput(scoreXMlOutput.getBytes());
						birRequest.setScore(score.toString());
					}
				}
				birRequest.setStatus(statusrepository.findBystatusDescription(Constant.DOWNLOADED).getStatusId());
				
			} else {
				if (respoceObj.contains("620")) // response:"620":"Report is // // being processed"
				{
					logger.info("Report is being processed.");
					System.out.println("Report is being processed.");
				}
				if (respoceObj.contains("610")) {
					getAccessToken();
					logger.debug("Status Code : 610");
					System.out.println("Status Code : 610");
					System.out.println("Getting access token");
				}
				if (respoceObj.contains("601")) {
					JSONObject json = new JSONObject(respoceObj);
					String key = (String) json.get("Message");
					logger.debug("Response :"+key);
					System.out.println("Response :" + key);
				}
				birRequest.setStatus(statusrepository.findBystatusDescription(Constant.PENDING).getStatusId());
			}

			birReqRepository.save(birRequest);

		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<BirRequest> getPendingRecord() {
		Integer pendingStatus = 1; //TODO status id of pending form status table
		return birReqRepository.getByStatus(pendingStatus);
	}
	
	@Override
	public EligibleReport getEligibleReport() {
		EligibleReport selection = new EligibleReport();
		List<MemberProductMapping> productList = memberProductMappingRepo.findAll();
		
		for(MemberProductMapping s : productList){
			switch (s.getProductCode()) {
			case EIRDataConstant.COMBOWITHSCORE:
				selection.setComboWithScore(true);
				break;
			case EIRDataConstant.COMBOWITHOUTSCORE:
				selection.setComboWithoutScore(true);
				break;
			case EIRDataConstant.CIRWITHSCORE:
				selection.setCommWithScore(true);
				break;
			case EIRDataConstant.CIRWITHOUTSCORE:
				selection.setCommWithoutScore(true);
				break;
			case EIRDataConstant.BIR:
				selection.setBir(true);
				break;
			case EIRDataConstant.SME:
				selection.setSme(true);
				break;
			case EIRDataConstant.LETIGATION:
				selection.setLitigation(true);
				break;
			case EIRDataConstant.NEWSFEED:
				selection.setNewsFeed(true);
				break;
				
			}
		}
		return selection;
	}

	@Override
	public void saveSelectedReportData(EligibleReport selection) {
		
		List<ReportSelection> addintoList = new ArrayList<ReportSelection>();
						
		if (selection.getComboWithScore()) {	
			ReportSelection cws = new ReportSelection();
			cws.setProductCode(EIRDataConstant.COMBOWITHSCORE);
			
			addintoList.add(cws);
		}
		if(selection.getComboWithoutScore())
		{
			ReportSelection cwos = new ReportSelection();
			cwos.setProductCode(EIRDataConstant.COMBOWITHOUTSCORE);
			addintoList.add(cwos);
		}
		if(selection.getCommWithScore())
		{
			ReportSelection cirws = new ReportSelection();
			cirws.setProductCode(EIRDataConstant.CIRWITHSCORE);
			addintoList.add(cirws);
		}
		if(selection.getCommWithoutScore())
		{
			ReportSelection cirwos = new ReportSelection();
			cirwos.setProductCode(EIRDataConstant.CIRWITHOUTSCORE);
			addintoList.add(cirwos);
		}
		if(selection.getLitigation())
		{
			ReportSelection let = new ReportSelection();
			let.setProductCode(EIRDataConstant.LETIGATION);
			addintoList.add(let);
		}
		if(selection.getNewsFeed())
		{
			ReportSelection newsfeed = new ReportSelection();
			newsfeed.setProductCode(EIRDataConstant.NEWSFEED);
			addintoList.add(newsfeed);
		}
		if(selection.getSme())
		{
			ReportSelection sme = new ReportSelection();
			sme.setProductCode(EIRDataConstant.SME);
			addintoList.add(sme);
		}
		if(selection.getBir())
		{
			ReportSelection bir = new ReportSelection();
			bir.setProductCode(EIRDataConstant.BIR);
			addintoList.add(bir);
		}
		for (ReportSelection reportSelection : addintoList) {
			reportSelectionRepository.save(reportSelection);
		}
	}

	@Override
	public void saveRequestedData(MultipleRequest input , HttpServletRequest request) {
		 		
		birReqRepository.save(setBIRData(input , request));
		cirReqRepository.save(setCIRData(input , request));	
		addressRepository.save(setAddress(input));
		setConsumerListData(input , request);
	}

	private Address setAddress(MultipleRequest input) {
		Address addrsEntity = new Address();
			addrsEntity.setAddressLine1(input.getCir().getAddrLinen1());
			addrsEntity.setAddressLine2(input.getCir().getAddrline2());
			addrsEntity.setCity(input.getCir().getCity());
			addrsEntity.setState(input.getCir().getState());
			addrsEntity.setPincode(input.getCir().getPinCode());
		return addrsEntity;
	}

	private ConsumerRequet setConsumerListData(MultipleRequest input, HttpServletRequest request) {
		
		for (ConsumerList consumer_element : input.getConsumer()) {
			ConsumerRequet consumerEntity = new ConsumerRequet();
				consumerEntity.setErnNumber(consumer_element.getErnNumber());
				consumerEntity.setScore(consumer_element.getScore());
				consumerEntity.setStatus(consumer_element.getStatus());
				
			consumerListRepository.save(consumerEntity);
		}
		return null;
	}

	private CirRequest setCIRData(MultipleRequest input, HttpServletRequest request) {
		CirRequest saveCir = new CirRequest();		
				
		saveCir.setErnNumber(input.getCir().getErnNumber());
		saveCir.setStatus(input.getCir().getStatus());
		
		return saveCir;
	}

	private BirRequest setBIRData(MultipleRequest input, HttpServletRequest request) {
		BirRequest saveBir = new BirRequest();
		saveBir.setCompanyName(input.getBir().getCompanyName());
		saveBir.setEntityName(input.getBir().getEntityName());
		saveBir.setCinNumber(input.getBir().getCinNumber());
		
		return saveBir;
	}
}
