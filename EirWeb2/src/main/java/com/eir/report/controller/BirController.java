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

import com.eir.model.EIRDataConstant;
import com.eir.model.EligibleReport;
import com.eir.report.entity.BIRCmpnySrchRequest;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.MemberProductMapping;
import com.eir.report.entity.MultipleRequest;
import com.eir.report.entity.Response;
import com.eir.report.service.BirReportService;

@Controller
public class BirController {
	
	@Autowired
	BirReportService birService;
	
	Logger logger = LoggerFactory.getLogger(BirController.class);

	@RequestMapping("/welcome2")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping(value = "/getCompanyList", method = RequestMethod.POST)
	public @ResponseBody List<Response> getCompanyList(@RequestBody BIRCmpnySrchRequest request) {
		logger.debug("ZaubaIntegrationController getCompanyList() ");
		
		String companyName=request.getCmpName();
				
		System.out.println("Sending Company Search Request");
		List<Response> listOfCompany = birService.companySearch(companyName);//Later on pass one more parameter as company name
        		
		logger.debug("ZaubaIntegrationController - :getCompanyList End");
		return listOfCompany;
	}
	
	@RequestMapping(value = "/palceOrderForCompany", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public String palceOrderForCompany(@RequestBody BIRZaubaRequest request) throws IOException {
		
		logger.debug("ZaubaIntegrationController - :palceOrderForCompany() ");
		
		birService.saveCompanyDetails(request);
		
		logger.debug("ZaubaIntegrationController - :palceOrderForCompany() saveCompanyDetails end");
       	
		return null;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getReport", method = RequestMethod.POST,produces="application/json")
	public void getRequest(@RequestBody EligibleReport selection ){
		
		System.out.println("CWOS:"+selection.getComboWithScore());
		System.out.println("CWS:"+selection.getComboWithoutScore());
		
		birService.saveSelectedReportData(selection);
		
	
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/getEligibleReport", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody EligibleReport getEligibleReport() {
		EligibleReport selectedProduct = birService.getEligibleReport();
		return selectedProduct;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getInfo", method = RequestMethod.POST,produces="application/json")
	public String getInfo(@RequestBody MultipleRequest input ){
	
		System.out.println("Inside getInfo method" + input.getBirRequest().getScore());
		System.out.println("CmpName: ");
		
		birService.saveRequestedData(input);
		
	   return "" ;
	}
}
