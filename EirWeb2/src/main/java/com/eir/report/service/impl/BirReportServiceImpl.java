package com.eir.report.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

import com.eir.bir.request.model.Company;
import com.eir.model.EIRDataConstant;
import com.eir.model.EligibleReport;
import com.eir.model.bir.CompanyReportType;
import com.eir.model.bir.report.CalculateScore;
import com.eir.report.constant.Constant;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CompanyList;
import com.eir.report.entity.MemberProductMapping;
import com.eir.report.entity.ProductMaster;
import com.eir.report.entity.ReportSelection;
import com.eir.report.entity.Request;
import com.eir.report.entity.Response;
import com.eir.report.entity.Status;
import com.eir.report.repository.AddressRepository;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.MemberProductMappingRepository;
import com.eir.report.repository.ProductMasterRepository;
import com.eir.report.repository.ReportSelectionRepository;
import com.eir.report.repository.RequestRepository;
import com.eir.report.repository.StatusRepository;
import com.eir.report.service.BirReportService;
import com.eir.report.util.GetStatus;
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
	
	@Value("${outputXml.path}")
	private String xmlOutputPath;
	
	Logger logger = LoggerFactory.getLogger(BirReportServiceImpl.class);

	@Autowired
	ProductMasterRepository productMasterRepository;

	@Autowired
	BirRequestRepository birReqRepository;
	
	@Autowired
	MemberProductMappingRepository memberProductMappingRepo;
	
	@Autowired
	StatusRepository statusrepository;
	
	@Autowired
	ReportSelectionRepository reportSelectionRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	RequestRepository requestRepository;
		
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
		logger.debug("BirReportServiceImpl callZaubaApplication() start");
		
		System.setProperty(trustStore, jksPath);
		HttpPost httpost = new HttpPost(url);
		String responseString = null;
		try
		{
			httpost.setEntity(new UrlEncodedFormEntity(params));
			// ------ Execute URL with encoded form -------//
			httpResponse = httpclient.execute(httpost);
			entity = httpResponse.getEntity();
			if (entity == null) 
			{
				logger.debug("BirReportServiceImpl: callZaubaApplication()  - Empty Response Received");
			} 
			else 
			{
				responseString = EntityUtils.toString(entity, "UTF-8");

				if (responseString.contains("Invalid")) 
				{
					logger.debug("Invalid Access Token Used. Sending Request for new Access Token Again...");
					System.out.println("Invalid Access Token Used. Sending Request for new Access Token Again...");
					removeAccessToken(params);
					params.add(new BasicNameValuePair(Constant.ACCESS_TOKEN, getAccessToken())); // added post parameter in url
					callZaubaApplication(url, params);
				}
			}
		} catch (Exception e) {
			logger.error("BirReportServiceImpl: callZaubaApplication() - call to zauba fail", e.getMessage());
		} finally {
			try {
				httpResponse.close();
				httpost.releaseConnection();
			} catch (IOException e) {
				logger.error("BirReportServiceImpl: callZaubaApplication() finally " + e);
			}
		}
		return responseString;
	}
	
	private void removeAccessToken(List<BasicNameValuePair> params)
	{
		if(params != null && !params.isEmpty())
		{
			for(BasicNameValuePair nameValuePair: params)
			{
				if(nameValuePair.getName().equals(Constant.ACCESS_TOKEN))
				{
					params.remove(nameValuePair);
					break;
				}
			}
		}
	}

	@Override
	public String getAccessToken() 
	{
		logger.debug("BirReportServiceImpl getAccessToken() Start");
		
		String access_token = null;
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(); // List created for adding post parameters to url
		params.add(new BasicNameValuePair("ClientKey", key)); // added post parameters in url
		params.add(new BasicNameValuePair("ClientSecret", secretValue));

		System.setProperty(trustStore, jksPath);
		HttpPost httpost = new HttpPost(accessTockenURL);
		try 
		{
			httpost.setEntity(new UrlEncodedFormEntity(params));
			// ------ Execute URL with encoded form -------//
			httpResponse = httpclient.execute(httpost);
			entity = httpResponse.getEntity();

			if (entity == null) 
			{
				logger.debug("BirReportServiceImpl: callZaubaApplication()  - Empty Response Received");
			}
			else 
			{
				String respoceobj = EntityUtils.toString(entity, "UTF-8");
				
				JSONObject json = new JSONObject(respoceobj);
				access_token = (String) json.get("AccessToken");
				
				if (access_token.contains("Invalid")) 
				{
					logger.debug("BirReportServiceImpl: getAccessToken() accesstoken received is empty");
				}
			}
		}
		catch(Exception e)
		{
			logger.error("BirReportServiceImpl: getAccessToken() error on getting access token", e);
		}
		return access_token;
	}

	@Override
	public List<Company> companySearch(String companyName) {
		
		logger.debug("BirReportServiceImpl companySearch()");
		try {
			// one more parameter will come here from jsp which is company name.
			CompanyList list = null;
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			params.add(new BasicNameValuePair("AccessToken", getAccessToken())); // added post parameters in url
			params.add(new BasicNameValuePair("Name", companyName));
			params.add(new BasicNameValuePair("StrictSearch", strictSearch));
	
			String respoceobj = callZaubaApplication(companySearchURL, params);
			JSONObject json = new JSONObject(respoceobj);
			logger.debug("BirReportServiceImpl companySearch() response json " + json.toString());
			System.out.println(json);
			ObjectMapper mapper = new ObjectMapper();
			list = mapper.readValue(respoceobj, CompanyList.class);
			return companyMapper(list.getResponse());
		} catch (IOException e) {
			logger.error("BirReportServiceImpl companySearch() error -" +  e);
		}
		return null;
	}
	
	private List<Company> companyMapper(List<Response> companyResponselist)
	{
		if(companyResponselist != null && !companyResponselist.isEmpty())
		{
			List<Company> companies = new ArrayList<>();
			for(Response response: companyResponselist)
			{
				Company company = new Company();
				company.setCinNumber(response.getCin());
				company.setEntityName(response.getName());
				companies.add(company); 
			}
			return companies;
		}
		return null;
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
			birReq.setStatus(getStatusByDescription(com.eir.report.constant.Status.PENDING.status()));
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
		logger.debug("BirReportServiceImpl getAndProcessBirReport() ");
		String statusRes = null;
		for (BirRequest birRequest : list) {
			getZaubaResponseAndProcess(birRequest);
		}
		logger.debug("BirReportServiceImpl getAndProcessBirReport() end -");
		return true;
	}

	@Override
	public void getZaubaResponseAndProcess(BirRequest birRequest) {
		
		logger.info("BirReportServiceImpl getZaubaResponseAndProcess() ");
		
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
			
			//birRequest.setXmlOutput(respoceObj.getBytes()); // commented reason -- we are not save output xml in database
			birRequest.setXmlOutputPath(writeXmlOutputToFile(respoceObj));
			
			
			if (respoceObj.contains("Expired")) {
				logger.debug("Expired Access token.Getting Fresh Access Token And Sending request again. : "+respoceObj);
				System.out.println("Expired Access token.Getting Fresh Access Token And Sending request again.");//
				String fresh_access_token = getAccessToken();
				//birRequest.setAccessToken(fresh_access_token);
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
						birRequest.setScoreCardExcell(scoreXMlOutput.getBytes());
						birRequest.setScore(score.toString());
					}
				}
				birRequest.setStatus(getStatusByDescription(com.eir.report.constant.Status.COMPLETED.status()));
				
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
				birRequest.setStatus(getStatusByDescription(com.eir.report.constant.Status.PENDING.status()));
			}

			birReqRepository.save(birRequest);

		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
	}
	private String writeXmlOutputToFile(String xmlOutputResponse) 
	{
			//responceData write into file 
			Integer xmlOutputFolderReqId = 8;//birRequest.getRequest().getRequestId();
			String fileName = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.txt'").format(new Date());
			
			File file = new File(xmlOutputPath+xmlOutputFolderReqId+"/"+fileName);
			file.getParentFile().mkdirs();
			String writePath = file.getAbsolutePath();
	        FileWriter fr = null;
	        try {
	            fr = new FileWriter(file);
	            fr.write(xmlOutputResponse);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            //close resources
	            try {
	                fr.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        //end write data here
			return writePath;
	}

	@Override
	public List<BirRequest> getPendingRecord() {
		Integer pendingStatus = 1; //TODO status id of pending form status table
		return birReqRepository.findByStatus(getStatusByDescription(com.eir.report.constant.Status.PENDING.status()));
	}
	
	@Override
	public EligibleReport getEligibleProduct(Integer userID) {
		EligibleReport selection = new EligibleReport();
		List<MemberProductMapping> productList = memberProductMappingRepo.findProductMappingForUserId(userID);
		
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

	/*@Override
	public void saveBIRRequestData(MultipleRequest input, Request request) 
	{
		birReqRepository.save(createBIRrequest(input.getBir() , request));
		
	}*/
	
	@Override
	public BirRequest createBIRrequest(com.eir.bir.request.model.BirRequest birInputRequest, Request request) 
	{
		BirRequest birReq = new BirRequest();
		
		birReq.setRequest(request);
		birReq.setCompanyName(birInputRequest.getCompanyName());
		birReq.setEntityName(birInputRequest.getCompany().getEntityName());
		birReq.setCinNumber(birInputRequest.getCompany().getCinNumber());
		//birReq.setStatus(GetStatus.getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
		
		String reportToken = reportRequest(birReq.getCinNumber());
		logger.info("Report Tocken - " + reportToken);

		if (reportToken != null && !reportToken.isEmpty()) 
		{
			birReq.setReportToken(reportToken);
			birReq.setStatus(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
			birReqRepository.save(birReq);
			logger.debug("BirReportServiceImpl createBIRrequestsaved() BirRequest saved to db Id: " + birReq.getBirRequestId());
		} 
		return birReq;
	}
	public Status getStatusByDescription(String statusDesc)
	{
		if(statusDesc != null && !statusDesc.isEmpty())
		{
			return statusRepository.findBystatusDescription(statusDesc);	
		}
		return null;
	}

	public Request getEarlierRequest(Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Request getEarlierRequest(Integer userID) {
		
		return null;
	}*/
}
