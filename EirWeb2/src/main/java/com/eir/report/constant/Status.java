package com.eir.report.constant;


public enum Status {
	
	PENDING("Pending"),
	DOWNLOADED("DOWNLOADED"),
	IN_PROCCESS("In Process"),
	COMPLETED("Completed"),
	ERROR("Error"),
	KYC_APPROVED("KYC Apporved"),
	KYC_REJECTED("KYC Rejected"),
	RECIEVEANDPLACED("Received & Placed"),
	SCOREDANDSERVED("Scored + Served"),
	OPEN("Open"),
	CLOSED("Closed");
	
	private String status;

	Status(String status) {
        this.status = status;
    }

    public String status() {
        return status;
    }
}
