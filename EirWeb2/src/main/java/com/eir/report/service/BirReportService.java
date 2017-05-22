package com.eir.report.service;

import java.util.List;

import com.eir.model.EligibleReport;
import com.eir.report.entity.BIRZaubaRequest;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.MemberProductMapping;
import com.eir.report.entity.MultipleRequest;
import com.eir.report.entity.Response;

public interface BirReportService {
	
	public String getAccessToken() ;

	public List<Response> companySearch(String companyName);
	
	public String reportRequest(String cin);
	
	public void saveCompanyDetails(BIRZaubaRequest birZaubaRequest);

	public void getZaubaResponseAndProcess(BirRequest birRequest);
	
	public List<BirRequest> getPendingRecord() ;

	public boolean getAndProcessBirReport(List<BirRequest> list);
	
    public EligibleReport getEligibleReport();
	
	public void saveSelectedReportData(EligibleReport selection);

	public void saveRequestedData(MultipleRequest input);
	

}
