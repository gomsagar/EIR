package com.eir.report.constant;

import org.springframework.beans.factory.annotation.Autowired;

import com.eir.report.repository.StatusRepository;

public enum Status {

	
	PENDING,
	DOWNLOADED,
	IN_PROCCESS,
	COMPLETED,
	ERROR,
	KYC_APPROVED,
	KYC_REJECTED,
	RECIEVEANDPLACED,
	SCOREDANDSERVED,
	OPEN,
	CLOSED;
}
