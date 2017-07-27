package com.eir.model;

import org.joda.time.DateTime;

public class ViewEarlierEnqRequestObject {
	
	String requestId;
	DateCustomFormatter fromDate;
	DateCustomFormatter toDate;
	Integer startIndex;
	Integer endIndex;
	
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
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	
	

}
