package com.eir.report.service;

import java.util.List;

import com.eir.bir.request.model.Consumer;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.ConsumerRequest;
import com.eir.report.entity.Request;

public interface NextGenWebService {

	CirRequest createCIRReport(CirRequest cirRequest);

	void createConsumerReport(List<ConsumerRequest> consumerEntityRequest);
	
	void getCIRReport();

	void getConsumerReport();
}
