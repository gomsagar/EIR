package com.eir.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.eir.model.EligibleReport;
import com.eir.model.ResponseObject;
import com.eir.report.entity.BIRCmpnySrchRequest;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.Request;
import com.eir.bir.request.model.Company;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.report.entity.Response;
import com.eir.report.service.BirReportService;

@Controller
public class BirController {
	
	@Autowired
	BirReportService birService;
	
	Logger logger = LoggerFactory.getLogger(BirController.class);

	@CrossOrigin("*")
	@RequestMapping(value = "/getCompanyList", method = RequestMethod.POST)
	public @ResponseBody List<Company> getCompanyList(@RequestBody BIRCmpnySrchRequest request) {
		logger.debug("ZaubaIntegrationController getCompanyList() ");
		
		String companyName=request.getCompanyName();
				
		System.out.println("Sending Company Search Request");
		List<Company> listOfCompany = birService.companySearch(companyName);//Later on pass one more parameter as company name
        		
		logger.debug("ZaubaIntegrationController - :getCompanyList End");
		return listOfCompany;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/palceOrderForCompany", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public String palceOrderForCompany(@RequestBody BIRZaubaRequest request) throws IOException {
		
		logger.debug("ZaubaIntegrationController - :palceOrderForCompany() ");
		
		birService.saveCompanyDetails(request);
		
		logger.debug("ZaubaIntegrationController - :palceOrderForCompany() saveCompanyDetails end");
       	
		return null;
	}
	
	/*@CrossOrigin("*")
	@RequestMapping(value="/saveProductSelection", method = RequestMethod.POST,produces="application/json")
	public void getRequest(@RequestBody EligibleReport selection )
	{
		birService.saveSelectedReportData(selection);
	}*/
	
	@CrossOrigin("*")
	@RequestMapping(value = "/getEligibleProduct", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody EligibleReport getEligibleReport(Integer userID) 
	{
		userID = 1002;
		EligibleReport selectedProduct = birService.getEligibleProduct(userID);
		return selectedProduct;
	}
	
	
}
