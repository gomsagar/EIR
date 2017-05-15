package com.eir.report.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CompanyList;
import com.eir.report.entity.Response;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.ProductRepository;
import com.eir.report.service.BirReportService;
import com.eir.report.zauba.model.CompanyReportType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Service
@PropertySource("classpath:zaubaConfig.properties")
public class BirReportServiceImpl implements BirReportService{
	
	@Value("${application.ID}")
	private String applicationID1;
	
	@Value("${access.key}")
	String key;

	@Value("${secret.value}")
    String secretValue ; 
	
	@Value("${trustStore.value}")
	String trustStore;
	
	@Value("${jks.path}")
	String jksPath;
	
	@Value("${accessTocken.url}") 
	String accessTockenURL;
	
	@Value("${strict.Search}")
	String strictSearch;
	
	@Value("${company.search.url}")
	String companySearchURL;
	
	@Value("${request.report.url}")
	String reqReportURL;
	
	@Value("${report.url}")
	String reportURL;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BirRequestRepository birReqRepository;
	
	CloseableHttpResponse  httpResponse=null;
    HttpEntity entity=null;
    static Unmarshaller unmarsh =null;
	private  CloseableHttpClient httpclient;
    private  BasicCookieStore cookieStore;
    CompanyReportType bipr = null;
    static JAXBContext jc =null;
    public BirReportServiceImpl()
    {
        cookieStore = new BasicCookieStore();
        httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

    }
    //BirReportServiceImpl mainObj = new BirReportServiceImpl();
/* static{
		try {
			jc=JAXBContext.newInstance(CompanyReportType.class);
			unmarsh = jc.createUnmarshaller();
		} catch (JAXBException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	 public String callZaubaApplication(String url , List<BasicNameValuePair> params) {
		 System.setProperty(trustStore, jksPath);
		 HttpPost httpost=new HttpPost(url);
		 String  responseString = null;
		 try {
			httpost.setEntity(new UrlEncodedFormEntity(params));
			
			//------ Execute URL with encoded form -------//
			httpResponse = httpclient.execute(httpost);	
			
			entity = httpResponse.getEntity();
			
			if(entity == null)
            {
                System.out.println("Get Case Type - Empty Response Received");
            }
			responseString = EntityUtils.toString(entity, "UTF-8");
			
			if(responseString.contains("Invalid"))
            {
            	System.out.println("Invalid Access Token Used. Sending Request for new Access Token Again...");
            	getAccessToken();
            }
			JSONObject json = new JSONObject(responseString);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 finally{
			 try {
				httpResponse.close();
				httpost.releaseConnection();
		        httpost = null; 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return responseString;
	}

	@Override
	public String getAccessToken() {		

        String access_token=null;
        
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(); //List created for adding post parameters to URL.
        params.add(new BasicNameValuePair("ClientKey",key)); // added post parameters in URL.
        params.add(new BasicNameValuePair("ClientSecret",secretValue));

        String respoceobj = callZaubaApplication(accessTockenURL,params);

        JSONObject json = new JSONObject(respoceobj);
        access_token = (String) json.get("AccessToken");
        System.out.println("Access Token is "+access_token);    
        
		return access_token;
	}

	@Override
	public List<Response> companySearch(String companyName) {

		//one more parameter will come here from jsp which is company name.
        String cinNew=null;
        JSONArray array = new JSONArray();        
        CompanyList list = null;
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(); 
        params.add(new BasicNameValuePair("AccessToken",getAccessToken())); // added post parameters in URL.
        params.add(new BasicNameValuePair("Name",companyName));
        params.add(new BasicNameValuePair("StrictSearch",strictSearch));
        
        String respoceobj = callZaubaApplication(companySearchURL,params);
        
            JSONObject json = new JSONObject(respoceobj);   
            
            ObjectMapper mapper = new ObjectMapper();
            
            try {
            	 list = mapper.readValue(respoceobj, CompanyList.class);
				// list = mapper.readValue(respoceobj,TypeFactory.defaultInstance().constructCollectionType(List.class, BIRZaubaRequest.class));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            System.out.println(json);
            
            if(respoceobj.contains("Invalid"))
            {
            	System.out.println("Invalid Access Token Used. Sending Request for new Access Token Again...");
            	getAccessToken();
            	companySearch(companyName);
            }
            else
            {//we will have multiple company names in Reponse. So we will have to search for which company we wants.
            	if(respoceobj.contains("600"))
            	{
    	            array =  (JSONArray) json.get("Response");
    	            System.out.println("ResponseArray "+array);            		
            	}
            	else
            	{
            		if(respoceobj.contains("611"))
            		{
            			System.out.println("Request Limit exceeded.");
            		}
            	}
            }
            ;
           
            return list.getResponse();
	}

	@Override
	public String reportRequest(String cin) {
    	
        String statusCode = null;
        String report_Token = null;
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(); 
        params.add(new BasicNameValuePair("AccessToken",getAccessToken())); // added post parameters in URL.
        params.add(new BasicNameValuePair("Cin",cin));
        
        String respoceobj = callZaubaApplication(reqReportURL,params);

            if(respoceobj.contains("StatusCode"))
            {
            	JSONObject json = new JSONObject(respoceobj);	
            	System.out.println(json);
            	statusCode = (String) json.get("StatusCode");
            	if(statusCode.contains("600"))
            	{
            	    report_Token = (String) json.get("RequestToken");
            		System.out.println("Report Token is "+report_Token);
            		System.out.println("Now set for getting xml Response");
            	}
            }
               
        return report_Token;
    }

	@Override
	public void saveCompanyDetails(BirRequest setBirReq) {
		birReqRepository.save(setBirReq);
	}

	@Override
	public String getXMLResponse(String report_token, String cin, String entityName) {
		SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
    	Date date = new Date();
    	String currentDate = form.format(date);
    	String xmlResponse = null;
    	
    	 List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(); 
         params.add(new BasicNameValuePair("AccessToken",getAccessToken())); // added post parameters in URL.
         params.add(new BasicNameValuePair("Cin",cin));
         params.add(new BasicNameValuePair("ReportToken",report_token));
         
         String respoceobj = callZaubaApplication(reportURL,params);
         
         if(respoceobj.contains("Expired"))
         {
         	System.out.println("Expired Access token.Getting Fresh Access Token And Sending request again.");
         	String fresh_access_token = getAccessToken();
         	
         	//birReqRepository.updateAccessToken(report_token, fresh_access_token, cin, entityName);//don't need to update access tocken
         	
         	getXMLResponse(report_token, cin, entityName);
         }
         if(respoceobj.contains("xml version"))
         {
         	System.out.println("Got xml. Writing it to file.....");
         	System.out.println("Checking for Litigation and ShareHolders Data.");
         	xmlResponse = respoceobj;
         	
         	try {
				bipr = (CompanyReportType)unmarsh.unmarshal(new StringReader(xmlResponse));
				if(null==bipr.getLawsuits() || (null != bipr.getLawsuits() && 0 <= bipr.getLawsuits().getLawsuit().size())){           		
             		if(null == bipr.getShareholders() || (null != bipr.getShareholders() &&  0 <= bipr.getShareholders().getShareholder().size())){
             			System.out.println("ShareHolders Data Found");
                     	File file = new File("C:/Zauba/ZaubaOutput/"+entityName+"("+currentDate+").xml");
             			FileWriter fw = new FileWriter(file.getAbsoluteFile());
             			BufferedWriter bw = new BufferedWriter(fw);
             			bw.write(xmlResponse);
             			bw.close();
             			System.out.println("Done Writing File.");
             			String status = "DOWNLOADED";
             			//birReqRepository.updateRecord(report_token,cin,entityName,status);//
                         System.out.println("Record Updated.");
                         String filePath = "C:/Zauba/ZaubaOutput/"+entityName+"("+currentDate+").xml";
                        // sendMail(filePath,entityName);
             		}else{
             			System.out.println("Litigation Data Found But Share Holders Data not found.");
             		}
             	}else{
             		System.out.println("Litigation and ShareHolders Data Not Found in Response.");
             	}
			} catch(UnmarshalException e)
	         {
	         	try
	         	{
	 	        	File file = new File("C:/Zauba/ZaubaOutput/"+entityName+"("+currentDate+").xml");
	 	        	//File file = new File("file://eibackup2/Business Info/Zauba/ZaubaOutput/"+companyName+"("+currentDate+").xml");
	 				FileWriter fw = new FileWriter(file.getAbsoluteFile());
	 				BufferedWriter bw = new BufferedWriter(fw);
	 				bw.write(xmlResponse);
	 				bw.close();
	 				System.out.println("Done Writing File.");
	 				String status = "DOWNLOADED";
	 				//birReqRepository.updateRecord(report_token,cin,entityName,status);//
	         	}
	         	catch(Exception ex)
	         	{
	         		ex.printStackTrace();
	         	}
	         //	sendExceptionMail("C:/Zauba/ZaubaOutput/"+entityName+"("+currentDate+").xml",entityName);
	         	e.printStackTrace();        	
	         }
	         catch (Exception e) 
	         {
	             e.printStackTrace();
	         }
         	
         }
         else
         {
         	if(respoceobj.contains("620")) //response:"620":"Report is being processed"
         	{
         		System.out.println("Report is being processed.");
         		
         	}
         	if(respoceobj.contains("610"))
         	{
         		getAccessToken();
         		System.out.println("Status Code : 610");
         		System.out.println("Getting access token");
         	}
         	if(respoceobj.contains("601"))
         	{
         		JSONObject json = new JSONObject(respoceobj);
         		String key = (String)json.get("Message");
         		System.out.println("Response :"+key);
         	}
         }
		return respoceobj;
	}
	
}
