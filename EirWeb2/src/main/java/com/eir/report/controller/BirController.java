package com.eir.report.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eir.report.entity.BIRCmpnySrchRequest;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.EligibleReport;
import com.eir.report.entity.Response;
import com.eir.report.service.BirReportService;

@Controller
public class BirController {
	
	@Autowired
	BirReportService birZaubaIntegrtionService;
	
	Logger logger = LoggerFactory.getLogger(BirController.class);

	@RequestMapping("/welcome2")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	@CrossOrigin("*")
	@RequestMapping(value = "/getCompanyList", method = RequestMethod.POST)
	public @ResponseBody List<Response> getCompanyList(@RequestBody BIRCmpnySrchRequest request) {
		logger.debug("ZaubaIntegrationController getCompanyList() ");
		
		String companyName=request.getCmpName();
				
		System.out.println("Sending Company Search Request");
		List<Response> listOfCompany = birZaubaIntegrtionService.companySearch(companyName);//Later on pass one more parameter as company name
        		
		logger.debug("ZaubaIntegrationController - :getCompanyList End");
		return listOfCompany;
	}
	
	@RequestMapping(value = "/palceOrderForCompany", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public String palceOrderForCompany(@RequestBody BIRZaubaRequest request) throws IOException {
		
		String entityName = request.getName();
		System.out.println("You have selected "+entityName);
		String status = "PENDING";
		String cin = request.getCin();
		String xmlResponseStatus = null;
		
		System.out.println("Cin "+cin);
				
        String report_token = birZaubaIntegrtionService.reportRequest(cin);	
        
        System.out.println("Report Tocken - "+report_token);
        
        BirRequest setBirReq = new BirRequest();
        
        setBirReq.setEntityName(entityName);
        setBirReq.setCinNumber(cin);
        setBirReq.setReportToken(report_token);
        setBirReq.setStatus(status);
        
        if(report_token!=null && !report_token.equalsIgnoreCase("")){
        	
        	birZaubaIntegrtionService.saveCompanyDetails(setBirReq);//pass one more parameter as status.

            System.out.println("Sending Request for xml");
            if(null!=cin && null!=report_token )//&& null!=access_token)
    		{
    			System.out.println("inside if. Nobody is null");
    			xmlResponseStatus = birZaubaIntegrtionService.getXMLResponse(report_token, cin,entityName);
    			System.out.println("Sending Acknowledgment");
    			System.out.println("Acknowledgment Sent.");
    		}
            
        }   else{
        	System.out.println("Report Token is null");
            //response.getWriter().write("Valid CIN Reguired!!Please Place Order By CIN no.");
            //response.setContentType("text/html");
        }	
       	
		return xmlResponseStatus;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getReport", method = RequestMethod.POST,produces="application/json")
	public void getRequest(@RequestBody EligibleReport selection ){
		
		System.out.println("CWOS:"+selection.getComboWithScore());
		System.out.println("CWS:"+selection.getComboWithoutScore());
	
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/getEligibleReport", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody EligibleReport getEligibleReport() {
		EligibleReport selection = new EligibleReport();
		
		selection.setComboWithScore(true);
		selection.setComboWithoutScore(true);
		selection.setCommWithScore(true);
		selection.setCommWithoutScore(true);
		selection.setLitigation(false);
		selection.setBir(true);
		selection.setNewsFeed(false);
		selection.setSme(false);
		System.out.println("Combo with score ...."+selection.getComboWithScore());
		System.out.println("Combo without score ...."+selection.getComboWithoutScore());
		return selection;
	}
}
