package com.eir.domain;

import java.util.ArrayList;
import java.util.List;

import com.eir.combo.domains.ComboSummaryDomain;
import com.eir.commercial.domains.CommercialReportDetails;
import com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo;

public class ComboDomain {
	
	private CommercialReportDetails reportDetails;
	private ComboSummaryDomain summaryDetails;
	private List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> responseInfoList;
	public CommercialReportDetails getReportDetails() {
		return reportDetails;
	}
	public void setReportDetails(CommercialReportDetails reportDetails) {
		this.reportDetails = reportDetails;
	}
	public ComboSummaryDomain getSummaryDetails() {
		return summaryDetails;
	}
	public void setSummaryDetails(ComboSummaryDomain summaryDetails) {
		this.summaryDetails = summaryDetails;
	}
	public List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> getResponseInfoList() {
		return responseInfoList;
	}
	public void setResponseInfoList(List<com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo> responseInfoList) {
		this.responseInfoList = responseInfoList;
	}
	
	
}
