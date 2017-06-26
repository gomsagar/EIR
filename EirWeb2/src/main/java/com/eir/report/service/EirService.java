package com.eir.report.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eir.bir.request.model.Frequency;
import com.eir.bir.request.model.Gender;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.bir.request.model.SpecifiedUserFlag;
import com.eir.model.EligibleReport;
import com.eir.report.entity.AccountType;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirPurpose;
import com.eir.report.entity.ConsumerFinancialPurpose;
import com.eir.report.entity.ConsumerPurpose;
import com.eir.report.entity.RelationType;
import com.eir.report.entity.ReportType;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.UserDetails;

public interface EirService {

	List<BirRequest> retrieveRequest();
	
	 void saveUser(Address adr);

	List<Address> getAddress();

	List<State> getStateList();

	List<AddressType> getAddressTypeList();

	void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response);

	void downloadKYCDocuments(int reqId,String fileName,HttpServletRequest request, HttpServletResponse response);

	//void saveRequestedData(MultipleRequest input, HttpServletRequest request);

	Request createRequest(MultipleRequest input, HttpServletRequest request);

	UserDetails getUserById(Integer userId);
	
	List<com.eir.bir.request.model.CirPurpose> getCirPurposeList();

	List<AccountType> getAccountTypeList();

	List<ReportType> getReportTypeList();

	List<RelationType> getRelationTypeList();

	List<ConsumerPurpose> getConsumerPurposeList();

	//void createCIRAndConsumersRequest(MultipleRequest input, Request reqEntity);
	
	List<com.eir.bir.request.model.ConsumerFinancialPurpose> findConsumerFinancialPurposeByPurposeId(Integer purposeId);

	boolean saveSelectedProduct(EligibleReport selection);
	
	List<Gender> getGender();
	SpecifiedUserFlag getSpecifiedUserFlag();

	List<Frequency> getFrequency();
}
