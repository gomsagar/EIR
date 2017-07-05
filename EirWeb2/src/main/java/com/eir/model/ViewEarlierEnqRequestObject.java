package com.eir.model;

import org.joda.time.DateTime;

public class ViewEarlierEnqRequestObject {
	
	String requestId;
	DateCustomFormatter fromDate;
	DateCustomFormatter toDate;
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public DateCustomFormatter getFromDate() {
		return fromDate;
	}
	public void setFromDate(DateCustomFormatter fromDate) {
		this.fromDate = fromDate;
	}
	public DateCustomFormatter getToDate() {
		return toDate;
	}
	public void setToDate(DateCustomFormatter toDate) {
		this.toDate = toDate;
	}
	
	

}
