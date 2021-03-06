package com.eir.report.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.runtime.directive.Parse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eir.bir.request.model.CirPurpose;
import com.eir.bir.request.model.Frequency;
import com.eir.bir.request.model.Gender;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.bir.request.model.SpecifiedUserFlag;
import com.eir.commercial.domains.CommonUtilityService;
import com.eir.model.DashboardObject;
import com.eir.model.EligibleReport;
import com.eir.model.MemberObject;
import com.eir.model.ViewEarlierEnqRequestObject;
import com.eir.model.ViewEarlierEnquiresObject;
import com.eir.model.ViewEnquiryObject;
import com.eir.report.constant.Constant;
import com.eir.report.entity.AccountType;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.ConsumerFinancialPurpose;
import com.eir.report.entity.ConsumerPurpose;
import com.eir.report.entity.RelationType;
import com.eir.report.entity.ReportType;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.UserDetails;
import com.eir.report.nextgen.service.mapper.CreateReport;
import com.eir.report.service.BirReportService;
import com.eir.report.service.EirService;
import com.eir.report.service.NextGenWebService;

@Controller
//@RequestMapping("eir")
public class EirController {

	@Autowired
	EirService eirService;
	
	@Autowired
	BirReportService birService; 
	
	@Autowired
	NextGenWebService nextGenWebService; 
	
	Logger logger = LoggerFactory.getLogger(EirController.class);

	@CrossOrigin("*")
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String callDashboard(@RequestParam("userId") Integer userID, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		logger.debug("EirController - callDashboard: Start");

		try {
			if (userID != null) {
				UserDetails userDetails = eirService.getUserById(userID);
				if (userDetails != null) {
					httpServletRequest.getSession().setAttribute(Constant.USER_ID, userID);
					httpServletResponse.sendRedirect("ng/index.html");
					return "ng/index.html";
				}
			}
			logger.debug("EirController - callDashboard: Invalid User");
			httpServletResponse.sendRedirect("ng/error.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ng/error.html";
	}
	
	@CrossOrigin("*")
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
	
	@CrossOrigin("*")
	@RequestMapping(value="/getStateList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.State> getStateList(){
		
		logger.debug("EirController - getStateList(): Start");
		
		List<com.eir.bir.request.model.State> stateList = eirService.getStateList();
				
		logger.debug("EirController - getStateList(): State list" );
		
		return stateList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getAddressTypeList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.AddressType> getAddressTypeList(){
		logger.debug("EirController - getAddressTypeList(): Start");
		
		List<com.eir.bir.request.model.AddressType> addrsTypeList = eirService.getAddressTypeList();
				
		logger.debug("EirController - getAddressTypeList(): State list" );
		
		return addrsTypeList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getCirPurposeList", method = RequestMethod.GET)
	public @ResponseBody List<CirPurpose> getCirPurposeList(){
		List<com.eir.bir.request.model.CirPurpose> cirPurposeList =new ArrayList<com.eir.bir.request.model.CirPurpose>();
		logger.debug("EirController - getCirPurposeList(): Start");
		
		cirPurposeList = eirService.getCirPurposeList();
				
		logger.debug("EirController - getAddressTypeList(): State list"+ cirPurposeList );
		
		return cirPurposeList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getAccountTypeList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.AccountType> getAccountTypeList(){
		logger.debug("EirController - getAccountTypeList(): Start");
		
		List<com.eir.bir.request.model.AccountType> accntTypeList = eirService.getAccountTypeList();
				
		logger.debug("EirController - getAccountTypeList(): State list" );
		
		return accntTypeList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getReportTypeList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.ReportType> getReportTypeList(){
		logger.debug("EirController - getReportTypeList(): Start");
		
		List<com.eir.bir.request.model.ReportType> reportTypeList = eirService.getReportTypeList();
				
		logger.debug("EirController - getReportTypeList(): State list"+ reportTypeList );
		
		return reportTypeList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getRelationTypeList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.RelationType> getRelationTypeList(){
		logger.debug("EirController - getRelationTypeList(): Start");
		
		List<com.eir.bir.request.model.RelationType> relationTypeList = eirService.getRelationTypeList();
				
		logger.debug("EirController - getRelationTypeList(): State list"+ relationTypeList );
		
		return relationTypeList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getConsumerPurposeList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.ConsumerPurpose> getConsumerPurposeList(){
		logger.debug("EirController - getConsumerPurposeList(): Start");
		
		List<com.eir.bir.request.model.ConsumerPurpose> consumerPurposeList = eirService.getConsumerPurposeList();
				
		logger.debug("EirController - getConsumerPurposeList(): State list"+ consumerPurposeList );
		
		return consumerPurposeList;		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getFrequency", method = RequestMethod.GET)
	public @ResponseBody List<Frequency> getFrequency(){
		logger.debug("EirController - getFrequency(): Start");
		
		List<Frequency> frequencyList = eirService.getFrequency();
				
		logger.debug("EirController - getFrequency(): State list" );
		
		return frequencyList;		
	}
	
	/**
	 * Upload multiple file using Spring Controller
	 */
	@CrossOrigin("*")
	@RequestMapping(value = "/uploadKYCDocuments", method = RequestMethod.POST)
	public void uploadKYCDocuments(@RequestParam Integer requestId,HttpServletRequest request, HttpServletResponse response) 
	{
		eirService.uploadKYCDocuments(request,response,requestId);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/downloadKYCDocuments" , method = RequestMethod.POST)
	public void downloadKYCDocuments(@RequestParam int reqId, @RequestParam String fileName,HttpServletRequest request , HttpServletResponse response)
	{
		eirService.downloadKYCDocuments(reqId,fileName,request,response);
	}
	
	@Transactional
	@CrossOrigin("*")
	@RequestMapping(value = "/getUserFlag", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MemberObject getUserFlag(HttpServletRequest request) {

		/*
		 * SpecifiedUserFlag flag = new SpecifiedUserFlag();
		 * flag.setUserFlag("NonSpecifiedUser");
		 * //flag.setUserFlag("SpecifiedUser"); System.out.println("flag = " +
		 * flag.getUserFlag()); //SpecifiedUserFlag flag =
		 * eirService.getSpecifiedUserFlag();
		 */
		Integer userId = Integer.parseInt((String) request.getSession().getAttribute(Constant.USER_ID));
		MemberObject userType = eirService.getUserType(userId);
		return userType;		
	}
	
	@Transactional
	@CrossOrigin("*")
	@RequestMapping(value="/createEnquiry", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String createEnquiry(@RequestBody MultipleRequest input , HttpServletRequest request ){
	
		request.getSession().setAttribute("userId", "EIR");
		System.out.println("session id - : "+request.getSession().getAttribute("userId"));
		System.out.println("session id - : "+request.getRequestedSessionId());
		//System.out.println("Inside getInfo method" + input.getBir().getCompany().getCinNumber());
		
		Request requestObj = eirService.createRequest(input , request);
				
	   return requestObj.getStatus().getStatusDescription() ;
	}

	@CrossOrigin("*")
	@RequestMapping(value = "/getConsumerFinancialPurposeList", method = RequestMethod.GET)
	public @ResponseBody List<com.eir.bir.request.model.ConsumerFinancialPurpose> getConsumerFinancialPurposeList(
			@RequestParam("purposeId") Integer purposeId) {
		logger.debug("EirController - getConsumerPurposeList(): Start");

		List<com.eir.bir.request.model.ConsumerFinancialPurpose> consumerFinancialPurposeList = eirService
				.findConsumerFinancialPurposeByPurposeId(purposeId);

		return consumerFinancialPurposeList;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/saveProductSelection", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Integer saveProductSelection(@RequestBody EligibleReport selection,
			@RequestParam(required = true) Integer sentRequestId, HttpServletRequest request) {
		Integer userId = Integer.parseInt((String) request.getSession().getAttribute(Constant.USER_ID));
		return eirService.saveSelectedProduct(selection, sentRequestId, userId);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value="/getGender", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<Gender> getRequest()
	{
		return eirService.getGender();
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/getDashboardObject", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody DashboardObject getDashboardDetails(HttpServletRequest request) {
		Integer userId = Integer.parseInt((String) request.getSession().getAttribute(Constant.USER_ID));
		return eirService.getDashboardDetails(userId);
	}

	@Transactional
	@CrossOrigin("*")
	@RequestMapping(value = "/getHTMLReport", method = RequestMethod.GET)
	public ModelAndView getEIRReport(@RequestParam(required = true) Integer requestId,
			@RequestParam(required = true) String reportType, @RequestParam(required = true) Boolean isPdf) {

		String htmlReport = nextGenWebService.getEIRReport(requestId, reportType, isPdf);
		logger.debug("EirController - getEIRReport(): report generated");
		
		//return Constant.HTML_FILE_PATH;
		ModelAndView modelAndView = new ModelAndView("ViewReport");
		modelAndView.addObject("htmlReport", htmlReport);
 
		return modelAndView;
	}
	@Transactional
	@CrossOrigin("*")
	@RequestMapping(value = "/getPDFReport", method = RequestMethod.GET)
	public void getEIRPDFReport(@RequestParam(required = true) Integer requestId,
			@RequestParam(required = true) String reportType, @RequestParam(required = true) Boolean isPdf,
			HttpServletRequest request, HttpServletResponse response) {

		String pdfString = nextGenWebService.getEIRReport(requestId, reportType, isPdf);
		CommonUtilityService commonUtilityService = new CommonUtilityService();
	    ByteArrayOutputStream htmlToPdfFile = commonUtilityService.htmlToPdfFile(pdfString, "", "");
	    eirService.getDownloadFile(htmlToPdfFile,Constant.FILE_EXTENTION_PDF,request,response);
	    
		logger.debug("EirController - getEIRReport(): report generated");
	}
	@Transactional
	@CrossOrigin("*")
	@RequestMapping(value = "/getXMLReport", method = RequestMethod.GET)
	public String getXMLReport(@RequestParam(required = true) Integer requestId,
			@RequestParam(required = true) String reportType, HttpServletRequest request,
			HttpServletResponse response) {
		String responceststus = eirService.getEirXMLReport(requestId, reportType, request, response);

		logger.debug("EirController - getEirXMLReport(): report generated");
		
		return responceststus;
	}
	
	@CrossOrigin("*")
   	@RequestMapping(value = "/getEarlierEnquiryRequestData", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<ViewEarlierEnquiresObject> getEarlierEnquiryRequestData(
			@RequestBody ViewEarlierEnqRequestObject input, HttpServletRequest request) {

		Integer userId =  Integer.parseInt((String)request.getSession().getAttribute(Constant.USER_ID));
		List<ViewEarlierEnquiresObject> viewEnquiresObjectList = eirService.getEarlierEnquiryRequestData(input,userId);
		return viewEnquiresObjectList;
	}
	
	@CrossOrigin("*")
    @RequestMapping(value = "/getCrmAdminEnqData", method = RequestMethod.POST,produces="application/json")
    public @ResponseBody List<ViewEarlierEnquiresObject> getCrmAdminEnqData(@RequestBody ViewEarlierEnqRequestObject input , HttpServletRequest request) 
    {
         
           List<ViewEarlierEnquiresObject> viewEnquiresObjectList = eirService.getCrmAdminRequestData(input);              
           return viewEnquiresObjectList;
    }
	@CrossOrigin("*")
    @RequestMapping(value = "/viewRequestIds", method = RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Integer> viewRequestIds(@RequestBody ViewEarlierEnqRequestObject input , HttpServletRequest request) 
    {
         
           List<Integer> viewEnquiresObjectList = eirService.getRequestedIds(input);              
           return viewEnquiresObjectList;
    }

	
	@Transactional
	@CrossOrigin("*")
	@RequestMapping(value = "/getViewRequest", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ViewEnquiryObject getViewRequest(@RequestParam("requestId") Integer requestId) 
	{
		//requestId =145;		
		ViewEnquiryObject viewEnquiresObject = eirService.getRequestByRequestId(requestId);		
		return viewEnquiresObject;
	}
	
	@CrossOrigin("*")
    @RequestMapping(value = "/reSubmitRequestForBIR", method = RequestMethod.GET)
    public void resubmitRequestForBIR(@RequestParam("birRequestId") Integer birRequestId) 
    {
         
           eirService.resubmitRequestForBIR(birRequestId);              
          // return viewEnquiresObjectList;
    }
	
	@Transactional
	@CrossOrigin("*")
    @RequestMapping(value = "/reSubmitRequestForCombo", method = RequestMethod.POST)
    public @ResponseBody Object reSubmitRequestForCombo(@RequestParam("requestId") Integer requestId) 
    {
		Object object = eirService.reSubmitRequestForCombo(requestId);              
		return object;
    }

	@Transactional
	@CrossOrigin("*")
    @RequestMapping(value = "/reSubmitRequestForCIR", method = RequestMethod.POST)
    public @ResponseBody Object reSubmitRequestForCIR(@RequestParam("cirRequestId") Integer cirRequestId) 
    {
         Object object = eirService.reSubmitRequestForCIR(cirRequestId);              
        return object;
    }
	
	@CrossOrigin("*")
	@RequestMapping(value = "/getEligibleProduct", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody EligibleReport getEligibleReport(Integer userID) 
	{
		userID = 1002;
		EligibleReport selectedProduct = eirService.getEligibleProduct(userID);
		return selectedProduct;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/getSelectedProduct", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody EligibleReport getSelectedProduct(Integer reqID) 
	{
	 EligibleReport productSelection = eirService.getSelectedProduct(reqID);
		return productSelection;
	}
	
}
