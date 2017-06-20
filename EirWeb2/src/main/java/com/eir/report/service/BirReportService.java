package com.eir.report.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.eir.model.EligibleReport;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.Request;
import com.eir.bir.request.model.Company;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.report.entity.Response;

public interface BirReportService {
	
	String getAccessToken() ;

	List<Company> companySearch(String companyName);
	
	String reportRequest(String cin);
	
	void saveCompanyDetails(BIRZaubaRequest birZaubaRequest);

	void getZaubaResponseAndProcess(BirRequest birRequest);
	
	List<BirRequest> getPendingRecord() ;

	boolean getAndProcessBirReport(List<BirRequest> list);
	
    EligibleReport getEligibleProduct(Integer userID);
	
    Request getEarlierRequest(Integer userID);
	//void saveBIRRequestData(MultipleRequest input, Request request);
	
	//void createZaubaRequest(com.eir.bir.request.model.BirRequest birZaubaRequest);

	BirRequest createBIRrequest(com.eir.bir.request.model.BirRequest birInputRequest, Request request);
}
