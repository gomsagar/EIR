package com.eir.bir.request.model;

import java.util.List;

public class CirRequest {
	
	String ernNumber;
	String status;
	String cirRequetcol;
	List<ConsumerList> consumerList = null;
	
	public String getErnNumber() {
		return ernNumber;
	}
	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCirRequetcol() {
		return cirRequetcol;
	}
	public void setCirRequetcol(String cirRequetcol) {
		this.cirRequetcol = cirRequetcol;
	}
	@Override
	public String toString() {
		return "CirRequest [ernNumber=" + ernNumber + ", status=" + status + ", cirRequetcol=" + cirRequetcol + "]";
	}
	public List<ConsumerList> getConsumerList() {
		return consumerList;
	}
	public void setConsumerList(List<ConsumerList> consumerList) {
		this.consumerList = consumerList;
	}

}
