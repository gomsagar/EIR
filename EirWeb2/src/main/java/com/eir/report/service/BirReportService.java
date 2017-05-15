package com.eir.report.service;

import java.util.List;

import com.eir.report.entity.BirRequest;
import com.eir.report.entity.Response;

public interface BirReportService {
	
	public String getAccessToken() ;

	public List<Response> companySearch(String companyName);
	
	public String reportRequest(String cin);
	
	public void saveCompanyDetails(BirRequest setBirReq);

	public String getXMLResponse(String report_token, String cin, String entityName);

}
