package com.eir.report.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eir.bir.request.model.MultipleRequest;
import com.eir.report.constant.Constant;
import com.eir.report.entity.AccountType;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.CirPurpose;
import com.eir.report.entity.ConsumerPurpose;
import com.eir.report.entity.RelationType;
import com.eir.report.entity.ReportType;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.UserDetails;
import com.eir.report.service.BirReportService;
import com.eir.report.service.EirService;

@Controller
//@RequestMapping("eir")
public class EirController {

	@Autowired
	EirService eirService;
	
	@Autowired
	BirReportService birService;
	
	Logger logger = LoggerFactory.getLogger(EirController.class);

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String callDashboard(@RequestParam("userId") String userID, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		logger.debug("EirController - callDashboard: Start");
		
		try
		{
			if(userID != null && !userID.isEmpty())
			{
				UserDetails userDetails = eirService.getUserById(userID);
				if(userDetails != null)
				{
					httpServletRequest.getSession().setAttribute(Constant.USER_ID, userID);
					httpServletResponse.sendRedirect("ng/index.html");
					return "ng/index.html";
				}
			}
			logger.debug("EirController - callDashboard: Invalid User");
			httpServletResponse.sendRedirect("ng/error.html");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "ng/error.html";
	}
	
	@RequestMapping(value = "/getRequest", method = RequestMethod.POST)
	public @ResponseBody Request update() {
		Request request = new Request();
		request.setRequestId(1);
		request.setAdminHit(1);
		request.setUserHit(1);
		request.setErnNumber("ERN102");
		System.out.println(request.getErnNumber());
		return request;
	}
	
	@RequestMapping(value="/getStateList", method = RequestMethod.GET)
	public @ResponseBody List<State> getStateList(){
		
		logger.debug("EirController - getStateList(): Start");
		
		List<State> stateList = eirService.getStateList();
				
		logger.debug("EirController - getStateList(): State list"+ stateList );
		
		return stateList;		
	}
	
	@RequestMapping(value="/getAddressTypeList", method = RequestMethod.GET)
	public @ResponseBody List<AddressType> getAddressTypeList(){
		List<AddressType> addrsTypeList =new ArrayList<AddressType>();
		logger.debug("EirController - getAddressTypeList(): Start");
		
		addrsTypeList = eirService.getAddressTypeList();
				
		logger.debug("EirController - getAddressTypeList(): State list"+ addrsTypeList );
		
		return addrsTypeList;		
	}
	
	@RequestMapping(value="/getCirPurposeList", method = RequestMethod.GET)
	public @ResponseBody List<CirPurpose> getCirPurposeList(){
		List<CirPurpose> cirPurposeList =new ArrayList<CirPurpose>();
		logger.debug("EirController - getCirPurposeList(): Start");
		
		cirPurposeList = eirService.getCirPurposeList();
				
		logger.debug("EirController - getAddressTypeList(): State list"+ cirPurposeList );
		
		return cirPurposeList;		
	}
	
	@RequestMapping(value="/getAccountTypeList", method = RequestMethod.GET)
	public @ResponseBody List<AccountType> getAccountTypeList(){
		logger.debug("EirController - getAccountTypeList(): Start");
		
		List<AccountType> accntTypeList = eirService.getAccountTypeList();
				
		logger.debug("EirController - getAccountTypeList(): State list"+ accntTypeList );
		
		return accntTypeList;		
	}
	
	@RequestMapping(value="/getReportTypeList", method = RequestMethod.GET)
	public @ResponseBody List<ReportType> getReportTypeList(){
		logger.debug("EirController - getReportTypeList(): Start");
		
		List<ReportType> reportTypeList = eirService.getReportTypeList();
				
		logger.debug("EirController - getReportTypeList(): State list"+ reportTypeList );
		
		return reportTypeList;		
	}
	
	@RequestMapping(value="/getRelationTypeList", method = RequestMethod.GET)
	public @ResponseBody List<RelationType> getRelationTypeList(){
		logger.debug("EirController - getRelationTypeList(): Start");
		
		List<RelationType> relationTypeList = eirService.getRelationTypeList();
				
		logger.debug("EirController - getRelationTypeList(): State list"+ relationTypeList );
		
		return relationTypeList;		
	}
	
	@RequestMapping(value="/getConsumerPurposeList", method = RequestMethod.GET)
	public @ResponseBody List<ConsumerPurpose> getConsumerPurposeList(){
		logger.debug("EirController - getConsumerPurposeList(): Start");
		
		List<ConsumerPurpose> consumerPurposeList = eirService.getConsumerPurposeList();
				
		logger.debug("EirController - getConsumerPurposeList(): State list"+ consumerPurposeList );
		
		return consumerPurposeList;		
	}
	
	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadKYCDocuments", method = RequestMethod.POST)
	public @ResponseBody void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response) 
	{
		eirService.uploadKYCDocuments(request,response);
	}
	
	@RequestMapping(value = "/downloadKYCDocuments" , method = RequestMethod.GET)
	public void downloadKYCDocuments(HttpServletRequest request , HttpServletResponse response)
	{
		eirService.downloadKYCDocuments(request,response);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getInfo", method = RequestMethod.POST,produces="application/json")
	public String getInfo(@RequestBody MultipleRequest input , HttpServletRequest request ){
	
		request.getSession().setAttribute("userId", "EIR");
		System.out.println("session id - : "+request.getSession().getAttribute("userId"));
		System.out.println("session id - : "+request.getRequestedSessionId());
		System.out.println("Inside getInfo method" + input.getBir().getCinNumber());
		
		Request requestObj = eirService.createRequest(input , request);
		
		/*input.setRequestObj(requestObj);
		
		if (input.getIsBIRActive()) 
		{
			birService.saveBIRRequestData(input , request);					
		}
		
		if (input.getIsCIRActive() || input.getIsComboActive()) 
		{
			eirService.saveRequestedData(input , request);
		}*/
		
	   return "" ;
	}
}
