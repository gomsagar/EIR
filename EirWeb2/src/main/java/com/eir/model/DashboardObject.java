package com.eir.model;

public class DashboardObject {

	private int totEnquiry;
	private int inProcessEnquiry;
	private int totDispute;
	private int pendingDispute;

	public int getTotEnquiry() {
		return totEnquiry;
	}
	public void setTotEnquiry(int totEnquiry) {
		this.totEnquiry = totEnquiry;
	}
	public int getInProcessEnquiry() {
		return inProcessEnquiry;
	}
	public void setInProcessEnquiry(int inProcessEnquiry) {
		this.inProcessEnquiry = inProcessEnquiry;
	}
	public int getTotDispute() {
		return totDispute;
	}
	public void setTotDispute(int totDispute) {
		this.totDispute = totDispute;
	}
	public int getPendingDispute() {
		return pendingDispute;
	}
	public void setPendingDispute(int pendingDispute) {
		this.pendingDispute = pendingDispute;
	}
}
