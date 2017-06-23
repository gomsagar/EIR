package com.eir.report.service;

import java.util.List;

import com.eir.commercial.domains.CommercialReportDetails;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.ConsumerRequest;
import com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo;

public interface NextGenWebService {

	CirRequest createCIRReport(CirRequest cirRequest);

	void createConsumerReport(List<ConsumerRequest> consumerEntityRequest);

	CommercialReportDetails getCIRReport(CirRequest cirRequest);

	List<ResponseInfo> getConsumerReport(List<ConsumerRequest> consumerRequests);
	
	void getEIRReport(Integer requestId, String reportType);

//	CommercialReportDetails getCIRReport(com.eir.bir.request.model.CirRequest cirRequest);
}
