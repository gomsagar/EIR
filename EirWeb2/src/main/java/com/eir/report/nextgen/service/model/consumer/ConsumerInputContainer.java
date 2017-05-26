package com.eir.report.nextgen.service.model.consumer;

import java.io.Serializable;

public class ConsumerInputContainer implements Serializable {
	
	private int errorCode;
	private boolean flag;
	private ConsumerUiq consumerUiq;
	private long bureauMemberId;	
	
	public ConsumerInputContainer() {
		errorCode = -1;		
	}

	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public boolean isFlag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}		
	
	public ConsumerUiq getConsumerUiq() {
		return consumerUiq;
	}

	public void setConsumerUiq(ConsumerUiq consumerUiq) {
		this.consumerUiq = consumerUiq;
	}

	public long getBureauMemberId() {
		return bureauMemberId;
	}
	
	public void setBureauMemberId(long bureauMemberId) {
		this.bureauMemberId = bureauMemberId;
	}	
	
}
