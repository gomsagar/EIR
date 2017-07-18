package com.eir.report.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eir.bir.request.model.Frequency;
import com.eir.bir.request.model.Gender;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.bir.request.model.SpecifiedUserFlag;
import com.eir.model.DashboardObject;
import com.eir.model.EligibleReport;
import com.eir.model.ViewEarlierEnqRequestObject;
import com.eir.model.ViewEarlierEnquiresObject;
import com.eir.model.ViewEnquiryObject;
import com.eir.report.entity.AccountType;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirPurpose;
import com.eir.report.entity.ConsumerFinancialPurpose;
import com.eir.report.entity.ConsumerPurpose;
import com.eir.report.entity.Member;
import com.eir.report.entity.RelationType;
import com.eir.report.entity.ReportType;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.UserDetails;

public interface EirService {

	List<BirRequest> retrieveRequest();
	
	 void saveUser(Address adr);

	List<Address> getAddress();

	List<com.eir.bir.request.model.State> getStateList();

	List<com.eir.bir.request.model.AddressType> getAddressTypeList();

	void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response);

	void downloadKYCDocuments(int reqId,String fileName,HttpServletRequest request, HttpServletResponse response);

	//void saveRequestedData(MultipleRequest input, HttpServletRequest request);

	Request createRequest(MultipleRequest input, HttpServletRequest request);

	UserDetails getUserById(Integer userId);
	
	List<com.eir.bir.request.model.CirPurpose> getCirPurposeList();

	List<com.eir.bir.request.model.AccountType> getAccountTypeList();

	List<com.eir.bir.request.model.ReportType> getReportTypeList();

	List<com.eir.bir.request.model.RelationType> getRelationTypeList();

	List<com.eir.bir.request.model.ConsumerPurpose> getConsumerPurposeList();

	//void createCIRAndConsumersRequest(MultipleRequest input, Request reqEntity);
	
	List<com.eir.bir.request.model.ConsumerFinancialPurpose> findConsumerFinancialPurposeByPurposeId(Integer purposeId);

	Integer saveSelectedProduct(EligibleReport selection);
	
	List<Gender> getGender();
	SpecifiedUserFlag getSpecifiedUserFlag();

	List<Frequency> getFrequency();

	DashboardObject getDashboardDetails(Integer userId);
	//List<ViewEarlierEnquiresObject> getEarlierRequest(Integer userID);
	
	ViewEnquiryObject getRequestByRequestId(Integer reqId);

	List<ViewEarlierEnquiresObject> getRequestedData(ViewEarlierEnqRequestObject input);
	
		void downloadPDF(ByteArrayOutputStream htmlToPdfFile, HttpServletRequest request, HttpServletResponse response);

		void getResubmitedBIRData(Integer birRequestId);

		Object getResubmitedComboData(Integer requestId);

		Object getResubmitedCIRData(Integer cirRequestId);
		
		Integer getUsersMemberId(Integer userId);
}
